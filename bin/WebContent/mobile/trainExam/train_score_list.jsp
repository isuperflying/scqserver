<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<!--[if lt IE 9]>
　　　　<script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
<![endif]-->

<!-- HTTP 1.1 -->  
<meta http-equiv="pragma" content="no-cache">
<!-- HTTP 1.0 -->  
<meta http-equiv="cache-control" content="no-cache">  
<!-- Prevent caching at the proxy server -->  
<meta http-equiv="expires" content="0">
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE9" />

<link rel="icon" type="image/x-icon" href="/education/favicon.ico" />
<link rel="shortcut icon" type="image/x-icon" href="/education/favicon.ico" />
<link rel="bookmark" type="image/x-icon" href="/education/favicon.ico" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/ui-dialog.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/mobile_pagination.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/base.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/mobile_base.css">

<script type="text/javascript" src="<%=basePath%>js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.form.js"></script>
<script type="text/javascript" src="<%=basePath%>js/dialog.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jqPaginator.js"></script>
<script type="text/javascript" src="<%=basePath%>mobile/trainExam/js/train_exam.js"></script>

<title>成绩查询</title>
</head>
<body style="margin: 0px;padding: 0px;">
    <form id="trainExamForm" action="" method="post">
        <input type="hidden" id="current_page" value="${page }">
        <input type="hidden" id="total_count" value="${totalCount }">
        <!-- <div class="nav">
            <label>&gt;&gt;培训考试</label>
        </div> -->
        <div class="mobile_content_div">
            <table class="mobile_allTable">
<!--                 <thead>
                    <tr style="height: 35px;font-size: 15px;">
                        <th width="10%">序号</th>
                        <th width="15%">发布人</th>
                        <th width="40%">培训考试主题</th>
                        <th width="22%">操作</th>
                    </tr>
                </thead> -->
                <tbody>
                    <c:forEach items="${trainExamList}" var="trainExam" varStatus="status">
                        <tr>
                        	<td align="center" width="5%">
                                <%-- <img src="<%=basePath%>images/score_list_bg.png" style="width: 40px;height: 40px;" class="emp_top_logo"> --%>
                                <span style="color: blue;font-size: 18px;">${ status.index + 1}.</span>
                            </td>
                            <td align="center" width="85%">
                                <c:out value="${trainExam.examTheme}" />
                            </td>
                            <td align="center" width="10%">
                                <%-- <a href="javascript:toScoreDetail('${trainExam.id}');"><img src="<%=basePath%>images/score_bg.png" class="emp_top_logo" style="width: 35px;height: 35px;" border="0"></a> --%>
                                <input type="button" onclick="toScoreDetail('${trainExam.id}');" class="detailBtn" value="成绩查询" />
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="page_div">
            <div class="mobile_page_left_div"><ul class="pagination" id="pagination"></ul></div>
            <%-- <div class="mobile_page_right_div">共&nbsp;${totalPages }&nbsp;页/&nbsp;${totalCount }&nbsp;记录</div> --%>
        </div>
    </form>
</body>
</html>