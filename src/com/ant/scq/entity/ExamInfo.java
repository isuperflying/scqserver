package com.ant.scq.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "T_EXAM_INFO")
public class ExamInfo {
	private int id;

	/**
	 * 试卷编号
	 */
	private String examNumber;
	/**
	 * 试卷名称
	 */
	private String examName;
	/**
	 * 试卷内容
	 */
	private String examContent;

	/**
	 * 试卷附件文件路径
	 */
	private String examFilePath;
	/**
	 * 试卷考试开始时间
	 */
	private String examStartDate;
	/**
	 * 试卷考试结束时间
	 */
	private String examEndDate;
	/**
	 * 试卷考试时长
	 */
	private int examTotalTime;
	/**
	 * 试卷发布时间
	 */
	private String examAddDate;
	/**
	 * 备注
	 */
	private String remark;

	private int userExamState;
	
	private Integer examScore;
	
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

	@Column(name = "exam_number", length = 200)
	public String getExamNumber() {
		return examNumber;
	}

	public void setExamNumber(String examNumber) {
		this.examNumber = examNumber;
	}

	@Column(name = "exam_name", length = 200)
	public String getExamName() {
		return examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}
	
	@Column(name = "exam_content", length = 500)
	public String getExamContent() {
		return examContent;
	}

	public void setExamContent(String examContent) {
		this.examContent = examContent;
	}

	@Column(name = "exam_file_path", length = 200)
	public String getExamFilePath() {
		return examFilePath;
	}

	public void setExamFilePath(String examFilePath) {
		this.examFilePath = examFilePath;
	}

	@Column(name = "exam_start_date")
	public String getExamStartDate() {
		return examStartDate;
	}

	public void setExamStartDate(String examStartDate) {
		this.examStartDate = examStartDate;
	}

	@Column(name = "exam_end_date")
	public String getExamEndDate() {
		return examEndDate;
	}

	public void setExamEndDate(String examEndDate) {
		this.examEndDate = examEndDate;
	}

	
	@Column(name = "exam_total_time")
	public int getExamTotalTime() {
		return examTotalTime;
	}

	public void setExamTotalTime(int examTotalTime) {
		this.examTotalTime = examTotalTime;
	}

	@Column(name = "exam_add_date")
	public String getExamAddDate() {
		return examAddDate;
	}

	public void setExamAddDate(String examAddDate) {
		this.examAddDate = examAddDate;
	}

	@Column(name = "remark", length = 500)
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	
	@Transient
	public int getUserExamState() {
		return userExamState;
	}

	public void setUserExamState(int userExamState) {
		this.userExamState = userExamState;
	}

	@Transient
	public Integer getExamScore() {
		return examScore;
	}

	public void setExamScore(Integer examScore) {
		this.examScore = examScore;
	}
	
}