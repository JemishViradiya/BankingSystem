package com.finalproject.model;

public class AddressModel {
	
	private int address_id;
	private String street_address;
	private String street_address2;
	private String city;
	private String state;
	private String postal_code;
	private String country;
	private int client_id;
	private ClientModel client;
	public int getAddress_id() {
		return address_id;
	}
	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}
	public String getStreet_address() {
		return street_address;
	}
	public void setStreet_address(String street_address) {
		this.street_address = street_address;
	}
	public String getStreet_address2() {
		return street_address2;
	}
	public void setStreet_address2(String street_address2) {
		this.street_address2 = street_address2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPostal_code() {
		return postal_code;
	}
	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getClient_id() {
		return client_id;
	}
	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public ClientModel getClient() {
		return client;
	}
	public void setClient(ClientModel client) {
		this.client = client;
	}
	

}
