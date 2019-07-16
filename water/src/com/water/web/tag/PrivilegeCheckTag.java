package com.water.web.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.water.model.User;


/**
 * 权限检查标签，如果没有权限则不显示标签内容
 * @author lingxiaoguang
 *
 */
public class PrivilegeCheckTag extends SimpleTagSupport{

	@Override
	public void doTag() throws JspException, IOException {
		PageContext pageContext=(PageContext) this.getJspContext();
		User user = (User) pageContext.getSession().getAttribute("user");
		if(user!=null){
			//如果已经登陆并且是管理员，则显示标签体
			if("admin".equals(user.getUsername())){
				this.getJspBody().invoke(null);
			}
		}
	}
}
