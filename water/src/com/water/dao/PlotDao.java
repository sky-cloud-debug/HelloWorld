package com.water.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.water.common.dao.BaseDao;
import com.water.common.dao.BaseDaoImpl;
import com.water.model.County;
import com.water.model.Crop;
import com.water.model.Plot;
import com.water.model.Region;

/**
 * 
 * 类名: CountyDao<BR>
 * 描述: 站点Dao<BR>
 * 创建人:毕燕东 <BR>
 * 时间：2017年8月12日 <BR>
 * @version 1.0
 */
@Repository
public class PlotDao extends BaseDaoImpl<Plot> implements BaseDao<Plot>{
	public List<Plot> findPlotListByCountyId(Integer countyId){
		Session session=this.getSession();
		Query query=session.createQuery("from Plot p where p.county.id = '"+countyId+"'");
		return query.list();
		
	}
}