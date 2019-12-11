package com.ourevents.dao;
import java.util.List;
import com.ourevents.model.Equipment;

public interface EquipmentDao {
	void insertEquipment(Equipment cus);
	List<Equipment> getAllEquipments();
	List<String> getAllEquipmentNames();
	String getEquipmentIdFromName(String n);
}