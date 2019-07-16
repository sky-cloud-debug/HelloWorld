package com.water.web.action;

import java.io.IOException;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.water.model.Area;

@Controller
@Scope("prototype")
public class AreaAction extends MyBaseAction<Area> {
	private String status;
	private int areaId;
	private int regionId;
	
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
	public int getAreaId() {
		return areaId;
	}
	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}
	public void addArea() throws IOException {
		System.out.println(model.getAreaName());
		model.setRegion(regionService.findOneById(regionId));
		areaService.save(model);
		getWriter().write("success");	
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
	public String addui() {
		return SUCCESS;
	}
	public String updateArea()
	{
		model=areaService.findOneById(areaId);
		ServletActionContext.getRequest().getSession().setAttribute("areaUpdateId",model.getId());
	    return SUCCESS;
	}
	public void deleteArea() throws IOException
	{System.out.println(areaId);
		model=areaService.findOneById(areaId);
	    areaService.delete(areaId);
	    System.out.println(areaId);
		getWriter().write("success");
	}
	public void updateArea2() throws IOException
	{   Area model1;
     	int areaId=(Integer) ServletActionContext.getRequest().getSession().getAttribute("areaUpdateId");
		model1=areaService.findOneById(areaId);
		model1.setAreaName(model.getAreaName());
		model1.setAverageWaterCapacity(model.getAverageWaterCapacity());
		model1.setFirstCropCoefficient(model.getFirstCropCoefficient());
		model1.setFirstStageDepthOfWetting(model.getFirstStageDepthOfWetting());
		model1.setIrrigationArea(model.getIrrigationArea());
		model1.setSecondCropCoefficient(model.getSecondCropCoefficient());
		model1.setSecondStageDepthOfWetting(model.getSecondStageDepthOfWetting());
		model1.setSoilDryBulkDensity(model.getSoilDryBulkDensity());	
		model1.setOutletNumber(model.getOutletNumber());
		model1.setSoilType(model.getSoilType());
		areaService.update(model1);  
		getWriter().write("success");
	}
}
