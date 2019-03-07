package com.zanyun.model;


import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @Author anyang
 * @CreateTime 2018/4/6
 * @Des
 */

public class Product {
  
    private Long id;

    private String taobaoKey;

    private String name;

    private BigDecimal costPrice;

    private Integer stock;

    private BigDecimal price;

    private BigDecimal secondkillPrice;

    private Integer popularity;

 
    private Long createdBy;

   
    private Timestamp createdAt;

    private Long updatedBy;

  
    private Timestamp updatedAt;

    private boolean active = true;

    private boolean deleted = false;

    private Long deletedBy;

   
    private Timestamp deletedAt;

private String describe;
private String icon;
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTaobaoKey() {
		return taobaoKey;
	}


	public void setTaobaoKey(String taobaoKey) {
		this.taobaoKey = taobaoKey;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public BigDecimal getCostPrice() {
		return costPrice;
	}


	public void setCostPrice(BigDecimal costPrice) {
		this.costPrice = costPrice;
	}


	public Integer getStock() {
		return stock;
	}


	public void setStock(Integer stock) {
		this.stock = stock;
	}


	public BigDecimal getPrice() {
		return price;
	}


	public void setPrice(BigDecimal price) {
		this.price = price;
	}


	public BigDecimal getSecondkillPrice() {
		return secondkillPrice;
	}


	public void setSecondkillPrice(BigDecimal secondkillPrice) {
		this.secondkillPrice = secondkillPrice;
	}


	public Integer getPopularity() {
		return popularity;
	}


	public void setPopularity(Integer popularity) {
		this.popularity = popularity;
	}


	public Long getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}


	public Timestamp getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}


	public Long getUpdatedBy() {
		return updatedBy;
	}


	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}


	public Timestamp getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}


	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}


	public boolean isDeleted() {
		return deleted;
	}


	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}


	public Long getDeletedBy() {
		return deletedBy;
	}


	public void setDeletedBy(Long deletedBy) {
		this.deletedBy = deletedBy;
	}


	public Timestamp getDeletedAt() {
		return deletedAt;
	}


	public void setDeletedAt(Timestamp deletedAt) {
		this.deletedAt = deletedAt;
	}


	public String getDescribe() {
		return describe;
	}


	public void setDescribe(String describe) {
		this.describe = describe;
	}


	public String getIcon() {
		return icon;
	}


	public void setIcon(String icon) {
		this.icon = icon;
	}


}
