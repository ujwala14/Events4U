package com.ourevents.service;

import com.ourevents.model.User;

public interface UserService {
	void insertUser(User r);
	User getUserAfterLogin(String email,String pwd);
}
