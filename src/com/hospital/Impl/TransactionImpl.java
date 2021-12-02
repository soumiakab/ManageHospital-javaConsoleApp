package com.hospital.Impl;

import java.util.Date;

import com.hospital.helpers.HOutput;
import com.hospital.helpers.HValidateInput;
import com.hospital.models.Transaction;

public class TransactionImpl {

	Transaction transaction;
	
	public TransactionImpl() {
		this.transaction=new Transaction ();
	}
	
	
	public Transaction addTransaction() {
		HOutput.write("** entrer numero de transaction**");
		this.transaction.setTransactionNumber(HValidateInput.getDouble());
		
		HOutput.write("** entrer le montant de transaction**");
		this.transaction.setTransactionAmout(HValidateInput.getDouble());
		this.transaction.setTransactionDate(new Date());
		
		return this.transaction;
	}
	
}
