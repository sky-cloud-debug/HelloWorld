package com.water.service;

import com.water.common.bean.Page;
import com.water.common.service.BaseService;

public interface MyBaseService<T> extends BaseService<T> {

	Page<T> findListByRegionIdAndPage(Integer pageNo,Integer pageSize, Integer regionId);
    Page<T> findListByPlotIdAndPage(Integer pageNo,Integer pageSize, Integer regionId);
    Page<T> findListByPlotIdAndPageAsc(Integer pageNo,Integer pageSize, Integer regionId);
    Page<T> findListByPlotName(Integer pageNo,Integer pageSize, String plotName);

}
