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
	function submitForm() {
		$('#ff').form('submit');
	}
	function clearForm() {
		$('#ff').form('clear');
	}
</script>

</head>
<body class="easyui-layout" style="font-size: 15px;"
	data-options="fit:true">
	<jsp:include page="../common/admin_options.jsp" />
	<!--右侧-->
	<div data-options="region:'center',title:' '" style="padding: 5px;">

		<form id="ff" method="post">
			<table cellpadding="5">
				<tr>
					<td>类型:</td>
					<td><select id=”cc” class=”easyui-combobox” name=”dept”
						style="”width: 200px;">
							<option value=”aa”>aitem1</option>
							<option>bitem2</option>
							<option>bitem3</option>
							<option>ditem4</option>
							<option>eitem5</option>
					</select></td>
					<td><select id=”cc” class=”easyui-combobox” name=”dept”
						style="width: 200">
							<option value=”aa”>aitem1</option>
							<option>bitem2</option>
							<option>bitem3</option>
							<option>ditem4</option>
							<option>eitem5</option>
					</select></td>
				</tr>
				<tr>
					<td>金额:</td>
					<td><input class="easyui-textbox" type="text" name="amount"
						data-options="required:true,validType:'email'"></input></td>
				</tr>
				<tr>
					<td>图片:</td>
					<td><input class="easyui-filebox" name="file1" data-options="prompt:'Choose a file...'" style="width:260px;"></input></td>
				</tr>
				<tr>
					<td>描述:</td>
					<td><input class="easyui-textbox" name="message"
						data-options="multiline:true" style="height: 60px"></input></td>
				</tr>
			</table>
	 
		</form>
		<div style="text-align: center; padding: 5px">
			<a href="javascript:void(0)" class="easyui-linkbutton"
				onclick="submitForm()">Submit</a> <a href="javascript:void(0)"
				class="easyui-linkbutton" onclick="clearForm()">Clear</a>
		</div>
		</div>
</body>
</html>