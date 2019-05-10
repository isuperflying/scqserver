package com.ant.scq.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "T_USER_EXAM")
public class UserExam {
	private Integer id;
	/**
	 * 用户ID
	 */
	private User user;
	/**
	 * 课程ID
	 */
	private ExamInfo examInfo;
	/**
	 * 订单状态 0:未考试，1：已考试：2：通过，3：不通过
	 */
	private Integer examState;

	private Integer examUseTime = 0;

	private Double examScore;

	private Integer isMarkScore;//0未打分，1已打分
	
	/**
	 * 备注
	 */
	private String remark;

	@Id
	// 采用数据库自增方式生成主键
	// @GeneratedValue(strategy=GenerationType.AUTO)
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "user_id")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne
	@JoinColumn(name = "exam_info_id")
	public ExamInfo getExamInfo() {
		return examInfo;
	}

	public void setExamInfo(ExamInfo examInfo) {
		this.examInfo = examInfo;
	}

	@Column(name = "exam_state")
	public Integer getExamState() {
		return examState;
	}

	public void setExamState(Integer examState) {
		this.examState = 0;
		if (examState != null) {
			this.examState = examState;
		}
	}

	@Column(name = "exam_use_time")
	public Integer getExamUseTime() {
		return examUseTime;
	}

	public void setExamUseTime(Integer examUseTime) {
		this.examUseTime = examUseTime;
	}

	@Column(name = "exam_score")
	public Double getExamScore() {
		return examScore;
	}

	public void setExamScore(Double examScore) {
		this.examScore = examScore;
	}
	
	@Column(name = "is_mark_score")
	public Integer getIsMarkScore() {
		return isMarkScore;
	}

	public void setIsMarkScore(Integer isMarkScore) {
		this.isMarkScore = isMarkScore;
	}

	@Column(name = "remark", length = 500)
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}