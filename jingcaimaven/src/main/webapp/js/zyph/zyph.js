$(function() {
	init();
	picchange();
	$(".s1").click(function() {
		panduan();
		$("#masthead").css("top", "0");
		$("#masthead").css("background-color", "transparent");
		$(".list-inline li a").css("color", "#aaaaaa");
		$(".list div").css("top", "0");
		$("header").css("height", "100px");
		$(".site-header").css("padding", "20px 0");
	});
	$(".s2").click(function() {
		panduan();
		$("#masthead").css("top", "-20");
		$("#masthead").css("background-color", "rgba(120,120,120,0.8)");
		$(".list-inline li a").css("color", "white");
		$("header").css("height", "80px");
		$(".site-header").css("padding-top", "10px");
		listchange();
	});
	$(".ha").click(function() {
		$.fn.fullpage.moveSectionDown();
		panduan();
		listchange();
		linechange();
	});
	
	line(); wheel();
	var loginzh=$('#zh');
	var loginmm=$('#mm');
	var registzh=$('#zh2');
	var registmm=$('#mm2');
	var registmm2=$('#mm3');
	var registemail=$('#email');
	var registyzm=$('#yzm');
	loginzh.blur(function(){checkinput(loginzh.val(),'loginzh');});
	loginmm.blur(function(){checkinput(loginmm.val(),'loginmm');});
	registzh.blur(function(){checkinput(registzh.val(),'registzh');});
	registmm.blur(function(){checkinput(registmm.val(),'registmm');});
	registmm2.blur(function(){checkinput(registmm2.val(),'registmm2');});
	registemail.blur(function(){checkinput(registemail.val(),'registemail');});
	registyzm.blur(function(){checkinput(registyzm.val(),'registyzm');});
	$(".loginbt") .on( "click", function() {		
	if (!checkinput(loginzh.val(),'loginzh')) { return false; }
	if (!checkinput(loginmm.val(),'loginmm')) { return false; }
	$.ajax({type : "post",url : "/index/checklogin",dataType : "json",data : {loginName : loginzh.val(),password : loginmm.val()},success : function(result) {if (result == '1') {window.location.href = "/index/personalcenter.html";}else{ $('#alerttext').html('账号与密码不匹配！'); $('#alert').modal('show'); return ;}}});});
	
	$(".registbtn").on("click", function() {
	
	
		if (!checkinput(registzh.val(),'registzh')) { return false; }
		if (!checkinput(registmm.val(),'registmm')) { return false; }
		if (!checkinput(registmm2.val(),'registmm2')) { return false; }
		if (!checkinput(registemail.val(),'registemail')) { return false; }
		if (!checkinput(registyzm.val(),'registyzm')) { return false; }
	
		var loginName = $("#zh2").val();
		var password = $("#mm2").val();
		var email=$("#email").val();
		var yzm=$("#yzm").val();
		$.ajax({
			type : "post",
			url : "/index/regist",
			dataType : "json",
			data : {
				operatorId : loginName,
				password : password,
				email:email,
				yzm:yzm
			},
			success : function(result) {
			
				$('#indexModal').modal('hide');
if(result=='success'){ $('#alerttext').html('注册成功！'); $('#alert').modal('show'); return ; }else { $('#alerttext').html('账号已经存在！'); $('#alert').modal('show'); return ; }}
});
	});
	$('#indexModal').on('show.bs.modal', function() { $("#login").click(); });
	$('#myCarousel') .on( 'slide.bs.carousel', function() {
						var id = $(".carousel-inner .active .carousel-caption") .attr('id');
						$('#' + id).addClass('animated fadeInDown');
						$('#' + id) .one( 'webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend', function() { $('#' + id).removeClass('animated'); $('#' + id).removeClass( 'fadeInDown');	 }); });
});




/**********************************************************************************************************************************************************/


