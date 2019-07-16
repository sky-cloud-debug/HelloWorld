package com.water.model;


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
 * 类名: WeatherForecast<BR>
 * 描述: 天气预报实体类<BR>
 * 创建人:毕燕东 <BR>
 * 时间：2017年9月24日-下午7:16:22 <BR>
 * 
 * @version 1.0
 */
@Entity
@Table(name = "irri_weather_forecast")
public class WeatherForecast {
	/** id */
	private Integer id;
	/** 创建时间 */
	private String createTime;
	/** 空气最高温度 */
	private String airHighTemp;
	/** 空气最低温度 */
	private String airLowTemp;
	/** 空气湿度 */
	private String airHumi;
	/** 风速 */
	private String windSpeed;
	/**降雨量*/
	private String rainHour;
	/**日照时长*/
	private String sunLong;
	/** 区域 */
	private String region;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "create_time", length = 20)
	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	@Column(name = "air_high_temp", length = 20)
	public String getAirHighTemp() {
		return airHighTemp;
	}
	public void setAirHighTemp(String airHighTemp) {
		this.airHighTemp = airHighTemp;
	}
	
	@Column(name = "air_low_temp", length = 20)
	public String getAirLowTemp() {
		return airLowTemp;
	}
	public void setAirLowTemp(String airLowTemp) {
		this.airLowTemp = airLowTemp;
	}
	

	@Column(name = "air_humi", length = 20)
	public String getAirHumi() {
		return airHumi;
	}

	public void setAirHumi(String airHumi) {
		this.airHumi = airHumi;
	}


	@Column(name = "sun_long", length = 20)
	public String getSunLong() {
		return sunLong;
	}

	public void setSunLong(String sunLong) {
		this.sunLong = sunLong;
	}
	
	
	
	
	@Column(name = "win_speed", length = 20)
	public String getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(String windSpeed) {
		this.windSpeed = windSpeed;
	}

	@Column(name = "region", length = 20)
	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	
	public void setRainHour(String rainHour) {
		this.rainHour = rainHour;
	}
	@Column(name="rain_hour")
	public String getRainHour() {
		return rainHour;
	}

	@Override
	public String toString() {
		return "WeatherForecast [id=" + id + ", createTime=" + createTime
				+ ", airHighTemp=" + airHighTemp + ", airLowTemp=" + airLowTemp
				+ ", airHumi=" + airHumi + ", windSpeed=" + windSpeed
				+ ", rainHour=" + rainHour + ", sunLong=" + sunLong
				+ ", region=" + region + "]";
	}


	

	
}
