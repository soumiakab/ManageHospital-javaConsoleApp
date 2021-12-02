package com.hospital.enumerations;

public enum OperationEnum {

	
	OPERATION_Gastroenterology("OPERATION_Gastroenterology",20000,OperationsTypeEnum.NORMAL,SpecialtyEnum.Gastroenterology,105),
	OPERATION_Cardiovascular("OPERATION_Cardiovascular",30000,OperationsTypeEnum.URGENT,SpecialtyEnum.Cardiovascular,240),
	OPERATION_Orthopedic("OPERATION_orthopedic",7000,OperationsTypeEnum.URGENT,SpecialtyEnum.Orthopedic,240),
	OPERATION_Ophthalmology("OPERATION_ophthalmology",13000,OperationsTypeEnum.NORMAL,SpecialtyEnum.Ophthalmology,90);
	
	
	private String name;
	double price;
	OperationsTypeEnum type;
	SpecialtyEnum specialty;
	int durationOpInMinutes;
	
	OperationEnum(String name,double price,OperationsTypeEnum type,SpecialtyEnum specialty,int durationOpInMinutes) {
		this.name = name;
		this.price = price;
		this.type = type;
		this.specialty=specialty;
		this.durationOpInMinutes= durationOpInMinutes;
	}
	
	public String getName() {
		return name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public OperationsTypeEnum  getPayBefore() {
		return type;
	}
	
	
	public SpecialtyEnum  getSpeciality() {
		return specialty;
	}
	
	
	public int getOperationDuration() {
		return durationOpInMinutes;
	}
	
	
}
