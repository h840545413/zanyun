package com.zanyun.alipay.controller;

import java.math.BigDecimal;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alipay.util.UtilDate;
import com.zanyun.alipay.model.Alipay;
import com.zanyun.alipay.model.AlipayInfo;
import com.zanyun.alipay.model.TAlipaytb;
import com.zanyun.alipay.model.TMoneyDetails;
import com.zanyun.alipay.model.TOrderNumber;
import com.zanyun.alipay.service.AlipayService;
import com.zanyun.index.model.User;
import com.zanyun.model.TUser;
import com.zanyun.user.service.UserService;


@Controller
@RequestMapping("/alipay")
public class AlipayController {
	@Resource
	private AlipayService alipayService;
	@Resource
	private UserService userService;
	/**
	 * 支付宝支付页面配置
	 * @param alipayInfo
	 * @param request
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/frame.html",method=RequestMethod.GET)
	public String frame(@ModelAttribute AlipayInfo alipayInfo,HttpServletRequest request,HttpSession session ) throws Exception {
		User user=(User) session.getAttribute("user");
		if(user==null||"".equals(user.getOperatorId()))
		{
			
			return "redirect:/";
		}
		String WIDtotal_fee = alipayInfo.getMoney().toString();
		String tempTradeNo ="2"+ UtilDate.getOrderNum() + UtilDate.getThree();
		TOrderNumber orderNumber=new TOrderNumber();
		Date date=new Date();
		orderNumber.setCreatedate(date.getTime());
		orderNumber.setOperatorId(user.getOperatorId());
		orderNumber.setMoney(alipayInfo.getMoney());
		orderNumber.setTemptradeno(tempTradeNo);
		orderNumber.setName("zycz");
		orderNumber.setZjx("v2181");
		alipayService.addOrderNumber(orderNumber);
		request.setAttribute("WIDseller_email", "1215126611@qq.com");// 卖家支付宝账号
		request.setAttribute("WIDout_trade_no", tempTradeNo);// 商户订单号
		request.setAttribute("WIDsubject", "赞云充值");// 订单名称
		request.setAttribute("WIDtotal_fee", WIDtotal_fee);// 付款金额
		request.setAttribute("WIDshow_url", "http://www.zanyunjia.com/index/personalcenter");// 商品展示地址
		request.setAttribute("WIDbody", "赞云充值");// 团备注
		/*request.setAttribute("WIDshow_url", "http://www.zanyunjia.com/index/personalcenter");// 商品展示地址
*/		request.setAttribute("ip", request.getRemoteAddr());// 客户端的IP地址
		
		return "pay/alipayapi";
	}
	/**
	 * //添加支付宝订单记录
	 * @param alipay
	 * @return
	 */
	@SuppressWarnings("finally")
	@RequestMapping(value="/returnpage",method=RequestMethod.GET)
	//@ResponseBody
	public  String returnPage(@ModelAttribute Alipay alipay,HttpServletRequest request)
	{
		Date date=new Date();
		
		try {
			TOrderNumber orderNumber=alipayService.findOrderNumber(alipay.getOut_trade_no());
			if(orderNumber.getStatus().equals("1"))
			{
				return "index/loss";
				
			}
			alipayService.updateOrderNumber(orderNumber);
			TAlipaytb alipaytb=new TAlipaytb();
			alipaytb.setOutTradeNo(new String(alipay.getOut_trade_no().getBytes("ISO-8859-1"),"UTF-8"));
			alipaytb.setTradeNo(new String(alipay.getTrade_no().getBytes("ISO-8859-1"),"UTF-8"));
			alipaytb.setTradeStatus(new String(alipay.getTrade_status().getBytes("ISO-8859-1"),"UTF-8"));
			alipaytb.setBody(alipay.getBody());
			alipaytb.setBuyerEmail(alipay.getBuyer_email());
			alipaytb.setBuyerId(alipay.getBuyer_id());
			alipaytb.setExterface(alipay.getExterface());
			alipaytb.setIsSuccess(alipay.getIs_success());
			alipaytb.setNotifyId(alipay.getNotify_id());
			alipaytb.setNotifyTime(date.getTime());
			alipaytb.setNotifyType(alipay.getNotify_type());
			alipaytb.setOrdernumber(alipay.getOrdernumber());
			alipaytb.setPaymentType(alipay.getPayment_type());
			alipaytb.setSellerId(alipay.getSeller_id());
			alipaytb.setSign(alipay.getSign());
			alipaytb.setSignType(alipay.getSign_type());
			alipaytb.setSubject(alipay.getSubject());
			alipaytb.setTotalFee(new BigDecimal(alipay.getTotal_fee()));
		
			//Integer flag=
			if(alipayService.addAlipay(alipaytb)==0){return "fail";}
			TUser user=new TUser(); 
			user.setOperatorId(orderNumber.getOperatorId());
			user.setMoney(alipay.getTotal_fee());
			if(userService.updateUserMoney(user,"add").equals("error")){return "fail";}
			TMoneyDetails moneyDetails=new TMoneyDetails();
			moneyDetails.setCreatedate(date.getTime());
			moneyDetails.setMoney(alipaytb.getTotalFee());
			moneyDetails.setMemo("zycz");
			moneyDetails.setOperatorId(orderNumber.getOperatorId());
			moneyDetails.setZjx(orderNumber.getZjx());
			moneyDetails.setStatus(1);
			alipayService.addMoneyDetails(moneyDetails);
			request.setAttribute("money", alipay.getTotal_fee());
		} catch (Exception e) {
		e.printStackTrace();
		}finally{
			return "index/paysuccess";
			//return "redirect:/index/personalcenter.html";
		}
		
		//添加金额记录
		//更新订单状态
		//更新用户金额信息
		
		
		
	}

}
