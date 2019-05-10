<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<!--[if lt IE 9]>
　　　　<script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
<![endif]-->
<base href=".">
<title>辅导帮APP下载</title>
<style type="text/css">
* {
	margin: 0px;
	padding: 0px;
	font-size: 14px;
	font-family: "微软雅黑";
	border: none;
}

body {
	background: url(images/download_background.jpg) center;
	background-repeat: no-repeat;
	background-position: top;
}

.middle_white {
	background: url(images/download_background.png);
	height: 400px;
	margin-top: 125px;
}

.width_1200 {
	width: 1200px;
	margin: 0px auto;
}

.height_400 {
	height: 400px;
}

.left {
	float: left;
}

.download_url {
	width: 680px;
	height: 200px;
	margin-top: 125px;
}

.android, .iphone {
	width: 180px;
	height: 50px;
	margin-top: 50px;
}

.android, .android:hover, .iphone, .iphone:hover {
	background: url(images/down_img.png);
	background-repeat: no-repeat;
}

.android {
	margin-left: 30px;
}

.android:hover {
	background-position: 0 -50px;
}

.iphone {
	margin-left: 20px;
	background-position: 0 -100px;
}

.iphone:hover {
	background-position: 0 -150px;
}
</style>
</head>
<!---------------------------------------/body---------------------------------------------->
<body>
	<!--/白色底纹图-->
	<div class="middle_white">
		<div class="width_1200 height_400">
			<!--/手持手机图400*400px-->
			<div class="left">
				<img src="images/hand_show.png">
			</div>
			<div class="left download_url">
				<!--/二维码图片200*200px-->
				<img class="left" src="images/qr_code.png">
				<!--/辅导帮APP字样-->
				<img class="left" style="margin-left: 30px;"
					src="images/train_help_pitches.png" width="380">
				<!--/客户端下载连接-->
				<div align="center">
					<a id="and"
						href="http://www.antleague.com/TrainHelp/down/TrainHelp.apk"
						style="margin-top: 10px;"> <img src="images/down_img.png"
						width="180" height="50" style="margin-top: 30px;">
					</a>
				</div>
			</div>
		</div>
		<!--/width1200-->
	</div>

</body>
</html>