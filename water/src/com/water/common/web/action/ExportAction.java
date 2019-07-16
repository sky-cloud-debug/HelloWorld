package com.water.common.web.action;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.water.dao.PlotDao;
import com.water.dao.SoilDao;
import com.water.dao.SoilDao2;
import com.water.dao.WeatherDao;
import com.water.dao.WeatherDao2;
import com.water.dao.WeatherForecastDao;
import com.water.model.Soil;
import com.water.model.Soil2;
import com.water.model.Weather;
import com.water.model.Weather2;
import com.water.model.WeatherForecast;
import com.water.common.util.ExportExcelUtils;

@Controller("export")
@Scope("prototype")
public class ExportAction extends ActionSupport {
	private static final long serialVersionUID = 8810869485563486256L;
	// 注入
	@Resource
	private WeatherDao weatherDao;
	@Resource
	private WeatherForecastDao weatherForecastDao;
	@Resource
	private WeatherDao2 weatherDao2;
	
	@Resource
	private SoilDao2 soilDao2;
	@Resource
	private SoilDao soilDao;
	@Resource
	private PlotDao plotDao;
    private String status;
	/**
	 * 导出天气
	 * @throws IOException 
	 */
    
	public String login() throws IOException
	{
		if(BaseAction.getCurrentUser()==null){
			BaseAction.getWriter().write("fail");
			ServletActionContext.getRequest().getSession().setAttribute("status", status);
		   System.out.println(status);
			return "fail";
		} else {
			//BaseAction.getWriter().write("success");
			return "success";
		}
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDir(double windDir)
	{
		String windD;
		if ( windDir == 2.00)
		{
			windD = "故障码";
		}
		else if (windDir > 2.00 && windDir < 5.00)
		{
			windD = "北";
		}
		else if (windDir >= 5.00 && windDir < 6.00)
		{
			windD = "东北偏北";
		}
		else if (windDir >= 6.00 && windDir < 7.00)
		{
			windD = "东北";
		}
		else if (windDir >= 7.00 && windDir < 8.00)
		{
			windD = "东北偏东";
		}
		else if (windDir >= 8.00 && windDir < 9.00)
		{
			windD = "东";
		}
		else if (windDir >= 9.00 && windDir < 10.00)
		{
			windD = "东南偏东";
		}
		else if (windDir >= 10.00 && windDir < 11.00)
		{
			windD = "东南";
		}
		else if (windDir >= 11.00 && windDir < 12.00)
		{
			windD = "东南偏南";
		}
		else if (windDir >= 12.00 && windDir < 13.00)
		{
			windD = "南";
		}
		else if (windDir >= 13.00 && windDir < 14.00)
		{
			windD = "西南偏南";
		}
		else if (windDir >= 14.00 && windDir < 15.00)
		{
			windD = "西南";
		}
		else if (windDir >= 15.00 && windDir < 16.00)
		{
			windD = "西南偏西";
		}
		else if (windDir >= 16.00 && windDir < 17.00)
		{
			windD = "西";
		}
		else if (windDir >= 17.00 && windDir < 18.00)
		{
			windD = "西北偏西";
		}
		else if (windDir >= 18.00 && windDir < 19.00)
		{
			windD = "西北";
		}
		else if (windDir >= 19.00 && windDir < 20.00)
		{
			windD = "西北偏北";
		}
		else
		{
			windD = "西北偏北";
		}

		return windD;
	}
	public void exportWeather() {
		if(status.equals("exportWeather")){
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("octets/stream");
			response.addHeader("Content-Disposition",
					"attachment;filename=export.xls");
			OutputStream out = response.getOutputStream();
			List<LinkedHashMap<String, Object>> result = new ArrayList<LinkedHashMap<String, Object>>();
			List<Weather> weathers = weatherDao.getAllWeather();    
			for (Weather weather : weathers) {
				LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>();
				map.put("air_humi", weather.getAirHumi());
				map.put("air_temp", weather.getAirTemp());
				map.put("co2", weather.getCo2());
				map.put("creat_time", weather.getCreateTime());
				map.put("sun_data", weather.getSunData());
				map.put("win_dir", getDir(Double.parseDouble(weather.getWindDir())/65536*20)/*weather.getWindDir()*/);
				map.put("win_speed", weather.getWindSpeed());
//				map.put("region", weather.getRegion().getCity());
				map.put("rain_hour", Double.parseDouble(weather.getRainHour())*0.2);
				map.put("plot_name",weather.getPlotIdd());
				result.add(map);
			}
			String[] headers = { "空气湿度", "空气温度", "co2浓度", "创建时间", "光照强度", "风向",
					"风速" ,"降雨量","沾化站点号"};

			String[] columns = { "air_humi", "air_temp", "co2", "creat_time",
					"sun_data", "win_dir", "win_speed","rain_hour","plot_name"};
			ExportExcelUtils.exportExcel("天气情况导出表", headers, columns, result,
					out, "");
			out.close();
		} catch (Exception e) {
		}}
		else{
			try {
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setContentType("octets/stream");
				response.addHeader("Content-Disposition",
						"attachment;filename=export.xls");
				OutputStream out = response.getOutputStream();
				List<LinkedHashMap<String, Object>> result = new ArrayList<LinkedHashMap<String, Object>>();
				List<Weather2> weathers = weatherDao2.getAllWeather();    
				for (Weather2 weather : weathers) {
					LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>();
					map.put("air_humi", weather.getAirHumi());
					map.put("air_temp", weather.getAirTemp());
					map.put("co2", weather.getCo2());
					map.put("creat_time", weather.getCreateTime());
					map.put("sun_data", weather.getSunData());
					map.put("win_speed", weather.getWindSpeed());
					map.put("rain_hour", Double.parseDouble(weather.getRainHour()));
					result.add(map);
				}
				String[] headers = { "空气湿度", "空气温度", "co2浓度", "创建时间", "光照强度", 
						"风速" ,"降雨量"};
				

				String[] columns = { "air_humi", "air_temp", "co2", "creat_time",
						"sun_data",  "win_speed","rain_hour"};
				ExportExcelUtils.exportExcel("天气情况导出表", headers, columns, result,
						out, "");
				out.close();
			} catch (Exception e) {
			}	
		}
	}

