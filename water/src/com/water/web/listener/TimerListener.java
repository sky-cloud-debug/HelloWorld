package com.water.web.listener;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.water.common.bean.Page;
import com.water.model.Area;
import com.water.model.MessageRecord;
import com.water.model.Soil2;
import com.water.model.Weather2;
import com.water.service.AreaService;
import com.water.service.CountyService;
import com.water.service.MessageRecordService;
import com.water.service.PlotService;
import com.water.service.RegionService;
import com.water.service.SoilService;
import com.water.service.SoilService2;
import com.water.service.WaterRecordService;
import com.water.service.WeatherService2;
import com.water.util.Config;
import com.water.util.GetDataSource;
import com.water.util.HttpUtil;

import com.water.util.WaterUtil;

public class TimerListener implements ServletContextListener{
	private static String accountSid = Config.ACCOUNT_SID;

	private static String to = "17605435329,17605435360";

	/*17605435329,17605435360*/
	
		//System.out.println("result:" + System.lineSeparator() + result);
	
	
	
	protected static final double P = 0;
	protected static final double ET0 = 0;
	protected static final double Kc = 0;
	public static ApplicationContext applicationContext;
	
	List<Area> areaList;
	public  static ServletContext servletContext;
	private SoilService soilService;
	private AreaService areaService;
	private MessageRecordService messageRecordService;
	private WaterRecordService waterRecordService;
	private SoilService2 soilService2;
	private WeatherService2 weatherService2;
	private RegionService regionService;
	private PlotService plotService;
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		servletContext = event.getServletContext();
		applicationContext=WebApplicationContextUtils.getWebApplicationContext(servletContext);
		areaService=applicationContext.getBean(AreaService.class);
		soilService=applicationContext.getBean(SoilService.class);
		messageRecordService=applicationContext.getBean(MessageRecordService.class);
		waterRecordService=applicationContext.getBean(WaterRecordService.class);
		soilService2 = applicationContext.getBean(SoilService2.class);
		weatherService2 = applicationContext.getBean(WeatherService2.class);
		regionService = applicationContext.getBean(RegionService.class);
		plotService = applicationContext.getBean(PlotService.class);
		Timer timer=new Timer();
			timer.schedule(new TimerTask() {
				
				@Override 
				public void run() {
//					if(土壤湿度<灌水下限){
//						计算灌水量
//					         发短信
//					}
					
					areaList = areaService.findListByRegionIdAndPage(1,100,1).getContent();
					System.out.println("================");
					Area area = areaList.get(0);
					double soilHumi=getAverageSoilHumi();
					double irrigationLowerLimit=Double.parseDouble(area.getIrrigationLowerLimit());
					System.out.println("土壤湿度为："+soilHumi+"，灌水下限："+irrigationLowerLimit);
					String message="";
					if(soilHumi<irrigationLowerLimit){
						
						
						
						Page<Area> page=new Page<Area>();
						page.setPageNo(1);
						page.setPageSize(100);
						List<Area> areaList = areaService.findByPage(page).getContent();
						for (Area areaa : areaList) {
//							WaterUtil.irriauto(waterholdingCapacity, soilHumi, Hi, Ai);
							Integer outletNumber=areaa.getOutletNumber();
							String irrigationArea=areaa.getIrrigationArea();
							
							double waterNum=WaterUtil.irriauto(Double.parseDouble(areaa.getWaterholdingCapacity()),Double.parseDouble(areaa.getIrrigationLowerLimit()),Double.parseDouble(areaa.getFirstStageDepthOfWetting()),Double.parseDouble(areaa.getIrrigationArea()));
							 message += "出水口"+outletNumber+"号，灌溉面积："+irrigationArea+"亩，需灌溉量："+waterNum+"立方米。";
						}
						
						String url = Config.BASE_URL;
						String body = "accountSid=" + accountSid
						+ "&smsContent=【水肥一体化节水灌溉】"+ message+"。设置灌溉量，请登录http://202.194.131.174:8080/water/water/login2?status=autoControl&to=" + to
						+ HttpUtil.createCommonParam();

						// 提交请求
						
						
						 message+="设置灌溉量，请登录http://202.194.131.174:8080/water/water/login2?status=autoControl";

					if(HttpUtil.sendMessage(url,body)){
						System.out.println("I'm comming");
						messageRecordService.save(new MessageRecord(message,new Date()));}
					}else{System.out.println("What's up");}
					List<Object> oo = new ArrayList<Object>();
				    oo = GetDataSource.getWeatherAndSoil();
				    if(oo!=null){
					Soil2 s2 = new Soil2();
					
					//	Plot cxiawa = plotService.findOneById(1);
					//  System.out.println(cxiawa);
					s2 = (Soil2) oo.get(0);
					s2.setPlotId("1");
					Weather2 w2 = new Weather2();
					w2 = (Weather2) oo.get(1);
				//	w2.setPlotId(cxiawa.getPlotId());
					w2.setPlotId("1");
					weatherService2.save(w2);
					soilService2.save(s2);}
					
				}
			}, 0,3600000);
			System.out.println("定时器启动成功！");
	}
	
	public double getAverageSoilHumi() {
		return soilService.getLastDayAverageSoilHumi(1);
	}
	
}
