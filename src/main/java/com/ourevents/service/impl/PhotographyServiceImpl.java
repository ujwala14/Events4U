package com.ourevents.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ourevents.dao.PhotographyDao;
import com.ourevents.model.Photography;
import com.ourevents.service.PhotographyService;

@Service
public class PhotographyServiceImpl implements PhotographyService {
	@Autowired
	PhotographyDao photographyDao;

	public void insertPhotography(Photography photography) {
		photographyDao.insertPhotography(photography);
	}

	public List<Photography> getAllPhotographys() {
		return photographyDao.getAllPhotographys();
	}

	@Override
	public List<String> getAllPhoNames() {
		// TODO Auto-generated method stub
		return photographyDao.getAllPhoNames();
	}

	@Override
	public String getPhoIdFromName(String n) {
		// TODO Auto-generated method stub
		return photographyDao.getPhoIdFromName(n);
	}

}
