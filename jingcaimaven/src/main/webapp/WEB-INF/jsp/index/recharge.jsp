<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>


<title>用户充值</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />

<link href="/jingcaimaven/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<link rel="stylesheet" href="/jingcaimaven/css/zyunhomepage/zyhead.css">
<link rel="stylesheet" href="/jingcaimaven/css/zyunhomepage/zybutton.css">
<link rel="stylesheet"
	href="/jingcaimaven/css/zyunhomepage/zyrecharge.css">
<script src="/jingcaimaven/js/jquery.min.js"></script>
<script src="/jingcaimaven/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/jingcaimaven/js/head.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#other").focus(function() {
			$("#czbtn1").removeClass("active");
			$("#czbtn2").removeClass("active");
			$("#czbtn3").removeClass("active");
		});
		$('.btn-group').on('click', function() {

			$("#other").val('');
		});
		$(".recharge_btn").on("click", function() {
			var money1 = $('.btn-group .sum  .active').find('input').val();
			alert(money1)
			var money2 = $('#other').val();
			var money = '';
			if (money1 == undefined && money2 == '') {
				
				return;
			}
			if (money1 == undefined) {
				
				money = money2;
			} else {
				money = money1;

			}
			
			window.open('/jingcaimaven/alipay/frame.html?money='+money+'&WIDsubject=zycz&WIDbody=zycz');
			
	
		});
	})
		$(document).click( function(e) {
				if ($('.personal-dropdown').is(':hidden')) { if ($(e.target).is('.mine') || $(e.target).parents('.mine').length > 0) { $('.personal-dropdown').slideDown(); } else { } } else { $('.personal-dropdown').slideUp(); }
			});
</script>
</head>

<body>
	<div class="page">
		<div class="head" style="border-bottom: 1px solid #aaaaaa;">


			<div class="head_logo">
				<img src="/jingcaimaven/images/zynews/logo-01.png"
					style="width: 100%;height:95%">
			</div>
			<div class="head_title">

				<ul class="ul_word" id="menu">
				<li><a href="/">赞云首页</a></li>
				<li><a href="/jingcaimaven/news/newslist.html">新闻帮助</a></li>
				<li><a href="/jingcaimaven/index/video.html">赞云学堂</a></li>
				<li><a href="/jingcaimaven/model/modellist.html">案例展示</a></li>
				<li><a href="/jingcaimaven/index/details.html">精品服务</a></li>
				</ul>
			</div>
			<div class="head_center">
				<div class="mine">
					<i class="fa fa-user"> <img
						src="/jingcaimaven/images/zynews/center.png"
						style="width: 100%;height:100%"></i>
				</div>
			</div>
		</div>
		<jsp:include page="../inc/personal.jsp"></jsp:include>
		<div class="rechargedaohang">
			当前位置：<a>账户充值</a>
		</div>
		<div class="rechargediv">
			<div class="rechargeleft">
				<div class="rechargezhcz">账户充值</div>
				<div class="rechargeshuoming">
					&nbsp;&nbsp;1.使用充值抵用时，将按照实际支付费用来判定会员等级以及赠送金额。</br>
					&nbsp;&nbsp;2.单笔充值100元~2000（不含）元为普通会员；单笔充值2000~5000（不含）元，可变成银牌会员；；单笔充值5000~10000（不含）元，可变成金牌会员；；单笔充值1000元以上，可变成钻石会员。查看具体VIP规则。</br>
					&nbsp;&nbsp;3.不支持退款。
				</div>
			</div>
			<div class="rechargeright">
				<!-- <div class="rechargejine">
					充值账号：<input type="text" id="money">
				</div> -->
				<div class="rechargejine" style="margin-top: 35px;">
					充值金额：
					<div class="btn-group" data-toggle="buttons">
						<label class="btn sum" id="czbtn1"> <input type="radio"
							name="options" value="50"> 50
						</label> <label class="btn sum" id="czbtn2"> <input type="radio"
							name="options" value="100"> 100
						</label> <label class="btn sum" id="czbtn3"> <input type="radio"
							name="options" value="500"> 500
						</label>
					</div>
					其他<input type="text" size="5"
						style="margin-left: 5px;height: 34px;" id="other" onkeyup="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}" onafterpaste="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}">
				</div>
				<div class="rechargejine" style="margin-top: 35px;">赠送金额：</div>
				<div class="rechargejine" style="margin-top: 35px;height: 50px">
					充值方式：
					<div class="btn-group" data-toggle="buttons">
						<label class="btn"> <input type="radio" name="options">
							<img src="/jingcaimaven/images/zycenter/zfb.png">
						</label>
					</div>
				</div>
				<div
					style="width: 100%;height: 30px;margin-top: 35px;text-align: center;">
					<button type="button" class="btn btn-info btn-lg recharge_btn">确认充值</button>
				
				</div>
			</div>

		</div>

	</div>
	<jsp:include page="../inc/buttom.jsp"></jsp:include>
</body>
</html>
