package com.ant.scq.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 区
 * 
 * @author super
 *
 */
@Entity
@Table(name = "hat_area")
public class Area {
	private int id;

	private String areaId;

	private String area;

	private String father;

	@Id
	// 采用数据库自增方式生成主键
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "areaID", length = 50)
	public String getAreaId() {
		return areaId;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

	@Column(name = "area", length = 60)
	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	@Column(name = "father", length = 6)
	public String getFather() {
		return father;
	}

	public void setFather(String father) {
		this.father = father;
	}

}