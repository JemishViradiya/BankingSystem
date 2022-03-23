package com.finalproject.controller;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.finalproject.dao.AccountDao;
import com.finalproject.dao.AccountRequestDao;
import com.finalproject.dao.ClientDao;
import com.finalproject.dao.LoginDao;
import com.finalproject.model.AccountModel;
import com.finalproject.model.AccountRequestModel;
import com.finalproject.model.ClientModel;
import com.finalproject.model.LoginModel;

@Controller
public class AdminController {
	
	@Autowired
	ClientDao clientdao;
	
	@Autowired
	AccountDao accountdao;
	
	@Autowired
	LoginDao logindao;
	
	@Autowired
	AccountRequestDao dao;
	
	
	//Admin Dashboard Page
	@RequestMapping(value="**/admin")
	public ModelAndView dashboard()
	{
		List<ClientModel> model = clientdao.getclientlist();
		ModelAndView view = new ModelAndView();
		view.addObject("clientlist", model);
		List<AccountRequestModel> accountrequestmodel = dao.clientRequest();
		view.addObject("requestlist", accountrequestmodel);
		view.setViewName("/dashbord");
		return view;
	}
	
	//Provide account to the client
	@RequestMapping(value="**/provide/{client_id}")
	public ModelAndView AccountProvide(@PathVariable int client_id, @PathVariable(required = false) Integer id)
	{
		ModelAndView view = new ModelAndView();
		view.addObject("client_id", client_id);
		
			//Provide default account
			AccountModel model =  accountgenerate("chequing");
			view.addObject("account", model);
			view.setViewName("/accountprovider");
		
		return view;
		
	}
	@RequestMapping(value="**/provide/{id}/{client_id}")
	public ModelAndView AccountProvider(@PathVariable int client_id, @PathVariable Integer id)
	{
		ModelAndView view = new ModelAndView();
		view.addObject("client_id", client_id);
		view.addObject("request_id",id);
		view.addObject("account", accountgenerate(dao.getAccountType(id)));
		view.setViewName("/accountprovider");
		return view;
	}
	
	//Generate Random Account Number
	public AccountModel accountgenerate(String account_type)
	{
		Random random = new Random();
		   char[] digits = new char[11];
		   digits[0] = '1';
		   for (int i = 1; i < 11; i++) {
		      digits[i] = (char)(random.nextInt(10) + '0');
		   }
		Long accountmodel = Long.parseLong(new String(digits));
		AccountModel model = new AccountModel();
		model.setAccount_number(String.valueOf(accountmodel));
		model.setAccount_type(account_type);
		model.setAccount_balance(100.0);
		return model;
	}
	
	//Generate Random password
	public String generatepassword()
	{
		UUID randomUUID = UUID.randomUUID(); 
	    String passwrod =randomUUID.toString().replaceAll("-", ""); 
	    return passwrod.substring(0,10);
		
	}
	
	//Link Account with the client
	@RequestMapping(value="**/addaccounts/{client_id}")
	public RedirectView addAccount(@ModelAttribute("account")AccountModel model, @PathVariable int client_id)
	{
		
		model.setClient_id(client_id);
		model.setPassword_set(false);
		accountdao.save(model);
		if(logindao.checkclient(client_id)==0)
		{
			LoginModel loginmodel = new LoginModel();
			loginmodel.setUsername(clientdao.getemail(client_id));
			loginmodel.setPassword(generatepassword());
			loginmodel.setClient_id(client_id);
			logindao.savecredentials(loginmodel);
		}
				return new RedirectView("admin");
		
	}
	
	@RequestMapping(value="**/addaccounts/{id}/{client_id}")
	public RedirectView addmoreaccount(@ModelAttribute("account")AccountModel model, @PathVariable int client_id
			, @PathVariable Integer id)
	{
		model.setClient_id(client_id);
		model.setPassword_set(false);
		accountdao.save(model);
		dao.changeStatus(id);
		return new RedirectView("admin");
	}

}
