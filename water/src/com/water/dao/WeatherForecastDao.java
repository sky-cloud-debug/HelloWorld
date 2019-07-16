package com.water.dao;

import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.water.common.bean.Page;
import com.water.common.dao.BaseDao;
import com.water.model.SoilCollectStatisticsModel;
import com.water.model.Weather;
import com.water.model.WeatherCollectStatisticsModel;
import com.water.model.WeatherForecast;

/**
 * 
 * 类名: WeatherDao<BR>
 * 描述: 气象Dao<BR>
 * 创建人:翟旭光 <BR>
 * 时间：2016年4月15日-下午12:20:21 <BR>
 * 
 * @version 1.0
 */
@Repository
public class WeatherForecastDao extends MyBaseDaoImpl<WeatherForecast> implements
		BaseDao<WeatherForecast> {
	
}