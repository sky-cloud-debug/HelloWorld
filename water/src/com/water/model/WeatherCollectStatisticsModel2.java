package com.water.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 气象采集数据统计模型
 * 
 * @author lingxiaoguang
 *
 */
public class WeatherCollectStatisticsModel2 {
	/** 创建时间 */
	private Date createTime;
	/** 空气温度 */
	private String airTemp;
	/** 空气湿度 */
	private String airHumi;
	/** CO2浓度 */
	private String co2;
	/** 风速 */
	private String windSpeed;
	/** 光照 */
	private String sunData;
	/**降雨量*/
	private String rainHour;
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getAirTemp() {
		return airTemp;
	}
	public void setAirTemp(String airTemp) {
		this.airTemp = airTemp;
	}
	public String getAirHumi() {
		return airHumi;
	}
	public void setAirHumi(String airHumi) {
		this.airHumi = airHumi;
	}
	public String getCo2() {
		return co2;
	}
	public void setCo2(String co2) {
		this.co2 = co2;
	}
	public String getWindSpeed() {
		return windSpeed;
	}
	public void setWindSpeed(String windSpeed) {
		this.windSpeed = windSpeed;
	}
	public String getSunData() {
		return sunData;
	}
	public void setSunData(String sunData) {
		this.sunData = sunData;
	}
	public void setRainHour(String rainHour) {
		this.rainHour = rainHour;
	}
	public String getRainHour() {
		return rainHour;
	}
	@Override
	public String toString() {
		return "WeatherCollectStatisticsModel2 [createTime=" + createTime
				+ ", airTemp=" + airTemp + ", airHumi=" + airHumi + ", co2="
				+ co2 + ", windSpeed=" + windSpeed + ", sunData=" + sunData
				+ ", rainHour=" + rainHour + "]";
	}
	
}
