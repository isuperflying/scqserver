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
<script type="text/javascript" src="<%=basePath%>My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="<%=basePath%>trainExam/js/train_exam.js"></script>

<title>修改培训考试</title>
</head>
<body style="margin: 0px;padding: 0px;">
    <div class="nav">
       <label>&gt;&gt;修改培训考试</label>
    </div>
    <div class="add_content_div" align="center">
        <form id="editTrainExamForm" action="updateTrainExam.action" method="post">
            <input type="hidden" name="trainExam.id" value="${ trainExam.id }" >
            <input type="hidden" name="trainExam.user.id" value="${ trainExam.user.id }" >
            <table class="add_table">
                 <tr>
                    <td width="20%" align="right">培训考试主题：</td>
                    <td width="70%" align="left">
                    	<input type="text" id="te_theme" name="trainExam.examTheme" value="${ trainExam.examTheme }" class="input" maxlength="200">
                    </td>
                </tr>
                <tr>
                	<td align="right">考试开始时间：</td>
                	<td align="left">
                		<input id="te_begin" name="trainExam.examBeginDate" type="text" value="${ trainExam.examBeginDate }" class="input_date" onClick="WdatePicker()" />
                		<span style="margin-left: 30px;">考试结束时间：</span>
                		<input id="te_end" name="trainExam.examEndDate" type="text" value="${ trainExam.examEndDate }" class="input_date" onClick="WdatePicker()" />
                	</td>
                </tr>
                <tr>
                	<td align="right">考试时长：</td>
                	<td align="left">
                		<input id="te_time" name="trainExam.examTime" type="text" value="${trainExam.examTime }" class="input_date"/><span style="margin-left: 5px;font-size: 14px;">分钟</span>
                	</td>
                </tr>
                <tr>
                	<td align="right">备注：</td>
                	<td align="left">
                		<textarea rows="5" cols="100" id="te_remark" name="trainExam.remark" style="width: 80%;color: #444;border: 1px solid #D2D9dC;border-radius: 2px;">${ trainExam.remark }</textarea>
                	</td>
                </tr>
            </table>
        </form>
    </div>
    <div class="bottom_div" align="center">
         <input type="button" id="update_train_exam" class="save_btn" value="保存"/>&nbsp;&nbsp;&nbsp;&nbsp;
         <input type="button" id="toBack" class="save_btn" onclick="javascript:window.history.back();" value="返回"/>
    </div>
</body>
</html>