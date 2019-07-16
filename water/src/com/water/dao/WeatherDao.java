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
public class WeatherDao extends MyBaseDaoImpl<Weather> implements
		BaseDao<Weather> {
	 private static int[] date={0,31,28,31,30,31,30,31,31,30,31,30,31};
	    private static int[] date1={0,31,29,31,30,31,30,31,31,30,31,30,31};
	    public  boolean judgeYear(int year)
	    {
	    	if((year%4==0&&year%100!=0)||year%400==0)
	    	{
	    		return true;
	    	}
	    	return false;
	    }
	    public int[] updateEndTime(int [] bagTime)
	    {
	    	if(judgeYear(bagTime[0]))
	    	{
	    		bagTime[2]++;
	    	if(bagTime[2]>date1[1]){
				 bagTime[1]++; 
				 bagTime[2]=1;
				 if(bagTime[2]>12)
				 {
					 bagTime[0]++;
					 bagTime[1]=1;
					 bagTime[2]=1;
				 }
			 }	 }
	    	else{
	    		bagTime[2]++;
	    		if(bagTime[2]>date[1]){
	   			 bagTime[1]++; 
	   			 bagTime[2]=1;
	   			 if(bagTime[2]>12)
	   			 {
	   				 bagTime[0]++;
	   				 bagTime[1]=1;
	   				 bagTime[2]=1;
	   			 }
	   		 }	
	    	}
	    	return bagTime;
	    }
	public List<WeatherCollectStatisticsModel> statisticWeatherByCreateTime(Integer regionId,Date startTime,Date endTime,boolean byDay){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String endTime1=sdf.format(endTime);
		 String[] tempenddate1=endTime1.split("-");
		 endTime1=tempenddate1[0]+tempenddate1[1]+tempenddate1[2];
		 int tempendyear2=Integer.parseInt(tempenddate1[0]);
		 int tempenddate2=Integer.parseInt(tempenddate1[2]);
		 int tempendmonth2=Integer.parseInt(tempenddate1[1]);
		 int [] bagTime={tempendyear2,tempendmonth2,tempenddate2};
		 int [] bagNewTime=updateEndTime(bagTime);
		 @SuppressWarnings("deprecation")
		Date endDate= new Date(bagNewTime[0]-1900,bagNewTime[1]-1,bagNewTime[2]);
		 String endTime2=sdf.format(endDate);
		//统计的sql语句
		
		String sql;
		if(byDay){
			sql="select avg(s.air_humi),avg(s.air_temp),avg(s.co2),avg(s.rain_hour),avg(s.sun_data),avg(s.win_dir),avg(s.win_speed),create_time"+ 
			 " from irri_weather s "+
			 " where s.region_id="+regionId+ 
			  " and create_time between date_format('"+sdf.format(startTime)+"','%y-%m-%d')  and date_format('"+endTime2+"','%y-%m-%d')"+
			 " group by DATE_FORMAT(create_time,'%Y %m %d')";
		}else{
			sql="select avg(s.air_humi),avg(s.air_temp),avg(s.co2),avg(s.rain_hour),avg(s.sun_data),avg(s.win_dir),avg(s.win_speed),create_time "+ 
					 " from irri_weather s "+
					 " where s.region_id="+regionId+ 
					  " and create_time between date_format('"+sdf.format(startTime)+"','%y-%m-%d')  and date_format('"+endTime2+"','%y-%m-%d')"+
					 "  group by DATE_FORMAT(create_time,'%Y %m %d %H')";
		}
		//查询
		Query query=getSession().createSQLQuery(sql);
		//查询结果
		List<Object[]> list=query.list();
		//封装查询结果
		List<WeatherCollectStatisticsModel> modalList=new ArrayList<WeatherCollectStatisticsModel>();
		for (Object[] objects : list) {
			WeatherCollectStatisticsModel modal=new WeatherCollectStatisticsModel();
			try {
				BeanUtils.setProperty(modal, "airHumi",objects[0]);
				BeanUtils.setProperty(modal, "airTemp",objects[1]);
				BeanUtils.setProperty(modal, "co2",objects[2]);
				BeanUtils.setProperty(modal, "rainHour",objects[3]);
				BeanUtils.setProperty(modal, "sunData",objects[4]);
				BeanUtils.setProperty(modal, "windDir",objects[5]);
				BeanUtils.setProperty(modal, "windSpeed",objects[6]);
				BeanUtils.setProperty(modal, "createTime",new Date(((Timestamp)objects[7]).getTime()));
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			modalList.add(modal);
		}
		return modalList;
	}
	public List<Weather> getAllWeather() {
		Session session=this.getSession();
		Query query=session.createQuery("from Weather");
		return query.list();
	}
	

}