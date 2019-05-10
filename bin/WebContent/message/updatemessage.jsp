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

	function toSubmit() {
		var messagetitle = $.trim($('#messageTitle').val());
		var messagecontent = $.trim($('#messageContent').val());
		if (messagetitle == null || messagetitle == ''
				|| messagetitle == undefined) {
			alert("标题不能为空!");
			return;
		}
		if (messagecontent == null || messagecontent == ''
				|| messagecontent == undefined) {
			alert("内容不能为空!");
			return;
		}
		$('#form1').submit();
	}
</script>
<title><s:if test="tm.messageType==0">最新动态</s:if> <s:elseif
		test="tm.messageType==1">政策法规</s:elseif> <s:else>新闻</s:else></title>
</head>
<body style="margin: 0px; padding: 0px;">
	<div class="nav">
		<label>&gt;&gt; <s:if test="tm.messageType==0">最新动态新增</s:if> <s:elseif
				test="tm.messageType==1">政策法规新增</s:elseif> <s:else>新闻新增</s:else>
		</label>
	</div>
	<br />
	<div style="height: 400px;">
		<form id="form1"
			action="modifyMessage.action?deleteFileName=<s:property value="tm.messageUrlName" />"
			method="post" enctype="multipart/form-data">
			<input type="hidden" id="messageType" name="tm.messageType"
				value="<s:property value="tm.messageType" />" />
			<table class="allTable"
				style="border-spacing: 3px; border-collapse: separate;">
				<tr>
					<td align="right" width="25%" style="font-size: 13px;">信息标题：</td>
					<td colspan="3" width="75%"><input id="messageTitle"
						style="width: 500px;" type="text" name="tm.messageTitle"
						value="<s:property value="tm.messageTitle" />" maxlength="100" /></td>
				</tr>
				<tr>
					<td align="right" style="font-size: 13px;">信息内容：</td>
					<td colspan="3"><textarea id="messageContent"
							style="width: 500px; height: 100px;" name="tm.messageContent"
							maxlength="1000"><s:property value="tm.messageContent" /></textarea></td>
				</tr>
				<tr id="imgdiv">
					<td align="right" width="25%" style="font-size: 13px;">信息图片：</td>
					<td colspan="3" width="75%"><input type="file" name="image"
						accept="image/*" /></td>
				</tr>
				<tr id="filediv">
					<td align="right" width="25%" style="font-size: 13px;">信息附件：</td>
					<td colspan="3" width="75%"><input type="file" name="image" /></td>
				</tr>
				<tr id="imgdiv">
					<td align="right" width="25%" style="font-size: 13px;"><s:if
							test="tm.messageType==0">原图片：</s:if> <s:elseif
							test="tm.messageType==1">原附件：</s:elseif></td>
					<td colspan="3" width="75%">
						<%-- <img alt="" src="<%=request.getContextPath() %>/tempfile/<s:property value="tm.messageUrlName" />"> --%>
						<input type="text" style="width: 500px;" readonly="readonly"
						value="<s:property value="tm.messageUrlName" />" />
					</td>
				</tr>
				<tr>
					<td align="right" width="25%" style="font-size: 13px;">备注：</td>
					<td colspan="3" width="75%"><textarea
							style="width: 500px; height: 50px;" name="tm.remark"
							maxlength="250"><s:property value="tm.remark" /></textarea></td>
				</tr>
			</table>
		</form>
	</div>
	<input style="margin-left: 40%;" type="button"
		class="new_base_data_btn" onclick="toSubmit();" value="提交">
	<input align="middle" type="button" class="new_base_data_btn"
		onclick="javascript:window.history.back();" value="返回">
</body>
</html>