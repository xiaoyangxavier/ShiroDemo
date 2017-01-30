<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html>
 
<html lang="en" class="no-js">
 
<head>
<base href="<%=basePath%>">
<meta charset="utf-8"/>
<title>500 Server Error</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1.0" name="viewport"/>
<meta content="" name="description"/>
<meta content="" name="author"/>
<meta name="MobileOptimized" content="320">
 
</head>
 
<body  >
<div class="row">
	<div class="col-md-12 page-500">
		<div class=" number">
			 500
		</div>
		<div class=" details">
			<h3>Oops! Something went wrong.</h3>
			<p>
				 We are fixing it!<br/>
				Please come back in a while.<br/><br/>
			</p>
		</div>
	</div>
</div>
 
</body>
 
</html>