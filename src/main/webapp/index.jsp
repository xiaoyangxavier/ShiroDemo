<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<meta charset="UTF-8">
	<title>Basic FileBox - jQuery EasyUI Demo</title>
	<link rel="stylesheet" type="text/css" href="/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="/themes/icon.css">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
</head>
<body>
	<h2>Basic FileBox</h2>
	<p>The filebox component represents a file field of the forms.</p>
	<div style="margin:20px 0;"></div>
	<div class="easyui-panel" title="Upload File" style="width:100%;max-width:400px;padding:30px 60px;">
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