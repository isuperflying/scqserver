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
<script type="text/javascript" src="<%=basePath%>traininfo/js/train_info.js"></script>
<script type="text/javascript" src="<%=basePath%>js/layer/layer.js"></script>

<title>待考试卷</title>
</head>
<body >
<div>
    <form id="trainInfoForm" action="" method="post">
        <input type="hidden" id="current_page" value="${page }">
        <input type="hidden" id="total_count" value="${totalCount }">
        <div class="nav">
            <label>&gt;&gt;待考试卷</label>
        </div>
        <div class="top_div">
            <!-- <input type="button" id="toAdd_train_info" onclick="toAdd();" class="btn green" value="新增"/> -->
            <input type="button" id="toAdd_train_info" onclick="toInput();" class="btn green" value="导入"/>
        </div>
        <div class="content_div">
            <table class="allTable" border="1" bordercolor="gray">
                <thead>
                    <tr style="height: 35px;font-size: 13px;">
                        <th width="8%">序号</th>
                        <th width="12%">试卷编号</th>
                        <th width="15%">考试时间</th>
                        <th width="15%">考试总分</th>
                        <th width="15%">考试状态</th>
                        <th width="20%">操作</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${trainInfoList}" var="trainInfo" varStatus="status">
                        <tr style="height: 35px;font-size: 13px;">
                            <td align="center">
                                ${ status.index + 1}
                            </td>
                            <td align="center">
                                <c:out value="${trainInfo.trainName}" />
                            </td>
                            <td align="center">
                                <c:out value="${trainInfo.trainSchoolArea}" />
                            </td>
                            <td align="center">
                                <c:out value="${trainInfo.registerAddress}" />
                            </td>
                            <td align="center">
                                <c:out value="${trainInfo.enrollmentPhoneNumber}" />
                            </td>
                            <td align="center">
                            	<input type="button" id="train_info_teacher" class="btn_opera green_opera" onclick="toTeacherInfoList('${trainInfo.id}')" value="教师信息"/>
                                <input type="button" id="train_info_detail" class="btn_opera green_opera" onclick="toCourseInfoList('${trainInfo.id}')" value="课程信息"/>
                                <input type="button" id="train_info_edit" class="btn_opera green_opera" onclick="toEdit('${trainInfo.id}')" value="编辑"/>
                                <input type="button" id="train_info_delete" class="btn_opera green_opera" onclick="toDelete('${trainInfo.id}')" value="删除"/>
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