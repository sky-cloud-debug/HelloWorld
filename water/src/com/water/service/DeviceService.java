package com.water.service;

import java.util.List;

import com.water.common.service.BaseService;
import com.water.model.County;
import com.water.model.Device;
import com.water.model.Plot;
import com.water.model.Region;

public interface DeviceService extends BaseService<Device>{
	public List<Device> findListByPlotId(Integer plotId);

}
