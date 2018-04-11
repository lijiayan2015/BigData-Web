package com.ljy.web.mvc.service;

import com.ljy.web.mvc.domain.User;

public interface UserService {

	int regiester(User user);

	User findUser(String username, String password);

}
