package com.zanyun.render.model;

import java.math.BigDecimal;
import java.util.Date;

public class TNewRenderrecord {
    private Integer id;

    private String sn;

    private String orderid;

    private String subid;

    private String userid;

    private String xyuserid;

    private BigDecimal cost;

    private String sign;

    private BigDecimal ykmoney;

    private Integer status;

    private Date createdate;

    private String xykey;

    private String xyvalue;

    private Integer width;

    private Integer height;

    private String xyLoginName;

    private Date startTime;

    private Date endTime;

    private String orderstate;

    private Integer nuclearhours;

    private String beizhu;

    private String costno;

    private Long paytime;

    private Long begintime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn == null ? null : sn.trim();
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid == null ? null : orderid.trim();
    }

    public String getSubid() {
        return subid;
    }

    public void setSubid(String subid) {
        this.subid = subid == null ? null : subid.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getXyuserid() {
        return xyuserid;
    }

    public void setXyuserid(String xyuserid) {
        this.xyuserid = xyuserid == null ? null : xyuserid.trim();
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign == null ? null : sign.trim();
    }

    public BigDecimal getYkmoney() {
        return ykmoney;
    }

    public void setYkmoney(BigDecimal ykmoney) {
        this.ykmoney = ykmoney;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getXykey() {
        return xykey;
    }

    public void setXykey(String xykey) {
        this.xykey = xykey == null ? null : xykey.trim();
    }

    public String getXyvalue() {
        return xyvalue;
    }

    public void setXyvalue(String xyvalue) {
        this.xyvalue = xyvalue == null ? null : xyvalue.trim();
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

    public String getXyLoginName() {
        return xyLoginName;
    }

    public void setXyLoginName(String xyLoginName) {
        this.xyLoginName = xyLoginName == null ? null : xyLoginName.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getOrderstate() {
        return orderstate;
    }

    public void setOrderstate(String orderstate) {
        this.orderstate = orderstate == null ? null : orderstate.trim();
    }

    public Integer getNuclearhours() {
        return nuclearhours;
    }

    public void setNuclearhours(Integer nuclearhours) {
        this.nuclearhours = nuclearhours;
    }

    public String getBeizhu() {
        return beizhu;
    }

    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu == null ? null : beizhu.trim();
    }

    public String getCostno() {
        return costno;
    }

    public void setCostno(String costno) {
        this.costno = costno == null ? null : costno.trim();
    }

    public Long getPaytime() {
        return paytime;
    }

    public void setPaytime(Long paytime) {
        this.paytime = paytime;
    }

    public Long getBegintime() {
        return begintime;
    }

    public void setBegintime(Long begintime) {
        this.begintime = begintime;
    }
}