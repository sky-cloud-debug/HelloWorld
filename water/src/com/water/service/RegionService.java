package com.water.service;

import java.util.List;

import com.water.common.service.BaseService;
import com.water.model.Region;

public interface RegionService extends BaseService<Region>{
	public List<Region> findListByCityName(String cityName);
}
