<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/pagination.css">
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-1.8.3.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/dialog.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jqPaginator.js"></script>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/base_data.css">
<script type="text/javascript">
	$(function() {
		var messagetype = $('#messageType').val();
		if (messagetype == 0) {
			$('#imgdiv').css('display', 'table-row');
			$('#filediv').css('display', 'none');
		} else if (messagetype == 1) {
			$('#imgdiv').css('display', 'none');
			$('#filediv').css('display', 'table-row');
		}
	})
</script>
<title>详情</title>
</head>
<body style="margin: 0px; padding: 0px; background-color: white;">
	<div style="height: 400px;">
		<form id="form1" action="" method="post">
			<input type="hidden" id="messageType" name="tm.messageType"
				value="<s:property value="tm.messageType" />" />
			<h3 align="center">
				<s:property value="tm.messageTitle" />
			</h3>
			<div style="margin: 50px;">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<s:property value="tm.messageContent" />
			</div>
			<div style="margin-left: 100px;">
				<font>附件下载:</font> <a
					href="<s:url value='download.action'><s:param name='tm.messageFileName'><s:property value="tm.messageFileName" /></s:param></s:url>"><s:property value="tm.messageFileName" /></a>
			</div>
		</form>
	</div>
	<input style="margin-left: 50%;" align="middle" type="button"
		class="new_base_data_btn" onclick="javascript:window.history.back();"
		value="返回">
</body>
</html>