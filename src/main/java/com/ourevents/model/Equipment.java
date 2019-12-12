package com.ourevents.model;

public class Equipment {
	
	String equipID;
	String equipName;
	
	public String getEquipID() {
		return equipID;
	}
	public void setEquipID(String equipID) {
		this.equipID = equipID;
	}
	public String getEquipName() {
		return equipName;
	}
	public void setEquipName(String equipName) {
		this.equipName = equipName;
	}
	
	@Override
	public String toString() {
		return "Equipment [equipmentID=" + equipID + ", equipmentName=" + equipName +  "]";
	}
}
