package com.zanyun.alipay.service;

import com.zanyun.alipay.model.Alipay;
import com.zanyun.alipay.model.TAlipaytb;
import com.zanyun.alipay.model.TMoneyDetails;
import com.zanyun.alipay.model.TOrderNumber;


public interface AlipayService {

	Integer addOrderNumber(TOrderNumber orderNumber);

	String updateaAlipayOrder(Alipay alipay);

	

	Integer addAlipay(TAlipaytb alipaytb);

	TOrderNumber findOrderNumber(String tardeNo);

	Integer addMoneyDetails(TMoneyDetails moneyDetails);

	Integer updateOrderNumber(TOrderNumber orderNumber);

	



}
