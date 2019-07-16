package com.water.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.water.common.service.BaseServiceImpl;
import com.water.dao.CountyDao;
import com.water.dao.CropDao;
import com.water.dao.PlotDao;
import com.water.dao.RegionDao;
import com.water.model.County;
import com.water.model.Plot;
import com.water.model.Region;
import com.water.service.CountyService;
import com.water.service.PlotService;
import com.water.service.RegionService;

@Service
public class PlotServiceImpl extends  BaseServiceImpl<Plot> implements PlotService{
	@Autowired
	PlotDao dao;
	@Override
	public List<Plot> findListByCountyId(Integer countyId) {
		// TODO Auto-generated method stub
		return dao.findPlotListByCountyId(countyId);
	}
	@Override
	public List<Plot> findPlotList() {
		
		List<Plot> plots = dao.findListByHql("from Plot");
		return plots;
	}

}
