package com.water.common.web.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.water.common.bean.Page;
import com.water.common.bean.SessionUser;
import com.water.common.service.BaseService;
import com.water.common.util.Constants;
import com.water.model.Area;
import com.water.model.User;

/**
 * 
 * 类名: BaseAction<BR>
 * 描述:基础Action <BR>
 * 创建人:翟旭光 <BR>
 * 时间：2016年4月15日-下午1:21:55 <BR>
 * 
 * @version 1.0
 */
public class BaseAction<T> extends ActionSupport {

	public static final String SUCCESS = "success";
	public static final String FAIL = "fail";
	public static final String TO_LOGIN = "toLogin";
	public static final String TO_INDEX = "toIndex";
	public static final String ADD_UI = "addui";
	public static final String EDIT_UI = "editui";
	public static final String JSON = "json";
	public static final String TO_ITEM_INDEX = "toItemIndex";

	protected static HttpSession getCurrentHttpSession() {
		return ServletActionContext.getRequest().getSession();
	}

	protected HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}

	protected  static HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}

	protected static PrintWriter getWriter() throws IOException {
		getResponse().setCharacterEncoding("UTF-8");
		return getResponse().getWriter();
	}

	protected static SessionUser getCurrentUser() {
		return (SessionUser) getCurrentHttpSession().getAttribute(
				Constants.USER_SESSION_KEY);
	}

	protected void saveUserToSession(User user) {
		SessionUser sessionUser = new SessionUser();
		sessionUser.setUser(user);
		getCurrentHttpSession().setAttribute(Constants.USER_SESSION_KEY,
				sessionUser);
	}

	@Autowired
	protected BaseService<T> service;

	protected Integer id;
	protected List<Integer> ids;
	protected Page<T> page=new Page<T>();
	protected T model;
	protected List<T> list;
	
//	protected Class<T> clazz;
	
//	{
//		//得到泛型的具体类型
//		Type type = this.getClass().getGenericSuperclass();
//		if(type instanceof ParameterizedType){
//			ParameterizedType pt = (ParameterizedType)type;
//			clazz=(Class<T>) pt.getActualTypeArguments()[0];
//		}
//		
//		//反射创建model的实例
//		try {
//			model=clazz.newInstance();
//		} catch (InstantiationException e) {
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			e.printStackTrace();
//		}
//	}
	
	protected Map<String, Object> jsonMap;

	public String addui() {
		return ADD_UI;
	}

	public void add() throws IOException, Exception {
		System.out.println("==========");
		System.out.println(model);
		
		service.save(model);
		getWriter().write("success");
	}

	public String editui() {
		model=service.findOneById(id);
		return EDIT_UI;
	}

	public void edit() throws IOException {
		service.saveOrUpdate(model);
		getWriter().write("success");
	}

	public void delete() throws IOException {
		service.delete(id);
		getWriter().write("success");
	}

	public void deleteList() throws IOException {
		service.deleteList(ids);
		getWriter().write("success");
	}

	public String listByPage() {
		page = service.findByPage(page);
		jsonMap = new HashMap<String, Object>();
		jsonMap.put("page", page);
		return JSON;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}

	public Page<T> getPage() {
		return page;
	}

	public void setPage(Page<T> page) {
		this.page = page;
	}

	public T getModel() {
		return model;
	}

	public void setModel(T model) {
		this.model = model;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public Map<String, Object> getJsonMap() {
		return jsonMap;
	}

	public void setJsonMap(Map<String, Object> jsonMap) {
		this.jsonMap = jsonMap;
	}
}
