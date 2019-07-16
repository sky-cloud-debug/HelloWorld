package com.water.web.interceptor;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.water.common.util.Constants;
import com.water.common.web.action.BaseAction;
import com.water.model.User;

public class AuthenticationInterceptor implements Interceptor{

	@Override
	public void init() {
		
	}

	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		//session中的用戶信息
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute(Constants.USER_SESSION_KEY);
		if(user==null){
			return BaseAction.TO_LOGIN;
		}
		return actionInvocation.invoke();
	}

	
	@Override
	public void destroy() {
		
	}

}
