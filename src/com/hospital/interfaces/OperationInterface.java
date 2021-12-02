package com.hospital.interfaces;

import com.hospital.models.Operation;
import com.hospital.models.Patient;

import java.util.Optional;
import java.util.List;


public interface OperationInterface {

	public Optional<Operation> getOperationByRef(String ref);
	
	// Il faut vérifier l'assurance du patient avant de passer l'opération
	public boolean verifyInsurance();
	
	// l'assurance rembourse un pourcentage de 70% si c'est CNSS et 80% pour RAMED et 100% pour CNOPS 
	public double calculateRsefund();
	
	
	// chaque opération a un prix, le patient doit payer le montant et après l'hopital va lui remboursser (le cas du CNSS et CNOPS) , si RAMED le patient va juste 
		// payer la différence dès le début (20%)
	public double priceTopay();
	
	
	// Proposition : Ajouter un attribut portefeuille à la classe Patient pour gérer le solde du patient, et du coup il faut avoir aussi une classe transaction qui traçe les 
	// actions de payments avec la date...
	public void checkPayementStatus();
	
	

	// Après le payement d'une opération et si c'est passé avec succès le programme est terminé, sinon il faut renvoyer le montant vers la portefeuille patient
	

	// et dans ce cas son dossier est en stand by pour le discuter au tribunal. (vous devez gérer les status de chaque opération)
	void exceedPayement();
	
	public void addOperation(List<Operation> operations);
	public void addToHospitalOparationList();

	void addToHospitalTopayOparationList();


	void addToHospitalCanceledOparationList();


	
}
