package com.finalproject.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.finalproject.model.AccountModel;
import com.finalproject.model.AddressModel;
import com.finalproject.model.ClientModel;

public class ClientDao {

	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public ClientModel clientDetails(int client_id) {
		String getclientdetails = "select * from client where client_id=" + client_id;
		ClientModel model = template.queryForObject(getclientdetails,
				new BeanPropertyRowMapper<ClientModel>(ClientModel.class));

		String getaccountlist = "select * from account where client_id =" + client_id;
		model.setAccountlist(template.query(getaccountlist, new RowMapper<AccountModel>() {

			public AccountModel mapRow(ResultSet rs, int rowNum) throws SQLException {
				AccountModel model = new AccountModel();
				model.setAccount_number(rs.getString(1));
				model.setAccount_type(rs.getString(2));
				model.setAccount_balance(rs.getDouble(5));
				return model;
			}
		}));
		return model;

	}

	public List<ClientModel> getclientlist() {
		String list = "select * from client";
		return template.query(list, new RowMapper<ClientModel>() {
			public ClientModel mapRow(ResultSet rs, int rowNum) throws SQLException {
				ClientModel model = new ClientModel();
				model.setClient_id(rs.getInt(1));
				model.setFirst_name(rs.getString(2));
				model.setLast_name(rs.getString(3));
				model.setEmail(rs.getString(10));
				String accountlist = "select * from account where client_id=" + model.getClient_id();
				model.setAccountlist(template.query(accountlist, new RowMapper<AccountModel>() {
					public AccountModel mapRow(ResultSet rs1, int rowNum) throws SQLException {
						AccountModel accountmodel = new AccountModel();
						accountmodel.setAccount_number(rs1.getString(1));
						accountmodel.setAccount_type(rs1.getString(2));
						accountmodel.setAccount_balance(rs1.getDouble(5));
						return accountmodel;
					}
				}));
				return model;
			}
		});
	}

	public String getemail(int client_id) {
		String getEmail = "select email from client where client_id=" + client_id;
		return template.queryForObject(getEmail, String.class);
	}

	public AddressModel getaddress(int client_id) {
		String getaddress = "select * from address where client_id=" + client_id;
		return template.queryForObject(getaddress, new BeanPropertyRowMapper<AddressModel>(AddressModel.class));

	}

	public void updateprofile(ClientModel model) {
		String update = "update client set first_name='" + model.getFirst_name() + "', last_name='"
				+ model.getLast_name() + "'" + ", monthly_income=" + model.getMonthly_income() + ", gender='"
				+ model.getGender() + "'," + "birth_date='" + model.getBirth_date() + "', marital_status='"
				+ model.getMarital_status() + "'," + "telephone_number='" + model.getTelephone_number() + "', email='"
				+ model.getEmail() + "'" + " where client_id=" + model.getClient_id() + "";
		template.update(update);
		
		AddressModel addressModel = model.getAddress();
		String updateaddress = "update address set street_address='" + addressModel.getStreet_address() + "', city='"
				+ addressModel.getCity() + "'," + "state='" + addressModel.getState() + "', postal_code='"
				+ addressModel.getPostal_code() + "', country='" + addressModel.getCountry() + "'" + " where client_id="
				+ model.getClient_id() + "";
		template.update(updateaddress);
	}

}
