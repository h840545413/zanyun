<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>404</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="/js/jquery.min.js"></script>
<script type="text/javascript" src="/js/bootstrap.min.js"></script>
<script type="text/javascript">
$(function(){
	/* var waitTime=5; */

	setTimeout(function() {
		window.location.href = "/";}, 10000);
	
});

</script>
  </head>
  
  <body style="width: 100%;height: 100%;">
  <div style="width: 100%;height: 100%;background-image: url('/yunsumaven/images/error/bg.png');text-align: center;margin-top: 200px;">
  <div style="background-image: url('/yunsumaven/images/error/404.png');width: 750px;height: 324px;margin: auto auto;"></div>
  <div style="margin-top: 40px;"><a href="/"><button class="btn btn-info">返回主页</button></a></div>
  </div>
  </body>
</html>
