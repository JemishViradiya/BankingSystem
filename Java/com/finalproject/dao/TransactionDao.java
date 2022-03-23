package com.finalproject.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.finalproject.model.TransactionModel;

public class TransactionDao {
	JdbcTemplate template;
	public void setTemplate(JdbcTemplate template)
	{
		this.template = template;
	}
	public void savetransaction(TransactionModel model)
	{
		String save ="insert into transaction (transaction_type, transaction_amount, sender_account_number, receiver_account_number, transaction_date)"
				+ "values ('"+model.getTransaction_type()+"',"+model.getTransaction_amount()+",'"+model.getSender_account_number()+
				"','"+model.getReceiver_account_number()+"','"+model.getTransaction_date()+"')";
		template.update(save);
		
	}
	public List<TransactionModel> getlist(String account_number)
	{
		
		String getlist = "select * from transaction where  sender_account_number='"+account_number+"' or receiver_account_number='"+account_number+"'"
				+ " order by transaction_date desc";
		return template.query(getlist,new RowMapper<TransactionModel>(){
			public TransactionModel mapRow(ResultSet rs, int rowNum) throws SQLException {
				TransactionModel model = new TransactionModel();
				model.setTransaction_type(rs.getString(2));
				model.setTransaction_amount(rs.getDouble(3));
				model.setTransaction_date(rs.getString(6));
				model.setSender_account_number(rs.getString(4));
				model.setReceiver_account_number(rs.getString(5));
				model.setTransaction_id(rs.getInt(1));
				return model;
			}
		});
	}

}
