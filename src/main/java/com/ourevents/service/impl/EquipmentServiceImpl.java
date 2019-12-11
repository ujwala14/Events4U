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
	@Override
	public List<String> getAllEquipmentNames() {
		// TODO Auto-generated method stub
		return equipmentDao.getAllEquipmentNames();
	}

	@Override
	public String getEquipmentIdFromName(String n) {
		// TODO Auto-generated method stub
		return equipmentDao.getEquipmentIdFromName(n);
	}
}
