package com.water.web.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.JSONUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.water.common.bean.Page;
import com.water.dao.MyBaseDaoImpl;
import com.water.model.Area;
import com.water.model.Crop;
import com.water.model.Region;
import com.water.model.Soil;
import com.water.model.Soil2;
import com.water.model.SoilCollectStatisticsModel;
import com.water.model.SoilCollectStatisticsModel2;
import com.water.model.Weather;
import com.water.model.Weather2;
import com.water.model.WeatherCollectStatisticsModel;
import com.water.model.WeatherCollectStatisticsModel2;

@Controller
@Scope("prototype")
public class RegionDetailAction extends MyBaseAction<Region> {
	private String status;
	private Crop modle;
	Page<Area> areaPage;
	Page<Weather> weatherPage;
	Page<Weather2> weatherPage2;
	Page<Soil> soilPage;
	Page<Soil2> soilPage2;
	private Integer regionId;
	private Integer countyId;
	private Integer areaId;
	private Integer plotId;
	private Integer pageNo;
	private Integer pageSize;
	private Page<Crop> cropPage;
	Boolean isDay = true;
	String startTimeStr;
	String endTimeStr;
	private Integer plotIdName;
	public Integer getPlotIdName() {
		return plotIdName;
	}
	public void setPlotIdName(Integer plotIdName) {
		this.plotIdName = plotIdName;
	}
	private MyBaseDaoImpl<Soil> dao;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String login3() throws IOException {
		if (getCurrentUser() == null) {
			getWriter().write("fail");
			ServletActionContext.getRequest().getSession()
					.setAttribute("status", status);
			return "fail";
		} else {
			return SUCCESS;
		}
	}

	public String getPicture() {
		return SUCCESS;
	}

	public String soilListPre() {
		return SUCCESS;
	}
	public void updateCrop() throws IOException {
		modle = (Crop) ServletActionContext.getRequest().getSession()
				.getAttribute("cropEdit");
		getWriter().write("success");
	}

	public Crop getModle() {
		return modle;
	}

	public void setModle(Crop modle) {
		this.modle = modle;
	}

	public String show() {
		areaPage = areaService.findListByRegionIdAndPage(1, 10, regionId);
		weatherPage = weatherService.findListByRegionIdAndPage(1, 10, regionId);
		soilPage = soilService.findListByRegionIdAndPage(1, 10, regionId);
		return SUCCESS;
	}

	public String cropUpload() {
		return SUCCESS;
	}

	public void cropUpload2() throws IOException {
		Crop crop = new Crop();
		Area area = areaService.findOneById(areaId);
		crop.setArea(area);
		crop.setCanopyTemperature(modle.getCanopyTemperature());
		crop.setCreateTime(new Date());
		crop.setPhysiologicalAndBiochemicalIndexes(modle
				.getPhysiologicalAndBiochemicalIndexes());
		crop.setQuality(modle.getQuality());
		cropService.save(crop);

		System.out.println(crop.getCanopyTemperature() + ","
				+ crop.getPhysiologicalAndBiochemicalIndexes() + ","
				+ crop.getQuality() + "," + crop.getSoilMoistureContent()
				+ "hhhhhhhhh");

		ServletActionContext.getRequest().getSession()
				.setAttribute("cropEdit", crop);
		getWriter().write("success");
	}

	public String areaList() {
		regionId = 1;
		areaPage = areaService.findListByRegionIdAndPage(1, 10, regionId);
		return SUCCESS;
	}

