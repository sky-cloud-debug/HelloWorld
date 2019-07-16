package com.water.web.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.water.common.bean.Page;
import com.water.model.City;


@Controller
@Scope("prototype")
public class CityAction extends MyBaseAction<City> {
	private Page<City> cityPage;
	private List<City> cities;
    private Integer cityId;
    public Page<City> getCityPage() {
		return cityPage;
	}
    public void setCityPage(Page<City> cityPage) {
		this.cityPage = cityPage;
	}
    public Integer getCityId() {
		return cityId;
	}
    public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public List<City> getCities() {
		return cities;
	}
	public void setCities(List<City> cities) {
		this.cities = cities;
	}
	public void cityAdd() throws Exception {
	cityService.save(model);
	getWriter().write("success");
    }
	
	public String select17(){
		
		cities = new ArrayList<City>();
		cities =  cityService.findCityList();
		return SUCCESS;
	}
	public void deleteCity() throws Exception{
		cityService.delete(cityId);
		getWriter().write("success");
	}
	public String cityList(){
		int cityCount=Integer.parseInt(""+cityService.getTotalCount());
		cityPage = new Page<City>();
		cityPage .setContent(cityService.findCityList());
		ServletActionContext.getRequest().setAttribute("cityPage", cityPage);
		return SUCCESS;
	}
}
