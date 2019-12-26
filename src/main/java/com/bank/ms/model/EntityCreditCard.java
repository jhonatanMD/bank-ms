package com.bank.ms.model;

import java.util.List;

public class EntityCreditCard {

	private String codCur;
	
	private String numCard;
	
	private Double cash;
	
	private Double cashLimit;
	
	private Double cashPay;
	
	private int cuotas;
	
	private List<String> datesPay;
	
	private HeadLineEntity  customer;
	
	private String status;
	
	public String getCodCur() {
		return codCur;
	}

	public void setCodCur(String codCur) {
		this.codCur = codCur;
	}

	public String getNumCard() {
		return numCard;
	}

	public void setNumCard(String numCard) {
		this.numCard = numCard;
	}

	public Double getCash() {
		return cash;
	}

	public void setCash(Double cash) {
		this.cash = cash;
	}

	public Double getCashLimit() {
		return cashLimit;
	}

	public void setCashLimit(Double cashLimit) {
		this.cashLimit = cashLimit;
	}
	
	
	public Double getCashPay() {
		return cashPay;
	}

	public void setCashPay(Double cashPay) {
		this.cashPay = cashPay;
	}

	public int getCuotas() {
		return cuotas;
	}

	public void setCuotas(int cuotas) {
		this.cuotas = cuotas;
	}

	public List<String> getDatesPay() {
		return datesPay;
	}

	public void setDatesPay(List<String> datesPay) {
		this.datesPay = datesPay;
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
