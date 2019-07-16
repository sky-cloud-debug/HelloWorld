package com.water.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.water.model.Area;
import com.water.model.Region;
import com.water.model.Weather;
import com.water.model.WeatherForecast;
import com.water.service.AreaService;
import com.water.service.RegionService;
import com.water.service.SoilService;
import com.water.service.WeatherService;
import com.water.web.listener.TimerListener;

public final class HttpForForecast {
	public static String message="";
	public static boolean statuss=true;
	public static List<WeatherData> request(String httpUrl) {
		BufferedReader reader = null;
		String result1 = null;
		String result;
		StringBuffer sbf = new StringBuffer();
		List<WeatherData> list = new ArrayList<WeatherData>();
		try {
			URL url = new URL(httpUrl);
			HttpsURLConnection connection = (HttpsURLConnection) url
					.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();
			InputStream is = connection.getInputStream();
			reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			String strRead = null;
			while ((strRead = reader.readLine()) != null) {
				sbf.append(strRead);
				sbf.append("\r\n");
			}
			reader.close();
			result = sbf.toString();//30
			result1 = result.substring(14, result.length() - 3);
			JSONArray jsonArray = JSONArray.fromObject(result1);
			JSONObject jsonObject = jsonArray.getJSONObject(0);
			JSONArray daily_forecast = jsonObject
					.getJSONArray("daily_forecast");
			for (int i = 0; i < 7; i++) {
				JSONObject astro = daily_forecast.getJSONObject(i)
						.getJSONObject("astro");
				String sr = astro.getString("sr");
				String ss = astro.getString("ss");
				Date srr = null;
				Date sss = null;
				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
				srr = sdf.parse(sr);
				sss = sdf.parse(ss);

				String date = daily_forecast.getJSONObject(i).getString("date");
				Date date1 = null;
				sdf = new SimpleDateFormat("yyyy-MM-dd");
				date1 = sdf.parse(date);
				String hum = daily_forecast.getJSONObject(i).getString("hum");
				String pcpn = daily_forecast.getJSONObject(i).getString("pcpn");
				JSONObject tmp = daily_forecast.getJSONObject(i).getJSONObject(
						"tmp");
				String max = tmp.getString("max");
				String min = tmp.getString("min");
				JSONObject wind = daily_forecast.getJSONObject(i)
						.getJSONObject("wind");
				String spd = wind.getString("spd");
				System.out.println("日出="+sr+",日落="+ss+",日期="+date+",湿度="+hum+",降雨量="+pcpn+",最高气温="+max
		        		  +",最低气温="+min+",风速="+spd);
				WeatherData weatherData=new WeatherData();
				weatherData.setDate(sdf.parse(date));
				weatherData.setHumi(hum);
				weatherData.setMaxTemp(max);
				weatherData.setMinTemp(min);
				weatherData.setSunRise(sr);
				weatherData.setSunSet(ss);
				weatherData.setWaterfall(pcpn);
				weatherData.setWinSpeed(spd);

				list.add(weatherData);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//基于实时气象数据的分析预测
	public static ForeShow getRealPredict(int areaId)
	{
	 
	 RegionService regionService=TimerListener.applicationContext.getBean(RegionService.class);
	 WeatherService weatherService=TimerListener.applicationContext.getBean(WeatherService.class);
	 SoilService soilService = TimerListener.applicationContext.getBean(SoilService.class);
	 double soilHumi2 = soilService.getLastDayAverageSoilHumi(2);	
	 double soilHumi = soilService.getLastDayAverageSoilHumi(1);
	 ForeShow f1= new ForeShow();
	 
	 System.out.println(soilHumi+","+soilHumi2);
	 
	 
	 AreaService areaService=TimerListener.applicationContext.getBean(AreaService.class);
	 Area area = areaService.findListByRegionIdAndPage(1, 10,1).getContent().get(areaId);
	 double waterholdingCapacity=Double.parseDouble(area.getWaterholdingCapacity());
	
	 double W1=WaterUtil.getW1(soilHumi2*0.01, Double.parseDouble(area.getFirstStageDepthOfWetting()));
	 double lower= Double.parseDouble(area.getIrrigationLowerLimit());
	 double wettingDepth=Double.parseDouble(area.getFirstStageDepthOfWetting());
	 double Ai=Double.parseDouble(area.getIrrigationArea());//控制面积 
	 double W2=WaterUtil.getW2(soilHumi*0.01,Double.parseDouble(area.getFirstStageDepthOfWetting()));;
	 double rainHour=weatherService.getLastDayAverageRainHour(1);
	 Region region=regionService.findOneById(area.getRegion().getId());
	 double kc1=Double.parseDouble(area.getFirstCropCoefficient());
	 double kc2=Double.parseDouble(area.getSecondCropCoefficient());
	 double kc3=Double.parseDouble(area.getThirdCropCoefficient());
	 
	 double Kc=judge(new Date().getMonth()+1,new Date().getDate(),kc1,kc2,kc3);
	 System.out.println(new Date().getMonth()+1+","+new Date().getDate()+","+kc1+","+kc2+","+kc3+",kc="+Kc);
	 
	 
	 
	 int month=new Date().getMonth()+1;
	 int date = new Date().getDate();
	 int year = new  Date().getYear()+1900;
	    double altitude = Double.parseDouble(region.getAltitude());
		double u10=weatherService.getLastDayAverageWinSpeed();
		double latitude =Double.parseDouble(region.getLatitude());
		double hightemp=weatherService.getLastDayHighestTemp();
		double lowtemp = weatherService.getLastDayLowestTemp();
		double airhumi=weatherService.getLastDayAverageWinHumi();
		List<String> sunlong=new ArrayList<String>();
		List<Weather> weatherSunLong=weatherService.getWeatherSunLong();
		for(int j=0;j<24;j++)
		{
			sunlong.add(weatherSunLong.get(j).getSunData());
		}
		double sunLong = getsunLong(sunlong);
	    double et0=WaterUtil.getET0(altitude, u10, latitude, hightemp, lowtemp, airhumi, sunLong, new Date().getYear()+1900, new Date().getMonth()+1, new Date().getDate());	    
	    double ETa=et0*Kc;
	    double Wr= WaterUtil.getWr(wettingDepth, wettingDepth, soilHumi);
        double I1 = W2-W1-WaterUtil.getP(rainHour)+ETa-Wr;
        double areaSize=Double.parseDouble(area.getIrrigationArea());
        double I=I1*0.667*areaSize;
        System.out.println("基于实时气象数据，"+year+"年"+month+"月"+date+"日,预测灌水量为"+I+"立方米");
        
        if(soilHumi<lower){message="目前已达灌溉下限值，请灌溉";}
        else{
        if((W2*0.1/wettingDepth*100)<lower)
		{
        	 System.out.println("W1="+W1+",W2="+W2+"，Eta="+ETa+",昨天的土壤湿度："+soilHumi2+"，今天的土壤湿度："+soilHumi);
			System.out.println("基于实时气象数据，"+year+"年"+month+"月"+date+"日,预测灌水量为"+I+"立方米");	    
			message="基于实时气象数据预测灌水量为"+I+"立方米";
		}
        else {
        	System.out.println("今天不需要灌溉。");
        	System.out.println("2222"+","+lower);
        	message="今天不需要灌溉。";
        }
       
        
        
          Date date1=new Date(year,month,date);   	          
          f1.setDate(date1);
          f1.seteT0pre(et0);
          f1.setkCpre(Kc);
          f1.setIpre(ETa);
          f1.setSoilHumipre(W2*0.1/wettingDepth*100);
        }
		return f1;
	}
	//基于天气预报预测
	public static List<ForeShow> getForecaseData(int areaId,List<WeatherData> jsonResult)
	{
		double W1,W2=0;
		//double kc1=1;double kc2=1;double kc3=1;
		/*String cityId = "CN101121106";// 沾化代码https://api.heweather.com/v5/weather?city=CN101121106&key=472d172fe992436d888899870c1b7181

		String httpUrl = "https://free-api.heweather.com/v5/weather?city="
				+ cityId + "&key=472d172fe992436d888899870c1b7181";
		 jsonResult = HttpForForecast.request(httpUrl);*/
		
		System.out.println(jsonResult.size());
		
		
		SoilService soilService = TimerListener.applicationContext.getBean(SoilService.class);
		AreaService areaService=TimerListener.applicationContext.getBean(AreaService.class);
		WeatherService weatherService=TimerListener.applicationContext.getBean(WeatherService.class);
		RegionService regionService=TimerListener.applicationContext.getBean(RegionService.class);
		
		List<ForeShow> foreShow = new ArrayList<ForeShow>();
	
			
			double soilHumi = soilService.getLastDayAverageSoilHumi(1);
			//System.out.println(soilHumi+"什么情况这个值");
			
			Area area = areaService.findListByRegionIdAndPage(1, 10,1).getContent().get(areaId);
			Region region=regionService.findOneById(area.getRegion().getId());
			double wettingDepth=Double.parseDouble(area.getFirstStageDepthOfWetting());
			double kc1=Double.parseDouble(area.getFirstCropCoefficient());
			double kc2=Double.parseDouble(area.getSecondCropCoefficient());
			double kc3=Double.parseDouble(area.getThirdCropCoefficient());
			
			
			double waterholdingCapacity=Double.parseDouble(area.getWaterholdingCapacity());
			double rainHour=weatherService.getLastDayAverageRainHour(1);
			double altitude = Double.parseDouble(region.getAltitude());
			double u10=weatherService.getLastDayAverageWinSpeed();
			double latitude =Double.parseDouble(region.getLatitude());
			double hightemp=weatherService.getLastDayHighestTemp();
			double lowtemp = weatherService.getLastDayLowestTemp();
			double airhumi=weatherService.getLastDayAverageWinHumi();
			List<Weather> weatherSunLong=weatherService.getWeatherSunLong();
			List<String> sunlong=new ArrayList<String>();
			for(int j=0;j<24;j++)
			{
				sunlong.add(weatherSunLong.get(j).getSunData());
			}
			double sunLong = getsunLong(sunlong);
			
			int year=jsonResult.get(1).getDate().getYear()+1900;
			int month=jsonResult.get(1).getDate().getMonth()+1;
			int date=jsonResult.get(1).getDate().getDate();//日期
			double lower=Double.parseDouble(area.getIrrigationLowerLimit());//灌水量下限
            
			if(soilHumi<lower){
				List<ForeShow> ffff= new ArrayList<ForeShow>();
				statuss=false;  return ffff;};
			
			
			double Ai=Double.parseDouble(area.getIrrigationArea());//控制面积
		//	System.out.println(Ai+",,,,,,,,"+areaId);
			
  
            
            W1=WaterUtil.getW1(soilHumi*0.01,wettingDepth);
            /*rainHour1 =Double.parseDouble(jsonResult.get(i).getWaterfall());
	     		u101=Double.parseDouble(jsonResult.get(i).getWinSpeed());
	     	    hightemp1=Double.parseDouble(jsonResult.get(i).getMaxTemp());
	     		lowtemp1=Double.parseDouble(jsonResult.get(i).getMinTemp());
	     	    airhumi1=Double.parseDouble(jsonResult.get(i).getHumi());
	     	    sunlong1=getSunLong(jsonResult.get(i).getSunRise(), jsonResult.get(i).getSunSet());*/
            hightemp=Double.parseDouble(jsonResult.get(1).getMaxTemp());
            lowtemp=Double.parseDouble(jsonResult.get(1).getMinTemp());
            u10=Double.parseDouble(jsonResult.get(1).getWinSpeed())*0.278;
            airhumi=Double.parseDouble(jsonResult.get(1).getHumi());
            sunLong=getSunLong(jsonResult.get(1).getSunRise(), jsonResult.get(1).getSunSet());
            rainHour=Double.parseDouble(jsonResult.get(1).getWaterfall());
            
            double et0=WaterUtil.getET0(altitude, u10, latitude, hightemp, lowtemp, airhumi, sunLong, year, month, date);
            
            
            double uu2=u10 * 4.87 / Math.log(67.8 * 10 - 5.42);
            
            
            
            System.out.println("时间="+year+","+month+","+date+","+"海拔="+altitude+",纬度="+latitude+",最高气温="+hightemp+",最低气温="+lowtemp+",10米风速="+u10+",空气湿度="+airhumi+",日照长度="+sunLong+",et0="+et0+",u2="+uu2);
            
        	double Kc=judge(jsonResult.get(1).getDate().getMonth()+1,jsonResult.get(1).getDate().getDate(),kc1,kc2,kc3);
            W2=W1+WaterUtil.getP(rainHour)-Kc*et0;
           
            //double I = WaterUtil.irriauto(waterholdingCapacity, lower, wettingDepth, Ai);
            double I= Kc*et0;
            double II=WaterUtil.irriauto(waterholdingCapacity,lower , wettingDepth, Double.parseDouble(area.getIrrigationArea()));
			boolean status =false;
	     	      ForeShow f1= new ForeShow();
	  	          Date date1=new Date(jsonResult.get(1).getDate().getYear(),jsonResult.get(1).getDate().getMonth(),jsonResult.get(1).getDate().getDate());   	          
	  	          f1.setDate(date1);
	  	          f1.seteT0pre(et0);
	  	          f1.setkCpre(Kc);
	  	          f1.setIpre(I);
	  	          f1.setSoilHumipre(W2*0.1/wettingDepth*100);
	  	        
	     	   
            if((W2*0.1/wettingDepth*100)<lower)
			{
            	System.out.println("wowejwgkjseksg"+W2+",,,,,"+lower);
				System.out.println("基于天气预报需要灌水的日期是"+year+","+month+","+date+" 灌水量为"+II+"立方米");
				status=true;	
			} 
            foreShow.add(f1);	
   	       
 	         System.out.println("eto="+et0+",kc="+Kc+",I="+I+",WW="+W2*0.1/wettingDepth*100);
 	          
 	          double rainHour1,u101, hightemp1,lowtemp1, airhumi1,sunlong1,et01,Kc1,I1;
 	     	
 	          
 	        
 	          for(int i=2;i<7;i++){
 	     		rainHour1 =Double.parseDouble(jsonResult.get(i).getWaterfall());
 	     		u101=Double.parseDouble(jsonResult.get(i).getWinSpeed())*0.278;
 	     	    hightemp1=Double.parseDouble(jsonResult.get(i).getMaxTemp());
 	     		lowtemp1=Double.parseDouble(jsonResult.get(i).getMinTemp());
 	     	    airhumi1=Double.parseDouble(jsonResult.get(i).getHumi());
 	     	    sunlong1=getSunLong(jsonResult.get(i).getSunRise(), jsonResult.get(i).getSunSet());
 	     	    
 	     	  double uu22=u101 * 4.87 / Math.log(67.8 * 10 - 5.42);
 	     	    
 	     	    
 	     	//  System.out.println(W2+"W2.......................");
 	     	    
 	     	    year=jsonResult.get(i).getDate().getYear()+1900;
 				month=jsonResult.get(i).getDate().getMonth()+1;
 				date=jsonResult.get(i).getDate().getDate(); 
 				W1=W2;
 				
 			//	System.out.println(W1+"W1.......................");
 				
 				
 				et01=WaterUtil.getET0(altitude, u101, latitude, hightemp1, lowtemp1, airhumi1, sunlong1, year, month, date);
 				
 				
 				 System.out.println("u101="+u101+",hightemp1="+hightemp1+",lowtemp1="+lowtemp1+",airhumi1="+airhumi1+" ,sunlong1="+ sunlong1+" year="+ year+","
 	   	        		 +",month="+month+",date="+date+",altitude="+altitude+"latitude="+latitude+",eto="+et01+",u2="+uu22);
 				
 	            Kc1=judge(month,date,kc1,kc2,kc3);
 	            W2=W1+WaterUtil.getP(rainHour1)-Kc1*et01;
 	            
 	           // System.out.println("zenfskgkang;ka;kfgafgdkjfnkzj   W2="+W2+",W1="+W1+",ETa="+Kc1*et01);
 	           
 	            
 	            //System.out.println(soilHumi+"初始状态，，，，，，，，，，，，，，，，，，，，，，，，，，，");
 	            
 	            
 	            //I1 = WaterUtil.irriauto(waterholdingCapacity, lower, wettingDepth, Ai);
 	            I1= Kc1*et01;
 	          ForeShow f= new ForeShow();
 	          Date date2= new Date(year-1900,month-1,date);
  	          f.setDate(date2);
  	          f.seteT0pre(et01);
  	          f.setkCpre(Kc1);
  	          f.setIpre(I1);
  	          f.setSoilHumipre(W2*0.1/wettingDepth*100);
  	          double II1=WaterUtil.irriauto(waterholdingCapacity, lower, wettingDepth, Double.parseDouble(area.getIrrigationArea()));
  	        if((W2*0.1/wettingDepth*100)<lower&&!status)
				{
	            	String msg1="基于天气预报数据需要灌水的日期是："+year+","+month+","+date+" 灌水量为"+II1+"立方米";
					System.out.println("基于天气预报数据需要灌水的日期是："+year+","+month+","+date+" 灌水量为"+II1+"mm");
				    status=true;
				    
				}
  	          foreShow.add(f);
  	     //   System.out.println("rainHour1="+rainHour1+",u101="+u101+",hightemp1="+hightemp1+",lowtemp1="+lowtemp1+",airhumi1="+airhumi1+" ,sunlong1="+ sunlong1+",,, year="+ year+","
  	        	//	 +",month="+month+",date="+date+",altitude="+altitude+"latitude="+latitude);
  	       // System.out.println("eto="+et01+",kc="+Kc1+",I="+I1+",W1="+W1+",W2="+W2+",WW="+W2*0.1/wettingDepth*100);
 	     	}
 	     //	System.out.println(foreShow.size());
 	     //	System.out.println(foreShow.get(0).getDate().getMonth());
 	     	return foreShow;
		
	}
	
	
	
	
	
	//基于天气预报存储数据
	public static WeatherForecast saveForecaseData(List<WeatherData> jsonResult)
	{
		//double kc1=1;double kc2=1;double kc3=1;
		/*String cityId = "CN101121106";// 沾化代码https://api.heweather.com/v5/weather?city=CN101121106&key=472d172fe992436d888899870c1b7181

		String httpUrl = "https://free-api.heweather.com/v5/weather?city="
				+ cityId + "&key=472d172fe992436d888899870c1b7181";
		List<WeatherData> jsonResult = HttpForForecast.request(httpUrl);*/
		
		System.out.println(jsonResult);
		
		WeatherForecast weatherForecast = new WeatherForecast();
		AreaService areaService=TimerListener.applicationContext.getBean(AreaService.class);
		RegionService regionService=TimerListener.applicationContext.getBean(RegionService.class);
		double hightemp,lowtemp,u10,airhumi,sunLong,rainHour;
		int year = jsonResult.get(0).getDate().getYear() + 1900;
		int month = jsonResult.get(0).getDate().getMonth() + 1;
		int date = jsonResult.get(0).getDate().getDate();// 日期
		hightemp = Double.parseDouble(jsonResult.get(0).getMaxTemp());
		lowtemp = Double.parseDouble(jsonResult.get(0).getMinTemp());
		u10 = Double.parseDouble(jsonResult.get(0).getWinSpeed()) * 0.278;
		airhumi = Double.parseDouble(jsonResult.get(0).getHumi());
		sunLong = getSunLong(jsonResult.get(0).getSunRise(), jsonResult.get(0)
				.getSunSet());
		rainHour = Double.parseDouble(jsonResult.get(0).getWaterfall())*0.2;
		double uu2 = u10 * 4.87 / Math.log(67.8 * 10 - 5.42);
        String createTime = ""+year+"-"+month+"-"+date;
		weatherForecast.setAirHumi(""+airhumi);
		weatherForecast.setAirHighTemp(""+hightemp);
		weatherForecast.setAirLowTemp(""+lowtemp);
		weatherForecast.setCreateTime(createTime);
		weatherForecast.setRainHour(""+rainHour);
		weatherForecast.setRegion("沾化");
		weatherForecast.setSunLong(""+sunLong);
		weatherForecast.setWindSpeed(""+uu2);

		System.out.println("时间="+createTime+",最高气温="+hightemp+",最低气温="+lowtemp+",10米风速="+u10+",空气湿度="+airhumi+",日照长度="+sunLong+",u2="+uu2);
 	    return weatherForecast;
	}
	
	
	
	/*public static void main(String[] args) throws Exception {
		//基于实时气象数据预测预报
		getRealPredict(1);
		//基于天气预报预测
		getForecaseData(1);
		
	}*/
	//获取气象的日照时长
	  public static double getsunLong(List<String>  sunLong)
	    {
	    	int day=24;
	    	for(int i=0;i<24;i++)
			{
				if(sunLong.get(i).equals("0.00"))
				{
					day--;
				}
			}
	    	
	    	return day; 
	    }	    
	 //获取天气预报的日照时长 
	  public static double getSunLong(String sr,String ss)

		{
			
			int hourr;int minutee;int hourr2;int minutee2;
			String hour=sr.substring(0, 2);
			hourr=Integer.parseInt(hour);
			String minute = sr.substring(3,5);
			minutee=Integer.parseInt(minute);
			String hour2=ss.substring(0, 2);
			hourr2=Integer.parseInt(hour2);
			String minute2 =ss.substring(3,5);
			minutee2=Integer.parseInt(minute2);
			
			if(minutee2<minutee)
			{
				minutee2=minutee2+60;
				hourr2--;
			}
			double h=(hourr2-hourr)+(minutee2-minutee)/60.0;
			System.out.println(Integer.parseInt(hour));
			return h;
			
		}
	 //判断kc的取值 
	  public static double judge(int month,int day,double kc1,double kc2,double kc3)
		{
		  double kc=0;
			if(month==1){//末
				kc=kc3;
				}
			else if(month==2){//初
				kc=kc1;
				}
			else if(month==3&&day<=15){//初
				kc=kc1;
				}
			else if(month<10){//中
				kc=kc2;
				}
			else if(month==10&&day<=15){//中
				kc=kc2;
				}
			else if(month<=12){//末
				kc=kc3;
				}					
			return kc;
		}	  
}
