package com.water.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.water.common.bean.Page;
import com.water.dao.NewsDao;
import com.water.model.News;
import com.water.service.NewsService;

/**
 * 
 * 类名: NewsServiceImpl<BR>
 * 描述: 新闻服务实现类<BR>
 * 创建人:翟旭光 <BR>
 * 时间：2016年5月25日-下午12:41:12 <BR>
 * 
 * @version 1.0
 */
@Service
public class NewsServiceImpl extends MyBaseServiceImpl<News> implements
		NewsService {

	@Autowired
	private NewsDao newsDao;

	@Override
	public Page<News> findByPageAndType(Page<News> page, int type) {
		return newsDao.findByPageAndType(page, type);
	}
}
