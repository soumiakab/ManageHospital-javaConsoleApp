package com.hospital.models;

import java.util.Date;

public class Transaction {

	private double transactionNumber;
	private double transactionAmout;
	private Date  transactionDate;
	
	public Transaction() {
		
	}
	public Transaction(int transactionNumber,double transactionAmout,Date  transactionDate) {
		this.transactionNumber = transactionNumber;
		this.transactionAmout = transactionAmout;
		this.transactionDate = transactionDate;
	}

	
	public double getTransactionNumber() {
		return this.transactionNumber;
	}
	
	

	public void setTransactionNumber(double transactionNumber) {
		this.transactionNumber = transactionNumber;
	}
	
	
	
	public double getTransactionAmout() {
		return this.transactionAmout;
	}
	
	

	public void setTransactionAmout(double transactionAmout) {
		this.transactionAmout = transactionAmout;
	}
	
	
	
	public Date getTransactionDate() {
		return this.transactionDate;
	}

	
	
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
}
