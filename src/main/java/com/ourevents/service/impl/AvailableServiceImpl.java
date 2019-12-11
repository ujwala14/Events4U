package com.ourevents.service.impl;

import java.util.List;

import com.ourevents.dao.AvailableDao;
import com.ourevents.model.Available;
import com.ourevents.service.AvailableService;

public class AvailableServiceImpl implements AvailableService {

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

}
