package com.water.service;

import com.water.common.service.BaseService;
import com.water.model.User;

public interface UserService extends BaseService<User>{

	User findByUsernameAndPassword(String username, String password);

}