	public String getDir(double windDir) {
		String windD;
		if (windDir == 2.00) {
			windD = "故障码";
		} else if (windDir > 2.00 && windDir < 5.00) {
			windD = "北";
		} else if (windDir >= 5.00 && windDir < 6.00) {
			windD = "东北偏北";
		} else if (windDir >= 6.00 && windDir < 7.00) {
			windD = "东北";
		} else if (windDir >= 7.00 && windDir < 8.00) {
			windD = "东北偏东";
		} else if (windDir >= 8.00 && windDir < 9.00) {
			windD = "东";
		} else if (windDir >= 9.00 && windDir < 10.00) {
			windD = "东南偏东";
		} else if (windDir >= 10.00 && windDir < 11.00) {
			windD = "东南";
		} else if (windDir >= 11.00 && windDir < 12.00) {
			windD = "东南偏南";
		} else if (windDir >= 12.00 && windDir < 13.00) {
			windD = "南";
		} else if (windDir >= 13.00 && windDir < 14.00) {
			windD = "西南偏南";
		} else if (windDir >= 14.00 && windDir < 15.00) {
			windD = "西南";
		} else if (windDir >= 15.00 && windDir < 16.00) {
			windD = "西南偏西";
		} else if (windDir >= 16.00 && windDir < 17.00) {
			windD = "西";
		} else if (windDir >= 17.00 && windDir < 18.00) {
			windD = "西北偏西";
		} else if (windDir >= 18.00 && windDir < 19.00) {
			windD = "西北";
		} else if (windDir >= 19.00 && windDir < 20.00) {
			windD = "西北偏北";
		} else {
			windD = "西北偏北";
		}

		return windD;
	}

	public String weatherList() {
		// 修改了
		String plotName="";
		weatherPage = weatherService.findListByPlotName(1, 10, plotName);
		Page<Weather> weatherPage1 = new Page<Weather>();
		weatherPage1 = weatherService
				.findListByPlotName(1, 11, plotName);
		for (int i = 0; i < 10; i++) {
			weatherPage
					.getContent()
					.get(i)
					.setRainHour(
							Double.parseDouble(weatherPage.getContent().get(i)
									.getRainHour())
									- Double.parseDouble(weatherPage1
											.getContent().get(i + 1)
											.getRainHour()) + "");
		}

		for (long i = 0; i < 10; i++) {
			double windDir = Double.parseDouble(weatherPage.getContent()
					.get(Integer.parseInt(i + "")).getWindDir()) / 65536 * 20;
			String windD = getDir(windDir);
			weatherPage.getContent().get(Integer.parseInt(i + ""))
					.setWindDir(windD);
		}

		return SUCCESS;
	}
	public String weatherList2() {
		// 修改了
		weatherPage2 = weatherService2.findListByPlotIdAndPage(1, 10, plotId);
		Page<Weather2> weatherPage1 = new Page<Weather2>();
		/*weatherPage1 = weatherService2
				.findListByCountyIdAndPage(1, 11, countyId);*/
		/*if(weatherPage2.getTotalItems()>0){
		for (int i = 0; i < 10; i++) {
			weatherPage2
					.getContent()
					.get(i)
					.setRainHour(
							Double.parseDouble(weatherPage2.getContent().get(i)
									.getRainHour())
									- Double.parseDouble(weatherPage1
											.getContent().get(i + 1)
											.getRainHour()) + "");
		}
		}*/
		/*for (long i = 0; i < 10; i++) {
			double windDir = Double.parseDouble(weatherPage.getContent()
					.get(Integer.parseInt(i + "")).getWindDir()) / 65536 * 20;
			String windD = getDir(windDir);
			weatherPage.getContent().get(Integer.parseInt(i + ""))
					.setWindDir(windD);
		}*/

		return SUCCESS;
	}

	public String soilList() throws IOException {
		System.out.println(plotIdName+"==================");
		String plotName="";
		if(plotIdName==2){
			System.out.println("001");
			plotName="001";}
			else{plotName="002";
			System.out.println("002");
			}
		
		
		soilPage = soilService.findListByPlotName(1, 10, plotName);
		List<Soil> soilLt = soilPage.getContent();
		for (int i = 0; i < soilLt.size(); i++) {
			soilLt.get(i).setId(i + 1);
		}
		soilPage.setContent(soilLt);
		getWriter().write("success");
		return SUCCESS;
	}
	
	public String soilList2() throws IOException {
		soilPage2 = soilService2.findListByPlotIdAndPage(1, 10, plotId);
		List<Soil2> soilLt = soilPage2.getContent();
		for (int i = 0; i < soilLt.size(); i++) {
			soilLt.get(i).setId(i + 1);
		}
		soilPage2.setContent(soilLt);
		getWriter().write("success");
		return SUCCESS;
	}

