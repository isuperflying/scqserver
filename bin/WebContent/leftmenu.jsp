<%@page import="com.ant.scq.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- HTTP 1.1 -->  
<meta http-equiv="pragma" content="no-cache">
<!-- HTTP 1.0 -->  
<meta http-equiv="cache-control" content="no-cache">  
<!-- Prevent caching at the proxy server -->  
<meta http-equiv="expires" content="0">
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE9" />

<link rel="icon" type="image/x-icon" href="/jmoa/favicon.ico" />
<link rel="shortcut icon" type="image/x-icon" href="/jmoa/favicon.ico" />
<link rel="bookmark" type="image/x-icon" href="/jmoa/favicon.ico" />
<link rel="stylesheet" href="css/styles.css" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/zzsc.css">

<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/leftmenu.js"></script>
<title>功能菜单</title>
</head>
<body>
    <div style="height: 61px;width: 170px;text-align: center;">
        <img src="images/left_menu.png">
    </div>
    <div class="subNavBox">
        <div class="subNav currentDd currentDt">培训实施</div>
        <ul class="navContent " style="display: block">
            <li><a href="javascript:void(0)" onclick="toShow(22);"><img src="images/jiantou1.png"><span>通知发布</span></a>
            </li>
            <li><a href="javascript:void(0)" onclick="toShow(1);"><img src="images/jiantou1.png"><span>培训实施</span></a>
            </li>
            <li><a href="javascript:void(0)" onclick="toShow(28);"><img src="images/jiantou1.png"><span>培训考试</span></a>
            </li>
        </ul>
        <%-- <div class="subNav">课程学习</div>
        <ul class="navContent">
            <li><a href="javascript:void(0)" onclick="toShow(2);"><img src="images/jiantou1.png"><span>在线学习</span></a>
            </li>
            <li><a href="javascript:void(0)" onclick="toShow(2);"><img src="images/jiantou1.png"><span>在线学习</span></a>
            </li>
        </ul>
        <div class="subNav">在线考试</div>
        <ul class="navContent">
        	<c:if test="${LOGIN_USER.userType==0 }">
            <li><a href="javascript:void(0)" onclick="alert('请用从业人员账号登陆!')"><img src="images/jiantou1.png"><span>在线考试</span></a>
            </li>
            </c:if>
            <c:if test="${LOGIN_USER.userType==1 }">
            <li><a href="javascript:void(0)" onclick="toShow(23);"><img src="images/jiantou1.png"><span>在线考试</span></a>
            </li>
            </c:if>
            <li><a href="javascript:void(0)" onclick="toShow(24);"><img src="images/jiantou1.png"><span>成绩查询</span></a>
            </li>
        </ul> --%>
        <div class="subNav">补考管理</div>
        <ul class="navContent">
            <li><a href="javascript:void(0)" onclick="toShow(7);"><img src="images/jiantou1.png"><span>补考信息</span></a>
            </li>
        </ul>
        <div class="subNav">通知消息</div>
        <ul class="navContent">
            <li><a href="javascript:void(0)" onclick="toShow(22);"><img src="images/jiantou1.png"><span>通知列表</span></a>
            </li>
        </ul>
        <div class="subNav">基础数据</div>
        <ul class="navContent">
            <li><a href="javascript:void(0)" onclick="toShow(8);"><img src="images/jiantou1.png"><span>字典列表</span></a>
            </li>
            <li><a href="javascript:void(0)" onclick="toShow(9);"><img src="images/jiantou1.png"><span>课件列表</span></a>
            </li>
            <li><a href="javascript:void(0)" onclick="toShow(27);"><img src="images/jiantou1.png"><span>培训课程</span></a>
            </li>
            <li><a href="javascript:void(0)" onclick="toShow(21);"><img src="images/jiantou1.png"><span>题库列表</span></a>
            </li>
            <li><a href="javascript:void(0)" onclick="toShow(25);"><img src="images/jiantou1.png"><span>最新动态</span></a>
            </li>
            <li><a href="javascript:void(0)" onclick="toShow(26);"><img src="images/jiantou1.png"><span>政策法规</span></a>
            </li>
        </ul>
    </div>
</body>
</html>