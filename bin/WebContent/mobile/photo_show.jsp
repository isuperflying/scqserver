<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html class="expanded">

	<head>
		<base href="<%=basePath%>">
		<meta charset="utf-8" />
		<meta http-equiv="Cache-Control" content="no-transform" />
		<title>只凭${fileMessage.successWord }我被${fileMessage.schoolName }录取</title>

		<meta name="applicable-device" content="mobile" />
		<meta id="viewport" name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no" />
		<meta name="apple-mobile-web-app-capable" content="yes" />
		<meta name="apple-mobile-web-app-status-bar-style" content="black" />
		<meta name="msapplication-tap-highlight" content="no" />

		<meta name="keywords" content="">
		<meta name="description" content="" name="description">
		
		<!-- 清除缓存 -->
    	<META HTTP-EQUIV="Pragma"CONTENT="no-cache">
		<META HTTP-EQUIV="Cache-Control"CONTENT="no-cache">
		<META HTTP-EQUIV="Expires"CONTENT="0">
		
		<link rel="shortcut icon" href="/static/common/static/lib/img/favicon.ico">
		<link rel="shortcut icon" href="/static/common/static/lib/img/favicon.ico" type="image/x-icon" />

		<script>
			var PAGE_MAX_WIDTH = 640,
				BASE_FONT_SIZE = 50;
			! function() {
				function n() {
					e.fontSize = Math.min(window.innerWidth / PAGE_MAX_WIDTH * BASE_FONT_SIZE, BASE_FONT_SIZE) + "px"
				}
				var e = document.documentElement.style;
				window.addEventListener("load", n), window.addEventListener("resize", n), n()
			}();
		</script>
		
		<script type="text/javascript" src="<%=basePath%>js/jquery-1.8.3.js"></script>
		<script type="text/javascript" src="<%=basePath%>mobile/js/photo_show.js"></script>
		<link rel="stylesheet" href="<%=basePath%>/mobile/css/show1.css" />
		<link rel="stylesheet" href="<%=basePath%>/mobile/css/show2.css" />
	</head>

	<body>
		
		<div id="wrapper">
			<div id="envelope">
				<div class="inside">
					<div class="layout">
						<div class="paper">
							<div class="inner-wrap">
								<a href="http://zmlearn.com" class="zm-website-entry">江苏广电新启程留学</a>
								<h1 class="main-title">只凭${fileMessage.successWord }我被${fileMessage.schoolName }录取</h1>
								
								<div class="school-affix zymzdx"></div>
								<div class="avatar-area">
									<div class="avatar">
										<img src="<%=basePath%>/tempfile/${fileMessage.fileName }" style="position:absolute; top:-9999px; left:-9999px;" width="295" height="413"/>
										<b style="background-image:url(<%=basePath%>/tempfile/${fileMessage.fileName })"></b>
									</div>
								</div>
								<div class="outside">
									<div class="layout">
										<div class="entry">
											<div class="intro">
												<div class="weibo-entry">
													<a href="http://mp.weixin.qq.com/s?__biz=MzA5NDM0MTYyMw==&mid=207611849&idx=1&sn=041caf9fd64c9e316f660aca98a0d682#rd">据说颜值高的都会点这里</a>
												</div>
											</div>
										</div>
									</div>
							    </div>
							    
								<div class="score-area">
									<div class="rp-score">
										颜值
										<span class="score">
                                            <!-- <b class="num n-5">5</b>
                                            <b class="num n-7">7</b>
                                            <b class="num n-2">2</b> -->
                                            <b id="yanzhi_b">${fileMessage.yanzhib }</b>
                                            <b id="yanzhi_s">${fileMessage.yanzhis }</b>
                                            <b id="yanzhi_g">${fileMessage.yanzhig }</b>
                                        <b class="unit">分!</b>
                                    </span>
									</div>
									<div class="defeat-score">
										<span class="text-0">击败全国</span>
										<span class="score">
                                                <!--  <b class="num n-3">3</b>
                                                <b class="num n-7">7</b>
                                                <b class="point">.</b>
                                                <b class="num n-4">4</b> -->
                                                
                                                <b id="percent_s">${fileMessage.percents }</b>
	                                            <b id="percent_g">${fileMessage.percentg }</b>
	                                            <b class="point">.</b>
	                                            <b id="percent_x">${fileMessage.percentx }</b>
                                                
                                        <b class="unit">%</b>
                                    </span>
										<span class="text-1">的高考学生</span>
									</div>
								</div>
								<div class="target-school">
									<span class="label">${fileMessage.schoolName }已录取</span><br />
									<span class="label_jxj">你已获得<label style="color: red;">${fileMessage.totalJxj }</label>元奖学金</span>
									<div class="comment">
										<!-- 五官端正眉目清秀
										<br/>你的正气指数已突破系统设定最高值
										<br/>我要报警了
										<br/>日后走上人生巅峰，苟富贵，勿忘喵！ -->
										<%-- <s:property value="#session.school_describe"/> --%>
										${fileMessage.schoolDescribe }
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="outside">
					<div class="layout">
						<div class="entry">
							<div class="button-area">
								<button class="upload important button J-trigger-crop" onclick="toPhoto();"><b><i class="icon">&#xe60c;</i><span>我也要刷脸上名校</span></b>
								</button>

							</div>
							<div class="intro">
								<p class="tip"><b class="counter">已有${fileMessage.totalNumber }人获得录取结果</b>
								</p>
								<!-- <div class="weibo-entry">
									<a href="http://mp.weixin.qq.com/s?__biz=MzA5NDM0MTYyMw==&mid=207611849&idx=1&sn=041caf9fd64c9e316f660aca98a0d682#rd">据说颜值高的都会点这里</a>
								</div> -->
							</div>

							<div class="footer-x">
								<a class="zm-ren" href="http://mp.weixin.qq.com/s?__biz=MzA5NDM0MTYyMw==&mid=207611849&idx=1&sn=041caf9fd64c9e316f660aca98a0d682#rd"></a>
								<a class="logo" href="www.newaccess.tv"></a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

	</body>

</html>