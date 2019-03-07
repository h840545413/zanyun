<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>精彩联盟登录页面</title>
    <meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />

<link href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="/jingcaimaven/css/zylogin/zylogin.css">

<link rel="stylesheet" href="/jingcaimaven/css/button.css">
<script src="/jingcaimaven/js/jquery.min.js"></script>
<script src="/jingcaimaven/js/bootstrap.min.js"></script>
<script src="/jingcaimaven/js/zylogin/login.js"></script>
<script language="JavaScript">
	
</script>
</head>
<body>
	<div class="all">
		<div class="page">
			<div class="colse">
				<button
					style="float: right;margin-right: 10px;border: none;background-color: rgba(0,0,0,0);"
					onclick="CloseWebPage()">
					<img src="/jingcaimaven/images/icon/colse.png" onclick="window.close()">
				</button>
			</div>
			<div class="logo">
				<img src="/jingcaimaven/images/icon/logo.png" style="height: 100%">
			</div>
			<div class="choose">
				<div class="c1">
					<span id="login" style="color: #46dcff;">账号登录</span>
				</div>
				<div class="c1">
					<span id="register">注册账号</span>
				</div>
			</div>
			<!-- 登录界面 -->
			<div id="logindiv">
				<div class="bg">
					<div class="in1">
						<img src="/jingcaimaven/images/icon/input.png" style="width: 100%">
					</div>
				</div>
				<div class="box">
					<div class="user">
						<img src="/jingcaimaven/images/icon/user.png" style="width: 50%">
					</div>
					<div style="height: 100%;width:80%;margin-left: 10%;padding-top:3%">
						<input type="text" class="word" placeholder="请输入账号" id="qzh">
					</div>
					<div class="ts">
						<span style="font-size: 12em;color: red" id="ts1"></span>
					</div>
				</div>
				<div class="bg">
					<div class="in1">
						<img src="/jingcaimaven/images/icon/input.png" style="width: 100%">
					</div>
				</div>
				<div class="box">
					<div class="user">
						<img src="/jingcaimaven/images/icon/lock.png" style="width: 50%">
					</div>
					<div style="height: 100%;width:80%;margin-left: 10%;padding-top:3%">
						<input type="password" class="word" placeholder="请输入密码" id="qmm">
					</div>
					<div class="ts">
						<span style="font-size: 12em;color: red" id="ts2"></span>
					</div>
				</div>
				<div
					style="width: 100%;height:10%;margin-top: 25px;padding:0 35px 0 35px;">
					<a class="button button-raised button-primary button-pill b1"
						onclick="check()">登录</a>
				</div>
				<div style="width: 100%;height:5%;padding-left:70%;margin-top: 15px">
					<a class="wj">忘记密码?</a>
				</div>
			</div>

			<!-- 注册界面 -->
			<div id="registerdiv" class="dis">
				<div class="bg">
					<div class="in1">
						<img src="/jingcaimaven/images/icon/input.png" style="width: 100%">
					</div>
				</div>
				<div class="box">
					<div class="user">
						<img src="/jingcaimaven/images/icon/user.png" style="width: 50%">
					</div>
					<div style="height: 100%;width:80%;margin-left: 10%;padding-top:3%">
						<input type="text" class="word" placeholder="输入账号" id="zh">
					</div>
					<div class="ts">
						<span style="font-size: 12em;color: red" id="ts3"></span>
					</div>
				</div>
				<div class="bg">
					<div class="in1">
						<img src="/jingcaimaven/images/icon/input.png" style="width: 100%">
					</div>
				</div>
				<div class="box">
					<div class="user">
						<img src="/jingcaimaven/images/icon/lock.png" style="width: 50%">
					</div>
					<div style="height: 100%;width:80%;margin-left: 10%;padding-top:3%">
						<input type="password" class="word" placeholder="输入密码" id="mm1">
					</div>
					<div class="ts">
						<span style="font-size: 12em;color: red" id="ts4"></span>
					</div>
				</div>
				<div class="bg">
					<div class="in1">
						<img src="/jingcaimaven/images/icon/input.png" style="width: 100%">
					</div>
				</div>
				<div class="box">
					<div class="user">
						<img src="/jingcaimaven/images/icon/lock.png" style="width: 50%">
					</div>
					<div style="height: 100%;width:80%;margin-left: 10%;padding-top:3%">
						<input type="password" class="word" placeholder="输入密码" id="mm2">
					</div>
					<div class="ts">
						<span style="font-size: 12em;color: red" id="ts5"></span>
					</div>
				</div>
				<div class="cb">
					<div style="float:left; ">
						<input type="checkbox" class="FengCheck">
					</div>
					<div class="ty">
						同意<a style="color: #46dcff">《注册用户协议》</a> <span style="color: red;"
							id="ts6">111</span>
					</div>
				</div>
				<div
					style="width: 100%;height:10%;margin-top:10px;padding:0 35px 0 35px;">
					<a class="button button-raised button-primary button-pill b1"
						onclick="tj()">立即注册</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
