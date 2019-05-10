<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/common.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/ui-dialog.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/pagination.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/list_info.css">

<script type="text/javascript" src="<%=basePath%>js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.form.js"></script>
<%-- <script type="text/javascript" src="<%=basePath%>js/dialog.js"></script> --%>
<script type="text/javascript" src="<%=basePath%>js/jqPaginator.js"></script>
<script type="text/javascript" src="<%=basePath%>examinfo/js/exam_info.js"></script>
<script type="text/javascript" src="<%=basePath%>js/layer/layer.js"></script>
<script type="text/javascript">
//下载
function toDown(id){
    window.location.href = "examFileDownLoad.action?examInfo.id="+id;
}

function timer(intDiff){
    window.setInterval(function(){
    var day=0,
        hour=0,
        minute=0,
        second=0;//时间默认值        
    if(intDiff > 0){
        day = Math.floor(intDiff / (60 * 60 * 24));
        hour = Math.floor(intDiff / (60 * 60)) - (day * 24);
        minute = Math.floor(intDiff / 60) - (day * 24 * 60) - (hour * 60);
        second = Math.floor(intDiff) - (day * 24 * 60 * 60) - (hour * 60 * 60) - (minute * 60);
    }
    if (minute <= 9) minute = '0' + minute;
    if (second <= 9) second = '0' + second;
    $('#day_show').html(day+"天");
    $('#hour_show').html('<s id="h"></s>'+hour+'时');
    $('#minute_show').html('<s></s>'+minute+'分');
    $('#second_show').html('<s></s>'+second+'秒');
    intDiff--;
    total_times = intDiff;
    }, 1000);
}

//结束考试
function toOver(id,useTime){
	$.ajax({
        url : 'saveUserExamState.action',
        dataType : 'text',
        type : 'post',
        data : {
            'examInfo.id' : id,
            'examInfo.examScore' : useTime
        },
        success: function (data) {
            if ($.trim(data) == "success") {
                window.location.reload();
            }
        },
        error: function () {
            //alert("删除失败!");
            layer.alert('操作失败!');
        }
    });
}

var total_times;

function toStart(id,times){
	
	if($("#exam_start").val() == "开始"){
		total_times = parseInt(times) * 60;//倒计时总秒数量
		$("#exam_start").val("结束");
		$(".time-item").show();
		//alert(times);
		timer(total_times);
	}else{
		var useTime = Math.ceil((parseInt(times) * 60 - total_times ) / 60);
		toOver(id,useTime);
		$("#exam_start").val("已考试");
		$(".time-item").hide();
		$("#exam_start").attr({"disabled":"disabled"});
	}
	
}

</script>

<style type="text/css">
h1 {
    font-family:"微软雅黑";
    font-size:40px;
    margin:20px 0;
    border-bottom:solid 1px #ccc;
    padding-bottom:20px;
    letter-spacing:2px;
}
.time-item strong {
    background:#ff5555;
    color:#fff;
    line-height:35px;
    font-size:16px;
    font-family:Arial;
    padding:0 10px;
    margin-right:10px;
    border-radius:5px;
    box-shadow:1px 1px 3px rgba(0,0,0,0.2);
}
#day_show {
    float:left;
    line-height:49px;
    color:#c71c60;
    font-size:32px;
    margin:0 10px;
    font-family:Arial,Helvetica,sans-serif;
}
.item-title .unit {
    background:none;
    line-height:49px;
    font-size:24px;
    padding:0 10px;
    float:left;
}
</style>

<title>待考试卷</title>
</head>
<body >
<div>
    <form id="examInfoForm" action="" method="post">
        <input type="hidden" id="current_page" value="${page }">
        <input type="hidden" id="total_count" value="${totalCount }">
        <div class="nav">
            <label>&gt;&gt;待考试卷</label>
        </div>
        <c:if test="${user.userType == 1 }">
	       <div class="top_div">
	           <input type="button" id="toAdd_exam_info" onclick="toInput();" class="btn green" value="导入"/>
	       </div>
        </c:if>
        <div class="content_div">
            <table class="allTable" border="1" bordercolor="gray">
                <thead>
                    <tr style="height: 35px;font-size: 13px;">
                        <th width="8%">序号</th>
                        <th width="12%">试卷编号</th>
                        <th width="12%">试卷名称</th>
                        <th width="15%">考试开始</th>
                        <th width="15%">考试结束</th>
                        <th width="15%">考试时长(分)</th>
                        <th width="20%">操作</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${examInfoList}" var="examInfo" varStatus="status">
                        <tr style="height: 35px;font-size: 13px;">
                            <td align="center">
                                ${ status.index + 1}
                            </td>
                            <td align="center">
                                <c:out value="${examInfo.examNumber}" />
                            </td>
                            <td align="center">
                                <c:out value="${examInfo.examName}" />
                            </td>
                            <td align="center">
                                <c:out value="${examInfo.examStartDate}" />
                            </td>
                            <td align="center">
                                <c:out value="${examInfo.examEndDate}" />
                            </td>
                            <td align="center">
                                <c:out value="${examInfo.examTotalTime}" />
                                ${user.userType }
                            </td>
                            <td align="center">
                            	<c:if test="${user.userType == 1 }">
                            		<input type="button" id="exam_info_teacher" class="btn_opera green_opera" onclick="toExamRecordList('${examInfo.id}')" value="成绩管理"/>
                            	</c:if>
                            	<input type="button" id="exam_info_teacher" class="btn_opera green_opera" onclick="toDown('${examInfo.id}')" value="下载"/>
                            	<c:choose>
								   <c:when test="${ examInfo.userExamState == 0 || examInfo.userExamState == 3 }">  
								     	<input type="button" id="exam_start" class="btn_opera green_opera" onclick="toStart('${examInfo.id}','${examInfo.examTotalTime}');" value="开始"/>
								   </c:when>
								   <c:otherwise> 
								   		<input type="button" id="exam_start" class="btn_opera gray_over" disabled="disabled"  value="已考试"/>
								   </c:otherwise>
								</c:choose>
                            	
                            	<div class="time-item" style="display: none;">
                            		<strong id="hour_show">0时</strong>
								    <strong id="minute_show">0分</strong>
								    <strong id="second_show">0秒</strong>
								</div>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="page_div">
            <div class="page_left_div"><ul class="pagination" id="pagination"></ul></div>
            <div class="page_right_div">共&nbsp;${totalPages }&nbsp;页/&nbsp;${totalCount }&nbsp;记录</div>
        </div>
    </form>
</div>

</body>
</html>