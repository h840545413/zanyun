package com.zanyun.render.model;

public class TUserXy {
    private Integer id;

    private String operatorId;

    private String xyloginname;

    private String xypassword;

    private String xyuserid;

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

    public String getXyloginname() {
        return xyloginname;
    }

    public void setXyloginname(String xyloginname) {
        this.xyloginname = xyloginname == null ? null : xyloginname.trim();
    }

    public String getXypassword() {
        return xypassword;
    }

    public void setXypassword(String xypassword) {
        this.xypassword = xypassword == null ? null : xypassword.trim();
    }

    public String getXyuserid() {
        return xyuserid;
    }

    public void setXyuserid(String xyuserid) {
        this.xyuserid = xyuserid == null ? null : xyuserid.trim();
    }
}