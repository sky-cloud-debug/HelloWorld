package com.water.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.water.common.dao.BaseDao;
import com.water.common.service.BaseServiceImpl;
import com.water.dao.CityDao;
import com.water.dao.CountyDao;
import com.water.dao.CropDao;
import com.water.dao.RegionDao;
import com.water.model.City;
import com.water.model.County;
import com.water.model.Region;
import com.water.service.CityService;
import com.water.service.CountyService;
import com.water.service.RegionService;

@Service
public class CityServiceImpl extends  BaseServiceImpl<City> implements CityService{

	@Autowired
	protected CityDao cityDao;
	@Override
	public List<City> findCityList() {
		
		List<City> cities = cityDao.findListByHql("from City");
		return cities;
	}
	

}
