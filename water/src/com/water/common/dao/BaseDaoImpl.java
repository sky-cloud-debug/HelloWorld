package com.water.common.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.water.common.bean.Page;

/**
 * 
 * 类名: BaseDaoImpl<BR>
 * 描述: BaseDao实现类<BR>
 * 创建人:翟旭光 <BR>
 * 时间：2016年4月15日-上午11:04:02 <BR>
 * 
 * @version 1.0
 */
public class BaseDaoImpl<T> implements BaseDao<T> {

	@Autowired
	protected SessionFactory sessionFactory;

	protected Class<T> clazz;

	{
		Type type = this.getClass().getGenericSuperclass();
		if (type instanceof ParameterizedType) {
			ParameterizedType pt = (ParameterizedType) type;
			clazz = (Class<T>) pt.getActualTypeArguments()[0];
		}
	}

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void save(T t) {
		getSession().save(t);
	}

	public void saveList(List<T> list) {
		Session session = getSession();
		for (int i = 0; i < list.size(); i++) {
			session.save(list.get(i));
			if (i % 10 == 0) {
				session.flush();
			}
		}
	}

	public void update(T t) {
		getSession().update(t);
	}

	public void saveOrUpdate(T t) {
		getSession().saveOrUpdate(t);
	}

	public void delete(Integer id) {
		T t = (T) getSession().get(clazz, id);
		getSession().delete(t);
	}

	public void deleteList(List<Integer> idList) {
		Session session = getSession();
		for (Integer id : idList) {
			T t = (T) getSession().get(clazz, id);
			session.delete(t);
		}
	}

	public T findOneById(Integer id) {
		return (T) getSession().get(clazz, id);
	}

	public List<T> findListByIdList(List<Integer> ids) {
		Query query = getSession().createQuery(
				"from " + clazz.getSimpleName() + " where id in :ids");
		query.setParameterList("ids", ids);
		return query.list();
	}

	public Page<T> findByPage(Page<T> page) {
		Session session = getSession();
		// 查询总数
		page.setTotalItems(getTotalCount());

		// 查询本页内容
		Query itemsQuery = session.createQuery("from " + clazz.getSimpleName()+" c order by c.createTime desc");
		itemsQuery.setFirstResult((page.getPageNo() - 1) * page.getPageSize());
		itemsQuery.setMaxResults(page.getPageSize());
		page.setContent(itemsQuery.list());
		return page;
	}

	public Long getTotalCount() {
		Query totalCountQuery = getSession().createQuery(
				"select count(t) from " + clazz.getSimpleName() + " t");
		Long totalCount = (Long) totalCountQuery.uniqueResult();
		return totalCount;
	}

	public Long getTotalCountByHql(String hql, Object... params) {
		Query totalCountQuery = getSession().createQuery(hql);
		for (int i = 0; i < params.length; i++) {
			totalCountQuery.setParameter(i, params[i]);
		}
		Long totalCount = (Long) totalCountQuery.uniqueResult();
		return totalCount;
	}

	protected T findOneByHql(String hql, Object... params) {
		Query query = getSession().createQuery(hql);
		for (int i = 0; i < params.length; i++) {
			query.setParameter(i, params[i]);
		}
		return (T) query.uniqueResult();
	}

	public List<T> findListByHql(String hql, Object... params) {
		Query query = getSession().createQuery(hql);
		for (int i = 0; i < params.length; i++) {
			query.setParameter(i, params[i]);
		}
		return query.list();
	}

	public List<T> findListByHqlAndPage(String hql, Page<?> page,
			Object... params) {
		// 查询本页内容
		Query query = getSession().createQuery(hql);
		for (int i = 0; i < params.length; i++) {
			query.setParameter(i, params[i]);
		}
		query.setFirstResult((page.getPageNo()-1)*page.getPageSize());
		query.setMaxResults(page.getPageSize());
		return query.list();
	}

	@Override
	public String findValueByHql(String hql, Object... params) {
		Query query = getSession().createQuery(hql);
		for (int i = 0; i < params.length; i++) {
			query.setParameter(i, params[i]);
		}
		return query.uniqueResult()+"";
	}
	
	
	public String findValueByHqlAndPage(String hql, int pageNo, int pageSize,Object...params) {
		Query query = getSession().createQuery(hql);
		for (int i = 0; i < params.length; i++) {
			query.setParameter(i, params[i]);
		}
		query.setFirstResult((pageNo-1)*pageSize);
		query.setMaxResults(pageSize);
		return query.uniqueResult()+"";
	}
	
}
