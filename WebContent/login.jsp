<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/login.css">
<link rel="stylesheet" type="text/css" href="css/yui.css">
<title>后台管理系统</title>

<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery.form.js"></script>
<script type="text/javascript">
	function toSubmit() {
		$("#loginForm").submit();
	}
</script>
</head>

<body>
	<div class="wrapper">
		<form id="loginForm" action="userLogin.action" method="post">
			<div class="title_div">
				<span class="title_name">南京新港中专校</span>
			</div>
			<div class="loginBox">
				<div class="loginBoxCenter">
					<table>
						<tr>
							<td>登录名：</td>
							<td><input type="text" id="userName" name="user.userName" class="loginInput" /></td>
						</tr>
						<tr>
							<td>密码：</td>
							<td><input type="password" id="passWord" name="user.passWord" class="loginInput" /></td>
						</tr>
					</table>
					<!-- <div><input id="remember" type="checkbox" name="remember" /><label for="remember">记住登录状态</label></div> -->
				</div>
				<div class="loginBoxButtons">
					<input type="button" id="sub"  onclick="toSubmit();" class="loginBtn green bigrounded" value="&nbsp;&nbsp;&nbsp;&nbsp;登 录&nbsp;&nbsp;&nbsp;&nbsp;" />
				</div>
				<div class="register"><span><a href="register.jsp" style="text-decoration: none;">立即注册</a></span></div>
			</div>
		</form>
	</div>
</body>
</html>