<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>精采联盟</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />

<link href="/jingcaimaven/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="/jingcaimaven/css/zyunhomepage/comm.css">
<link rel="stylesheet" href="/jingcaimaven/css/zyhomepage/homepage.css">
<link rel="stylesheet" href="/jingcaimaven/css/static.css">
<link rel="stylesheet" href="/jingcaimaven/css/animate.min.css">
<script type="text/javascript" src="/jingcaimaven/js/jquery.min.js"></script>
<script type="text/javascript" src="/jingcaimaven/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/jingcaimaven/js/jquery.fullPage.js"></script>
<script type="text/javascript" src="/jingcaimaven/js/zyunhomepage/index.js"></script>
<script type="text/javascript" src="/jingcaimaven/js/zyph/zyph.js"></script>
<script type="text/javascript" src="/jingcaimaven/js/index.js"></script>
<script type="text/javascript">
function jqqd()
{
	
	alert('功能尚未推出，敬请期待！');
	}

</script>
</head>
<body>
	<header id="masthead" class="site-header">
		<div class="logo">
			<img src="/jingcaimaven/images/zyunhomepage/logo.png"
				alt="广东精采家居科技有限公司"  />
		</div>
		<div class="list">
			<ul class="list-inline" id="menu">
				<li class="active" id="sy1"><a href="javascript:void(0);"
					onclick="$.fn.fullpage.moveTo(1, 0);" class="s1">精采首页</a></li>
				<li id="sy2"><a href="javascript:void(0);"
					onclick="$.fn.fullpage.moveTo(2, 0);" class="s2">产品特色</a></li>
				<li id="sy3"><a href="javascript:void(0);"
					onclick="$.fn.fullpage.moveTo(3, 0);" class="s2">案例展示</a></li>
				<li id="sy4"><a href="javascript:void(0);"
					onclick="$.fn.fullpage.moveTo(4, 0);" class="s2">精品服务</a></li>
				<li id="sy5"><a href="javascript:void(0);"
					onclick="$.fn.fullpage.moveTo(5, 0);" class="s2">软件下载</a></li>
				<li id="sy6"><a href="javascript:void(0);"
					onclick="$.fn.fullpage.moveTo(6, 0);" class="s2">精采学堂</a></li>
				<li id="sy7"><a href="javascript:void(0);"
					onclick="$.fn.fullpage.moveTo(7, 0);" class="s2">联系我们</a></li>
			</ul>
			<div style="width:840px;height: 3px;position: absolute;top: 0">
				<i class="line" style="display: inline; width: 88px; left: 27px;"></i>
			</div>
		</div>
		<div class="display" id="dh">
			<div class="btn-group">
				<button type="button" class="btn btn-default dropdown-toggle"
					data-toggle="dropdown">
					导航栏<span class="caret"></span>
				</button>
				<ul class="dropdown-menu" role="menu">
					<li><a href="javascript:void(0);"
						onclick="$.fn.fullpage.moveTo(1, 0);" class="s1">精采首页</a></li>
					<li class="divider"></li>
					<li><a href="javascript:void(0);"
						onclick="$.fn.fullpage.moveTo(2, 0);" class="s2">产品特色</a></li>
					<li class="divider"></li>
					<li><a href="javascript:void(0);"
						onclick="$.fn.fullpage.moveTo(3, 0);" class="s2">案例展示</a></li>
					<li class="divider"></li>
					<li><a href="javascript:void(0);"
						onclick="$.fn.fullpage.moveTo(4, 0);" class="s2">精品服务</a></li>
					<li class="divider"></li>
					<li><a href="javascript:void(0);"
						onclick="$.fn.fullpage.moveTo(5, 0);" class="s2">软件下载</a></li>
					<li class="divider"></li>
					<li><a href="javascript:void(0);"
						onclick="$.fn.fullpage.moveTo(6, 0);" class="s2">精采学堂</a></li>
					<li class="divider"></li>
					<li><a href="javascript:void(0);"
						onclick="$.fn.fullpage.moveTo(7, 0);" class="s2">联系我们</a></li>
				</ul>
			</div>
		</div>
		<div class="hotline">
			<c:if test="${loginFlag eq '0' }">
			<a href="javascript:void(0)" onclick="openlogin()" style="color: white;font-size: 18px;margin-top:20px;">登录/注册 </a>
			<!-- <a href="http://360zy.yjia88.com" target="_blank" style="margin-left: 10px;"><img src="/jingcaimaven/images/VR.png" title="前往全景" height="30px" style="border: 0"></a> -->
			</c:if>
			<%-- <c:if test="${loginFlag eq '1' }">
				<div class="mine">
					<i class="fa fa-user"><img
						src="/jingcaimaven/images/zyunhomepage/center.png"
						style="cursor: pointer;"></i>
						<a href="http://360zy.yjia88.com" target="_blank" style="margin-left:10px;"><img  src="/jingcaimaven/images/VR.png"  title="前往全景"></a>
				</div>
				
			</c:if> --%>

		</div>

	</header>
	<div class="hp_div">
		<div class="hp_img_div">
			<img src="/jingcaimaven/images/zyunhomepage/button.png"
				style="position: absolute;"> <img
				src="/jingcaimaven/images/zyunhomepage/telephone.png"
				style="position: absolute;z-index: 10;top:15px;left: 5px;"
				id="hptel"> <img src="/jingcaimaven/images/zyunhomepage/qq.png"
				style="position: absolute;z-index: 10;top:75px;left: 5px;" id="hpqq">
			<img src="/jingcaimaven/images/zyunhomepage/wechat.png"
				style="position: absolute;z-index: 10;top:125px;left: 5px;"
				id="hpwechat" ata-toggle="popover" data-placement="left">
		</div>
		<div
			style="height: 100%;width: 100%;float: left;position: absolute;z-index: 1;left: 100%">
			<div class="hp_tel"></div>
			<div class="hp_qq"></div>
		</div>
	</div>
	<div id="fullpage">
		<div class="first section">
			<div id="myCarousel" class="carousel slide " data-ride="carousel"
				data-interval="3000">
				<div class="carousel-inner">
					<div class="item  active">
						<img data="/jingcaimaven/images/zyunhomepage/banner2.png"
							src="/jingcaimaven/images/zyunhomepage/2(1).jpg"
							style="width: 100%" id="img2" class="lazy">
						<div class="carousel-caption" style="bottom: 40%" id="first_first1">
							<div style="font-size: 48px;color: white;">精采联盟</div>
							<div
								style="font-size: 18px;color: white;margin-top: 25px;margin-bottom: 23px">引领家装行业进入智能设计时代</div>
								<div style="width: 350px;height: 70px;border-bottom: 1px solid #46dcff;margin: 0 auto;line-height: 60px;">
								<span style="color: #46dcff;font-size: 60px;font-weight: bolder;letter-spacing:-5px;">INTELLIGENT</span></div>
							<!-- <img alt="" src="/images/zyunhomepage/innovation.png"
								style="width: 332px;height: 47px;"> --><!-- <br /> <img
								src="/images/zyunhomepage/I.png"
								style="margin-top: 12px;margin-bottom: 26px;width: 332px"> --><br />
							<div
								style="font-size:18px;color:rgba(255,255,255,0.7);line-height: 30px">
								</br> 智能生成设计方案</br> 一键渲染、一键出施工图、一键出预算、无缝对接企业ERP
							</div>
						</div>
					</div>
							<div class="item">
						<img data="/jingcaimaven/images/zyunhomepage/banner3.png"
							src="/jingcaimaven/images/zyunhomepage/3(1).jpg"
							style="width: 100%" id="img3" class="lazy"
							data-original="/jingcaimaven/images/zyunhomepage/banner3.png">
						<div class="carousel-caption" style="bottom: 40%" id="first_first3">
							<div style="font-size: 48px;color: white;">精采联盟</div>
							<div
								style="font-size: 18px;color: white;margin-top: 25px;margin-bottom: 23px">引领家装行业进入智能设计时代</div>
							<div style="width: 350px;height: 70px;border-bottom: 1px solid #46dcff;margin: 0 auto;line-height: 60px;">
								<span style="color: #46dcff;font-size: 60px;font-weight: bolder;letter-spacing:-5px;">INNOVATION</span></div>
							<div
								style="font-size: 18px;color:rgba(255,255,255,0.7);line-height: 30px;margin-top:10px;">
								</br>可为装饰行业定制三维智能设计软件、私有模型库</br>无缝对接企业预算、主材管理、施工管理以及ERP系统。
							</div>
						</div>
					</div>
					<div class="item">
						<img data="/jingcaimaven/images/zyunhomepage/banner1.png"
							src="/jingcaimaven/images/zyunhomepage/1(1).jpg"
							style="width: 100%;height: 100%;" id="img1" class="lazy"
							data-original="/jingcaimaven/images/zyunhomepage/banner1.png">
						<div class="carousel-caption" style="bottom:40%" id="first_first2">
							<div style="font-size: 48px;color: white;">精采联盟</div>
							<div
								style="font-size: 18px;color: white;margin-top: 25px;margin-bottom: 23px">引领家装行业进入智能设计时代</div>
							<div style="width: 350px;height: 70px;border-bottom: 1px solid #46dcff;margin: 0 auto;line-height: 60px;">
								<span style="color: #46dcff;font-size: 60px;font-weight: bolder;letter-spacing:-5px;">PROFESSION</span></div>
							<div
								style="font-size: 18px;color:rgba(255,255,255,0.7);line-height: 30px;margin-top:10px;">
								</br> 公司创业团队源于国内著名"211，985,"双一流"高校一一东南大学</br>由在三维室内设计软件领域具有丰富研发经验的教授、博士、硕士</br>
								以及具有丰富设计经验的资深室内设计精英所组成
							</div>
						</div>
					</div>


			
				</div>
				<!-- 轮播（Carousel）指标 -->
				<ol class="carousel-indicators" style="bottom: 20%">
					<li data-target="#myCarousel" data-slide-to="0"
						class="active index"></li>
					<li data-target="#myCarousel" data-slide-to="1" class="index"></li>
					<li data-target="#myCarousel" data-slide-to="2" class="index"></li>
				</ol>
			</div>

			<div class="mard">
