package com.water.web.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.sun.org.apache.bcel.internal.generic.GETSTATIC;
import com.water.common.bean.Page;
import com.water.common.web.action.BaseAction;
import com.water.model.Area;
import com.water.model.User;
import com.water.model.WaterData;
import com.water.model.WaterRecord;
import com.water.model.WaterStatus;
import com.water.util.WaterUtil;

@Controller
@Scope("prototype")
public class WaterAction extends MyBaseAction<Area>{
	private String status;
	private int waterNum1;
	private int waterNum2;
	private int waterNum3;
	private int waterNum4;
	private User modle;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getModle() {
		return modle;
	}

	public void setModle(User modle) {
		this.modle = modle;
	}

	public int getWaterNum1() {
		return waterNum1;
	}

	public void setWaterNum1(int waterNum1) {
		this.waterNum1 = waterNum1;
	}

	public int getWaterNum2() {
		return waterNum2;
	}

	public void setWaterNum2(int waterNum2) {
		this.waterNum2 = waterNum2;
	}

	public int getWaterNum3() {
		return waterNum3;
	}

	public void setWaterNum3(int waterNum3) {
		this.waterNum3 = waterNum3;
	}

	public int getWaterNum4() {
		return waterNum4;
	}

	public void setWaterNum4(int waterNum4) {
		this.waterNum4 = waterNum4;
	}
public String login() throws IOException
{ if(getCurrentUser()==null){
	getWriter().write("fail");
	ServletActionContext.getRequest().getSession().setAttribute("status", status);
	return "fail";
} else {
	
	getWriter().write("success");
	return "success";
}
	
}
public String login2() throws IOException
{if(getCurrentUser()==null){
	getWriter().write("fail");
	ServletActionContext.getRequest().getSession().setAttribute("status", status);
	return "fail";
} else {
	water();
	getWriter().write("success");
	return "success";
}
}
	public String water(){
		Page<Area> page=new Page<Area>();
		page.setPageNo(1);
		page.setPageSize(100);
		List<Area> areaList = areaService.findByPage(page).getContent();
		List<Map<String,String>> waterList=new ArrayList<Map<String,String>>();
		for (Area area : areaList) {
//			WaterUtil.irriauto(waterholdingCapacity, soilHumi, Hi, Ai);
			Map<String,String> map=new HashMap<String,String>();
			Integer outletNumber=area.getOutletNumber();
			String irrigationArea=area.getIrrigationArea();
			System.out.println("田间持水量："+Double.parseDouble(area.getWaterholdingCapacity())+";最低灌水下限："+Double.parseDouble(area.getIrrigationLowerLimit())+"作物第一生长期"+Double.parseDouble(area.getFirstStageDepthOfWetting())+"出水口灌溉面积:"+Double.parseDouble(area.getIrrigationArea()));
			double waterNum=WaterUtil.irriauto(Double.parseDouble(area.getWaterholdingCapacity()),Double.parseDouble(area.getIrrigationLowerLimit()),Double.parseDouble(area.getFirstStageDepthOfWetting()),Double.parseDouble(area.getIrrigationArea()));
			System.out.println(waterNum);
			map.put("outletNumber",outletNumber+"");
			map.put("irrigationArea",irrigationArea);
			map.put("waterNum",waterNum+"");
			waterList.add(map);
		}
		ServletActionContext.getRequest().setAttribute("waterList",waterList);
//	WaterUtil.geti(beginsoilHumi, endsoilHumi, beginDepth, endDepth, Kc, ET0, P);
		return SUCCESS;
	}
	
	public String device(){
		WaterStatus waterStatus=waterStatusService.findOneByCreateTimeDesc();
		List<WaterData> waterDataList=waterDataService.findLatestWaterData();
		ServletActionContext.getRequest().setAttribute("waterStatus",waterStatus);
		ServletActionContext.getRequest().setAttribute("waterData1",waterDataList.get(0));
		ServletActionContext.getRequest().setAttribute("waterData2",waterDataList.get(1));
		ServletActionContext.getRequest().setAttribute("waterData3",waterDataList.get(2));
		ServletActionContext.getRequest().setAttribute("waterData4",waterDataList.get(3));
		System.out.println(waterStatus.getWater1()+","+waterStatus.getWater2()+","+waterStatus.getWater3()+","+waterStatus.getWater4());
		return SUCCESS;
	}
	
	public void confirm() throws Exception{
		Page<Area> page=new Page<Area>();
		page.setPageNo(1);
		page.setPageSize(100);
		List<Area> areaList = areaService.findByPage(page).getContent();
		List<Map<String,String>> waterList=new ArrayList<Map<String,String>>();
		for (Area area : areaList) {
//			WaterUtil.irriauto(waterholdingCapacity, soilHumi, Hi, Ai);
			Integer outletNumber=area.getOutletNumber();
			String irrigationArea=area.getIrrigationArea();
			double waterNum=WaterUtil.irriauto(Double.parseDouble(area.getWaterholdingCapacity()),Double.parseDouble(area.getIrrigationLowerLimit()),Double.parseDouble(area.getFirstStageDepthOfWetting()),Double.parseDouble(area.getIrrigationArea()));
			WaterUtil.sendIrrigationCode(outletNumber,Integer.parseInt(waterNum+""));
			Thread.sleep(6000);
			WaterRecord wr=new WaterRecord();
			wr.setCreateTime(new Date());
			wr.setOutletNumber(outletNumber+"");
			wr.setIrrigationArea(irrigationArea);
			wr.setWaterNum(waterNum+"");
			waterRecordService.save(wr);
		}
		ServletActionContext.getResponse().getWriter().write("success");
	}
	//向硬件发送指令-----手动灌溉
	public void confirmm() throws Exception{
		getWriter().write("success");
		if(waterNum1!=0){
			WaterUtil.sendIrrigationCode(1,Integer.parseInt(waterNum1+""));
			WaterRecord wr=new WaterRecord();
			wr.setCreateTime(new Date());
			wr.setOutletNumber(1+"");
			wr.setIrrigationArea("13");
			wr.setWaterNum(waterNum1+"");
			waterRecordService.save(wr);
			Thread.sleep(6000);}
		if(waterNum2!=0){
			WaterUtil.sendIrrigationCode(2,Integer.parseInt(waterNum2+""));
			WaterRecord wr1=new WaterRecord();
			wr1.setCreateTime(new Date());
			wr1.setOutletNumber(2+"");
			wr1.setIrrigationArea("10");
			wr1.setWaterNum(waterNum2+"");
		    waterRecordService.save(wr1);
			Thread.sleep(6000);}
		if(waterNum3!=0){
			WaterUtil.sendIrrigationCode(3,Integer.parseInt(waterNum3+""));
			WaterRecord wr2=new WaterRecord();
			wr2.setCreateTime(new Date());
			wr2.setOutletNumber(3+"");
			wr2.setIrrigationArea("10");
			wr2.setWaterNum(waterNum3+"");
			waterRecordService.save(wr2);
			Thread.sleep(6000);}
		if(waterNum4!=0){
			WaterUtil.sendIrrigationCode(4,Integer.parseInt(waterNum4+""));
			WaterRecord wr3=new WaterRecord();
			wr3.setCreateTime(new Date());
			wr3.setOutletNumber(4+"");
			wr3.setIrrigationArea("11.5");
			wr3.setWaterNum(waterNum4+"");
			waterRecordService.save(wr3);}

			
		
	 
	}
	public String manualWater()
	
	{
		return SUCCESS;
	}
}
