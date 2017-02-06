<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <jsp:include page="../common/common_head.jsp"/>
 
 
 
</head>
 
<body class="easyui-layout" style="font-size: 15px;" data-options="fit:true">
 <jsp:include page="../common/admin_options.jsp"/>
 <!--右侧-->
<div data-options="region:'center',title:' '" style="padding: 5px;">
<h1 style="text-align:center">后台管理</h1>
<div style="margin:20px 0;"></div>
	<center>
	<table class="easyui-datagrid" title="数据列表" style="width:700px;height:250px;align=center"
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
			<c:forEach var="o" items="${outlayList}">
			
			
			<tr>
			<td>${o.typeName}</td>
				<td>${o.amount}</td>
				<td>${o.userRealName}</td>
				<td><fmt:formatDate value="${o.outlayDate}" pattern="yyyy-MM-dd HH:mm" /></td>
				<td>${o.description}</td>
				<td><fmt:formatDate value="${o.operationDate}" pattern="yyyy-MM-dd HH:mm" /></td	>
			</tr>
			</c:forEach>
		</tbody>
	</table>
		<div class="easyui-pagination" style="width:700px" data-options="total:114" ></div>
</center>
</div>
</body>
</html>