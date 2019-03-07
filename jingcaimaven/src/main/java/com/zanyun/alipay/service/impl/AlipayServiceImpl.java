package com.zanyun.alipay.service.impl;


import java.util.Map;



import org.springframework.stereotype.Service;









import com.zanyun.alipay.model.Alipay;
import com.zanyun.alipay.model.TAlipaytb;
import com.zanyun.alipay.model.TMoneyDetails;
import com.zanyun.alipay.model.TOrderNumber;
import com.zanyun.alipay.service.AlipayService;


import com.zanyun.service.BaseService;
@Service
public class AlipayServiceImpl extends BaseService implements AlipayService {

	/**
	 * 更新支付宝订单信息
	 * @param alipay
	 * @return
	 */
	@Override
	public String updateaAlipayOrder(Alipay alipay)
	{
		
		
		return null;
	}
	
@Override
public Integer addOrderNumber(TOrderNumber orderNumber)
{orderNumber.setStatus("0");
	Map<String,String> map= super.objectToMap(orderNumber);
	
	Integer flag=super.httpInsertOrUpdate(COMMURL+"money/addordernumber", map);
	return flag;

}
@Override
public Integer updateOrderNumber(TOrderNumber orderNumber)
{
	orderNumber.setStatus("1");
	
	Integer flag=super.httpInsertOrUpdate(COMMURL+"money/updateordernumber", super.objectToMap(orderNumber));
	return flag;
}
@Override
public Integer addAlipay(TAlipaytb alipaytb)
{
	Integer flag=super.httpInsertOrUpdate(COMMURL+"money/addalipay", super.objectToMap(alipaytb));
	return flag;
}
@Override
public TOrderNumber findOrderNumber(String tardeNo)
{
	TOrderNumber orderNumber=super.httpObjectPrase(COMMURL+"money/findordernumber", "tardeNo", tardeNo, TOrderNumber.class);
	return orderNumber;

}
@Override
public Integer addMoneyDetails(TMoneyDetails moneyDetails)
{
	Integer flag=super.httpInsertOrUpdate(COMMURL+"money/addmoneydetail", super.objectToMap(moneyDetails));
	return flag;
}
}
