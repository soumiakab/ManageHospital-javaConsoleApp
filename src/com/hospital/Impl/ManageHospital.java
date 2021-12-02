package com.hospital.Impl;

import com.hospital.helpers.HOutput;
import com.hospital.helpers.HValidateInput;
import com.hospital.models.Doctor;
import com.hospital.models.Hospital;
import com.hospital.models.Nurse;
import com.hospital.models.Room;
import com.hospital.models.TimeSlot;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.hospital.enumerations.InsuranceType;
import com.hospital.enumerations.OperationEnum;
import com.hospital.enumerations.PayementEnum;

public class ManageHospital {
	
	static Scanner scan= new Scanner(System.in);
	
	static Hospital hospital= new Hospital("Menara","Marrakech");
	//static List<OperationEnum> opertionsNames= new ArrayList<OperationEnum>();
	 static OperationEnum[] opertionsNames=OperationEnum.values();
	 static PayementEnum[] payementChooses=PayementEnum.values();
	 static InsuranceType[] insuranceTypes=InsuranceType.values();
	 
	public static void initApp() {
		initHospitalDoctors();
		initNurses();
		initHospitalRooms();
		menu();
	}
	
	
	public static void  menu() {
		
		HOutput.write("welcome to *****");
		HOutput.write("\t1-Inscription patient\n");
		HOutput.write("\t2-les operations programmer\n");
		HOutput.write("\t3-infos d' operation \n");
		HOutput.write("\t4-payement\n");
		HOutput.write("\t5-ajouter un medecin \n");
		HOutput.write("\t6-ajouter une infermiere\n");
		HOutput.write("\t7-les salles d operation disponibles\n");
		HOutput.write("\t8-nos medecins \n");
		HOutput.write("\t9-Recuperer argent assurance \n");
		HOutput.write("\t10-nos infermieres\n");
		HOutput.write("\t11-Liste des patients\n");
		chooseMethod(HValidateInput.getInteger());
		
	}
	
	
	
	
	public static void chooseMethod(int choose) {
		switch(choose) {
		case 0:scheduleAnOperation();
		menu();
			break;
		case 1:showHOpeartion();
		menu();
			break;
			
		case 2:getPatientByRef();
				menu();
			break;
		case 3:HOutput.write(OperationImpl. getDateOperation());
			payOperation();
				menu();
			break;
		case 4:addDoctor();
			menu();
			break;
		case 5:addNurse();
			menu();
			break;
		case 6:availableRoom();
			menu();
			break;
		case 7:doctors();
			menu();
			break;
		case 8:refundInsurance();
			menu();
			break;
		case 9:nurses();
			menu();
			break;
		case 10:showHPatients();
			menu();
			break;
		default: menu();
			break;					
		}
		
	}
	
	
	public static void initHospitalDoctors() {
		Hospital.getDoctors().add(new Doctor("khalid","benjloun","+2126-56767854","23 rue xxx","A001",new TimeSlot(8,20),20000));
		Hospital.getDoctors().add(new Doctor("omar","tazi","+2126-56767854","23 rue xxx","A002",new TimeSlot(8,20),20000));
		Hospital.getDoctors().add(new Doctor("ahemad","malik","+2126-56767854","23 rue xxx","A003",new TimeSlot(8,20),20000));
		Hospital.getDoctors().add(new Doctor("hassan","rami","+2126-56767854","23 rue xxx","A004",new TimeSlot(8,20),20000));
		Hospital.getDoctors().add(new Doctor("meryem","moetaz","+2126-56767854","23 rue xxx","A005",new TimeSlot(8,20),20000));
		Hospital.getDoctors().add(new Doctor("ghita","elIdressi","+2126-56767854","23 rue xxx","A006",new TimeSlot(8,20),20000));
		
	}
	
	public static void initHospitalRooms() {
		Hospital.getRooms().add(new Room(1,0));
		Hospital.getRooms().add(new Room(2,1));
		Hospital.getRooms().add(new Room(3,1));
		Hospital.getRooms().add(new Room(7,2));
		Hospital.getRooms().add(new Room(6,3));
		Hospital.getRooms().add(new Room(4,3));
				
	}
	
	
	public static void initNurses() {
		Hospital.gethNurses().add(new Nurse("khalid","benjloun","+2126-56767854","23 rue xxx","A001",new TimeSlot(8,22),20000));
		Hospital.gethNurses().add(new Nurse("khalid","benjloun","+2126-56767854","23 rue xxx","A001",new TimeSlot(8,22),20000));
		Hospital.gethNurses().add(new Nurse("khalid","benjloun","+2126-56767854","23 rue xxx","A001",new TimeSlot(8,22),20000));
		Hospital.gethNurses().add(new Nurse("khalid","benjloun","+2126-56767854","23 rue xxx","A001",new TimeSlot(8,22),20000));
		Hospital.gethNurses().add(new Nurse("khalid","benjloun","+2126-56767854","23 rue xxx","A001",new TimeSlot(8,22),20000));
				
	}
	
