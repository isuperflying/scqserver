package com.ant.scq.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 题目项表
 * 
 * @author super
 *
 */
@Entity
@Table(name = "T_SUBJECT_ITEM")
public class SubjectItem {
	private int id;
	private Subject subject;
	private String itemCode;
	private String itemContent;
	private int itemSelectCount;

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
	@JoinColumn(name = "subject_id")
	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	@Column(name = "item_code", length = 60)
	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	@Column(name = "item_content", length = 500)
	public String getItemContent() {
		return itemContent;
	}

	public void setItemContent(String itemContent) {
		this.itemContent = itemContent;
	}

	@Column(name = "item_select_count")
	public int getItemSelectCount() {
		return itemSelectCount;
	}

	public void setItemSelectCount(int itemSelectCount) {
		this.itemSelectCount = itemSelectCount;
	}

}