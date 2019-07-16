package com.water.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.water.common.bean.Page;
import com.water.common.dao.BaseDao;
import com.water.common.dao.BaseDaoImpl;
import com.water.model.Crop;
/**
 * 
 * 类名: CropDao<BR>
 * 描述: 作物Dao<BR>
 * 创建人:翟旭光 <BR>
 * 时间：2016年4月15日-下午12:22:51 <BR>
 * @version 1.0
 */
@Repository
public class CropDao extends BaseDaoImpl<Crop> implements BaseDao<Crop>{
	public Page<Crop> findCropListByAreaIdAndPage(Page<Crop> page, Integer areaId) {
		Long totalCount=getTotalCountByHql("select  count(*) from "+clazz.getSimpleName()+" a where a.area.id=?",areaId);
		page.setTotalItems(totalCount);
		
	    List<Crop> list = (List<Crop>) findListByHqlAndPage("from "+clazz.getSimpleName()+" a where a.area.id=?",page,areaId);
		page.setContent(list);
		return page;
	}

}