<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<!-- 引入css文件，不限顺序 -->
<link rel="stylesheet" href="themes/default/easyui.css" type="text/css"></link>
<link rel="stylesheet" href="themes/icon.css" type="text/css"></link>
<!-- 引入js文件，有顺序限制 -->
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>

<style>
#div_left {
width: 250px;
background-color: powderblue;
font-size: inherit;
}
#div_welcome {
margin: 15px 0 15px 0;
text-align: center;
}
#div_leftmenu div {
font-size: 15px;
}
#div_leftmenu div ul {
margin: 15px 15px 15px 15px;
padding: 0;
overflow: hidden;
line-height: 40px;
max-height: 200px;
}
#div_leftmenu div ul li {
list-style-type: none;
background-color: #DFE2E3;
text-align: center;
margin-bottom: 15px;
}
#div_leftmenu div ul li:hover{
list-style-type: none;
background-color: powderblue;
text-align: center;
margin-bottom: 15px;
cursor:pointer;
}
#div_leftmenu div ul li:last-of-type {
margin-bottom: 0;
}
</style>
</head>
<body class="easyui-layout" style="font-size: 15px;" data-options="fit:true">
 
<!--左侧-->
<div id="div_left" data-options="region:'west',title:' '">
<div id="div_welcome">后台系统,欢迎您</div>
</div>
<!--右侧-->
<div data-options="region:'center',title:' '" style="padding: 5px;">
</div>
 
<script type="text/javascript">
 
$(document).ready(function () {
var div_leftmenu_html = '<div id="div_leftmenu" class="easyui-accordion">';//
 
div_leftmenu_html += '<div title="收入管理">';
div_leftmenu_html += ' <ul>';
div_leftmenu_html += ' <li>新增收入</li>';
div_leftmenu_html += ' <li>收入列表</li>';
div_leftmenu_html += ' <li>收入统计</li>';
div_leftmenu_html += ' </ul>';
div_leftmenu_html += '</div>';
div_leftmenu_html += '<div title="支出管理">';
div_leftmenu_html += ' <ul>';
div_leftmenu_html += ' <li>新增支出</li>';
div_leftmenu_html += ' <li>支出列表</li>';
div_leftmenu_html += ' <li>支出统计</li>';
div_leftmenu_html += ' </ul>';
div_leftmenu_html += '</div>';
div_leftmenu_html += '<div title="用户管理">';
div_leftmenu_html += ' <ul>';
div_leftmenu_html += ' <li>新增用户</li>';
div_leftmenu_html += ' <li>用户列表</li>';
div_leftmenu_html += ' </ul>';
div_leftmenu_html += '</div>';
 
div_leftmenu_html += '</div>';
$("#div_left").append(div_leftmenu_html);
//导航菜单绑定初始化
$(".easyui-accordion").accordion();
});
</script>
</body>
</html>