package com.finalproject.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.finalproject.model.BillModel;

public class BillDao {

	JdbcTemplate template;
	public void setTemplate(JdbcTemplate template)
	{
		this.template = template;
	}
	public void savebill(BillModel model)
	{
		String savebill="insert into bill_history (payee_name, payee_type, payee_account_number, bill_amount, account_number, pay_date) "
				+ "values ('"+model.getPayee_name()+"','"+model.getPayee_type()+"','"+model.getPayee_account_number()+"',"+model.getBill_amount()
				+",'"+model.getAccount_number()+"','"+model.getPay_date()+"')";
		template.update(savebill);
	}
}
