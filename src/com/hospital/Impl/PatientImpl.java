package com.hospital.Impl;

import java.util.Date;
import java.util.List;

import com.hospital.enumerations.InsuranceType;
import com.hospital.helpers.HOutput;
import com.hospital.interfaces.PatientInterface;
import com.hospital.models.Hospital;
import com.hospital.models.Patient;
import com.hospital.models.Transaction;

public class PatientImpl implements PatientInterface {

	private Patient pt ;
	
	public PatientImpl(String firstname,String lastname,String phone,String address,Date hospitalEntryDate,String affiliationNumber,InsuranceType insuranceType) {
		this.pt=new Patient(firstname,lastname,phone,address,hospitalEntryDate,affiliationNumber,insuranceType);
		addPatient();
	}
	public PatientImpl(Patient patient) {
		this.pt=patient;
	}
	
	@Override
	public void addPatient() {
		Hospital.getpatients().add(pt);
	}
	

	@Override
	public Patient getPatient() {
		return this.pt;
		
	}

	@Override
	public List<Patient> getAllPatient() {		
		return Hospital.getpatients();
	}
	
	public void addAmountTowallet() {
		
	}
	
	public double transactionAmount() {
		double transactionAmount=0;
		if(pt.getTransactions().size()>0) {
			for(Transaction tr:pt.getTransactions()) {
				transactionAmount+=tr.getTransactionAmout();
			}						
		}
		return transactionAmount;
	}
	
	
	
}
