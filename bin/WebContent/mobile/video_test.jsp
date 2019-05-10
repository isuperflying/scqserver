<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link href="<%=basePath%>css/video-js.css" rel="stylesheet" type="text/css">
  <script src="<%=basePath%>js/video.js"></script>
<title>HTML5网页视频播放测试</title>
<script>
  videojs.options.flash.swf = "<%=basePath%>/images/video-js.swf";
</script>
</head>
<body>
	<video id="example_video_1" class="video-js vjs-default-skin" controls preload="none" width="100%" height="400"
      data-setup="{}">
    <source src="http://www.anter.com/education/video/html5_test.mp4" type='video/mp4' />
    <track kind="captions" src="demo.captions.vtt" srclang="en" label="English"></track><!-- Tracks need an ending tag thanks to IE9 -->
    <track kind="subtitles" src="demo.captions.vtt" srclang="en" label="English"></track><!-- Tracks need an ending tag thanks to IE9 -->
    <p class="vjs-no-js">To view this video please enable JavaScript, and consider upgrading to a web browser that <a href="http://videojs.com/html5-video-support/" target="_blank">supports HTML5 video</a></p>
  </video>
</body>
</html>