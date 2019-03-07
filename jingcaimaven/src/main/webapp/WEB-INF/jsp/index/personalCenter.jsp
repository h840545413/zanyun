<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% 	response.setHeader("Cache-Control", "no-store");
	response.setHeader("Pragrma", "no-cache");
	response.setDateHeader("Expires", 0);
%>
<!DOCTYPE HTML>
<html>
<head>
<title>精采联盟个人中心</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta HTTP-EQUIV="pragma" CONTENT="no-cache">
<meta HTTP-EQUIV="Cache-Control" CONTENT="no-cache, must-revalidate">
<meta HTTP-EQUIV="expires" CONTENT="0">
<link href="/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
	<link rel="stylesheet" href="/css/zyunhomepage/zycenter.css">
<link rel="stylesheet" href="/css/zyunhomepage/zyhead.css">
<link rel="stylesheet" href="/css/zyunhomepage/zybutton.css">
<style type="text/css">
.modaldiv
{width: 300px;height: 42px;line-height:40px;text-align: left;margin: auto auto;border: 1px solid #DCDCDC;padding-left: 20px;}
.modaldiv input[type='text']
{
	width: 250px;margin-left: 10px;height: 40px;line-height: 40px;border:0;font-size: 14px;outline:none;
}
.modaldiv input[type='password']
{
	width: 250px;margin-left: 10px;height: 40px;line-height: 40px;border:0;font-size: 14px;outline:none;
	
}
.ts{height: 20px;width: 300px;margin:auto auto;text-align: left;padding-left: 20px;}
</style>
<script src="/js/jquery.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/zyun/head.js"></script>
<script src="/js/center.js"></script>
<!-- <script src="/js/index.js"></script> -->
<script type="text/javascript">
	$(document) .ready( function() {
		init();
					//	checkmm();
					//	$("#email").blur(function() { checkMailbox();});
					var mm=$('#mm');
					var mm2=$('#mm2');
					var email=$('#email');
					var yzm=$('#yzm');
					var donglekey=$('#donglekey');
					mm.blur(function(){checkinput(mm.val(),'mm');});
					mm2.blur(function(){checkinput(mm2.val(),'mm2');});
					email.blur(function(){checkinput(email.val(),'email');});
					yzm.blur(function(){checkinput(yzm.val(),'yzm');});
					donglekey.blur(function(){checkinput(donglekey.val(),'donglekey');});
						$('#alert') .on( 'hidden.bs.modal', function() {
							if ($("#alerttext").html() == '密码修改成功！') { window.location.href = "/index/layout.html"; }
							if ($("#alerttext").html() == '加密狗认证成功！') {window.location.reload(); }
							});
					$('#donglekeybingbtn').on('click',function(){
						if(!checkinput(donglekey.val(),'donglekey')){ return false;	}
						$.ajax({
							type : "post",
							url : "/index/bindingdonglekey",
							dataType : "json",
							data : {
								donglekey :donglekey.val()
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
					});
					$('#checkemailbtn').on('click',function(){
					
						if(!checkinput(email.val(),'email')){alert(1);return false;}
						if(!checkinput(yzm.val(),'yzm')){alert(2);return false;}
						var result = new MyJqueryAjax('/index/findemail', {
							yzm : $('#emailyzm').val()
						}).request();
						$.ajax({
							type : "post",
							url : "/index/checkyzm",
							dataType : "json",
							data : {
								email:email.val(),
								yzm : yzm.val()
							},
							success : function(result) {
								closediv('myModal');
								if (result == 'success') {
									$('#alerttext').html('邮箱认证成功!');
									$('#alert').modal('show');

								}

							}
						});
						
					});
					$('#changepasswordbtn').on('click',function(){
						if(!checkinput(mm.val(),'mm')){return false;}
						if(!checkinput(mm2.val(),'mm2')){return false;}
						
						$.ajax({
							type : "post",
							url : "/index/changepassword",
							dataType : "json",
							data : {

								password : $('#mm').val()
							},
							success : function(result) {
								$('#changepassword').modal('hide');
								$('#alerttext').html('密码修改成功！');
								$('#alert').modal('show');
								/*  */
							}
						});
					});
					});
	
	$(document).click( function(e) {
				if ($('.personal-dropdown').is(':hidden')) { if ($(e.target).is('.mine') || $(e.target).parents('.mine').length > 0) { $('.personal-dropdown').slideDown(); } else { } } else { $('.personal-dropdown').slideUp(); }
			});
	function init()
	{
		//输入框焦点
		$('.modaldiv input').on('focus',function(){ $(this).parent().css("border","1px solid #00FFFF");});
		$('.modaldiv input').on('blur',function(){ $(this).parent().css("border","1px solid #DCDCDC");});
			
		$('#wechat') .popover( {trigger : 'hover',html : true,content : "	<img src='/images/zycase/wechat1.jpg' style='width:150px;heigth:150px;'>"});
		$("#menu li").mouseout(function() {var line = $(".line");line.stop().animate({left : "460px"});});
		findrenders(1);
		finddetails(1);
	}
</script>

</head>

<body>
	<div class="page">
		<div class="head" style="border-bottom: 1px solid #aaaaaa; ">

			<div class="head_logo">
				<img src="/images/zynews/logo-01.png"
					style="width: 100%;height:95%">
			</div>
			<div class="head_title">

				<ul class="ul_word" id="menu">
					<li><a href="/">精采首页</a></li>
				</ul>

			</div>
			<div class="head_center">
				<div class="mine">
					<i class="fa fa-user"> <img
						src="/images/zynews/center.png"
						style="width: 100%;height:100%"></i>
				</div>

			</div>
		</div>
		<jsp:include page="../inc/personal.jsp"></jsp:include>
		<!--///////////////// -->
		<div class="personal">
			<div class="personal_information">
				<div class="personal_information_head">
					<img src="/images/zycenter/center.png"
						class="img-circle" style="height:100px;width:100px;">
				</div>
				<div class="personal_information_id">
					<div class="personal_information_id_div">${account.operatorId }</div>
					<div class="personal_information_id_update">
						<img src="/images/zycenter/update.png">
					</div>
				</div>
			</div>
		</div>
		<!--账号安全///////////////// -->
		<div class="account">
			<div class="account_information" style="padding: 0 0 0 0">
				<p class="account_information_za">账号安全</p>
				<div class="account_information_div">
					<div class="account_information_ye">余额：</div>
					<div class="account_information_money">￥${account.money}</div>
					<div class="account_information_btn">
						<a class="account_information_a"
							href="/index/recharge.html">
							<button type="button" class="btn btn-info  recharge_btn">充值</button>
						</a>
					</div>
				</div>
				<div class="account_information_update">
					<div style="width: 100%;height:30%">
						<div class="account_information_update_word1">
							<c:if test="${empty account.email }">
							绑定邮箱：<span>未绑定</span>
						</div>
						<div class="account_information_update_word2">
							<a href="javascript:void(0)" onclick="bindingMailbox()">立即绑定</a>
							</c:if>
							<c:if test="${not empty account.email }">
							绑定邮箱：<span>已绑定</span>
						</div>
						<div class="account_information_update_word2">
							<a href="javascript:void(0)" onclick="bindingMailbox()">重新绑定</a>
							</c:if>
						</div>
					</div>
					<div style="width: 100%;height:30%">
						<div class="account_information_update_word1">
							密码修改：<span>*******</span>
						</div>
						<div class="account_information_update_word2">
							<a href="javascript:void(0)" onclick="changepassword()">点击修改</a>
						</div>
					</div>
					<%-- <div style="width: 100%;height:30%">
						<div class="account_information_update_word1">
							<c:if test="${empty donglekey}">
							绑定加密狗：<span>未绑定</span>
						</div>
						<div class="account_information_update_word2">
							<a href="javascript:void(0)" onclick="openDonglekeyModal()">立即绑定</a>
							</c:if>
							<c:if test="${not empty donglekey }">
							绑定加密狗：<span>已绑定</span>
						</div>
						<div class="account_information_update_word2">
							<a href="javascript:void(0)" onclick="openDonglekeyModal()">重新绑定</a>
							</c:if>
						</div>
					</div> --%>
				</div>

			</div>
		</div>
		<!-- 充值记录////////////// -->
		<!-- <div class="record.account">
			<div class="record_information">
				<div style="width: 100%;height: 30px;margin-bottom:30px;">
					<div class="czjl" style="text-align: left;">充值记录</div>
				</div>
				<table class="details_table">


				</table>
				<div style="width: 100%;text-align: center;height: 30px;">
					<ul class="page_details"></ul>
				</div>
			</div>
		</div> -->
		<!-- 		
			</div>
		</div>
		
		<!-- 渲染记录////////////// -->
		<div class="record.render" style="margin-bottom: 30px;">
			<div class="record_information" style="border: none;">
				<div style="width: 100%;height: 30px;margin-bottom:30px;">
					<div class="czjl" style="text-align: left;">渲染记录</div>
				</div>

				<table class="render_table">
				</table>

				<div style="width: 100%;height: 30px;text-align: center;">
					<ul class="page_render">
					</ul>
				</div>

			</div>
		</div>
		<jsp:include page="../inc/buttom.jsp"></jsp:include>
	</div>
	<!-- 绑定邮箱////////////// -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" style="width: 400px;">
			<div class="modal-content">

				<div class="modal-body">
					<div class="colse">
						<button
							style="float: right;margin-right: 10px;border: none;background-color: rgba(0,0,0,0);"
							onclick="closediv('myModal')">
							<img src="/images/icon/colse.png">
						</button>
					</div>
					<div>
						<h3 style="width: 100%;text-align: center;">绑定邮箱</h3>
						<div class="modaldiv" style="width: 300px;height: 42px;line-height:40px;text-align: left;margin: auto auto;border: 1px solid #DCDCDC;padding-left: 20px;">
					<img src="/images/icon/lock.png"><input id="email" type="text"  placeholder="邮箱" style="border:0;"/>
					</div>
					<div class="ts">
							<span style="font-size: 12px;color: red" id="tsmsg"></span>
						</div>
						<div class="modaldiv" style="width: 300px;height: 42px;line-height:40px;text-align: left;margin: auto auto;border: 1px solid #DCDCDC;padding-left: 20px;">
					<img src="/images/icon/lock.png"><input id="yzm" type="text" style="width: 150px;" style="border:0;" placeholder="验证码"/><button type="button" class="btn btn-info" onclick="getyzm()" id="getyzm">获取验证码</button>
					<input type="hidden" id="hiddenyzm"/>
					</div>
					<div class="ts">
							<span style="font-size: 12px;color: red" id="tsyzm" ></span>
						</div>
						<div
							style="width: 100%;height: 40px;text-align: center;margin-top: 20px">
							<button type="button" class="btn btn-info btn-lg"
								id="checkemailbtn">确认认证</button>

						</div>
					</div>
				</div>



			</div>
		</div>
	</div>
	<!-- 修改密码////////////// -->
	<div class="modal fade" id="changepassword" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" style="width: 400px;">
			<div class="modal-content">

				<div class="modal-body">
					<div class="colse">
						<button
							style="float: right;margin-right: 10px;border: none;background-color: rgba(0,0,0,0);"
							onclick="closediv('changepassword')">
							<img src="/images/icon/colse.png">
						</button>
					</div>
					<h3 style="width: 100%;text-align: center;">修改密码</h3>
					<div>
					<div class="modaldiv" style="width: 300px;height: 42px;line-height:40px;text-align: left;margin: auto auto;border: 1px solid #DCDCDC;padding-left: 20px;">
					<img src="/images/icon/lock.png"><input id="mm" style="border:0;" type="password"  placeholder="密码"/>
					</div>
						<div class="ts">
							<span style="font-size: 12px;color: red" id="tsmm"></span>
						</div>
					<div class="modaldiv" style="width: 300px;height: 42px;line-height:40px;text-align: left;margin: auto auto;border: 1px solid #DCDCDC;padding-left: 20px;">
					<img src="/images/icon/lock.png"><input id="mm2" style="border:0;" type="password"  placeholder="密码"/>
					</div>
						<div class="ts">
							<span style="font-size: 12px;color: red" id="tsmm2"></span>
						</div>
						<div
							style="width: 100%;height: 40px;text-align: center;margin-top: 20px">
							<button type="button" class="btn btn-info " id="changepasswordbtn">确认修改</button>
						</div>
					</div>
				</div>



			</div>
		</div>
	</div>
	<!-- 验证加密狗////////////// -->
	<div class="modal fade" id="bindingdonglekey" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" style="width: 400px;">
			<div class="modal-content">

				<div class="modal-body">
					<div class="colse">
						<button
							style="float: right;margin-right: 10px;border: none;background-color: rgba(0,0,0,0);"
							onclick="closediv('bindingdonglekey')">
							<img src="/images/icon/colse.png">
						</button>
					</div>
					<div class="">
						<h3 style="width: 100%;text-align: center;">绑定加密狗</h3>
						<div class="modaldiv" style="width: 300px;height: 42px;line-height:40px;text-align: left;margin: auto auto;border: 1px solid #DCDCDC;padding-left: 20px;">
					<img src="/images/icon/lock.png"><input id="donglekey" type="text" style="border:0;"  placeholder="加密狗编号"/>
					</div>
					<div class="ts">
							<span style="font-size: 12px;color: red" id="tsdongle"></span>
						</div>
						<!-- <div>
							<span>输入加密狗编号：</span><input type="text" placeholder="输入加密狗编号" id="donglekey"/>
						</div> -->
						<div
							style="width: 100%;height: 40px;text-align: center;margin-top: 20px">
							<button type="button" class="btn btn-info "  id="donglekeybingbtn">确认绑定</button>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
	<div class="modal fade" id="alert" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content" style="height:80px;line-height: 80px;">

				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="alerttext"
					style="text-align: center;height: 80px;line-height: 80px;font-size: 28px;">修改成功</h4>


			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>
</body>
</html>
