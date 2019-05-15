package com.ant.scq.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "scq_sc_field_info")
public class SourceFieldInfo {
	
	private Integer  id;
	
	private SourceInfo sourceInfo;
	
	private String fieldName;
	
	private int isInputWay;
	
	private int isVisable;
	
	private int inputType;
	
	private int fontStyleType;
	
	private String fontColor;
	
	private int fontSize;
	
	private int fontWay;
	
	private int fontDirection;
	
	private int firstPointx;
	
	private int firstPointy;
	
	private int secondPointx;
	
	private int secondPointy;
	
	private int xoffset;
	
	private int yoffset;
	
	private int angleValue;
	
	private int sid;
	
	private int fieldIndex;
	
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
	@JoinColumn(name = "sc_id")
	public SourceInfo getSourceInfo() {
		return sourceInfo;
	}

	public void setSourceInfo(SourceInfo sourceInfo) {
		this.sourceInfo = sourceInfo;
	}

	@Column(name = "field_name",length = 100)
	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	
	@Column(name = "is_input_way")
	public int getIsInputWay() {
		return isInputWay;
	}

	public void setIsInputWay(int isInputWay) {
		this.isInputWay = isInputWay;
	}

	@Column(name = "is_visable")
	public int getIsVisable() {
		return isVisable;
	}

	public void setIsVisable(int isVisable) {
		this.isVisable = isVisable;
	}

	@Column(name = "input_type")
	public int getInputType() {
		return inputType;
	}

	public void setInputType(int inputType) {
		this.inputType = inputType;
	}

	@Column(name = "font_style_type")
	public int getFontStyleType() {
		return fontStyleType;
	}

	public void setFontStyleType(int fontStyleType) {
		this.fontStyleType = fontStyleType;
	}

	@Column(name = "font_color")
	public String getFontColor() {
		return fontColor;
	}

	public void setFontColor(String fontColor) {
		this.fontColor = fontColor;
	}

	@Column(name = "font_size")
	public int getFontSize() {
		return fontSize;
	}

	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}

	@Column(name = "font_way")
	public int getFontWay() {
		return fontWay;
	}

	public void setFontWay(int fontWay) {
		this.fontWay = fontWay;
	}

	@Column(name = "font_direction")
	public int getFontDirection() {
		return fontDirection;
	}

	public void setFontDirection(int fontDirection) {
		this.fontDirection = fontDirection;
	}

	@Column(name = "first_pointx")
	public int getFirstPointx() {
		return firstPointx;
	}

	public void setFirstPointx(int firstPointx) {
		this.firstPointx = firstPointx;
	}

	@Column(name = "first_pointy")
	public int getFirstPointy() {
		return firstPointy;
	}

	public void setFirstPointy(int firstPointy) {
		this.firstPointy = firstPointy;
	}

	@Column(name = "second_pointx")
	public int getSecondPointx() {
		return secondPointx;
	}

	public void setSecondPointx(int secondPointx) {
		this.secondPointx = secondPointx;
	}

	@Column(name = "second_pointy")
	public int getSecondPointy() {
		return secondPointy;
	}

	public void setSecondPointy(int secondPointy) {
		this.secondPointy = secondPointy;
	}

	@Column(name = "xoffset")
	public int getXoffset() {
		return xoffset;
	}

	public void setXoffset(int xoffset) {
		this.xoffset = xoffset;
	}

	@Column(name = "yoffset")
	public int getYoffset() {
		return yoffset;
	}

	public void setYoffset(int yoffset) {
		this.yoffset = yoffset;
	}

	@Column(name = "angle_value")
	public int getAngleValue() {
		return angleValue;
	}

	public void setAngleValue(int angleValue) {
		this.angleValue = angleValue;
	}

	
	@Column(name = "field_index")
	public int getFieldIndex() {
		return fieldIndex;
	}

	public void setFieldIndex(int fieldIndex) {
		this.fieldIndex = fieldIndex;
	}

	@Transient
	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}
	
}
