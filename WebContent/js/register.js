//jQuery time
var current_fs, next_fs, previous_fs; //fieldsets
var left, opacity, scale; //fieldset properties which we will animate
var animating; //flag to prevent quick multi-click glitches

$(".next").click(function(){
	if(animating) return false;
	animating = true;
	
	current_fs = $(this).parent();
	next_fs = $(this).parent().next();
	
	//activate next step on progressbar using the index of next_fs
	$("#progressbar li").eq($("fieldset").index(next_fs)).addClass("active");
	
	//show the next fieldset
	next_fs.show(); 
	//hide the current fieldset with style
	current_fs.animate({opacity: 0}, {
		step: function(now, mx) {
			//as the opacity of current_fs reduces to 0 - stored in "now"
			//1. scale current_fs down to 80%
			scale = 1 - (1 - now) * 0.2;
			//2. bring next_fs from the right(50%)
			left = (now * 50)+"%";
			//3. increase opacity of next_fs to 1 as it moves in
			opacity = 1 - now;
			current_fs.css({'transform': 'scale('+scale+')'});
			next_fs.css({'left': left, 'opacity': opacity});
		}, 
		duration: 800, 
		complete: function(){
			current_fs.hide();
			animating = false;
		}, 
		//this comes from the custom easing plugin
		easing: 'easeInOutBack'
	});
});

$(".previous").click(function(){
	if(animating) return false;
	animating = true;
	
	current_fs = $(this).parent();
	previous_fs = $(this).parent().prev();
	
	//de-activate current step on progressbar
	$("#progressbar li").eq($("fieldset").index(current_fs)).removeClass("active");
	
	//show the previous fieldset
	previous_fs.show(); 
	//hide the current fieldset with style
	current_fs.animate({opacity: 0}, {
		step: function(now, mx) {
			//as the opacity of current_fs reduces to 0 - stored in "now"
			//1. scale previous_fs from 80% to 100%
			scale = 0.8 + (1 - now) * 0.2;
			//2. take current_fs to the right(50%) - from 0%
			left = ((1-now) * 50)+"%";
			//3. increase opacity of previous_fs to 1 as it moves in
			opacity = 1 - now;
			current_fs.css({'left': left});
			previous_fs.css({'transform': 'scale('+scale+')', 'opacity': opacity});
		}, 
		duration: 800, 
		complete: function(){
			current_fs.hide();
			animating = false;
		}, 
		//this comes from the custom easing plugin
		easing: 'easeInOutBack'
	});
});

$("#register_btn").click(function(){
	
	var username=$("#username").val();
	var password=$("#password").val();
	var config_password=$("#config_password").val();
	if(username==null||username==""){
		layer.msg('请输入用户名');
		return false;
	}
	if(username.length < 6){
		layer.msg('账号长度最低6位');
		return false;
	}
	if(password==null||password==""){
		layer.msg('请输入密码');
		return false;
	}
	
	if(password.length < 6){
		layer.msg('密码长度最低6位');
		return false;
	}
	
	if(config_password==null||config_password==""){
		layer.msg('请再次输入密码');
		return false;
	}
	
	if(password != config_password){
		layer.msg('密码输入不一致');
		return false;
	}
	
	var loading = layer.msg('注册中', {
		  icon: 16
		  ,shade: 0.01
		});
	
	var options = {
        success: function(data){
        	if(null != data && data == "success"){
        		layer.closeAll('loading');
            	layer.alert('注册成功,请登录', function(){
            		window.open('login.jsp','_self');
            	});
        	}else{
        		layer.closeAll('loading');
        		setTimeout(function(){
        			layer.tips('账号已存在，请重新输入', '#username',{tips: [2,'#ff5555']});
        		}, 3000);
        		
        	}
        },
        error : function(data){
        	layer.closeAll('loading');
        	layer.tips('注册失败', '#username');
        }
	 };
	$('#msform').ajaxForm(options).submit();
	
})