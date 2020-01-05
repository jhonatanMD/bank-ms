package com.bank.ms.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "BankEntity")
public class BankEntity {

	@Id
	private String id;
	private String nameBank;
	private Double commTran;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNameBank() {
		return nameBank;
	}
	public void setNameBank(String nameBank) {
		this.nameBank = nameBank;
	}
	public Double getCommTran() {
		return commTran;
	}
	public void setCommTran(Double commTran) {
		this.commTran = commTran;
	}
	
	
}
