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
import com.water.model.Weather2;
import com.water.model.WeatherCollectStatisticsModel;
import com.water.model.WeatherCollectStatisticsModel2;

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
public class WeatherDao2 extends MyBaseDaoImpl<Weather2> implements
		BaseDao<Weather2> {
	private static int[] date = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31,
			30, 31 };
	private static int[] date1 = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31,
			30, 31 };

	public boolean judgeYear(int year) {
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			return true;
		}
		return false;
	}

	public int[] updateEndTime(int[] bagTime) {
		if (judgeYear(bagTime[0])) {
			bagTime[2]++;
			if (bagTime[2] > date1[1]) {
				bagTime[1]++;
				bagTime[2] = 1;
				if (bagTime[2] > 12) {
					bagTime[0]++;
					bagTime[1] = 1;
					bagTime[2] = 1;
				}
			}
		} else {
			bagTime[2]++;
			if (bagTime[2] > date[1]) {
				bagTime[1]++;
				bagTime[2] = 1;
				if (bagTime[2] > 12) {
					bagTime[0]++;
					bagTime[1] = 1;
					bagTime[2] = 1;
				}
			}
		}
		return bagTime;
	}

	public static boolean[] test(Object[] obj) {
		boolean[] circumstance = {false,false,false,false,false,false};
		for(int i=0;i<6;i++){
			if (((String) (obj[i])).equals("--")) {
				System.out.println("--");
				circumstance[i]=false;
			} else {
				circumstance[i]=true;
			}
		}
		return circumstance;
	}

	// 处理"--"的数据 下洼镇
	public static List<WeatherCollectStatisticsModel2> getReWriteXiaWaCounty(List<Object[]> objs, boolean byday){
		 
		 double[] data6 ={0,0,0,0,0,0};
		 int[] data6Count ={0,0,0,0,0,0};
		 double[] result={0,0,0,0,0,0};
		 List<WeatherCollectStatisticsModel2> modalList=new ArrayList<WeatherCollectStatisticsModel2>();  
		 List<WeatherCollectStatisticsModel2> modalList2=new ArrayList<WeatherCollectStatisticsModel2>();
		 boolean[] cs = {false,false,false,false,false,false};
		 System.out.println("obj长度"+objs.size());
		 if(byday){
			 for(int d=0;d<objs.size();d++){
				 if(objs.size()==1){
				  cs =   test(objs.get(d));
				  for(int i=0;i<cs.length;i++){
					    if(cs[i]){
						data6[i]+=Double.parseDouble((String)(objs.get(d)[i]));
						data6Count[i]++;
					    }
					}
				  for(int j=0;j<cs.length;j++){
					  if(data6Count[j]==0){
						  data6Count[j]=1;
					  }
				  }
				  for(int k=0;k<cs.length;k++){
					  result[k]=data6[k]/data6Count[k];
				  }
							WeatherCollectStatisticsModel2 modal=new WeatherCollectStatisticsModel2();
							try {
								BeanUtils.setProperty(modal, "airHumi",result[0]);
								BeanUtils.setProperty(modal, "airTemp",result[1]);
								BeanUtils.setProperty(modal, "co2",result[2]);
								BeanUtils.setProperty(modal, "rainHour",result[3]);
								BeanUtils.setProperty(modal, "sunData",result[4]);
								BeanUtils.setProperty(modal, "windSpeed",result[5]);
								BeanUtils.setProperty(modal, "createTime",new Date(((Timestamp)objs.get(d)[6]).getTime()));
								System.out.println(modal);
								modalList.add(modal);
							} catch (IllegalAccessException e) {
								e.printStackTrace();
							} catch (InvocationTargetException e) {
								e.printStackTrace();
							}
				  return modalList; 
			  }
			  else{  
			  if(d==0){
			  cs =   test(objs.get(d));
			  for(int i=0;i<cs.length;i++){
				    if(cs[i]){
					data6[i]+=Double.parseDouble((String)(objs.get(d)[i]));
					System.out.println(Double.parseDouble((String)(objs.get(d)[i])));
					data6Count[i]++;
				    }
				}
			  }
			  else{
				  
			  
			  if( ((Timestamp)objs.get(d-1)[6]).getDate()==((Timestamp)objs.get(d)[6]).getDate()&&((Timestamp)objs.get(d-1)[6]).getMonth()==((Timestamp)objs.get(d)[6]).getMonth()
					  &&((Timestamp)objs.get(d-1)[6]).getYear()==((Timestamp)objs.get(d)[6]).getYear())
				 {
				     cs =   test(objs.get(d));
					 for(int i=0;i<cs.length;i++){
						    if(cs[i]){
							data6[i]+=Double.parseDouble((String)(objs.get(d)[i]));
							data6Count[i]++;
						    }
						} 
				 }
			  else{
				  for(int j=0;j<cs.length;j++){
					  if(data6Count[j]==0){
						  data6Count[j]=1;
					  }
				  }  
			
			  for(int k=0;k<cs.length;k++){
				  result[k]=data6[k]/data6Count[k];
			  }
			  
				  WeatherCollectStatisticsModel2 modal=new WeatherCollectStatisticsModel2();
					try {
						BeanUtils.setProperty(modal, "airHumi",result[0]);
						BeanUtils.setProperty(modal, "airTemp",result[1]);
						BeanUtils.setProperty(modal, "co2",result[2]);
						BeanUtils.setProperty(modal, "rainHour",result[3]);
						BeanUtils.setProperty(modal, "sunData",result[4]);
						BeanUtils.setProperty(modal, "windSpeed",result[5]);
						BeanUtils.setProperty(modal, "createTime",new Date(((Timestamp)objs.get(d-1)[6]).getTime()));
						System.out.println(modal);
						modalList2.add(modal);
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}
					for(int k=0;k<cs.length;k++){
						result[k]=0;
					}
					for(int k=0;k<cs.length;k++){
						data6[k]=0;
					}
					for(int k=0;k<cs.length;k++){
						data6Count[k]=0;
					}
					 cs =   test(objs.get(d));
					  for(int i=0;i<cs.length;i++){
						    if(cs[i]){
							data6[i]+=Double.parseDouble((String)(objs.get(d)[i]));
							data6Count[i]++;
						    }
						}
			  }		
		  } }
				
			 }if(objs.size()>0){
			 for(int j=0;j<cs.length;j++){
				  if(data6Count[j]==0){
					  data6Count[j]=1;
				  }
			  }  
		
		  for(int k=0;k<cs.length;k++){
			  result[k]=data6[k]/data6Count[k];
		  }
		  
			  WeatherCollectStatisticsModel2 modal=new WeatherCollectStatisticsModel2();
				try {
					BeanUtils.setProperty(modal, "airHumi",result[0]);
					BeanUtils.setProperty(modal, "airTemp",result[1]);
					BeanUtils.setProperty(modal, "co2",result[2]);
					BeanUtils.setProperty(modal, "rainHour",result[3]);
					BeanUtils.setProperty(modal, "sunData",result[4]);
					BeanUtils.setProperty(modal, "windSpeed",result[5]);
					BeanUtils.setProperty(modal, "createTime",new Date(((Timestamp)objs.get(objs.size()-1)[6]).getTime()));
					System.out.println(modal);
					modalList2.add(modal);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			 }
			 return modalList2;
			 }
		 else{if(objs.size()>0){
			 System.out.println("dddddddddddddddddddd");
			 for(int c=0;c<objs.size();c++){
				 System.out.println(c);
				 cs = test(objs.get(c));
				 for(int i=0;i<cs.length;i++){
					    if(cs[i]){
						result[i]=Double.parseDouble((String)(objs.get(c)[i]));
						System.out.println(result[i]);
					    }
				 }
				 WeatherCollectStatisticsModel2 modal1=new WeatherCollectStatisticsModel2();
					  try {
							BeanUtils.setProperty(modal1, "airHumi",result[0]);
							BeanUtils.setProperty(modal1, "airTemp",result[1]);
							BeanUtils.setProperty(modal1, "co2",result[2]);
							BeanUtils.setProperty(modal1, "rainHour",result[3]);
							BeanUtils.setProperty(modal1, "sunData",result[4]);
							BeanUtils.setProperty(modal1, "windSpeed",result[5]);
							BeanUtils.setProperty(modal1, "createTime",new Date(((Timestamp)objs.get(c)[6]).getTime()));
						System.out.println(new Date(((Timestamp)objs.get(c)[6]).getTime()));
						modalList2.add(modal1);
					  } catch (Exception e) {
							e.printStackTrace();
						}
					  
					  for(int k=0;k<cs.length;k++){
							result[k]=0;
						}
			 }
					}
		return modalList2;
		}
	  }

	public List<WeatherCollectStatisticsModel2> statisticWeatherByCreateTime(
			Integer plotId, Date startTime, Date endTime, boolean byDay) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String endTime1 = sdf.format(endTime);
		String[] tempenddate1 = endTime1.split("-");
		endTime1 = tempenddate1[0] + tempenddate1[1] + tempenddate1[2];
		int tempendyear2 = Integer.parseInt(tempenddate1[0]);
		int tempenddate2 = Integer.parseInt(tempenddate1[2]);
		int tempendmonth2 = Integer.parseInt(tempenddate1[1]);
		int[] bagTime = { tempendyear2, tempendmonth2, tempenddate2 };
		int[] bagNewTime = updateEndTime(bagTime);
		@SuppressWarnings("deprecation")
		Date endDate = new Date(bagNewTime[0] - 1900, bagNewTime[1] - 1,
				bagNewTime[2]);
		String endTime2 = sdf.format(endDate);
		// 统计的sql语句

		String sql;
		sql = "select s.air_humi,s.air_temp,s.co2,s.rain_hour,s.sun_data,s.win_speed,create_time"
				+ " from irri_weather2 s "
				+ " where s.plot_id="
				+ plotId
				+ " and create_time between date_format('"
				+ sdf.format(startTime)
				+ "','%y-%m-%d')  and date_format('"
				+ endTime2 + "','%y-%m-%d') order by create_time asc";

		/*
		 * sql=
		 * "select avg(s.air_humi),avg(s.air_temp),avg(s.co2),avg(s.rain_hour),avg(s.sun_data),avg(s.win_speed),create_time"
		 * + " from irri_weather2 s "+ " where s.plot_id="+plotId+
		 * " and create_time between date_format('"
		 * +sdf.format(startTime)+"','%y-%m-%d')  and date_format('"
		 * +endTime2+"','%y-%m-%d')"+
		 * " group by DATE_FORMAT(create_time,'%Y %m %d')";
		 */

		/*
		 * sql=
		 * "select avg(s.air_humi),avg(s.air_temp),avg(s.co2),avg(s.rain_hour),avg(s.sun_data),avg(s.win_speed),create_time "
		 * + " from irri_weather2 s "+ " where s.plot_id="+plotId+
		 * " and create_time between date_format('"
		 * +sdf.format(startTime)+"','%y-%m-%d')  and date_format('"
		 * +endTime2+"','%y-%m-%d')"+
		 * "  group by DATE_FORMAT(create_time,'%Y %m %d %H')";
		 */

		// 查询
		Query query = getSession().createSQLQuery(sql);
		// 查询结果
		List<Object[]> list = query.list();
        if(list!=null){
        	System.out.println("明明有数据呀！"+"总共有："+list.size()+"个");
        }
		// 封装查询结果
		List<WeatherCollectStatisticsModel2> modalList = new ArrayList<WeatherCollectStatisticsModel2>();
		/*for (Object[] objects : list) {
			WeatherCollectStatisticsModel2 modal = new WeatherCollectStatisticsModel2();
			try {
				BeanUtils.setProperty(modal, "airHumi", objects[0]);
				BeanUtils.setProperty(modal, "airTemp", objects[1]);
				BeanUtils.setProperty(modal, "co2", objects[2]);
				BeanUtils.setProperty(modal, "rainHour", objects[3]);
				BeanUtils.setProperty(modal, "sunData", objects[4]);
				BeanUtils.setProperty(modal, "windSpeed", objects[5]);
				BeanUtils.setProperty(modal, "createTime", new Date(
						((Timestamp) objects[6]).getTime()));
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			modalList.add(modal);
		}*/
		if(byDay){
			System.out.println("有哪些数据呢？如果按照天的话");
			modalList = getReWriteXiaWaCounty(list,true);
			for(WeatherCollectStatisticsModel2 w2:modalList){
				System.out.println(w2);
			}
			System.out.println(modalList.size()+"元数据");
		}else{
			System.out.println("有哪些数据呢？如果按照小时的话");

			modalList = getReWriteXiaWaCounty(list,false);
			for(WeatherCollectStatisticsModel2 w2:modalList){
				System.out.println(w2);
			}
			System.out.println(modalList.size()+"元数据");
		}
		return modalList;
	}

	public List<Weather2> getAllWeather() {
		Session session = this.getSession();
		Query query = session.createQuery("from Weather2");
		return query.list();
	}

}