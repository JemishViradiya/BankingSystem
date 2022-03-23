package com.finalproject.model;

public class ActivityModel {
	private int id;
	private String account_number;
	private String withdraw_amount;
	private String deposit_amount;
	private String message;
	public int getDeposit_id() {
		return id;
	}
	public void setDeposit_id(int deposit_id) {
		this.id = deposit_id;
	}
	public String getAccount_number() {
		return account_number;
	}
	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}
	public String getDeposit_amount() {
		return deposit_amount;
	}
	public void setDeposit_amount(String deposit_amount) {
		this.deposit_amount = deposit_amount;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getWithdraw_amount() {
		return withdraw_amount;
	}
	public void setWithdraw_amount(String withdraw_amount) {
		this.withdraw_amount = withdraw_amount;
	}
	
}
