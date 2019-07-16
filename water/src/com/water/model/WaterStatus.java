package com.water.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="sl_water_zt")
public class WaterStatus {
	private Integer id;
	private String water1;
	private String water2;
	private String water3;
	private String water4;
	private String water5;
	private String water6;
	private Date createTime;

	@Id
	@GeneratedValue()
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="water_1")
	public String getWater1() {
		return water1;
	}
	public void setWater1(String water1) {
		this.water1 = water1;
	}
	@Column(name="water_2")
	public String getWater2() {
		return water2;
	}
	public void setWater2(String water2) {
		this.water2 = water2;
	}
	@Column(name="water_3")
	public String getWater3() {
		return water3;
	}
	public void setWater3(String water3) {
		this.water3 = water3;
	}
	@Column(name="water_4")
	public String getWater4() {
		return water4;
	}
	public void setWater4(String water4) {
		this.water4 = water4;
	}
	@Column(name="water_5")
	public String getWater5() {
		return water5;
	}
	public void setWater5(String water5) {
		this.water5 = water5;
	}
	@Column(name="water_6")
	public String getWater6() {
		return water6;
	}
	public void setWater6(String water6) {
		this.water6 = water6;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="datetime")
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date crateTime) {
		this.createTime = crateTime;
	}
}
