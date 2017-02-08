<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <jsp:include page="../common/common_head.jsp"/>
 
 <script>
 
 $(document).ready(function(){ 

	 $('#pagination').pagination({
		 onSelectPage:function(pageNumber, pageSize){
		 //$(this).pagination('loading');
		 //alert('pageNumber:'+pageNumber+',pageSize:'+pageSize);
		 //getData(pageNumber, pageSize);
		 window.location.href="${pageContext.request.contextPath}/outlay/list?pageNumber="+pageNumber+"&pageSize="+pageSize;
		 //$(this).pagination('loaded');
		 }
		 });
	 }); 
 

 //查询数据
 function getData(pageNumber, pageSize) {
     $.post("${pageContext.request.contextPath}/outlay/listRefresh", {
    	 pageNumber : pageNumber,
    	 pageSize:pageSize
		}, showPlusCallback, "json");
 }
 
//ajax返回数据
 function showPlusCallback(obj) {
	
	alert( JSON.stringify(obj["allData"]));
	
	 $("#datagrid").datagrid('loadData', obj["allData"]);
 }
 </script>
 
 
</head>
 
<body class="easyui-layout" style="font-size: 15px;" data-options="fit:true">
 <jsp:include page="../common/admin_options.jsp"/>
 <!--右侧-->
<div data-options="region:'center',title:' '" style="padding: 5px;">
<h1 style="text-align:center">后台管理</h1>
<div style="margin:20px 0;"></div>
	<center>
	<table id="datagrid" class="easyui-datagrid" title="数据列表" style="width:700px;height:250px;align=center"
			 >
		<thead>
			<tr>
				<th data-options="field:'itemid',width:80,align:'center'">类型</th>
				<th data-options="field:'productid',width:100,align:'center'">金额</th>
				<th data-options="field:'listprice',width:80,align:'center'">姓名</th>
				<th data-options="field:'unitcost',width:150,align:'center'">时间</th>
				<th data-options="field:'attr1',width:140,align:'center'">描述</th>
				<th data-options="field:'status',width:150,align:'center'">操作时间</th>
			</tr>
			</thead>
			 <tbody>  
			<c:forEach var="o" items="${allData}">
			
			
			<tr>
			<td>${o.typeName}</td>
				<td>${o.amount}</td>
				<td>${o.userRealName}</td>
				<td><fmt:formatDate value="${o.outlayDate}" pattern="yyyy-MM-dd" /></td>
				<td>${o.description}</td>
				<td><fmt:formatDate value="${o.operationDate}" pattern="yyyy-MM-dd HH:mm" /></td	>
			</tr>
			</c:forEach>
		</tbody>
	</table>
		<div id="pagination" class="easyui-pagination" style="width:700px" data-options="total:${count},pageNumber:${pageNumber},pageSize:${pageSize}" onSelectPage:"selectPage(pageNumber,pageSize);"></div>
</center>
</div>
</body>
</html>