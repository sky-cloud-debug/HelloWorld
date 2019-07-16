package com.water.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.water.common.bean.Page;
import com.water.common.dao.BaseDao;
import com.water.common.dao.BaseDaoImpl;
import com.water.model.Area;

/**
 * 
 * 类名: AreaDao<BR>
 * 描述: 田地dao<BR>
 * 创建人:翟旭光 <BR>
 * 时间：2016年4月15日-下午12:22:25 <BR>
 * 
 * @version 1.0
 */
@Repository
public class AreaDao extends MyBaseDaoImpl<Area> implements BaseDao<Area> {
}
