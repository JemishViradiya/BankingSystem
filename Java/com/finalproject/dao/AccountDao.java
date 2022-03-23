package com.finalproject.dao;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.finalproject.model.AccountModel;

public class AccountDao {
	
	JdbcTemplate template;
	public void setTemplate(JdbcTemplate template)
	{
		this.template = template;
	}
	public int verifyaccount(AccountModel model)
	{
		try
		{
			String getclientid =
					"select client_id from client where email='"+model.getClient().getEmail()+"'";
			int client_id = template.queryForObject(getclientid, Integer.class);
			String verifyaccount = "select count(*) from account where client_id="+client_id+" and "
					+ "account_number='"+model.getAccount_number()+"'";
			int count = template.queryForObject(verifyaccount, Integer.class);
			return count;
			
		}catch(EmptyResultDataAccessException e)
		{
			return 0;
		}
		
	}
	public void save(AccountModel model)
	{
		String save = "insert into account values('"+model.getAccount_number()+"','"+model.getAccount_type()+"',"
				+ ""+model.getClient_id()+","+model.isPassword_set()+","+model.getAccount_balance()+")";
		template.update(save);
	}

}
