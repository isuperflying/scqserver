<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="icon" type="image/x-icon" href="/education/favicon.ico" />
<link rel="shortcut icon" type="image/x-icon" href="/education/favicon.ico" />
<link rel="bookmark" type="image/x-icon" href="/education/favicon.ico" />
<link rel="stylesheet" type="text/css" href="css/main.css">

<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/jquery.form.js"></script>
<title>主页</title>
</head>
<body>
    <div class="all_div">
        <div id="top" class="top_div">
            <img src="images/top_img_logo.png" class="top_logo">
            <img src="images/top_img_title.png">
            <label class="top_user_div"><font size="3" color="white" style="font-weight: 600">欢迎你:${LOGIN_USER.userName }&nbsp;
            <a href="javascript:void(0)" onclick="toShow(12);" style="color: white;font-weight: 600">修改密码</a>
            <a href="javascript:void(0)" onclick="toLoginOut();" style="color: white;font-weight: 600">退出</a></font></label>
        </div>
        <div id="content" class="content_div">
            <div id="left" style="float: left;width: 170px;">
                <%@include file="leftmenu.jsp" %>
            </div>
            <div id="right" style="float: right;width: 1030px;height: 592px;background-color: white;">
               <iframe src="index.jsp" name="main_show" frameborder="0" style="width: 100%; height: 100%;border-width: 0px;" scrolling="yes"></iframe>
            </div>
        </div>
        <div class="bottom_div">宿迁市食品药品监督管理局</div>
    </div>
</body>
</html>