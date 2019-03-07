$(document).ready(function() {
	changeDiv();
	/* input(); */
	decide();
	
	$(".loginbt").on("click",function(){
		var loginName=$("#zh").val();
		var password=$("#mm").val();
		alert(loginName);
		$.ajax({
			type:"post",
			url:"/jingcaimaven/index/checklogin",
			dataType: "json",
			data:{loginName:loginName,password:password},
			success:function(result){
				alert(result);
		//window.location.href="/zanyunmaven/index/personalcenter";}
			}
	});
	
});
});
function changeDiv() {
	$("#login").click(function() {
		$("#login").css({
			color : "#46dcff"
		});
		$("#register").css({
			color : "black"
		});
		$("#logindiv").removeClass("dis");
		$("#registerdiv").addClass("dis");
		$(".ts span").text('');
		$("input[type='text']").val('');
		$("input[type='password']").val('');
		$("#ts6").text('');
	});
	$("#register").click(function() {
		$("#register").css({
			color : "#46dcff"
		});
		$("#login").css({
			color : "black"
		});
		$("#registerdiv").removeClass("dis");
		$("#logindiv").addClass("dis");
		$(".ts span").text("");
		$("input[type='text']").val('');
		$("input[type='password']").val('');
		$("#ts6").text('');
	});
}

/*
 * function input(){ $("input").focus(function(){
 * $(this).attr('placeholder',''); }); }
 */
// 登录按钮提交
function openlogin()
{
	$('body').css("overflow","hidden");
	$('#myModal').modal('show');
	$('body').css("overflow","hidden");
}
function closelogin()
{
	$('#myModal').modal('hide');
}
function check() {
	if ($("#qzh").val() == '') {
		$("#ts1").text("*输入账号不能为空");
	} else {
		$("#ts1").text("");
	}
	if ($("#qmm").val() == '') {
		$("#ts2").text("*输入密码不能为空");
	} else {
		$("#ts2").text("");
	}
}

function decide() {
	var re = /\d+/;
	var reg = /[a-zA-Z]+/;
	var reb = /^[0-9a-zA-Z]+$/;
	$("#zh").blur(function() {
		if ($("#zh").val() == '' || $("#zh").val() == null) {
			$("#ts3").text("*账号不能为空");
			return false;
		} else {
			$("#ts3").text("");
		}
		if ($("#zh").val().length >= 4 && reb.test($("#zh").val())) {
			$("#ts3").text("");
		}else{
			$("#ts3").text("*账号必须不小于4位数且为字母或者数字");
			$("#zh").val('');
			return false;
		}
	});
	$("#mm1").blur(
			function() {
				if ($("#mm1").val() == '' || $("#mm1").val() == null) {
					$("#ts4").text("*密码不能为空");
					return false;
				} else {
					$("#ts4").text("");
				}
				if (re.test($("#mm1").val()) && reg.test($("#mm1").val())
						&& $("#mm1").val().length >= 6) {

					$("#ts4").text("");
				}
				if (!re.test($("#mm1").val()) || !reg.test($("#mm1").val())
						|| $("#mm1").val().length < 6) {
					$("#ts4").text("*密码必须不小于6位数且同时为字母和数字");
					$("#mm1").val('');
					return false;
				}
			});
	$("#mm2").blur(
			function() {
				if ($("#mm1").val() == $("#mm2").val()
						&& $("#mm1").val() !== '' && $("#mm2").val() !== '') {
					$("#ts5").text("");
				} else {
					$("#mm2").val('');
					$("#ts5").text("*密码不一致");
				}
			});
}

// 注册按钮提交
function tj() {
	if ($("#zh").val() !== '' && $("#mm1").val() == $("#mm2").val()
			&& $("#mm1").val() !== '' && $("#mm2").val() !== ''
			&& $('.FengCheck').is(':checked')) {
		$(".ts span").text("");	
		$("#ts6").text("");
		alert("注册成功！");
	} else {
		if ($("#zh").val() == '' || $("#zh").val() == null) {
			$("#ts3").text("*账号不能为空");
		}
		if ($("#mm1").val() == '' || $("#mm1").val() == null) {
			$("#ts4").text("*密码不能为空");
		}
		if ($("#mm1").val() !== $("#mm2").val() || $("#mm2").val() == ''
				|| $("#mm2").val() == null) {
			$("#ts5").text("*密码不一致");
		}
		if ($('.FengCheck').is(':checked') == false) {
			$("#ts6").text("*请阅读用户注册协议！");
		}
		return false;
	}
}
function CloseWebPage() {
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

// 查看浏览器版本
function getOs() {
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
}