	/**
	 * 导出土壤数据
	 */
	public void exportSoil() {
		if(status.equals("exportSoil")){
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("octets/stream");
			response.addHeader("Content-Disposition",
					"attachment;filename=export.xls");
			OutputStream out = response.getOutputStream();
			List<LinkedHashMap<String, Object>> result = new ArrayList<LinkedHashMap<String, Object>>();
			List<Soil> soils = soilDao.getAllSoilList();
			for (Soil soil : soils) {
				LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>();
				map.put("creat_time", soil.getCreateTime());
				map.put("soil_humi", soil.getSoilTemp());
				map.put("soil_temp", soil.getSoilHumi());
				map.put("plot_name", soil.getPlotIdd());
				result.add(map);
			}
			String[] headers = { "创建时间","土壤湿度", "土壤温度","沾化站点号" };

			String[] columns = { "creat_time","soil_temp", "soil_humi","plot_name" };
			ExportExcelUtils.exportExcel("土壤墒情信息导出表", headers, columns, result,
					out, "");
			out.close();
		} catch (Exception e) {

		}
	}
	else{
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("octets/stream");
			response.addHeader("Content-Disposition",
					"attachment;filename=export.xls");
			OutputStream out = response.getOutputStream();
			List<LinkedHashMap<String, Object>> result = new ArrayList<LinkedHashMap<String, Object>>();
			List<Soil2> soils = soilDao2.getAllSoilList();
			for (Soil2 soil : soils) {
				LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>();
				map.put("creat_time", soil.getCreateTime());
				map.put("soil_humi", soil.getSoilHumi());
				map.put("soil_humii", soil.getSoilHumi2());
				map.put("soil_humiii", soil.getSoilHumi3());
				map.put("soil_temp", soil.getSoilTemp());
				map.put("soil_elect", soil.getElect());
				map.put("soil_ph", soil.getPh());
				result.add(map);
			}
			String[] headers = { "创建时间","土壤湿度1","土壤湿度2","土壤湿度3", "土壤温度","土壤电导率","土壤PH值"};

			String[] columns = { "creat_time", "soil_humi","soil_humii","soil_humiii","soil_temp","soil_elect","soil_ph"};
			ExportExcelUtils.exportExcel("土壤墒情信息导出表", headers, columns, result,
					out, "");
			out.close();
		} catch (Exception e) {

		}}
	}
	
	public void exportForecastWeather(){
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("octets/stream");
			response.addHeader("Content-Disposition",
					"attachment;filename=exportForecastWeather.xls");
			OutputStream out = response.getOutputStream();
			List<LinkedHashMap<String, Object>> result = new ArrayList<LinkedHashMap<String, Object>>();
			List<WeatherForecast> weatherForecasts = weatherForecastDao.findListByHql("from WeatherForecast");    
			for (WeatherForecast weatherForecast : weatherForecasts) {
				LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>();
				map.put("air_humi", weatherForecast.getAirHumi());
				map.put("air_high_temp", weatherForecast.getAirHighTemp());
				map.put("air_low_temp", weatherForecast.getAirLowTemp());
				map.put("creat_time", weatherForecast.getCreateTime());
				map.put("sun_data", weatherForecast.getSunLong());
				map.put("win_speed", weatherForecast.getWindSpeed());
				map.put("region", weatherForecast.getRegion());
				map.put("rain_hour", Double.parseDouble(weatherForecast.getRainHour()));
				result.add(map);
			}
			String[] headers = { "空气湿度", "最高温度", "最低温度", "日照时长", "创建时间",
					"风速" ,"降雨量","地点"};

			String[] columns = { "air_humi", "air_high_temp","air_low_temp", "sun_data", "creat_time",
					 "win_speed","rain_hour","region"};
			ExportExcelUtils.exportExcel("天气预报情况导出表", headers, columns, result,
					out, "");
			out.close();
		} catch (Exception e) {
		}}

	
	
}
