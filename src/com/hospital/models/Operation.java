package com.hospital.models;

import java.util.Date;
import java.util.List;

import com.hospital.enumerations.OperationEnum;
import com.hospital.enumerations.PayementEnum;

public class Operation {

	// Une opération sera dans un hopital, dans une salle spécifique, et géré par un médecin X qui fait partie de l'hopital :)
	
	private String hospital;
	private String reference;
	private Room room;
	private Doctor doctor;
	// Ajouter une classe infirmière pour aider le médecin dans son travail
	private List<Nurse> nurses;
	private OperationEnum operationName;
	private double refund=0;
	private PayementEnum payementType;
	private boolean isPayed=false;
	private Patient patient;
	private Date operationDate;
	private Date operationPayementDate;
	private TimeSlot shiftSlot;
	//status
	//report
	public Operation(String hospital,String reference,Doctor doctor,List<Nurse> nurses,OperationEnum operationName,PayementEnum payementType,Patient patient,Date operationDate) {
	
		this.hospital = hospital;
		this.reference = reference;
		this.doctor = doctor;
		this.nurses = nurses;
		this.operationName = operationName;
		this.payementType = payementType;
		this.patient = patient;
		this.operationDate = operationDate;
	}
	
	public void setOperationDate(Date date) {
		this.operationDate=date;
	}
	
	public Date getOperationDate() {
		return this.operationDate;
	}
	
	public void setOperationPayementDate(Date date) {
		this.operationPayementDate=date;
	}
	
	public Date getOperationPayementDate() {
		return this.operationPayementDate;
	}
	
	public TimeSlot getShiftSlot() {
		return shiftSlot;
	}

	public void setShiftSlot(TimeSlot shiftSlot) {
		this.shiftSlot = shiftSlot;
	}
	
	public void setHospital(String hospital) {
		this.hospital=hospital;
	}
	
	public String getHospital() {
		return this.hospital;
	}
	
	public void setRoom(Room room) {
		this.room=room;
	}
	
	public Room getRoom() {
		return this.room;
	}
	
	
	public void pay() {
		this.isPayed=true;
	}
	
	public boolean IsPayed() {
		return this.isPayed;
	}
	
	
	public void setDoctor(Doctor doctor) {
		this.doctor=doctor;
	}
	
	public Doctor getDoctor() {
		return this.doctor;
	}
	
	
	public void setNurse(List<Nurse> nurse) {
		this.nurses=nurse;
	}
	
	public List<Nurse> getNurse() {
		return this.nurses;
	}
	
	
	public void setPatient(Patient patient) {
		this.patient=patient;
	}
	
	public Patient getPatient() {
		return this.patient;
	}
	
	public double getprice() {
		return this.operationName.getPrice();
	}
	
	public OperationEnum getOperationName() {
		return this.operationName;
	}
	
	public double getRefund( ) {
		return this.refund;
	}
	
	public String getReference( ) {
		return this.reference;
	}
	
	public void setReference(String ref) {
		this.reference=ref;
	}
	
	public PayementEnum getPayementType( ) {
		return this.payementType;
	}
	
	public void setPayementType(PayementEnum payementType) {
		this.payementType= payementType;
	}
	
	@Override
	public String toString() {
		return "Operation [reference=" + reference + ", patient=" + patient
				+ ", operation Date=" + operationDate + " à "+shiftSlot.getStartTime()+" jusqu'à "+shiftSlot.getEndTime()+" ]";
	}
	// Essayer de structurer votre travail avec la création des interfaces qui vous permettez d'implémenter les méthodes nécessaires.
	
}