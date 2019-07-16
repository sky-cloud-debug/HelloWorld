package com.water.web.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.water.common.bean.Page;
import com.water.model.County;
import com.water.model.Plot;


@Controller
@Scope("prototype")
public class PlotAction extends MyBaseAction<Plot> {
	
	private List<Plot> plots;
    private int countyId;
    private String plotId;
    private Page<Plot> plotPage;
    public Page<Plot> getPlotPage() {
		return plotPage;
	}
    public void setPlotPage(Page<Plot> plotPage) {
		this.plotPage = plotPage;
	}
	public int getCountyId() {
		return countyId;
	}

	public void setCountyId(int countyId) {
		this.countyId = countyId;
	}
	
	public String selectPlot(){
		plots = new ArrayList<Plot>();
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(countyId);
		plots = plotService.findListByCountyId(countyId);
		for(Plot p : plots ){
			System.out.println(p.getPlotName());
		}
		return SUCCESS;
		
	}
	public String getPlotId() {
		return plotId;
	}
	public void setPlotId(String plotId) {
		this.plotId = plotId;
	}
	public List<Plot> getPlots() {
		return plots;
	}
	public void setPlots(List<Plot> plots) {
		this.plots = plots;
	}
	public String selectOnePlot(){
		plots = new ArrayList<Plot>();
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(Integer.parseInt(plotId));
		plots = plotService.findListByIdList(ids);
		return SUCCESS;
		
	}
	public void plotAdd() throws Exception{
		plotService.save(model);
		getWriter().write("success");
	}
	public void deletePlot() throws Exception{
		plotService.delete(Integer.parseInt(plotId));
		getWriter().write("success");
	}
	
	
	public String plotList(){
		int plotCount=Integer.parseInt(""+plotService.getTotalCount());
		plotPage = new Page<Plot>();
		plotPage .setContent(plotService.findPlotList());
		ServletActionContext.getRequest().setAttribute("plotPage", plotPage);
		return SUCCESS;
	}
}
