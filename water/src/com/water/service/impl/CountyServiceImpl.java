package com.water.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.water.common.service.BaseServiceImpl;
import com.water.dao.CityDao;
import com.water.dao.CountyDao;
import com.water.dao.CropDao;
import com.water.dao.RegionDao;
import com.water.model.City;
import com.water.model.County;
import com.water.model.Region;
import com.water.service.CountyService;
import com.water.service.RegionService;

@Service
public class CountyServiceImpl extends  BaseServiceImpl<County> implements CountyService{
	@Autowired
	CountyDao dao;
	@Override
	public List<County> findListByRegionId(Integer regionId) {
		// TODO Auto-generated method stub
		return dao.findCountyListByRegionId(regionId);
	}
	
	@Override
	public List<County> findCountyList() {
		
		List<County> counties = dao.findListByHql("from County");
		return counties;
	}
}
