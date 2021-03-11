package com.ant.scq.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "T_SYSTEM_USER")
public class User {
	private int id;
	/**
	 * 用户名/账号
	 */
	private String userName;
	/**
	 * 密码
	 */
	private String passWord;
	/**
	 * 用户昵称
	 */
	private String nickName;
	/**
	 * 性别
	 */
	private int sex;
	/**
	 * 年龄
	 */
	private int age;
	/**
	 * 用户类别
	 */
	private Integer userType;//0普通用户，1管理员
	/**
	 * 身份证
	 */
	private String idCard;
	/**
	 * 联系地址
	 */
	private String address;
	/**
	 * 联系电话
	 */
	private String phoneNumber;
	/**
	 * 联系QQ
	 */
	private String qqNumber;
	/**
	 * 邮箱
	 */
	private String emailNumber;
	/**
	 * 收款账户
	 */
	private String receiveAccount;
	/**
	 * 账户余额
	 */
	private BigDecimal balance;
	/**
	 * 用户积分
	 */
	private int userIntegral;
	/**
	 * 备注
	 */
	private String remark;

	/**
	 * 验证码(不存在数据库中)
	 */
	private String security;
	
	
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

	@Column(name = "user_name", length = 100)
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "password", length = 100)
	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	@Column(name = "nick_name", length = 100)
	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Column(name = "sex")
	public int getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = 0;
		if (sex != null) {
			this.sex = sex;
		}
	}

	@Column(name = "age")
	public int getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = 0;
		if (age != null) {
			this.age = age;
		}
	}

	@Column(name = "user_type")
	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	@Column(name = "id_card", length = 100)
	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	@Column(name = "address", length = 200)
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "phone_number", length = 100)
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Column(name = "qq_number", length = 100)
	public String getQqNumber() {
		return qqNumber;
	}

	public void setQqNumber(String qqNumber) {
		this.qqNumber = qqNumber;
	}

	@Column(name = "email_number", length = 100)
	public String getEmailNumber() {
		return emailNumber;
	}

	public void setEmailNumber(String emailNumber) {
		this.emailNumber = emailNumber;
	}

	@Column(name = "receive_account", length = 100)
	public String getReceiveAccount() {
		return receiveAccount;
	}

	public void setReceiveAccount(String receiveAccount) {
		this.receiveAccount = receiveAccount;
	}

	@Column(name = "balance")
	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	@Column(name = "user_integral")
	public int getUserIntegral() {
		return userIntegral;
	}

	public void setUserIntegral(Integer userIntegral) {
		this.userIntegral = 0;
		if (userIntegral != null) {
			this.userIntegral = userIntegral;
		}
	}

	@Column(name = "remark", length = 500)
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Transient
	public String getSecurity() {
		return security;
	}

	public void setSecurity(String security) {
		this.security = security;
	}

}