<!-- 				<marquee behavior="scroll"> ${news }</marquee> -->
				<marquee behavior="scroll"><a  target="_blank">精采联盟与中国好宜家达成并签署合作协议</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</marquee>
				<a href="/news/newslist.html" target="_blank"><img
					src="/jingcaimaven/images/zyunhomepage/newsmore.png"></a>
			</div>
			<div class="md">
				<a class="ha s2" href="javascript:void(0);"><img
					src="/jingcaimaven/images/zyunhomepage/arrow.png" alt="前往下一页" title="前往下一页"></a>
			</div>
		</div>

		<!-- ---------------------------------------------------------------------------------------------- -->
		<div class="second section" style="overflow: hidden;">
			<div style="width: 100%;height: 100%;position: absolute;text-align: center;">
				<img src="/jingcaimaven/images/cpts/bg.png"
					style="width: 100%;height: 100%">
			</div>
			<div class="cpte_div" id="second_second">
				<div id="myCarousel1" class="carousel slide " data-ride="carousel" data-interval="6000">
					<div class="carousel-inner" style="height: 100%;width: 100%">
						<div class="item active">
							<div class="citfont1">玩转设计 满足各种功能</div>
							<div class="citfont2">整体方案一拖既得，自动匹配户型；标准化个性设计，万种风格的软硬装随意搭配；完全个性化设计，线下互动式体验设计。</div>
							<img src="/jingcaimaven/images/cpts/tsbanner1.png">
						</div>
						<div class="item">
							<div class="citfont1">先商品后模型 模型既商品</div>
							<div class="citfont2">先有商品，再根据商品建模型，方案中使用的模型能够直接连接对应的商品，方便直接采购。而模型库随着商品的不断更新迭代而实时更新扩充。</div>
							<img style="    width: 80%;margin-left: 10%;" src="/jingcaimaven/images/cpts/tsbanner2.png">
						</div>
						<div class="item">
							<div class="citfont1">瞬间出效果 一次性成单</div>
							<div class="citfont2">720°全宅VR场景效果，不用学渲染，一键智能出全景图；5分钟极速云渲染，客户看效果不用等。</div>
							<img src="/jingcaimaven/images/cpts/tsbanner3.png">
						</div>

						<div class="item">
							<div class="citfont1">一键施工图 一键报价</div>
							<div class="citfont2">一键生成全套施工图，内含平面图，剖面图，立面图等。标注尺寸,材质。一键生成施工预算和产品清单。</div>
							<img style="margin-left: 15%; width: 60%;" src="/jingcaimaven/images/cpts/tsbanner4.png">
						</div>
					</div>

					<a class="carousel-control left" href="#myCarousel1"
						data-slide="prev"
						style="height: 100px;width: 40px;background-image: none;top:50%;"><img
						src="/jingcaimaven/images/cpts/left.png"></a> <a
						class="carousel-control right" href="#myCarousel1"
						data-slide="next"
						style="height: 100px;width: 40px;background-image: none;top:50%;"><img
						src="/jingcaimaven/images/cpts/right.png"></a>
				</div>
			</div>
			<div class="md">
				<a class="ha s2" href="javascript:void(0);"><img
					src="/jingcaimaven/images/zyunhomepage/arrow.png" alt="前往下一页" title="前往下一页"></a>
			</div>
		</div>
		<!-- ---------------------------------------------------------------------------------------------- -->
		<div class="third section" style="overflow: hidden;">
			<div style="width: 100%;height: 100%;position: absolute;">
				<img class="banner" src="/jingcaimaven/images/caseshow/bg.png"
					style="width: 100%;height: 100%">
			</div>
			<div
				style="width:100%;position: absolute;text-align:center;top: 25%;min-width: 886px;" id="third_third">
				<div class="thirdmodels">${models}
				
				</div>
				<div class="case_btn_div">
					<a href="/model/modellist.html" target="_blank"><button
							type="button" class="btn btn-info btn-lg">MORE</button></a>
				</div>
				<!-- <div class="case_btn_div">
					<a href="/model/modellist.html" target="_blank"><button
							type="button" class="btn btn-info btn-lg">MORE</button></a>
				</div> -->
			</div>
			<div class="md">
				<a class="ha s2" href="javascript:void(0);"><img
					src="/jingcaimaven/images/zyunhomepage/arrow.png" alt="前往下一页" title="前往下一页"></a>
			</div>
		</div>
		<!-- ---------------------------------------------------------------------------------------------- -->
		<div class="fourth section">
			<div style="width: 100%;height: 100%;position: absolute;">
				<img src="/jingcaimaven/images/jpfw/bg.png"
					style="width: 100%;height: 100%">
			</div>
			<div class="jpfu_div" id="show1">
				<div class="jpfu_div_pic" >
					<img style="box-shadow:0 1px 50px #333;" src="/jingcaimaven/images/jpfw/bz.png" >
				</div>
				<div class="jpfu_div_word">
			   <!-- <div style="width: 100%;height:40%;margin-top: 30%;">
						<div class="jpfu_div_word_1">赞云·云家</div>
						<div class="jpfu_div_word_2">大客户定制版</div>
						<div class="jpfu_div_word_3">试用于家装O2O、平台型大企业</div>
					</div> -->
					<div style="width: 100%;height:40%;margin-top: 30%;">
						<div class="jpfu_div_word_1">精采联盟</div>
						<div class="jpfu_div_word_2">标准版</div>
						<div class="jpfu_div_word_3">适用于装修公司、家具品牌厂商</div>
					</div>
					<div
						style="height: 20%;width: 100%;text-align: right;margin-top: 50px;">
						<a href="/index/details.html" target="_blank"><button
								type="button" class="btn btn-info btn-lg">了解更多</button></a>
					</div>
				</div>
			</div>
			<div class="jpfu_div display" id="show2">
				<div class="jpfu_div_pic">
					<img style="box-shadow:0 1px 50px #333;" src="/jingcaimaven/images/jpfw/dz.png">
				</div>
				<div class="jpfu_div_word">
					<div style="width: 100%;height:40%;margin-top: 30%;">
						<div class="jpfu_div_word_1">精采联盟</div>
						<div class="jpfu_div_word_2">大客户定制版</div>
						<div class="jpfu_div_word_3">适用于家装O2O、平台型大企业</div>
					</div>
					<div
						style="height: 20%;width: 100%;text-align: right;margin-top: 50px;">
						<a href="/index/details.html" target="_blank"
							target="_blank">
							<button type="button" class="btn btn-info btn-lg">了解更多</button>
						</a>
					</div>
				</div>
			</div>
			<div class="jpfu_div_btn">
				<div>
					<button type="button" class="btn btn-info " id="standard" onclick="jpbutton1()">标准版</button> <button type="button" class="btn  " id="cust" onclick="jpbutton2()">定制版</button>
					<!-- <img src="/images/jpfw/standard-click.png"
						id="standard" onclick="jpbutton1()"> <img
						src="/images/jpfw/cust.png" id="cust"
						onclick="jpbutton2()"> -->
				</div>
			</div>
			<div class="md">
				<a class="ha s2" href="javascript:void(0);"><img
					src="/jingcaimaven/images/zyunhomepage/arrow.png" alt="前往下一页" title="前往下一页" title="前往下一页"></a>
			</div>
		</div>
		<!-------------------------------------------------------------------------------------------------->
		<div class="fifth section">
			<div style="width: 100%;height: 100%;position: absolute;">
				<img src="/jingcaimaven/images/rjxz/bg.png"
					style="width: 100%;height: 100%">
			</div>
			<div class="rjxz_div" id="fifth_fifth">
				<div class="rjxz_div_w1">为中国室内装饰行业提供最领先的智能家装互联网解决方案</div>
				<div class="rjxz_div_w2" style="margin-top: 47px">智能生成设计方案</div>
				<div class="rjxz_div_w2">一键渲染、一键出施工图、一键出预算</div>
				<div class="rjxz_div_w2">无缝对接企业ERP</div>
				<div class="rjxz_div_w2">引领中国室内装饰行业进入智能时代!</div>
				<div class="rjxz_button_div">
					<button type="button" class="btn btn-info btn-lg" onclick="jqqd()">查看更多软件介绍</button>
					<button type="button" class="btn btn-info btn-lg"  onclick="jqqd()">下载软件</button>
				</div>
			</div>
			<!-- <div class="rjxz_button_div">
 
				<img src="/images/rjxz/watchmore.png"
					class="rjxz_rbutton" id="watchmore"> <img
					src="/images/rjxz/down.png" class="rjxz_rbutton"
					id="down" style="margin-left: 5%">

			</div> -->
			<div class="md">
				<a class="ha s2" href="javascript:void(0);"><img
					src="/jingcaimaven/images/zyunhomepage/arrow.png" alt="前往下一页" title="前往下一页"></a>
			</div>
		</div>
		<!-------------------------------------------------------------------------------------------------->
		<div class="sixth section">
			<div style="width: 100%;height: 100%;position: absolute;">

				<img src="/jingcaimaven/images/zyxt/bg.png"
					style="width: 100%;height: 100%;">

			</div>
			<div class="zyxt_div" id="sixth_sixth">
				<div style="height: 100%;width: 60%;float: left;">
					<div style="position: relative;width: 100%;height: 100%;">
					<a href="https://v.qq.com/x/page/r0553bc1bjp.html" target="_blank">	<img src="/jingcaimaven/images/zyxt/zyxtbg.png"
							style="position:absolute;">
						<button class="zyxt_vodio_btn">
							<img src="/jingcaimaven/images/zyxt/play.png"/>
						</button></a>
					</div>
				</div>
				<div class="zuxt_word">
					<div class="zyxt_w1">精采学堂</div>
					<div class="zyxt_w2">视频内容介绍</div>
					<div class="zuxt_btn_div">
						<a href="/index/video.html" target="_blank"><button type="button" class="btn btn-info btn-lg">进入学堂</button></a>

					</div>
				</div>
			</div>
		<div class="md">
				<a class="ha s2" href="javascript:void(0);"><img
					src="/jingcaimaven/images/zyunhomepage/arrow.png" alt="前往下一页" title="前往下一页"></a>
			</div>
		</div>
		<!-------------------------------------------------------------------------------------------------->
		<div class="seventh section">
			<div style="width: 100%;height: 100%;">
				<div style="width: 100%;height: 100%;position: absolute;">
					<img src="/jingcaimaven/images/lxwm/bg.png"
						style="width: 100%;height: 100%">
				</div>
				<div
					style="width:600px;height:200px;position:relative;top:40%;margin: 0 auto;"  id="seventh_seventh">
					<div style="height: 100%;width:154px;float: left;">
						<img src="/jingcaimaven/images/lxwm/logo-big.png">
					</div>
					<!-- <div
						style="width: 300px;height:20%;float: left;margin-left: 70px;margin-top:40px">
						<img src="/jingcaimaven/images/lxwm/400-8844121.png">
					</div> -->
					<div
						style="width: 300px;height:20%;float: left;margin-left: 70px;;font-family: MicrosoftYaHei;color:#666666;font-size: 18px">
						Email: 992321590@qq.com</div>
					<div
						style="width: 300px;height: 20%;float: left;margin-left: 70px;;font-family: MicrosoftYaHei;color:#666666;font-size: 18px">
						<div style="float: left;">电话：0760-85213992</div>
						<div style="font-size: 10px;float: left;margin-top:5px">(9:00-18:00)</div>
					</div>
					<div
						style="width: 350px;height: 20%;float: left;margin-left: 70px;;font-family: MicrosoftYaHei;color:#666666;font-size: 18px">
						地址：广东省中山市南朗镇岭南路33号盈彩美地19栋</div>
				</div>

			</div>
			<!--<div
				style="width:100%;text-align:center;position: absolute;top:95%;font-size: 14px;color: rgba(102,102,102,0.75);">精采联盟
				 版权所有 备案号:<a href="http://www.miibeian.gov.cn"  target="_blank" class="mPercent fontColDepBlue font10" >苏ICP备14050130号</a></div> -->
		</div>
	</div>
	<div class="modal" id="indexModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" style="width: 400px;">
			<div class="modal-content">

				<div class="modal-body">
					<div class="colse">
						<button
							style="float: right;margin-right: 10px;border: none;background-color: rgba(0,0,0,0);"
							onclick="closelogin()">
							<img src="/jingcaimaven/images/icon/colse.png">
						</button>
					</div>
				
					<div class="choose">
						<div class="c1">
							<span id="login" style="color: #46dcff;cursor:pointer;">账号登录</span>
						</div>
						<div class="c1">
							<span id="register" style="cursor:pointer;">注册账号</span>
						</div>
					</div>
					<div id="logindiv">
					<div class="logo">
						<img src="/jingcaimaven/images/icon/logo.png" style="width: 200px;height:114px;">
					</div>
					<div class="modaldiv" style="margin-top: 20px;">
					<img src="/jingcaimaven/images/icon/user.png"/><input id="zh"  type="text" style="" placeholder="账号"/>
					</div>
					<div class="ts">
							<span style="font-size: 12px;color: red" id="ts1"></span>
						</div>
					<div class="modaldiv" style="">
					<img src="/jingcaimaven/images/icon/lock.png"><input id="mm" type="password" style="" placeholder="密码"/>
					</div>
					<div class="ts">
							<span style="font-size: 12px;color: red" id="ts2"></span>
						</div>
						<div style="width: 100%;height: 40px;text-align: center;margin-top: 20px">
							<button type="button" class="btn btn-info btn-block loginbt">登录</button>
							
						</div>

						<div
							style="width: 100%;height:5%;padding-left:70%;margin-top: 15px">
							<a class="wj" style="text-shadow:none;">忘记密码?</a>
						</div>
					</div>
					<div id="registerdiv" class="dis">
					<div class="modaldiv" style="width: 300px;height: 42px;line-height:40px;text-align: left;margin: auto auto;border: 1px solid #DCDCDC;padding-left: 20px;margin-top: 20px;">
					<img src="/jingcaimaven/images/icon/user.png"/><input id="zh2" type="text"  placeholder="账号"/>
					</div>
					<div class="ts">
							<span id="ts3" style="font-size: 12px;color: red" ></span>
						</div>
					<div class="modaldiv" style="width: 300px;height: 42px;line-height:40px;text-align: left;margin: auto auto;border: 1px solid #DCDCDC;padding-left: 20px;">
					<img src="/jingcaimaven/images/icon/lock.png"><input id="mm2" type="password"  placeholder="密码"/>
					</div>
					<div class="ts">
							<span style="font-size: 12px;color: red" id="ts4"  ></span>
						</div>
						<div class="modaldiv" style="width: 300px;height: 42px;line-height:40px;text-align: left;margin: auto auto;border: 1px solid #DCDCDC;padding-left: 20px;">
					<img src="/jingcaimaven/images/icon/lock.png"><input id="mm3" type="password"  placeholder="确认密码"/>
					</div>
					<div class="ts">
							<span style="font-size: 12px;color: red" id="ts5" ></span>
						</div>
						<div class="modaldiv" style="width: 300px;height: 42px;line-height:40px;text-align: left;margin: auto auto;border: 1px solid #DCDCDC;padding-left: 20px;">
					<img src="/jingcaimaven/images/icon/lock.png"><input id="email" type="text"  placeholder="邮箱"/>
					</div>
					<div class="ts">
							<span style="font-size: 12px;color: red" id="msgts"></span>
						</div>
						<div class="modaldiv" style="width: 300px;height: 42px;line-height:40px;text-align: left;margin: auto auto;border: 1px solid #DCDCDC;padding-left: 20px;">
					<img src="/jingcaimaven/images/icon/lock.png"><input id="yzm" type="text" style="width: 150px;" placeholder="验证码"/><button type="button" class="btn btn-info" onclick="getyzm()" id="getyzm">获取验证码</button>
					<input type="hidden" id="hiddenyzm"/>
					</div>
					<div class="ts">
							<span style="font-size: 12px;color: red" id="tsyzm" ></span>
						</div>
						 <div
							style="width: 100%;height: 40px;text-align: center;margin-top: 20px">
							<button type="button" class="btn btn-info btn-block registbtn">注册</button>
							
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
	<jsp:include page="../inc/personal.jsp"></jsp:include>
</body>
</html>
