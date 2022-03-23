package com.finalproject.model;

public class BillModel {
	
	private int bill_id;
	private String payee_name;
	private String payee_type;
	private String payee_account_number;
	private String bill_amount;
	private String account_number;
	private String pay_date;
	public int getBill_id() {
		return bill_id;
	}
	public void setBill_id(int bill_id) {
		this.bill_id = bill_id;
	}
	public String getPayee_name() {
		return payee_name;
	}
	public void setPayee_name(String payee_name) {
		this.payee_name = payee_name;
	}
	public String getBill_amount() {
		return bill_amount;
	}
	public void setBill_amount(String bill_amount) {
		this.bill_amount = bill_amount;
	}
	public String getPayee_type() {
		return payee_type;
	}
	public void setPayee_type(String payee_type) {
		this.payee_type = payee_type;
	}
	public String getPayee_account_number() {
		return payee_account_number;
	}
	public void setPayee_account_number(String payee_account_number) {
		this.payee_account_number = payee_account_number;
	}
	public String getAccount_number() {
		return account_number;
	}
	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}
	public String getPay_date() {
		return pay_date;
	}
	public void setPay_date(String pay_date) {
		this.pay_date = pay_date;
	}
	
}
