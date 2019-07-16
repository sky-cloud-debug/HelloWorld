package com.water.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.water.common.bean.Page;
import com.water.common.dao.BaseDao;
import com.water.model.News;

/**
 * 
 * 类名: NewsDao<BR>
 * 描述: 新闻Dao<BR>
 * 创建人:翟旭光 <BR>
 * 时间：2016年5月25日-下午12:38:03 <BR>
 * @version 1.0
 */
@Repository
public class NewsDao extends MyBaseDaoImpl<News> implements BaseDao<News> {

	
	public Page<News> findByPageAndType(Page<News> page, int type) {
		Long totalCount=getTotalCountByHql("select  count(*) from News n where n.type=?",type);
		page.setTotalItems(totalCount);
		
		List<News> list = findListByHqlAndPage("from News n where n.type=? order by createTime desc",page,type);
		page.setContent(list);
		return page;
	}
}
