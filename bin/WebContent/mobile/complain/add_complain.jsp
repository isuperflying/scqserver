<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ page import="com.ant.scq.mobile.util.WeixinUtil" %>     --%>
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
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="icon" type="image/x-icon" href="/education/favicon.ico" />
<link rel="shortcut icon" type="image/x-icon" href="/education/favicon.ico" />
<link rel="bookmark" type="image/x-icon" href="/education/favicon.ico" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/ui-dialog.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/pagination.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/mobile_base.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/base.css">

<script type="text/javascript" src="<%=basePath%>js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.form.js"></script>
<script type="text/javascript" src="<%=basePath%>js/dialog.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jqPaginator.js"></script>
<script type="text/javascript" src="<%=basePath%>mobile/complain/js/complain.js"></script>

<title>我要投诉</title>
</head>
<body>
    <%-- <input type="hidden" id="appId" value="wx188ae4796c1bb04b">
    <input type="hidden" id="timestamp" value="<%= WeixinUtil.TIME_STAMP%>">
    <input type="hidden" id="nonceStr" value="<%= WeixinUtil.NONCE_STR%>">
    <input type="hidden" id="signature" value="<%= WeixinUtil.SIGNATURE%>"> --%>
    
    <form id="addComplainForm" action="saveComplain.action" method="post">
		<table style="border-collapse:separate;width:100%;">
			<tr>
				<td class="td_left">投诉主题:</td>
				<td><input type="text" id="complain_theme" name="complain.complainTheme" class="input-text" placeholder="请输入投诉主题"></td>
			</tr>
			<tr>
				<td class="td_left">投诉内容:</td>
				<td>
					<textarea rows="5" cols="30" style="width: 100%;" id="complain_content" name="complain.complainContent"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="button" id="save_complain" class="regBtn" value="保&nbsp;存" /></td>
			</tr>
		</table>
	</form>
</body>
<!-- <script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
<script type="text/javascript">

$(document).ready(function() {
	
	var appId = $("#appId").val();
	var timestamp = $("#timestamp").val();
	var nonceStr = $("#nonceStr").val();
	var signature = $("#signature").val();
	
	alert(appId);
	alert(timestamp);
	alert(nonceStr);
	alert(signature);
	
	wx.config({
	    debug : false,
		appId : appId,
		timestamp : timestamp,
		nonceStr : nonceStr,
		signature : signature,
	    jsApiList: [
	      'checkJsApi',
	      'chooseImage',
	      'previewImage',
	      'uploadImage',
	      'downloadImage'
	    ]
	});
});
</script> -->
<%-- <script src="<%=basePath%>complain/js/complain_wx.js"> </script>     --%>
</html>