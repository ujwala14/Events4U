package com.ourevents.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ourevents.dao.ActorDao;
import com.ourevents.model.Actor;
import com.ourevents.service.ActorService;

@Service
public class ActorServiceImpl implements ActorService {
	@Autowired
	ActorDao actorDao;

	public void insertActor(Actor actor) {
		actorDao.insertActor(actor);
	}

	public List<Actor> getAllActors() {
		return actorDao.getAllActors();
	}

	@Override
	public List<String> getAllActorNames() {
		// TODO Auto-generated method stub
		return actorDao.getAllActorNames();
	}
}