	public String cropList() throws IOException {
		try {
			cropPage = cropService.findCropListByAreaIdAndPage(1, 10, areaId);
		} catch (Exception e) {
			getWriter().write("fail");
		}
		return SUCCESS;
	}

	public String areaListByPage() throws Exception {
		Page<Area> page = areaService.findListByRegionIdAndPage(pageNo,
				pageSize, regionId);
		ServletActionContext.getRequest().setAttribute("page", page);
		return SUCCESS;
	}

	public String cropListByPage() throws Exception {
		Page<Crop> page = cropService.findCropListByAreaIdAndPage(pageNo,
				pageSize, areaId);
		ServletActionContext.getRequest().setAttribute("page", page);
		return SUCCESS;
	}

	public String weatherList2ByPage() throws Exception {
		Page<Weather2> page = weatherService2.findListByPlotIdAndPage(pageNo,
				pageSize, plotId);
/*		if (pageNo < page.getTotalPages()) {
			Page<Weather2> page1 = weatherService2.findListByCountyIdAndPage(
					pageNo + 1, pageSize, countyId);
			for (int i = 0; i < page.getContent().size(); i++) {
				if (i != page.getContent().size() - 1) {
					page.getContent()
							.get(i)
							.setRainHour(
									Double.parseDouble(page.getContent().get(i)
											.getRainHour())
											- Double.parseDouble(page
													.getContent().get(i + 1)
													.getRainHour()) + "");

				} else {
					page.getContent()
							.get(i)
							.setRainHour(
									Double.parseDouble(page.getContent().get(i)
											.getRainHour())
											- Double.parseDouble(page1
													.getContent().get(0)
													.getRainHour()) + "");
				}
			}
		} else {
			for (int i = 0; i < page.getContent().size(); i++) {
				if (i != page.getContent().size() - 1) {
					page.getContent()
							.get(i)
							.setRainHour(
									Double.parseDouble(page.getContent().get(i)
											.getRainHour())
											- Double.parseDouble(page
													.getContent().get(i + 1)
													.getRainHour()) + "");

				} else {
					page.getContent().get(i).setRainHour(0 + "");
				}
			}
	
		}*/
/*
		for (int i = 0; i < page.getContent().size(); i++) {
			double windDir = Double.parseDouble(page.getContent().get(i)
					.getWindDir()) / 65536 * 20;
			String windD = getDir(windDir);
			page.getContent().get(i).setWindDir(windD);
		}*/
		ServletActionContext.getRequest().setAttribute("page", page);
		return SUCCESS;
	}

	
	public String weatherListByPage() throws Exception {
		Page<Weather> page = weatherService.findListByPlotName(pageNo, pageSize, "");
		if (pageNo < page.getTotalPages()) {
			Page<Weather> page1 = weatherService.findListByPlotName(pageNo+1, pageSize, "");
			for (int i = 0; i < page.getContent().size(); i++) {
				if (i != page.getContent().size() - 1) {
					page.getContent()
							.get(i)
							.setRainHour(
									Double.parseDouble(page.getContent().get(i)
											.getRainHour())
											- Double.parseDouble(page
													.getContent().get(i + 1)
													.getRainHour()) + "");

				} else {
					page.getContent()
							.get(i)
							.setRainHour(
									Double.parseDouble(page.getContent().get(i)
											.getRainHour())
											- Double.parseDouble(page1
													.getContent().get(0)
													.getRainHour()) + "");
				}
			}
		} else {
			for (int i = 0; i < page.getContent().size(); i++) {
				if (i != page.getContent().size() - 1) {
					page.getContent()
							.get(i)
							.setRainHour(
									Double.parseDouble(page.getContent().get(i)
											.getRainHour())
											- Double.parseDouble(page
													.getContent().get(i + 1)
													.getRainHour()) + "");

				} else {
					page.getContent().get(i).setRainHour(0 + "");
				}
			}

		}

		for (int i = 0; i < page.getContent().size(); i++) {
			double windDir = Double.parseDouble(page.getContent().get(i)
					.getWindDir()) / 65536 * 20;
			String windD = getDir(windDir);
			page.getContent().get(i).setWindDir(windD);
		}
		ServletActionContext.getRequest().setAttribute("page", page);
		return SUCCESS;
	}

	
	
	
	// 修改过
	public String soilListByPage() throws Exception {

		String plotName="";
		if(plotIdName==2){
		plotName="001";}
		else{plotName="002";
		}
		Page<Soil> page = soilService.findListByPlotName(pageNo,
				pageSize, plotName);

		/*
		 * MyBaseDaoImpl<Soil> dao = new MyBaseDaoImpl<Soil>(); Page<Soil>
		 * pgSoil = new Page<Soil>(); pgSoil =
		 * dao.findListByRegionIdAndPage(pgSoil, regionId); Long total =
		 * pgSoil.getTotalItems(); List<Soil> q=page.getContent();
		 *  for(int
		 * i=0;i<q.size();i++) { q.get(i).setId((int)(total-q.get(i).getId()));
		 * }
		 */

		ServletActionContext.getRequest().setAttribute("page", page);
		return SUCCESS;
	}
   
	
	public  Date soil2Newest(int plotId){

		Page<Soil2> page = soilService2.findListByPlotIdAndPageAsc(1,
				1, plotId);
		return page.getContent().get(0).getCreateTime();
	}
	public Date weather2Newest(int plotId){
		Page<Weather2> page = weatherService2.findListByPlotIdAndPageAsc(1,
				1, plotId);
		return page.getContent().get(0).getCreateTime();
	}
	
