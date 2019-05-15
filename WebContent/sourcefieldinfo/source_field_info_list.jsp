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
<script type="text/javascript" src="<%=basePath%>sourcefieldinfo/js/source_field_info.js"></script>
<script type="text/javascript" src="<%=basePath%>js/layer/layer.js"></script>

<title>素材字段</title>
</head>
<body style="margin: 10px;padding: 0px;margin-left: 10px;">
	<div>
	    <form id="sourceFieldInfoForm" action="" method="post">
	    	<input type="hidden" id="sid" value="${sourceFieldInfo.sourceInfo.id}">
	        <input type="hidden" id="current_page" value="${page }">
	        <input type="hidden" id="total_count" value="${totalCount }">
	        <div class="nav">
	            <label>&gt;&gt;素材字段管理</label>
	        </div>
	        <div class="top_div">
	            <input type="button" id="toAdd_source_field_info" onclick="toAdd();" class="btn green" value="新增"/>
	        </div>
	        <div class="content_div">
	            <table class="allTable" border="1" bordercolor="gray">
	                <thead>
	                    <tr style="height: 38px;font-size: 15px;">
	                        <th width="5%">编号</th>
	                        <th width="15%">字段名称</th>
	                        <th width="5%">输入类型</th>
	                        <th width="5%">字体类型</th>
	                        <th width="5%">字体颜色</th>
	                        <th width="5%">字体尺寸</th>
	                        <th width="5%">对其方式</th>
	                        <th width="5%">文字方向</th>
	                        <th width="10%">第一X坐标</th>
	                        <th width="10%">第一Y坐标</th>
	                        <th width="15%">旋转角度</th>
	                        <th width="15%">操作</th>
	                    </tr>
	                </thead>
	                <tbody>
	                    <c:forEach items="${sourceFieldInfoList}" var="sourceFieldInfo" varStatus="status">
	                        <tr style="height: 35px;font-size: 15px;">
	                            <td align="center">
	                                ${ status.index + 1}
	                            </td>
	                            <td align="center">
	                                <c:out value="${sourceFieldInfo.fieldName}" />
	                            </td>
	                            <td align="center">
	                                <c:if test="${sourceFieldInfo.inputType == 0 }">文本</c:if>
	                                <c:if test="${sourceFieldInfo.inputType == 1 }">下拉框</c:if>
	                                <c:if test="${sourceFieldInfo.inputType == 2 }">图片</c:if>
	                                <c:if test="${sourceFieldInfo.inputType == 3 }">二维码</c:if>
	                                <c:if test="${sourceFieldInfo.inputType == 4 }">背景图</c:if>
	                            </td>
	                            <td align="center">
	                                <c:if test="${sourceFieldInfo.fontStyleType == 0 }">微软雅黑</c:if>
	                                <c:if test="${sourceFieldInfo.fontStyleType == 1 }">华文楷体</c:if>
	                            </td>
	                            <td align="center">
	                                <c:out value="${sourceFieldInfo.fontColor}" />
	                            </td>
	                            <td align="center">
	                                <c:out value="${sourceFieldInfo.fontSize}" />
	                            </td>
	                            <td align="center">
	                                <c:if test="${sourceFieldInfo.fontWay == 0 }">左对齐</c:if>
	                                <c:if test="${sourceFieldInfo.fontWay == 1 }">右对齐</c:if>
	                                <c:if test="${sourceFieldInfo.fontWay == 2 }">水平居中</c:if>
	                            </td>
	                            <td align="center">
	                                <c:if test="${sourceFieldInfo.fontDirection == 0 }">水平方向</c:if>
	                                <c:if test="${sourceFieldInfo.fontDirection == 1 }">竖直方向</c:if>
	                                <c:if test="${sourceFieldInfo.fontDirection == 2 }">自动换行</c:if>
	                            </td>
	                            <td align="center">
	                                <c:out value="${sourceFieldInfo.firstPointx}" />
	                            </td>
	                            <td align="center">
	                                <c:out value="${sourceFieldInfo.firstPointy}" />
	                            </td>
	                            <td align="center">
	                                <c:out value="${sourceFieldInfo.angleValue}" />
	                            </td>
	                            <td align="center">
	                                <input type="button" id="source_field_info_edit" class="btn green" onclick="toEdit('${sourceFieldInfo.id}')" value="编辑"/>
	                                <input type="button" id="source_field_info_delete" class="btn green" onclick="toDelete('${sourceFieldInfo.id}')" value="删除"/>
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