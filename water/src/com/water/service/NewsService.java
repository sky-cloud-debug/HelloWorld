package com.water.service;

import com.water.common.bean.Page;
import com.water.model.News;

/**
 * 
 * 类名: NewsService<BR>
 * 描述: 新闻服务类<BR>
 * 创建人:翟旭光 <BR>
 * 时间：2016年5月25日-下午12:40:06 <BR>
 * @version 1.0
 */
public interface NewsService extends MyBaseService<News>{
	Page<News> findByPageAndType(Page<News> page,int type);
}
