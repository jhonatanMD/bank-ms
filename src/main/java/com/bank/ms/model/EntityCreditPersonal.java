package com.bank.ms.model;

public class EntityCreditPersonal {
	
	
	private String codCur;
	
	private String numCredi;
	
	private Double cash;
	
	private Double cashPay;
	
	private HeadLineEntity  customer;
	
	private String status;

	public String getCodCur() {
		return codCur;
	}

	public void setCodCur(String codCur) {
		this.codCur = codCur;
	}

	public String getNumCredi() {
		return numCredi;
	}

	public void setNumCredi(String numCredi) {
		this.numCredi = numCredi;
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

	public HeadLineEntity getCustomer() {
		return customer;
	}

	public void setCustomer(HeadLineEntity customer) {
		this.customer = customer;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}







}
