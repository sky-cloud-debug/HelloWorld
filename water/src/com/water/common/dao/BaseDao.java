package com.water.common.dao;

import java.util.List;

import com.water.common.bean.Page;
import com.water.model.User;

/**
 * 
 * 类名: BaseDao<BR>
 * 描述: 基础Dao<BR>
 * 创建人:翟旭光 <BR>
 * 时间：2016年4月15日-上午10:54:51 <BR>
 * 
 * @version 1.0
 */
public interface BaseDao<T> {

	void save(T t);

	void saveList(List<T> list);

	void update(T t);

	void saveOrUpdate(T t);

	void delete(Integer id);

	void deleteList(List<Integer> idList);

	/**     */
	
	T findOneById(Integer id);

	List<T> findListByIdList(List<Integer> ids);

	Page<T> findByPage(Page<T> page);

	Long getTotalCount();

	String findValueByHql(String hql, Object... params);

}
