package com.hospital.Impl;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.Scanner;

import com.hospital.enumerations.InsuranceType;
import com.hospital.enumerations.OperationEnum;
import com.hospital.enumerations.PayementEnum;
import com.hospital.helpers.HOutput;
import com.hospital.helpers.HValidateInput;
import com.hospital.interfaces.OperationInterface;
import com.hospital.models.Doctor;
import com.hospital.models.Hospital;
import com.hospital.models.Nurse;
import com.hospital.models.Operation;
import com.hospital.models.Patient;

public class OperationImpl implements OperationInterface{
	
	private static HashMap<String,List<Operation>> hospitalOperations = new HashMap<String,List<Operation>>();
	Scanner scan=new Scanner(System.in);
	private Operation operation; 
	
	
	
	public OperationImpl (String hospital,Doctor doctor,List<Nurse> nurses,OperationEnum operationsType,PayementEnum payementType,Patient patient,Date operationDate, Date operationPayementDate) {
		String reference=this.generateReference();
		this.operation=new  Operation( hospital, reference, doctor,nurses, operationsType, payementType, patient, operationDate,operationPayementDate);
	}
	
	
	
	@Override
	public Optional<Operation> getOperationByRef(String ref) {
		Optional<Operation> oper=null;
		for(Operation op:Hospital.getOperations()) {
			if(op.getReference().equals(ref)) {
				oper= Optional.ofNullable(op);
			}
		}		
		return oper;
	}

	
	@Override
	public void addOperation(List<Operation> operations) {
		// TODO Auto-generated method stub
		
	}
	

	
	@Override
	public boolean verifyInsurance() {
		
		if(this.operation.getPatient().getInsuranceType().getValue()==0) {
			return false;
		}
		else {
			return true;
		}
		
	}

	
	@Override
	public void addToHospitalOparationList() {
		Hospital.getOperations().add(operation);
		
	}

	@Override
	public void addToHospitalTopayOparationList() {
		Hospital.getToPayOperations().add(operation);
		
	}
	
	@Override
	public void addToHospitalCanceledOparationList() {
		Hospital.getCanceledOperations().add(operation);
		
	}
	
	@Override
	public double calculateRsefund() {
		if(this.verifyInsurance()) {
			if(this.operation.getPatient().getInsuranceType().equals(InsuranceType.RAMED)) {
				return 0;
			}
			return (this.operation.getprice() * this.operation.getPatient().getInsuranceType().getValue());
		}
		return 0;
	}

	
	
	@Override
	public double priceTopay() {
		if(this.operation.getPatient().getInsuranceType().equals(InsuranceType.RAMED)) {
			return this.operation.getprice()-(this.operation.getprice() * this.operation.getPatient().getInsuranceType().getValue());
		}
		return this.operation.getprice();		
	}
	
	@Override
	public void checkPayementStatus() {
		
		
	}
	@Override
	public void exceedPayement() {
		Date date = new Date();
		for(Operation op:Hospital.getOperations()) {
			if(op.getOperationPayementDate().compareTo(date)<0) {
				System.out.println("le patient "+op.getPatient()+" n as pas paye");
			}
		}
		
	}
	
