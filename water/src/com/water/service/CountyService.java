package com.water.service;

import java.util.List;

import com.water.common.service.BaseService;
import com.water.model.County;
import com.water.model.Region;

public interface CountyService extends BaseService<County>{
	public List<County> findListByRegionId(Integer regionId);
	public List<County> findCountyList();
}
