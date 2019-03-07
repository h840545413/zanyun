package com.zanyun.account.service;

import java.util.Map;

import com.zanyun.account.model.RenderSubmit;
import com.zanyun.alipay.model.TMoneyDetails;

public interface AccountService {

	Map<String, Object> findRenderList(RenderSubmit submit);

	Map<String, Object> moneydetails(TMoneyDetails moneyDetails, Integer start, Integer limit);

	Integer addMoneyDetails(TMoneyDetails moneyDetails);

}
