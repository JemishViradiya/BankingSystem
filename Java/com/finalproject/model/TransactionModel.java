package com.finalproject.model;

public class TransactionModel {
	
	private int transaction_id;
	private String transaction_type;
	private Double transaction_amount;
	private String sender_account_number;
	private String receiver_account_number;
	private String transaction_date;
	private AccountModel sender_model;
	private AccountModel receiver_model;
	public int getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}
	public String getTransaction_type() {
		return transaction_type;
	}
	public void setTransaction_type(String transaction_type) {
		this.transaction_type = transaction_type;
	}
	public Double getTransaction_amount() {
		return transaction_amount;
	}
	public void setTransaction_amount(Double transaction_amount) {
		this.transaction_amount = transaction_amount;
	}
	public String getSender_account_number() {
		return sender_account_number;
	}
	public void setSender_account_number(String sender_account_number) {
		this.sender_account_number = sender_account_number;
	}
	public String getReceiver_account_number() {
		return receiver_account_number;
	}
	public void setReceiver_account_number(String receiver_account_number) {
		this.receiver_account_number = receiver_account_number;
	}
	public String getTransaction_date() {
		return transaction_date;
	}
	public void setTransaction_date(String transaction_date) {
		this.transaction_date = transaction_date;
	}
	public AccountModel getSender_model() {
		return sender_model;
	}
	public void setSender_model(AccountModel sender_model) {
		this.sender_model = sender_model;
	}
	public AccountModel getReceiver_model() {
		return receiver_model;
	}
	public void setReceiver_model(AccountModel receiver_model) {
		this.receiver_model = receiver_model;
	}

}
