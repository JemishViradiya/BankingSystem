package com.finalproject.model;

public class LoginModel {
	
	private int login_id;
	private String username;
	private String password;
	private int client_id;
	private Boolean password_set;
	private ClientModel client;
	public ClientModel getClient() {
		return client;
	}
	public void setClient(ClientModel client) {
		this.client = client;
	}
	public int getClient_id() {
		return client_id;
	}
	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getLogin_id() {
		return login_id;
	}
	public void setLogin_id(int login_id) {
		this.login_id = login_id;
	}
	public Boolean getPassword_set() {
		return password_set;
	}
	public void setPassword_set(Boolean password_set) {
		this.password_set = password_set;
	}
	

}
