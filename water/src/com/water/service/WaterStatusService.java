package com.water.service;

import com.water.common.service.BaseService;
import com.water.model.WaterStatus;

public interface WaterStatusService extends BaseService<WaterStatus>{

	WaterStatus findOneByCreateTimeDesc();

}
