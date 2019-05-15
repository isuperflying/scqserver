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
<script type="text/javascript" src="<%=basePath%>sourceinfo/js/source_info.js"></script>
<script type="text/javascript" src="<%=basePath%>js/layer/layer.js"></script>

<script type="text/javascript">
function toAddSc(){
	var fileName = $("#thumb_file_name").val();
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
            		window.location.href = "getSourceInfoDataList.action";
            	});
        	} 
        }
	 };
	$('#addSourceInfoForm').ajaxForm(options).submit();
}

</script>

<title>新增素材</title>
</head>
<body style="margin: 0px;padding: 0px;width:50%;">
    <div class="nav">
       <label>&gt;&gt;新增素材</label>
    </div>
    <div align="center" style="height: 100px;">
        <s:form action="saveSourceInfo.action" id="addSourceInfoForm" namespace="/" method="post" enctype="multipart/form-data">
        	
            <table style="width: 100%;margin-top: 10px;">
                <tr>
                    <td align="right">所属类别:</td>
                    <td align="left">
                        <select id="sc_type" style="width: 100px;height: 25px;" name="sourceInfo.scType">
                            <option value="1" selected="selected">微信</option>
                            <option value="2">表白</option>
                            <option value="3">节日</option>
                            <option value="4">恶搞</option>
                            <option value="5">炫富</option>
                            <option value="6">游戏</option>
                            <option value="7">证书</option>
                            <option value="8">明星</option>
                            <option value="9">其它</option>
                        </select>
                    </td>
                    <td align="right">所属专题:</td>
                    <td align="left">
                        <select id="sc_cid" name="sourceInfo.collectionId" style="width: 100px;height: 25px;">
                            <option value="1" selected="selected">趣味表白</option>
                            <option value="2">豪车炫富</option>
                            <option value="3">证书恶搞</option>
                            <option value="4">节日贺卡</option>
                        </select>
                    </td>
                </tr>
                <tr>
                	<td align="right">素材名称:</td>
                    <td align="left">
                        <input id="sc_name" name="sourceInfo.scName" type="text" class="input"/>
                    </td>
                    <td align="right">素材描述:</td>
                    <td align="left">
                        <input id="sc_desc" name="sourceInfo.scDesc" type="text" class="input"/>
                    </td>
                </tr>
                <tr>
                	<td align="right">是否收费:</td>
                    <td align="left">
                        <select id="sc_is_vip" name="scourceInfo.scIsVip" style="width: 100px;height: 25px;">
                            <option value="0" selected="selected">免费</option>
                            <option value="1">收费</option>
                        </select>
                    </td>
                	<td align="right">素材价格:</td>
                    <td align="left">
                        <input id="sc_price" name="sourceInfo.scPrice" type="text" class="input"/>
                    </td>
                </tr>
                <tr>
                    <td align="right">素材缩略图:</td>
                    <td align="left" colspan="3">
                        <span style="height:30px;line-height:30px;" ><s:file name="thumbFile" id="thumb_file_name">选择文件:</s:file></span>
                    </td>
                </tr>
                <tr>
                	<td align="right">素材预览图:</td>
                    <td align="left">
                        <span style="height:30px;line-height:30px;" ><s:file name="scPreFile" id="pre_file_name">选择文件:</s:file></span>
                    </td>
                    <td align="right">素材生成底图:</td>
                    <td align="left">
                        <span style="height:30px;line-height:30px;" ><s:file name="scCreateFile" id="create_file_name">选择文件:</s:file></span>
                    </td>
                </tr>
            </table>
        </s:form>
        
        <div align="center" style="width: 100%">
			<input type="button" class="btn green" onclick="toAddSc()" value="添加" style="margin-bottom: 10px; margin-top: 10px;margin-left: 0px;" />
		</div>
    </div>
</body>
</html>