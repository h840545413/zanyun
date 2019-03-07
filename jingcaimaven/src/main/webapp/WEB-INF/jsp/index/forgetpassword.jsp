<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>赞云·云家</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<style type="text/css">
.modaldiv
{width: 300px;height: 42px;line-height:40px;text-align: left;margin: auto auto;border: 1px solid #DCDCDC;padding-left: 20px;}
.modaldiv input[type='text']
{
	width: 250px;margin-left: 10px;height: 40px;line-height: 40px;border:0;font-size: 14px;
}
.modaldiv input[type='password']
{
	width: 250px;margin-left: 10px;height: 40px;line-height: 40px;border:0;font-size: 14px;
	
}
.ts{height: 20px;width: 300px;margin:auto auto;text-align: left;padding-left: 20px;}
</style>
<script type="text/javascript" src="/js/jquery.min.js"></script>
<script type="text/javascript" src="/js/bootstrap.min.js"></script>
<script type="text/javascript">
$(function(){
	
	var email=$('#email');
	var yzm=$('#yzm');
	email.blur(function(){checkinput(email.val(),'email');});
	yzm.blur(function(){checkinput(yzm.val(),'yzm');});
	$('#resetpassword').on('click',function(){
		if (!checkinput(email.val(),'email')) { return false; }
		if (!checkinput(yzm.val(),'yzm')) { return false; }
		
	});
});
function checkinput(str,type)
{
	var re = /\d+/;
	var reg = /[a-zA-Z]+/;
	var reb = /^[0-9a-zA-Z]+$/;
	
	if(type=="email")
		{
	
		var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;
		if (str == '') {
			$("#msgts").html("邮箱不能为空!");
			return false;
		}
		// var flag = reg.test(Mailbox);

		if (reg.test(str) == true) {
			var flag = new MyJqueryAjax('/index/findemail', { email : str}).request();
			if (flag != '"0"') {
				$("#msgts").html("*邮箱尚未注册!");
				return false;
			}
			$("#msgts").html("");
			return true;
		} else {
			$("#msgts").html("*请输入正确的邮箱地址!");
			return false;
		}
		}
	if(type=="yzm")
		{
		if(str==''){	$("#tsyzm").html("*验证码不能为空");return false;}
		var hiddenyzm=$('#hiddenyzm').val();
		if(hiddenyzm!=str){
			$("#tsyzm").html("*验证码错误");
		return false;}
		$("#tsyzm").html("");return true;
		}
	
}
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
		url : "/index/createresetpasswordyzm",
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
<body>


	
	
	
	<div class="modaldiv"
		style="width: 300px;height: 42px;line-height:40px;text-align: left;margin: auto auto;border: 1px solid #DCDCDC;padding-left: 20px;">
		<img src="/images/icon/lock.png"><input id="email" type="text"
			placeholder="邮箱" />
	</div>
	<div class="ts">
		<span style="font-size: 12px;color: red" id="msgts"></span>
	</div>
	<div class="modaldiv"
		style="width: 300px;height: 42px;line-height:40px;text-align: left;margin: auto auto;border: 1px solid #DCDCDC;padding-left: 20px;">
		<img src="/images/icon/lock.png"><input id="yzm" type="text"
			style="width: 150px;" placeholder="验证码" />
		<button type="button" class="btn btn-info" onclick="getyzm()"
			id="getyzm">获取验证码</button>
		<input type="hidden" id="hiddenyzm" />
	</div>
	<div class="ts">
		<span style="font-size: 12px;color: red" id="tsyzm"></span>
	</div>
	<div
		style="width: 100%;height: 40px;text-align: center;margin-top: 20px">
		<button type="button" class="btn btn-info btn-block" id="resetpassword">重置密码</button>

	</div>


</body>
</html>