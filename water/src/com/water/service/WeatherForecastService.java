package com.water.service;

import java.util.Date;
import java.util.List;

import com.water.common.bean.Page;
import com.water.model.Weather;
import com.water.model.WeatherCollectStatisticsModel;
import com.water.model.WeatherForecast;
import com.water.util.WeatherData;

public interface WeatherForecastService extends MyBaseService<WeatherForecast> {
	  void saveWeatherForecast(List<WeatherData> jsonResult);
}
