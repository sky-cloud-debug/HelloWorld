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

public class TimerListenerSpare implements ServletContextListener{

	public static ApplicationContext applicationContext;
	
	public  static ServletContext servletContext;
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
		soilService2 = applicationContext.getBean(SoilService2.class);
		weatherService2 = applicationContext.getBean(WeatherService2.class);
		regionService = applicationContext.getBean(RegionService.class);
		plotService = applicationContext.getBean(PlotService.class);
		Timer timer=new Timer();
			timer.schedule(new TimerTask() {
				
				@Override 
				public void run() {

					/*List<Object> oo = new ArrayList<Object>();
					Long plotCount = plotService.getTotalCount();
					int pC = Integer.parseInt(plotCount+"");
					Page <Plot>plotPage = new Page<Plot>();
					plotPage.setPageNo(1);
					plotPage.setPageSize(pC);
					Page<Plot> plotResult = plotService.findByPage(plotPage);
					List<Plot> plotResult2 = new ArrayList<Plot>();
					for(int i = 0; i < pC; i++){
						if(plotResult.getContent().get(i).getPlotId()!=null){
							plotResult2.add(plotResult.getContent().get(i));
							
						}
					}
					oo = GetDataSource.getManyWeatherAndSoil(plotResult2);
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
					
				}*/}
			}, 0,3600000);
			System.out.println("定时器启动成功！");
	}
	
}
