package com.ant.scq.entity;

import java.math.BigDecimal;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "T_COURSE")
public class CourseInfo {
	private int id;
	/**
	 * 课程名称
	 */
	private String courseName;
	/**
	 * 课程简称
	 */
	private String courseSimpleName;
	/**
	 * 机构ID
	 */
	private TrainInfo trainId;
	/**
	 * 课程所属类别
	 */
	private MenuType typeId;
	/**
	 * 课程所属年级
	 */
	private String courseGrade;
	/**
	 * 课程所在教室地址
	 */
	private String courseClass;
	/**
	 * 课程所在教室编号
	 */
	private String courseClassNumber;
	/**
	 * 开课日期
	 */
	private String courseStartDate;
	/**
	 * 结课日期
	 */
	private String courseEndDate;
	
	/**
	 * 上课时间
	 */
	private String courseTime;
	/**
	 * 上课时间
	 */
	private String courseTimeRemark;
	
	/**
	 * 课程简介
	 */
	private String courseIntroduction;
	/**
	 * 学年
	 */
	private String courseYear;
	/**
	 * 课程教课的老师ID
	 */
	private TeacherInfo courseTeacher;
	/**
	 * 课程教课老师姓名
	 */
	private String teacherName;
	/**
	 * 课程收费方式
	 */
	private int coursePriceType;
	/**
	 * 是否为精选课程
	 */
	private int isCurated;
	/**
	 * 课程_课时
	 */
	private int courseHour;
	/**
	 * 课程费用
	 */
	private BigDecimal courseTotalPrice;
	/**
	 * 课程教材
	 */
	private String courseBook;
	/**
	 * 备注
	 */
	private String remark;

	/**
	 * 一级菜单选中值
	 */
	private String firstMenuNumber;
	/**
	 * 二级菜单选中值
	 */
	private String secondMenuNumber;
	/**
	 * 二级菜单选中值
	 */
	private String threeMenuNumber;

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

	@Column(name = "course_name", length = 100)
	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	@Column(name = "course_simple_name", length = 100)
	public String getCourseSimpleName() {
		return courseSimpleName;
	}

	public void setCourseSimpleName(String courseSimpleName) {
		this.courseSimpleName = courseSimpleName;
	}

	@ManyToOne
	@JoinColumn(name = "train_id")
	public TrainInfo getTrainId() {
		return trainId;
	}

	public void setTrainId(TrainInfo trainId) {
		this.trainId = trainId;
	}

	@ManyToOne
	@JoinColumn(name = "type_id")
	public MenuType getTypeId() {
		return typeId;
	}

	public void setTypeId(MenuType typeId) {
		this.typeId = typeId;
	}

	@Column(name = "course_grade", length = 100)
	public String getCourseGrade() {
		return courseGrade;
	}

	public void setCourseGrade(String courseGrade) {
		this.courseGrade = courseGrade;
	}

	@Column(name = "course_class", length = 100)
	public String getCourseClass() {
		return courseClass;
	}

	public void setCourseClass(String courseClass) {
		this.courseClass = courseClass;
	}

	@Column(name = "course_class_number", length = 100)
	public String getCourseClassNumber() {
		return courseClassNumber;
	}

	public void setCourseClassNumber(String courseClassNumber) {
		this.courseClassNumber = courseClassNumber;
	}

	@Column(name = "course_start_date",length = 100)
	public String getCourseStartDate() {
		return courseStartDate;
	}

	public void setCourseStartDate(String courseStartDate) {
		this.courseStartDate = courseStartDate;
	}

	@Column(name = "course_end_date",length = 100)
	public String getCourseEndDate() {
		return courseEndDate;
	}

	public void setCourseEndDate(String courseEndDate) {
		this.courseEndDate = courseEndDate;
	}
	
	@Column(name = "course_time",length = 100)
	public String getCourseTime() {
		return courseTime;
	}

	public void setCourseTime(String courseTime) {
		this.courseTime = courseTime;
	}

	@Column(name = "course_time_remark",length = 200)
	public String getCourseTimeRemark() {
		return courseTimeRemark;
	}

	public void setCourseTimeRemark(String courseTimeRemark) {
		this.courseTimeRemark = courseTimeRemark;
	}

	@Column(name = "course_introduction", length = 500)
	public String getCourseIntroduction() {
		return courseIntroduction;
	}

	public void setCourseIntroduction(String courseIntroduction) {
		this.courseIntroduction = courseIntroduction;
	}

	@Column(name = "course_year", length = 100)
	public String getCourseYear() {
		return courseYear;
	}

	public void setCourseYear(String courseYear) {
		this.courseYear = courseYear;
	}

	@ManyToOne
	@JoinColumn(name = "course_teacher")
	public TeacherInfo getCourseTeacher() {
		return courseTeacher;
	}

	public void setCourseTeacher(TeacherInfo courseTeacher) {
		this.courseTeacher = courseTeacher;
	}

	@Column(name = "teacher_name", length = 100)
	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	@Column(name = "course_price_type")
	public int getCoursePriceType() {
		return coursePriceType;
	}

	public void setCoursePriceType(int coursePriceType) {
		this.coursePriceType = coursePriceType;
	}

	@Column(name = "is_curated")
	public int getIsCurated() {
		return isCurated;
	}

	public void setIsCurated(int isCurated) {
		this.isCurated = isCurated;
	}

	@Column(name = "course_hour")
	public int getCourseHour() {
		return courseHour;
	}

	public void setCourseHour(int courseHour) {
		this.courseHour = courseHour;
	}

	@Column(name = "course_total_price")
	public BigDecimal getCourseTotalPrice() {
		return courseTotalPrice;
	}

	public void setCourseTotalPrice(BigDecimal courseTotalPrice) {
		this.courseTotalPrice = courseTotalPrice;
	}

	@Column(name = "course_book")
	public String getCourseBook() {
		return courseBook;
	}

	public void setCourseBook(String courseBook) {
		this.courseBook = courseBook;
	}

	@Column(name = "remark", length = 500)
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Transient
	public String getFirstMenuNumber() {
		return firstMenuNumber;
	}

	public void setFirstMenuNumber(String firstMenuNumber) {
		this.firstMenuNumber = firstMenuNumber;
	}

	@Transient
	public String getSecondMenuNumber() {
		return secondMenuNumber;
	}

	public void setSecondMenuNumber(String secondMenuNumber) {
		this.secondMenuNumber = secondMenuNumber;
	}

	@Transient
	public String getThreeMenuNumber() {
		return threeMenuNumber;
	}

	public void setThreeMenuNumber(String threeMenuNumber) {
		this.threeMenuNumber = threeMenuNumber;
	}

}