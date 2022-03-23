package com.finalproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.finalproject.dao.LoginDao;
import com.finalproject.model.ClientModel;
import com.finalproject.model.LoginModel;

@Controller
public class LoginController {
	
	@Autowired
	LoginDao logindao;
	
	//Login Page
	@RequestMapping(value="**/loginpage")
	public String loginpage()
	{
		return "login";
	}
	
	//Register Page
	@RequestMapping(value="**/register")
	public String register()
	{
		return "register";
	}
	
	//Save Registration data
	@RequestMapping(value="**/register", method = RequestMethod.POST)
	public String saveclient(@ModelAttribute("client")ClientModel model, Model atr)
	{
		logindao.save(model);
		atr.addAttribute("message","Regsiter Succesfully, Admin will Provide username and password");
		return "login";
	}
	
	//Authenticate user
	@RequestMapping(value="**/login", method = RequestMethod.POST )
	public ModelAndView login(@ModelAttribute("loginmodel")LoginModel model, RedirectAttributes atr)
	{
		ModelAndView view = new ModelAndView();
		
		
		//Check Admin credentials
		if(model.getUsername().equals("admin") && model.getPassword().equals("admin"))
		{
			return new ModelAndView("redirect:/admin");
		}
		else {
			try {
				
				//Check Password has been set or not
				LoginModel loginmodel = logindao.login(model);
				
				//Password reset request
				if(!loginmodel.getPassword_set())
				{
					view.addObject("client_id",loginmodel.getClient_id());
					view.addObject("oldpassword", loginmodel.getPassword());
					view.setViewName("passwordreset");
				}
				else {
					
					//Client Home Page
					atr.addAttribute("client_id", loginmodel.getClient_id());
					view.setViewName("redirect:/home/{client_id}");
					
				}
				return view;
				
			}catch(NullPointerException e)
			{
				view.addObject("message", "Username and password are incorrect!!");
				view.setViewName("/login");
				return view;
			}
		
		}
	}
	
	//Change Password into database
	@RequestMapping(value="**/resetpassword/{client_id}", method=RequestMethod.POST)
	public String setpassword(String newpassword, @PathVariable int client_id)
	{
		logindao.changepassword(client_id, newpassword);
		return "login";
	}

}
