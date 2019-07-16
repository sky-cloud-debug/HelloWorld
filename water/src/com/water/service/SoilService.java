package com.water.service;

import java.util.Date;
import java.util.List;

import com.water.model.Soil;
import com.water.model.SoilCollectStatisticsModel;

public interface SoilService extends MyBaseService<Soil>{

	public List<SoilCollectStatisticsModel> statisticSoilByCreateTime(String plotIdd,Date startTime,Date endTime,boolean byDay);

	public double getLastDayAverageSoilHumi(int pageNo);

}
