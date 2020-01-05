package com.bank.ms.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Document(collection = "AtmEntity")
public class AtmEntity {
	@Id
	private String id;
	private String bank;
	private String numAccount;
	private String typeAccount;
	private String numDoc;
	private int numMov;
	private String msj;
	
	@JsonFormat(pattern = "yyyy-MM-dd", shape = Shape.STRING)
	private Date date;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public String getNumAccount() {
		return numAccount;
	}
	public void setNumAccount(String numAccount) {
		this.numAccount = numAccount;
	}
	public String getTypeAccount() {
		return typeAccount;
	}
	public void setTypeAccount(String typeAccount) {
		this.typeAccount = typeAccount;
	}
	public String getNumDoc() {
		return numDoc;
	}
	public void setNumDoc(String numDoc) {
		this.numDoc = numDoc;
	}
	public int getNumMov() {
		return numMov;
	}
	public void setNumMov(int numMov) {
		this.numMov = numMov;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getMsj() {
		return msj;
	}
	public void setMsj(String msj) {
		this.msj = msj;
	}
	
}
