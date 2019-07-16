package com.water.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.water.common.bean.Page;
import com.water.dao.SoilDao;
import com.water.model.Soil;
import com.water.model.SoilCollectStatisticsModel;
import com.water.service.SoilService;

@Service
public class SoilServiceImpl extends MyBaseServiceImpl<Soil> implements
		SoilService {
	@Autowired
	SoilDao soilDao;	
	
	public List<SoilCollectStatisticsModel> statisticSoilByCreateTime(String plotIdd,Date startTime,Date endTime,boolean byDay){
		return soilDao.statisticSoilByCreateTime(plotIdd, startTime, endTime, byDay);
	}

	@Override
	public double getLastDayAverageSoilHumi(int pageNo) {
		Page<Soil> page=new Page<Soil>();
		page.setPageNo(pageNo);
		page.setPageSize(48);
		 List<Soil> list = soilDao.findListByHqlAndPage("from Soil order by createTime desc",page);
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
