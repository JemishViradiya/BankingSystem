package com.finalproject.controller;

import java.sql.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.finalproject.dao.ActivityDao;
import com.finalproject.dao.TransactionDao;
import com.finalproject.model.ActivityModel;
import com.finalproject.model.TransactionModel;

@Controller
public class ActivityController {
	long millis=System.currentTimeMillis();  
	@Autowired
	ActivityDao activitydao;

	@Autowired
	TransactionDao transactiondao;
	
	//Deposit into Account
	@RequestMapping(value = "**/deposit/{client_id}", method=RequestMethod.POST)
	public RedirectView deposit(@ModelAttribute("deposit") ActivityModel model, @PathVariable int client_id,
			RedirectAttributes atr) 
	{
			Double depositamount = Double.parseDouble(model.getDeposit_amount());
			
			//Get current amount
			Double oldAmount = activitydao.getaccountbalance(model.getAccount_number());
			
			//Calculate total amount
			Double newAmount = depositamount + oldAmount;
			
			//Deposit Query
			activitydao.updateAmount(model.getAccount_number(), newAmount);
			
			//Set data into transaction model
			TransactionModel transaction =new TransactionModel();
			transaction.setTransaction_type("Deposit");
			transaction.setSender_account_number(model.getAccount_number());
			transaction.setReceiver_account_number(model.getAccount_number());
			transaction.setTransaction_date(new Date(millis).toString());
			transaction.setTransaction_amount(depositamount);
			
			//Add data into transaction table
			transactiondao.savetransaction(transaction);
			
			//Redirect to home page
			RedirectView view = new RedirectView();
			atr.addAttribute("client_id", client_id);
			view.setUrl("home/{client_id}");
			return view;
		
	}
	
	//Withdraw from account
	
	@RequestMapping(value = "**/withdraw/{client_id}", method=RequestMethod.POST)
	public RedirectView withdraw(@ModelAttribute("withdraw") ActivityModel model, @PathVariable int client_id,
			RedirectAttributes atr)
	{
		Double withdrawAmount = Double.parseDouble(model.getWithdraw_amount());
		
		//Get current amount
		Double oldAmount = activitydao.getaccountbalance(model.getAccount_number());
		RedirectView view = new RedirectView();
		atr.addAttribute("client_id",client_id);
		if(withdrawAmount>=oldAmount)
		{
			atr.addFlashAttribute("error", "You don't have enough money");
			view.setUrl("withdraw/{client_id}");
			return view;
		}
		else {
			
			//Update account balance
			Double newAmount = oldAmount - withdrawAmount ;
			activitydao.updateAmount(model.getAccount_number(), newAmount);
			
			//Set data into transaction model
			TransactionModel transaction =new TransactionModel();
			transaction.setTransaction_type("Withdraw");
			transaction.setSender_account_number(model.getAccount_number());
			transaction.setReceiver_account_number(model.getAccount_number());
			transaction.setTransaction_date(new Date(millis).toString());
			transaction.setTransaction_amount(withdrawAmount);
			
			//Add data into transaction table
			transactiondao.savetransaction(transaction);
			view.setUrl("home/{client_id}");
			return view;
		}
		
		
	}
	
	

}