	public String soilList2ByPage() throws Exception {

		System.out.println(plotId + "hghg");
		Page<Soil2> page = soilService2.findListByPlotIdAndPage(pageNo,
				pageSize, plotId);

		/*
		 * MyBaseDaoImpl<Soil> dao = new MyBaseDaoImpl<Soil>(); Page<Soil>
		 * pgSoil = new Page<Soil>(); pgSoil =
		 * dao.findListByRegionIdAndPage(pgSoil, regionId); Long total =
		 * pgSoil.getTotalItems(); List<Soil> q=page.getContent(); for(int
		 * i=0;i<q.size();i++) { q.get(i).setId((int)(total-q.get(i).getId()));
		 * }
		 */

		ServletActionContext.getRequest().setAttribute("page", page);
		return SUCCESS;
	}

	public String weatherStatistic() {
		return SUCCESS;
	}
	public String weatherStatistic2() {
		return SUCCESS;
	}

	public String soilStatistic() {
		return SUCCESS;
	}
	public String soilStatistic2() {
		return SUCCESS;
	}

	public String cropStatistic() {
		return SUCCESS;
	}

	public void weatherStatisticData() throws Exception {
		Date startTime = new SimpleDateFormat("yyyy-MM-dd").parse("2016-05-01");
		Date endTime = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if (startTimeStr != null) {
			startTime = sdf.parse(startTimeStr);
		}
		if (endTimeStr != null) {
			endTime = sdf.parse(endTimeStr);
		}

		List<WeatherCollectStatisticsModel> model = weatherService
				.statisticWeatherByCreateTime(regionId, startTime, endTime,
						isDay);
		String str = JSONUtil.serialize(model, false);
		getWriter().write(str);
	}
	public void weatherStatisticData2() throws Exception {
		Date startTime = new SimpleDateFormat("yyyy-MM-dd").parse("2016-05-01");
		Date endTime = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if (startTimeStr != null) {
			startTime = sdf.parse(startTimeStr);
		}
		if (endTimeStr != null) {
			endTime = sdf.parse(endTimeStr);
		}
		
		List<WeatherCollectStatisticsModel2> model = weatherService2
		.statisticWeatherByCreateTime(plotId, startTime, endTime,
				isDay);
		
		for(WeatherCollectStatisticsModel2 w2:model){
			System.out.println(w2);
		}
		
		
		
		
		String str = JSONUtil.serialize(model, false);
		getWriter().write(str);
	}

