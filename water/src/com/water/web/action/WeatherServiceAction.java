package com.water.web.action;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.water.model.County;
import com.water.model.Device;
import com.water.model.Plot;
import com.water.model.WeatherForecast;
import com.water.util.HttpForForecast;
import com.water.util.WeatherData;


@Controller
@Scope("prototype")
public class WeatherServiceAction extends MyBaseAction<WeatherForecast> {
	
	
	
	
	public void saveWeatherForecast() throws Exception{
		String[] waterList = getRequest().getParameterValues("waterListSave");
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
        weatherForecastService.saveWeatherForecast(weatherDatas);
	
	}
	
	
	
}
