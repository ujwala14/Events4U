package com.ourevents.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ourevents.dao.CastDao;
import com.ourevents.model.Cast;
import com.ourevents.service.CastService;

@Service
public class CastServiceImpl implements CastService {
	@Autowired
	CastDao castDao;

	public void insertCast(Cast cast) {
		castDao.insertCast(cast);
	}

	public List<Cast> getAllCasts() {
		return castDao.getAllCasts();
	}

	@Override
	public List<Cast> getCastByMovie(String mid) {
		// TODO Auto-generated method stub
		return castDao.getCastByMovie(mid);
	}

	@Override
	public String getActorIdFromName(String an) {
		// TODO Auto-generated method stub
		return castDao.getActorIdFromName(an);
	}
}
