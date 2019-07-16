
package com.water.common.util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public   class  JsoupHtml {

	/**
	 * @param args
	 * @throws IOException  
	 */
	public static List<String> selectDate(String beginDate,String endDate,String plot) throws IOException{
		List<String> ahref=new ArrayList<String>();
		String url = "http://115.28.64.240/sys/user/"+plot+"/";
		Document doc = Jsoup.connect(url).timeout(30*1000).get();
		Elements links = doc.select("a[href]");
		for(int h=5;h<=links.size()-14;h++)
		{
			if(sub(links.get(h))>=Integer.parseInt(beginDate)&&sub(links.get(h))<=Integer.parseInt(endDate))
			{
				ahref.add(sub(links.get(h))+"");			
			}
		}
		return ahref;
		
	}
	public static  List<String> selectHref(String date,String plot) throws IOException
	{
		List<String> ahref=new ArrayList<String>();
		String url = "http://115.28.64.240/sys/user/"+plot+"/"+date+"/";
		Document doc = Jsoup.connect(url).timeout(10*1000).get();
		Elements links = doc.select("a[href]");
		for(int i=5;i<links.size()-1;i++)
		{
			String urlAdd=url+links.get(i).attr("href");
			ahref.add(urlAdd);
			System.out.println(urlAdd);
		}
		return ahref;
	}
		
	public  static int sub(Element e)
	{
		return Integer.parseInt(e.attr("href").substring(0,8));
		
	}
}
