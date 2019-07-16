package com.water.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.water.common.bean.Page;
import com.water.common.service.BaseServiceImpl;
import com.water.dao.CropDao;
import com.water.model.Crop;
import com.water.service.CropService;

@Service
public class CropServiceImpl extends BaseServiceImpl<Crop> implements
		CropService {

	@Autowired
	CropDao dao;
	
	@Override
	public Page<Crop> findCropListByAreaIdAndPage(Integer pageNo,
			Integer pageSize, Integer areaId) {
		Page<Crop> page=new Page<Crop>();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		return dao.findCropListByAreaIdAndPage(page,areaId);
	}

	
}
