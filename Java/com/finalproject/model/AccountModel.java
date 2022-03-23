package com.finalproject.model;

public class AccountModel {
	
	private String account_number;
	private String account_type;
	private boolean password_set;
	
	private Double account_balance;
	private int client_id;
	private ClientModel client;
	public String getAccount_number() {
		return account_number;
	}
	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}
	public String getAccount_type() {
		return account_type;
	}
	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}
	public boolean isPassword_set() {
		return password_set;
	}
	public void setPassword_set(boolean password_set) {
		this.password_set = password_set;
	}
	
	public Double getAccount_balance() {
		return account_balance;
	}
	public void setAccount_balance(Double account_balance) {
		this.account_balance = account_balance;
	}
	public int getClient_id() {
		return client_id;
	}
	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}
	public ClientModel getClient() {
		return client;
	}
	public void setClient(ClientModel client) {
		this.client = client;
	}

}
