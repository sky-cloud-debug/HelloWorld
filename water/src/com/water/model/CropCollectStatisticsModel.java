package com.water.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 作物采集数据统计模型
 * 
 * @author lingxiaoguang
 *
 */
public class CropCollectStatisticsModel {
	/**  */
	private String canopyTemperature;
	/** 生理生化指标 */
	private String physiologicalAndBiochemicalIndexes;
	/** 品质 */
	private String quality;
	/** 土壤含水率 */
	private String soilMoistureContent;
	/** 土壤容重 */
	private String soilBulkDensity;
	/** 创建时间 */
	private Date createTime;
	public String getCanopyTemperature() {
		return canopyTemperature;
	}
	public void setCanopyTemperature(String canopyTemperature) {
		this.canopyTemperature = canopyTemperature;
	}
	public String getPhysiologicalAndBiochemicalIndexes() {
		return physiologicalAndBiochemicalIndexes;
	}
	public void setPhysiologicalAndBiochemicalIndexes(
			String physiologicalAndBiochemicalIndexes) {
		this.physiologicalAndBiochemicalIndexes = physiologicalAndBiochemicalIndexes;
	}
	public String getQuality() {
		return quality;
	}
	public void setQuality(String quality) {
		this.quality = quality;
	}
	public String getSoilMoistureContent() {
		return soilMoistureContent;
	}
	public void setSoilMoistureContent(String soilMoistureContent) {
		this.soilMoistureContent = soilMoistureContent;
	}
	public String getSoilBulkDensity() {
		return soilBulkDensity;
	}
	public void setSoilBulkDensity(String soilBulkDensity) {
		this.soilBulkDensity = soilBulkDensity;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}


}
