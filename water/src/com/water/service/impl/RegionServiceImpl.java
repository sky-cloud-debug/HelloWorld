package com.water.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.water.common.service.BaseServiceImpl;
import com.water.dao.CropDao;
import com.water.dao.RegionDao;
import com.water.model.Region;
import com.water.service.RegionService;

@Service
public class RegionServiceImpl extends  BaseServiceImpl<Region> implements RegionService{
	@Autowired
	RegionDao dao;
	@Override
	public List<Region> findListByCityName(String cityName) {
		return dao.findRegionByCityName(cityName);
	}

}
