package com.water.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * 
 * 类名: Soil<BR>
 * 描述: 土壤实体类<BR>
 * 创建人:翟旭光 <BR>
 * 时间：2016年4月12日-下午7:16:03 <BR>
 * @version 1.0
 */
@Entity
@Table(name="irri_soil")
public class Soil {
	/**id*/
	private Integer id;
	/**创建时间*/
	private Date createTime;
	/**土壤温度*/
	private String soilTemp;
	/**土壤湿度*/
	private String soilHumi;
	
	/**plotName*/
	private String plotIdd;
	/**区域*/
	private Region region;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_time")
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Column(name="soil_temp",length=20)
	public String getSoilTemp() {
		return soilTemp;
	}
	public void setSoilTemp(String soilTemp) {
		this.soilTemp = soilTemp;
	}
	@Column(name="soil_humi",length=20)
	public String getSoilHumi() {
		return soilHumi;
	}
	public void setSoilHumi(String soilHumi) {
		this.soilHumi = soilHumi;
	}
	@JoinColumn(name="region_id")
	@ManyToOne
	public Region getRegion() {
		return region;
	}
	public void setRegion(Region region) {
		this.region = region;
	}
	@Column(name = "dtu_id",length=20)
	public String getPlotIdd() {
		return plotIdd;
	}
	public void setPlotIdd(String plotIdd) {
		this.plotIdd = plotIdd;
	}
	@Override
	public String toString() {
		return "Soil [id=" + id + ", createTime=" + createTime + ", soilTemp="
				+ soilTemp + ", soilHumi=" + soilHumi + ", region=" + region
				 + "]";
	}
	
}
