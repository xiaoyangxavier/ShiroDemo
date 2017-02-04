<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 
<script type="text/javascript">
function login(){
window.location = "${pageContext.request.contextPath}/login";
}

function logout(){
	window.location = "${pageContext.request.contextPath}/user/logout";
	}
function goAdmin(){
	window.location = "${pageContext.request.contextPath}/admin";
	}


</script>
 

 
  <body> 
  
  <c:choose>
<c:when test="${user.roleId==1}">
管理员：${user.realname} 	&nbsp&nbsp&nbsp 
<button onclick="goAdmin()">后台</button>
<button onclick="logout()">退出</button>
</c:when>
<c:when test="${user.roleId==2}">
用户：${user.realname} &nbsp&nbsp&nbsp <button onclick="logout()">退出</button>
</c:when>
<c:otherwise> <button onclick="login()">登录</button> </c:otherwise>
</c:choose>
  	
  <br/>
  
  <H1>家庭综合管理系统<H1/>
  
  
  
  
  
  
  
  
  
 
<shiro:hasPermission name="user:create">
	<button onclick="#">新增用户</button><shiro:principal/>
</shiro:hasPermission>

 
  
   
  </body>
</html>
