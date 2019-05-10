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
<script type="text/javascript" src="<%=basePath%>mobile/message/js/message.js"></script>

<title>信息详情</title>
</head>
<body style="margin: 0px;padding: 0px;">
    <div class="exam_theme">${message.theme }</div>
    <div style="width: 100%;margin-top: 10px;">&nbsp;&nbsp;&nbsp;&nbsp;${message.contentShow }</div>
	<div style="width: 90%;margin-left: auto;margin-right: auto;">
		<input type="button" id="message_back" class="exam_confirm_btn" value="返回" />
	</div>
</body>
</html>