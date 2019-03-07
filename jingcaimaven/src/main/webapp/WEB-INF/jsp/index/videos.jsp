<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>案例展示</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />

<link href="/jingcaimaven/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<script src="/jingcaimaven/js/jquery.min.js"></script>
<script src="/jingcaimaven/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/jingcaimaven/css/zyunhomepage/zyhead.css">
<link rel="stylesheet" href="/jingcaimaven/css/zyunhomepage/zybutton.css">
<link rel="stylesheet" href="/jingcaimaven/css/zyunhomepage/zycase.css">
<script type="text/javascript" src="/jingcaimaven/js/zyun/head.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		var width=$(document.body).width();
		if(width<=1200){ width=1200; }
		$('.bt img').css("margin-left",width/2-960);
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
				left : "340px"
			});
		});
		//findvideos(1);
	});
	
	function findvideos(s) {
		
		$.ajax({
			url : '/jingcaimaven/index/findvideos',
			type : 'POST',
			dataType : 'json',
			async : false,
			data : {
				start : s,
				limit : 12
			},
			success : function(result) {
				$(".videos").html(result.videos);
				$(".pagination").html(result.pageNum);
			}
		});

	}
	$(window).resize(function(){
		
		var width=$(document.body).width();
		if(width<=1200){ width=1200; }
		$('.bt img').css("margin-left",width/2-960);
		
	});
	$(document).click( function(e) {
		if ($('.personal-dropdown').is(':hidden')) { if ($(e.target).is('.mine') || $(e.target).parents('.mine').length > 0) { $('.personal-dropdown').slideDown(); } else { } } else { $('.personal-dropdown').slideUp(); }
	});
</script>
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
</head>

<body>
	<div class="page">
		<div class="head">
			<div style="height: 3px;width: 100%" class="top_m">
				<div style="width:20%;height: 100%;float: left;"></div>
				<div
					style="width:700px;height: 100%;float: left;margin-left: 150px;">
					<i class="line"
						style=" width:80px;display: inline-block;left:340px;"></i>
				</div>
			</div>
			<div class="head_logo">
				<img style="width: 100%" src="/jingcaimaven/images/zynews/logo-01.png">
			</div>
			<div class="head_title">

				<ul class="ul_word" id="menu">
					<li><a href="/">精采首页</a></li>
					<li><a href="/news/newslist.html">新闻帮助</a></li>
					<li><a id="zy" href="javascript:void(0)">精采学堂</a></li>
					<li><a  href="/model/modellist.html">案例展示</a></li>
					<li><a href="/index/details.html">精品服务</a></li>
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
		</div>
		<div style="width:100%;height:460px; overflow: hidden;min-width: 1200px;" class="bt">
			<img src="/jingcaimaven/images/zyxt/banner.png"  style=" width:1920px;">
		</div>
		<div class="news_bar">
			当前位置：<a>精采首页</a>><a id="new">精采学堂</a>
		</div>
		<div style="width: 100%;">
	<div style="width: 100%;padding:10px;text-align: center;height: 800px;"><div style="width:1200px;margin: auto auto;text-align: center; "> <ul  class="videos"></ul>
	</div></div>
	<div style="width: 100%;height: 80px;text-align: center">
	<ul class="pagination">
					
	</ul>
	</div>
		</div>
		<jsp:include page="../inc/buttom.jsp"></jsp:include>
	</div>
</body>
<head>

</head>
</html>
