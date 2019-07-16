package com.water.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.water.common.service.BaseServiceImpl;
import com.water.dao.CountyDao;
import com.water.dao.CropDao;
import com.water.dao.DeviceDao;
import com.water.dao.RegionDao;
import com.water.model.County;
import com.water.model.Device;
import com.water.model.Region;
import com.water.service.CountyService;
import com.water.service.DeviceService;
import com.water.service.RegionService;

@Service
public class DeviceServiceImpl extends  BaseServiceImpl<Device> implements DeviceService{
	@Autowired
	DeviceDao dao;
	@Override
	public List<Device> findListByPlotId(Integer plotId) {
		return dao.findDeviceListByPlotId(plotId);
	}
	

}
