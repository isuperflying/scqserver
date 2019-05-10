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
<script type="text/javascript" src="<%=basePath%>js/jqPaginator.js"></script>
<script type="text/javascript" src="<%=basePath%>user/js/user.js"></script>
<script type="text/javascript" src="<%=basePath%>js/layer/layer.js"></script>

<title>用户管理</title>
</head>
<body style="margin: 10px;padding: 0px;margin-left: 10px;">
<div>
    <form id="userForm" action="" method="post">
        <input type="hidden" id="current_page" value="${page }">
        <input type="hidden" id="total_count" value="${totalCount }">
        <div class="nav">
            <label>&gt;&gt;用户管理</label>
        </div>
        <!-- <div class="top_div">
            <input type="button" id="toAdd_menu_type" onclick="toAdd();" class="btn green" value="新增"/>
        </div> -->
        <div class="content_div">
            <table class="allTable" border="1" bordercolor="gray">
                <thead>
                    <tr style="height: 35px;font-size: 15px;">
                        <th width="5%">编号</th>
                        <th width="20%">用户昵称</th>
                        <th width="20%">用户名</th>
                        <th width="15%">联系电话</th>
                        <th width="25%">联系地址</th>
                        <th width="15%">操作</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${userList}" var="user" varStatus="status">
                        <tr style="height: 35px;font-size: 15px;">
                            <td align="center">
                                ${ status.index + 1}
                            </td>
                            <td align="center">
                                <c:out value="${user.nickName}" />
                            </td>
                            <td align="center">
                                <c:out value="${user.userName}" />
                            </td>
                            <td align="center">
                                <c:out value="${user.phoneNumber}" />
                            </td>
                            <td align="center">
                                <c:out value="${user.address}" />
                            </td>
                            <td align="center">
                                <input type="button" id="menu_type_edit" class="btn_opera green_opera" onclick="toEdit('${user.id}')" value="编辑"/>
                                <input type="button" id="menu_type_delete" class="btn_opera green_opera" onclick="toDelete('${user.id}')" value="删除"/>
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