	public static PatientImpl patientInfo() {
		Date hospitalEntryDate=new Date();	
		HOutput.write("Entrer le nom ");
		String lastname=scan.nextLine();
		HOutput.write("Entrer le prenom ");
		String firstname=scan.nextLine();
		HOutput.write("Entrer le numero de telephone ");
		String phone=scan.nextLine();
		HOutput.write("Entrer l adress ");
		String address=scan.nextLine();
		HOutput.write("Entrer le num�ro d'affiliation ");
		String affiliationNumber=scan.nextLine();
		HOutput.write("choisir le type d assurance");
		HOutput.showList(insuranceTypes);
		InsuranceType insuranceType=insuranceTypes[HValidateInput.getInteger()];
		PatientImpl patientImpl = new PatientImpl( firstname, lastname, phone, address, hospitalEntryDate, affiliationNumber, insuranceType);
		
		return patientImpl;
	}
	
	public static void scheduleAnOperation() {
		
		PatientImpl patientImpl=patientInfo();
		
		HOutput.write("**choisir l operation **");
		HOutput.showList(OperationEnum.values());
		OperationEnum operationsType=opertionsNames[HValidateInput.getInteger()];
		
		HOutput.write("**choisir un medecin**");
		HOutput.showList(Hospital.getDoctors());
		Doctor doctor=Hospital.getDoctors().get(HValidateInput.getInteger());
		
		List<Nurse> nurses=new ArrayList<Nurse>();
		HOutput.write("**choisir une infermiere**");
		HOutput.showList(Hospital.gethNurses());
		nurses.add(Hospital.gethNurses().get(HValidateInput.getInteger()));
		String addNurse="n";
		do {						
			HOutput.write("\n voulez vous ajouter un(e) autre infermi(ere) ??");
			addNurse=scan.nextLine();
			if(addNurse.equalsIgnoreCase("O")) {
				HOutput.write("\n entrer le num�ro associer a l infermi(ere)");
				nurses.add(Hospital.gethNurses().get(HValidateInput.getInteger()));
			}
		}while(addNurse.equalsIgnoreCase("O"));
					
		HOutput.write("**choisir le type de payement **");
		HOutput.showList(PayementEnum.values());
		PayementEnum payementChoose=payementChooses[HValidateInput.getInteger()];
		
		if(payementChoose.equals(PayementEnum.Cash))
		{
			HOutput.write("**Le montant que vous avez est de ? **");
			patientImpl.getPatient().setWalletAmount(HValidateInput.getDouble());
			
		}
		
		Date operationDate=new Date();
		Date operationPayementDate=new Date();
		
		OperationImpl opImpl=new OperationImpl(hospital.getName(),doctor,nurses,operationsType,payementChoose,patientImpl.getPatient(),operationDate,operationPayementDate);
		opImpl.payOperation();
		
		
	}
	
	
	public static void showHOpeartion() {
		if(Hospital.getOperations().size() == 0) {
			HOutput.write("Liste des operations est vide ");
			
		}else {
			HOutput.showList(Hospital.getOperations());
		}
		
	}

	
	public static void showHPatients() {
		
		if(Hospital.getpatients().size() == 0) {
			HOutput.write("Liste des patients est vide ");
			
		}else {
			HOutput.showList(Hospital.getpatients());
		}
	}
		
	
	public static void getPatientByRef() {
		
	}
	
	
	public static void payOperation() {
		
	}
	
	public static void addDoctor() {
		
	}
	
	public static void addNurse() {
		
	}
	
	public static void availableRoom() {
		
	}
	
	public static void doctors() {
		if(Hospital.getpatients().size() == 0) {
			HOutput.write("Liste des patients est vide ");
			
		}else {
			HOutput.showList(Hospital.getpatients());
		}
		
	}
	
	
	public static void nurses() {
		if(Hospital.getpatients().size() == 0) {
			HOutput.write("Liste des patients est vide ");
			
		}else {
			HOutput.showList(Hospital.getpatients());
		}
	}
	
	
	public static void refundInsurance() {
		
	}
	
	//change Operation status
}