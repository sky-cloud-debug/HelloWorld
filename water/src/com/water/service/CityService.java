package com.water.service;

import java.util.List;

import com.water.common.bean.Page;
import com.water.common.service.BaseService;
import com.water.model.City;
import com.water.model.County;
import com.water.model.Region;

public interface CityService extends BaseService<City>{
	List<City> findCityList();
}
