package com.water.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.water.common.dao.BaseDao;
import com.water.common.dao.BaseDaoImpl;
import com.water.model.County;
import com.water.model.Crop;
import com.water.model.Region;

/**
 * 
 * 类名: CountyDao<BR>
 * 描述: 县/乡镇Dao<BR>
 * 创建人:毕燕东 <BR>
 * 时间：2017年8月12日 <BR>
 * @version 1.0
 */
@Repository
public class CountyDao extends BaseDaoImpl<County> implements BaseDao<County>{
	public List<County> findCountyListByRegionId(Integer regionId){
		Session session=this.getSession();
		Query query=session.createQuery("from County c where c.region.id = '"+regionId+"'");
		return query.list();
		
	}
}