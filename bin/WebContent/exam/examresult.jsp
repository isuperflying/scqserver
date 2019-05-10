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
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/ui-dialog.css">
<title>考试结果</title>
</head>
<body style="margin: 0px; padding: 0px; background-color: white;">
	<div class="content_div">
		<table class="allTable" border="1" bordercolor="gray">
			<tr style="height: 35px; font-size: 15px;">
				<th align="center" width="3%">序号</th>
				<th align="center" width="15%">培训主题</th>
				<th align="center" width="15%">培训类别</th>
				<th align="center" width="10%">状态</th>
				<th align="center" width="5%">得分</th>
			</tr>
			<s:iterator value="truList" var="tp" status="st">
				<tr height="35px;">
					<td align="center"><s:property value="#st.index+1" /></td>
					<td align="center"><s:property value="#tp[1]" /></td>
					<td align="center"><s:property value="#tp[4]" /></td>
					<td align="center"><s:if test="#tp[6]!=null">
							<s:if test="#tp[6]>=60">
								<span style="color: green;">已通过</span>
							</s:if>
							<s:else>
								<span style="color: red;">未通过</span>
							</s:else>
						</s:if> <s:else>
							<span style="color: red;">未考试</span>
						</s:else></td>
					<td align="center"><s:if test="#tp[6]!=null">
							<s:if test="#tp[6]>=60">
								<span style="color: green;"><s:property value="#tp[6]" /></span>
							</s:if>
							<s:else>
								<span style="color: red;"><s:property value="#tp[6]" /></span>
							</s:else>
						</s:if></td>
				</tr>
			</s:iterator>
		</table>
	</div>
</body>
</html>