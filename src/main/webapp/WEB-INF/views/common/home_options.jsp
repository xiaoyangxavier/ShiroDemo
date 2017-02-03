 

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>options</title>


<style media="screen" rel="stylesheet" type="text/css">
#navigation {
	margin:0;
	padding: 0;
	clear:both;
	width:950px;
	height:51px;
	background: #d6eaf8 url(../../../images/dropdown-bg.gif) repeat-x left top;
}


ul.nav-main,
ul.nav-main li {
	list-style: none;
	margin: 0;
	padding: 0;
}


ul.nav-main {
	position: relative;
	z-index: 597;
}

ul.nav-main li:hover > ul {
	visibility: visible;
}


ul.nav-main li.hover,
ul.nav-main li:hover {
	position: relative;
	z-index: 599;
	cursor: pointer;
	background: url(../../../images/dropdown-bg-hover.gif) repeat-x left top;
}



ul.nav-main li {
	float:left;
	display:block;
	height: 51px;
	color: #999;
	font: 14px Arial, Helvetica, sans-serif;
	background: url(../../../images/separator.gif) no-repeat right center;
}

ul.nav-main li a {
	display:block;
	padding: 16px 16px 0 16px;
	height: 35px;
	color: #999;
	font: 14px Arial, Helvetica, sans-serif;
	text-decoration:none;
}

ul.nav-main li a:hover {
	color:#D6D6D6;
}



ul.nav-main *.list {
	padding-right: 22px;
	background: url(../../../images/navigation-arrow.gif) no-repeat right top;
}



ul.nav-sub {
	visibility: hidden;
	position: absolute;
	padding:10px;
	top: 48px;
	left: 0;
	z-index: 598;
	background: #353535 url(../../../images/dropdown-list-bg.gif) repeat-x left top;
	border-right: 1px solid #000;
	border-bottom: 1px solid #000;
	border-left: 1px solid #000;
}


ul.nav-sub li {
	list-style:none;
	display:block;
	padding: 0;
	height: 27px;
	float: none;
	width:145px;
	border-bottom: 1px solid #5a5a5a;
	background: none;
}

ul.nav-sub li a {
	list-style:none;
	display:block;
	padding: 6px 5px 6px 5px;
	height: 15px;
	float: none;
	width:145px;
	background: none;
	font: 12px Arial, Helvetica, sans-serif;	
}



</style>
</head>

<body>

<br />
<br />


<ul id="navigation" class="nav-main">
	<li><a href="localhost:8080/myhome/index/">首页</a></li>
    
      <li class="list"><a href="#">收入管理</a>
	<ul class="nav-sub">
    <li><a href="http://www.psdgraphics.com/about/">新增收入</a></li>
 		<li><a href="http://www.psdgraphics.com/commercial-use/">收入列表</a></li>
		<li><a href="http://www.psdgraphics.com/about/terms-of-use/">收入统计</a></li>
	</ul>
	</li>
    
    
    <li class="list"><a href="#">支出管理</a>
	<ul class="nav-sub">
    <li><a href="http://www.psdgraphics.com/category/backgrounds/">新增支出</a></li>
		<li><a href="http://www.psdgraphics.com/category/buttons/">支出列表</a></li>
		<li><a href="http://www.psdgraphics.com/category/graphics/">支出统计</a></li>
	</ul>
	</li>
    
    <li class="list"><a href="#">用户管理</a>
	<ul class="nav-sub">
    <li><a href="http://www.psdgraphics.com/category/backgrounds/">新增用户</a></li>
		<li><a href="http://www.psdgraphics.com/category/buttons/">用户列表</a></li>
	</ul>
	</li>
    
  
    <li><a href="http://www.psdgraphics.com/contact/">系统管理</a></li>
    

</ul>

<br/>
 


</body>
</html>
