package com.water.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.water.common.bean.Page;
import com.water.dao.SoilDao;
import com.water.dao.SoilDao2;
import com.water.model.Soil;
import com.water.model.Soil2;
import com.water.model.SoilCollectStatisticsModel;
import com.water.model.SoilCollectStatisticsModel2;
import com.water.service.SoilService;
import com.water.service.SoilService2;

@Service
public class SoilServiceImpl2 extends MyBaseServiceImpl<Soil2> implements
		SoilService2 {
	@Autowired
	SoilDao2 soilDao;	
	
	public List<SoilCollectStatisticsModel2> statisticSoilByCreateTime(Integer plotId,Date startTime,Date endTime,boolean byDay){
		return soilDao.statisticSoilByCreateTime(plotId, startTime, endTime, byDay);
	}

	@Override
	public double getLastDayAverageSoilHumi(int pageNo) {
		Page<Soil2> page=new Page<Soil2>();
		page.setPageNo(pageNo);
		page.setPageSize(24);
		 List<Soil2> list = soilDao.findListByHqlAndPage("from Soil2 order by createTime desc",page);
		 double sum=0;
		 int size = list.size();
		 List<Integer> ids=new ArrayList<Integer>();
		 for (int i = 0; i < list.size(); i++) {
			 double soilHumi = Double.parseDouble(list.get(i).getSoilTemp());
			 sum+=soilHumi;
			 if(soilHumi==0){
				  ids.add(i);
				 size--;
			 }
		}
		 for (int i = 0; i < ids.size(); i++) {
			list.remove(ids.get(i));
		}
		 double avgSoilHumi=sum/size;
		 return avgSoilHumi;
	}
	

}
