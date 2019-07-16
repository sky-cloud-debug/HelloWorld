package com.water.web.action;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.catalina.connector.Request;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.water.common.bean.Page;
import com.water.model.Area;
import com.water.model.Region;
import com.water.util.ForeShow;
import com.water.util.HttpForForecast;
import com.water.util.WeatherData;

@Controller
@Scope("prototype")
public class RegionAction extends MyBaseAction<Region> {
	private String status;
	private String msg;
	private String msg1;
	private List<ForeShow> foreShow;
	private List<ForeShow> forecast_list;
	private double lower;
	private int areaId;
    private int regionId;
    private String waterList;
    public String getWaterList() {
		return waterList;
	}
    public void setWaterList(String waterList) {
		this.waterList = waterList;
	}
	public List<ForeShow> getForeShow() {
		return foreShow;
	}
	public void setForeShow(List<ForeShow> foreShow) {
		this.foreShow = foreShow;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getRegionId() {
		return regionId;
	}
	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}
	public String login() throws IOException
	{
		if(getCurrentUser()==null){
			getWriter().write("fail");
			ServletActionContext.getRequest().getSession().setAttribute("status", status);
			return "fail";
		} else {
			getWriter().write("success");
			return "success";
		}
	}
	public String select()
	{
		System.out.println(regionId);
		model=regionService.findOneById(regionId);
		ServletActionContext.getRequest().getSession().setAttribute("regionUpdateId",model.getId());
		return SUCCESS;
	}
	public void regionUpdate2() throws IOException
	{
		int idd = (Integer) ServletActionContext.getRequest().getSession().getAttribute("regionUpdateId");
		Region model1 = regionService.findOneById(idd);
		model1.setAltitude(model.getAltitude());
		model1.setCity(model.getCity());
		model1.setLatitude(model.getLatitude());
		model1.setLongitude(model.getLongitude());
		model1.setRegionName(model.getRegionName());
		model1.setTown(model.getTown());
		regionService.update(model1);
		getWriter().write("success");
	}
	public String list() {
		Page<Region> page = new Page<Region>();
		page.setPageNo(1);
		page.setPageSize(50);
		service.findByPage(page);
		ServletActionContext.getRequest().setAttribute("page", page);
		return SUCCESS;
	}
	public void delete() throws IOException {
		model= regionService.findOneById(regionId);
		regionService.delete(regionId);
		getWriter().write("success");
		}
	public String addui() {
		return SUCCESS;
	}

	public void regionAdd() throws IOException {
		regionService.save(model);
		getWriter().write("success");
	}

	public double getLower() {
		return lower;
	}

	public void setLower(double lower) {
		this.lower = lower;
	}

	public String getMsg1() {
		return msg1;
	}

	public void setMsg1(String msg1) {
		this.msg1 = msg1;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public List<ForeShow> getForecast_list() {
		return forecast_list;
	}

	public void setForecast_list(List<ForeShow> forecast_list) {
		this.forecast_list = forecast_list;
	}

	public int getAreaId() {
		return areaId;
	}

	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}
	
	


	public String city() {
		return SUCCESS;
	}

	public String plot() {
		return SUCCESS;
	}
	
	public String queryForecast() throws Exception {
		System.out.println("进来了============");
		String[] waterList = getRequest().getParameterValues("waterList");
		System.out.println(waterList);
       
		
		
		
		
		
		
		JSONArray js = (JSONArray.fromObject(waterList)).getJSONArray(0);
        
      
        List<WeatherData> weatherDatas = new ArrayList<WeatherData>();
       for(int i=0;i<js.size();i++){
    	   JSONObject j = js.getJSONObject(i);
    	   String sunRise = j.getString("sr");
    	   String sunSet= j.getString("ss");
    	   String minTemp=j.getString("min");
    	   String maxTemp=j.getString("max");
    	   String winSpeed = j.getString("spd");
    	   String humi=j.getString("hum");
    	   String date = j.getString("date");
    	   String waterfall=j.getString("pcpn");
    	   WeatherData weatherData = new WeatherData();
    	   weatherData.setSunRise(sunRise);
    	   weatherData.setMaxTemp(maxTemp);
    	   weatherData.setHumi(humi);
    	   weatherData.setSunSet(sunSet);
    	   weatherData.setMinTemp(minTemp);
    	   weatherData.setWaterfall(waterfall);
    	   weatherData.setWinSpeed(winSpeed);
    	   DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
   		   Date d = df.parse(date);
    	   weatherData.setDate(d);
    	   weatherDatas.add(weatherData);
    	   System.out.println(weatherData);
       }
	   
	   
		forecast_list = HttpForForecast.getForecaseData(areaId,weatherDatas);
		
		for (int i = 0; i < 6; i++) {

			System.out.println(forecast_list.get(i).geteT0pre()+","+forecast_list.get(i).getkCpre()+","+forecast_list.get(i).getIpre()
					+","+forecast_list.get(i).getSoilHumipre());
		}
		
		Area area = areaService.findListByRegionIdAndPage(1, 10, 1)
				.getContent().get(areaId);
		Region region = regionService.findOneById(area.getRegion().getId());
		lower = Double.parseDouble(area.getIrrigationLowerLimit());// 灌水量下限
		
		boolean irri = false;
		if (HttpForForecast.statuss == false) {
			irri = true;
			msg1 = "目前已达灌溉下限值，请灌溉";
		} else {
			for (int i = 0; i < 6; i++) {

				if (forecast_list.get(i).getSoilHumipre() < lower) {
					double irri_num = 6.67* (Double.parseDouble(area.getAverageWaterCapacity()) * 0.01 - Double.parseDouble(area.getIrrigationLowerLimit()) * 0.01)* Double.parseDouble(area.getFirstStageDepthOfWetting())* Double.parseDouble(area.getIrrigationArea());
					int year = forecast_list.get(i).getDate().getYear() + 1900;
					int month = forecast_list.get(i).getDate().getMonth() + 1;
					int date3 = forecast_list.get(i).getDate().getDate();
					msg1 = "基于天气预报需要灌水的日期是" + year + "年" + month + "月" + date3
							+ "日，灌水量为" + irri_num + "立方米";
					irri = true;
					break;
				}
			}
		}
		if (!irri) {
			msg1 = "未来 6  天不需要灌溉";
		}
		return "forecast_list";
	}
//基于实测数据进行预测ET0
	public String queryRealForecast() {
		//msg = HttpForForecast.getRealPredict(areaId);
		ForeShow test=new ForeShow();
		test=HttpForForecast.getRealPredict(areaId);
		test.getDate().setYear(test.getDate().getYear()-1900);
		test.getDate().setMonth(test.getDate().getMonth()-1);
		test.getDate().setDate(test.getDate().getDate());
		foreShow=new ArrayList<ForeShow>();
		foreShow.add(test);
		msg=HttpForForecast.message;
		return "msg";
	}

	public String realForecast() {
		return SUCCESS;

	}

	public String forecast() {
		return SUCCESS;
	}

}
