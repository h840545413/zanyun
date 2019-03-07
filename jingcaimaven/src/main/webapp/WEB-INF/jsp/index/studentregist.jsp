<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>student</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<link href="/bootvalueap/css/bootvalueap.min.css"
	rel="stylesheet">
<script src="/js/jquery.min.js"></script>
<script src="/js/bootvalueap.min.js"></script>
<link rel="stylesheet" href="/css/zyunhomepage/zyhead.css">
<link rel="stylesheet" href="/css/zyunhomepage/zybutton.css">
<style type="text/css">
.showinfo{width: 200px;color: red;text-align: left;}
.td1{padding-right: 20px;text-align: right;}
.th2{text-align: left;width: 300px;}
</style>
<script type="text/javascript">
$(function(){
	
	$('#registbtn').on('click',function(){
		var flag=1;
		if(!checkinfo('operatorId')){ flag=0;};
		if(!checkinfo('password')){flag=0;};
		if(!checkinfo('rpassword')){flag=0;};
		if(!checkinfo('email')){flag=0;};
		if(!checkinfo('yzm')){flag=0;};
		if(!checkinfo('school')){flag=0;};
		if(!checkinfo('studentNo')){flag=0;};
		if(!checkinfo('majorClass')){flag=0;};
		if(!checkinfo('name')){flag=0;};
		
		
		if(flag==1){var txt=$('#studentRegistFrom').serialize();
		//alert(txt)
		if(new MyJqueryAjax('/index/studentregist',txt).request()=='success')
			{
		alert("注册成功！");
		window.location.href = "/";
			}}
		
	});
	
	$("input[type=text]").blur(function(){
		checkinfo($(this).attr('id'));
		
	//	alert($(this).attr('id'));
		
	});
	
	/* $("#operatorId").blur(function(){
		$(this).parent().next().text("success");
		//alert($(this).attr('id'));
	//	alert(1);
		
	}); */
	
	
});
function getyzm() {
	var  registemail=$('#email');
	if (!checkinfo('email')) { return false; }
	var info = $(".getyzm").html();
	alert( $(".getyzm").text());
	if (info == "获取验证码") {
		$(".getyzm").addClass("disabled");
		var waitTime = 60;
		timeOutCode("getyzm", waitTime);
		getEmailYzm();
	}
	if (info == "请重新获取") {
		$(".getyzm").addClass("disabled");
		var waitTime = 60;
		timeOutCode("getyzm", waitTime);
		getEmailYzm();
	}
}
function timeOutCode(id, waitTime) {
	if (waitTime == 0) {
		$("." + id).html("请重新获取");
		$(".getyzm").removeClass("disabled");
	} else {
		waitTime--;
		$("." + id).html('等待 '+waitTime + ' s ');
		setTimeout(function() {
			timeOutCode(id, waitTime);
		}, 1000);
	}
}
function getEmailYzm() {
	$.ajax({
		type : "post",
		url : "/index/creatregistemailyzm",
		dataType : "json",
		data : {
			Mailbox : $('#email').val()
		},
		success : function(result) {
		$("#hiddenyzm").val(result);
		}
	});

}
function checkinfo(id)
{
	var value='';
	var re = /\d+/;
	var reg = /[a-zA-Z]+/;
	var reb = /^[0-9a-zA-Z]+$/;
	if(id=='school'){
		value=$('#'+id).val();
		if(value==''){
			$('#'+id).parent().next().text("学校不能为空");
			return false;
		}
	}
	if(id=='majorClass'){
		value=$('#'+id).val();
		if(value==''){
			$('#'+id).parent().next().text("专业班级不能为空");
			return false;
		}
	}
	if(id=='name'){
		value=$('#'+id).val();
		if(value==''){
			$('#'+id).parent().next().text("姓名不能为空");
			return false;
		}
	}
	if(id=='studentNo'){
		value=$('#'+id).val();
		if(value==''){
			$('#'+id).parent().next().text("学号不能为空");
			return false;
		}
	}
if(id=='operatorId')
	{
	value=$('#'+id).val();
	if (value == '' || value == null) {
		$('#'+id).parent().next().text("账号不能为空");
		return false;
	} else {
		$('#'+id).parent().next().text("");
	}
	if (value.length >= 4 && reb.test(value)) {
		$('#'+id).parent().next().text("");
	} else {
		$('#'+id).parent().next().text("账号必须不小于4位数且为字母或者数字");
		$('#'+id).val('');
		return false;
	}
	if (value.length <= 16 && reb.test(value)) {
		
	var result=	new MyJqueryAjax('/index/checkloginname', { loginname : value }).request();
	if(result!='1'){;return true;}else{$('#'+id).parent().next().text("用户名已经被使用");return false;}
	} else {

		$('#'+id).parent().next().text("账号必须不超过16位数且为字母或者数字");
		$('#'+id).val('');
		return false;
	}
	}
	if(id=='password'){
		value=$('#'+id).val();
		if (value == '' || value == null) {
			$('#'+id).parent().next().text("密码不能为空");
			return false;
		} else {
			$('#'+id).parent().next().text("");
		}
		if (re.test(value) && reg.test(value)
				&& value.length >= 6) {

			$('#'+id).parent().next().text("");
			return true;
		}
		if (!re.test(value) || !reg.test(value) || value.length < 6) {
			$('#'+id).parent().next().text("密码必须不小于6位数且同时为字母和数字");
			$('#'+id).val('');
			return false;
		}
		return true;
	}
	if(id=='rpassword')
		{
		value=$('#'+id).val();
		var pass=$("#password").val();
		if(value==pass){return true;}
		$('#'+id).parent().next().text("密码不一致");
		return false;
		}
	if(id=='email')
		{value=$('#'+id).val();
		var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;
		if (value == '') {
			$('#'+id).parent().next().text("邮箱不能为空!");
			return false;
		}
		// var flag = reg.test(Mailbox);

		if (reg.test(value) == true) {
			var flag = new MyJqueryAjax('/index/findemail', { email : value}).request();
			if (flag == '"0"') {
				$('#'+id).parent().next().text("邮箱已经被使用!");
				return false;
			}
			$('#'+id).parent().next().text("");
			return true;
		} else {
			$('#'+id).parent().next().text("请输入正确的邮箱地址!");
			return false;
		}
		}
	if(id=='ezm')
		{
		value=$('#'+id).val();
		
		if(value==''){	$('#'+id).parent().next().text("验证码不能为空");return false;}
		var hiddenyzm=$('#hiddenyzm').val();
		if(hiddenyzm!=value){
			$('#'+id).parent().next().text("验证码错误");
		return false;}
		$('#'+id).parent().next().text("");return true;
		}
	$('#'+id).parent().next().text("");
	return true;
}
MyJqueryAjax = function(v_url, data, func, dataType) {
	this.url = v_url;
	this.data = data;
	this.func = func;
	this.request = function() {
		var v_response;
		$.ajax({
			async : false,
			url : v_url,
			cache : false,
			data : data,
			type : "POST",
			dataType : dataType == null ? "text" : dataType,
			error : function(XMLHttpRequest, textStatus, errorThrown) {
			},
			success : (func !== null && func != undefined) ? func : function(
					req) {
				v_response = req;
			}
		});
		return v_response;
	};
}

