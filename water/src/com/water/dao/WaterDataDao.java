package com.water.dao;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.water.common.dao.BaseDaoImpl;
import com.water.model.WaterData;

@Repository
public class WaterDataDao extends  BaseDaoImpl<WaterData>{

	public WaterData findOneByDtuAndCreateTime(String dtu) {
		Query query = getSession().createQuery("from WaterData wd where dtu =? order by createTime desc");
		query.setString(0, dtu);
		return (WaterData) query.list().get(0);
	}



}
