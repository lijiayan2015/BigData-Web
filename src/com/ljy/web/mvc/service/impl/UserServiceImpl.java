package com.ljy.web.mvc.service.impl;

import com.ljy.web.mvc.dao.UserDao;
import com.ljy.web.mvc.dao.impl.UserDaoImpl;
import com.ljy.web.mvc.domain.User;
import com.ljy.web.mvc.service.UserService;

public class UserServiceImpl implements UserService {
	UserDao dao = new UserDaoImpl();
	@Override
	public int regiester(User user) {
		
		return dao.regiest(user);
	}

}
