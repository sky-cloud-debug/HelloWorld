package com.water.service;

import java.util.Date;
import java.util.List;

import com.water.model.Soil;
import com.water.model.Soil2;
import com.water.model.SoilCollectStatisticsModel;
import com.water.model.SoilCollectStatisticsModel2;

public interface SoilService2 extends MyBaseService<Soil2>{

	public List<SoilCollectStatisticsModel2> statisticSoilByCreateTime(Integer regionId,Date startTime,Date endTime,boolean byDay);

	public double getLastDayAverageSoilHumi(int pageNo);

}
