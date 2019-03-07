package com.zanyun.model;

public class TVideo {
	private Integer id;

	private String videoname;

	private String videofile;

	private String videourl;

	private String videomenu;

	private String status;

	private String type;

	private Integer orderv;

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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getVideoname() {
		return videoname;
	}

	public void setVideoname(String videoname) {
		this.videoname = videoname == null ? null : videoname.trim();
	}

	public String getVideofile() {
		return videofile;
	}

	public void setVideofile(String videofile) {
		this.videofile = videofile == null ? null : videofile.trim();
	}

	public String getVideourl() {
		return videourl;
	}

	public void setVideourl(String videourl) {
		this.videourl = videourl == null ? null : videourl.trim();
	}

	public String getVideomenu() {
		return videomenu;
	}

	public void setVideomenu(String videomenu) {
		this.videomenu = videomenu == null ? null : videomenu.trim();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status == null ? null : status.trim();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type == null ? null : type.trim();
	}

	public Integer getOrderv() {
		return orderv;
	}

	public void setOrderv(Integer orderv) {
		this.orderv = orderv;
	}
}