package com.ant.scq.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "T_TRAIN")
public class TrainInfo {
	private int id;

	/**
	 * 机构名称
	 */
	private String trainName;
	/**
	 * 所属校区
	 */
	private String trainSchoolArea;
	/**
	 * 所在省
	 */
	private String registerProvince;
	/**
	 * 所在市
	 */
	private String registerCity;
	/**
	 * 所在区
	 */
	private String registerArea;
	/**
	 * 注册地址
	 */
	private String registerAddress;
	/**
	 * 负责人
	 */
	private String contactsName;
	/**
	 * 负责人电话
	 */
	private String contactsPhone;
	/**
	 * 报名电话
	 */
	private String enrollmentPhoneNumber;
	/**
	 * 营业执照
	 */
	private String license;
	/**
	 * 经度
	 */
	private String longitude;
	/**
	 * 纬度
	 */
	private String latitude;
	/**
	 * 机构特色
	 */
	private String trainSpecial;
	/**
	 * 机构规模
	 */
	private String trainScale;
	/**
	 * 机构简介
	 */
	private String introduction;
	/**
	 * 备注
	 */
	private String remark;

	/**
	 * 距离显示(不在数据库中存在)
	 */
	private String disance;

	// ---------------查询条件--------------
	// 距离
	private String querySelectDiance;
	// 区域
	private String querySelectArea;
	// 智能排序
	private String querySelectSmart;
	// 用户当前的经度
	private String currentLongitude;
	// 用户当前的纬度
	private String currentLatitude;

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

	@Column(name = "train_name", length = 100)
	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	@Column(name = "train_school_area", length = 100)
	public String getTrainSchoolArea() {
		return trainSchoolArea;
	}

	public void setTrainSchoolArea(String trainSchoolArea) {
		this.trainSchoolArea = trainSchoolArea;
	}

	@Column(name = "register_province", length = 60)
	public String getRegisterProvince() {
		return registerProvince;
	}

	public void setRegisterProvince(String registerProvince) {
		this.registerProvince = registerProvince;
	}

	@Column(name = "register_city", length = 60)
	public String getRegisterCity() {
		return registerCity;
	}

	public void setRegisterCity(String registerCity) {
		this.registerCity = registerCity;
	}

	@Column(name = "register_area", length = 60)
	public String getRegisterArea() {
		return registerArea;
	}

	public void setRegisterArea(String registerArea) {
		this.registerArea = registerArea;
	}

	@Column(name = "register_address", length = 200)
	public String getRegisterAddress() {
		return registerAddress;
	}

	public void setRegisterAddress(String registerAddress) {
		this.registerAddress = registerAddress;
	}

	@Column(name = "contacts_name", length = 100)
	public String getContactsName() {
		return contactsName;
	}

	public void setContactsName(String contactsName) {
		this.contactsName = contactsName;
	}

	@Column(name = "contacts_phone", length = 100)
	public String getContactsPhone() {
		return contactsPhone;
	}

	public void setContactsPhone(String contactsPhone) {
		this.contactsPhone = contactsPhone;
	}

	@Column(name = "enrollment_phone_number", length = 100)
	public String getEnrollmentPhoneNumber() {
		return enrollmentPhoneNumber;
	}

	public void setEnrollmentPhoneNumber(String enrollmentPhoneNumber) {
		this.enrollmentPhoneNumber = enrollmentPhoneNumber;
	}

	@Column(name = "license", length = 100)
	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	@Column(name = "longitude", length = 100)
	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	@Column(name = "latitude", length = 100)
	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	@Column(name = "train_special", length = 200)
	public String getTrainSpecial() {
		return trainSpecial;
	}

	public void setTrainSpecial(String trainSpecial) {
		this.trainSpecial = trainSpecial;
	}

	@Column(name = "train_scale", length = 60)
	public String getTrainScale() {
		return trainScale;
	}

	public void setTrainScale(String trainScale) {
		this.trainScale = trainScale;
	}

	@Column(name = "introduction", length = 500)
	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	@Column(name = "remark", length = 500)
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Transient
	public String getDisance() {
		return disance;
	}

	public void setDisance(String disance) {
		this.disance = disance;
	}

	@Transient
	public String getQuerySelectDiance() {
		return querySelectDiance;
	}

	public void setQuerySelectDiance(String querySelectDiance) {
		this.querySelectDiance = querySelectDiance;
	}

	@Transient
	public String getQuerySelectArea() {
		return querySelectArea;
	}

	public void setQuerySelectArea(String querySelectArea) {
		this.querySelectArea = querySelectArea;
	}

	@Transient
	public String getQuerySelectSmart() {
		return querySelectSmart;
	}

	public void setQuerySelectSmart(String querySelectSmart) {
		this.querySelectSmart = querySelectSmart;
	}

	@Transient
	public String getCurrentLongitude() {
		return currentLongitude;
	}

	public void setCurrentLongitude(String currentLongitude) {
		this.currentLongitude = currentLongitude;
	}

	@Transient
	public String getCurrentLatitude() {
		return currentLatitude;
	}

	public void setCurrentLatitude(String currentLatitude) {
		this.currentLatitude = currentLatitude;
	}

}