package com.water.service;

import java.util.Date;
import java.util.List;

import com.water.common.bean.Page;
import com.water.model.Weather;
import com.water.model.Weather2;
import com.water.model.WeatherCollectStatisticsModel;
import com.water.model.WeatherCollectStatisticsModel2;

public interface WeatherService2 extends MyBaseService<Weather2> {
	

	double getLastDayAverageRainHour(int pageNo);

	double getLastDayHighestTemp();
	
	double getLastDayLowestTemp();

	double getLastDayAverageWinSpeed();
	
	double getLastDayAverageWinHumi();

	List<WeatherCollectStatisticsModel2> statisticWeatherByCreateTime(Integer countyId,Date startTime,Date endTime,boolean byDay);

	List<Weather2> getWeatherSunLong();
}
