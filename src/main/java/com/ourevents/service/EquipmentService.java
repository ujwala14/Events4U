package com.ourevents.service;
import java.util.List;

import com.ourevents.model.Equipment;

public interface EquipmentService {
	void insertEquipment(Equipment equi);
	List<Equipment> getAllEquipments();
	List<String> getAllEquipmentNames();
	String getEquipmentIdFromName(String n);
}
