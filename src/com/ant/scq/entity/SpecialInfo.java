package com.ant.scq.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "scq_special")
public class SpecialInfo {

	private int id;

	private String name;

	private String cover;

	private int isShow;
	
	private int specialType;
	
	private String jumpPath;
	
	private String appId;
	
	private String originalId;
	
	private String addDate;

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

	@Column(name = "name",length = 200)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "cover",length = 200)
	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	@Column(name = "is_show")
	public int getIsShow() {
		return isShow;
	}

	public void setIsShow(int isShow) {
		this.isShow = isShow;
	}
	
	@Column(name = "special_type")
	public int getSpecialType() {
		return specialType;
	}

	public void setSpecialType(int specialType) {
		this.specialType = specialType;
	}
	
	
	@Column(name = "jump_path", length = 200)
	public String getJumpPath() {
		return jumpPath;
	}

	public void setJumpPath(String jumpPath) {
		this.jumpPath = jumpPath;
	}

	@Column(name = "app_id",length = 100)
	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	@Column(name = "original_id",length = 100)
	public String getOriginalId() {
		return originalId;
	}

	public void setOriginalId(String originalId) {
		this.originalId = originalId;
	}

	@Column(name = "add_date",length = 100)
	public String getAddDate() {
		return addDate;
	}

	public void setAddDate(String addDate) {
		this.addDate = addDate;
	}
	
}