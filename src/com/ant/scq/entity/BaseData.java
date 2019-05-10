package com.ant.scq.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="T_BASE_DATA")
public class BaseData
{
  private String id;
  private String baseDataName;
  private String remark;

  @Id
  @GenericGenerator(name="baseDataGenerator", strategy="uuid")
  @GeneratedValue(generator="baseDataGenerator")
  @Column(name="id", length=32, nullable=false)
  public String getId()
  {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }
  @Column(name="base_data_name", length=100)
  public String getBaseDataName() {
    return this.baseDataName;
  }

  public void setBaseDataName(String baseDataName) {
    this.baseDataName = baseDataName;
  }
  @Column(name="remark", length=100)
  public String getRemark() {
    return this.remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }
}