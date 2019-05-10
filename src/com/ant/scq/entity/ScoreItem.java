package com.ant.scq.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_SCORE_ITEM")
public class ScoreItem {
	private int id;

	/**
	 * 评分项名称
	 */
	private String scoreItemName;
	
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

	@Column(name = "score_item_name", length = 100)
	public String getScoreItemName() {
		return scoreItemName;
	}

	public void setScoreItemName(String scoreItemName) {
		this.scoreItemName = scoreItemName;
	}	
}