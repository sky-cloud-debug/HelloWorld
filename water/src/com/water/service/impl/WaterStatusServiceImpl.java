package com.water.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.water.common.service.BaseServiceImpl;
import com.water.dao.WaterStatusDao;
import com.water.model.WaterStatus;
import com.water.service.WaterStatusService;

@Service
public class WaterStatusServiceImpl extends BaseServiceImpl<WaterStatus> implements WaterStatusService{

	@Autowired
	WaterStatusDao waterStatusDao;
	
	@Override
	public WaterStatus findOneByCreateTimeDesc() {
		return waterStatusDao.findListByHql("from WaterStatus ws order by ws.createTime desc").get(0);
	}

}
