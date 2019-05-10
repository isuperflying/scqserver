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
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="icon" type="image/x-icon" href="/education/favicon.ico" />
<link rel="shortcut icon" type="image/x-icon" href="/education/favicon.ico" />
<link rel="bookmark" type="image/x-icon" href="/education/favicon.ico" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/ui-dialog.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/pagination.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/base.css">

<script type="text/javascript" src="<%=basePath%>js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.form.js"></script>
<script type="text/javascript" src="<%=basePath%>js/dialog.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jqPaginator.js"></script>
<script type="text/javascript" src="<%=basePath%>trainCourseware/js/train_course.js"></script>

<title>修改课程</title>
</head>
<body style="margin: 0px;padding: 0px;">
    <div class="nav">
       <label>&gt;&gt;修改课程</label>
    </div>
    <div class="add_content_div" align="center">
        <form id="editTrainCoursewareForm" action="updateTrainCourseware.action" method="post">
            <input type="hidden" name="trainCourseware.id" value="${ trainCourseware.id }" >
            <input type="hidden" name="trainCourseware.user.id" value="${ trainCourseware.user.id }" >
            <input type="hidden" id="tc_type" value="${ trainCourseware.coursewareType }" >
            <table class="add_table">
                <tr>
                    <td>课程名称：</td>
                    <td><input type="text" id="tc_edit_name" name="trainCourseware.coursewareName" 
                            value="${ trainCourseware.coursewareName }" class="input"  maxlength="30">
                    </td>
                </tr>
                <tr>
                    <td>课程类型：</td>
                    <td>
                        <select name="trainCourseware.coursewareType" id="tc_edit_type" style="width: 150px;height: 25px;">
                            <option value="0" selected="selected">视频</option>
                            <option value="1">文档</option>
                        </select>
                    </td>
                </tr>
                <tr><td>选择课件：</td><td><input type="file" id="tc_edit_url" name="trainCourseware.coursewareUrl" class="input"></td></tr>
            </table>
        </form>
    </div>
    <div class="bottom_div" align="center">
         <input type="button" id="update_train_courseware" class="save_btn" value="保存"/>&nbsp;&nbsp;&nbsp;&nbsp;
         <input type="button" id="toBack" class="save_btn" onclick="javascript:window.history.back();" value="返回"/>
    </div>
</body>
</html>