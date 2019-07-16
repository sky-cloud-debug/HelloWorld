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
 * 类名: Area<BR>
 * 描述:田地名字 <BR>
 * 创建人:翟旭光 <BR>
 * 时间：2016年4月15日-上午10:42:46 <BR>
 * 
 * @version 1.0
 */
@Entity
@Table(name="irri_area")
public class Area
 {
	/** id */
	private Integer id;
	/** 田地名字 */
	private String areaName;
	/** 田地图片路径 */
	private String imgPath;
	/** 创建时间 */
	private Date createTime;
	/** 灌水下限 */
	private String irrigationLowerLimit;
	/** 灌水上限 */
	private String irrigationUpperLimit;
	/** 根系层土壤平均田间持水率 */
	private String averageWaterCapacity;
	/** 生育初期土壤计划湿润层深度 */
	private String firstStageDepthOfWetting;
	/** 生育中期土壤计划湿润层深度 */
	private String secondStageDepthOfWetting;
	/** 生育后期土壤计划湿润层深度 */
	private String thirdStageDepthOfWetting;
	/** 生育初期作物系数 */
	private String firstCropCoefficient;
	/** 生育中期作物系数 */
	private String secondCropCoefficient;
	/** 生育后期作物系数 */
	private String thirdCropCoefficient;
	/** 田间持水量 */
	private String waterholdingCapacity;
	/** 土壤类型 */
	private String soilType;
	/** 土壤干容重 */
	private String soilDryBulkDensity;
	/** 出水口号码 */
	private Integer outletNumber;
	/**灌溉面积*/
	private String irrigationArea;
	/** 区域*/
	private  Region region;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "area_name", length = 50)
	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	@Column(name = "average_water_capacity", length = 40)
	public String getAverageWaterCapacity() {
		return averageWaterCapacity;
	}

	public void setAverageWaterCapacity(String averageWaterCapacity) {
		this.averageWaterCapacity = averageWaterCapacity;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_time")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "first_stage_depth_of_wetting")
	public String getFirstStageDepthOfWetting() {
		return firstStageDepthOfWetting;
	}

	public void setFirstStageDepthOfWetting(String firstStageDepthOfWetting) {
		this.firstStageDepthOfWetting = firstStageDepthOfWetting;
	}

	@Column(name = "second_stage_depth_of_wetting")
	public String getSecondStageDepthOfWetting() {
		return secondStageDepthOfWetting;
	}

	public void setSecondStageDepthOfWetting(String secondStageDepthOfWetting) {
		this.secondStageDepthOfWetting = secondStageDepthOfWetting;
	}

	@Column(name = "third_stage_depth_of_wetting")
	public String getThirdStageDepthOfWetting() {
		return thirdStageDepthOfWetting;
	}

	public void setThirdStageDepthOfWetting(String thirdStageDepthOfWetting) {
		this.thirdStageDepthOfWetting = thirdStageDepthOfWetting;
	}

	@Column(name = "first_crop_coefficient")
	public String getFirstCropCoefficient() {
		return firstCropCoefficient;
	}

	public void setFirstCropCoefficient(String firstCropCoefficient) {
		this.firstCropCoefficient = firstCropCoefficient;
	}

	@Column(name = "second_crop_coefficient")
	public String getSecondCropCoefficient() {
		return secondCropCoefficient;
	}

	public void setSecondCropCoefficient(String secondCropCoefficient) {
		this.secondCropCoefficient = secondCropCoefficient;
	}

	@Column(name = "third_crop_coefficient")
	public String getThirdCropCoefficient() {
		return thirdCropCoefficient;
	}

	public void setThirdCropCoefficient(String thirdCropCoefficient) {
		this.thirdCropCoefficient = thirdCropCoefficient;
	}

	@Column(name = "water_holding_capacity")
	public String getWaterholdingCapacity() {
		return waterholdingCapacity;
	}

	public void setWaterholdingCapacity(String waterholdingCapacity) {
		this.waterholdingCapacity = waterholdingCapacity;
	}

	@Column(name = "soil_type")
	public String getSoilType() {
		return soilType;
	}

	public void setSoilType(String soilType) {
		this.soilType = soilType;
	}

	@Column(name = "soil_dry_bulk_density")
	public String getSoilDryBulkDensity() {
		return soilDryBulkDensity;
	}

	public void setSoilDryBulkDensity(String soilDryBulkDensity) {
		this.soilDryBulkDensity = soilDryBulkDensity;
	}

	@Column(name = "img_path")
	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	@JoinColumn(name = "region_id")
	@ManyToOne
	public Region getRegion() {
		return region;
	}
	@Column(name = "irrigation_lower_limit")
	public String getIrrigationLowerLimit() {
		return irrigationLowerLimit;
	}

	public void setIrrigationLowerLimit(String irrigationLowerLimit) {
		this.irrigationLowerLimit = irrigationLowerLimit;
	}
	@Column(name = "irrigation_upper_limit")
	public String getIrrigationUpperLimit() {
		return irrigationUpperLimit;
	}

	public void setIrrigationUpperLimit(String irrigationUpperLimit) {
		this.irrigationUpperLimit = irrigationUpperLimit;
	}
	
	public void setIrrigationArea(String irrigationArea) {
		this.irrigationArea = irrigationArea;
	}
	@Column(name="irrigation_area")
	public String getIrrigationArea() {
		return irrigationArea;
	}
	
	public void setOutletNumber(Integer outletNumber) {
		this.outletNumber = outletNumber;
	}
	@Column(name="outlet_number")
	public Integer getOutletNumber() {
		return outletNumber;
	}
}
