<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <body> 
    普通用户 
		<form action="${pageContext.request.contextPath}/user/login" method="POST">
		<table border="2" align="center">
			<tr>
				<th>姓名</th>
				<td><input type="text" name="username"  "/></td>
			</tr>
		 
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="普通用户注册" style="width:111px"/>
				</td>
			</tr>
		</table>	
	</form>	
 
	
  </body>
</html>
