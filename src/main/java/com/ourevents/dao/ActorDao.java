package com.ourevents.dao;
import java.util.List;
import com.ourevents.model.Actor;

public interface ActorDao {
	void insertActor(Actor cus);
	List<Actor> getAllActors();
	List<String> getAllActorNames();
}