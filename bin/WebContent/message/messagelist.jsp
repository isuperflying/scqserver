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
<script type="text/javascript">
	$(function() {
		var current_page = $("#current_page").val();
		var total_count = $("#total_count").val();

		if (Number(total_count) > 0) {
			//初始化分页控件
			$
					.jqPaginator(
							'#pagination',
							{
								totalCounts : Number(total_count),
								pageSize : 10,
								visiblePages : 10,
								first : '<li class="prev"><a href="javascript:;">首页</a></li>',
								prev : '<li class="prev"><a href="javascript:;">上一页</a></li>',
								next : '<li class="next"><a href="javascript:;">下一页</a></li>',
								last : '<li class="prev"><a href="javascript:;">尾页</a></li>',
								page : '<li class="page"><a href="javascript:;">{{page}}</a></li>',
								onPageChange : function(num, type) {
									if (type == "change") {
										window.location.href = "subjectList.action?page="
												+ num;
									}
								}
							});

			$('#pagination').jqPaginator('option', {
				currentPage : Number(current_page)
			});
		}
	})

	function toDelete(txt) {
		var r = txt.id.split("#!");
		var id = r[0];
		var img = r[1];
		if (window.confirm("确定要删除第[" + txt.name + "]条数据吗?")) {
			window.location.href = "deleteMessage.action?tm.id=" + id
					+ "&tm.messageUrlName=" + img;
		}
	}
	function toUpdate(txt) {
		window.location.href = "editMessage.action?tm.id=" + txt.id;
	}
</script>
<title><s:if test="tm.messageType==0">最新动态</s:if> <s:elseif
		test="tm.messageType==1">政策法规</s:elseif> <s:else>新闻</s:else></title>
</head>
<body style="margin: 0px; padding: 0px;">
	<input type="hidden" id="current_page" value="${page }">
	<input type="hidden" id="total_count" value="${totalCount }">
	<div class="nav">
		<label>&gt;&gt; <s:if test="tm.messageType==0">最新动态列表</s:if> <s:elseif
				test="tm.messageType==1">政策法规列表</s:elseif> <s:else>新闻列表</s:else>
		</label>
	</div>
	<div style="margin-bottom: 2px;">
		<input type="button" id="toAdd_base_data" class="new_base_data_btn"
			onclick="javascript:window.location.href='toMessage.action?tm.messageType=<s:property value="tm.messageType" />'"
			value="新增" style="float: left; margin-left: 5px;" />
	</div>
	<div class="content_div">
		<table class="allTable" border="1" bordercolor="gray">
			<tr style="height: 35px; font-size: 15px;">
				<th align="center" width="3%">序号</th>
				<th align="center" width="5%">发布人</th>
				<th align="center" width="5%">信息类型</th>
				<th align="center" width="20%">信息标题</th>
				<th align="center" width="20%">备注</th>
				<th align="center" width="10%">操作</th>
			</tr>
			<s:iterator value="tmList" status="st" var="tm">
				<tr>
					<td align="center"><s:property value="#st.index+1" /></td>
					<td align="center"><s:property value="#tm.user.userName" /></td>
					<td align="center"><s:if test="#tm.messageType==0">
							最新动态
						</s:if> <s:elseif test="#tm.messageType==1">
							政策法规
						</s:elseif> <s:else>
							未知类型
						</s:else></td>
					<td align="center"><s:property value="#tm.messageTitle" /></td>
					<td align="center"><s:property value="#tm.remark" /></td>
					<td align="center"><input type="button"
						class="new_base_data_btn" id="<s:property value='#tm.id' />"
						onclick="toUpdate(this)" value="修改" /> <input type="button"
						class="new_base_data_btn"
						id="<s:property value='#tm.id' />#!<s:property value="#tm.messageUrlName" />"
						name="<s:property value="#st.index+1" />" onclick="toDelete(this)"
						value="删除" /></td>
				</tr>
			</s:iterator>
		</table>
	</div>
	<div class="page_div">
		<div class="page_left_div">
			<ul class="pagination" id="pagination"></ul>
		</div>
		<div class="page_right_div">共&nbsp;${totalPages }&nbsp;页/&nbsp;${totalCount }&nbsp;记录</div>
	</div>
</body>
</html>