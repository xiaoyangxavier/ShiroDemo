<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 
<script type="text/javascript">
function openpage(){
window.location = "${pageContext.request.contextPath}/login";
}
</script>

 


  <body> 
  
  <button onclick="openpage()">登录</button>
  
   
  </body>
</html>
