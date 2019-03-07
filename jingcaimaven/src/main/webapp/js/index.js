/**
 * 
 */
function getyzm() {
	var  registemail=$('#email');
	if (!checkinput(registemail.val(),'registemail')) { return false; }
	var info = $("#getyzm").html();
	if (info == "获取验证码") {
		$("#getyzm").addClass("disabled");
		var waitTime = 60;
		timeOutCode("getyzm", waitTime);
		getEmailYzm();
	}
	if (info == "请重新获取") {
		$("#getyzm").addClass("disabled");
		var waitTime = 60;
		timeOutCode("getyzm", waitTime);
		getEmailYzm();
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
function checkyzm() {

	if (checkMailbox() != true) {
		return false;
	}
	if ($('#msgts').html != '') {
		return false;
	}
	if ($('#emailyzm').val() == '') {
		$('#tszym').html("*验证码不能为空");
		return false;
	}
	if($('#emailyzm').val()!=$("#yzmhidden").val())
		{
		$('#tszym').html("*验证码错误");
		return false;
		}


}
function checkMailbox() {
	var Mailbox = $('#email').val();
	var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;
	if (Mailbox == '') {
		$("#msgts").html("邮箱不能为空!");
		return false;
	}
	// var flag = reg.test(Mailbox);

	if (reg.test(Mailbox) == true) {
		var flag = new MyJqueryAjax('/index/findemail', { email : Mailbox }).request();
		if (flag == '"0"') {
			$("#msgts").html("邮箱已经被使用!");
			return false;
		}
		$("#msgts").html("");
		return true;
	} else {
		$("#msgts").html("请输入正确的邮箱地址!");
		return false;
	}
}
function findemail(email) {
	var flag = '0';
	$.ajax({
		type : "post",
		url : "/index/findemail",
		dataType : "json",
		data : {
			email : $('#email').val()
		},
		success : function(result) {

			return result;
		}
	});

}
function timeOutCode(id, waitTime) {
	if (waitTime == 0) {
		$("#" + id).html("请重新获取");
		$("#getyzm").removeClass("disabled");
	} else {
		waitTime--;
		$("#" + id).html('等待 '+waitTime + ' s ');
		setTimeout(function() {
			timeOutCode(id, waitTime);
		}, 1000);
	}
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
};

function checkinput(str,type)
{
	var re = /\d+/;
	var reg = /[a-zA-Z]+/;
	var reb = /^[0-9a-zA-Z]+$/;
	if(type=='loginzh'){
	if (str == '' || str == null) { $("#ts1").text("*账号不能为空"); return false; } else { $("#ts1").text(""); }
	if (str.length >= 4 && reb.test(str)) { $("#ts1").text(""); } else { $("#ts1").text("*账号必须不小于4位数且为字母或者数字"); $("#zh").val(''); return false;}
	if (str.length <= 16 && reb.test(str)) { $("#ts1").text(""); return true; } else { $("#ts1").text("*账号必须不超过16位数且为字母或者数字"); $("#zh").val(''); return false; }
	}
	if(type=="loginmm") {
		 if (str == '' || str == null) { $("#ts2").text("*密码不能为空"); return false; } else { 	$("#ts2").text(""); return true; }
	}
	if(type=="registzh")
		{
		if (str == '' || str == null) {
			$("#ts3").text("*账号不能为空");
			return false;
		} else {
			$("#ts3").text("");
		}
		if (str.length >= 4 && reb.test(str)) {
			$("#ts3").text("");
		} else {
			$("#ts3").text("*账号必须不小于4位数且为字母或者数字");
			$("#zh2").val('');
			return false;
		}
		if (str.length <= 16 && reb.test(str)) {
			
		var result=	new MyJqueryAjax('/index/checkloginname', { loginname : str }).request()
if(result!='1'){;return true;}else{$("#ts3").text("用户名已经被使用");return false;}
		} else {

			$("#ts3").text("*账号必须不超过16位数且为字母或者数字");
			$("#zh2").val('');
			return false;
		}
		
		}
	if(type=="registmm")
		{
		if (str == '' || str == null) {
			$("#ts4").text("*密码不能为空");
			return false;
		} else {
			$("#ts4").text("");
		}
		if (re.test(str) && reg.test(str)
				&& str.length >= 6) {

			$("#ts4").text("");
			return true;
		}
		if (!re.test(str) || !reg.test(str) || str.length < 6) {
			$("#ts4").text("*密码必须不小于6位数且同时为字母和数字");
			$("#mm2").val('');
			return false;
		}
		return true;
		}
	if(type=="registmm2")
		{
		var mm=$('#mm2').val();
		if(str==''){$("#ts5").text("*确认密码不能为空");return false;}
		if(str!=mm){$("#ts5").text("*两次密码不一致");return false;}
		$("#ts5").text('');return true;
		}
	if(type=="registemail")
		{
	
		var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;
		if (str == '') {
			$("#msgts").html("邮箱不能为空!");
			return false;
		}
		// var flag = reg.test(Mailbox);

		if (reg.test(str) == true) {
			var flag = new MyJqueryAjax('/index/findemail', { email : str}).request();
			if (flag == '"0"') {
				$("#msgts").html("*邮箱已经被使用!");
				return false;
			}
			$("#msgts").html("");
			return true;
		} else {
			$("#msgts").html("*请输入正确的邮箱地址!");
			return false;
		}
		}
	if(type=="registyzm")
		{
		if(str==''){	$("#tsyzm").html("*验证码不能为空");return false;}
		var hiddenyzm=$('#hiddenyzm').val();
		if(hiddenyzm!=str){
			$("#tsyzm").html("*验证码错误");
		return false;}
		$("#tsyzm").html("");return true;
		}
	
}
