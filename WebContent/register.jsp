<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" media="screen" href="css/register.css" />

<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/register.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.form.js"></script>
<script type="text/javascript" src="<%=basePath%>js/layer/layer.js"></script>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/layer.css">
<title>用户注册</title>
</head>
<body>
	<div style="text-align:center;clear:both">
		<form id="msform" action="register.action" method="post">
		<fieldset>
			<h2 style="color: #27AE60;">用户注册</h2>
			<input id="username" type="text" name="user.userName" placeholder="用户名" />
			<input id="password" type="password" name="user.passWord" placeholder="密码" />
			<input id="config_password" type="password" placeholder="确认密码" />
			<input id="register_btn" type="button" name="submit" class="submit action-button" value="注册" />
		</fieldset>
		
	</form>
	<script src="js/register.js" type="text/javascript"></script>
</div>
</body>
</html>