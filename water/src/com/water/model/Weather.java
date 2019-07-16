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
 * 类名: Weather<BR>
 * 描述: 气象实体类<BR>
 * 创建人:翟旭光 <BR>
 * 时间：2016年4月12日-下午7:16:22 <BR>
 * 
 * @version 1.0
 */
@Entity
@Table(name = "irri_weather")
public class Weather {
	/** id */
	private Integer id;
	/** 创建时间 */
	private Date createTime;
	/** 空气温度 */
	private String airTemp;
	/** 空气湿度 */
	private String airHumi;
	/** CO2浓度 */
	private String co2;
	/** 风向 */
	private String windDir;
	/** 风速 */
	private String windSpeed;
	/** 光照 */
	private String sunData;
	/**降雨量*/
	private String rainHour;
	/** 区域 */
	private Region region;
    private String plotIdd;
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

	@Column(name = "air_temp", length = 20)
	public String getAirTemp() {
		return airTemp;
	}

	public void setAirTemp(String airTemp) {
		this.airTemp = airTemp;
	}

	@Column(name = "air_humi", length = 20)
	public String getAirHumi() {
		return airHumi;
	}

	public void setAirHumi(String airHumi) {
		this.airHumi = airHumi;
	}

	@Column(name = "co2", length = 20)
	public String getCo2() {
		return co2;
	}

	public void setCo2(String co2) {
		this.co2 = co2;
	}

	@Column(name = "win_dir", length = 20)
	public String getWindDir() {
		return windDir;
	}

	public void setWindDir(String windDir) {
		this.windDir = windDir;
	}

	@Column(name = "win_speed", length = 20)
	public String getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(String windSpeed) {
		this.windSpeed = windSpeed;
	}

	@Column(name = "sun_data", length = 20)
	public String getSunData() {
		return sunData;
	}

	public void setSunData(String sunData) {
		this.sunData = sunData;
	}

	@JoinColumn(name = "region_id")
	@ManyToOne
	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	
	public void setRainHour(String rainHour) {
		this.rainHour = rainHour;
	}
	@Column(name="rain_hour")
	public String getRainHour() {
		return rainHour;
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
		return "Weather [id=" + id + ", createTime=" + createTime
				+ ", airTemp=" + airTemp + ", airHumi=" + airHumi + ", co2="
				+ co2 + ", windDir=" + windDir + ", windSpeed=" + windSpeed
				+ ", sunData=" + sunData + ", rainHour=" + rainHour
				+ ", region=" + region + ", plotIdd=" + plotIdd + "]";
	}
	

	
}
