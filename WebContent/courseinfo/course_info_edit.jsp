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

<script type="text/javascript" src="<%=basePath%>My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.form.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jqPaginator.js"></script>
<script type="text/javascript" src="<%=basePath%>courseinfo/js/course_info.js"></script>
<script type="text/javascript" src="<%=basePath%>js/layer/layer.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$("#ci_first_menu").val($("#first_menu_value").val());
	$("#ci_second_menu").val($("#second_menu_value").val());
	$("#ci_three_menu").val($("#three_menu_value").val());
});
</script>
<title>编辑课程</title>
</head>
<body style="margin: 0px;padding: 0px;width: 100%;">
    <div class="nav">
       <label>&gt;&gt;编辑课程</label>
    </div>
    <div align="center" style="height: 400px;">
        <form id="editCourseInfoForm" action="updateCourseInfo.action" method="post">
        	<input type="hidden" id="trainInfoId" name="courseInfo.trainId.id" value="${trainInfoId }">
        	<input type="hidden" id="menu_type_id" name="courseInfo.typeId.menuNumber" >
        	
        	<input type="hidden" id="first_menu_value" value="${courseInfo.firstMenuNumber }">
        	<input type="hidden" id="second_menu_value" value="${courseInfo.secondMenuNumber }">
        	<input type="hidden" id="three_menu_value" value="${courseInfo.threeMenuNumber }">
        	
            <table style="width: 100%;margin-top: 10px;">
                <tr>
                    <td align="right">课程名称:</td>
                    <td align="left">
                        <input id="ci_name" name="courseInfo.courseName" type="text" class="input" size="60" value="${courseInfo.courseName}"/>
                    </td>
                    <td align="right">课程简称:</td>
                    <td align="left">
                        <input id="ci_simple_name" name="courseInfo.courseSimpleName" type="text" class="input" value="${courseInfo.courseSimpleName}"/>
                    </td>
                </tr>
                <tr>
                    <td width="15%" align="right">课程所属菜单:</td>
                    <td width="35%" align="left">
                        <select id="ci_first_menu"  style="width: 150px;height: 25px;">
                        	<option value="0" selected="selected">选择一级菜单</option>
                        	<c:if test="${!empty firstMenuList}">
                                <c:forEach items="${firstMenuList}" var="first">
                                    <option value="${first.menuNumber}">${first.typeName}</option>
                                </c:forEach>
                            </c:if>
                        </select>
                        <select id="ci_second_menu" style="width: 100px;height: 25px;">
                            <option value="0" selected="selected">选择二级菜单</option>
                        	<c:if test="${!empty secondMenuList}">
                                <c:forEach items="${secondMenuList}" var="second">
                                    <option value="${second.menuNumber}">${second.typeName}</option>
                                </c:forEach>
                            </c:if>
                        </select>
                        <select id="ci_three_menu" style="width: 100px;height: 25px;">
                            <option value="0" selected="selected">选择三级菜单</option>
                        	<c:if test="${!empty threeMenuList}">
                                <c:forEach items="${threeMenuList}" var="threes">
                                    <option value="${threes.menuNumber}">${threes.typeName}</option>
                                </c:forEach>
                            </c:if>
                        </select>
                    </td>
                    <td width="15%" align="right">课程所属年级:</td>
                    <td width="35%" align="left">
                        <select id="ci_course_grade" name="courseInfo.courseGrade" style="width: 150px;height: 25px;">
                        	<option value="0">选择年级</option>
                        	<option value="1">小班</option>
                        	<option value="2">中班</option>
                        	<option value="3">大班</option>
                        	<option value="4">一年级</option>
                        	<option value="5">二年级</option>
                        	<option value="6">三年级</option>
                        	<option value="7">四年级</option>
                        	<option value="8">五年级</option>
                        	<option value="9">六年级</option>
                        	<option value="10">初一</option>
                        	<option value="11">初二</option>
                        	<option value="12">初三</option>
                        	<option value="13">高一</option>
                        	<option value="14">高二</option>
                        	<option value="15">高三</option>
                        	<option value="16">大学一年级</option>
                        	<option value="17">大学二年级</option>
                        	<option value="18">大学三年级</option>
                        	<option value="19">大学四年级</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td align="right">课程所在教室地址:</td>
                    <td align="left">
                        <input id="ci_course_class" name="courseInfo.courseClass" type="text" class="input" size="60" value="${courseInfo.courseClass}"/>
                    </td>
                    <td align="right">教室编号:</td>
                    <td align="left">
                        <input id="ci_course_class_number" name="courseInfo.courseClassNumber" type="text" class="input" value="${courseInfo.courseClassNumber}"/>
                    </td>
                </tr>
                <tr>
                    <td align="right">课程开始时间:</td>
                    <td align="left">
                        <input id="ci_course_start_date" name="courseInfo.courseStartDate" type="text" class="input" onClick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm'})" value="${courseInfo.courseStartDate}"/>
                    </td>
                    <td align="right">课程结束时间:</td>
                    <td align="left">
                        <input id="ci_course_end_date" name="courseInfo.courseEndDate" type="text" class="input" onClick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm'})" value="${courseInfo.courseEndDate}"/>
                    </td>
                </tr>
                <tr>
                    <td align="right">学年:</td>
                    <td align="left">
                        <input id="ci_course_year" name="courseInfo.courseYear" type="text" class="input" value="${courseInfo.courseYear}"/>
                    </td>
                    <td align="right">课程教材:</td>
                    <td align="left">
                        <input id="ci_course_book" name="courseInfo.courseBook" type="text" class="input" value="${courseInfo.courseBook}"/>
                    </td>
                </tr>
                <tr>
                   <%--  <td align="right">授课老师:</td>
                    <td align="left">
                        <select id="ci_parentNumber" name="courseInfo.courseTeacher.id" style="width: 150px;height: 25px;">
                        	<option value="0">选择老师</option>
                        </select>
                    </td> --%>
                    <td align="right">课程收费方式:</td>
                    <td align="left" colspan="3">
                        <select id="ci_course_price_type" name="courseInfo.coursePriceType" style="width: 150px;height: 25px;">
                        	<option value="1">课时</option>
                        	<option value="2">次数</option>
                        </select>
                    </td>
                    <td align="right">是否为精选课程:</td>
                    <td align="left">
                        <select id="ci_is_curated" name="courseInfo.isCurated" style="width: 150px;height: 25px;">
                        	<option value="0">选择老师</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td align="right">课程课时:</td>
                    <td align="left">
                        <input id="ci_course_hour" name="courseInfo.courseHour" type="text" class="input" value="${courseInfo.courseHour}"/>
                    </td>
                    <td align="right">课程总费用:</td>
                    <td align="left">
                        <input id="ci_course_total_price" name="courseInfo.courseTotalPrice" type="text" class="input" value="${courseInfo.courseTotalPrice}"/>
                    </td>
                </tr>
                <tr>
                    <td align="right">课程简介:</td>
                    <td align="left" colspan="3">
                        <textarea id="ci_course_introduction" rows="3" cols="100" name="courseInfo.courseIntroduction" class="input">${courseInfo.courseIntroduction}</textarea>
                    </td>
                </tr>
                <tr>
	                <td align="right">备注:</td>
	                <td align="left" colspan="3">
	                	<textarea id="ci_remark" name="courseInfo.remark" rows="4" cols="100" class="input" >${courseInfo.remark}</textarea>
	                </td>
                </tr>
            </table>
        </form>
    </div>
    <div class="bottom_div" align="center">
         <input type="button" id="update_course_info" class="btn green" value="保存"/>&nbsp;&nbsp;&nbsp;&nbsp;
         <input type="button" id="toBack" class="btn green" onclick="javascript:window.history.back();" value="返回"/>
    </div>
</body>
</html>