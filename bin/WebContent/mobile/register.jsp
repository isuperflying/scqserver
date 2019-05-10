<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/mobile_base.css">

<script type="text/javascript" src="<%=basePath%>js/jquery-1.8.3.js"></script>
<!--[if lt IE 9]>
　　　　<script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
<![endif]-->
<title>注册</title>
<script type="text/javascript">
function IdentityCodeValid(code) {
    var city={11:"北京",12:"天津",13:"河北",14:"山西",15:"内蒙古",21:"辽宁",22:"吉林",23:"黑龙江 ",31:"上海",32:"江苏",33:"浙江",34:"安徽",35:"福建",36:"江西",37:"山东",41:"河南",42:"湖北 ",43:"湖南",44:"广东",45:"广西",46:"海南",50:"重庆",51:"四川",52:"贵州",53:"云南",54:"西藏 ",61:"陕西",62:"甘肃",63:"青海",64:"宁夏",65:"新疆",71:"台湾",81:"香港",82:"澳门",91:"国外 "};
    var tip = "";
    var pass= true;
    
    if(!code || !/^\d{6}(18|19|20)?\d{2}(0[1-9]|1[12])(0[1-9]|[12]\d|3[01])\d{3}(\d|X)$/i.test(code)){
        tip = "身份证号格式错误";
        pass = false;
    }
    
   else if(!city[code.substr(0,2)]){
        tip = "地址编码错误";
        pass = false;
    }
    else{
        //18位身份证需要验证最后一位校验位
        if(code.length == 18){
            code = code.split('');
            //∑(ai×Wi)(mod 11)
            //加权因子
            var factor = [ 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 ];
            //校验位
            var parity = [ 1, 0, 'X', 9, 8, 7, 6, 5, 4, 3, 2 ];
            var sum = 0;
            var ai = 0;
            var wi = 0;
            for (var i = 0; i < 17; i++)
            {
                ai = code[i];
                wi = factor[i];
                sum += ai * wi;
            }
            var last = parity[sum % 11];
            if(parity[sum % 11] != code[17]){
                tip = "校验位错误";
                pass =false;
            }
        }
    }
    if(!pass) alert(tip);
    return pass;
}
function toSubmit(){
	if ($("#nick_name").val() == '') {
        alert("请输入姓名!");
        return false;
    }
	if ($("#id_card").val() == '') {
        alert("请输入身份证号码!");
        return false;
    }
	if ($("#user_company").val() == '') {
        alert("请输入单位!");
        return false;
    }
	if ($("#tel_number").val() == '') {
        alert("请输入手机号码!");
        return false;
    }
	if ($("#passWord").val() == '') {
        alert("请输入密码!");
        return false;
    }
	if ($("#confirm_passWord").val() == '') {
        alert("请再次输入密码!");
        return false;
    }
	
	
	if(!IdentityCodeValid($("#id_card").val()))
	{  
	    return false;
	}
	
	var reg_telnumber = /^1\d{10}$/;
    if(reg_telnumber.test($("#tel_number").val()) == false){
    	alert("手机号码输入有误!");
	    return false;
    }
	
    if($("#passWord").val() !=$("#confirm_passWord").val()){
    	alert("2次密码输入不一致!");
	    return false;
    }
    
    $("#registerForm").submit();
}

</script>
</head>
<body>
	<form id="registerForm" action="registerUser.action" method="post">
		<input type="hidden" name="user.openId" value="<s:property value='openId'/>" >
		<table style="border-collapse:separate;width:100%;">
			<tr>
				<td class="td_left">姓&nbsp;名:</td>
				<td><input type="text" id="nick_name" name="user.nickName" class="input-text" placeholder="请输入姓名"></td>
			</tr>
			<tr>
				<td class="td_left">身份证:</td>
				<td><input type="text" id="id_card" name="user.idCard"  class="input-text" placeholder="请输入身份证"></td>
			</tr>
			<tr>
				<td class="td_left">单&nbsp;位:</td>
				<td><input type="text" id="user_company" name="user.userCompany" class="input-text" placeholder="请输入单位"></td>
			</tr>
			<tr>
				<td class="td_left">手机号码:</td>
				<td><input type="text" id="tel_number" name="user.telNumber" class="input-text" placeholder="请输入手机号码"></td>
			</tr>
			<tr>
				<td class="td_left">密&nbsp;码:</td>
				<td><input type="text" id="passWord" name="user.passWord" class="input-text" placeholder="请输入密码"></td>
			</tr>
			<tr>
				<td class="td_left">确认密码:</td>
				<td><input type="text" id="confirm_passWord" class="input-text" placeholder="请再次输入密码"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="button" onclick="toSubmit();" class="regBtn" value="注&nbsp;册" /></td>
			</tr>
		</table>
	</form>
</body>
</html>