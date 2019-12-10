package com.ourevents.model;

public class Equipment {
	
	String equipID;
	String equipName;
	int quantity_avai;
	
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
	public int getQuantity_avai() {
		return quantity_avai;
	}
	public void setQuantity_avai(int quantity_avai) {
		this.quantity_avai = quantity_avai;
	}
	
	@Override
	public String toString() {
		return "Equipment [equipmentID=" + equipID + ", equipmentName=" + equipName + ", quantityAvailable=" + quantity_avai + "]";
	}
}
