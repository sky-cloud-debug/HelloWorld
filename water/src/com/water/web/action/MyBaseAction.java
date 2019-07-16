package com.water.web.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.water.common.web.action.BaseAction;
import com.water.service.AreaService;
import com.water.service.CityService;
import com.water.service.CountyService;
import com.water.service.CropService;
import com.water.service.DeviceService;
import com.water.service.MessageRecordService;
import com.water.service.NewsService;
import com.water.service.PlotService;
import com.water.service.RegionService;
import com.water.service.SoilService;
import com.water.service.SoilService2;
import com.water.service.UserService;
import com.water.service.WaterDataService;
import com.water.service.WaterRecordService;
import com.water.service.WaterStatusService;
import com.water.service.WeatherForecastService;
import com.water.service.WeatherService;
import com.water.service.WeatherService2;

public class MyBaseAction<T> extends BaseAction<T> {
	@Autowired
	protected AreaService areaService;
	@Autowired
	protected CropService cropService;
	@Autowired
	protected RegionService regionService;
	@Autowired
	protected SoilService soilService;
	@Autowired
	protected SoilService2 soilService2;
	@Autowired
	protected UserService userService;
	@Autowired
	protected WeatherService weatherService;
	@Autowired
	protected WeatherService2 weatherService2;
	@Autowired
	protected WaterDataService waterDataService;
	@Autowired
	protected WaterStatusService waterStatusService;
	@Autowired
	protected NewsService newsService;
	@Autowired
	protected MessageRecordService messageRecordService;
	@Autowired
	protected WaterRecordService waterRecordService;
	@Autowired
	protected CountyService countyService;
	@Autowired
	protected PlotService plotService;
	@Autowired
	protected CityService cityService;
	@Autowired
	protected WeatherForecastService weatherForecastService;
	@Autowired
	protected DeviceService deviceService;
}
