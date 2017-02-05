<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <jsp:include page="../common/common_head.jsp"/>
 
</head>
 
<body class="easyui-layout" style="font-size: 15px;" data-options="fit:true">
 <jsp:include page="../common/admin_options.jsp"/>
<div data-options="region:'center',title:' '" style="padding: 5px;">

 <!--需要写入的内容-->
<div style="margin-bottom:20px">
			<input class="easyui-textbox" label="Name:" labelPosition="top" style="width:100%">
		</div>
		<div style="margin-bottom:20px">
			<input class="easyui-filebox" label="File1:" labelPosition="top" data-options="prompt:'Choose a file...'" style="width:100%">
		</div>
		<div style="margin-bottom:40px">
			<input class="easyui-filebox" label="File2:" labelPosition="top" data-options="prompt:'Choose another file...'" style="width:100%">
		</div>
		<div>
			<a href="#" class="easyui-linkbutton" style="width:100%">Upload</a>
		</div>
</div>
</body>
</html>