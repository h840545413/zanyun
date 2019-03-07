<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>新闻列表</title>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<link href="/jingcaimaven/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="/jingcaimaven/css/zyunhomepage/zynews.css">
<link rel="stylesheet" href="/jingcaimaven/css/zyunhomepage/zyhead.css">
<link rel="stylesheet" href="/jingcaimaven/css/zyunhomepage/zybutton.css">
<script src="/jingcaimaven/js/jquery.min.js"></script>
<script src="/jingcaimaven/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/jingcaimaven/js/head.js"></script>
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
				left : "208px"
			});
		});
		findnews(1);
		var width=$(document.body).width();
		if(width<=1200){
			width=1200;
			
		}
				$('.bt img').css("margin-left",width/2-960);
	});
	
	

	function findnews(s) {
		$.ajax({
			url : '/jingcaimaven/news/findnewslist',
			type : 'POST',
			dataType : 'json',
			async : false,
			data : {
				id : 90,
				start : s,
				limit : 10
			},
			success : function(result) {
				$(".news_ul").html(result.newsList);
				$(".pagination").html(result.pageNum);
			}
		});

	}
$(window).resize(function(){
		
		var width=$(document.body).width();
if(width<=1200){
	width=1200;
	
}
		$('.bt img').css("margin-left",width/2-960);
		
	});
$(document).click( function(e) {
	if ($('.personal-dropdown').is(':hidden')) { if ($(e.target).is('.mine') || $(e.target).parents('.mine').length > 0) { $('.personal-dropdown').slideDown(); } else { } } else { $('.personal-dropdown').slideUp(); }
});
</script>
</head>

<body>

	<div class="page" style="width: 1900px;width: 100%;">
		<div class="head">
			<div style="height: 3px;width: 100%" class="top_m">
				<div style="width:20%;height: 100%;float: left;"></div>
				<div style="width:700px;height: 100%;float: left;margin-left: 150px;">
					<i class="line"
						style=" width:80px;display: inline-block;left:208px;"></i>
				</div>
			</div>
			<div class="head_logo">
				<img style="width: 100%" src="/jingcaimaven/images/zynews/logo-01.png">
			</div>
			<div class="head_title">
				<ul class="ul_word" id="menu">
					<li><a href="/">精采首页</a></li>
					<li><a id="zy" href="/news/newslist.html">新闻帮助</a></li>
					<li><a href="/index/video.html">精采学堂</a></li>
					<li><a href="/model/modellist.html">案例展示</a></li>
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
				<jsp:include page="../inc/personal.jsp"></jsp:include>
		</div>
		<div style="width:100%;height:450px;overflow: hidden;min-width: 1200px;" class="bt">
			<img src="/jingcaimaven/images/zynews/banner.png" class="news_pic" style="width: 1920px;">
		</div>
		<div class="news_bar">
			当前位置：<a>精采首页</a>><a id="new">新闻中心</a>
		</div>
		<div
			style="width: 100%;height:390px;border-bottom: 1px solid #aaaaaa;margin-top: 30px;">
			<div style="width: 100%;height: 100%;text-align: center;overflow: hidden;min-width: 1200px;">
				<!-- <div class="news_tittle">新闻资讯</div> -->
				<div
					style="min-width: 1400px;width: 80%;height: 100%;margin: auto auto;">

					 ${topnews } 
					</div>
			</div>
		</div>
		<input type="hidden" value="${newsId}" id="newsId" /> <input
			type="hidden" value="1" id="start" />
		<div style="width: 100%;height:390px;text-align: center;" id="xw">
		
			<ul style="width: 1000px;height: 80%;margin: auto auto;margin-top: 50px;clear:both;" class="news_ul">
			</ul>
			
		</div>

			<div style="width: 100%;height:12%;text-align:center;margin: auto auto;float: left;margin-top: 50px;">
				<ul class="pagination">

				</ul>
			</div>
	</div>
	<div style="height: 300px;width: 100%;"></div>
		 <jsp:include page="../inc/buttom.jsp"></jsp:include> 
</body>
</html>
