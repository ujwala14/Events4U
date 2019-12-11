package com.ourevents.dao;

import com.ourevents.model.User;

public interface UserDao {
	void insertUser(User r);
	User getUserAfterLogin(String email,String pwd);
}
