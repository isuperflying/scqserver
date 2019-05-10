<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<!--[if lt IE 9]>
　　　　<script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
<![endif]-->
<title>注册</title>
<style type="text/css">
body{
	width: auto;
	font: normal 100% Helvetica, Arial, sans-serif;
}
.loginBtn {
	background-color:#20a0fc;
	border: 0px solid #98CCE7;
	border-radius: 3px;
	box-shadow:inset rgba(255,255,255,0.6) 0 1px 1px, rgba(0,0,0,0.1) 0 1px 1px;
	color: #FFF;
	cursor: pointer;
	float: right;
	font: bold 18px;
	font-size:18px;
	padding: 5px 14px;
	width: 100%;
}
.loginBtn:HOVER {
	background-image: -moz-linear-gradient(to top, #B5DEF2, #85CFEE);
}
</style>
</head>
<body>
	<table style="width: auto">
		<tr>
			<td>姓&nbsp;名:</td>
			<td><input type="text" placeholder="请输入姓名"></td>
		</tr>
		<tr>
			<td>身份证:</td>
			<td><input type="text" placeholder="请输入身份证"></td>
		</tr>
		<tr>
			<td>单&nbsp;位:</td>
			<td><input type="text" placeholder="请输入单位"></td>
		</tr>
		<tr>
			<td>手机号码:</td>
			<td><input type="text" placeholder="请输入手机号码"></td>
		</tr>
		<tr>
			<td>密&nbsp;码:</td>
			<td><input type="text" placeholder="请输入手机号码"></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit" class="loginBtn" value="登录" /></td>
		</tr>
	</table>
</body>
</html>