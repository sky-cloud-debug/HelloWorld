package com.water.web.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.water.common.util.JsoupHtml;

@Controller("pictureAction")
@Scope("prototype")
public class PictureAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<String> imgSrc;
	private String beginDate;
	private String endDate;
	private String plotId;

	public String requestPicture() {
		return SUCCESS;
	}

	public List<String> getImgSrc() {
		return imgSrc;
	}

	public void setImgSrc(List<String> imgSrc) {
		this.imgSrc = imgSrc;
	}

	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getPlotId() {
		return plotId;
	}

	public void setPlotId(String plotId) {
		this.plotId = plotId;
	}

	public void getPicture() throws IOException {
		imgSrc = new ArrayList<String>();
		List<String> dates = JsoupHtml.selectDate(beginDate, endDate, plotId);
		for (int i = 0; i < dates.size(); i++) {
			imgSrc.addAll((JsoupHtml.selectHref(dates.get(i), plotId)));
		}
		for (int i = 0; i < imgSrc.size(); i++) {
			System.out.println("这是我的数据");
			System.out.println(imgSrc.get(i));
		}
		JSONArray jsonArray = new JSONArray();
		jsonArray.addAll(imgSrc);
		ServletActionContext.getResponse().getWriter().write(jsonArray.toString());
	}
}
