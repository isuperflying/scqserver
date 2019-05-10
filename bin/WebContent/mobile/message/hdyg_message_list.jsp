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
<script type="text/javascript" src="<%=basePath%>mobile/message/js/message.js"></script>

<title>活动预告</title>
</head>
<body style="margin: 0px;padding: 0px;">
    <form id="messageForm" action="" method="post">
        <input type="hidden" id="current_page" value="${page }">
        <input type="hidden" id="total_count" value="${totalCount }">
        <div class="mobile_content_div">
            <table class="mobile_allTable">
                <tbody>
                    <c:forEach items="${messageList}" var="message" varStatus="status">
                        <tr onclick="toMessageDetail('${message.id}');">
                            <td align="center" width="15%">
                                <span style="color: blue;font-size: 18px;">${ status.index + 1}.</span>
                                <%-- <img src="<%=basePath%>images/video_left_img2.png" style="width: 40px;height: 40px;" class="emp_top_logo"> --%>
                            </td>
                            <td align="left" width="70%">
                                <c:out value="${message.theme}" />
                            </td>
                            <td align="center" width="15%">
                                <%-- <input type="button" id="tc_play" class="new_btn" onclick="toPlay('${message.id}')" value="播放"/> --%>
                                <%-- <a href="javascript:toPlay();"><img src="<%=basePath%>images/message_detail.png" class="emp_top_logo" style="width: 35px;height: 35px;"></a> --%>
                                <img src="<%=basePath%>images/4_${ status.index + 1}.png" class="emp_top_logo" style="width: 35px;height: 35px;">
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