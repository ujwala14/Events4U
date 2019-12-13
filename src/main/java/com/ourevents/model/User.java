package com.ourevents.model;

public class User {
	@Override
	public String toString() {
		return "User [userName=" + userName + ", phoneNo=" + 
				phoneNo + ", email=" + email + ", pwd=" + pwd + ", age="
				+ age + "]";
	}
	String userName,phoneNo,email,pwd;
	int age;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
