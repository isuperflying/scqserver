package com.ant.scq.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 题目表
 * 
 * @author super
 *
 */
@Entity
@Table(name = "T_SUBJECT")
public class Subject {
	private int id;
	private String subjectStem;//话题
	private String standardAnswer;//标准答案
	private String subjectDescription;//话题描述
	private String subjectContent;

	private List<SubjectItem> subjectItemList;

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

	@Column(name = "subject_stem", length = 500)
	public String getSubjectStem() {
		return subjectStem;
	}

	public void setSubjectStem(String subjectStem) {
		this.subjectStem = subjectStem;
	}

	@Column(name = "standard_answer", length = 60)
	public String getStandardAnswer() {
		return standardAnswer;
	}

	public void setStandardAnswer(String standardAnswer) {
		this.standardAnswer = standardAnswer;
	}
	
	@Column(name = "subject_description", length = 500)
	public String getSubjectDescription() {
		return subjectDescription;
	}

	public void setSubjectDescription(String subjectDescription) {
		this.subjectDescription = subjectDescription;
	}

	@OneToMany(targetEntity = SubjectItem.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "subject")
	public List<SubjectItem> getSubjectItemList() {
		return subjectItemList;
	}

	public void setSubjectItemList(List<SubjectItem> subjectItemList) {
		this.subjectItemList = subjectItemList;
	}

	@Transient
	public String getSubjectContent() {
		return subjectContent;
	}

	public void setSubjectContent(String subjectContent) {
		this.subjectContent = subjectContent;
	}

}