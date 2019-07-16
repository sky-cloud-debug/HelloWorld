package com.water.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.water.common.service.BaseServiceImpl;
import com.water.dao.UserDao;
import com.water.model.User;
import com.water.service.UserService;

@Service
public class UserServiceImpl extends  BaseServiceImpl<User> implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public User findByUsernameAndPassword(String username, String password) {
		return userDao.findByUsernameAndPassword(username,password);
	}
}
