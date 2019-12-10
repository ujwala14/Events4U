package com.ourevents.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ourevents.dao.EquipmentDao;
import com.ourevents.model.Equipment;
import com.ourevents.service.EquipmentService;

@Service
public class EquipmentServiceImpl implements EquipmentService {
	@Autowired
	EquipmentDao equipmentDao;

	public void insertEquipment(Equipment equipment) {
		equipmentDao.insertEquipment(equipment);
	}

	public List<Equipment> getAllEquipments() {
		return equipmentDao.getAllEquipments();
	}

}
