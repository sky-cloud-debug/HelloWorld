package com.water.web.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.water.common.bean.Page;
import com.water.model.City;
import com.water.model.County;


@Controller
@Scope("prototype")
public class CountyAction extends MyBaseAction<County> {
	
	private List<County> countys;
    private int regionId;
    private int countyId;
    private Page<County> countyPage;
    public Page<County> getCountyPage() {
		return countyPage;
	}
    public void setCountyPage(Page<County> countyPage) {
		this.countyPage = countyPage;
	}
    public int getCountyId() {
		return countyId;
	}
    public void setCountyId(int countyId) {
		this.countyId = countyId;
	}
	public List<County> getCountys() {
		return countys;
	}
	public int getRegionId() {
		return regionId;
	}
	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}
	public String county() throws Exception{
		/*countyService.save(model);
		getWriter().write("success");
*/
		return SUCCESS;
	}
	public void countyAdd() throws Exception{
		countyService.save(model);
		getWriter().write("success");
	}
	public String selectCounty(){
		countys = new ArrayList<County>();
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(regionId);
		countys = countyService.findListByRegionId(regionId);
		for(County c : countys ){
			System.out.println(c.getCountyName());
		}
		return SUCCESS;
		
	}
	public void deleteCounty() throws Exception{
		countyService.delete(countyId);
		getWriter().write("success");
	}
	
	public String countyList(){
		int countyCount=Integer.parseInt(""+countyService.getTotalCount());
		countyPage = new Page<County>();
		countyPage .setContent(countyService.findCountyList());
		ServletActionContext.getRequest().setAttribute("countyPage", countyPage);
		return SUCCESS;
	}
}
