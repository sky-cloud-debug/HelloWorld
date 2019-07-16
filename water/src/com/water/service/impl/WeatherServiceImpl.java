package com.water.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.water.common.bean.Page;
import com.water.dao.WeatherDao;
import com.water.model.Soil;
import com.water.model.Weather;
import com.water.model.WeatherCollectStatisticsModel;
import com.water.service.WeatherService;

@Service
public class WeatherServiceImpl extends MyBaseServiceImpl<Weather> implements
		WeatherService {

	@Autowired
	WeatherDao weatherDao;

	@Override
	public double getLastDayAverageRainHour(int pageNo) {
		Page<Soil> page = new Page<Soil>();
		page.setPageNo(pageNo);
		page.setPageSize(24);
		List<Weather> list = weatherDao.findListByHqlAndPage(
				"from Weather order by createTime desc", page);
		double rainHour = Double.parseDouble(list.get(0).getRainHour());

		page.setPageNo(pageNo + 1);
		page.setPageSize(24);
		list = weatherDao.findListByHqlAndPage(
				"from Weather order by createTime desc", page);
		double rainHour2 = Double.parseDouble(list.get(0).getRainHour());

		return rainHour - rainHour2;
	}

	@Override
	public double getLastDayHighestTemp() {
		Page<Weather> page = new Page<Weather>();
		page.setPageNo(1);
		page.setPageSize(24);
		List<Weather> list = weatherDao.findListByHqlAndPage(
				"from Weather w order by w.createTime desc", page);
		double max = 0;
		for (Weather weather : list) {
			double ariTemp = Double.parseDouble(weather.getAirTemp());
			if (ariTemp > max) {
				max = ariTemp;
			}
		}
		return max;
	}

	@Override
	public double getLastDayAverageWinSpeed() {
		Page<Weather> page = new Page<Weather>();
		page.setPageNo(1);
		page.setPageSize(24);
		List<Weather> list = weatherDao.findListByHqlAndPage(
				"from Weather order by createTime desc", page);
		double sum = 0;
		int size = list.size();
		List<Integer> ids = new ArrayList<Integer>();
		for (int i = 0; i < list.size(); i++) {
			double winSpeed = Double.parseDouble(list.get(i).getWindSpeed());
			sum += winSpeed;
			if (winSpeed == 0) {
				ids.add(i);
				size--;
			}
		}
		for (int i = 0; i < ids.size(); i++) {
			list.remove(ids.get(i));
		}
		double avgWinSpeed = sum / size;
		return avgWinSpeed;
	}

	@Override
	public List<WeatherCollectStatisticsModel> statisticWeatherByCreateTime(
			Integer regionId, Date startTime, Date endTime, boolean byDay) {
		return weatherDao.statisticWeatherByCreateTime(regionId, startTime,
				endTime, byDay);
	}

	@Override
	public double getLastDayLowestTemp() {
		Page<Weather> page = new Page<Weather>();
		page.setPageNo(1);
		page.setPageSize(24);
		List<Weather> list = weatherDao.findListByHqlAndPage(
				"from Weather w order by w.createTime desc", page);
		double min = 110;
		for (Weather weather : list) {
			double ariTemp = Double.parseDouble(weather.getAirTemp());
			if (ariTemp < min ) {
				min = ariTemp;
			}
		}
		return min;
	}

	@Override
	public double getLastDayAverageWinHumi() {
		Page<Weather> page = new Page<Weather>();
		page.setPageNo(1);
		page.setPageSize(24);
		List<Weather> list = weatherDao.findListByHqlAndPage(
				"from Weather order by createTime desc", page);
		double sum = 0;
		int size = list.size();
		List<Integer> ids = new ArrayList<Integer>();
		for (int i = 0; i < list.size(); i++) {
			double winHumi = Double.parseDouble(list.get(i).getAirHumi());
			sum += winHumi;
			if (winHumi == 0) {
				ids.add(i);
				size--;
			}
		}
		for (int i = 0; i < ids.size(); i++) {
			list.remove(ids.get(i));
		}
		double avgHumi = sum / size;
		return avgHumi;
	}
	
	@Override
	public List<Weather> getWeatherSunLong() {
		Page<Weather> page = new Page<Weather>();
		page.setPageNo(1);
		page.setPageSize(24);
		List<Weather> list = weatherDao.findListByHqlAndPage(
				"from Weather order by createTime desc", page);
		return list;
	}

}