/**个人中心弹出层*/
$(document).click( function(e) { if ($('.personal-dropdown').is(':hidden')) { if ($(e.target).is('.mine') || $(e.target).parents('.mine').length > 0) { $('.personal-dropdown').slideDown();} else { } } else { $('.personal-dropdown').slideUp(); } });
/**浏览器变化*/
$(window).resize(function() { $(".lazy").css('height', document.documentElement.clientHeight + 'px'); $(".lazy").css('width', document.documentElement.clientWidth + 'px');});



/**********************************************************************************************************************************************************/
function init()
{
	//输入框焦点
	$('.modaldiv input').on('focus',function(){ $(this).parent().css("border","1px solid #00FFFF");});
	$('.modaldiv input').on('blur',function(){ $(this).parent().css("border","1px solid #DCDCDC");});
		
	//banner全屏
	$(".section .lazy").css("height", document.documentElement.clientHeight + 'px'); $("#fullpage").fullpage();
	//初始化效果
	$('#first_first1').addClass('animated fadeInDown');
	$('#first_first1').one('webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend', function() { $('#first_first1').removeClass('animated'); $('#first_first1').removeClass('fadeInDown');});
	$('#first_first2').addClass('animated fadeInDown');
	$('#first_first2') .one( 'webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend', function() { $('#first_first2').removeClass('animated'); $('#first_first2').removeClass('fadeInDown');});
	$('#first_first3').addClass('animated fadeInDown');
	$('#first_first3') .one( 'webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend', function() { $('#first_first3').removeClass('animated'); $('#first_first3').removeClass('fadeInDown'); });
	
	var po = $(".ps1");
	po.mouseover(function() { $(this).children(".ps3").removeClass('display'); $(this).children(".ps2").children(".picword").css("color", "white") .css("background-color", "#46dcff");$(this).children(".ps2").children(".picword").find("div").css("color", "white");});
	po.mouseout(function() { $(this).children(".ps3").addClass('display'); $(this).children(".ps2").children(".picword").css("color", "white") .css("background-color", "white"); $(this).children(".ps2").children(".picword").find("div").css("color", "#333333");});

	var watchmore = $("#watchmore"); watchmore.mouseover(function() { watchmore.attr('src', '/images/rjxz/watchmore-click.png'); });
	watchmore.mouseout(function() { watchmore.attr('src', '/images/rjxz/watchmore.png'); });
	var down = $("#down");
	down.mouseover(function() { down.attr('src', '/images/rjxz/down-click.png'); });
	down.mouseout(function() { down.attr('src', '/images/rjxz/down.png'); });

	/****右侧悬浮*****/
	$("#hptel").mouseover(function() { $(".hp_tel").css("width", "100%"); $(".hp_tel").text("0760-85213992"); });
	$("#hptel").mouseout(function() { $(".hp_tel").css("width", "0"); 	$(".hp_tel").text(""); });

	$("#hpqq").mouseover(function() { $(".hp_qq").css("width", "100%"); $(".hp_qq").text("992321590"); });
	$("#hpqq").mouseout(function() { $(".hp_qq").css("width", "0"); $(".hp_qq").text(""); });
	$('#hpwechat') .popover( { trigger : 'hover',/**鼠标以上时触发弹出提示框*/ html : true,/** 开启html 为true的话，data-content里就能放html代码了*/ content : "<img src='/jingcaimaven/images/zycase/wechat1.jpg' style='width:150px;heigth:150px;'>"});

	$("#login").click(function() {
		$("#login").css({ color : "#46dcff" });
		$("#register").css({ color : "black" });
		$("#logindiv").removeClass("dis");
		$("#registerdiv").addClass("dis");
		$(".ts span").text('');
		$("input[type='text']").val('');
		$("input[type='password']").val('');
		$("#ts6").text('');
	});
	$("#register").click(function() {
		$("#register").css({ color : "#46dcff" });
		$("#login").css({ color : "black" });
		$("#registerdiv").removeClass("dis");
		$("#logindiv").addClass("dis");
		$(".ts span").text("");
		$("input[type='text']").val('');
		$("input[type='password']").val('');
		$("#ts6").text('');
	});
}

