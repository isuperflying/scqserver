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
<link rel="icon" type="image/x-icon" href="/education/favicon.ico" />
<link rel="shortcut icon" type="image/x-icon" href="/education/favicon.ico" />
<link rel="bookmark" type="image/x-icon" href="/education/favicon.ico" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/ui-dialog.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/pagination.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/base_data.css">

<script type="text/javascript" src="<%=basePath%>js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.form.js"></script>
<script type="text/javascript" src="<%=basePath%>js/dialog.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jqPaginator.js"></script>
<script type="text/javascript" src="<%=basePath%>basedata/js/base_data.js"></script>

<title>字典表</title>
</head>
<body style="margin: 0px;padding: 0px;">
    <form id="baseDataForm" action="" method="post">
        <input type="hidden" id="current_page" value="${page }">
        <input type="hidden" id="total_count" value="${totalCount }">
        <div class="nav">
            <label>&gt;&gt;字典列表</label>
        </div>
        <div class="top_div">
            <input type="button" id="toAdd_base_data" class="new_base_data_btn" value="新增"/>
            <!-- <input type="button" id="base_data_delete" class="new_base_data_btn" onclick="toSyn()" value="同步数据"/>
            <input type="button" id="base_data_delete" class="new_base_data_btn" onclick="toBaseDataDetail()" value="字典取值"/> -->
        </div>
        <div class="content_div">
            <table class="allTable" border="1" bordercolor="gray">
                <thead>
                    <tr style="height: 35px;font-size: 15px;">
                        <th width="10%">编号</th>
                        <th width="40%">字典名称</th>
                        <th width="50%">操作</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${baseDataList}" var="baseData" varStatus="status">
                        <tr>
                            <td align="center">
                                ${ status.index + 1}
                            </td>
                            <td align="center">
                                <c:out value="${baseData.baseDataName}" />
                            </td>
                            <td align="center">
                                <input type="button" id="base_data_detail" class="new_base_data_btn" onclick="toDetail('${baseData.id}')" value="字典详情"/>
                                <input type="button" id="base_data_edit" class="new_base_data_btn" onclick="toEdit('${baseData.id}','${baseData.baseDataName}')" value="修改"/>
                                <input type="button" id="base_data_delete" class="new_base_data_btn" onclick="toDelete('${baseData.id}')" value="删除"/>
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
    <div id="add_base_data_div" class="add_base_div">
        <form id="baseDataAddForm" action="saveBaseData.action" method="post">
            <div class="base_data_name">
                <font size="2" style="margin-right: 5px;">字典名称：</font>
                <input type="text" id="base_data_name" size="30" name="baseData.baseDataName" maxlength="30">
            </div>
            <div class="save_div"><input id="save_base_data" class="save_base_data_btn" type="button" value="保存"/></div>
        </form>
    </div>
    
    <div id="edit_base_data_div" class="add_base_div">
        <form id="baseDataEditForm" action="updateBaseData.action" method="post">
            <div class="base_data_name">
                <font size="2" style="margin-right: 5px;">字典名称：</font>
                <input type="hidden" id="base_data_edit_id" name="baseData.id">
                <input type="text" id="base_data_edit_name" size="30" name="baseData.baseDataName" maxlength="30">
            </div>
            <div class="save_div"><input id="update_base_data" class="save_base_data_btn" type="button" value="保存"/></div>
        </form>
    </div>
    
</body>
</html>