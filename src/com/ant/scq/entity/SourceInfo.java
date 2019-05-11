package com.ant.scq.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "scq_sc_info")
public class SourceInfo {
	
	private int id;

	private int scType;
	
	private int collectionId;
	
	private String scName;
	
	private int scIsVip;
	
	private double scPrice;
	
	private String scThumb;
		
	private String scPreImg;
	
	private String scBeforeImg;
	
	private String scAddDate;
	
	@Id
	// 采用数据库自增方式生成主键
	// @GeneratedValue(strategy=GenerationType.AUTO)
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "sc_type")
	public int getScType() {
		return scType;
	}
	
	public void setScType(int scType) {
		this.scType = scType;
	}

	@Column(name = "collection_id")
	public int getCollectionId() {
		return collectionId;
	}

	public void setCollectionId(int collectionId) {
		this.collectionId = collectionId;
	}

	@Column(name = "sc_name", length = 200)
	public String getScName() {
		return scName;
	}

	public void setScName(String scName) {
		this.scName = scName;
	}

	@Column(name = "sc_is_vip")
	public int getScIsVip() {
		return scIsVip;
	}

	public void setScIsVip(int scIsVip) {
		this.scIsVip = scIsVip;
	}

	@Column(name = "sc_price")
	public double getScPrice() {
		return scPrice;
	}

	public void setScPrice(double scPrice) {
		this.scPrice = scPrice;
	}

	@Column(name = "sc_thumb",length = 100)
	public String getScThumb() {
		return scThumb;
	}

	public void setScThumb(String scThumb) {
		this.scThumb = scThumb;
	}
	
	@Column(name = "sc_pre_img",length = 100)
	public String getScPreImg() {
		return scPreImg;
	}

	public void setScPreImg(String scPreImg) {
		this.scPreImg = scPreImg;
	}

	@Column(name = "sc_before_img",length = 100)
	public String getScBeforeImg() {
		return scBeforeImg;
	}

	public void setScBeforeImg(String scBeforeImg) {
		this.scBeforeImg = scBeforeImg;
	}

	@Column(name = "sc_add_date",length = 100)
	public String getScAddDate() {
		return scAddDate;
	}

	public void setScAddDate(String scAddDate) {
		this.scAddDate = scAddDate;
	}
	
}