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
 * 类名: Soil2<BR>
 * 描述: 土壤实体类2<BR>
 * 创建人:毕燕东 <BR>
 * 时间：2016年4月12日-下午7:16:03 <BR>
 * 
 * @version 1.0
 */
@Entity
@Table(name = "irri_soil2")
public class Soil2 {
	/** id */
	private Integer id;
	/** 创建时间 */
	private Date createTime;
	/** 土壤温度 */
	private String soilTemp;
	/** 土壤湿度1 */
	private String soilHumi;
	/** 土壤湿度2 */
	private String soilHumi2;
	/** 土壤湿度3 */
	private String soilHumi3;
	/** 土壤酸碱度 */
	private String ph;
	/** 土壤电导率 */
	private String elect;

	/** 站点 */
	private String plotId;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_time")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "soil_temp", length = 20)
	public String getSoilTemp() {
		return soilTemp;
	}

	public void setSoilTemp(String soilTemp) {
		this.soilTemp = soilTemp;
	}

	@Column(name = "soil_humi", length = 20)
	public String getSoilHumi() {
		return soilHumi;
	}

	public void setSoilHumi(String soilHumi) {
		this.soilHumi = soilHumi;
	}
	@Column(name = "plot_id",length=20)
	public String getPlotId() {
		return plotId;
	}

	public void setPlotId(String plotId) {
		this.plotId = plotId;
	}
	@Column(name = "soil_elect", length = 20)
	public String getElect() {
		return elect;
	}

	public void setElect(String elect) {
		this.elect = elect;
	}

	@Column(name = "soil_ph", length = 20)
	public String getPh() {
		return ph;
	}

	public void setPh(String ph) {
		this.ph = ph;
	}

	@Column(name = "soil_humi2", length = 20)
	public String getSoilHumi2() {
		return soilHumi2;
	}

	public void setSoilHumi2(String soilHumi2) {
		this.soilHumi2 = soilHumi2;
	}

	@Column(name = "soil_humi3", length = 20)
	public String getSoilHumi3() {
		return soilHumi3;
	}

	public void setSoilHumi3(String soilHumi3) {
		this.soilHumi3 = soilHumi3;
	}

	@Override
	public String toString() {
		return "Soil2 [id=" + id + ", createTime=" + createTime + ", soilTemp="
				+ soilTemp + ", soilHumi=" + soilHumi + ", soilHumi2="
				+ soilHumi2 + ", soilHumi3=" + soilHumi3 + ", ph=" + ph
				+ ", elect=" + elect  + "]";
	}
}
