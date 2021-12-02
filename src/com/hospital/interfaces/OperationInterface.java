package com.hospital.interfaces;

import com.hospital.models.Operation;
import com.hospital.models.Patient;

import java.util.Optional;
import java.util.List;


public interface OperationInterface {

	public Optional<Operation> getOperationByRef(String ref);
	
	// Il faut v�rifier l'assurance du patient avant de passer l'op�ration
	public boolean verifyInsurance();
	
	// l'assurance rembourse un pourcentage de 70% si c'est CNSS et 80% pour RAMED et 100% pour CNOPS 
	public double calculateRsefund();
	
	
	// chaque op�ration a un prix, le patient doit payer le montant et apr�s l'hopital va lui remboursser (le cas du CNSS et CNOPS) , si RAMED le patient va juste 
		// payer la diff�rence d�s le d�but (20%)
	public double priceTopay();
	
	
	// Proposition : Ajouter un attribut portefeuille � la classe Patient pour g�rer le solde du patient, et du coup il faut avoir aussi une classe transaction qui tra�e les 
	// actions de payments avec la date...
	public void checkPayementStatus();
	
	

	// Apr�s le payement d'une op�ration et si c'est pass� avec succ�s le programme est termin�, sinon il faut renvoyer le montant vers la portefeuille patient
	

	// et dans ce cas son dossier est en stand by pour le discuter au tribunal. (vous devez g�rer les status de chaque op�ration)
	void exceedPayement();
	
	public void addOperation(List<Operation> operations);
	public void addToHospitalOparationList();

	void addToHospitalTopayOparationList();


	void addToHospitalCanceledOparationList();


	
}
