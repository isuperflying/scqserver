<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<!--[if lt IE 9]>
　　　　<script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
<![endif]-->

<!-- HTTP 1.1 -->  
<meta http-equiv="pragma" content="no-cache">
<!-- HTTP 1.0 -->  
<meta http-equiv="cache-control" content="no-cache">  
<!-- Prevent caching at the proxy server -->  
<meta http-equiv="expires" content="0">
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE9" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/mobile_base.css">

<script type="text/javascript" src="<%=basePath%>js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.form.js"></script>
<script type="text/javascript" src="<%=basePath%>mobile/trainExam/js/train_exam.js"></script>

<title>考试确认</title>
</head>
<body style="margin: 0px;padding: 0px;">
	<form id="startExamForm" action="saveExamUser.action" method="post">
		<input type="hidden" name="examUser.trainExam.id" value="${trainExam.id }">
		<input type="hidden" name="examTime" value="${trainExam.examTime }">
	    <div class="exam_theme">${trainExam.examTheme }</div>
	    <table class="confirm_table">
	    	<tr>
				<td class="td_left" align="right"><font>考生:</font></td>
				<td align="left"><font style="color: red;">${trainExam.user.nickName }</font></td>
			</tr>
			<tr>
				<td class="td_left" align="right"><font>身份证:</font></td>
				<td align="left">${trainExam.user.idCard }</td>
			</tr>
			<tr>
				<td class="td_left" align="right"><font>手机号码:</font></td>
				<td align="left">${trainExam.user.telNumber }</td>
			</tr>
			<tr>
				<td class="td_left" align="right"><font>考试期限:</font></td>
				<td align="left">${trainExam.examBeginDate }至${trainExam.examEndDate }</td>
			</tr>
			<tr>
				<td class="td_left" align="right"><font>考试时长:</font></td>
				<td align="left">${trainExam.examTime }&nbsp;分钟</td>
			</tr>
			<tr>
				<td class="td_left" align="right"><font>考试总分:</font></td>
				<td align="left">${trainExam.examTotalScore }&nbsp;分</td>
			</tr>
		</table>
		<div style="width: 90%;margin-left: auto;margin-right: auto;">
			<input type="button" id="start_exam" class="exam_confirm_btn" value="确认考试" />
		</div>
	</form>
</body>
</html>