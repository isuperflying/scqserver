package com.ant.scq.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 题目表
 * 
 * @author super
 *
 */
@Entity
@Table(name = "T_SUBJECT_USER")
public class SubjectUser {
	private int id;
	private Subject subject;// 话题
	private User user;// 用户
	private String selectItemCode;// 用户选择的答案

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

	@OneToOne
	@JoinColumn(name = "subject_id")
	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	@OneToOne
	@JoinColumn(name = "user_id")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "select_item_code", length = 60)
	public String getSelectItemCode() {
		return selectItemCode;
	}

	public void setSelectItemCode(String selectItemCode) {
		this.selectItemCode = selectItemCode;
	}

}