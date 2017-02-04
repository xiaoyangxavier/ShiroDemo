 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<head>
 
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

a{
text-decoration:none;
color:black;
}

</style>
</head>	

 
<!--左侧-->
<div id="div_left" data-options="region:'west',title:' '">
<div id="div_welcome">后台系统,欢迎您</div>
</div>
	

 
<script type="text/javascript">
 
$(document).ready(function () {
var div_leftmenu_html = '<div id="div_leftmenu" class="easyui-accordion">';//
 
div_leftmenu_html += '<div title="收入管理">';
div_leftmenu_html += ' <ul>';
div_leftmenu_html += ' <li><a href="#">收入列表</a></li>';
div_leftmenu_html += ' <li><a href="#">新增收入</a></li>';
div_leftmenu_html += ' <li><a href="#">收入统计</a>		</li>';
div_leftmenu_html += ' </ul>';
div_leftmenu_html += '</div>';
div_leftmenu_html += '<div title="支出管理">';
div_leftmenu_html += ' <ul>';
div_leftmenu_html += ' <li><a href="#">支出列表</a></li>';
div_leftmenu_html += ' <li><a href="#">新增支出</a></li>';
div_leftmenu_html += ' <li><a href="#">支出统计</a></li>';
div_leftmenu_html += ' </ul>';
div_leftmenu_html += '</div>';
div_leftmenu_html += '<div title="用户管理">';
div_leftmenu_html += ' <ul>';
div_leftmenu_html += ' <li><a href="#">新增用户</a></li>';
div_leftmenu_html += ' <li><a href="#">用户列表</a></li>';
div_leftmenu_html += ' </ul>';
div_leftmenu_html += '</div>';
 
div_leftmenu_html += '</div>';
$("#div_left").append(div_leftmenu_html);
//导航菜单绑定初始化
$(".easyui-accordion").accordion();
});
</script>

