package com.allianz.order.person;

public class OrderPerson {
	
	private String name;
	private String mobile;
	
	public OrderPerson(String name, String mobile){
		this.name = name;
		this.mobile = mobile;
	}
	
	public OrderPerson(){

	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	

}
