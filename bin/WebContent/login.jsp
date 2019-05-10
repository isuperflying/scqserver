<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="icon" type="image/x-icon" href="/education/favicon.ico" />
<link rel="shortcut icon" type="image/x-icon" href="/education/favicon.ico" />
<link rel="bookmark" type="image/x-icon" href="/education/favicon.ico" />
<link rel="stylesheet" type="text/css" href="css/login.css">

<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<title>餐饮行业在线培训平台</title>
<script type="text/javascript">
function toSubmit(){
    $("#loginForm").submit();
}
//主要用于避免出现2个登录页面
$(document).ready(function() {
    if(self.location!=top.location) { 
        top.location.href=self.location.href;
    } 
});
</script>
</head>
<body>
    <div class="bigbox">
        <div class="denglu">
            <form id="loginForm" action="userLogin.action" method="post">
                <table>
                    <tr>
                        <td align="right"><label class="dengl">用户名:&nbsp;&nbsp;</label></td>
                        <td><input type="text" id="userName" name="user.userName" class="loginInput" /></td>
                    </tr>
                    <tr>
                        <td align="right"><label class="dengl">密&nbsp;&nbsp;码:&nbsp;&nbsp;</label></td>
                        <td><input type="password" id="passWord" name="user.passWord" class="loginInput" /></td>
                    </tr>
                </table>
                <div align="right" style="margin-top: 20px;margin-right: 10px;">
                    <input type="checkbox" id="auto_login"/><label class="dengl">自动登录</label>
                    <label class="dengl" style="margin-left: 25px;">忘记密码?</label>
                </div>
                <div align="right" style="margin-top: 15px;margin-right: 10px;">
                    <a href="javascript:void(0)" onclick="toSubmit();"><img src="images/login_btn.png"></a>
                    <!-- <input type="submit" style="margin-top: 10px;margin-right: 10px;" id="sub" class="loginBtn" value="登&nbsp;&nbsp;录" /> -->
                </div>
            </form>
        </div>
    </div>
    
</body>
</html>