package com.finalproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.finalproject.dao.TransactionDao;
import com.finalproject.model.TransactionModel;

@Controller
public class TransactionController {
	
	@Autowired
	TransactionDao transactiondao;
	
	
	//Fetch all transaction details
	@RequestMapping(value="**/statement/{account_number}/{client_id}")
	public ModelAndView view (@PathVariable String account_number, @PathVariable int client_id )
	{
		List<TransactionModel> model = transactiondao.getlist(account_number);
		ModelAndView view = new ModelAndView();
		view.addObject("transactionlist", model);
		view.addObject("account",account_number);
		view.setViewName("statement");
		view.addObject("client_id",client_id);
		return view;
	}

}
