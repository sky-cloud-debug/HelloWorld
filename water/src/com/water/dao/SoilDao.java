package com.water.dao;

import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.water.common.dao.BaseDao;
import com.water.model.Soil;
import com.water.model.SoilCollectStatisticsModel;

/**
 * 
 * 类名: SoilDao<BR>
 * 描述: 土壤Dao<BR>
 * 创建人:翟旭光 <BR>
 * 时间：2016年4月15日-下午12:24:10 <BR>
 * @version 1.0
 */
@Repository
public class SoilDao extends MyBaseDaoImpl<Soil> implements BaseDao<Soil>{
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
	public List<SoilCollectStatisticsModel> statisticSoilByCreateTime(String plotIdd,Date startTime,Date endTime,boolean byDay){
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
			sql="select avg(soil_humi),avg(soil_temp),create_time from irri_soil s where s.dtu_id="+plotIdd+" and create_time between date_format('"+sdf.format(startTime)+"','%y-%m-%d') and date_format('"+endTime2+"','%y-%m-%d') group by DATE_FORMAT(create_time,'%Y %m %d')";
		}else{
			sql="select avg(soil_humi),avg(soil_temp),create_time from irri_soil s where s.dtu_id="+plotIdd+" and create_time between date_format('"+sdf.format(startTime)+"','%y-%m-%d') and date_format('"+endTime2+"','%y-%m-%d') group by DATE_FORMAT(create_time,'%Y %m %d %H')";
		}
		//查询
		Query query=getSession().createSQLQuery(sql);
		//查询结果
		List<Object[]> list=query.list();
		//封装查询结果
		List<SoilCollectStatisticsModel> soilCollectStatisticModel=new ArrayList<SoilCollectStatisticsModel>();
		for (Object[] objects : list) {
			SoilCollectStatisticsModel modal=new SoilCollectStatisticsModel();
			try {
				modal.getSoilHumi();modal.getSoilTemp();modal.getClass();
				BeanUtils.setProperty(modal, "soilHumi",objects[0]);
				BeanUtils.setProperty(modal, "soilTemp",objects[1]);
				BeanUtils.setProperty(modal, "createTime",new Date(((Timestamp)objects[2]).getTime()));
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			soilCollectStatisticModel.add(modal);
		}
		return soilCollectStatisticModel;
	}
	public List<Soil> getAllSoilList() {
		Session session=this.getSession();
		Query query=session.createQuery("from Soil");
		return query.list();
		
		
	}

}