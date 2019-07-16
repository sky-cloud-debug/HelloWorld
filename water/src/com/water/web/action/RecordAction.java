package com.water.web.action;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.water.common.bean.Page;
import com.water.model.MessageRecord;
import com.water.model.WaterRecord;

@Controller
public class RecordAction extends MyBaseAction<MessageRecord>{
	public String messageRecord(){
		Page<MessageRecord> page=new Page<MessageRecord>();
		page.setPageNo(1);
		page.setPageSize(10);
		messageRecordService.findByPage(page);
		ServletActionContext.getRequest().setAttribute("page", page);
		return SUCCESS;
	}
	public String waterRecord(){
		Page<WaterRecord> page=new Page<WaterRecord>();
		page.setPageNo(1);
		page.setPageSize(10);
		waterRecordService.findByPage(page);
		ServletActionContext.getRequest().setAttribute("page", page);
		return SUCCESS;
	}
}
