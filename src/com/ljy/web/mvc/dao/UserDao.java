package com.ljy.web.mvc.dao;

import com.ljy.web.mvc.domain.User;

public interface UserDao {

	int regiest(User user);

	User findUser(String username, String password);

}
