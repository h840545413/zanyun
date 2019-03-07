<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>服务详情</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<link href="/jingcaimaven/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script src="/jingcaimaven/js/jquery.min.js"></script>
<script src="/jingcaimaven/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/jingcaimaven/css/zyunhomepage/zyhead.css">
<link rel="stylesheet" href="/jingcaimaven/css/zyunhomepage/zybutton.css">
<script type="text/javascript" src="/jingcaimaven/js/zyun/head.js"></script>
<link rel="stylesheet" href="/jingcaimaven/css/zyunhomepage/zydetails.css">
<style type="text/css">

.pagination>li>a{
	border: none;
}
.pagination>li>a.active{
	color:black;
}
li{list-style-type: none;}
.personal-dropdown {
	position: absolute;
	top: 60px;
	right: 20px;
	width: 100px;
	height: 150x;
	display: none;
	z-index: 99999999;
	border: solid 1px #00FFFF;
	border-radius: 4px;
	background-color: white;
}

.personal-dropdown>i {
	position: absolute;
	display: block;
	right: 8px;
	top: -10px;
	margin-left: -10px;
	width: 0;
	height: 0;
	border-color: transparent;
	border-style: solid;
	border-width: 9px;
	border-top-width: 0;
	border-bottom-color: #00FFFF;
}

.personal-dropdown>table {
	width: 100%;
}

.personal-dropdown>table tr {
	border-top: solid 1px #000000;
}

.personal-dropdown>table tr:first-child {
	border-top: none;
}

.personal-dropdown>table tr td {
	padding-top: 15px;
	padding-bottom: 15px;
}

.personal-dropdown>table a {
	text-decoration: none;
	color: black;
	display: inline-block;
	width: 100%;
	font-size: 14px;
	padding-left: 10px;
}

.personal-dropdown>table p {
	position: relative;
	padding: 0;
	margin: 0;
	height: 32px;
	line-height: 32px;
	width: 100%;
}

.personal-dropdown>table tr>td>p>a:hover {
	background-color: #00FFFF;
	color: #333;
	font-weight: 700;
}

@media screen and (max-width: 1200px) {
	.head_title{display: none;}
	.top_m{display: none;}
}
</style>
<script type="text/javascript">
	$(document).ready(function() {
		$("#zy").addClass("active");
		$('#wechat').popover(
				{trigger : 'hover',//鼠标以上时触发弹出提示框
					html : true,//开启html 为true的话，data-content里就能放html代码了
					content : "<img src='/jingcaimaven/images/zycase/wechat1.jpg' style='width:150px;heigth:150px;'>"
				});
		$("#menu li").mouseover(function() {
			var line = $(".line");
			$(this).addClass("active");
			line.stop().animate({
				width : $(this).width(),
				left :(parseInt($(this).position().left)-($(document.body).width()*0.2+105))+ "px"}, 300);
		});
		$("#menu li").mouseout(function() {
			var line = $(".line");
			line.stop().animate({
				left : "588px"
			});
		});
	});

	 function line1() {
			$("#menu li").mouseout(function() {
				var line = $(".line");

				line.stop().animate({
					left : "588px"
				});
			});
		}
</script>

</head>

