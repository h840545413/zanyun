package com.zanyun.alipay.model;

import java.math.BigDecimal;

public class AlipayInfo {
private	BigDecimal money;
private String WIDsubject;
private String WIDbody;
public BigDecimal getMoney() {
	return money;
}

public void setMoney(BigDecimal money) {
	this.money = money;
}

public String getWIDsubject() {
	return WIDsubject;
}

public void setWIDsubject(String wIDsubject) {
	WIDsubject = wIDsubject;
}

public String getWIDbody() {
	return WIDbody;
}

public void setWIDbody(String wIDbody) {
	WIDbody = wIDbody;
}


}
