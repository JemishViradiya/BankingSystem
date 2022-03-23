package com.finalproject.dao;

import org.springframework.jdbc.core.JdbcTemplate;


public class ActivityDao {
	
	JdbcTemplate template;
	public void setTemplate(JdbcTemplate template)
	{
		this.template = template;
	}
	public void updateAmount(String account_number, Double amount)
	{
		String updatebalance = "update account set account_balance="+amount+" where account_number='"+account_number+"'";
		template.update(updatebalance);
	}
	public Double getaccountbalance(String account_number)
	{
		String getbalance = "select account_balance from  account where account_number='"+account_number+"'";
		return template.queryForObject(getbalance, Double.class);
	}
	

}
