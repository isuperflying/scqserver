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
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/base_data_detail.css">

<script type="text/javascript" src="<%=basePath%>js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.form.js"></script>
<script type="text/javascript" src="<%=basePath%>js/dialog.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jqPaginator.js"></script>
<script type="text/javascript" src="<%=basePath%>basedata/js/base_data_detail.js"></script>

<title>字典详情</title>
</head>
<body style="margin: 0px;padding: 0px;">
    <form id="baseDataDetailForm" action="" method="post">
        <input type="hidden" id="current_page" value="${page }">
        <input type="hidden" id="total_count" value="${totalCount }">
        <input type="hidden" id="base_data_id" value="${baseDataId }">
        <div class="nav">
            <label>&gt;&gt;字典详情列表</label>
        </div>
        <div class="top_div">
            <input type="button" id="toAdd_base_data_detail" class="new_base_data_btn" value="新增"/>
            <input type="button" id="to_back" class="new_base_data_btn" onclick="toBack();" value="返回"/>
        </div>
        <div class="content_div">
            <table class="allTable" border="1" bordercolor="gray">
                <thead>
                    <tr style="height: 35px;font-size: 15px;">
                        <th width="10%">编号</th>
                        <th width="25%">字典名称</th>
                        <th width="10%">键</th>
                        <th width="25%">值</th>
                        <th width="30%">操作</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${baseDataDetailList}" var="baseDataDetail" varStatus="status">
                        <tr>
                            <td align="center">
                                ${ status.index + 1}
                            </td>
                            <td align="center">
                                <c:out value="${baseDataDetail.baseData.baseDataName}" />
                            </td>
                            <td align="center">
                                <c:out value="${baseDataDetail.baseDataKey}" />
                            </td>
                            <td align="center">
                                <c:out value="${baseDataDetail.baseDataValue}" />
                            </td>
                            <td align="center">
                                <input type="button" id="base_data_edit" class="new_base_data_btn" onclick="toEdit('${baseDataDetail.id}','${baseDataDetail.baseDataKey}','${baseDataDetail.baseDataValue}')" value="修改"/>
                                <input type="button" id="base_data_delete" class="new_base_data_btn" onclick="toDelete('${baseDataDetail.id}')" value="删除"/>
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
    <div id="add_base_data_detail_div" class="add_base_div">
        <form id="baseDataDetailAddForm" action="saveBaseDataDetail.action" method="post">
            <div class="base_data_name">
                <div>
                    <input type="hidden" name="baseDataDetail.baseData.id" value="${baseDataId }">
                    <font size="2" style="margin-right: 5px;">字典名称：</font>
                    <label>${baseData.baseDataName }</label>
                </div>
                <!-- <div style="margin-top: 15px;">
                    <font size="2" style="margin-right: 5px;">键：</font>
                    <input type="text" id="base_data_detail_key" name="baseDataDetail.baseDataKey" size="30">
                </div> -->
                <div style="margin-top: 10px;">
                    <font size="2" style="margin-right: 5px;">字典详情值：</font>
                    <input type="text" id="base_data_detail_value" name="baseDataDetail.baseDataValue" maxlength="30">
                </div>
            </div>
            <div class="save_div"><input id="save_base_data_detail" class="save_base_data_btn" type="button" value="保存"/></div>
        </form>
    </div>
    
    <div id="edit_base_data_detail_div" class="add_base_div">
        <form id="baseDataDetailEditForm" action="updateBaseDataDetail.action" method="post">
            <div class="base_data_name">
                <div>
                    <input type="hidden" name="baseDataDetail.baseData.id" value="${baseDataId }">
                    <input type="hidden" id="base_data_detail_id" name="baseDataDetail.id">
                    <input type="hidden" id="base_data_detail_edit_key" name="baseDataDetail.baseDataKey">
                    <font size="2" style="margin-right: 5px;">字典名称：</font>
                    <label>${baseData.baseDataName }</label>
                </div>
                <!-- <div style="margin-top: 15px;">
                    <font size="2" style="margin-right: 5px;">键：</font>
                    <input type="text" id="base_data_detail_edit_key" name="baseDataDetail.baseDataKey" size="30">
                </div> -->
                <div style="margin-top: 10px;">
                    <font size="2" style="margin-right: 5px;">字典详情值：</font>
                    <input type="text" id="base_data_detail_edit_value" name="baseDataDetail.baseDataValue" maxlength="30">
                </div>
            </div>
            <div class="save_div"><input id="update_base_data_detail" class="save_base_data_btn" type="button" value="保存"/></div>
        </form>
    </div>
    
</body>
</html>