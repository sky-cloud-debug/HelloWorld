package com.water.common.service;

import java.util.List;

import com.water.common.bean.Page;

/**
 * 
 * 类名: BaseService<BR>
 * 描述: 基础Service<BR>
 * 创建人:翟旭光 <BR>
 * 时间：2016年4月15日-下午12:25:51 <BR>
 * @version 1.0
 */
public interface BaseService<T>{
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
}
