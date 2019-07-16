package com.water.web.action;

import java.io.IOException;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.inject.Container;
import com.water.common.util.LogUtils;
import com.water.model.User;

@Controller
@Scope("prototype")
public class UserAction extends MyBaseAction<User> {
	private String status;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	// 原密码
	private String prevPassword;
	// 新密码
	private String newPassword;
	// 确认密码
	private String confirmPassword;

	public void login() throws IOException {
		User tmpUser = userService.findByUsernameAndPassword(
				model.getUsername(), model.getPassword());
		if (tmpUser == null) {
			getWriter().write("fail");
			
			} else {
			saveUserToSession(tmpUser);
			
			status=(String) ServletActionContext.getRequest().getSession().getAttribute("status");
			getWriter().write(status);
		}
	}

	public String logout() {
		getCurrentHttpSession().invalidate();
		return TO_INDEX;
	}

	public String updatePasswordUI() {
		return SUCCESS;
	}

	public void updatePassword() throws IOException {
		User user = getCurrentUser().getUser();
		// 验证是否合法
		if (!prevPassword.equals(user.getPassword())) {
			getWriter().write("原密码错误!");
			return;
		}
		if (!newPassword.equals(confirmPassword)) {
			getWriter().write("两次密码不一致!");
			return;
		}
		// 修改密码
		Integer userId = user.getId();
		User tmpUser = userService.findOneById(userId);
		System.out.println(newPassword);
		tmpUser.setPassword(newPassword);
		userService.update(tmpUser);

		getWriter().write("success");
	}

	public String updateui() {
		return SUCCESS;
	}

	public void update() throws IOException {
		Integer userId = getCurrentUser().getUser().getId();
		User tmpUser = userService.findOneById(userId);

		tmpUser.setEmail(model.getEmail());
		tmpUser.setTelephone(model.getTelephone());
		userService.update(tmpUser);

		saveUserToSession(tmpUser);
		getWriter().write("success");
	}

	// getter setter

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setPrevPassword(String prevPassword) {
		this.prevPassword = prevPassword;
	}

	public String getPrevPassword() {
		return prevPassword;
	}
}
