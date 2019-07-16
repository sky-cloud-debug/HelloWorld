package com.water.service;

import java.util.List;

import com.water.common.service.BaseService;
import com.water.model.WaterData;

public interface WaterDataService extends BaseService<WaterData>{

	List<WaterData> findLatestWaterData();

}
