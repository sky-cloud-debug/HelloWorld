package com.water.common.bean;

import com.water.model.User;

/**
 * 
 * 类名: SessionUser<BR>
 * 描述:放在会话中的User相关信息 <BR>
 * 创建人:翟旭光 <BR>
 * 时间：2016年4月15日-下午1:58:53 <BR>
 * 
 * @version 1.0
 */
public class SessionUser {
	private User user;

	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}
}
