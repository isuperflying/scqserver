<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<title>添加用户</title>
<script type="text/javascript">
	$(document).ready(function() {

		$("#addUser").click(function() {
		    alert(11);
			//提交表单
			$("#addUserForm").submit();
		});

	});
</script>
</head>
<body style="height: 561px;width: 948px;background-color: #92c6ee;">
	<form action="addUser" id="addUserForm" method="post">
		<table>
			<tr>
				<td width="10%" align="right">用户名:</td>
				<td width="40%"><input type="text" id="userName" name="user.userName">
				</td>
				<td width="10%" align="right">密码:</td>
				<td width="40%"><input type="text" id="userPassWord" name="user.userPassWord"></td>
			</tr>
		</table>
		<div align="center" style="margin-top: 20px;">
			<input id="addUser" type="button" value="保存" />
		</div>
	</form>
</body>
</html>