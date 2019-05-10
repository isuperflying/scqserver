package com.ant.scq.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 市
 * 
 * @author super
 *
 */
@Entity
@Table(name = "hat_city")
public class City {
	private int id;

	private String cityId;

	private String city;

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

	@Column(name = "cityID", length = 6)
	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	@Column(name = "city", length = 50)
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "father", length = 6)
	public String getFather() {
		return father;
	}

	public void setFather(String father) {
		this.father = father;
	}

}