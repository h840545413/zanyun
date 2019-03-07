/**
 * 
 */

function bindingMailbox() {

	$('#myModal').modal('show');

}
function openDonglekeyModal() {

	$('#bindingdonglekey').modal('show');
}
function changepassword() {
	$('#changepassword').modal('show');

}
function bindingdDonglekey() {
	var donglekey = $('#donglekey').val();
	$.ajax({
		type : "post",
		url : "/index/bindingdonglekey",
		dataType : "json",
		data : {
			donglekey : donglekey
		},
		success : function(result) {
			if (result == 'success') {

				$('#bindingdonglekey').modal('hide');
				$('#alerttext').html('加密狗认证成功！');
				$('#alert').modal('show');

			} else {
				$('#bindingdonglekey').modal('hide');
				$('#alerttext').html(result);
				$('#alert').modal('show');
			}

		}
	});

}
function closediv(id) {

	$("#" + id).modal('hide');
}
function findrenders(page) {
	$.ajax({
		type : "post",
		url : "/index/findrenders",
		dataType : "json",
		data : {
			start : page,
			limit : 10
		},
		success : function(result) {
			$('.render_table').html(result.renders)
			$('.page_render').html(result.pageNum);

		}
	});

}
function finddetails(page) {
	$.ajax({
		type : "post",
		url : "/index/finddetails",
		dataType : "json",
		data : {
			start : page,
			limit : 10
		},
		success : function(result) {
			$('.details_table').html(result.moneydetails)
			$('.page_details').html(result.pageNum);

		}
	});

}
function getyzm() {
	if (checkMailbox() != true) {
		return false;
	}

	if ($('#tsmsg').html() != '') {
		return false;
	}

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
		url : "/index/createmailyzm",
		dataType : "json",
		data : {
			Mailbox : $('#email').val()
		},
		success : function(result) {
			$('#hiddenyzm').val(result);
		}
	});

}
function checkyzm() {

	if (checkMailbox() != true) {
		return false;
	}
	if ($('#tsmsg').html != '') {
		return false;
	}
	if ($('#emailyzm').val() == '') {
		return false;
	}
	var result = new MyJqueryAjax('/index/findemail', {
		yzm : $('#emailyzm').val()
	}).request();
	$.ajax({
		type : "post",
		url : "/index/checkyzm",
		dataType : "json",
		data : {
			yzm : $('#emailyzm').val()
		},
		success : function(result) {
			closediv('myModal');
			if (result == 'success') {
				$('#alerttext').html('邮箱认证成功!');
				$('#alert').modal('show');

			}

		}
	});

}
function change() {
	checkmm1();
	if ($('#ts1').html() != '') {
		return;
	}
	checkmm2();

	if ($('#ts2').html() != '') {
		return;
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
function checkinput(str,type)
{var re = /\d+/;
var reg = /[a-zA-Z]+/;
var reb = /^[0-9a-zA-Z]+$/;
	
	if(type=="mm")
		{
		if (str == '' || str == null) {
			$("#tsmm").text("*密码不能为空");
			return false;
		} else {
			$("#tsmm").text("");
		}
		if (re.test(str) && reg.test(str)
				&& str.length >= 6) {
			$("#tsmm").text("");
			
		}
		if (!re.test(str) || !reg.test(str) || str.length < 6) {
			$("#tsmm").text("*密码必须不小于6位数且同时为字母和数字");
			$("#mm2").val('');
			return false;
		}
		$("#tsmm").text(""); return true;
		}
	if(type=="mm2")
		{
		var mm=$('#mm').val();
		if(str==''){$("#tsmm2").text("*确认密码不能为空");return false;}
	
		if(str!=mm){$("#tsmm2").text("*两次密码不一致");return false;}
		$("#tsmm2").text('');return true;
		}
	if(type=="email")
		{
	
		var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;
		if (str == '') {
			$("#tsmsg").html("邮箱不能为空!");
			return false;
		}
		// var flag = reg.test(Mailbox);

		if (reg.test(str) == true) {
			var flag = new MyJqueryAjax('/index/findemail', { email : str}).request();
			if (flag == '"0"') {
				$("#tsmsg").html("*邮箱已经被使用!");
				return false;
			}
			$("#tsmsg").html("");
			return true;
		} else {
			$("#tsmsg").html("*请输入正确的邮箱地址!");
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
	if(type=='donglekey')
		{
		
		if(str=='')
			{
			$("#tsdongle").html("*加密狗编号不能为空");return false;
			}
		var flag = new MyJqueryAjax('/index/checkdonglekey', { dongleKey : str}).request();
		if(flag=='1'){	$("#tsdongle").html("*加密狗编号已经被使用");return false;}
		if(flag=='9'){	$("#tsdongle").html("*加密狗编号不存在");return false;}
		$("#tsdongle").html("");return true;
		}
	
}