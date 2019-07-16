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
import com.water.model.Soil2;
import com.water.model.SoilCollectStatisticsModel;
import com.water.model.SoilCollectStatisticsModel2;
import com.water.model.WeatherCollectStatisticsModel2;

/**
 * 
 * 类名: SoilDao2<BR>
 * 描述: 土壤Dao<BR>
 * 创建人:毕燕东 <BR>
 * 时间：2016年4月15日-下午12:24:10 <BR>
 * @version 1.0
 */
@Repository
public class SoilDao2 extends MyBaseDaoImpl<Soil2> implements BaseDao<Soil2>{
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
	public static List<SoilCollectStatisticsModel2> getReWriteXiaWaCounty(List<Object[]> objs, boolean byday){
		 
		 double[] data6 ={0,0,0,0};
		 int[] data6Count ={0,0,0,0};
		 double[] result={0,0,0,0};
		 List<SoilCollectStatisticsModel2> modalList=new ArrayList<SoilCollectStatisticsModel2>();  
		 List<SoilCollectStatisticsModel2> modalList2=new ArrayList<SoilCollectStatisticsModel2>();
		 boolean[] cs = {false,false,false,false,false,false};
		 
		 int count123=0;
		 double sum123=0;
		 if(byday){
			 for(int d=0;d<objs.size();d++){
				 if(objs.size()==1){
				  cs =   test(objs.get(d));
				  for(int j=0;j<3;j++){
				    	if(cs[j]){
				    	count123++;
				    	sum123+=Double.parseDouble((String)(objs.get(d)[j]));
				    	}
				    }
				  data6[0]=sum123;
				  data6Count[0]=count123++;
				  for(int i=3;i<cs.length;i++){
					    
					  if(cs[i]){
						data6[i-2]+=Double.parseDouble((String)(objs.get(d)[i]));
						data6Count[i-2]++;
					    }
					}
				  for(int j=0;j<data6.length;j++){
					  if(data6Count[j]==0){
						  data6Count[j]=1;
					  }
				  }
				  for(int k=0;k<cs.length;k++){
					  result[k]=data6[k]/data6Count[k];
				  }
							SoilCollectStatisticsModel2 modal=new SoilCollectStatisticsModel2();
							try {
								BeanUtils.setProperty(modal, "soilHumi",result[0]);
								BeanUtils.setProperty(modal, "soilTemp",result[1]);
								BeanUtils.setProperty(modal, "ph",result[2]);
								BeanUtils.setProperty(modal, "elect",result[3]);
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
			  for(int j=0;j<3;j++){
			    	if(cs[j]){
			    	count123++;
			    	sum123+=Double.parseDouble((String)(objs.get(d)[j]));
			    	}
			    }
			  data6[0]=sum123;
			  data6Count[0] = count123;
			  for(int i=3;i<cs.length;i++){
				    
				  if(cs[i]){
					data6[i-2]+=Double.parseDouble((String)(objs.get(d)[i]));
					data6Count[i-2]++;
				    }
				}
			  for(int j=0;j<data6.length;j++){
				  if(data6Count[j]==0){
					  data6Count[j]=1;
				  }
			  }
			  for(int i=0;i<data6.length;i++){
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
				     for(int j=0;j<3;j++){
					    	if(cs[j]){
					    	count123++;
					    	sum123+=Double.parseDouble((String)(objs.get(d)[j]));
					    	}
					    }
					  data6[0]=sum123;
					  data6Count[0] = count123;
					  for(int i=3;i<cs.length;i++){
						    
						  if(cs[i]){
							data6[i-2]+=Double.parseDouble((String)(objs.get(d)[i]));
							data6Count[i-2]++;
						    }
						}
					  for(int j=0;j<data6.length;j++){
						  if(data6Count[j]==0){
							  data6Count[j]=1;
						  }
					  }
				 }
			  else{
				  for(int j=0;j<data6.length;j++){
					  if(data6Count[j]==0){
						  data6Count[j]=1;
					  }
				  }  
			
			  for(int k=0;k<data6.length;k++){
				  result[k]=data6[k]/data6Count[k];
			  }
			  
				  SoilCollectStatisticsModel2 modal=new SoilCollectStatisticsModel2();
					try {
						BeanUtils.setProperty(modal, "soilHumi",result[0]);
						BeanUtils.setProperty(modal, "soilTemp",result[1]);
						BeanUtils.setProperty(modal, "ph",result[2]);
						BeanUtils.setProperty(modal, "elect",result[3]);
					
						BeanUtils.setProperty(modal, "createTime",new Date(((Timestamp)objs.get(d-1)[6]).getTime()));
						System.out.println(modal);
						modalList2.add(modal);
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}
					for(int k=0;k<data6.length;k++){
						result[k]=0;
					}
					for(int k=0;k<data6.length;k++){
						data6[k]=0;
					}
					for(int k=0;k<data6.length;k++){
						data6Count[k]=0;
					}
					 cs =   test(objs.get(d));
					 for(int j=0;j<3;j++){
					    	if(cs[j]){
					    	count123++;
					    	sum123+=Double.parseDouble((String)(objs.get(d)[j]));
					    	}
					    }
					  data6[0]=sum123;
					  data6Count[0] = count123;
					  for(int i=3;i<cs.length;i++){
						    
						  if(cs[i]){
							data6[i-2]+=Double.parseDouble((String)(objs.get(d)[i]));
							data6Count[i-2]++;
						    }
						}
			  }		
		  } }
				
			 }if(objs.size()>0){
			 for(int j=0;j<data6.length;j++){
				  if(data6Count[j]==0){
					  data6Count[j]=1;
				  }
			  }  
		
		  for(int k=0;k<data6.length;k++){
			  result[k]=data6[k]/data6Count[k];
		  }
		  
			  SoilCollectStatisticsModel2 modal=new SoilCollectStatisticsModel2();
				try {
					BeanUtils.setProperty(modal, "soilHumi",result[0]);
					BeanUtils.setProperty(modal, "soilTemp",result[1]);
					BeanUtils.setProperty(modal, "ph",result[2]);
					BeanUtils.setProperty(modal, "elect",result[3]);
					
					BeanUtils.setProperty(modal, "createTime",new Date(((Timestamp)objs.get(objs.size()-1)[6]).getTime()));
					System.out.println(modal);
					modalList2.add(modal);
					System.out.println("我现在的长度："+modalList2.size());
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
				 for(int j=0;j<3;j++){
				    	if(cs[j]){
				    	count123++;
				    	sum123+=Double.parseDouble((String)(objs.get(c)[j]));
				    	}
				    }
				  data6[0]=sum123;
				  data6Count[0] = count123;
				  if(data6Count[0]!=0)
				  result[0]=data6[0]/data6Count[0];
				  else{result[0]=-10;}
				  
				 for(int i=3;i<cs.length;i++){
					    if(cs[i]){
						result[i-2]=Double.parseDouble((String)(objs.get(c)[i]));
					    }else{
					    	result[i-2]=0;
					    }
				 }
				 SoilCollectStatisticsModel2 modal1=new SoilCollectStatisticsModel2();
					  try {
							BeanUtils.setProperty(modal1, "soilHumi",result[0]);
							BeanUtils.setProperty(modal1, "soilTemp",result[1]);
							BeanUtils.setProperty(modal1, "ph",result[2]);
							BeanUtils.setProperty(modal1, "elect",result[3]);
							BeanUtils.setProperty(modal1, "createTime",new Date(((Timestamp)objs.get(c)[6]).getTime()));
						System.out.println(new Date(((Timestamp)objs.get(c)[6]).getTime()));
						modalList2.add(modal1);
					  } catch (Exception e) {
							e.printStackTrace();
						} 
					}}
		return modalList2;
		}
	  }

    
    
    
    
    
    
    
	public List<SoilCollectStatisticsModel2> statisticSoilByCreateTime(Integer plotId,Date startTime,Date endTime,boolean byDay){
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
		sql="select soil_humi,soil_humi2,soil_humi3,soil_temp,soil_ph,soil_elect,create_time from irri_soil2 s where s.plot_id="+plotId+" and create_time between date_format('"+sdf.format(startTime)+"','%y-%m-%d') and date_format('"+endTime2+"','%y-%m-%d') order by create_time asc";
		/*if(byDay){
		}else{
		}*/
		//查询
		Query query=getSession().createSQLQuery(sql);
		System.out.println(query.list());
		//查询结果
		List<Object[]> list=query.list();
		//封装查询结果
		List<SoilCollectStatisticsModel2> soilCollectStatisticModel=new ArrayList<SoilCollectStatisticsModel2>();
		if(list!=null){
        	System.out.println("明明有数据呀！"+"总共有："+list.size()+"个");
        }
		// 封装查询结果
		List<SoilCollectStatisticsModel2> modalList = new ArrayList<SoilCollectStatisticsModel2>();
		
		if(byDay){
			System.out.println("有哪些数据呢？如果按照天的话");
			modalList = getReWriteXiaWaCounty(list,true);
			for(SoilCollectStatisticsModel2 w2:modalList){
				System.out.println(w2);
			}
			System.out.println(modalList.size()+"元数据");
		}else{
			System.out.println("有哪些数据呢？如果按照小时的话");

			modalList = getReWriteXiaWaCounty(list,false);
			for(SoilCollectStatisticsModel2 w2:modalList){
				System.out.println(w2);
			}
			System.out.println(modalList.size()+"元数据");
		}
	
		/*for (Object[] objects : list) {
			SoilCollectStatisticsModel2 modal=new SoilCollectStatisticsModel2();
			try {
				modal.getSoilHumi();modal.getSoilTemp();modal.getClass();
				//	BeanUtils.setProperty(modal, "soilHumi",-1);
				int count =3;
				int sum=0;
				for(int h=0;h<3;h++){
					if(objects[h]==null){
						count--;
					}
					else{
						sum+=(Double)objects[h];
					}
				}
				if(count==0){
					
					BeanUtils.setProperty(modal, "soilHumi",-1);
				}
				BeanUtils.setProperty(modal, "soilHumi",sum/1.0/count);
				
				BeanUtils.setProperty(modal, "soilTemp",objects[3]);
				BeanUtils.setProperty(modal, "createTime",new Date(((Timestamp)objects[6]).getTime()));
				BeanUtils.setProperty(modal, "ph",objects[4]);
				BeanUtils.setProperty(modal, "elect",objects[5]);
				
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			soilCollectStatisticModel.add(modal);
		}*/
		return modalList;
	}
	public List<Soil2> getAllSoilList() {
		Session session=this.getSession();
		Query query=session.createQuery("from Soil2");
		return query.list();
		
		
	}

}