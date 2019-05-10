var timerSiteLoading;
SiteLoadingNum=0;

function preLoad(preLoadImgArr){
	var imgLoadAll = 0;
	var imgList = new Array();
	imgList=preLoadImgArr;
	
	$("img").each(function(){
		src=$(this).attr("src");
		// if(src.indexOf("http://")==-1 && src.indexOf("site_loading_p")==-1){
		// if(src.indexOf("site_loading_p")==-1){
			imgLoadAll++;
			imgList.push($(this).attr("src"));
		// }
	})
	imgList = getNoRepeat(imgList);
	// console.log(imgList);

	var timeout = 3000;
	var count = 0;
	var fire = false;
	var fireFn = function(){
		
		fire = true;
		clearTimeout(timerSiteLoading);
		$(".siteLoading .num").text("100%");
		$(".main").css("opacity",1);
		siteLoaded();
		$(".siteLoading").fadeOut(1000);
	}

	for(var i = 0, len = imgList.length; i < len; i++){
		var img = new Image();
		var loadFn = function(e){
			count++;
			per=Math.floor((count/len)*100);
			//$(".siteLoading .num").text(per+"% "+count+" : "+len);
			$(".siteLoading .num").text(per+"%");
			$(".siteLoading .line2").width(per+"%");

			bl=100/6;
			n=Math.floor(per/bl);

			if (count >= len && !fire) {
				fireFn();
			};
		}
		img.onload = loadFn;
		img.onerror = loadFn;
		img.src = imgList[i];
	}
}

//鍘婚櫎鏁扮粍涓噸澶嶅€�  
function getNoRepeat(s) {  
	return s.sort().join(",,").replace(/(,|^)([^,]+)(,,\2)+(,|$)/g,"$1$2$4").replace(/,,+/g,",").replace(/,$/,"").split(",");  
}

sendSiteLoading();
//Loading鍥惧眰
function sendSiteLoading(){
	html='<div class="siteLoading">'
	html+='	<div class="content" style="width:'+window.screen.availWidth+'px;height:'+window.screen.availHeight+'px">'
	html+='		<div class="num">0%</div>'
	html+='		<div class="line1"><div class="line2"></div></div>'
	// html+='		<div class="txt">绋嶅€欙紝鍔犺浇涓�...</div>'
	html+='		</div>'
	html+='</div>'
	document.write(html);
	// document.body.innerHTML=html;
}