	public String generateReference() {
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int length = 7;
        for(int i = 0; i < length; i++) {

            // generate random index number
            int index = random.nextInt(alphabet.length());
            // get character specified by index
            // from the string
            char randomChar = alphabet.charAt(index);

            // append the character to string builder
            sb.append(randomChar);
        }
        String randomString = sb.toString();
        return randomString;
	}
	
	
	public boolean hasEnoughMoney() {
		String addMoney="n";
		if(this.operation.getPayementType().equals(PayementEnum.Cash)) {
			if(this.priceTopay()>this.operation.getPatient().getWalletAmount()) {
				do {
					if(this.operation.getPatient().getInsuranceType().equals(InsuranceType.RAMED)) {
						HOutput.write("le montant que vous avez est insuffaisant l operation cout "+this.operation.getprice()+"\n puisque vous avavez RAMED vous n allez payer que "+this.priceTopay()+"\n\t vous avez que "+this.operation.getPatient().getWalletAmount()+" , a ajouter :"+(this.priceTopay()-this.operation.getPatient().getWalletAmount()));
					}
					else {
						HOutput.write("le montant que vous avez est insuffaisant l operation cout "+this.priceTopay()+"et vous avez que "+this.operation.getPatient().getWalletAmount()+" , a ajouter :"+(this.priceTopay()-this.operation.getPatient().getWalletAmount()));
					}
					
					HOutput.write("\n voulez vous ajouter de l argent ??");
					addMoney=scan.nextLine();
					if(addMoney.equalsIgnoreCase("O")) {
						this.operation.getPatient().setWalletAmount(HValidateInput.getDouble());
					}
				}while(this.priceTopay()>this.operation.getPatient().getWalletAmount() && addMoney.equalsIgnoreCase("O"));
			}
			else {
				return true;
			}
			if(this.priceTopay()>this.operation.getPatient().getWalletAmount()) {
				return false;
			}
			return true;
		}
		else {
			PatientImpl patientImp= new PatientImpl(operation.getPatient());
			if(this.priceTopay()>patientImp.transactionAmount()) {
				do {
					if(this.operation.getPatient().getInsuranceType().equals(InsuranceType.RAMED)) {
						HOutput.write("le montant que vous avez est insuffaisant l operation cout "+this.operation.getprice()+"\n puisque vous avavez RAMED vous n allez payer que "+this.priceTopay()+"\n\t vous avez que "+patientImp.transactionAmount()+" , a ajouter :"+(this.priceTopay()-patientImp.transactionAmount()));
					}
					else {
						HOutput.write("le montant que vous avez est insuffaisant l operation cout "+this.priceTopay()+"et vous avez que "+patientImp.transactionAmount()+" , a ajouter :"+(this.priceTopay()-patientImp.transactionAmount()));
					}
					
					HOutput.write("\n voulez-vous effuctuer une autre transaction ??");
					addMoney=scan.nextLine();
					if(addMoney.equalsIgnoreCase("O")) {
						TransactionImpl trImpl= new TransactionImpl();
						this.operation.getPatient().setTransactions(trImpl.addTransaction());
					}
				}while(this.priceTopay()>patientImp.transactionAmount() && addMoney.equalsIgnoreCase("O"));
				
				this.operation.setPatient(patientImp.getPatient());
			}
			else {
				return true;
			}
			if(this.priceTopay()>patientImp.transactionAmount()) {
				return false;
			}
			return true;
			
		}
		
	}
	

	public void payOperation() {
		if(this.operation.IsPayed()== false) {
			if(hasEnoughMoney()) {
				this.operation.getPatient().setWalletAmount(-(this.priceTopay()));
				this.operation.pay();
				addToHospitalOparationList();
				HOutput.write("payement effectuer le reste a reccuperé par le patient est de: "+this.operation.getPatient().getWalletAmount());
				HOutput.write(this.toString());
			}
			else {
				HOutput.write("Operation n est payer vous avez jusqu'a "+this.operation.getOperationDate()+" pour payer si non l operation va etre annuler\n\t prix a payer est "+this.priceTopay()+"DH\n\t reference d operation est: \" "+this.operation.getReference()+" \"");
				addToHospitalTopayOparationList();
			}
		}
		else {
			HOutput.write("Operation déja payé");
		}
	}
	
	public static void reserveOperationDate() {
		if(hospitalOperations.size()>0) {
			 boolean find=false;
			for (Map.Entry<String, List<Operation>> entry : hospitalOperations.entrySet()) {
			   
			    if( entry.getKey().equals(getDateOperation())) {
			    	//hospitalOperations.replace(entry.getKey(),entry.getValue().addAll(Hospital.getOperations()));
			    	find=true;
			    }
			}
			
			if(find == false) {
				hospitalOperations.put(getDateOperation(),Hospital.getOperations());
			}
			
		}
		else {
			hospitalOperations.put(getDateOperation(),Hospital.getOperations());
		}
		
	}
	
	
	public static String getDateOperation() {
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
		   LocalDateTime Tomorrow = LocalDateTime.now().plusDays(1);  
		   return dtf.format(Tomorrow);
	}
	@Override
	public String toString() {
		return "Operation programmer avec reference: "+this.operation.getReference()+" le : "+this.operation.getOperationDate()+" Montant a payer de :"+this.priceTopay()+ " DH vous serez remboursser de: "+this.calculateRsefund()+" DH de la part de "+this.operation.getPatient().getInsuranceType();
	}
}
