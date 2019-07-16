package com.water.dao;

import java.util.List;

import com.water.common.bean.Page;
import com.water.common.dao.BaseDao;
import com.water.common.dao.BaseDaoImpl;
import com.water.model.News;

public class MyBaseDaoImpl<T> extends BaseDaoImpl<T> implements BaseDao<T>{
	
	public Page<T> findListByRegionIdAndPage(Page<T> page, Integer regionId) {
		Long totalCount=getTotalCountByHql("select  count(*) from "+clazz.getSimpleName()+" a where a.region.id=?",regionId);
		page.setTotalItems(totalCount);
		
		List<T> list = findListByHqlAndPage("from "+clazz.getSimpleName()+" a where a.region.id=? order by createTime desc",page,regionId);
		
		page.setContent(list);
		return page;
	}
	public Page<T> findListByPlotName(Page<T> page, String plotName){
		if(plotName.equals("")){
			
		Long totalCount=getTotalCountByHql("select  count(*) from "+clazz.getSimpleName()+" a ");
		page.setTotalItems(totalCount);
		
		List<T> list = findListByHqlAndPage("from "+clazz.getSimpleName()+" a  order by createTime desc",page);
		
		page.setContent(list);}
		else{
		Long totalCount=getTotalCountByHql("select  count(*) from "+clazz.getSimpleName()+" a where a.plotIdd=?",plotName);
		page.setTotalItems(totalCount);
		
		List<T> list = findListByHqlAndPage("from "+clazz.getSimpleName()+" a where a.plotIdd=? order by createTime desc",page,plotName);
		
		page.setContent(list);
		}
		
		return page;
	}
	public Page<T> findListByPlotIdAndPage(Page<T> page, Integer plotId) {
		Long totalCount=getTotalCountByHql("select  count(*) from "+clazz.getSimpleName()+" a where plot_id=?",plotId);
		page.setTotalItems(totalCount);
		
		List<T> list = findListByHqlAndPage("from "+clazz.getSimpleName()+" a where plot_id=? order by createTime desc",page,plotId);
		
		page.setContent(list);
		return page;
	}
	public Page<T> findListByPlotIdAndPageAsc(Page<T> page, Integer plotId) {
		Long totalCount=getTotalCountByHql("select  count(*) from "+clazz.getSimpleName()+" a where plot_id=?",plotId);
		page.setTotalItems(totalCount);
		
		List<T> list = findListByHqlAndPage("from "+clazz.getSimpleName()+" a where plot_id=? order by createTime asc",page,plotId);
		
		page.setContent(list);
		return page;
	}


}
