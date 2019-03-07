package com.zanyun.alipay.model;

import java.math.BigDecimal;

public class TMoneyDetails {
    private Integer moneyDetailId;

    private String operatorId;

    private BigDecimal money;

    private Integer status;

    private String memo;

    private String zjx;

    private Long createdate;
private Integer start;
private Integer limit;
    public Integer getStart() {
	return start;
}

public void setStart(Integer start) {
	this.start = start;
}

public Integer getLimit() {
	return limit;
}

public void setLimit(Integer limit) {
	this.limit = limit;
}

	public Integer getMoneyDetailId() {
        return moneyDetailId;
    }

    public void setMoneyDetailId(Integer moneyDetailId) {
        this.moneyDetailId = moneyDetailId;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId == null ? null : operatorId.trim();
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public String getZjx() {
        return zjx;
    }

    public void setZjx(String zjx) {
        this.zjx = zjx == null ? null : zjx.trim();
    }

    public Long getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Long createdate) {
        this.createdate = createdate;
    }
}