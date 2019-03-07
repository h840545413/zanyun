package com.zanyun.org.model;

import java.util.Date;

public class ZyDongleKeyCheckHz {
    private Integer id;

    private String uniqueKey;

    private String dongleKey;

    private Integer checkHour;

    private Date checktime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUniqueKey() {
        return uniqueKey;
    }

    public void setUniqueKey(String uniqueKey) {
        this.uniqueKey = uniqueKey == null ? null : uniqueKey.trim();
    }

    public String getDongleKey() {
        return dongleKey;
    }

    public void setDongleKey(String dongleKey) {
        this.dongleKey = dongleKey == null ? null : dongleKey.trim();
    }

    public Integer getCheckHour() {
        return checkHour;
    }

    public void setCheckHour(Integer checkHour) {
        this.checkHour = checkHour;
    }

    public Date getChecktime() {
        return checktime;
    }

    public void setChecktime(Date checktime) {
        this.checktime = checktime;
    }
}