package com.water.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.water.common.bean.Page;
import com.water.common.service.BaseServiceImpl;
import com.water.dao.MyBaseDaoImpl;
import com.water.model.Area;
import com.water.service.MyBaseService;

public class MyBaseServiceImpl<T> extends BaseServiceImpl<T> implements MyBaseService<T>{

	@Autowired
	protected MyBaseDaoImpl<T> dao;
	
	@Override
	public Page<T> findListByRegionIdAndPage(Integer pageNo, Integer pageSize,
			Integer regionId) {
		Page<T> page=new Page<T>();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		
		return dao.findListByRegionIdAndPage(page, regionId);
	}

	@Override
	public Page<T> findListByPlotIdAndPage(Integer pageNo, Integer pageSize,
			Integer plotId) {
		Page<T> page=new Page<T>();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		
		return dao.findListByPlotIdAndPage(page, plotId);
		
	}
	@Override
	public Page<T> findListByPlotIdAndPageAsc(Integer pageNo, Integer pageSize,
			Integer plotId) {
		Page<T> page=new Page<T>();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		
		return dao.findListByPlotIdAndPageAsc(page, plotId);
		
	}
	@Override
	public Page<T> findListByPlotName(Integer pageNo, Integer pageSize, String plotName){
		Page<T> page=new Page<T>();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		
		return dao.findListByPlotName(page, plotName);
		
	}

}
