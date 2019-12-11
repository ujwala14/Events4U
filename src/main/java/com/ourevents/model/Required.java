package com.ourevents.model;

public class Required {	

	String evenID;
	String equipID;
	int quantity_req;
	
	public String getEvenID() {
		return evenID;
	}

	public void setEvenID(String evenID) {
		this.evenID = evenID;
	}

	public String getEquipID() {
		return equipID;
	}

	public void setEquipID(String equipID) {
		this.equipID = equipID;
	}

	public int getQuantity_req() {
		return quantity_req;
	}

	public void setQuantity_req(int quantity_req) {
		this.quantity_req = quantity_req;
	}
	
	@Override
	public String toString() {
		return "Required [eventID=" + evenID + ", equipmentID=" + equipID + ", quantityRequired=" + quantity_req + "]";
	}
}
