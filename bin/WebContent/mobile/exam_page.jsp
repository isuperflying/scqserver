<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/mobile_base.css">

<script type="text/javascript" src="<%=basePath%>js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="<%=basePath%>mobile/js/exam_page.js"></script>
<!--[if lt IE 9]>
　　　　<script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
<![endif]-->
<title>在线考试</title>
<script type="text/javascript">
        window.history.forward(1);
 </script>
<script type="text/javascript">

function toSubmit(){
	if ($("#nick_name").val() == '') {
        alert("请输入姓名!");
        return false;
    }
	if ($("#id_card").val() == '') {
        alert("请输入身份证号码!");
        return false;
    }
    
    $("#subjectSubmitForm").submit();
}

</script>
</head>
<body>
	<form id="subjectSubmitForm" action="toSubmitSubject.action" method="post">
		
		<input type="hidden" id="begintime">
		<input type="hidden" id="endtime">
		
		<input type="hidden" id="exam_user_subject_id" value="${currentExamUserSubject.id  }">
		<input type="hidden" id="current_subject_num" name="currentSubjectNum" value="${currentSubjectNum }">
		<input type="hidden" id="current_subject_id" value="${currentSubject.id }">
		<input type="hidden" id="exam_user_id" value="${examUser.id }">
		<input type="hidden" id="exam_last_time" value="${examLastTime }">
		<input type="hidden" id="subject_result" value="${currentExamUserSubject.subjectResult }">
		<!-- 题目类别与标准答案 -->
		<input type="hidden" id="current_subject_type" value="${currentSubject.subjectType }">
		<input type="hidden" id="current_subject_standardAnswer" value="${currentSubject.standardAnswer }">
		<div class="exam_page">
			<table class="exam_page_table">
				<tr>
					<td><img src="<%=basePath%>images/time_warn.png" style="width:25px;height: 25px;" border="0"></td>
					<td><img src="<%=basePath%>images/subject_number.png" style="width:25px;height: 25px;" border="0"></td>
					<td rowspan="2"><a href="javascript:doSubmit('${trainExam.id}');"><img src="<%=basePath%>images/subject_submit.png" style="width:50px;height:50px;" border="0"></a></td>
				</tr>
				<tr>
					<td><label id="timeDiv" style="color: red;"></label></td>
					<td>${currentSubjectNum }/45</td>
				</tr>
			</table>
		</div>
		<div style="width: 100%;margin-top: 10px;">
			${currentSubjectNum } 、${currentSubject.subjectStem }
		</div>
		<div style="width: 100%;margin-top: 10px;">
			<c:set value="${ fn:split(currentSubject.subjectContent, '#!') }" var="subjectList" />
			
			<c:forEach items="${subjectList}" var="subject" varStatus="status">
				<div style="width: 100%;height: 35px;"><input type="radio" name="subject_item" value="${fn:substring(subject, 0, 1)}" />&nbsp;&nbsp;${subject }</div>
			</c:forEach>
		</div>
		<div style="width: 100%;text-align: center;">
			<input type="button" id="pre_subject" class="subjectBtn" value="上一题" />&nbsp;&nbsp;
			<input type="button" id="next_subject"  class="subjectBtn" value="下一题" />
		</div>
	</form>
</body>
</html>