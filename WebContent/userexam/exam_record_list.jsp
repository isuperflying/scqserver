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
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/layer.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/layui.css">


<script type="text/javascript" src="<%=basePath%>js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.form.js"></script>
<%-- <script type="text/javascript" src="<%=basePath%>js/dialog.js"></script> --%>
<script type="text/javascript" src="<%=basePath%>js/jqPaginator.js"></script>
<script type="text/javascript" src="<%=basePath%>userexam/js/user_exam.js"></script>
<script type="text/javascript" src="<%=basePath%>js/layer/layer.js"></script>

<script type="text/javascript">

//查看详情
function toDetail(id){
	alert(id);
}

</script>

<title>考试记录</title>
</head>
<body >
<div>
    <form id="userExamForm" action="" method="post">
        <input type="hidden" id="current_page" value="${page }">
        <input type="hidden" id="total_count" value="${totalCount }">
        <div class="nav">
            <label>&gt;&gt;考试记录</label>
        </div>
        <div class="top_div">
	           <input type="button" id="toAdd_exam_info" onclick="toBack();" class="btn green" value="返回"/>
	    </div>
        <div class="content_div">
            <table class="allTable" border="1" bordercolor="gray">
                <thead>
                    <tr style="height: 35px;font-size: 13px;">
                        <th width="8%">序号</th>
                        <th width="10%">考试姓名</th>
                        <th width="10%">试卷编号</th>
                        <th width="18%">试卷名称</th>
                        <th width="12%">考试状态</th>
                        <th width="12%">考试用时(分钟)</th>
                        <th width="12%">是否打分</th>
                        <th width="12%">考试分数</th>
                        <th width="20%">操作</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${examRecordList}" var="examRecord" varStatus="status">
                        <tr style="height: 35px;font-size: 13px;">
                            <td align="center">
                                ${ status.index + 1}
                            </td>
                            <td align="center">
                                <c:out value="${examRecord.user.userName}" />
                            </td>
                            <td align="center">
                                <c:out value="${examRecord.examInfo.examNumber}" />
                            </td>
                            <td align="center">
                                <c:out value="${examRecord.examInfo.examName}" />
                            </td>
                            <td align="center">
                                <c:if test="${examRecord.examState == 1 }">
                                	已考试
                                </c:if>
                                <c:if test="${examRecord.examState == 2 }">
                                	通过
                                </c:if>
                                <c:if test="${examRecord.examState == 3 }">
                                	<font color="#ff5555">未通过</font>
                                </c:if>
                            </td>
                            <td align="center">
                                <c:out value="${examRecord.examUseTime}" />
                            </td>
                            <td align="center">
                            	<c:if test="${ examRecord.isMarkScore == 0 }">否</c:if>
                            	<c:if test="${ examRecord.isMarkScore == 1 }">是</c:if>
                            </td>
                            <td align="center">
                                <c:out value="${examRecord.examScore}" />
                            </td>
                            <td align="center">
                            	<c:if test="${user.userType == 1 }">
	                            	<c:choose>
									   <c:when test="${ examRecord.isMarkScore == 0 }">  
									     	<input type="button" id="exam_info_teacher" class="btn_opera green_opera" onclick="markScore('${examRecord.examInfo.id }','${examRecord.id}');" value="打分"/>
									   </c:when>
									   <c:otherwise>
									   		<input type="button" class="btn_opera gray_over" disabled="disabled"  value="打分"/>
									   </c:otherwise>
									</c:choose>
                            	</c:if>
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
    
    
    <div id="add_score_div" style="display: none;">
	     <div style="background-color: #79C48C;color: #fff;height: 40px;line-height: 40px;">
		    <span style="margin-left: 10px;">考生打分</span>
		 </div>
	    <div align="center" style="height:auto;margin-bottom: 20px;text-align: center;">
	    	
	        <form id="addScoreForm" action="updateUserExam.action" method="post">
	        	<input type="hidden" id="exam_id">
	            <input type="hidden" id="user_exam_id">
	            <table id="score_table" class="scoreTable" border="1">
	                <thead>
	                    <tr style="height: 35px;font-size: 14px;">
	                        <th width="8%">打分项</th>
	                        <th width="10%">分值</th>
		            	</tr>
		            </thead>
	            	<c:forEach items="${scoreItemList}" var="scoreItem" varStatus="status">
		                <tr>
		                    <td align="center" height="30">${scoreItem.scoreItemName }：</td>
		                    <td align="center">
		                        <input id="score_name" style="height: 26px;" size="60" type="text" class="input"/>
		                    </td>
		                </tr>
	                </c:forEach>
	            </table>
	        </form>
	    </div>
	    <div class="bottom_div" align="center">
	         <input type="button" id="mark_score" onclick="saveMarkScore();" class="btn green" value="确认"/>&nbsp;&nbsp;&nbsp;&nbsp;
	    </div>
     </div>
    
</div>
</body>
</html>