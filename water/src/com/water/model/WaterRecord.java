package com.water.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="irri_water_record")
public class WaterRecord {
	private Integer id;
	private String waterNum;
	private String irrigationArea;
	private String outletNumber;
	private Date createTime;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="water_num")
	public String getWaterNum() {
		return waterNum;
	}
	public void setWaterNum(String waterNum) {
		this.waterNum = waterNum;
	}
	@Column(name="irrigation_area")
	public String getIrrigationArea() {
		return irrigationArea;
	}
	public void setIrrigationArea(String irrigationArea) {
		this.irrigationArea = irrigationArea;
	}
	@Column(name="outlet_number")
	public String getOutletNumber() {
		return outletNumber;
	}
	public void setOutletNumber(String outletNumber) {
		this.outletNumber = outletNumber;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_time")
	public Date getCreateTime() {
		return createTime;
	}
}