	public void soilStatisticData() throws Exception {
		Date startTime = new SimpleDateFormat("yyyy-MM-dd").parse("2016-05-01");
		Date endTime = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if (startTimeStr != null) {
			startTime = sdf.parse(startTimeStr);
		}
		if (endTimeStr != null) {
			endTime = sdf.parse(endTimeStr);
		}
		String plotName="";
		if(plotIdName==2){
			plotName="001";}
			else{plotName="002";
			}
		List<SoilCollectStatisticsModel> model = soilService
				.statisticSoilByCreateTime(plotName, startTime, endTime, isDay);
		String str = JSONUtil.serialize(model, false);
		getWriter().write(str);
	}
	public void soilStatisticData2() throws Exception {
		Date startTime = new SimpleDateFormat("yyyy-MM-dd").parse("2016-05-01");
		Date endTime = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if (startTimeStr != null) {
			startTime = sdf.parse(startTimeStr);
		}
		if (endTimeStr != null) {
			endTime = sdf.parse(endTimeStr);
		}
		
		List<SoilCollectStatisticsModel2> model = soilService2
		.statisticSoilByCreateTime(plotId, startTime, endTime, isDay);
		String str = JSONUtil.serialize(model, false);
		
		System.out.println(str);
		getWriter().write(str);
	}

	public void cropStatisticData() throws Exception {
		/*Date startTime = new SimpleDateFormat("yyyy-MM-dd").parse("2016-05-01");
		Date endTime = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if (startTimeStr != null) {
			startTime = sdf.parse(startTimeStr);
		}
		if (endTimeStr != null) {
			endTime = sdf.parse(endTimeStr);
		}

		List<SoilCollectStatisticsModel> model = soilService
				.statisticSoilByCreateTime(regionId, startTime, endTime, isDay);
		String str = JSONUtil.serialize(model, false);
		getWriter().write(str);*/
	}

	// getter setter

	public Integer getRegionId() {
		return regionId;
	}

	public void setRegionId(Integer regionId) {
		this.regionId = regionId;
	}

	public Page<Area> getAreaPage() {
		return areaPage;
	}

	public void setAreaPage(Page<Area> areaPage) {
		this.areaPage = areaPage;
	}

	public Page<Weather> getWeatherPage() {
		return weatherPage;
	}

	public void setWeatherPage(Page<Weather> weatherPage) {
		this.weatherPage = weatherPage;
	}

	public Integer getCountyId() {
		return countyId;
	}

	public void setCountyId(Integer countyId) {
		this.countyId = countyId;
	}

	public Page<Soil> getSoilPage() {
		return soilPage;
	}

	public void setSoilPage(Page<Soil> soilPage) {
		this.soilPage = soilPage;
	}

	public Page<Soil2> getSoilPage2() {
		return soilPage2;
	}

	public void setSoilPage2(Page<Soil2> soilPage2) {
		this.soilPage2 = soilPage2;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public Integer getAreaId() {
		return areaId;
	}

	public void setCropPage(Page<Crop> cropPage) {
		this.cropPage = cropPage;
	}

	public Page<Crop> getCropPage() {
		return cropPage;
	}

	public void setIsDay(Boolean isDay) {
		this.isDay = isDay;
	}

	public Boolean getIsDay() {
		return isDay;
	}

	public void setStartTimeStr(String startTimeStr) {
		this.startTimeStr = startTimeStr;
	}

	public String getStartTimeStr() {
		return startTimeStr;
	}

	public void setEndTimeStr(String endTimeStr) {
		this.endTimeStr = endTimeStr;
	}

	public String getEndTimeStr() {
		return endTimeStr;
	}

	public String soilDownload() {
		return SUCCESS;
	}

	public String weatherDownload() {
		return SUCCESS;
	}
	public Page<Weather2> getWeatherPage2() {
		return weatherPage2;
	}
	public void setWeatherPage2(Page<Weather2> weatherPage2) {
		this.weatherPage2 = weatherPage2;
	}
	public Integer getPlotId() {
		return plotId;
	}
	public void setPlotId(Integer plotId) {
		this.plotId = plotId;
	}
	
}
