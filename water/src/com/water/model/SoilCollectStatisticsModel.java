package com.water.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 作物采集数据统计模型
 * 
 * @author lingxiaoguang
 *
 */
public class SoilCollectStatisticsModel {
	/**创建时间*/
	private Date createTime;
	/**土壤温度*/
	private String soilTemp;
	/**土壤湿度*/
	private String soilHumi;
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getSoilTemp() {
		return soilTemp;
	}
	public void setSoilTemp(String soilTemp) {
		this.soilTemp = soilTemp;
	}
	public String getSoilHumi() {
		return soilHumi;
	}
	public void setSoilHumi(String soilHumi) {
		this.soilHumi = soilHumi;
	}
	
}