function jpbutton1() {

	var show1 = $("#show1");
	var show2 = $("#show2");
	var standard = $("#standard");
	var cust = $("#cust");
	show1.removeClass('display');
	show2.addClass('display');
	standard.addClass('btn-info');
	cust.removeClass('btn-info');

}
function jpbutton2() {

	var show1 = $("#show1");
	var show2 = $("#show2");
	var standard = $("#standard");
	var cust = $("#cust");
	show2.removeClass('display');
	show1.addClass('display');
	cust.addClass('btn-info');
	standard.removeClass('btn-info');
}

function line() {
	$("ul li").mouseover( function() {

			

				var line = $(".line");
				if (line.css("display") == "none")
					line.show();
				line.stop().animate( { width : $(this).width(), left : parseInt($(this).position().left) - parseInt($('.list').css('marginLeft')) + 15 + "px"}, 300);});

	$("#menu").mouseout(function() {

		linechange();
	});
}

function wheel() {
	$(window).mousewheel(function() {
		panduan();
		if ($('body').hasClass('fp-viewing-0-0')) {

			$("#masthead").css("top", "0");
			$("#masthead").css("background-color", "transparent");
			$(".list-inline li a").css("color", "#aaaaaa");
			$(".list div").css("top", "0");
			$("header").css("height", "100px");
			$(".site-header").css("padding", "20px 0");
		} else {

			$("#masthead").css("top", "-20");
			$("#masthead").css("background-color", "rgba(120,120,120,0.8)");
			$(".list-inline li a").css("color", "white");
			/* $(".list div").css("top", "20"); */
			$("header").css("height", "80px");
			$(".site-header").css("padding-top", "10px");
		}
		linechange();
	});

}
// 导航栏大小变化
function listchange() {
	$("#masthead").css("top", "-20");
	$("#masthead").css("background-color", "rgba(120,120,120,0.8)");
	$(".list-inline li a").css("color", "white");
	/* $(".list div").css("top", "20"); */
	$("header").css("height", "80px");
	$(".site-header").css("padding-top", "10px");
}



/*
 * function input(){ $("input").focus(function(){
 * $(this).attr('placeholder',''); }); }
 */
// 登录按钮提交
function openlogin() {
	$('body').css("overflow", "hidden");
	$('#indexModal').modal('show');
	$('body').css("overflow", "hidden");
}
function closelogin() {
	$('#indexModal').modal('hide');
}



