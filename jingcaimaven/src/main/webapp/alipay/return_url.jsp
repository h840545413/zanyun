<%-- <%@page import="com.saintyhw.util.EnDecode64"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.util.Map"%>
<%@ page import="com.alipay.util.*"%>
<%@ page import="com.alipay.config.*"%>
<%@ page import="com.saintyhw.util.BatchSql"%>
<%@ page import="com.saintyhw.util.StringHelper"%>
<%@ page import="web.service.orderNumber.OrderNumberService"%>
<%@ page import="com.saintyhw.util.EnDecode64" %>
<%@ page import="web.model.login.User"%>
<%@ page import="org.springframework.web.context.WebApplicationContext"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>支付宝页面跳转同步通知页面</title>
</head>
<body>
	<%
		EnDecode64 code=new EnDecode64();
		//获取支付宝GET过来反馈信息
		Map<String,String> params = new HashMap<String,String>();
		Map requestParams = request.getParameterMap();
		User user=(User)session.getAttribute("user");
		for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
		valueStr = (i == values.length - 1) ? valueStr + values[i]
				: valueStr + values[i] + ",";
			}
			//乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
			//valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
			params.put(name, valueStr);
		}
		//商户订单号
		String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
		//支付宝交易号
		String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");
		//交易状态
		String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"),"UTF-8");
		//获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//
		//计算得出通知验证结果
		boolean verify_result = AlipayNotify.verify(params);
		if(verify_result){//验证成功
			if(trade_status.equals("TRADE_FINISHED") || trade_status.equals("TRADE_SUCCESS")){
		String body = request.getParameter("body").toString();
		String ordernumber = body.substring(body.indexOf("@")+1);
		String buyer_email = request.getParameter("buyer_email").toString();
		String buyer_id = request.getParameter("buyer_id").toString();
		String exterface = request.getParameter("exterface").toString();
		String is_success = request.getParameter("is_success").toString();
		String notify_id = request.getParameter("notify_id").toString();
		String notify_time = request.getParameter("notify_time").toString();
		String notify_type = request.getParameter("notify_type").toString();
		String payment_type = request.getParameter("payment_type").toString();
		String seller_id = request.getParameter("seller_id").toString();
		String subject = request.getParameter("subject").toString();
		String total_fee = request.getParameter("total_fee").toString();
		String sign = request.getParameter("sign").toString();
		String sign_type = request.getParameter("sign_type").toString();
		
		/* WebApplicationContext context = (WebApplicationContext)this.getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);  
		OrderNumberService service = (OrderNumberService)context.getBean("orderNumberService"); 
		BatchSql  batchSql = new BatchSql();
			
		//Date data=new Date().
		String sql = "insert into t_alipaytb(body,buyer_email,buyer_id,exterface,is_success,notify_id,notify_time,"+
		" notify_type,out_trade_no,payment_type,seller_id,subject,total_fee,trade_no,trade_status,sign,sign_type,ordernumber)"+
		" values ('"+body+"','"+buyer_email+"','"+buyer_id+"','"+exterface+"','"+is_success+"','"+notify_id+"',convert(datetime,'"+notify_time+"', 120),"+
		"'"+notify_type+"','"+out_trade_no+"','"+payment_type+"','"+seller_id+"','"+subject+"','"+total_fee+"','"+trade_no
		+"','"+trade_status+"','"+sign+"','"+sign_type+"','"+ordernumber+"')";
		service.log.debug("保存支付宝返回信息sql:" + sql);
		batchSql.addBatch(sql);
		service.db.update(sql)
		sql = "update t_order_number set status = '1' where tempTradeNo = '"+out_trade_no+"'";
		service.log.debug("更改订单号信息sql:" + sql);
		batchSql.addBatch(sql);
			
		sql="INSERT into t_money_details (operator_id,Createtime,money,zjx,status) SELECT ton.operator_id,ton.createTime,ton.money,ton.zjx,ton.status FROM t_order_number ton WHERE ton.tempTradeNo='"+out_trade_no+"' ";
		service.log.debug("更改订单号信息sql:" + sql);
		batchSql.addBatch(sql);
		sql="select money from t_user where operator_id='"+user.getOperator_id()+"'";
		float weight=0;
		String money=service.db.queryForString(sql);
		if(money!=null&&!money.equals("")){
		
			money=code.decode64(money);
			 weight=Float.parseFloat(money)+Float.parseFloat(total_fee);}
			else{
				weight=Float.parseFloat(total_fee);
			}
			String momeyString=code.encode64(String.valueOf(weight));
			sql="update t_user set money='"+momeyString+"' where operator_id='"+user.getOperator_id()+"'";
			batchSql.addBatch(sql);
			service.db.doInTransaction(batchSql); */
	%>
	<script type="text/javascript">
		window.location.href = '192.168.1.115';
	</script>
	<%
		}

			//该页面可做页面美工编辑
			out.println("验证成功<br />");
			//——请根据您的业务逻辑来编写程序（以上代码仅作参考）——

			//////////////////////////////////////////////////////////////////////////////////////////
		} else {
			//该页面可做页面美工编辑
			out.println("验证失败");
		}
	%>
</body>
</html> --%>