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
import com.finalproject.dao.BillDao;
import com.finalproject.dao.TransactionDao;
import com.finalproject.model.BillModel;
import com.finalproject.model.TransactionModel;

@Controller
public class BillController {
	long millis=System.currentTimeMillis();  
	@Autowired
	BillDao billdao;
	
	@Autowired
	ActivityDao activitydao;
	
	@Autowired
	TransactionDao transactiondao;
	//Save bill data into bill table 
	@RequestMapping(value="**/paybills/{client_id}", method=RequestMethod.POST)
	public RedirectView bill(@ModelAttribute("bill")BillModel model, @PathVariable int client_id,
			RedirectAttributes atr)
	{
		Double bill_amount = Double.parseDouble(model.getBill_amount());
		Double account_balance = activitydao.getaccountbalance(model.getAccount_number());
		RedirectView view = new RedirectView();
		atr.addAttribute("client_id",client_id);
		if(bill_amount>=account_balance)
		{
			atr.addFlashAttribute("error", "You don't have enough money");
			view.setUrl("withdraw/{client_id}");
			return view;
		}
		else
		{
			Double newAmount = account_balance - bill_amount ;
			activitydao.updateAmount(model.getAccount_number(), newAmount);
			model.setPay_date(new Date(millis).toString());
			billdao.savebill(model);
			TransactionModel transactionmodel = new TransactionModel();
			transactionmodel.setTransaction_type(model.getPayee_type());
			transactionmodel.setTransaction_amount(Double.parseDouble(model.getBill_amount()));
			transactionmodel.setSender_account_number(model.getAccount_number());
			transactionmodel.setReceiver_account_number(model.getPayee_account_number());
			transactionmodel.setTransaction_date(model.getPay_date());
			transactiondao.savetransaction(transactionmodel);
			view.setUrl("home/{client_id}");
			return view;
		}
		
	}

}
