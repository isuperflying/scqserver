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

<title>成绩详情</title>
</head>
<body style="margin: 0px;padding: 0px;">
	<form id="startExamForm" action="saveExamUser.action" method="post">
	    <div class="exam_theme">${trainExam.examTheme }</div>
	    <table class="confirm_table">
	    	<tr>
				<td class="td_left" align="right"><font>考生:</font></td>
				<td align="left">${trainExam.user.nickName }</td>
			</tr>
	    	<tr>
				<td class="td_left" align="right"><font>考试时间:</font></td>
				<td align="left">${examUser.examBeginDate }至${examUser.examEndDate }</td>
			</tr>
	    	<tr>
				<td class="td_left" align="right"><font>考试状态:</font></td>
				<td align="left">
				<font style="color: red;">
					<c:if test="${examUser.examState==0 }">
					未开始
					</c:if>
					<c:if test="${examUser.examState==1 }">
					进行中
					</c:if>
					<c:if test="${examUser.examState==2 }">
					已结束
					</c:if>
				</font></td>
			</tr>
			<tr>
				<td class="td_left" align="right"><font>考试得分:</font></td>
				<td align="left">${examUser.examScore }&nbsp;分</td>
			</tr>
			<tr>
				<td class="td_left" align="right"><font>考试结果:</font></td>
				<td align="left">
				<c:if test="${examUser.examResult==0 }">
					通过
					</c:if>
					<c:if test="${examUser.examResult==1 }">
					未通过
					</c:if>
					<c:if test="${examUser.examResult==2 }">
					其他
					</c:if>
				</td>
			</tr>
		</table>
		<div style="width: 90%;margin-left: auto;margin-right: auto;">
			<input type="button" id="score_back" class="exam_confirm_btn" value="返回" />
		</div>
	</form>
</body>
</html>