/*function CloseWebPage() {
	if (navigator.userAgent.indexOf("MSIE") > 0) {
		if (navigator.userAgent.indexOf("MSIE 6.0") > 0) {
			window.opener = null;
			window.close();
		} else {
			window.open('', '_top');
			window.top.close();
		}
	} else if (navigator.userAgent.indexOf("Firefox") > 0) {
		window.location.href = 'about:blank ';
	} else {
		window.opener = null;
		window.location.href = "about:blank";
		window.close();
	}
}
*/
// 查看浏览器版本
/*function getOs() {
	if (navigator.userAgent.indexOf("MSIE") > 0) {
		return "MSIE";
	}
	if (navigator.userAgent.indexOf("Firefox") > 0) {
		return "Firefox";
	}
	if (navigator.userAgent.indexOf("Chrome") > 0) {
		return "Chrome";
	}
	if (navigator.userAgent.indexOf("Camino") > 0) {
		return "Camino";
	}
	if (navigator.userAgent.indexOf("Gecko/") > 0) {
		return "Gecko";
	}
}*/
// 图片预加载
function picchange() {
	$('img[data]').load(function() {
		var __this__ = $(this);
		var url = __this__.attr('data');
		var src = __this__.attr('src');

		if (url == '' || url == src)// 这里判断如果图片实际地址不存在或者已经加载不处理
		{

			return;
		}
		var img = new Image();// 实例化一个图片的对象
		img.src = url;// 将要显示的图片加载进来
		if (img.complete)// 如果图片已经加载存在浏览器缓存中直接处理
		{
			__this__.attr('src', url);// 将要显示的图片替换过来
			return;
		}
		img.onload = function() {// 要显示的图片加载完成后做处理
			__this__.attr('src', url);
		};
	});
}
// 导航栏颜色变化
function panduan() {
	if ($('body').hasClass('fp-viewing-0-0')) {
		$("ul li").removeClass('active');
		$('#sy1').addClass('active');
		$('#seventh_seventh').addClass('animated fadeInDown');
		$('#seventh_seventh')
				.one(
						'webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend',
						function() {
							$('#seventh_seventh').removeClass('animated');
							$('#seventh_seventh').removeClass('fadeInDown');

						});
	}
	if ($('body').hasClass('fp-viewing-1-0')) {
		$("ul li").removeClass('active');
		$('#sy2').addClass('active');
		$('#second_second').addClass('animated fadeInDown');
		$('#second_second')
				.one(
						'webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend',
						function() {
							$('#second_second').removeClass('animated');
							$('#second_second').removeClass('fadeInDown');

						});
	}
	if ($('body').hasClass('fp-viewing-2')) {
		$("ul li").removeClass('active');
		$('#sy3').addClass('active');
		$('#third_third').addClass('animated fadeInDown');
		$('#third_third')
				.one(
						'webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend',
						function() {
							$('#third_third').removeClass('animated');
							$('#third_third').removeClass('fadeInDown');

						});
	}
	if ($('body').hasClass('fp-viewing-3')) {
		$("ul li").removeClass('active');
		$('#sy4').addClass('active');
		$('#show1').addClass('animated fadeInDown');
		$('#show1')
				.one(
						'webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend',
						function() {
							$('#show1').removeClass('animated');
							$('#show1').removeClass('fadeInDown');

						});
	}
	if ($('body').hasClass('fp-viewing-4')) {
		$("ul li").removeClass('active');
		$('#sy5').addClass('active');
		$('#fifth_fifth').addClass('animated fadeInDown');
		$('#fifth_fifth')
				.one(
						'webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend',
						function() {
							$('#fifth_fifth').removeClass('animated');
							$('#fifth_fifth').removeClass('fadeInDown');

						});
	}
	if ($('body').hasClass('fp-viewing-5')) {
		$("ul li").removeClass('active');
		$('#sy6').addClass('active');
		$('#sixth_sixth').addClass('animated fadeInDown');
		$('#sixth_sixth')
				.one(
						'webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend',
						function() {
							$('#sixth_sixth').removeClass('animated');
							$('#sixth_sixth').removeClass('fadeInDown');

						});
	}
	if ($('body').hasClass('fp-viewing-6')) {
		$("ul li").removeClass('active');
		$('#sy7').addClass('active');
		$('#seventh_seventh').addClass('animated fadeInDown');
		$('#seventh_seventh')
				.one(
						'webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend',
						function() {
							$('#seventh_seventh').removeClass('animated');
							$('#seventh_seventh').removeClass('fadeInDown');

						});

	}
}
function sleep(numberMillis) {
	var now = new Date();
	var exitTime = now.getTime() + numberMillis;
	while (true) {
		now = new Date();
		if (now.getTime() > exitTime)
			return;
	}
}
// 导航栏线条变化
function linechange() {
	var line = $(".line");
	if ($("#sy1").hasClass('active')) {
		line.stop().animate({
			left : "35px"
		});
	}
	if ($("#sy2").hasClass('active')) {
		line.stop().animate({
			left : "150px"
		});
	}
	if ($("#sy3").hasClass('active')) {
		line.stop().animate({
			left : "260px"
		});
	}
	if ($("#sy4").hasClass('active')) {
		line.stop().animate({
			left : "374px"
		});
	}
	if ($("#sy5").hasClass('active')) {
		line.stop().animate({
			left : "491px"
		});
	}
	if ($("#sy6").hasClass('active')) {
		line.stop().animate({
			left : "605px"
		});
	}
	if ($("#sy7").hasClass('active')) {
		line.stop().animate({
			left : "720px"
		});
		
	}
}