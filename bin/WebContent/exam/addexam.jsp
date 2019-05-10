<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/ui-dialog.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/base_data.css">
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-1.8.3.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/dialog.js"></script>
<script src="<%=request.getContextPath()%>/exam/js/jquery_icheck.js"></script>
<link href="<%=request.getContextPath()%>/exam/js/blue.css"
	rel="stylesheet">
<title>试卷内容</title>
<script type="text/javascript">
$(document).ready(function() {
	$('input').iCheck({//单选和多选样式
		checkboxClass : 'icheckbox_minimal-blue',
		radioClass : 'iradio_minimal-blue',
		increaseArea : '20%' // optional
	});
	
	time('begintime');//考试开始时间
	
	var status = $('#status').val();//0为模拟考试1为真实考试
	if (status == 1){//考试倒计时
		var times = 120*60;//剩余时间，单位秒
		var timeDiv = document.getElementById("timeDiv");
		var timeObj = null;
		
		function timer(){
			if (times <= 0){//考试时间结束，强制提交试卷
				doSubmit();
				window.clearInterval(timeObj);
				return;
			}
			var t = '时间:' + Math.floor(times/60) + '分' + times%60 + '秒';
			timeDiv.innerHTML = t;
			times--;
		}
		timeObj = window.setInterval(timer,1000);
	}
	
});

	//考试开始时间和结束时间
	function time(id){
		var today = new Date();
		var y = today.getFullYear();
		var M = today.getMonth() + 1;
		var d = today.getDate();
		var h = today.getHours();
		var m = today.getMinutes();
		var s = today.getSeconds();
		if (M <= 9)
			M = "0" + (today.getMonth() + 1);
		if (d <= 9)
			d = "0" + today.getDate();
		if (h <= 9)
			h = "0" + today.getHours();
		if (m <= 9)
			m = "0" + today.getMinutes();
		if (s <= 9)
			s = "0" + today.getSeconds();
		var time = y + "-" + M + "-" + d + " " + h + ":" + m + ":" + s;
		$('#'+id).val(time);
	}


	function doSubmit() {
		time('endtime');//考试结束时间
		
		var begintime = $('#begintime').val();//考试开始时间
		var endtime = $('#endtime').val();//考试结束时间
		
		var status = $('#status').val();//0为模拟考试1为真实考试
		
		var tpid = $('#tpid').val();//培训实施 主表id
		
		if (status == 1){
			var map = "";//将题号和答案放入map中便于后台获取并存入库中
		}
		
		var id = $('#id').val();
		var a = $('#answer').val();
		var ids = id.split(",");//获取题目id的集合
		var as = a.split(";");//获取题目正确答案的集合
		var count = 0;//记录未做题目的数量
		var wrong = "";//记录未做和做错题目的序号
		var sum = 0;//记录总分

		for (var i = 0; i < ids.length; i++) {
			var flag = true;//记录该题目是否做过
			var answers = document.getElementsByName(ids[i]);//根据题目id找到每个题目的所有选项
			var eachAnswer = "";//将多选题每题的答案加起来和正确答案作比较
			for (var j = 0; j < answers.length; j++) {
				if (i < 25 || i >= 35) {//单选题和是非题一题2分
					if (answers[j].checked == true) {//找到该道题的被选中的选项
						flag = false;
						if (status == 1)
							map += ((ids[i] + ":" + answers[j].value) + ",");
						if (answers[j].value == as[i]){
							sum += 2;
							break;
						}
					}
					
					if( j == answers.length - 1)
						wrong += ((i + 1) +" ");
				} else if (i >= 25 && i < 35) {//多选题一题3分
					if (answers[j].checked == true) {//找到该道题的被选中的选项
						flag = false;
						eachAnswer += (answers[j].value + " ");
					}
				
					if( j == answers.length - 1){
						
						if ($.trim(eachAnswer) == $.trim(as[i])){
							sum += 3;
						}else
							wrong += ((i + 1) +" ");
						
						if (status == 1)
							map += ((ids[i] + ":" + ($.trim(eachAnswer) == ''?'-1':$.trim(eachAnswer))) + ",");
					}
				}
			}
			if (status == 1){
				var r = map.indexOf(ids[i]);
				if (r < 0)//如果该题未选择答案则放入-1
					map += ((ids[i] + ":-1") + ",");
			}
			if (flag) {//如果这道题没做则记录下来
				count++;
			}
		}
		if (status == 1){//将考试信息存入库中
			$.ajax({
				url:'<%=request.getContextPath()%>/addExam.action?map='+map+'&begintime='+begintime+'&endtime='+endtime+'&sum='+sum+'&tru.tp.id='+tpid,
						cache : false,
						dataType : 'html',
						success : function(html) {
							if (html == "success")
								alert("您的考试信息已存入库中!");
							else if (html == "exist")
								alert("请勿重复考试!");
							else
								alert("您的考试信息存入失败!");
						}
					});
		}
		if(status == 0){
			if (count > 0) {
				if (window.confirm("您还有[" + count + "]道题未完成,确定要提交吗?")) {
					result = dialog({
						fixed : true,
						title : '模拟考试结果',
						content : '得分：'+sum+'<br />未得分的题号：'+$.trim(wrong),
						width : 500,
						height : 200
					});
					result.showModal();
				} else
					return;
			} else {
				if (window.confirm("确定要提交吗?")) {
					result = dialog({
						fixed : true,
						title : '模拟考试结果',
						content : '得分：'+sum+'<br />未得分的题号：'+$.trim(wrong),
						width : 500,
						height : 200
					});
					result.showModal();
				} else
					return;
			}
		}else{
			result = dialog({
				fixed : true,
				title : '考试结果',
				content : '得分：'+sum+'<br />未得分的题号：'+$.trim(wrong),
				width : 500,
				height : 200,
				onclose:function(){
					window.close();
				}
			});
			result.showModal();
			
		}
	}
	
