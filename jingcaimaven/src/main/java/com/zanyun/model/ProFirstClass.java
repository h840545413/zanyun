package com.zanyun.model;

public class ProFirstClass {
    private String firstName;

    private Integer firstId;

    private String banben;

    private Integer status;

    private Integer orderf;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName == null ? null : firstName.trim();
    }

    public Integer getFirstId() {
        return firstId;
    }

    public void setFirstId(Integer firstId) {
        this.firstId = firstId;
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

    public Integer getOrderf() {
        return orderf;
    }

    public void setOrderf(Integer orderf) {
        this.orderf = orderf;
    }
}