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
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/pagination.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/list_info.css">

<script type="text/javascript" src="<%=basePath%>js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.form.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jqPaginator.js"></script>
<script type="text/javascript" src="<%=basePath%>teacherinfo/js/teacher_info.js"></script>
<script type="text/javascript" src="<%=basePath%>js/layer/layer.js"></script>

<title>新增教师</title>
</head>
<body style="margin: 0px;padding: 0px;width: 100%;">
    <div class="nav">
       <label>&gt;&gt;新增教师</label>
    </div>
    <div align="center" style="height: 400px;">
        <form id="addTeacherInfoForm" action="saveTeacherInfo.action" method="post">
        	<input type="hidden" id="trainInfoId" name="teacherInfo.trainId.id" value="${trainInfoId }">
            <table style="width: 100%;margin-top: 10px;">
                <tr>
                    <td align="right">教师名称:</td>
                    <td align="left">
                        <input id="ti_name" name="teacherInfo.teacherName" type="text" class="input"/>
                    </td>
                    <td align="right">教师编号:</td>
                    <td align="left">
                        <input id="ti_number" name="teacherInfo.teacherNumber" type="text" class="input"/>
                    </td>
                </tr>
                <tr>
                	<td align="right">性别:</td>
                    <td align="left">
                        <select id="ti_sex" name="teacherInfo.sex" style="width: 100px;height: 25px;">
                            <option value="1" selected="selected">男</option>
                            <option value="2">女</option>
                        </select>
                    </td>
                    <td align="right">年龄:</td>
                    <td align="left">
                        <input id="ti_age" name="teacherInfo.age" type="text" class="input"/>
                    </td>
                </tr>
                <tr>
                	<td align="right">联系方式:</td>
                    <td align="left">
                        <input id="ti_phone_number" name="teacherInfo.phoneNumber" type="text" class="input"/>
                    </td>
                    <td align="right">邮箱:</td>
                    <td align="left">
                        <input id="ti_email_number" name="teacherInfo.emailNumber" type="text" class="input"/>
                    </td>
                </tr>
                <tr>
                	<td align="right">教龄:</td>
                    <td align="left">
                        <input id="ti_teacher_age" name="teacherInfo.teacherAge" type="text" class="input"/>
                    </td>
                    <td align="right">教师特色:</td>
                    <td align="left">
                        <input id="ti_teacher_special" name="teacherInfo.teacherSpecial" type="text" class="input"/>
                    </td>
                </tr>
                <tr>
	                <td align="right">擅长:</td>
	                <td align="left" colspan="3">
	                	<textarea id="ti_teacher_strong" name="teacherInfo.teacherStrong" rows="4" cols="100" class="input" ></textarea>
	                </td>
                </tr>
                <tr>
	                <td align="right">备注:</td>
	                <td align="left" colspan="3">
	                	<textarea id="ti_remark" name="teacherInfo.remark" rows="4" cols="100" class="input" ></textarea>
	                </td>
                </tr>
            </table>
        </form>
    </div>
    <div class="bottom_div" align="center">
         <input type="button" id="save_teacher_info" class="btn green" value="保存"/>&nbsp;&nbsp;&nbsp;&nbsp;
         <input type="button" id="toBack" class="btn green" onclick="javascript:window.history.back();" value="返回"/>
    </div>
</body>
</html>