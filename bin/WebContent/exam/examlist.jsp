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
	href="<%=request.getContextPath()%>/css/base.css">
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

	function fackTest(txt) {
		var id = txt.id;
		$.ajax({
			url:'<%=request.getContextPath()%>/checkExam.action?tru.tp.trainType.id=' + id,
					cache : false,
					dataType : 'html',
					success : function(html) {
						if (html == "success")
							window.open("toExam.action?status=0&tru.tp.trainType.id=" + id);
						else if (html == "fail")
							alert("考试题目还未完善，请耐心等待!");
						else
							alert("未知错误，请联系管理员!");
					}
				});
	}
	function realTest(txt) {
		var id = txt.id;
		if (window
				.confirm("注意：\n1、真实考试将持续两小时,时间到时将强制结束考试。\n2、该类别考试只能考一次,成绩将保存。\n\n是否确定开始?"))
			window.open("toExam.action?status=1&tru.tp.trainType.id=" + id
					+ "&tru.tp.id=" + txt.name);
	}
</script>
<title>在线考试列表</title>
</head>
<body style="margin: 0px; padding: 0px;">
	<input type="hidden" id="current_page" value="${page }">
	<input type="hidden" id="total_count" value="${totalCount }">
	<div class="content_div">
		<table class="emp_table" border="1" bordercolor="gray">
			<tr style="height: 35px; font-size: 15px;">
				<th align="center" width="3%">序号</th>
				<th align="center" width="15%">培训主题</th>
				<th align="center" width="15%">培训类别</th>
				<th align="center" width="5%">合格时间</th>
				<th align="center" width="5%">已培训时间</th>
				<th align="center" width="15%">操作</th>
			</tr>
			<s:iterator value="truList" status="st" var="tp">
				<tr>
					<td align="center"><s:property value="#st.index+1" /></td>
					<td align="center"><s:property value="#tp[1]" /></td>
					<td align="center"><s:property value="#tp[4]" /></td>
					<td align="center"><s:property value="#tp[5]" /></td>
					<td align="center"><s:if test="#tp[3] >= #tp[5]">
							<span style="color: green;"><s:property
									value="#tp[3]==null?0:#tp[3]" /></span>
						</s:if> <s:elseif test="#tp[3] < #tp[5]">
							<span style="color: red;"><s:property
									value="#tp[3]==null?0:#tp[3]" /></span>
						</s:elseif> <s:else>
							<span style="color: red;">0</span>
						</s:else></td>
					<td align="center" width="10%"><input type="button"
						class="new_base_data_btn" name="<s:property value="#tp[0]" />"
						id="<s:property value="#tp[2]" />" value="模拟考试 "
						onclick="fackTest(this)" /> <%-- <s:if test="#tp[3]>=#tp[5]">
							<input type="button" class="new_base_data_btn" name="showone"
								id="<s:property
									value="#tp[0]" />" value="模拟考试 "
								onclick="fackTest(this)" />
						</s:if> <s:else>
							<input type="button" class="new_base_data_btn" name="showone"
								value="模拟考试 " onclick="alert('您的培训时间不足!')" />
						</s:else>  --%> <s:if test="#tp[6]!=null">
							<s:if test="#tp[6]>=60">
								<input type="button" class="new_base_data_btn" value="已经通过"
									onclick="javascript:alert(<s:property value='#tp[6]' />+'分');" />
							</s:if>
							<s:elseif test="#tp[6]<60">
								<input type="button" class="new_base_data_btn" value="还未通过"
									onclick="javascript:alert(<s:property value='#tp[6]' />+'分')" />
							</s:elseif>
						</s:if> <s:else>
							<input type="button" class="new_base_data_btn"
								name="<s:property value="#tp[0]" />"
								id="<s:property value="#tp[2]" />" value="真实考试 "
								onclick="realTest(this)" />
						</s:else> <%-- <s:if test="#tp[3]>=#tp[5]">
							<input type="button" class="new_base_data_btn" name="showone"
								id="<s:property
									value="#tp[0]" />" value="真实考试 " />
						</s:if> <s:else>
							<input type="button" class="new_base_data_btn" name="showone"
								value="真实考试 " onclick="alert('您的培训时间不足!')" />
						</s:else> --%></td>
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