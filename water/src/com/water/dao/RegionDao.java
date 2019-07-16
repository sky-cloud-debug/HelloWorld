package com.water.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.water.common.dao.BaseDao;
import com.water.common.dao.BaseDaoImpl;
import com.water.model.Crop;
import com.water.model.Region;

/**
 * 
 * 类名: RegionDao<BR>
 * 描述: 区域Dao<BR>
 * 创建人:翟旭光 <BR>
 * 时间：2016年4月15日-上午11:44:48 <BR>
 * @version 1.0
 */
@Repository
public class RegionDao extends BaseDaoImpl<Region> implements BaseDao<Region>{
	public List<Region> findRegionByCityName(String cityName){
		Session session=this.getSession();
		Query query=session.createQuery("from Region r where r.city = '"+cityName+"'");// where r.city = "+cityName
		return query.list();
		
	}
}