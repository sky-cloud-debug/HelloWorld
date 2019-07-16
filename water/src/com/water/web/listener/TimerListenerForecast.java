package com.water.web.listener;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.water.common.bean.Page;
import com.water.model.Area;
import com.water.model.County;
import com.water.model.MessageRecord;
import com.water.model.Plot;
import com.water.model.Soil2;
import com.water.model.Weather2;
import com.water.service.AreaService;
import com.water.service.CountyService;
import com.water.service.MessageRecordService;
import com.water.service.PlotService;
import com.water.service.RegionService;
import com.water.service.SoilService;
import com.water.service.SoilService2;
import com.water.service.WaterRecordService;
import com.water.service.WeatherForecastService;
import com.water.service.WeatherService2;
import com.water.util.Config;
import com.water.util.GetDataSource;
import com.water.util.HttpUtil;

import com.water.util.WaterUtil;

public class TimerListenerForecast implements ServletContextListener{

	public static ApplicationContext applicationContext;
	
	public  static ServletContext servletContext;
	private WeatherForecastService weatherForecastService;
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		servletContext = event.getServletContext();
		applicationContext=WebApplicationContextUtils.getWebApplicationContext(servletContext);
		weatherForecastService = applicationContext.getBean(WeatherForecastService.class);
		Timer timer=new Timer();
			timer.schedule(new TimerTask() {
				
				@Override 
				public void run() {
					//weatherForecastService.saveWeatherForecast();
				}
			}, 0,14400000);
			System.out.println("定时器启动成功！开始爬取气象数据===============");
	}
	
}
