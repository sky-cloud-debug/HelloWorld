package com.water.web.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.water.model.County;
import com.water.model.Device;
import com.water.model.Plot;


@Controller
@Scope("prototype")
public class DeviceAction extends MyBaseAction<Device> {
	
	private List<Device> devices;
    private String plotId;
	
	public String getPlotId() {
		return plotId;
	}
	public void setPlotId(String plotId) {
		this.plotId = plotId;
	}

	public List<Device> getDevices() {
		return devices;
	}

	public void setDevices(List<Device> devices) {
		this.devices = devices;
	}
	public List<Device> selectDevices(Integer plotId){
		list = deviceService.findListByPlotId(plotId);
		
		return list;
	}
	
	
	
	
}
