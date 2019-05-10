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
<script type="text/javascript" src="<%=basePath%>traininfo/js/train_info.js"></script>
<script type="text/javascript" src="<%=basePath%>js/layer/layer.js"></script>

<title>新增培训机构</title>
</head>
<body style="margin: 0px;padding: 0px;width: 100%;">
    <div class="nav">
       <label>&gt;&gt;新增培训机构</label>
    </div>
    <div align="center" style="height: 400px;">
        <form id="addTrainInfoForm" action="saveTrainInfo.action" method="post">
            <table style="width: 100%;margin-top: 10px;">
                <tr>
                    <td align="right">培训机构名称:</td>
                    <td align="left" colspan="3">
                        <input id="ti_name" name="trainInfo.trainName" type="text" class="input" style="width: 60%" size="50"/>
                    </td>
                </tr>
                <tr>
                	<td width="15%" align="right">所属校区:</td>
                    <td width="35%" align="left">
                        <input id="ti_train_school_area" name="trainInfo.trainSchoolArea" type="text" class="input" />
                    </td>
                    <td width="15%" align="right">所在地区:</td>
                    <td width="35%" align="left">
                        <select id="ti_province" name="trainInfo.registerProvince" style="width: 100px;height: 25px;">
                            <c:if test="${!empty provinceList}">
                                <c:forEach items="${provinceList}" var="province">
                                    <option value="${province.provinceId}">${province.province}</option>
                                </c:forEach>
                            </c:if>
                        </select>
                        <select id="ti_city" name="trainInfo.registerCity" style="width: 100px;height: 25px;">
                            <option>选择城市</option>
                        </select>
                        <select id="ti_area" name="trainInfo.registerArea" style="width: 100px;height: 25px;">
                            <option>选择地区</option>
                        </select>
                    </td>
                </tr>
                <tr>
	                <td align="right">注册地址:</td>
	                <td align="left" colspan="3">
	                	<input id="ti_register_address" name="trainInfo.registerAddress" type="text" class="input" style="width: 60%" size="50"/>
	                </td>
                </tr>
                <tr>
	                <td align="right">负责人:</td>
	                <td align="left">
	                	<input id="ti_contacts_name" name="trainInfo.contactsName" type="text" class="input" />
	                </td>
	                <td align="right">负责人电话:</td>
	                <td align="left">
	                	<input id="ti_contacts_phone" name="trainInfo.contactsPhone" type="text" class="input" />
	                </td>
                </tr>
                <tr>
	                <td align="right">报名电话:</td>
	                <td align="left">
	                	<input id="ti_enrollment_phone_number" name="trainInfo.enrollmentPhoneNumber" type="text" class="input" />
	                </td>
	                <td align="right">营业执照号:</td>
	                <td align="left">
	                	<input id="ti_license" name="trainInfo.license" type="text" class="input" />
	                </td>
                </tr>
                <tr>
	                <td align="right">机构特色:</td>
	                <td align="left">
	                	<input id="ti_train_special" name="trainInfo.trainSpecial" type="text" class="input" />
	                </td>
	                <td align="right">机构规模:</td>
	                <td align="left">
	                	<input id="ti_train_scale" name="trainInfo.trainScale" type="text" class="input" />
	                </td>
                </tr>
                <tr>
	                <td align="right">机构简介:</td>
	                <td align="left" colspan="3">
	                	<textarea id="ti_introduction" name="trainInfo.introduction" rows="4" cols="100" class="input" ></textarea>
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