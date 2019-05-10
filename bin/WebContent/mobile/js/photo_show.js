
$(document).ready(function() {
	var num1 = $("#yanzhi_b").html();
	var num2 = $("#yanzhi_s").html();
	var num3 = $("#yanzhi_g").html();
	
	var num4 = $("#percent_s").html();
	var num5 = $("#percent_g").html();
	var num6 = $("#percent_x").html();
	
	/*alert(num1);
	alert(num2);
	alert(num3);*/
	$("#yanzhi_b").removeClass().addClass("num n-"+num1);
	$("#yanzhi_s").removeClass().addClass("num n-"+num2);
	$("#yanzhi_g").removeClass().addClass("num n-"+num3);
	
	$("#percent_s").removeClass().addClass("num n-"+num4);
	$("#percent_g").removeClass().addClass("num n-"+num5);
	$("#percent_x").removeClass().addClass("num n-"+num6);
});

function toPhoto(){
	//alert(1);
	window.location.href="mobile/photo_select.jsp";
}