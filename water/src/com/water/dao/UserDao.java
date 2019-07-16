package com.water.dao;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.water.common.dao.BaseDao;
import com.water.common.dao.BaseDaoImpl;
import com.water.model.User;

/**
 * 
 * 类名: UserDao<BR>
 * 描述: 用户Dao<BR>
 * 创建人:翟旭光 <BR>
 * 时间：2016年4月15日-上午11:44:18 <BR>
 * @version 1.0
 */
@Repository
public class UserDao extends BaseDaoImpl<User> implements BaseDao<User>{

	public User findByUsernameAndPassword(String username, String password){
		Query query = getSession().createQuery("from User u where u.username=? and u.password=?");
		query.setString(0, username);
		query.setString(1,password);
		return (User) query.uniqueResult();
	}
}
