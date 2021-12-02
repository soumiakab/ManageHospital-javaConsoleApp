package com.hospital.models;

import com.hospital.enumerations.SpecialtyEnum;

public class Doctor extends Person{

	private String professionNumber;
	private TimeSlot shiftSlot;
	private double salary;
	private SpecialtyEnum doctorSpecialty;
	
	public Doctor() {
		
	}
	public Doctor(String firstname,String lastname,String phone,String address,String professionNumber,SpecialtyEnum doctorSpecialty,TimeSlot shiftSlot,double salary) {
		super(firstname,lastname,phone,address);
		this.professionNumber = professionNumber;
		this.doctorSpecialty =  doctorSpecialty;
		this.shiftSlot = shiftSlot;
		this.salary = salary;
	}

	public String getProfessionNumber() {
		return professionNumber;
	}

	public void setProfessionNumber(String professionNumber) {
		this.professionNumber = professionNumber;
	}
	
	public SpecialtyEnum getDoctorSpecialty() {
		return this.doctorSpecialty;
	}

	public void setDoctorSpecialty(SpecialtyEnum doctorSpecialty) {
		this.doctorSpecialty =  doctorSpecialty;
	}
  
	public TimeSlot getShiftSlot() {
		return shiftSlot;
	}

	public void setShiftSlot(TimeSlot shiftSlot) {
		this.shiftSlot = shiftSlot;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Doctor [professionNumber=" + professionNumber + ", shiftSlot=" + shiftSlot + ", salary=" + salary + "]";
	}
	
}
