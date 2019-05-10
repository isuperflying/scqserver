<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=5"/>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
<meta name="viewport" content="width=320, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, minimal-ui, user-scalable=no,target-densityDpi=super-high-dpi">
<meta name="renderer" content="webkit">
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="apple-mobile-web-app-status-bar-style" content="black" />
<meta name="format-detection" content="telphone=no, email=no" />
<meta name="HandheldFriendly" content="true">
<meta name="MobileOptimized" content="320">
<meta name="browsermode" content="application">
<meta name="x5-page-mode" content="app">
<meta name="msapplication-tap-highlight" content="no">
<meta name="format-detection" content="telephone=no">
<link rel="stylesheet" href="../css/photo/style.css-1.css">
<link rel="stylesheet" href="../css/photo/font-awesome.min.css">
<script src="../js/photo/jquery.js" ></script>
<script src="../js/photo/GSAP/TweenMax.min.js"></script>
<script src="../js/photo/megapix-image.js"></script>
<script src="../js/photo/exif.js"></script>
<script src="../js/photo/hammer.min.js"></script>
<script src="../js/photo/jquery.hammer.js"></script>
<script src="../js/photo/mReSizeImg.js-1"></script>
<script src="../js/photo/preLoad.js"></script>
<script src="../js/photo/common.js"></script>
<title>照片旋转</title>
</head>
<body>
	<div class="shareText">
		<img src="../images/logo_dzq.jpg" alt="颜值">
		<h1>测测你的颜值配拿多高工资</h1>
		<h2>遇见你之后，再看其他人，都不想睁开眼睛！</h2>
	</div>
	<div class="siteMain siteMaker isTableCell fullScreenSzie">
		<div class="mainContent">

			<div class="letter">
				<div class="letterTop letterTop1"><img src="../images/letter_1.png"></div>
				<div class="letterContent">
					<div class="title">-- 传颜照，查颜值 --</div>
					<div class="MyHead">
						<img src="../images/myHead_bg.png">
						<div class='container c0'>
							<img src="../images/empty.png">
							<input type=file id="ftu0" name="fileToUpload0" accept="image/*" >
							<canvas class="myCanvas"></canvas>
						</div>
						<canvas class="photoResult" width='534' height='534'></canvas>
					</div>
					<div class="control">
						<div class="b b0"><i class="fa fa-search-plus"></i></div>
						<div class="b b1"><i class="fa fa-search-minus"></i></div>
						<div class="b b2"><i class="fa fa-rotate-left"></i></div>
						<div class="b b3"><i class="fa fa-rotate-right"></i></div>
					</div>
					<div class="btns">
						<div class="b b0">查颜值</div>
						<div class="b b1">换张图</div>
					</div>
				</div>
				<div class="letterDown"><img src="../images/letter_0.png"></div>
			</div>
		</div>
	</div>
	
<script>
	var photoUploader = new mReSizeImg();
	//加载...
	$(function(){
		var preLoadImgList = new Array();
		preLoad(preLoadImgList);
	})

	function siteLoaded(){
		photoUploader.photoContainer=$(".container");
		photoUploader.onModifyComplete(function(data){
			d=data;
			saveCanvasData(d);
		})
		photoUploader.init();

		$(".control .b0").hammer({}).on("tap", function(){
			buttonAnmi($(this),"lc")
			photoUploader.zoomIn();
		})
		$(".control .b1").hammer({}).on("tap", function(){
			buttonAnmi($(this),"lc")
			photoUploader.zoomOut();
		})
		$(".control .b2").hammer({}).on("tap", function(){
			buttonAnmi($(this),"lc")
			photoUploader.rotate(-1);
		})
		$(".control .b3").hammer({}).on("tap", function(){
			buttonAnmi($(this),"lc")
			photoUploader.rotate(1);
		})
		$(".btns .b0").hammer({}).on("tap", function(){
			buttonAnmi($(this),"lc")
			uploadUserinfo();
		})
		$(".btns .b1").hammer({}).on("tap", function(){
			buttonAnmi($(this),"lc")
			photoUploader.remove();
		})

		// anmiArr()

		// $('.imgReset').css('vertical-align','top');
	}

	function uploadUserinfo(){
		PP=$(".container").find("img").attr("src")
		if(PP.indexOf("empty.png")>0){
			alert('请先上传颜照！');
			return false;
		}

		D={};
		// D.myPhoto0=$(".photoResult")[0].toDataURL("image/jpeg",0.9).split(",")[1];
		D.myPhoto0=$(".photoResult")[0].toDataURL("image/jpeg",0.9);

		$.ajax({
			type: "POST",
			url:"/handler/savetofile",
			data:D.myPhoto0,
			contentType:'text/xml',
			dataType:'text',
			success: function(data) {
				if(data!==''){
					//alert(data.msg);
					// pic='http://img.dianziq.com/img/'+data;
					url='index.html?pic='+encodeURIComponent(data)+'&type='+Math.floor(Math.random()*20)+'#aftermake';
					location.href=url;
				}else{
					alert('上传出错！');
				}
			},
			beforeSend: function(){
				$(".ajaxLoading").show();
			},
			complete: function(){
				$(".ajaxLoading").hide();
			}
		})

	}
	//制作画布合成图片(未有宣言)
	function saveCanvasData(photoData){
		ctx=$(".photoResult")[0].getContext("2d");
		obj=$(".container img");
		kuanw=534;
		kuanh=534;
		bl=(kuanw/obj.parent().width())
		dx=	photoData.x * bl;
		dy= photoData.y * bl;
		s = photoData.scale;
		r = photoData.rotation;

		// $('.testLayer').text("保存到画布"+Math.round(Math.random()*999999999));
		//原始图尺寸
		ow=obj.width()
		oh=obj.height()
		//放到Canvas后缩放到和编辑框一样的比例尺寸
		aw=obj.width()*bl
		ah=obj.height()*bl
		toL=aw/2+dx
		toT=ah/2+dy

		//清除画布
		ctx.clearRect(-10000,-10000,100000,100000);
		//保存画布状态
		ctx.save();
		ctx.translate(toL, toT); 
		ctx.rotate(r*Math.PI/180);
		ctx.scale(s*bl, s*bl);
		ctx.drawImage(obj[0],-ow/2,-oh/2);
		//恢复保存前的画布状态，避免变形，走位，旋转
		ctx.restore();
		// alert("保存到画布");
		console.log("保存到画布");
	}

	//禁止IOS回弹;
	document.addEventListener("touchmove", function(evt){
		// evt.preventDefault();
	}, true);
	//开场
	function anmiArr(){
		kH=$(window).height();
		anmi = new TimelineLite();
		anmi
			.from($('.letter'),3,{scale:0, rotation:360, ease:Elastic.easeOut},'+=1')
			.to($('.letterTop0'),0.3,{scaleY:0, ease:Expo.easeIn, transformOrigin:"center top"})
			.from($('.letterTop1'),0.3,{scaleY:0, ease:Expo.easeOut, transformOrigin:"center bottom"})
		;
	}
</script>
</body>
</html>