<body>
	<div class="page">
		<div class="head" style="border-bottom: 1px solid #aaaaaa;">
			<div style="height: 3px;width: 100%" class="top_m">
				<div style="width:20%;height: 100%;float: left;"></div>
				<div style="width:700px;height: 100%;float: left;margin-left: 150px;">
					<i class="line" style=" width:80px;display: inline-block;left:588px;"></i>
				</div>
			</div>

			<div class="head_logo">
				<img src="/jingcaimaven/images/zynews/logo-01.png"
					style="width: 100%;height:95%">
			</div>
			<div class="head_title">

				<ul class="ul_word" id="menu">
					<li><a  href="/">精采首页</a></li>
					<li><a  href="/news/newslist.html">新闻帮助</a></li>
					<li><a href="/index/video.html">精采学堂</a></li>
					<li><a href="/model/modellist.html">案例展示</a></li>
					<li><a id="zy" href="/index/details.html">精品服务</a></li>
				</ul>

			</div>
		<div class="head_center">
			<c:if test="${loginFlag eq '1' }"> 
				<div class="mine">
					<i class="fa fa-user"><img
						src="/jingcaimaven/images/zynews/center.png"
						style="cursor: pointer;"></i>
				</div></c:if>
		
			</div>
				<jsp:include page="../inc/personal.jsp"></jsp:include>
		</div>
		<div
			style="margin-top: 78px;width:100%;height: 910px;text-align: center;">
			<img src="/jingcaimaven/images/details/111.png">
		</div>
		<div
			style="margin-top: 59px;width: 100%;height:50px;text-align: center;">
			<button class="details_btn1">立即购买</button>
		</div>
		<div style="">
		<div
			style="position: absolute;margin-top: 8px;position: absolute;z-index: -1;">
			<img src="/images/details/bg.png"
				style="width: 100%;height: 100%">
		</div>
		
		<div class="details_word">大客户定制版</div>
		<div class="details_picdiv">
			<div style="height: 100%;width:1550px;margin: 0 auto">
				<div style="height: 100%;width:350px;float: left;">
					<div
						style="height: 150px;width:150px;margin-bottom: 20px;margin: 0 auto">
						<img src="/jingcaimaven/images/details/3D.png">
					</div>
					<div
						style="height: 30px;width: 100%;color: #2e99ca;font-size: 22px;text-align: center;margin-bottom: 17px;font-family: MicrosoftYa;">企业自己的3D设计工具</div>
					<div
						style="height: 60px;width: 100%;color: #333333;font-size: 15px;text-align: center;font-family: MicrosoftYa;line-height: 30px">
						3D云设计工具内嵌企业官网</br>内含企业标准版所有功能模块
					</div>
				</div>
				<div style="height: 100%;width:350px;float: left;margin-left:3% ">
					<div
						style="height: 150px;width:150px;margin-bottom: 20px;margin: 0 auto">
						<img src="/jingcaimaven/images/details/jingzhun.png">
					</div>
					<div
						style="height: 30px;width: 100%;color: #2e99ca;font-size: 22px;text-align: center;margin-bottom: 17px;font-family: MicrosoftYa;">精准对接企业ERP</div>
					<div
						style="height: 60px;width: 100%;color: #333333;font-size: 15px;text-align: center;font-family: MicrosoftYa;line-height: 30px">
						实现设计、展示、订单、生产的一站式服务</br>以数据接口的形式、自动对接企业ERP、生产系统
					</div>
				</div>
				<div style="height: 100%;width:350px;float: left;margin-left:3% ">
					<div
						style="height: 150px;width:150px;margin-bottom: 20px;margin: 0 auto">
						<img src="/jingcaimaven/images/details/changjing.png">
					</div>
					<div
						style="height: 30px;width: 100%;color: #2e99ca;font-size: 22px;text-align: center;margin-bottom: 17px;font-family: MicrosoftYa;">精准对接企业ERP</div>
					<div
						style="height: 60px;width: 100%;color: #333333;font-size: 15px;text-align: center;font-family: MicrosoftYa;line-height: 30px">
						边设计，边购买，提升在线停留时间</br>打通线上、线下，实现O2O营销
					</div>
				</div>
				<div style="height: 100%;width:350px;float: left;margin-left:3% ">
					<div
						style="height: 150px;width:150px;margin-bottom: 20px;margin: 0 auto">
						<img src="/jingcaimaven/images/details/shuju.png">
					</div>
					<div
						style="height: 30px;width: 100%;color: #2e99ca;font-size: 22px;text-align: center;margin-bottom: 17px;font-family: MicrosoftYa;">精准对接企业ERP</div>
					<div
						style="height: 90px;width: 100%;color: #333333;font-size: 15px;text-align: center;font-family: MicrosoftYa;line-height: 30px">
						丰富数据获取，建立“用户画像”“产品画像”</br>为企业精准营销、产品定制、市场布局等提供科学的分析数据
					</div>
				</div>
			</div>
			<div style="width: 100%;height: 50px;text-align: center;">
				<button class="details_btn1">定制咨询</button>
			</div>
		</div>
		</div>
		
	</div>
	 <jsp:include page="../inc/buttom.jsp"></jsp:include> 
</body>
</html>
