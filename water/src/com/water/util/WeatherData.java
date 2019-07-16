package com.water.util;

import java.util.Date;

public class WeatherData {
	private String sunRise;
	private String sunSet;
	private String minTemp;
	private String maxTemp;
	private Date date;
	private String humi;
	private String waterfall;
	private String winSpeed;

	public String getSunRise() {
		return sunRise;
	}

	public void setSunRise(String sunRise) {
		this.sunRise = sunRise;
	}

	public String getSunSet() {
		return sunSet;
	}

	public void setSunSet(String sunSet) {
		this.sunSet = sunSet;
	}

	public String getMinTemp() {
		return minTemp;
	}

	@Override
	public String toString() {
		return "WeatherData [sunRise=" + sunRise + ", sunSet=" + sunSet
				+ ", minTemp=" + minTemp + ", maxTemp=" + maxTemp + ", date="
				+ date + ", humi=" + humi + ", waterfall=" + waterfall
				+ ", winSpeed=" + winSpeed + "]";
	}

	public void setMinTemp(String minTemp) {
		this.minTemp = minTemp;
	}

	public String getMaxTemp() {
		return maxTemp;
	}

	public void setMaxTemp(String maxTemp) {
		this.maxTemp = maxTemp;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getHumi() {
		return humi;
	}

	public void setHumi(String humi) {
		this.humi = humi;
	}

	public String getWaterfall() {
		return waterfall;
	}

	public void setWaterfall(String waterfall) {
		this.waterfall = waterfall;
	}

	public String getWinSpeed() {
		return winSpeed;
	}

	public void setWinSpeed(String winSpeed) {
		this.winSpeed = winSpeed;
	}
}