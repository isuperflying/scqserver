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
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/common.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/ui-dialog.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/layer.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/layui.css">

<script type="text/javascript" src="<%=basePath%>js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.form.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jqPaginator.js"></script>
<script type="text/javascript" src="<%=basePath%>user/js/user.js"></script>
<script type="text/javascript" src="<%=basePath%>js/layer/layer.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$("#ui_sex").val($("#user_sex").val());
});
</script>
<title>编辑用户</title>
</head>
<body style="margin: 0px;padding: 0px;width: 100%;">
    <div class="nav">
       <label>&gt;&gt;编辑用户</label>
    </div>
    <div align="center" style="height: 400px;">
        <form id="editUserForm" action="updateUser.action" method="post">
        	<input type="hidden" id="trainInfoId" name="user.id" value="${user.id }">
        	<input type="hidden" name="user.passWord" value="${user.passWord }">
        	<input type="hidden" id="user_sex" value="${user.sex }">
            <table style="width: 100%;margin-top: 10px;">
                <tr>
                    <td align="right">用户名:</td>
                    <td align="left">
                        <input id="ui_name" name="user.userName" type="text" class="input" value="${user.userName }"/>
                    </td>
                    <td align="right">用户昵称:</td>
                    <td align="left">
                        <input id="ui_nick_name" name="user.nickName" type="text" class="input" value="${user.nickName }"/>
                    </td>
                </tr>
                <tr>
                    <td align="right">性别:</td>
                    <td align="left">
                        <select id="ui_sex" name="user.sex" style="width: 100px;height: 25px;">
                            <option value="1">男</option>
                            <option value="2">女</option>
                        </select>
                    </td>
                    <td align="right">年龄:</td>
                    <td align="left">
                        <input id="ui_age" name="user.age" type="text" class="input" value="${user.age }"/>
                    </td>
                </tr>
                <tr>
                    <td align="right">身份证:</td>
                    <td align="left">
                        <input id="ui_id_card" name="user.idCard" type="text" class="input" value="${user.idCard }"/>
                    </td>
                    <td align="right">联系地址:</td>
                    <td align="left">
                        <input id="ui_address" name="user.address" type="text" class="input" value="${user.address }"/>
                    </td>
                </tr>
                <tr>
                    <td align="right">联系电话:</td>
                    <td align="left">
                        <input id="ui_phone_number" name="user.phoneNumber" type="text" class="input" value="${user.phoneNumber }"/>
                    </td>
                     <td align="right">邮箱:</td>
                    <td align="left">
                        <input id="ui_email_number" name="user.emailNumber" type="text" class="input" value="${user.emailNumber }"/>
                    </td>
                </tr>
                <tr>
	                <td align="right">备注:</td>
	                <td align="left" colspan="3">
	                	<textarea id="ui_remark" name="user.remark" rows="4" cols="100" class="input" >${user.remark }</textarea>
	                </td>
                </tr>
            </table>
        </form>
    </div>
    <div class="bottom_div" align="center">
         <input type="button" id="update_user" class="btn green" value="保存"/>&nbsp;&nbsp;&nbsp;&nbsp;
         <input type="button" id="toBack" class="btn green" onclick="javascript:window.history.back();" value="返回"/>
    </div>
</body>
</html>