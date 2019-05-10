<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/base.css">
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/jquery.form.js"></script>
<title>修改密码</title>
<script type="text/javascript">

$(document).ready(function() {
    $("#updateUser").click(function() {
        if ($("#userPassWord").val() == '') {
            alert("请输入新密码!");
            return false;
        }
        if ($("#re_userPassWord").val() == '') {
            alert("请再次输入密码!");
            return false;
        }
        
        if($("#userPassWord").val()!= $("#re_userPassWord").val()){
            alert("二次输入密码不一致，请重新输入!");
            return false;
        }
        
        $('#editUserForm').ajaxSubmit({
            success: function(data) {
                if ($.trim(data) == "success") {
                    alert("修改成功!");
                    //window.location.href="../index.jsp";
                }else {
                    alert("修改失败!");
                }
            }
        });
    });
});
</script>
</head>
<body style="margin: 0px;padding: 0px;">
    <div class="nav">
            <label>&gt;&gt;修改密码</label>
    </div>
    <form action="updateUser.action" id="editUserForm" method="post" style="height: 300px;">
        <input type="hidden" name="user.id" value="${ UPDATE_USER.id }">
        <table align="center">
            <tr style="height: 40px;">
                <td width="20%" align="right"><font color="blue">用户名：</font></td>
                <td width="30%"><label>${UPDATE_USER.userName }</label></td>
            </tr>
            
            <tr style="height: 40px;">
                <td width="20%" align="right"><font color="blue">供职企业：</font></td>
                <td width="30%"><label>${UPDATE_USER.organName }</label></td>
            </tr>
            
            <tr style="height: 40px;">
                <td width="20%" align="right"><font color="blue">身份证：</font></td>
                <td width="30%"><label>${UPDATE_USER.idCard }</label></td>
            </tr>
            
            <tr style="height: 40px;">
                <td width="20%" align="right"><font color="blue">联系电话：</font></td>
                <td width="30%"><label>${UPDATE_USER.telNumber }</label></td>
            </tr>
            
            <tr style="height: 40px;">
                <td width="20%" align="right"><font color="blue">详细地址：</font></td>
                <td width="30%"><label>${UPDATE_USER.address }</label></td>
            </tr>
            
            
            <tr style="height: 40px;">
                <td width="20%" align="right"><font color="blue">新密码：</font></td>
                <td width="30%"><input type="password" class="input" id="userPassWord" size="50"></td>
            </tr>
            
            <tr style="height: 40px;">
                <td width="10%" align="right"><font color="blue">确认密码：</font></td>
                <td width="40%"><input type="password" class="input" id="re_userPassWord" name="user.passWord" size="50"></td>
            </tr>
        </table>
        <div align="center" style="margin-top: 50px;">
            <input id="updateUser" class="new_btn" type="button" value="保存" />
        </div>
    </form>
</body>
</html>