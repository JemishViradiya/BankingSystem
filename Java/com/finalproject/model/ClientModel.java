package com.finalproject.model;

import java.util.List;

public class ClientModel {
	
	private int client_id;
	private String first_name;
	private String last_name;
	private String id_card_number;
	private Double monthly_income;
	private String gender;
	private String birth_date;
	private String marital_status;
	private String telephone_number;
	private String email;
	private AddressModel address;
	private List<AccountModel> accountlist;
	public int getClient_id() {
		return client_id;
	}
	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getId_card_number() {
		return id_card_number;
	}
	public void setId_card_number(String id_card_number) {
		this.id_card_number = id_card_number;
	}
	public Double getMonthly_income() {
		return monthly_income;
	}
	public void setMonthly_income(Double monthly_income) {
		this.monthly_income = monthly_income;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirth_date() {
		return birth_date;
	}
	public void setBirth_date(String birth_date) {
		this.birth_date = birth_date;
	}
	public String getMarital_status() {
		return marital_status;
	}
	public void setMarital_status(String marital_status) {
		this.marital_status = marital_status;
	}
	public String getTelephone_number() {
		return telephone_number;
	}
	public void setTelephone_number(String telephone_number) {
		this.telephone_number = telephone_number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<AccountModel> getAccountlist() {
		return accountlist;
	}
	public void setAccountlist(List<AccountModel> accountlist) {
		this.accountlist = accountlist;
	}
	public AddressModel getAddress() {
		return address;
	}
	public void setAddress(AddressModel address) {
		this.address = address;
	}

}
