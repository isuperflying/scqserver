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
<script type="text/javascript" src="<%=basePath%>scoreitem/js/score_item.js"></script>
<script type="text/javascript" src="<%=basePath%>js/layer/layer.js"></script>

<title>新增打分项</title>
</head>
<body style="margin: 0px;padding: 0px;width:50%;">
    <div class="nav">
       <label>&gt;&gt;新增打分项</label>
    </div>
    <div align="center" style="height: 100px;">
        <form id="addScoreItemForm" action="saveScoreItem.action" method="post">
            <table style="width: 100%;margin-top: 10px;">
                <tr>
                    <td align="right" width="20%">打分项名称：&nbsp;&nbsp;&nbsp;&nbsp;</td>
                    <td align="left" width="50%">
                        <input id="score_name" name="scoreItem.scoreItemName" size="60" type="text" class="input"/>
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <div class="bottom_div" align="center">
         <input type="button" id="save_score_item" class="btn green" value="保存"/>&nbsp;&nbsp;&nbsp;&nbsp;
         <input type="button" id="toBack" class="btn green" onclick="javascript:window.history.back();" value="返回"/>
    </div>
</body>
</html>