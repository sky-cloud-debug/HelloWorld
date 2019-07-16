package com.water.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.water.common.dao.BaseDao;
import com.water.common.dao.BaseDaoImpl;
import com.water.model.City;
import com.water.model.County;
import com.water.model.Crop;
import com.water.model.Region;

/**
 * 
 * 类名: CityDao<BR>
 * 描述: 城市Dao<BR>
 * 创建人:毕燕东 <BR>
 * 时间：2017年8月12日 <BR>
 * @version 1.0
 */
@Repository
public class CityDao extends BaseDaoImpl<City> implements BaseDao<City>{
}