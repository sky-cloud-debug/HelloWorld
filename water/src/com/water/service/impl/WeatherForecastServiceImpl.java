package com.water.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.water.dao.WeatherDao;
import com.water.dao.WeatherForecastDao;
import com.water.model.WeatherForecast;
import com.water.service.WeatherForecastService;
import com.water.util.HttpForForecast;
import com.water.util.WeatherData;

@Service
public class WeatherForecastServiceImpl extends MyBaseServiceImpl<WeatherForecast> implements
		WeatherForecastService {

	@Autowired
    WeatherForecastDao weatherForecastDao;
	
	public  void saveWeatherForecast(List<WeatherData> jsonResult){
		WeatherForecast weatherForecast = new WeatherForecast();
		weatherForecast = HttpForForecast.saveForecaseData(jsonResult);
		weatherForecastDao.save(weatherForecast);
	}
}
