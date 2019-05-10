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
<script type="text/javascript" src="<%=basePath%>menutype/js/menu_type.js"></script>
<script type="text/javascript" src="<%=basePath%>js/layer/layer.js"></script>

<title>培训菜单</title>
</head>
<body style="margin: 10px;padding: 0px;margin-left: 10px;">
<div>
    <form id="menuTypeForm" action="" method="post">
        <input type="hidden" id="current_page" value="${page }">
        <input type="hidden" id="total_count" value="${totalCount }">
        <div class="nav">
            <label>&gt;&gt;培训菜单</label>
        </div>
        <div class="top_div">
            <input type="button" id="toAdd_menu_type" onclick="toAdd();" class="btn green" value="新增"/>
        </div>
        <div class="content_div">
            <table class="allTable" border="1" bordercolor="gray">
                <thead>
                    <tr style="height: 35px;font-size: 15px;">
                        <th width="5%">编号</th>
                        <th width="25%">菜单名称</th>
                        <th width="25%">菜单编号</th>
                        <th width="25%">菜单等级</th>
                        <th width="15%">操作</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${menuTypeList}" var="menuType" varStatus="status">
                        <tr style="height: 35px;font-size: 15px;">
                            <td align="center">
                                ${ status.index + 1}
                            </td>
                            <td align="center">
                                <c:out value="${menuType.typeName}" />
                            </td>
                            <td align="center">
                                <c:out value="${menuType.menuNumber}" />
                            </td>
                            <td align="center">
                                <c:out value="${menuType.menuLevel}" />
                            </td>
                            <td align="center">
                                <%-- <input type="button" id="menu_type_edit" class="btn green" onclick="toEdit('${menuType.id}')" value="编辑"/> --%>
                                <input type="button" id="menu_type_delete" class="btn_opera green_opera" onclick="toDelete('${menuType.id}')" value="删除"/>
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