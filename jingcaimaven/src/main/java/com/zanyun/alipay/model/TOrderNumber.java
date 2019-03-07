package com.zanyun.alipay.model;

import java.math.BigDecimal;

public class TOrderNumber {
    private Integer id;

    private String name;

    private String operatorId;

    private String temptradeno;

    private BigDecimal money;

    private String status;

    private String zjx;

    private Long createdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId == null ? null : operatorId.trim();
    }

    public String getTemptradeno() {
        return temptradeno;
    }

    public void setTemptradeno(String temptradeno) {
        this.temptradeno = temptradeno == null ? null : temptradeno.trim();
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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