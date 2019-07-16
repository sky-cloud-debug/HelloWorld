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
@Table(name="sl_water_data")
public class WaterData {
	private Integer id;
	private String dtu;
	private String waterSpeed;
	private String waterFlow;
	private Date createTime;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="dtu")
	public String getDtu() {
		return dtu;
	}
	public void setDtu(String dtu) {
		this.dtu = dtu;
	}
	@Column(name="water_speed")
	public String getWaterSpeed() {
		return waterSpeed;
	}
	public void setWaterSpeed(String waterSpeed) {
		this.waterSpeed = waterSpeed;
	}
	@Column(name="water_flow")
	public String getWaterFlow() {
		return waterFlow;
	}
	public void setWaterFlow(String waterFlow) {
		this.waterFlow = waterFlow;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="datetime")
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
