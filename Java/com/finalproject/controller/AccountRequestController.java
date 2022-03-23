package com.finalproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.finalproject.dao.AccountRequestDao;
import com.finalproject.dao.ActivityDao;
import com.finalproject.model.AccountRequestModel;

@Controller
public class AccountRequestController {
	@Autowired
	AccountRequestDao dao;
	
	@Autowired
	ActivityDao activitydao;
	
	//Requesting New Account opening
	@RequestMapping(value="**/accountrequest/{client_id}", method = RequestMethod.POST)
	public RedirectView accountrequest(@ModelAttribute("AccountRequestModel")AccountRequestModel model,@PathVariable int client_id
			,RedirectAttributes atr)
	{
		Double newAmount = activitydao.getaccountbalance(model.getAccount_number()) - 100;
		activitydao.updateAmount(model.getAccount_number(), newAmount);
		model.setStatus("pending");
		model.setClient_id(client_id);
		dao.saveRequest(model);
		RedirectView view = new RedirectView();
		atr.addAttribute("client_id", client_id);
		view.setUrl("home/{client_id}");
		return view;
	}
}
