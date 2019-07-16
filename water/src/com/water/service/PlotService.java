package com.water.service;

import java.util.List;

import com.water.common.service.BaseService;
import com.water.model.County;
import com.water.model.Plot;
import com.water.model.Region;

public interface PlotService extends BaseService<Plot>{
	public List<Plot> findListByCountyId(Integer countyId);
	public List<Plot> findPlotList();
}
