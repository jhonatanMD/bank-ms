package com.bank.ms.model;

public class CustomerEntity {


	private String CodCust;
	private String Busnam;
	private String Ruc;
	private String Addr;
	private String Num;
	private String profile;
	
	public String getCodCust() {
		return CodCust;
	}
	public void setCodCust(String codCust) {
		CodCust = codCust;
	}
	public String getBusnam() {
		return Busnam;
	}
	public void setBusnam(String busnam) {
		Busnam = busnam;
	}
	public String getRuc() {
		return Ruc;
	}
	public void setRuc(String ruc) {
		Ruc = ruc;
	}
	public String getAddr() {
		return Addr;
	}
	public void setAddr(String addr) {
		Addr = addr;
	}
	public String getNum() {
		return Num;
	}
	public void setNum(String num) {
		Num = num;
	}
	
	
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	
}
