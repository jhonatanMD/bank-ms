package com.bank.ms.model;

import org.springframework.data.annotation.Id;

public class EntityBusinessCredit {
	@Id
	private String codCur;
	
	private String numCred;
	
	private Double cash;
	
	private Double cashPay;
	
	private CustomerEntity  customer;
	

	private String status;
	
	public String getCodCur() {
		return codCur;
	}

	public void setCodCur(String codCur) {
		this.codCur = codCur;
	}

	public String getNumCred() {
		return numCred;
	}

	public void setNumCred(String numCred) {
		this.numCred = numCred;
	}

	public Double getCash() {
		return cash;
	}

	public void setCash(Double cash) {
		this.cash = cash;
	}

	public Double getCashPay() {
		return cashPay;
	}

	public void setCashPay(Double cashPay) {
		this.cashPay = cashPay;
	}

	public CustomerEntity getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}	
	
	
}
