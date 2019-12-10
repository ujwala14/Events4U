package com.ourevents.service;
import java.util.List;

import com.ourevents.model.Actor;

public interface ActorService {
	void insertActor(Actor movie);
	List<Actor> getAllActors();
	List<String> getAllActorNames();
}
