package com.water.util;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.water.model.Device;
import com.water.model.Soil2;
import com.water.model.Weather2;
import com.water.service.SoilService2;
import com.water.web.action.DeviceAction;
import com.water.web.action.PlotAction;
import com.water.web.action.RegionAction;
import com.water.web.action.RegionDetailAction;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;



public class GetDataSource {
	public static String sendPost(String url,String Params)throws IOException{
        OutputStreamWriter out = null;
        BufferedReader reader = null;
        String response="";
        try {
            URL httpUrl = null; //HTTP URL类 用这个类创建连接
            //创建URL
            httpUrl = new URL(url);
            //建立连接
            HttpURLConnection conn = (HttpURLConnection) httpUrl.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("connection", "keep-alive");
            conn.setRequestProperty("contentType", "utf-8");  
            conn.setUseCaches(false);//设置不要缓存
            conn.setInstanceFollowRedirects(true);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.connect();
            //POST请求
            out = new OutputStreamWriter(
                    conn.getOutputStream(),"utf-8");
            out.write(Params);
            out.flush();
            //读取响应
            reader = new BufferedReader(new InputStreamReader(
                    conn.getInputStream(), "utf-8"));
            String lines;
            while ((lines = reader.readLine()) != null) {//lines.getBytes()
                lines = new String(lines.getBytes());
                response+=lines;
            }
            reader.close();
            // 断开连接
            conn.disconnect();

        } catch (Exception e) {
        System.out.println("发送POST请求出现异常 "+e);
        e.printStackTrace();
        }
        //使用finally块来关闭输入流、输出流
        finally{
        try{
            if(out!=null){
                out.close();
            }
            if(reader!=null){
                reader.close();
            }
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }

        return response;
    }
public static String changeToTime(String ss){
	Date data = new Date(Long.parseLong(ss));	
	return data.getYear()+1900+"-"+add0(data.getMonth()+1)+"-"+add0(data.getDate())+" "+add0(data.getHours())+":"+add0(data.getMinutes())+
	":"+add0(data.getSeconds());
}

public static String add0(int tt){
	return tt<10 ? ("0"+tt):(tt+"");
}

public static void updateTime(String value,String type){
	
}




//i+bp0LmulpgNEimyEcUDQQ==  MzlSyU6bWhCXWDErt4/k3g==
public static List<Object> getWeatherAndSoil(){
	String url="http://sa.tcloudit.com:8003/ToCustomerService.svc/GetDeviceNowData";
	String data="{\"username\":\"zzdz\",\"pass\":\"123456\",\"privatekey\":\"MzlSyU6bWhCXWDErt4/k3g==\",\"addupTime\":\"60\"}";
	List<Object> otwo = new ArrayList<Object>();
int countIf=0;
	try {
			String result=sendPost(url,data);
			 System.out.println(result);
			 JSONObject jsonObject = 	JSONObject.fromObject(result);
	JSONArray iterm12= JSONArray.fromObject(jsonObject.getJSONArray("Items"));
	Weather2 w2 = new Weather2();
	Soil2 s2 = new Soil2();
	otwo.add(s2);
	otwo.add(w2);
	int count = 0;
	boolean soil=false;
	boolean weather=false;
	for (int i = 0; i < 12; i++) {
		JSONObject as = iterm12.getJSONObject(i);
		if(as.getString("OrgName").equals("基地1")||as.getString("OrgName").equals("基地2")){
			countIf++;
		int ass = Integer.parseInt(as.getString("DeviceType"));
		switch(ass){
		//空气温度:1,空气湿度:2,土壤温度:3,土壤水分:4,光照强度:5,二氧化碳:6,降雨量:7,风速:8,流量:9,风向:10,水压:11,CO2浓度: 31,酸碱度: 14,土壤电导率: 56
		
		case 1: w2.setAirTemp(as.getString("LastValue"));if(!as.getString("LastValue").equals("--")&&!weather){
			Long d = Long.parseLong(as.getString("LastUpdateValueTime").substring(6,as.getString("LastUpdateValueTime").length()-7));
			w2.setCreateTime(new Date(d));	
		}
		System.out.println("设备名称:"+as.getString("DeviceName"));
		break;//;设备连接状态："+(Integer.parseInt(as.getString("ContactStatus"))==1?"连接正常":"连接断开"));
		case 2: w2.setAirHumi(as.getString("LastValue"));
		if(!as.getString("LastValue").equals("--")&&!weather){
			Long d = Long.parseLong(as.getString("LastUpdateValueTime").substring(6,as.getString("LastUpdateValueTime").length()-7));
			w2.setCreateTime(new Date(d));	
		}
		
		break;//";设备连接状态："+(Integer.parseInt(as.getString("ContactStatus"))==1?"连接正常":"连接断开"));break;
		case 3: s2.setSoilTemp(as.getString("LastValue"));System.out.println("设备名称:"+as.getString("DeviceName"));
		if(!as.getString("LastValue").equals("--")&&!soil){
			Long d = Long.parseLong(as.getString("LastUpdateValueTime").substring(6,as.getString("LastUpdateValueTime").length()-7));
			s2.setCreateTime(new Date(d));	
		}
		
		break;//";设备连接状态："+(Integer.parseInt(as.getString("ContactStatus"))==1?"连接正常":"连接断开"));break;
		case 4: if(count==0){s2.setSoilHumi(as.getString("LastValue"));count++;}else if(count==1){s2.setSoilHumi2(as.getString("LastValue"));count++;}
		else{s2.setSoilHumi3(as.getString("LastValue"));	
		     System.out.println("设备名称:"+as.getString("DeviceName"));break;//";设备连接状态："+(Integer.parseInt(as.getString("ContactStatus"))==1?"连接正常":"连接断开"));break;
		     }
		
		if(!as.getString("LastValue").equals("--")&&!soil){
			Long d = Long.parseLong(as.getString("LastUpdateValueTime").substring(6,as.getString("LastUpdateValueTime").length()-7));
			s2.setCreateTime(new Date(d));	
		}
		
		break;		
		case 5: w2.setSunData(as.getString("LastValue"));System.out.println("设备名称:"+as.getString("DeviceName"));
		if(!as.getString("LastValue").equals("--")&&!weather){
			Long d = Long.parseLong(as.getString("LastUpdateValueTime").substring(6,as.getString("LastUpdateValueTime").length()-7));
			w2.setCreateTime(new Date(d));	
		}
		
		break;//";设备连接状态："+(Integer.parseInt(as.getString("ContactStatus"))==1?"连接正常":"连接断开"));break;
		case 6: w2.setCo2(as.getString("LastValue"));System.out.println("设备名称:"+as.getString("DeviceName"));
		if(!as.getString("LastValue").equals("--")&&!weather){
			Long d = Long.parseLong(as.getString("LastUpdateValueTime").substring(6,as.getString("LastUpdateValueTime").length()-7));
			w2.setCreateTime(new Date(d));	
		}
		
		
		
		break;//";设备连接状态："+(Integer.parseInt(as.getString("ContactStatus"))==1?"连接正常":"连接断开"));break;
		case 7: w2.setRainHour(as.getString("LastValue"));System.out.println("设备名称:"+as.getString("DeviceName"));
		if(!as.getString("LastValue").equals("--")&&!weather){
			Long d = Long.parseLong(as.getString("LastUpdateValueTime").substring(6,as.getString("LastUpdateValueTime").length()-7));
			w2.setCreateTime(new Date(d));	
		}break;//";设备连接状态："+(Integer.parseInt(as.getString("ContactStatus"))==1?"连接正常":"连接断开"));break;
		case 8: w2.setWindSpeed(as.getString("LastValue"));System.out.println(as.getString("DeviceName"));
		if(!as.getString("LastValue").equals("--")&&!weather){
			Long d = Long.parseLong(as.getString("LastUpdateValueTime").substring(6,as.getString("LastUpdateValueTime").length()-7));
			w2.setCreateTime(new Date(d));	
		}break;//";设备连接状态："+(Integer.parseInt(as.getString("ContactStatus"))==1?"连接正常":"连接断开"));break;
 		case 14:s2.setPh(as.getString("LastValue"));System.out.println("设备名称:"+as.getString("DeviceName"));Long d1 = Long.parseLong(as.getString("LastUpdateValueTime").substring(6,as.getString("LastUpdateValueTime").length()-7));
 		s2.setCreateTime(new Date(d1));
 		if(!as.getString("LastValue").equals("--")&&!soil){
			Long d = Long.parseLong(as.getString("LastUpdateValueTime").substring(6,as.getString("LastUpdateValueTime").length()-7));
			s2.setCreateTime(new Date(d));	
		}
		break;//s2.setCreateTime(new Date(changeToTime(as.getString("LastUpdateValueTime").substring(6,as.getString("LastUpdateValueTime").length()-7))));break;//";设备连接状态："+(Integer.parseInt(as.getString("ContactStatus"))==1?"连接正常":"连接断开"));break;
 		case 56:s2.setElect(as.getString("LastValue"));System.out.println("设备名称:"+as.getString("DeviceName"));
 		if(!as.getString("LastValue").equals("--")&&!soil){
			Long d = Long.parseLong(as.getString("LastUpdateValueTime").substring(6,as.getString("LastUpdateValueTime").length()-7));
			s2.setCreateTime(new Date(d));	
		}
		break;//";设备连接状态："+(Integer.parseInt(as.getString("ContactStatus"))==1?"连接正常":"连接断开"));
		}
		}	
	}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	if(countIf==0){
		return null;
	}else{
	return otwo;}
}

/*public static List<Object> getManyWeatherAndSoil(List<Plot> plotList){
	String url="http://sa.tcloudit.com:8003/ToCustomerService.svc/GetDeviceTypeData";
	//System.out.println(new Date()+"今天是");
	String data ="";
    RegionDetailAction regionDetailAction = new RegionDetailAction();
    DeviceAction deviceAction = new DeviceAction();
    List<Device> devices = new ArrayList<Device>();
    for(Plot ii : plotList){ 
    devices = deviceAction.selectDevices(ii.getId());
    Date soilDate = regionDetailAction.soil2Newest(Integer.parseInt(ii.getPlotId()));
    for(Device dc : devices){
    if(soilDate!=null){
    	
    	
    	
        data="{\"username\":\"zzdz\",\"pass\":\"123456\",\"privatekey\":\"MzlSyU6bWhCXWDErt4/k3g==\",\"deviceType\":\"3\",\"starttime\":\"2017-07-20 10:40:23\",\"endtime\":\"2017-07-20 22:40:23\"}";

    	List<Object> otwo = new ArrayList<Object>();
    int countIf=0;
    }
    Date weatherDate = regionDetailAction.weather2Newest(Integer.parseInt(ii.getPlotId()));
    if(weatherDate!=null){
    
       
    	
    	try {
    			String result=sendPost(url,data);
    			 System.out.println(result);
    			 JSONObject jsonObject = 	JSONObject.fromObject(result);
    	JSONArray iterm12= JSONArray.fromObject(jsonObject.getJSONArray("Items"));
    	Weather2 w2 = new Weather2();
    	Soil2 s2 = new Soil2();
    	otwo.add(s2);
    	otwo.add(w2);	
    }
    }}
	//String data="{\"username\":\"zzdz\",\"pass\":\"123456\",\"privatekey\":\"MzlSyU6bWhCXWDErt4/k3g==\",\"deviceType\":\"3\",\"starttime\":\"2017-07-20 10:40:23\",\"endtime\":\"2017-07-20 22:40:23\"}";
	List<Object> otwo = new ArrayList<Object>();
int countIf=0;
	try {
			String result=sendPost(url,data);
			 System.out.println(result);
			 JSONObject jsonObject = 	JSONObject.fromObject(result);
	JSONArray iterm12= JSONArray.fromObject(jsonObject.getJSONArray("Items"));
	Weather2 w2 = new Weather2();
	Soil2 s2 = new Soil2();
	otwo.add(s2);
	otwo.add(w2);
	int count = 0;
	boolean soil=false;
	boolean weather=false;
	for (int i = 0; i < 12; i++) {
		JSONObject as = iterm12.getJSONObject(i);
		if(as.getString("OrgName").equals("基地1")||as.getString("OrgName").equals("基地2")){
			countIf++;
		int ass = Integer.parseInt(as.getString("DeviceType"));
		switch(ass){
		//空气温度:1,空气湿度:2,土壤温度:3,土壤水分:4,光照强度:5,二氧化碳:6,降雨量:7,风速:8,流量:9,风向:10,水压:11,CO2浓度: 31,酸碱度: 14,土壤电导率: 56
		
		case 1: w2.setAirTemp(as.getString("LastValue"));if(!as.getString("LastValue").equals("--")&&!weather){
			Long d = Long.parseLong(as.getString("LastUpdateValueTime").substring(6,as.getString("LastUpdateValueTime").length()-7));
			w2.setCreateTime(new Date(d));	
		}
		System.out.println("设备名称:"+as.getString("DeviceName"));
		break;//;设备连接状态："+(Integer.parseInt(as.getString("ContactStatus"))==1?"连接正常":"连接断开"));
		case 2: w2.setAirHumi(as.getString("LastValue"));
		if(!as.getString("LastValue").equals("--")&&!weather){
			Long d = Long.parseLong(as.getString("LastUpdateValueTime").substring(6,as.getString("LastUpdateValueTime").length()-7));
			w2.setCreateTime(new Date(d));	
		}
		
		break;//";设备连接状态："+(Integer.parseInt(as.getString("ContactStatus"))==1?"连接正常":"连接断开"));break;
		case 3: s2.setSoilTemp(as.getString("LastValue"));System.out.println("设备名称:"+as.getString("DeviceName"));
		if(!as.getString("LastValue").equals("--")&&!soil){
			Long d = Long.parseLong(as.getString("LastUpdateValueTime").substring(6,as.getString("LastUpdateValueTime").length()-7));
			s2.setCreateTime(new Date(d));	
		}
		
		break;//";设备连接状态："+(Integer.parseInt(as.getString("ContactStatus"))==1?"连接正常":"连接断开"));break;
		case 4: if(count==0){s2.setSoilHumi(as.getString("LastValue"));count++;}else if(count==1){s2.setSoilHumi2(as.getString("LastValue"));count++;}
		else{s2.setSoilHumi3(as.getString("LastValue"));	
		     System.out.println("设备名称:"+as.getString("DeviceName"));break;//";设备连接状态："+(Integer.parseInt(as.getString("ContactStatus"))==1?"连接正常":"连接断开"));break;
		     }
		
		if(!as.getString("LastValue").equals("--")&&!soil){
			Long d = Long.parseLong(as.getString("LastUpdateValueTime").substring(6,as.getString("LastUpdateValueTime").length()-7));
			s2.setCreateTime(new Date(d));	
		}
		
		break;		
		case 5: w2.setSunData(as.getString("LastValue"));System.out.println("设备名称:"+as.getString("DeviceName"));
		if(!as.getString("LastValue").equals("--")&&!weather){
			Long d = Long.parseLong(as.getString("LastUpdateValueTime").substring(6,as.getString("LastUpdateValueTime").length()-7));
			w2.setCreateTime(new Date(d));	
		}
		
		break;//";设备连接状态："+(Integer.parseInt(as.getString("ContactStatus"))==1?"连接正常":"连接断开"));break;
		case 6: w2.setCo2(as.getString("LastValue"));System.out.println("设备名称:"+as.getString("DeviceName"));
		if(!as.getString("LastValue").equals("--")&&!weather){
			Long d = Long.parseLong(as.getString("LastUpdateValueTime").substring(6,as.getString("LastUpdateValueTime").length()-7));
			w2.setCreateTime(new Date(d));	
		}
		
		
		
		break;//";设备连接状态："+(Integer.parseInt(as.getString("ContactStatus"))==1?"连接正常":"连接断开"));break;
		case 7: w2.setRainHour(as.getString("LastValue"));System.out.println("设备名称:"+as.getString("DeviceName"));
		if(!as.getString("LastValue").equals("--")&&!weather){
			Long d = Long.parseLong(as.getString("LastUpdateValueTime").substring(6,as.getString("LastUpdateValueTime").length()-7));
			w2.setCreateTime(new Date(d));	
		}break;//";设备连接状态："+(Integer.parseInt(as.getString("ContactStatus"))==1?"连接正常":"连接断开"));break;
		case 8: w2.setWindSpeed(as.getString("LastValue"));System.out.println(as.getString("DeviceName"));
		if(!as.getString("LastValue").equals("--")&&!weather){
			Long d = Long.parseLong(as.getString("LastUpdateValueTime").substring(6,as.getString("LastUpdateValueTime").length()-7));
			w2.setCreateTime(new Date(d));	
		}break;//";设备连接状态："+(Integer.parseInt(as.getString("ContactStatus"))==1?"连接正常":"连接断开"));break;
 		case 14:s2.setPh(as.getString("LastValue"));System.out.println("设备名称:"+as.getString("DeviceName"));Long d1 = Long.parseLong(as.getString("LastUpdateValueTime").substring(6,as.getString("LastUpdateValueTime").length()-7));
 		s2.setCreateTime(new Date(d1));
 		if(!as.getString("LastValue").equals("--")&&!soil){
			Long d = Long.parseLong(as.getString("LastUpdateValueTime").substring(6,as.getString("LastUpdateValueTime").length()-7));
			s2.setCreateTime(new Date(d));	
		}
		break;//s2.setCreateTime(new Date(changeToTime(as.getString("LastUpdateValueTime").substring(6,as.getString("LastUpdateValueTime").length()-7))));break;//";设备连接状态："+(Integer.parseInt(as.getString("ContactStatus"))==1?"连接正常":"连接断开"));break;
 		case 56:s2.setElect(as.getString("LastValue"));System.out.println("设备名称:"+as.getString("DeviceName"));
 		if(!as.getString("LastValue").equals("--")&&!soil){
			Long d = Long.parseLong(as.getString("LastUpdateValueTime").substring(6,as.getString("LastUpdateValueTime").length()-7));
			s2.setCreateTime(new Date(d));	
		}
		break;//";设备连接状态："+(Integer.parseInt(as.getString("ContactStatus"))==1?"连接正常":"连接断开"));
		}
		}	
	}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	if(countIf==0){
		return null;
	}else{
	return otwo;}
	
    }

return null;
}*/




}
