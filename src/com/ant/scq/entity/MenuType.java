package com.ant.scq.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_MENU_TYPE")
public class MenuType {
	private int id;

	/**
	 * 菜单类别名称
	 */
	private String typeName;
	/**
	 * 菜单编号
	 */
	private String menuNumber;
	/**
	 * 所属父类菜单编号
	 */
	private String parentNumber;
	/**
	 * 菜单级别
	 */
	private int menuLevel;
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

	@Column(name = "type_name", length = 100)
	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	@Column(name = "menu_number", length = 50)
	public String getMenuNumber() {
		return menuNumber;
	}

	public void setMenuNumber(String menuNumber) {
		this.menuNumber = menuNumber;
	}

	@Column(name = "parent_number")
	public String getParentNumber() {
		return parentNumber;
	}

	public void setParentNumber(String parentNumber) {
		this.parentNumber = parentNumber;
	}

	@Column(name = "menu_level")
	public int getMenuLevel() {
		return menuLevel;
	}

	public void setMenuLevel(Integer menuLevel) {
		this.menuLevel = 0;
		if (menuLevel != null) {
			this.menuLevel = menuLevel;
		}
	}

	@Column(name = "remark", length = 500)
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}