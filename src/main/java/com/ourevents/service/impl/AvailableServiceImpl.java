package com.ourevents.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ourevents.dao.AvailableDao;
import com.ourevents.model.Available;
import com.ourevents.service.AvailableService;

@Service
public class AvailableServiceImpl implements AvailableService {
	@Autowired
	AvailableDao availDao;
	@Override
	public void insertAvailable(Available a) {
		// TODO Auto-generated method stub
		availDao.insertAvailable(a);
	}

	@Override
	public List<Available> getAllAvailables() {
		// TODO Auto-generated method stub
		return availDao.getAllAvailables();
	}

	@Override
	public Available getAvailableById(String n) {
		// TODO Auto-generated method stub
		return availDao.getAvailableById(n);
	}

}
