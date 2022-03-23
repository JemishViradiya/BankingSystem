package com.finalproject.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.finalproject.model.AccountRequestModel;

public class AccountRequestDao {
	JdbcTemplate template;
	public void setTemplate(JdbcTemplate template)
	{
		this.template = template;
	}
	
	public void saveRequest(AccountRequestModel model)
	{
		String save="insert into account_request (status, account_type, client_id) values"
				+ "('"+model.getStatus()+"', '"+model.getAccount_type()+"', "+model.getClient_id()+")";
		template.update(save);
	}
	public List<AccountRequestModel> clientRequest()
	{
		String getrequests ="select * from account_request where status='pending'";
		return template.query(getrequests, new RowMapper<AccountRequestModel>(){

			public AccountRequestModel mapRow(ResultSet rs, int rowNum) throws SQLException {
				AccountRequestModel model = new AccountRequestModel();
				model.setAccount_type(rs.getString(3));
				model.setClient_id(rs.getInt(4));
				model.setId(rs.getInt(1));
				return model;
			}
		});
	}
	public String getAccountType(int id)
	{
		String getAccountType = "select account_type from account_request where id="+id;
		return template.queryForObject(getAccountType, String.class);
	}
	public void changeStatus(int id)
	{
		String changeStatus = "update account_request set status='provided' where id="+id;
		template.update(changeStatus);
	}
}
