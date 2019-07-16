package com.water.web.action;

import java.util.ArrayList;
import java.util.List;


import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.water.model.County;
import com.water.model.Plot;
import com.water.model.Region;


@Controller
@Scope("prototype")
public class RegionSelectAction extends MyBaseAction<Region> {
	
    private String cityName;
    private List<Region> regions;
    
    public List<Region> getRegions() {
		return regions;
	}
    public String getCityName() {
		return cityName;
	}
    public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	public String selectRegion(){
		regions = new ArrayList<Region>();
		regions = regionService.findListByCityName(cityName);
		return SUCCESS;
		
	}
	

}