</script>
</head>
<body>
	<input type="hidden" id="status" value="<s:property value="status" />" />
	<input type="hidden" id="id" value="<s:property value="id" />">
	<input type="hidden" id="answer" value="<s:property value="answer" />">

	<input type="hidden" id="tpid" value="<s:property value="tru.tp.id" />">

	<input type="hidden" id="begintime">
	<input type="hidden" id="endtime">

	<h1 align="center">从业人员培训内容笔试试卷</h1>
	<div align="center" style="color: red; font-size: 20px;" id="timeDiv"></div>
	<br />
	<form action="addExam.action" id="form1" method="post">
		<h3 style="margin-left: 150px;">一、单选题(下列各题所给选项中只有一个符合题意的正确答案，答错、不答或多答均不得分，本部分共25题，每题2分，共50分)</h3>
		<s:iterator value="subjectList" var="list" status="st" begin="0"
			end="24">
			<div style="margin-left: 200px;">
				<div>
					<s:property value="#st.index+1" />
					、
					<s:property value="#list.subjectStem" />
				</div>
				<br />
				<div>
					<s:set value="#list.subjectContent.split('#!')" var="temp"></s:set>
					<s:iterator value="temp" var="t" status="st">
						<div
							style="margin-bottom: 5px; margin-top: 5px; margin-left: 10px;">
							<input type="radio"
								value="<s:property value="#t.substring(0,1)" />"
								name="<s:property value="#list.id" />" /> &nbsp;
							<s:property value="t" />
						</div>
					</s:iterator>
				</div>
			</div>
			<br />
		</s:iterator>

		<h3 style="margin-left: 150px;">二、多选题(下列各题所给选项中有一个或多个符合题意的正确答案，答错或不答均不得分，本部分共10题，每题3分，共30分)</h3>
		<s:iterator value="subjectList" var="list" status="st" begin="25"
			end="34">
			<div style="margin-left: 200px;">
				<div>
					<s:property value="#st.index+26" />
					、
					<s:property value="#list.subjectStem" />
				</div>
				<br />
				<div>
					<s:set value="#list.subjectContent.split('#!')" var="temp"></s:set>
					<s:iterator value="temp" var="t" status="st">
						<div
							style="margin-bottom: 5px; margin-top: 5px; margin-left: 10px;">
							<input type="checkbox"
								value="<s:property value="#t.substring(0,1)" />"
								name="<s:property value="#list.id" />" /> &nbsp;
							<s:property value="t" />
						</div>
					</s:iterator>
				</div>
			</div>
			<br />
		</s:iterator>

		<h3 style="margin-left: 150px;">三、是非题(下列各题所给选项中有一个符合题意的正确答案，答错或不答均不得分，本部分共10题，每题2分，共20分)</h3>
		<s:iterator value="subjectList" var="list" status="st" begin="35">
			<div style="margin-left: 200px;">
				<div>
					<s:property value="#st.index+36" />
					、
					<s:property value="#list.subjectStem" />
				</div>
				<br />
				<div style="margin-bottom: 5px; margin-top: 5px; margin-left: 10px;">
					<input type="radio" value="0"
						name="<s:property value="#list.id" />" />&nbsp;是 &nbsp;&nbsp;<input
						type="radio" value="1" name="<s:property value="#list.id" />" />&nbsp;非
				</div>
			</div>
			<br />
		</s:iterator>
		<div align="center">
			<input class="new_base_data_btn" type="button" value="提交"
				onclick="doSubmit();">
			<c:if test="${status==0 }">
				<input class="new_base_data_btn" type="button" value="重做"
					onclick="window.confirm('重做将会重新选题，确定重做吗?')?window.location.reload():''">
			</c:if>
		</div>
	</form>
</body>
</html>