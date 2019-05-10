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
<script type="text/javascript" src="<%=basePath%>js/jqPaginator.js"></script>
<script type="text/javascript" src="<%=basePath%>scoreitem/js/score_item.js"></script>
<script type="text/javascript" src="<%=basePath%>js/layer/layer.js"></script>

<title>考试打分项</title>
</head>
<body style="margin: 10px;padding: 0px;margin-left: 10px;">
<div>
    <form id="scoreItemForm" action="" method="post">
        <input type="hidden" id="current_page" value="${page }">
        <input type="hidden" id="total_count" value="${totalCount }">
        <div class="nav">
            <label>&gt;&gt;考试打分项</label>
        </div>
        <div class="top_div">
            <input type="button" id="toAdd_score_item" onclick="toAdd();" class="btn green" value="新增"/>
        </div>
        <div class="content_div">
            <table class="allTable" border="1" bordercolor="gray">
                <thead>
                    <tr style="height: 38px;font-size: 15px;">
                        <th width="5%">编号</th>
                        <th width="25%">打分项</th>
                        <th width="15%">操作</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${scoreItemList}" var="scoreItem" varStatus="status">
                        <tr style="height: 35px;font-size: 15px;">
                            <td align="center">
                                ${ status.index + 1}
                            </td>
                            <td align="center">
                                <c:out value="${scoreItem.scoreItemName}" />
                            </td>
                            
                            <td align="center">
                                <input type="button" id="score_item_edit" class="btn green" onclick="toEdit('${scoreItem.id}','${scoreItem.scoreItemName}')" value="编辑"/>
                                <input type="button" id="score_item_delete" class="btn green" onclick="toDelete('${scoreItem.id}')" value="删除"/>
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
    
    <div id="edit_div" style="display: none;">
		     <div style="background-color: #79C48C;color: #fff;height: 40px;line-height: 40px;">
			    <span style="margin-left: 10px;">编辑打分项</span>
			 </div>
		    <div align="center" style="height: 100px;">
		        <form id="editScoreItemForm" action="updateScoreItem.action" method="post">
		        
		        	<input type="hidden" id="sid" name="scoreItem.id">
		            <table style="width: 100%;margin-top: 20px;">
		                <tr>
		                    <td align="right" height="40">打分项名称：&nbsp;&nbsp;&nbsp;&nbsp;</td>
		                    <td align="left">
		                        <input id="score_name" name="scoreItem.scoreItemName" style="height: 28px;" size="60" type="text" class="input"/>
		                    </td>
		                </tr>
		            </table>
		        </form>
		    </div>
		    <div class="bottom_div" align="center">
		         <input type="button" id="edit_score_item" class="btn green" value="保存"/>&nbsp;&nbsp;&nbsp;&nbsp;
		    </div>
        </div>
</div>
</body>
</html>