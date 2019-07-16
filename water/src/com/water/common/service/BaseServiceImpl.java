package com.water.common.service;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.water.common.bean.Page;
import com.water.common.dao.BaseDao;

/**
 * 
 * 类名: BaseServiceImpl<BR>
 * 描述: 基础服务类<BR>
 * 创建人:翟旭光 <BR>
 * 时间：2016年4月15日-下午12:27:34 <BR>
 * @version 1.0
 */
@Transactional
public class BaseServiceImpl<T> implements BaseService<T>{

	@Autowired
	protected BaseDao<T> dao;
	
	protected Class<T> clazz;

	{
		Type type = this.getClass().getGenericSuperclass();
		if (type instanceof ParameterizedType) {
			ParameterizedType pt = (ParameterizedType) type;
			clazz = (Class<T>) pt.getActualTypeArguments()[0];
		}
	}

	@Override
	public void save(T t) {
		dao.save(t);
	}

	@Override
	public void saveList(List<T> list) {
		dao.saveList(list);
	}

	@Override
	public void update(T t) {
		dao.update(t);
	}

	@Override
	public void saveOrUpdate(T t) {
		dao.saveOrUpdate(t);
	}

	@Override
	public void delete(Integer id) {
		dao.delete(id);
	}

	@Override
	public void deleteList(List<Integer> idList) {
		dao.deleteList(idList);
	}

	@Override
	public T findOneById(Integer id) {
		return dao.findOneById(id);
	}

	@Override
	public List<T> findListByIdList(List<Integer> ids) {
		return dao.findListByIdList(ids);
	}

	@Override
	public Page<T> findByPage(Page<T> page) {
		return dao.findByPage(page);
	}

	@Override
	public Long getTotalCount() {
		return dao.getTotalCount();
	}

	public String findValueByHql(String hql,Object...params){
		return dao.findValueByHql(hql,params);
	}
}
