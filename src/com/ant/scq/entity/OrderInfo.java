package com.ant.scq.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "T_ORDER")
public class OrderInfo {
	private int id;
	/**
	 * 用户ID
	 */
	private User userId;
	/**
	 * 课程ID
	 */
	private CourseInfo courseId;
	/**
	 * 订单状态
	 */
	private int orderState;
	/**
	 * 订单价格
	 */
	private BigDecimal orderPrice;
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
	@JoinColumn(name = "user_id")
	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	@ManyToOne
	@JoinColumn(name = "course_id")
	public CourseInfo getCourseId() {
		return courseId;
	}

	public void setCourseId(CourseInfo courseId) {
		this.courseId = courseId;
	}

	@Column(name = "order_state")
	public int getOrderState() {
		return orderState;
	}

	public void setOrderState(Integer orderState) {
		this.orderState = 0;
		if (orderState != null) {
			this.orderState = orderState;
		}
	}

	@Column(name = "order_price")
	public BigDecimal getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(BigDecimal orderPrice) {
		this.orderPrice = orderPrice;
	}

	@Column(name = "remark", length = 500)
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}