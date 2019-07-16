package com.water.web.action;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import net.sf.json.JSONObject;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.JSONUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.water.model.News;
import com.water.util.StringUtils;

/**
 * 
 * 类名: NewsAction<BR>
 * 描述: 新闻控制器<BR>
 * 创建人:翟旭光 <BR>
 * 时间：2016年5月25日-下午12:42:38 <BR>
 * 
 * @version 1.0
 */
@Controller
@Scope("prototype")
public class NewsAction extends MyBaseAction<News> {
    private String status;
	private Integer type;
	private Integer newsId;
	private News news;

	public News getNews() {
		return news;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setNews(News news) {
		this.news = news;
	}

	public int getNewsId() {
		return newsId;
	}

	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String list() {
		return SUCCESS;
	}

	public String ajaxListById() throws Exception {
		news = newsService.findOneById(newsId);
		String str = JSONUtil.serialize(news,false);
		getWriter().write(str);
		return SUCCESS;
	}

	/**
	 * 新闻列表页面
	 * 
	 * @return
	 * @throws Exception 
	 */
	public String newsList() throws Exception {
		// 参数默认值
		
		if(getCurrentUser()==null){
			getWriter().write("fail");
			ServletActionContext.getRequest().getSession().setAttribute("status", status);
			return "fail";
		} else {
			
			getWriter().write("success");
		if (page.getPageNo() == null) {
			page.setPageNo(1);
		}
		if (page.getPageSize() == null) {
			page.setPageSize(10);
		}
		// 查询分页的新闻
		newsService.findByPage(page);
		return SUCCESS;}
	}

	public String show() {
		news = newsService.findOneById(newsId);
		return SUCCESS;
	}
	
	/**
	 * 新闻详情界面
	 * @return
	 */
	public String detail() {
		news = newsService.findOneById(newsId);
		return SUCCESS;
	}
	
	/**
	 * 更多新闻界面
	 * @return
	 */
	public String more(){
		return SUCCESS;
	}

	/**
	 * ajax新闻列表页面
	 * 
	 * @return
	 */
	public String ajaxNewsList() {
		// 参数默认值
		if (page.getPageNo() == null) {
			page.setPageNo(1);
		}
		if (page.getPageSize() == null) {
			page.setPageSize(10);
		}
		// 查询分页的新闻
		newsService.findByPage(page);
		return SUCCESS;
	}

	/**
	 * 添加新闻页面
	 * 
	 * @return
	 * @throws Exception 
	 */
	public String addNews() throws Exception {
		if(getCurrentUser()==null){
			getWriter().write("fail");
			ServletActionContext.getRequest().getSession().setAttribute("status", status);
			return "fail";
		} else {			
			getWriter().write("success");
		return SUCCESS;}
	}

	public String editNews() throws Exception {
		
		

		news = newsService.findOneById(newsId);
		return SUCCESS;
	}

	/**
	 * 新增
	 * 
	 * @throws IOException
	 */
	public void save() throws IOException {
		news.setCreateTime(new Date());
		newsService.save(news);
		getWriter().write("success");
	}

	/**
	 * 修改
	 * 
	 * @throws IOException
	 */
	public void update() throws IOException {
		News tmpNews = newsService.findOneById(news.getId());
		tmpNews.setAuthor(news.getAuthor());
		tmpNews.setContent(news.getContent());
		tmpNews.setImgPath(news.getImgPath());
		tmpNews.setSource(news.getSource());
		tmpNews.setTitle(news.getTitle());
		tmpNews.setType(news.getType());
		newsService.update(tmpNews);
		getWriter().write("success");
	}

	/**
	 * 删除
	 * 
	 * @throws IOException
	 */
	public void delete() throws IOException {
		newsService.delete(news.getId());
		getWriter().write("success");
	}

	File img;
	String imgFileName;

	/**
	 * 上传图片
	 * 
	 * @throws Exception
	 */
	public void uploadImg() throws Exception {
		// 目录
		String dirPath = "/newsImg/"
				+ new SimpleDateFormat("yyyy/MM/dd").format(new Date());
		File dir = new File(getRequest().getServletContext().getRealPath(
				dirPath));
		if (!dir.exists()) {
			dir.mkdirs();
		}
		// 文件
		String fileName = StringUtils.generateRandomFileName(imgFileName);
		File file = new File(dir, fileName);
		// 保存文件
		FileUtils.copyFile(img, file);
		// 返回文件路径
		getWriter().write(dirPath + "/" + fileName);
	}

	/**
	 * ajax方式查询分页的新闻
	 * 
	 * @throws Exception
	 */
	public void ajaxListByPage() throws Exception {
		// 默认值
		if (page.getPageNo() == null) {
			page.setPageNo(1);
		}
		if (page.getPageSize() == null) {
			page.setPageSize(30);
		}
		// 查询
		page.setTotalItems(newsService.getTotalCount());
		page = newsService.findByPage(page);
		// 返回
		
		String str = JSONUtil.serialize(page, false);
		getWriter().write(str);
	}

	/**
	 * ajax方式根据类型查询分页的新闻
	 * 
	 * @throws Exception
	 */
	public void ajaxListByPageAndType() throws Exception {
		// 默认值
		if (page.getPageNo() == null) {
			page.setPageNo(1);
		}
		if (page.getPageSize() == null) {
			page.setPageSize(6);
		}
		if(type==null){
			type=1;
		}
		// 查询
		page = newsService.findByPageAndType(page,type);
		// 返回
		String str = JSONUtil.serialize(page,false);
		getWriter().write(str);
	}
	
	
	public void setType(Integer type) {
		this.type = type;
	}

	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}

	public void setImg(File img) {
		this.img = img;
	}

	public void setImgFileName(String imgFileName) {
		this.imgFileName = imgFileName;
	}

}
