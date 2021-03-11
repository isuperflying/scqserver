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
<script type="text/javascript" src="<%=basePath%>sourcefieldinfo/js/source_field_info.js"></script>
<script type="text/javascript" src="<%=basePath%>js/layer/layer.js"></script>

<script type="text/javascript">
function toAddScField(){
	
	var loading = layer.load();
    //此处用setTimeout演示ajax的回调
    /* setTimeout(function(){
        layer.close(ii);
    }, 1000); */
    var sid = $("#sid").val();
	var options = { 
        success: function(data){
        	if(null != data && data == "success"){
        		layer.close(loading);
            	layer.alert('添加成功!', function(){
            		//window.open('getTrainInfoDataList.action','_self');
            		window.location.href = "getSourceFieldInfoDataListBySid.action?sourceFieldInfo.sourceInfo.id="+sid;
            	});
        	} 
        }
	 };
	$('#addSourceFieldInfoForm').ajaxForm(options).submit();
}

</script>

<title>新增素材</title>
</head>
<body style="margin: 0px;padding: 0px;width:50%;">
    <div class="nav">
       <label>&gt;&gt;新增素材</label>
    </div>
    <div align="center" style="height: 100px;">
        <s:form action="saveSourceFieldInfo.action" id="addSourceFieldInfoForm" namespace="/" method="post" enctype="multipart/form-data">
        	<input type="hidden" id="sid" name="sourceFieldInfo.sourceInfo.id" value = "${sourceFieldInfo.sourceInfo.id}">
            <table style="width: 100%;margin-top: 10px;">
                <tr>
                    <td align="right">字段名称:</td>
                    <td align="left">
                        <input id="field_name" name="sourceFieldInfo.fieldName" type="text" class="input"/>
                    </td>
                    <td align="right">是否可见:</td>
                    <td align="left">
                        <select id="is_visable" name="sourceFieldInfo.isVisable" style="width: 100px;height: 25px;" onchange="visableChange();">
                            <option value="0" selected="selected">可见</option>
                            <option value="1">隐藏</option>
                        </select>
                    </td>
                </tr>
                <tr id="visable_type">
               	   <td align="right">隐藏类型：</td>
                   <td align="left">
                   		<select id="hide_type" name="sourceFieldInfo.hideType" style="width: 100px;height: 25px;">
                   			<option value="-1" selected="selected">--</option>
                            <option value="0">姓名</option>
                            <option value="1">时间</option>
                        </select>
                   </td>
                   <td align="right">隐藏值获取方式：</td>
                   <td>
                   	 	<input id="field_name" name="sourceFieldInfo.hideValue" type="text" class="input"/>
                   </td>
                </tr>
                <tr>
                	<td align="right">输入类型:</td>
                    <td align="left">
                        <select id="sc_input_type" name="sourceFieldInfo.inputType" style="width: 100px;height: 25px;">
                            <option value="0" selected="selected">文本</option>
                            <option value="1">下拉框</option>
                            <option value="2">图片</option>
                            <option value="3">二维码</option>
                            <option value="4">背景图</option>
                        </select>
                    </td>
                    <td align="right">字体类型:</td>
                    <td align="left">
                        <select id="sc_is_vip" name="sourceFieldInfo.fontStyleType" style="width: 100px;height: 25px;">
                            <option value="1" selected="selected">微软雅黑</option>
                            <option value="2">仿宋</option>
                            <option value="3">楷体</option>
                            <option value="4">经典空叠体</option>
                            <option value="5">郭敬明体</option>
                            <option value="6">吴嘉睿手写体</option>
                            <option value="7">胭脂连体</option>
                            <option value="8">徐金如硬笔行楷</option>
                            <option value="9">叶根友毛笔行书</option>
                            <option value="10">数字字体</option>
                            <option value="11">黑体</option>
                            <option value="12">方正榜书行简体</option>
                            <option value="13">方正大黑简体(粗)</option>
                            <option value="14">身份证设计字体</option>
                            <option value="15">钟齐余好建行艺体</option>
                            <option value="16">方正胖娃简体</option>
                            <option value="17">经典中国简体</option>
                            <option value="18">迷你简体卡通</option>
                            <option value="19">迷你简体毡笔黑</option>
                            <option value="20">情话手写</option>
                            <option value="21">书体坊颜体</option>
                            <option value="22">华文行楷</option>
                        </select>
                    </td>
                </tr>
                <tr>
                	<td align="right">文本约束类型:</td>
                    <td align="left" colspan="3">
                    	<select id="sc_input_type" name="sourceFieldInfo.restrain" style="width: 100px;height: 25px;">
                            <option value="0" selected="selected">无约束</option>
                            <option value="1">整数</option>
                            <option value="2">中文</option>
                            <option value="3">英文</option>
                            <option value="4">数值</option>
                        </select>
                    </td>
                </tr>
                <tr>
                	<td align="right">下拉框输入值(用#号分割开设置):</td>
                    <td align="left">
                    	<input id="option_txt" name="sourceFieldInfo.optionTxt" type="text" class="input"/>
                    </td>
                    <td align="right">文本最大输入长度:</td>
                    <td align="left">
                    	<input id="option_txt" name="sourceFieldInfo.inputLength" type="text" class="input"/>
                    </td>
                </tr>
                <tr>
                	<td align="right">字体颜色:</td>
                    <td align="left">
                        <input id="sc_price" name="sourceFieldInfo.fontColor" type="text" class="input"/>
                    </td>
                    <td align="right">字体尺寸:</td>
                    <td align="left">
                        <input id="sc_price" name="sourceFieldInfo.fontSize" type="text" class="input"/>
                    </td>
                </tr>
                <tr>
                    <td align="right">对其方式:</td>
                    <td align="left">
                        <select id="sc_is_vip" name="sourceFieldInfo.fontWay" style="width: 100px;height: 25px;">
                            <option value="0" selected="selected">左对齐</option>
                            <option value="1">右对齐</option>
                            <option value="2">水平居中</option>
                        </select>
                    </td>
                    <td align="right">文字方向:</td>
                    <td align="left">
                        <select id="sc_is_vip" name="sourceFieldInfo.fontDirection" style="width: 100px;height: 25px;">
                            <option value="0" selected="selected">水平方向</option>
                            <option value="1">竖直方向</option>
                            <option value="2">自动换行</option>
                        </select>
                    </td>
                </tr>
                <tr>
                	<td align="right">第一个点X坐标:</td>
                    <td align="left">
                        <input id="sc_price" name="sourceFieldInfo.firstPointx" type="text" class="input"/>
                    </td>
                    <td align="right">第一个点Y坐标:</td>
                    <td align="left">
                        <input id="sc_price" name="sourceFieldInfo.firstPointy" type="text" class="input"/>
                    </td>
                </tr>
                <tr>
                	<td align="right">第二个点X坐标:</td>
                    <td align="left">
                        <input id="sc_price" name="sourceFieldInfo.secondPointx" type="text" class="input"/>
                    </td>
                    <td align="right">第二个点Y坐标:</td>
                    <td align="left">
                        <input id="sc_price" name="sourceFieldInfo.secondPointy" type="text" class="input"/>
                    </td>
                </tr>
                <tr>
                	<td align="right">X方向偏移值:</td>
                    <td align="left">
                        <input id="sc_price" name="sourceFieldInfo.xoffset" type="text" class="input"/>
                    </td>
                    <td align="right">Y方向偏移值:</td>
                    <td align="left">
                        <input id="sc_price" name="sourceFieldInfo.yoffset" type="text" class="input"/>
                    </td>
                </tr>
                <tr>
                	<td align="right">旋转角度:</td>
                    <td align="left">
                        <input id="sc_price" name="sourceFieldInfo.angleValue" type="text" class="input"/>
                    </td>
                    <td align="right">字段排序:</td>
                    <td align="left">
                        <input id="sc_index" name="sourceFieldInfo.fieldIndex" type="text" class="input"/>
                    </td>
                </tr>
            </table>
        </s:form>
        
        <div align="center" style="width: 100%">
			<input type="button" class="btn green" onclick="toAddScField()" value="添加" style="margin-bottom: 10px; margin-top: 10px;margin-left: 0px;" />
		</div>
    </div>
</body>
</html>