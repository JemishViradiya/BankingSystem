package com.finalproject.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.finalproject.dao.AccountDao;
import com.finalproject.dao.ActivityDao;
import com.finalproject.dao.ClientDao;
import com.finalproject.dao.TransactionDao;
import com.finalproject.model.AccountModel;
import com.finalproject.model.ClientModel;
import com.finalproject.model.TransactionModel;

@Controller
public class AccountController {
	long millis=System.currentTimeMillis();  
	
	@Autowired
	AccountDao accountdao;
	
	@Autowired
	ClientDao clientdao;
	
	@Autowired
	ActivityDao activitydao;
	
	@Autowired
	TransactionDao transaction;
	
	
	
	//Verify account while transferring fund
	@RequestMapping(value="**/verify/{client_id}", method = RequestMethod.POST)
	public ModelAndView fundTransferForm(@ModelAttribute("receiver")AccountModel model, @PathVariable int client_id
			, RedirectAttributes atr)
	{
		ModelAndView view =new ModelAndView();
		view.addObject("client_id",client_id);
		int findaccount = accountdao.verifyaccount(model);
		if(findaccount == 0)
		{
			
			atr.addFlashAttribute("error","Unable to find an account with above details");
			view.setViewName("redirect:/transfer/{client_id}");
			return view;
		}
		else {
			
			//Transfer form with recipient details
			ClientModel clientmodel = clientdao.clientDetails(client_id);
			view.addObject("clientdetails",clientmodel);
			TransactionModel transaction = new TransactionModel();
			transaction.setReceiver_account_number(model.getAccount_number());
			view.addObject("command", transaction);
			view.setViewName("/transferform");
			return view;
		}
	}
	
	//Save Transfer data with applied logic
	@RequestMapping(value="**/transfer/{client_id}", method = RequestMethod.POST)
	public RedirectView transfer(@ModelAttribute("transfer")TransactionModel model, @PathVariable int client_id,
			RedirectAttributes atr)
	{
		Double transfer_amount = model.getTransaction_amount();
		
		//Get current amount
		Double sender_account_balance = activitydao.getaccountbalance(model.getSender_account_number());
		RedirectView view = new RedirectView();
		atr.addAttribute("client_id",client_id);
		if(transfer_amount>=sender_account_balance)
		{
			atr.addFlashAttribute("error", "You don't have enough money");
			view.setUrl("transfer/{client_id}");
			return view;
		}
		else {
			
			//Save Transaction
			Double receiver_account_balance = activitydao.getaccountbalance(model.getReceiver_account_number());
			Double new_receiver_balance = receiver_account_balance + transfer_amount;
			Double new_sender_balance = sender_account_balance - transfer_amount;
			activitydao.updateAmount(model.getReceiver_account_number(), new_receiver_balance);
			activitydao.updateAmount(model.getSender_account_number(), new_sender_balance);
			model.setTransaction_type("Transfer");
			model.setTransaction_date(new Date(millis).toString());
			transaction.savetransaction(model);
			view.setUrl("home/{client_id}");
			return view;
		}
		
	}

}
