<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="icon" type="image/x-icon" href="/education/favicon.ico" />
<link rel="shortcut icon" type="image/x-icon"
	href="/education/favicon.ico" />
<link rel="bookmark" type="image/x-icon" href="/education/favicon.ico" />
<link rel="stylesheet" type="text/css" href="css/emp_index.css">

<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/jquery.form.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/dialog.js"></script>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/ui-dialog.css">
<script type="text/javascript">
	function show(txt) {
		var r = txt.id.split("#!");
		var theme = r[0];
		var content = r[1];
		diaEdit = dialog({
			title : theme,
			content : content,
			width : 500,
			height : 300,
			quickClose : true
		});
		diaEdit.show();
	}
	
	function toMain(index){
	    window.location.href = "toEmpMain.action?mainIndex="+index;
	}
	function toLoginOut(){
	    $.ajax({
	        type:"POST",
	        url : "loginOut.action",
	        dataType : 'text',
	        success : function(data) {
	            if (data == "success") {
	                parent.location.href="login.jsp";
	            } else {
	                //parent.location.href="login.jsp";
	                alert("退出失败!");
	            }
	        }
	    });
	}
</script>
<title>从业人员主页</title>
</head>
<body>
	<div class="emp_all_div">
		<div id="top" class="emp_top_div">
			<img src="images/top_img_logo.png" class="emp_top_logo">
			<img src="images/emp_top_img_title.png">
			<label class="emp_top_user_div">
                 <a href="javascript:void(0)" style="text-decoration: none;" onclick="toMain(8);"><font size="3" color="white">修改密码</font></a>
                 <a href="javascript:void(0)" style="text-decoration: none;" onclick="toLoginOut();"><font size="3" color="white">退出</font></a>
			</label>
		</div>
		<div id="content" class="emp_content_div">
			<div id="top" style="height: 190px; margin-bottom: 12px;">
				<div id="top_left" class="top_left">
					<div style="height: 35px;">
						<font style="margin-left: 25px; line-height: 35px;">当前用户</font>
					</div>
					<div style="width: 98%; text-align: center; height: 10px;">
						<div
							style="background-image: url('images/main_line_01.png'); height: 3px; width: 90%; margin-left: auto; margin-right: auto;"></div>
					</div>
					<div style="height: 35px;">
						<font style="margin-left: 30px; line-height: 35px;">姓名:张三</font>
					</div>
					<div style="height: 35px;">
						<font style="margin-left: 30px; line-height: 35px;">单位:南京聚茂科技</font>
					</div>
				</div>
				<div id="top_right" class="top_right">
					<div style="height: 35px;">
						<font
							style="margin-left: 25px; line-height: 35px; color: #face37;">通知公告</font>
					</div>
					<div style="width: 97%; text-align: center; height: 10px;">
						<div
							style="background-image: url('images/main_line_01.png'); height: 3px; width: 97%; margin-left: auto; margin-right: auto;"></div>
					</div>
					<ul style="line-height: 33px;">
						<s:iterator value="trainNoticeList" var="list">
							<li id="<s:property value="#list.noticeTheme" />#!<s:property value="#list.noticeContent" />"
								onclick="show(this)" style="cursor: pointer;list-style:none;background: url('images/3_10.png') no-repeat;"><span
								style="width: 400px; display: inline-block; overflow: hidden; white-space: nowrap; text-overflow: ellipsis; color: white;margin-left:15px;margin-top:-10px;font-family:'微软雅黑';"><s:property
										value="#list.noticeTheme" /></span><span
								style="float: right; padding-right: 40px; color: white;margin-top:-10px;font-family:'微软雅黑';">[<s:property
										value="#list.sendTime.substring(0,10)" />]</span></li>
						</s:iterator>
					</ul>
				</div>
			</div>
			<div id="top_main" class="top_main">
				<table class="main_table">
					<tr>
						<td><a href="javascript:void(0)" onclick="toMain(1);"><img src="images/main_01.png" border="0"></a></td>
						<td><a href="javascript:void(0)" onclick="toMain(2);"><img src="images/main_02.png" border="0"></a></td>
						<td><a href="javascript:void(0)" onclick="toMain(3);"><img src="images/main_03.png" border="0"></a></td>
						<td><a href="javascript:void(0)" onclick="toMain(4);"><img src="images/main_04.png" border="0"></a></td>
					</tr>
					<tr>
						<td><a href="javascript:void(0)" onclick="toMain(5);"><img src="images/main_05.png" border="0"></a></td>
						<td><a href="javascript:void(0)" onclick="toMain(6);"><img src="images/main_06.png" border="0"></a></td>
						<td><a href="javascript:void(0)" onclick="toMain(7);"><img src="images/main_07.png" border="0"></a></td>
						<td><a href="javascript:void(0)" onclick="toMain(8);"><img src="images/main_08.png" border="0"></a></td>
					</tr>
				</table>
			</div>

		</div>
		<div class="emp_bottom_div">宿迁市食品药品监督管理局</div>
	</div>
</body>
</html>