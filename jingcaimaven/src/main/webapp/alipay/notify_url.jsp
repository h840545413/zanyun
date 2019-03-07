<%-- <%
/* *
 功能：支付宝服务器异步通知页面
 版本：3.3
 日期：2012-08-17
 说明：
 以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 该代码仅供学习和研究支付宝接口使用，只是提供一个参考。

 //***********页面功能说明***********
 创建该页面文件时，请留心该页面文件中无任何HTML代码及空格。
 该页面不能在本机电脑测试，请到服务器上做测试。请确保外部可以访问该页面。
 该页面调试工具请使用写文本函数logResult，该函数在com.alipay.util文件夹的AlipayNotify.java类文件中
 如果没有收到该页面返回的 success 信息，支付宝会在24小时内按一定的时间策略重发通知
 //********************************
 * */
%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.saintyhw.util.EnDecode64"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Date"%>

<%@ page import="java.util.*"%>
<%@ page import="java.util.Map"%>
<%@ page import="com.alipay.util.*"%>
<%@ page import="com.alipay.config.*"%>
<%@ page import="com.saintyhw.util.BatchSql"%>
<%@ page import="com.saintyhw.util.StringHelper"%>
<%@ page import="web.service.orderNumber.OrderNumberService"%>
<%@ page import="com.saintyhw.util.EnDecode64"%>

<jsp:directive.page import="org.springframework.web.context.WebApplicationContext" />
<%
	//获取支付宝POST过来反馈信息
	Map<String,String> params = new HashMap<String,String>();
	Map requestParams = request.getParameterMap();
	for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
		String name = (String) iter.next();
		String[] values = (String[]) requestParams.get(name);
		String valueStr = "";
		for (int i = 0; i < values.length; i++) {
			valueStr = (i == values.length - 1) ? valueStr + values[i]
					: valueStr + values[i] + ",";
		}
		//乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
		//valueStr = new String(valueStr.getBytes("ISO-8859-1"), "gbk");
		params.put(name, valueStr);
	}
	
	//获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//
	//商户订单号

	String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");

	//支付宝交易号

	String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");

	//交易状态
	String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"),"UTF-8");

	//获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//

	if(AlipayNotify.verify(params)){//验证成功
		//////////////////////////////////////////////////////////////////////////////////////////
		//请在这里加上商户的业务逻辑程序代码

		//——请根据您的业务逻辑来编写程序（以下代码仅作参考）——
		
		if(trade_status.equals("TRADE_FINISHED")||trade_status.equals("TRADE_SUCCESS")){
			//判断该笔订单是否在商户网站中已经做过处理
				//如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
				//如果有做过处理，不执行商户的业务程序
			
				
			 EnDecode64 code=new EnDecode64();
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
			WebApplicationContext context = (WebApplicationContext)this.getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);  
			OrderNumberService service = (OrderNumberService)context.getBean("orderNumberService"); 
			BatchSql  batch = new BatchSql();
		
		
		 String sql = "insert into t_alipaytb(body,buyer_email,buyer_id,exterface,is_success,notify_id,notify_time,"+
				" notify_type,out_trade_no,payment_type,seller_id,subject,total_fee,trade_no,trade_status,sign,sign_type,ordernumber)"+
				" values ('"+body+"','"+buyer_email+"','"+buyer_id+"','"+exterface+"','"+is_success+"','"+notify_id+"',convert(datetime,'"+notify_time+"', 120),"+
				"'"+notify_type+"','"+out_trade_no+"','"+payment_type+"','"+seller_id+"','"+subject+"','"+total_fee+"','"+trade_no
				+"','"+trade_status+"','"+sign+"','"+sign_type+"','"+ordernumber+"')";
		 batch.addBatch(sql);
		service.log.debug("保存支付宝返回信息sql:" + sql);
		sql="select operator_id from t_order_number where tempTradeNo = '"+out_trade_no+"'";
		service.log.equals("查找用户:" + sql);
		String operatorId=service.db.queryForString(sql);
		sql = "update t_order_number set status = '1' where tempTradeNo = '"+out_trade_no+"'";
		 batch.addBatch(sql);
		
		sql="if not EXISTS (SELECT * FROM t_money_details WHERE memo='"+out_trade_no+"') INSERT into t_money_details (operator_id,Createtime,money,zjx,status,memo) SELECT ton.operator_id,ton.createTime,ton.money,ton.zjx,ton.status,ton.tempTradeNo as memo FROM t_order_number ton WHERE ton.tempTradeNo='"+out_trade_no+"' ";
		 batch.addBatch(sql);
		
		sql="select money from t_user where operator_id='"+operatorId+"'";
		String money=service.db.queryForString(sql);
		float weight=0;
		if(money!=null&&!money.equals("")){
		money=code.decode64(money);
		 weight=Float.parseFloat(money)+Float.parseFloat(total_fee);}
		else{weight=Float.parseFloat(total_fee);}
		String momeyString=code.encode64(String.valueOf(weight));
		sql="update t_user set money='"+momeyString+"' where operator_id='"+operatorId+"'";
		 batch.addBatch(sql);
		 service.db.doInTransaction(batch);	
				
		
		} 

		//——请根据您的业务逻辑来编写程序（以上代码仅作参考）——
			
		out.println("success");	//请不要修改或删除

		//////////////////////////////////////////////////////////////////////////////////////////
	}else{//验证失败
		out.println("fail");
	}
%>
 --%>