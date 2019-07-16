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

/**
 * 
 * 类名: Crop<BR>
 * 描述: 作物实体类<BR>
 * 创建人:翟旭光 <BR>
 * 时间：2016年4月12日-下午7:15:51 <BR>
 * 
 * @version 1.0
 */
@Entity
@Table(name = "irri_crop")
public class Crop {
	/** id */
	private Integer id;
	/** 冠层温度 */
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
	
	/** 田地 */
	private Area area;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "canopy_temperature")
	public String getCanopyTemperature() {
		return canopyTemperature;
	}

	public void setCanopyTemperature(String canopyTemperature) {
		this.canopyTemperature = canopyTemperature;
	}

	@Column(name = "physiological_biochemical_indexes")
	public String getPhysiologicalAndBiochemicalIndexes() {
		return physiologicalAndBiochemicalIndexes;
	}

	public void setPhysiologicalAndBiochemicalIndexes(
			String physiologicalAndBiochemicalIndexes) {
		this.physiologicalAndBiochemicalIndexes = physiologicalAndBiochemicalIndexes;
	}

	@Column(name = "quality")
	public String getQuality() {
		return quality;
	}

	public void setQuality(String quality) {
		this.quality = quality;
	}

	@Column(name = "soil_moisture_content")
	public String getSoilMoistureContent() {
		return soilMoistureContent;
	}

	public void setSoilMoistureContent(String soilMoistureContent) {
		this.soilMoistureContent = soilMoistureContent;
	}

	@Column(name = "soil_bulk_density")
	public String getSoilBulkDensity() {
		return soilBulkDensity;
	}

	public void setSoilBulkDensity(String soilBulkDensity) {
		this.soilBulkDensity = soilBulkDensity;
	}

	@Column(name = "create_time")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@JoinColumn(name = "area_id")
	@ManyToOne
	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	@Override
	public String toString() {
		return "CropCollect [id=" + id + ", canopyTemperature="
				+ canopyTemperature + ", physiologicalAndBiochemicalIndexes="
				+ physiologicalAndBiochemicalIndexes + ", quality=" + quality
				+ ", soilMoistureContent=" + soilMoistureContent
				+ ", soilBulkDensity=" + soilBulkDensity + ", createTime="
				+ createTime + ", area=" + area + "]";
	}
}
