<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>导航菜单</title>
<link rel="stylesheet" type="text/css" href="css/styles.css"/>
<link rel="stylesheet" type="text/css" href="css/main.css">
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	/* 滑动/展开 */
	$("ul.expmenu li > div.header").click(function(){
		var arrow = $(this).find("span.arrow");
		if(arrow.hasClass("up")){
			arrow.removeClass("up");
			arrow.addClass("up");
		}else if(arrow.hasClass("up")){
			arrow.removeClass("up");
			arrow.addClass("up");
		}
		$(this).parent().find("ul.menu").slideToggle();
	});
});
</script>
<style>
	.menu ol { padding-left:15px; border:#E7E7E7 1px solid; border-top:none;background: #f7f2e5;} 
	.menu li i{background-color: #ae9c7e;padding: 1px 4px;color: #fff;text-shadow: 0px 0px 0px rgba(255, 255, 255, 0.8);font-family: 宋体;font-style:normal;}
	.menu a{color: #3f3f3f;text-decoration: none;}
	.menu .no {display:none;}
	.menu li a{width: 190px;display: block;line-height: 2em;margin-left: 20px;}
</style>
</head>
<body style="background-color: #373a47;">
	<ul class="expmenu">
			<!-- 部门是仓库的才可以看到，销售看不到 -->
			<li>
				<div class="header">
					<span class="left_span2" >考试管理</span>
					<span class="arrow down"></span>
				</div>
				<ul class="menu">
					<li><a href="getSourceInfoDataList.action" target="show" title="素材管理" class="left_span1">素材管理</a></li>
				</ul>
				<hr size=1>
				<ul class="menu">
					<li><a href="getExamInfoDataList.action" target="show" title="试卷列表" class="left_span1">试卷列表</a></li>
				</ul>
				<hr size=1>
				<ul class="menu">
					<li><a href="getUserExamDataList.action" target="show" title="考试记录" class="left_span1">考试记录</a></li>
				</ul>
			</li>
			<li>
				<div class="header">
					<span class="left_span2">系统管理</span>
					<span class="arrow down"></span>
				</div>
				<hr size=1>
				<ul class="menu">
					<li><a href="getScoreItemDataList.action" target="show" title="打分项设置" class="left_span1">打分项设置</a></li>
				</ul>
				<c:if test="${user.userType == 1 }">
					<hr size=1>
					<ul class="menu">
						<li><a href="getUserDataList.action" target="show" title="用户管理" class="left_span1">用户管理</a></li>
					</ul>
				</c:if>
			</li>
	</ul>
</body>
</html>