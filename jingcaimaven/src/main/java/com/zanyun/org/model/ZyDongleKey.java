package com.zanyun.org.model;

import java.util.Date;

public class ZyDongleKey {
    private Integer id;

    private String dongleKey;

    private Integer state;

    private String dongleBatch;

    private Date createTime;

    private Date checkTime;

    private String orgNum;

    private String operatorId;

    private Integer muban;

    private Integer zyrender;

    private Integer thdrender;

    private String licenseKey;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDongleKey() {
        return dongleKey;
    }

    public void setDongleKey(String dongleKey) {
        this.dongleKey = dongleKey == null ? null : dongleKey.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getDongleBatch() {
        return dongleBatch;
    }

    public void setDongleBatch(String dongleBatch) {
        this.dongleBatch = dongleBatch == null ? null : dongleBatch.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public String getOrgNum() {
        return orgNum;
    }

    public void setOrgNum(String orgNum) {
        this.orgNum = orgNum == null ? null : orgNum.trim();
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId == null ? null : operatorId.trim();
    }

    public Integer getMuban() {
        return muban;
    }

    public void setMuban(Integer muban) {
        this.muban = muban;
    }

    public Integer getZyrender() {
        return zyrender;
    }

    public void setZyrender(Integer zyrender) {
        this.zyrender = zyrender;
    }

    public Integer getThdrender() {
        return thdrender;
    }

    public void setThdrender(Integer thdrender) {
        this.thdrender = thdrender;
    }

    public String getLicenseKey() {
        return licenseKey;
    }

    public void setLicenseKey(String licenseKey) {
        this.licenseKey = licenseKey == null ? null : licenseKey.trim();
    }
}