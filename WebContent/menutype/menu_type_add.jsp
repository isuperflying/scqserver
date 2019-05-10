<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
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

<title>新增培训菜单</title>
</head>
<body style="margin: 0px;padding: 0px;width: 100%;">
    <div class="nav">
       <label>&gt;&gt;新增培训菜单</label>
    </div>
    <div align="center" style="height: 400px;">
        <form id="addMenuTypeForm" action="saveMenuType.action" method="post">
            <table style="width: 100%;margin-top: 10px;">
                <tr>
                    <td align="right">菜单名称:</td>
                    <td align="left">
                        <input id="mt_name" name="menuType.typeName" type="text" class="input"/>
                    </td>
                    <td align="right">菜单编号:</td>
                    <td align="left">
                        <input id="mt_number" name="menuType.menuNumber" type="text" class="input"/>
                    </td>
                </tr>
                <tr>
                	<td align="right">菜单等级:</td>
                    <td align="left">
                        <select id="mt_level" name="menuType.menuLevel" style="width: 100px;height: 25px;">
                            <option value="0">选择等级</option>
                            <option value="1">一级</option>
                            <option value="2" selected="selected">二级</option>
                            <option value="3">三级</option>
                        </select>
                    </td>
                    <td width="15%" align="right"><span id="father_tx">选择所属父级菜单:</span></td>
                    <td width="35%" align="left">
                        <select id="mt_parentNumber" name="menuType.parentNumber" style="width: 150px;height: 25px;">
                        	<option value="0">选择父级菜单</option>
                            <option value="1" selected="selected">兴趣</option>
                            <option value="2">课业</option>
                        </select>
                    </td>
                </tr>
                <tr>
	                <td align="right">备注:</td>
	                <td align="left" colspan="3">
	                	<textarea id="mt_remark" name="menuType.remark" rows="4" cols="100" class="input" ></textarea>
	                </td>
                </tr>
            </table>
        </form>
    </div>
    <div class="bottom_div" align="center">
         <input type="button" id="save_train_info" class="btn green" value="保存"/>&nbsp;&nbsp;&nbsp;&nbsp;
         <input type="button" id="toBack" class="btn green" onclick="javascript:window.history.back();" value="返回"/>
    </div>
</body>
</html>