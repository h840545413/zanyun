package com.zanyun.model;

import java.math.BigDecimal;

public class Render {
private String orderId;//订单
private String startTime;//开始时间
private String endTime;//结束时间
private String orderName;//订单名称
private String userId;//id
private Integer width;//宽度
private Integer height;//高度
private Integer status;//状态
private BigDecimal cost;//扣费
private String nuclearhours;//核小时
private String orderstate;//订单状态
private  BigDecimal ykmoney;
public String getOrderstate() {
	return orderstate;
}
public void setOrderstate(String orderstate) {
	this.orderstate = orderstate;
}
public String getOrderId() {
	return orderId;
}
public void setOrderId(String orderId) {
	this.orderId = orderId;
}
public String getStartTime() {
	return startTime;
}
public void setStartTime(String startTime) {
	this.startTime = startTime;
}
public String getEndTime() {
	return endTime;
}
public void setEndTime(String endTime) {
	this.endTime = endTime;
}
public String getOrderName() {
	return orderName;
}
public void setOrderName(String orderName) {
	this.orderName = orderName;
}
public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
public Integer getWidth() {
	return width;
}
public void setWidth(Integer width) {
	this.width = width;
}
public Integer getHeight() {
	return height;
}
public void setHeight(Integer height) {
	this.height = height;
}
public Integer getStatus() {
	return status;
}
public void setStatus(Integer status) {
	this.status = status;
}

public String getNuclearhours() {
	return nuclearhours;
}
public void setNuclearhours(String nuclearhours) {
	this.nuclearhours = nuclearhours;
}
public BigDecimal getCost() {
	return cost;
}
public void setCost(BigDecimal cost) {
	this.cost = cost;
}
public BigDecimal getYkmoney() {
	return ykmoney;
}
public void setYkmoney(BigDecimal ykmoney) {
	this.ykmoney = ykmoney;
}

}
