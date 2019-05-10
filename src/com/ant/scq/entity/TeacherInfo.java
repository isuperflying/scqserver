package com.ant.scq.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "T_TEACHER")
public class TeacherInfo {
	private int id;
	/**
	 * 培训机构
	 */
	private TrainInfo trainId;
	/**
	 * 老师编号
	 */
	private String teacherNumber;
	/**
	 * 老师姓名
	 */
	private String teacherName;
	/**
	 * 性别
	 */
	private int sex;
	/**
	 * 年龄
	 */
	private int age;
	/**
	 * 教龄
	 */
	private Float teacherAge;
	/**
	 * 手机号
	 */
	private String phoneNumber;
	/**
	 * 邮箱
	 */
	private String emailNumber;
	/**
	 * 老师特色
	 */
	private String teacherSpecial;
	/**
	 * 擅长
	 */
	private String teacherStrong;
	/**
	 * 备注
	 */
	private String remark;

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

	@ManyToOne
	@JoinColumn(name = "train_id")
	public TrainInfo getTrainId() {
		return trainId;
	}

	public void setTrainId(TrainInfo trainId) {
		this.trainId = trainId;
	}

	@Column(name = "teacher_number", length = 100)
	public String getTeacherNumber() {
		return teacherNumber;
	}

	public void setTeacherNumber(String teacherNumber) {
		this.teacherNumber = teacherNumber;
	}

	@Column(name = "teacher_name", length = 100)
	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
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

	@Column(name = "teacher_age")
	public Float getTeacherAge() {
		return teacherAge;
	}

	public void setTeacherAge(Float teacherAge) {
		this.teacherAge = teacherAge;
	}

	@Column(name = "phone_number", length = 100)
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Column(name = "email_number", length = 100)
	public String getEmailNumber() {
		return emailNumber;
	}

	public void setEmailNumber(String emailNumber) {
		this.emailNumber = emailNumber;
	}

	@Column(name = "teacher_special", length = 200)
	public String getTeacherSpecial() {
		return teacherSpecial;
	}

	public void setTeacherSpecial(String teacherSpecial) {
		this.teacherSpecial = teacherSpecial;
	}

	@Column(name = "teacher_strong", length = 200)
	public String getTeacherStrong() {
		return teacherStrong;
	}

	public void setTeacherStrong(String teacherStrong) {
		this.teacherStrong = teacherStrong;
	}

	@Column(name = "remark", length = 500)
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}