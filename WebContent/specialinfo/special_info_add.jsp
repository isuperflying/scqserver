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
<script type="text/javascript" src="<%=basePath%>menutype/js/menu_type.js"></script>
<script type="text/javascript" src="<%=basePath%>js/layer/layer.js"></script>
<script type="text/javascript">

function toAddSc(){
	var fileName = $("#cover_file_name").val();
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
            		window.location.href = "getSpecialInfoDataList.action";
            	});
        	} 
        }
	 };
	$('#addSpecialInfoForm').ajaxForm(options).submit();
}

</script>
<title>新增专题</title>
</head>
<body style="margin: 0px;padding: 0px;width: 100%;">
    <div class="nav">
       <label>&gt;&gt;新增培训菜单</label>
    </div>
    <div align="center" style="height: 400px;">
        <s:form action="saveSpecialInfo.action" id="addSpecialInfoForm" namespace="/" method="post" enctype="multipart/form-data">
            <table style="width: 100%;margin-top: 10px;">
                <tr>
                    <td align="right">专题名称:</td>
                    <td align="left">
                        <input id="mt_name" name="specialInfo.name" type="text" class="input"/>
                    </td>
                    <td align="right">是否显示:</td>
                    <td align="left">
                        <select id="is_visable" name="specialInfo.isShow" style="width: 100px;height: 25px;" onchange="visableChange();">
                            <option value="0" selected="selected">显示</option>
                            <option value="1">隐藏</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td align="right">专题类型:</td>
                    <td align="left">
                        <select id="is_visable" name="specialInfo.specialType" style="width: 100px;height: 25px;">
                            <option value="0" selected="selected">普通</option>
                            <option value="1">网页</option>
                            <option value="2">下载</option>
                            <option value="3">小程序</option>
                        </select>
                    </td>
                    <td align="right">专题跳转路径:</td>
                    <td align="left">
                        <input id="path_name" name="specialInfo.jumpPath" type="text" class="input"/>
                    </td>
                </tr>
                <tr>
                    <td align="right">小程序APPID:</td>
                    <td align="left">
                        <input id="appid_name" name="specialInfo.appId" type="text" class="input"/>
                    </td>
                    <td align="right">小程序原始ID:</td>
                    <td align="left">
                        <input id="ori_name" name="specialInfo.originalId" type="text" class="input"/>
                    </td>
                </tr>
                <tr>
                	<td align="right">封面图片:</td>
                    <td align="left" colspan="3">
                        <span style="height:30px;line-height:30px;" ><s:file name="coverFile" id="cover_file_name">选择文件:</s:file></span>
                    </td>
                </tr>
            </table>
        </s:form>
    </div>
    <div class="bottom_div" align="center">
         <input type="button" class="btn green" onclick="toAddSc()" value="添加" style="margin-bottom: 10px; margin-top: 10px;margin-left: 0px;" />
         <input type="button" id="toBack" class="btn green" onclick="javascript:window.history.back();" value="返回"/>
    </div>
</body>
</html>