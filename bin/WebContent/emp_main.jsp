<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="icon" type="image/x-icon" href="/education/favicon.ico" />
<link rel="shortcut icon" type="image/x-icon" href="/education/favicon.ico" />
<link rel="bookmark" type="image/x-icon" href="/education/favicon.ico" />
<link rel="stylesheet" type="text/css" href="css/emp_main.css">

<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/jquery.form.js"></script>
<script type="text/javascript" src="js/emp_main.js"></script>
<title>从业人员主页</title>
</head>
<body>
    <div class="emp_main_all_div">
        <div id="top" class="emp_main_top_div">
            <img src="images/top_img_logo.png" class="emp_main_top_logo">
            <img src="images/emp_top_img_title.png">
            <label class="emp_main_top_user_div">
                                              欢迎你,${LOGIN_USER.userName } 
               <a href="javascript:void(0)" style="text-decoration: none;" onclick="toShow(0);"><font size="3" color="white">返回首页</font> </a>
               <a href="javascript:void(0)" style="text-decoration: none;" onclick="toShow(8);"><font size="3" color="white">修改密码</font></a>
            </label>
        </div>
        <div id="content" class="emp_main_content_div">
            <input type="hidden" id="main_index" value="${mainIndex }">
            <div id="top_nav" class="top_nav">
                <table class="main_nav_table">
                    <tr>
                        <td><a href="javascript:void(0)" onclick="toShow(1);"><img src="images/main_nav_01.png" border="0"></a></td>
                        <td><a href="javascript:void(0)" onclick="toShow(2);"><img src="images/main_nav_02.png" border="0"></a></td>
                        <td><a href="javascript:void(0)" onclick="toShow(3);"><img src="images/main_nav_03.png" border="0"></a></td>
                        <td><a href="javascript:void(0)" onclick="toShow(4);"><img src="images/main_nav_04.png" border="0"></a></td>
                        <td><a href="javascript:void(0)" onclick="toShow(5);"><img src="images/main_nav_05.png" border="0"></a></td>
                        <td><a href="javascript:void(0)" onclick="toShow(6);"><img src="images/main_nav_06.png" border="0"></a></td>
                        <td><a href="javascript:void(0)" onclick="toShow(7);"><img src="images/main_nav_07.png" border="0"></a></td>
                        <td><a href="javascript:void(0)" onclick="toShow(8);"><img src="images/main_nav_08.png" border="0"></a></td>
                    </tr>
                </table>
            </div>
            <div id="top_main" class="top_main">
                <iframe src="test.jsp" name="emp_main_show" frameborder="0" style="width: 100%; height: 100%;border-width: 0px;" scrolling="yes"></iframe>
            </div>
        </div>
        <div class="emp_main_bottom_div">宿迁市食品药品监督管理局</div>
    </div>
</body>
</html>