package com.zanyun.model;

public class ProThirdClass {
    private String thirdName;

    private Integer secondId;

    private Integer thirdId;

    private String banben;

    private Integer status;

    private Integer ordert;

    public String getThirdName() {
        return thirdName;
    }

    public void setThirdName(String thirdName) {
        this.thirdName = thirdName == null ? null : thirdName.trim();
    }

    public Integer getSecondId() {
        return secondId;
    }

    public void setSecondId(Integer secondId) {
        this.secondId = secondId;
    }

    public Integer getThirdId() {
        return thirdId;
    }

    public void setThirdId(Integer thirdId) {
        this.thirdId = thirdId;
    }

    public String getBanben() {
        return banben;
    }

    public void setBanben(String banben) {
        this.banben = banben == null ? null : banben.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getOrdert() {
        return ordert;
    }

    public void setOrdert(Integer ordert) {
        this.ordert = ordert;
    }
}