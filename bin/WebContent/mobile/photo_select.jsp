<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<base href="<%=basePath%>">
		<title>我要上名校</title>
		<meta charset="utf-8">
		<meta name="applicable-device" content="mobile" />
        <meta id="viewport" name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no" />
        <!--[if lt IE 9]>
		　　　　<script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
		<![endif]-->
        <meta name="apple-mobile-web-app-capable" content="yes" />
        <meta name="apple-mobile-web-app-status-bar-style" content="black" />
        <meta name="msapplication-tap-highlight" content="no" />
        <meta name="keywords" content="">
    	<meta name="description" content="" name="description">
    	
    	<!-- 清除缓存 -->
    	<META HTTP-EQUIV="Pragma"CONTENT="no-cache">
		<META HTTP-EQUIV="Cache-Control"CONTENT="no-cache">
		<META HTTP-EQUIV="Expires"CONTENT="0">
    	
    	<link rel="stylesheet" href="<%=basePath%>/mobile/css/index.css" />
		<link rel="stylesheet" href="<%=basePath%>/mobile/css/photo.css" />
		<link rel="stylesheet" href="<%=basePath%>/mobile/css/photo1.css" />
		<link rel="stylesheet" href="<%=basePath%>/mobile/css/photo2.css" />
		<script type="text/javascript" src="<%=basePath%>js/jquery-1.8.3.js"></script>
		<script type="text/javascript" src="<%=basePath%>/mobile/js/file_upload.js" ></script>
	</head>
	<style type="text/css">
        #destination{
            filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(true,sizingMethod=scale);
        }
	</style>
	<script type="text/javascript">
	function toSubmit() {
		$('#form1').submit();
	}
	</script>
	<body>
		<div id="wrapper">
			<div id="envelope">
				<div class="inside">
					<div class="layout">
						<div class="paper">
						</div>
					</div>
				</div>
				<div class="outside">
				
				<form id="form1" action="saveFileMessage.action" method="post"
					enctype="multipart/form-data">
					<input type="hidden" id="fileMessage.fileName" name="fileMessage.fileName"/>
					<div class="layout">
						<div id="avatar-crop" class="table-layout" style="display:table">
							<h2 class="crop-title">传照片查高考成绩</h2>

							<div class="table-row">
								<div class="crop-container table-col">
									<div id="destination" class="crop is-empty" style="z-index: 10;position:relative;">
										<b class="sub-title">高考成绩神预测！高一高二也能查</b>
										<div class="no-image-tip" id="no_image">
											<i class="icon">&#xe60c;</i> 点我点我!
											<input type="file" id="image" name="image" draggable="true" class="file-picker" accept="image/*" />
										</div>
									</div>
									<!-- 暂时不缩放图片 -->
									<!-- <div class="zoom-control">
										<b class="title">
                                        <i></i><span>放大图片往右拉</span>
                                    </b>
										<div class="range-control">
											<div class="button-control zoom-in">
												<button class="J-zoom-in button"><i class="icon">&#xe60b;</i>
												</button>
											</div>
											<div class="range-bar-control">
												<b class="dragable"></b>
											</div>
											<div class="button-control zoom-out">
												<button class="J-zoom-out button"><i class="icon">&#xe60a;</i>
												</button>
											</div>
										</div>
									</div> -->
									<div class="button-area">
										<button class="important button" onclick="toSubmit();"><b>确定</b>
										</button>
										<!-- <button class="reload button" onclick="image.click();">
											<b>重新上传</b>
										</button> -->
										<input type="button" onclick="image.click()" id="mybutton" value="重新上传" class="button" style="font-size: 14px;color: #6E8B3D;"/>
									</div>
								</div>
							</div>

							<div class="footer">
								<div class="link-area">
									<a href="http://www.baidu.com" class="link-a">人丑就该多读书，长得丑点这里</a>
								</div>
							</div>
						</div>
					</div>
					
					</form>
					
				</div>
			</div>
		</div>
	</body>

</html>