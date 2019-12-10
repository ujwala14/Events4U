package com.ourevents.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ourevents.dao.DirectDao;
import com.ourevents.model.Direct;
import com.ourevents.service.DirectService;

@Service
public class DirectServiceImpl implements DirectService {
	@Autowired
	DirectDao directDao;

	public void insertDirect(Direct direct) {
		directDao.insertDirect(direct);
	}

	public List<Direct> getAllDirects() {
		return directDao.getAllDirects();
	}

	@Override
	public List<Direct> getDirectByMovie(String mid) {
		// TODO Auto-generated method stub
		return directDao.getDirectByMovie(mid);
	}

	@Override
	public String getDirectorIdFromName(String dn) {
		// TODO Auto-generated method stub
		return directDao.getDirectorIdFromName(dn);
	}

}
