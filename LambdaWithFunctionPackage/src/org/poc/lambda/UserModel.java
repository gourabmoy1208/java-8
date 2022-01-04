package org.poc.lambda;

public class UserModel {
	
	private String name;
	private String address;
	
	
	public UserModel(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "UserModel [name=" + name + ", address=" + address + "]";
	}
	

}
