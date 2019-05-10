	//
	CSSPlugin.defaultTransformPerspective = 600;

	//
	$("body").prepend('<div class="testLayer" style="position: fixed;left: 0;top: 0;background:#fff;z-index:9999999;word-break: break-all;min-height:10%;"></div>')
	//ajaxLoading
	$("body").prepend('<div class="ajaxLoading"></div>')

 	$(function(){
 		// $('.letterDown').click(function(){
 		// 	location.reload();
 		// });
		setFullScreenSzie();
	});
	
	$(window).resize(function(){
		setFullScreenSzie();
	})
	
	//
	function buttonAnmi(obj,dir){
		switch(dir){
			case "lc":
				align="left center";
				break;
			case "rc":
				align="right center";
				break;
			case "cc":
				align="center center";
				break;
			case "cb":
				align="center bottom";
				break;
			default :
		}
		// TweenMax.fromTo(obj,0.05,{scale:1},{autoAlpha:0.6,repeat:1,yoyo:true, transformOrigin:align})
		TweenMax.to(obj,0.1,{autoAlpha:0.6,repeat:1,yoyo:true})

	}
	
	//
	function setFullScreenSzie(){
		// alert($(window).height())
		$(".fullScreenSzie").each(function(){
			toW=$(window).innerWidth();
			toH=$(window).height();
	
			$(this).width(toW);
			$(this).height(toH);
		});
	}

	//
	function setBGSize(ow,oh){
		bl=ow/oh;
		sw=$(window).width();
		sh=$(window).height();
		bl2=sw/sh;
		if(bl>bl2){
			$('.dynamicBG').css("background-size","auto 100%");
			$('.dynamicBgShowAll').css("background-size","100% auto");

		}else{
			$('.dynamicBG').css("background-size","100% auto");
			$('.dynamicBgShowAll').css("background-size","auto 100%");
		}
	}	
	
	//
	(function($){
		$.getUrlParam = function(name){
		var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
		var r = window.location.search.substr(1).match(reg);
		if (r!=null) return decodeURI(r[2]); return null;}
	})(jQuery);
	
	function getRandom(){
		return Math.round(Math.random()*999999999);
	}

	//
	//document.write('<img src="images/cover400.jpg" style="width:0px;height:0px;">');