</script>
</head>
<body style="height: 100%;">
<div style="width: 100%;text-align: left;height: 50px;">
	<header id="masthead" class="site-header">
			<div class="head_logo">
				<img src="/images/zynews/logo-01.png">
			</div>
	</header>
	</div>
<div style="width: 100%;text-align: center;">
<h2 style="">赞云·云家 学生会员注册</h2>
<form id="studentRegistFrom">
<input type="hidden" id="hiddenyzm">
<table style="width: 600px;margin: auto auto;">
<tbody>
<tr><td class="td1">账号：</td><td class="td2"><input type="text" id="operatorId" name="operatorId"></td><td class="showinfo"></td></tr>
<tr><td  class="td1">密码：</td><td  class="td2"><input type="text" id="password" name="password"></td><td  class="showinfo"></td><tr>
<tr><td  class="td1">确认密码：</td  class="td2"><td><input type="text" id="rpassword" name="rpassword"></td class="showinfo"><td></td></tr>
<tr><td  class="td1">邮箱：</td><td  class="td2"><input type="text" id="email" name="email"></td><td class="showinfo"></td></tr>
<tr><td  class="td1">验证码：</td><td  class="td2"><input type="text" id="ezm" name="ezm" style="width: 88px;"><button type="button" class="btn btn-info getyzm" onclick="getyzm()" >获取验证码</button></td><td class="showinfo"></td></tr>
<tr><td></td><td></td><td></td></tr>
<tr><td  class="td1">学校：</td><td  class="td2"><input type="text" id="school" name="school"></td><td class="showinfo"></td></tr>
<tr><td  class="td1">专业班级：</td><td  class="td2"><input type="text" id="majorClass" name="majorClass"></td><td class="showinfo"></td></tr>
<tr><td  class="td1">姓名：：</td><td  class="td2"><input type="text" id="name" name="name"></td><td class="showinfo"></td></tr>
<tr><td  class="td1">学号：</td><td  class="td2"><input type="text" id="studentNo" name="studentNo"></td><td class="showinfo"></td></tr>
</tbody>
</table>

</form>
<button class="btn btn-info" id="registbtn" style="width: 200px;height: 30px;margin-top: 50px;">注册</button>

</div>
	<div class="news_button_b" style="bottom: 0;position: absolute;">备案号：苏ICP备14050130号&nbsp;&nbsp;常州赞云软件技术有限公司</div>
</body>
</html>
