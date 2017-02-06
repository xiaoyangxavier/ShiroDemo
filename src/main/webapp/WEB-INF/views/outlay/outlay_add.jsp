<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="../common/common_head.jsp" />


<script>


function showplus(id){
        	if (id != 0) {
    			//使用JQuery传递请求
    			/*第一个参数：链接
    			 * 2：接收的参数，前面是参数名，后面是参数值
    			 * 3：表示回调函数
    			 * 4：返回值类型
    			 * */
    			$.post("${pageContext.request.contextPath}/outlay/getTypeTwo", {
    				id : id
    			}, showPlusCallback, "json");
    		} else {
    			//清空下拉列表（大于下标0的选项）
    			$("#plus option:gt(0)").remove();
    		} 
        }
 
//可以直接取得返回值
function showPlusCallback(obj) {
	//alert(obj.data[0].name);
	typeData = obj;
	//清空下拉列表
	$("#plus option:gt(0)").remove();//将大于下标0的清除
	if (obj.data.length != 0) {
		for ( var i = 0; i < obj.data.length; i++) {
			var id = obj.data[i].id;
			var title = obj.data[i].title;
			$("#plus").append(
					"<option value='" + id + "'>" + title + "</option>");
		}
		$("#plus option:eq(1)").attr("selected",true) ;//选中等于下标1的选项
		
		//更新隐藏参数（非必须！！！！！！！！！！！！）
		 $("#typeName").attr("value",obj.data[0].title);
	}
}

function changePlus(){  
var title = $("#plus").find("option:selected").text();
	//alert(title);
	$("#typeName").attr("value",title);
	
}

</script>

</head>
<body class="easyui-layout" style="font-size: 15px;"
	data-options="fit:true">
	<jsp:include page="../common/admin_options.jsp" />
	<!--右侧-->
	<div data-options="region:'center',title:' '" style="padding: 5px;">

		<form id="ff" action="${pageContext.request.contextPath}/outlay/addOutlay" method="post" enctype="multipart/form-data">
			<table cellpadding="5">
				<tr>
					<td>类型:</td>
					<td><select id="type" name="type"
						style="width: 200" onchange="showplus(this.value);">
							<option value="0" selected>选择类别</option>
							<c:forEach var="t" items="${allType}">
								<option value="${t.id}">${t.title}</option>
							</c:forEach>
					</select></td>
					<td><select id="plus"  name="typeId"
						style="width: 200" onchange="changePlus();">
							<option value="0">选择类别</option>
							 
					</select></td>
					<input type="hidden" id="typeName" name="typeName" value="未知"/>
				</tr>
				<tr>
					<td>金额:</td>
					<td><input class="easyui-textbox" type="text" name="amount"
						data-options="required:true,validType:'intOrFloat'"></input></td>
				</tr>
				<tr>
					<td>图片:</td>
					<td><input class="easyui-filebox" name="file"
						data-options="prompt:'选择文件'" style="width: 260px;"></input></td>
				</tr>
				<tr>
					<td>描述:</td>
					<td><input class="easyui-textbox" name="description"
						data-options="multiline:true" style="height: 60px"></input></td>
				</tr>
				<tr>
						<td height="20" colspan="2" align="center" valign="middle"
							bgcolor="#FFFFFF">
							<span class="STYLE19"> <label>
									<input type="submit" name="Submit" value="增加">
									&nbsp;&nbsp;
									<input type="reset" name="Submit2" value="重置">
								</label> </span>
						</td>
					</tr>
			</table>

		</form>
		 
	</div>
</body>
</html>