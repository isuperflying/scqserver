<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title></title>
	<link rel="stylesheet" type="text/css" href="css/main.css">
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="js/jquery.form.js"></script>
		
<title>左侧导航菜单</title>
<style type="text/css">
body{
	background: #004f00;
}
</style>
</head>
<body>
	<div class="top">
		<img class="img_css" src="images/logo.png" width="60" height="60">
		<span class="top_text">测试项目</span>
		<label  style="float:right; padding-top: 15px; padding-right:34px;color:#ffffff;">
	    	欢迎您：${user.userName }&nbsp;&nbsp;
	    	<a href="login.jsp"  target="_top"  title="退出" style="color:#ffffff;text-decoration: none;">退出 </a><br/><br/>
		</label>
	 </div>
</body>
</html>