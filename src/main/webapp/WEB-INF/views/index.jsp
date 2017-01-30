<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 
<script type="text/javascript">
function openpage(){
window.location = "${pageContext.request.contextPath}/login";
}


</script>
 
  <body> 
  
  <c:choose>
<c:when test="${type==1}">
管理员：${user.username}
</c:when>
<c:when test="${type==1}">
用户：${user.username}
</c:when>
<c:otherwise> <button onclick="openpage()">登录</button> </c:otherwise>
</c:choose>
  
  <br/>
  
  <H1>家庭综合管理系统<H1/>
  
  
  
  
  
  
  
  
  
 
<shiro:hasPermission name="user:create">
	<button onclick="#">新增数据</button><shiro:principal/>
</shiro:hasPermission>

 
  
   
  </body>
</html>
