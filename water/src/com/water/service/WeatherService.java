package com.water.service;

import java.util.Date;
import java.util.List;

import com.water.common.bean.Page;
import com.water.model.Weather;
import com.water.model.WeatherCollectStatisticsModel;

public interface WeatherService extends MyBaseService<Weather> {
	

	double getLastDayAverageRainHour(int pageNo);

	double getLastDayHighestTemp();
	
	double getLastDayLowestTemp();

	double getLastDayAverageWinSpeed();
	
	double getLastDayAverageWinHumi();

	List<WeatherCollectStatisticsModel> statisticWeatherByCreateTime(Integer regionId,Date startTime,Date endTime,boolean byDay);

	List<Weather> getWeatherSunLong();
}
