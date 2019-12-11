package com.ourevents.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ourevents.dao.CateringDao;
import com.ourevents.model.Catering;
import com.ourevents.service.CateringService;

@Service
public class CateringServiceImpl implements CateringService {
	@Autowired
	CateringDao cateringDao;

	public void insertCatering(Catering catering) {
		cateringDao.insertCatering(catering);
	}

	public List<Catering> getAllCaterings() {
		return cateringDao.getAllCaterings();
	}

	@Override
	public List<String> getAllCateringNames() {
		// TODO Auto-generated method stub
		return cateringDao.getAllCateringNames();
	}

	@Override
	public String getCateringIdFromName(String n) {
		// TODO Auto-generated method stub
		return cateringDao.getCateringIdFromName(n);
	}

}
