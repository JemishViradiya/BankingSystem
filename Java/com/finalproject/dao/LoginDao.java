package com.finalproject.dao;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.finalproject.model.ClientModel;
import com.finalproject.model.LoginModel;

public class LoginDao {

	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public LoginModel login(LoginModel model) {
		try {

			String getresult = "select * from login where username='" + model.getUsername()
					+ "' and password ='" + model.getPassword() + "'";
			return  template.queryForObject(getresult, new BeanPropertyRowMapper<LoginModel>(LoginModel.class));

		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	public void save(ClientModel model) {
		String saveclient = "insert into client(first_name, last_name, id_card_number, monthly_income, gender,"
				+ "birth_date, marital_status, telephone_number, email) values (" + "'" + model.getFirst_name() + "','"
				+ model.getLast_name() + "','" + model.getId_card_number() + "'" + "," + model.getMonthly_income()
				+ ",'" + model.getGender() + "','" + model.getBirth_date() + "','" + model.getMarital_status() + "','"
				+ model.getTelephone_number() + "'," + "'" + model.getEmail() + "')";
		template.update(saveclient);

		String getclientid = "select client_id from client where email='" + model.getEmail() + "'";
		int client_id = template.queryForObject(getclientid, Integer.class);

		String saveaddress = "insert into address (street_address,city,state,postal_code, country, client_id)"
				+ "values ('" + model.getAddress().getStreet_address() + "','" + model.getAddress().getCity() + "',"
				+ "'" + model.getAddress().getState() + "','" + model.getAddress().getPostal_code() + "'," + "'"
				+ model.getAddress().getCountry() + "'," + client_id + ")";

		template.update(saveaddress);

	}
	
	public int checkclient(int client_id)
	{
		try {
		String check="select count(*) from login where client_id="+client_id;
		return template.queryForObject(check, Integer.class);
		}catch(EmptyResultDataAccessException e) {
			return 0;
		}
	}
	
	public void savecredentials(LoginModel model)
	{
		String save="insert into login (username, password, client_id) values ('"+model.getUsername()+"',"
				+ "'"+model.getPassword()+"',"+model.getClient_id()+")";
		template.update(save);
	}
	
	public void changepassword(int client_id, String password)
	{
		String updatepassword = "update login set password='"+password+"', password_set=1 where client_id="+client_id;
		template.update(updatepassword);
	}
	

}
