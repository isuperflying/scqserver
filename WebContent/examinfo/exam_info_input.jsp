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
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/layer.css">

<script type="text/javascript" src="<%=basePath%>js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.form.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jqPaginator.js"></script>
<script type="text/javascript" src="<%=basePath%>examinfo/js/exam_info.js"></script>
<script type="text/javascript" src="<%=basePath%>js/layer/layer.js"></script>
<script type="text/javascript" src="<%=basePath%>My97DatePicker/WdatePicker.js"></script>
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
            		window.location.href = "getExamInfoDataList.action";
            	});
        	} 
        },
        error : function(data){
        	layer.close(loading);
        }
	 };
	$('#fileFrom').ajaxForm(options).submit();
}


$(document).ready(function(){
	$("#exam_type").change(function(){
		if($(this).val() == 1){
			$("#exam_type_first").show();
			$("#exam_type_second").hide();
		}else{
			$("#exam_type_first").hide();
			$("#exam_type_second").show();
		}
	});
});
</script>
<title>培训机构</title>
</head>
<body style="margin: 10px;padding: 0px;margin-left: 10px;">
	<div class="nav">
       <label>&gt;&gt;发布试卷</label>
    </div>
    <div style="background-color: #F5F5F5;height: auto;">
	    <s:form action="inputExamFile.action" id="fileFrom" namespace="/" method="post" enctype="multipart/form-data">
	    	<table style="margin-left: 35px;">
	    		<tr height="50px;">
	    			<td align="right">试卷方式：</td>
	    			<td>
	    				<select id="exam_type" style="width: 100px;height: 25px;" onchange="toShow();">
	                            <option value="1" selected="selected">自编题目</option>
	                            <option value="2">附件试题</option>
	                    </select>
	    			</td>
	    			<td>试卷编号：</td>
	    			<td><input type="text" name="examInfo.examNumber" /></td>
	    		</tr>
	    		<tr height="50px;">
	    			<td align="right">试卷名称：</td>
	    			<td colspan="3"><input type="text" name="examInfo.examName" /></td>
	    		</tr>
	    		<tr height="50px;">
	    			<td align="right">考试时间：</td>
	               	<td>
	               		<input id="te_begin" name="examInfo.examStartDate" type="text" class="input_date" onClick="WdatePicker({startDate:'%y-%M-01 00:00',dateFmt:'yyyy-MM-dd HH:mm',alwaysUseStartDate:true})" />
	               		~
	               		<input id="te_end" name="examInfo.examEndDate" type="text" class="input_date" onClick="WdatePicker({startDate:'%y-%M-01 00:00',dateFmt:'yyyy-MM-dd HH:mm',alwaysUseStartDate:true})" />
	               	</td>
	               	<td align="right">考试总时长：</td>
	               	<td><input type="text" name="examInfo.examTotalTime" />(分钟)</td>
	    		</tr>
	    	</table>
	    	
	    	<div id="exam_type_first" style="margin-left: 38px;margin-top: 10px;height: 120px;">
	    		<span>试卷内容：</span>
	    		<div style="margin-top: 5px;"><textarea rows="5" cols="120" name="examInfo.examContent"></textarea></div>
	    	</div>
		    <div id="exam_type_second" style="margin-left:35px;margin-top: 10px;display: none;width: 100%;height: 120px;">
					<span style="height:30px;line-height:30px;" ><s:file name="excelFile" id="file_name">选择文件:</s:file></span>
		    </div>
		</s:form>
		<div align="center" style="width: 100%">
			<input type="button" class="btn green" onclick="toInputExcel()" value="发布" style="margin-bottom: 10px; margin-top: 10px;margin-left: 0px;" />
		</div>
	</div>
</body>
</html>