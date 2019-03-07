package com.zanyun.model;

public class ZySucaikuLogin {
    private Integer id;

    private String operatorId;

    private Long loginTime;

    private String ip;

    private String dongleKey;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId == null ? null : operatorId.trim();
    }

    public Long getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Long loginTime) {
        this.loginTime = loginTime;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getDongleKey() {
        return dongleKey;
    }

    public void setDongleKey(String dongleKey) {
        this.dongleKey = dongleKey == null ? null : dongleKey.trim();
    }
}