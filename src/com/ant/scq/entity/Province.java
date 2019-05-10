package com.ant.scq.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 省
 * @author super
 *
 */
@Entity
@Table(name = "hat_province")
public class Province {
	private int id;

	private String provinceId;

	private String province;

	@Id
	// 采用数据库自增方式生成主键
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "provinceID", length = 6)
	public String getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}

	@Column(name = "province", length = 40)
	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

}