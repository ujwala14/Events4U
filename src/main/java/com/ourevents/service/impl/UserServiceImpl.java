package com.ourevents.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ourevents.dao.UserDao;
import com.ourevents.model.User;
import com.ourevents.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao userDao;

	public void insertUser(User v) {
		userDao.insertUser(v);
	}

	@Override
	public User getUserAfterLogin(String email, String pwd) {
		// TODO Auto-generated method stub
		return userDao.getUserAfterLogin(email, pwd);
	}
}
