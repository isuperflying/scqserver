<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/main.css">
<title>智能实验室平台</title>
<script type="text/javascript">
	
</script>
</head>
<frameset rows="100%,0%" frameborder="no">
	<frameset rows="15%,85%" frameborder="no">
		<frame src="top.jsp">
		<frameset cols="13%,87%" frameborder="no">
			<frame src="left.jsp">
			<frame src="getSourceInfoDataList.action" name="show" scrolling="no">
		</frameset>
	</frameset>
	<frame src="bottom.jsp">
</frameset>
</html>