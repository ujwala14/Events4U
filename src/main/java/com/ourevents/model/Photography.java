package com.ourevents.model;

public class Photography {
	
	String phoID;
	String phoName;
	String phoContNo;
	
	public String getPhoID() {
		return phoID;
	}

	public void setPhoID(String phoID) {
		this.phoID = phoID;
	}

	public String getPhoName() {
		return phoName;
	}

	public void setPhoName(String phoName) {
		this.phoName = phoName;
	}

	public String getPhoContNo() {
		return phoContNo;
	}

	public void setPhoContNo(String phoContNo) {
		this.phoContNo = phoContNo;
	}	
	
	@Override
	public String toString() {
		return "Photography [photographerID=" + phoID + ", photographerName=" + phoName + ", photographer ContactNo=" + phoContNo + "]";
	}
}
