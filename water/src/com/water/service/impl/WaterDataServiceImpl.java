package com.water.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.water.common.service.BaseServiceImpl;
import com.water.dao.WaterDataDao;
import com.water.model.WaterData;
import com.water.service.WaterDataService;

@Service
public class WaterDataServiceImpl extends BaseServiceImpl<WaterData> implements WaterDataService{

	@Autowired
	WaterDataDao waterDataDao;
	       
	@Override
	public List<WaterData> findLatestWaterData() {
		List<WaterData> list=new ArrayList<WaterData>();
		WaterData waterData1=waterDataDao.findOneByDtuAndCreateTime("1");
		WaterData waterData2=waterDataDao.findOneByDtuAndCreateTime("2");
		WaterData waterData3=waterDataDao.findOneByDtuAndCreateTime("3");
		WaterData waterData4=waterDataDao.findOneByDtuAndCreateTime("4");
		list.add(waterData1);
		list.add(waterData2);
		list.add(waterData3);
		list.add(waterData4);
		return list;
	}

}
