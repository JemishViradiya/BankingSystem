package com.finalproject.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.finalproject.dao.ClientDao;
import com.finalproject.model.AccountModel;
import com.finalproject.model.ClientModel;

@Controller
public class ClientController {
	
	@Autowired
	ClientDao clientdao;
	
	//Home Page
	@RequestMapping(value="**/home/{client_id}")
	public ModelAndView home(@PathVariable int client_id)
	{
		ModelAndView view =new ModelAndView();
		ClientModel model = clientdao.clientDetails(client_id);
		view.addObject("clientdetails", model);
		view.setViewName("/home");
		return view;
	}
	
	//Deposit Page
	@RequestMapping(value="**/deposit/{client_id}")
	public ModelAndView depositview(@PathVariable int client_id)
	{
		ModelAndView view = new ModelAndView();
		ClientModel model = clientdao.clientDetails(client_id);
		view.addObject("clientdetails",model);
		view.setViewName("/deposit");
		return view;
	}
	
	//Withdraw Page
	@RequestMapping(value="**/withdraw/{client_id}")
	public ModelAndView withdrawview(@PathVariable int client_id, Model model)
	{
		ModelAndView view = new ModelAndView();
		ClientModel customermodel = clientdao.clientDetails(client_id);
		view.addObject("clientdetails",customermodel);
		view.addObject("error",(String)model.asMap().get("error"));
		view.setViewName("/withdraw");
		return view;
	}
	
	//Bill Page
	@RequestMapping(value="**/paybills/{client_id}")
	public ModelAndView billview(@PathVariable int client_id, Model model)
	{
		ModelAndView view = new ModelAndView();
		ClientModel customermodel = clientdao.clientDetails(client_id);
		view.addObject("clientdetails",customermodel);
		view.addObject("error",(String)model.asMap().get("error"));
		view.setViewName("/bill");
		return view;
	}
	
	//Transfer Page
	@RequestMapping(value="**/transfer/{client_id}")
	public ModelAndView transferfundview(@PathVariable int client_id, Model model)
	{
		ModelAndView view = new ModelAndView();
		ClientModel customermodel = clientdao.clientDetails(client_id);
		view.addObject("clientdetails",customermodel);
		view.addObject("error",(String)model.asMap().get("error"));
		view.setViewName("/transferfund");
		return view;
	}
	
	//New Account Page
	@RequestMapping(value="**/newaccount/{client_id}")
	public ModelAndView newAccountView(@PathVariable int client_id)
	{
		ModelAndView view = new ModelAndView();
		view.addObject("client_id",client_id);
		ClientModel customermodel = clientdao.clientDetails(client_id);
		view.addObject("accountTypeList", account_type(customermodel.getAccountlist()));
		view.addObject("clientdetails",customermodel);
		view.setViewName("/newaccount");
		return view;
	}
	
	//Get List of account type except already have client
	public List<String> account_type(List<AccountModel> accountlist)
	{
		String [] accountTypes = {"chequing","savings","student","business"};
		List<String> newlist = new ArrayList<String>();
		
		for (int j=0;j<accountTypes.length;j++)
		{
			int count =0;
			for(AccountModel account:accountlist)
			{
				if(!account.getAccount_type().equals(accountTypes[j]))
				{
					count++;
				}
				
			}
			if(count==accountlist.size())
			{
				newlist.add(accountTypes[j]);
				
			}
			
		}
		
		return newlist;
	}
	
	//View Profile Page
	@RequestMapping(value="**/viewprofile/{client_id}")
	public ModelAndView viewprofile(@PathVariable int client_id)
	{
		ModelAndView view = new ModelAndView();
		ClientModel model = clientdao.clientDetails(client_id);
		model.setAddress(clientdao.getaddress(client_id));
		view.addObject("command", model);
		
		view.setViewName("/viewprofile");
		return view;	
	}
	
	//Update Profile
	@RequestMapping(value="**/updateprofile/{client_id}")
	public RedirectView updateprofile(@ModelAttribute("client")ClientModel model,@PathVariable int client_id
			, RedirectAttributes atr)
	{
		model.setClient_id(client_id);
		clientdao.updateprofile(model);
		atr.addAttribute("client_id",client_id);
		return new RedirectView("home/{client_id}");
	}
	
	//Logout
	
	@RequestMapping(value="**/logout")
	public String logout()
	{
		return "login";
	}
	
	
	
	
	

}
