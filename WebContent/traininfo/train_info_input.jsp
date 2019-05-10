<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/common.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/ui-dialog.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/pagination.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/list_info.css">

<script type="text/javascript" src="<%=basePath%>js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.form.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jqPaginator.js"></script>
<script type="text/javascript" src="<%=basePath%>traininfo/js/train_info.js"></script>
<script type="text/javascript" src="<%=basePath%>js/layer/layer.js"></script>
<script type="text/javascript">
function toInputExcel(){
	var fileName = $("#file_name").val();
	if(null == fileName || fileName == ''){
		$.ligerDialog.warn('请选择文件!');
		return;
	}
	
	var loading = layer.load();
    //此处用setTimeout演示ajax的回调
    /* setTimeout(function(){
        layer.close(ii);
    }, 1000); */
    
	var options = {
        success: function(data){
        	if(null != data && data == "success"){
        		layer.close(loading);
            	layer.alert('导入成功!', function(){
            		//window.open('getTrainInfoDataList.action','_self');
            		window.location.href = "getTrainInfoDataList.action";
            	});
        	} 
        },
        error : function(data){
        	layer.close(loading);
        }
	 };
	$('#excelFrom').ajaxForm(options).submit();
}
</script>
<title>培训机构</title>
</head>
<body style="margin: 10px;padding: 0px;margin-left: 10px;">
	<div class="nav">
       <label>&gt;&gt;导入培训机构数据</label>
    </div>
    <s:form action="inputExamFile.action" id="excelFrom" namespace="/" method="post" enctype="multipart/form-data">
	    <div style="margin-top: 20px;">
		    <div style="float: left;height: 30px;">
				<span style="height:30px;line-height:30px;" ><s:file name="excelFile" id="file_name">选择文件:</s:file></span>
		    </div>
	    </div>
	</s:form>
	<div>
		<input type="button" class="btn green" onclick="toInputExcel()" value="导入" style="margin-bottom: 10px; margin-top: 10px;margin-left: 0px;" />
	</div>
</body>
</html>