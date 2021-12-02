package com.hospital.enumerations;

public enum OperationEnum {

	
	OPERATION1("OPERATION1",20000,false),
	OPERATION2("OPERATION2",30000,false),
	OPERATION3("OPERATION3",7000,true),
	OPERATION4("OPERATION4",13000,false);
	
	
	private String name;
	double price;
	boolean payBefore;
	
	OperationEnum(String name,double price,boolean payBefore) {
		this.name = name;
		this.price = price;
		this.payBefore = payBefore;
	}
	
	public String getName() {
		return name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public boolean getPayBefore() {
		return payBefore;
	}
}
