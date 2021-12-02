package com.hospital.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Hospital {

	private Long id;
	private String name;
	private String city;
	private static List<Doctor> doctors=new ArrayList<Doctor>();
	private static List<Room> rooms=new ArrayList<Room>();
	private static HashMap<String,List<Operation>> hospitalOperations = new HashMap<String,List<Operation>>();
	private static List<Operation> operations=new ArrayList<Operation>();
	private static List<Operation> canceledOperations=new ArrayList<Operation>();
	private static List<Operation> operationsTopay=new ArrayList<Operation>();
	private static List<Patient> patients=new ArrayList<Patient>();
	private static List<Nurse> hNurses=new ArrayList<Nurse> ();
	
	public Hospital() {
		
	}
	
	public Hospital(String name,String city) {
		this.id = 1L + (long) (Math.random() * (10L - 1L));
		this.name = name;
		this.city = city;
	}
	
	public Hospital(String name,String city,List<Doctor> doctorsH,List<Room> roomsH) {
		this.id = 1L + (long) (Math.random() * (10L - 1L));
		this.name = name;
		this.city = city;
		doctors = doctorsH;
		rooms = roomsH;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public static List<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<Doctor> doctorsH) {
		doctors = doctorsH;
	}

	public static List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> roomsH) {
		rooms = roomsH;
	}
	
	public static List<Operation> getOperations() {
		return operations;
	}
	
	
	public static List<Operation> getCanceledOperations() {
		return canceledOperations;
	}
	
	public static List<Operation> getToPayOperations() {
		return operationsTopay;
	}
	
	public static List<Patient> getpatients() {
		return patients;
	}
	
	public static List<Nurse> gethNurses() {
		return hNurses;
	}

	@Override
	public String toString() {
		return "Hospital [id=" + id + ", name=" + name + ", city=" + city + ", doctors=" + doctors + ", rooms=" + rooms
				+ "]";
	}
	
}
