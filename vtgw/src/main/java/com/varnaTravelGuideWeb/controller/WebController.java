package com.varnaTravelGuideWeb.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebController {

	@RequestMapping(value = "/", method = RequestMethod.GET) 
	public String index(Model model, Principal principal) { 
		return "redirect:/index"; 
	}
	
	 @RequestMapping(value = "/login", method = RequestMethod.GET) 
	 public String loginPage() { 
		 return "redirect:/login"; 
	 }
	 
	 @RequestMapping(value = "/login/oauth2/code/google", method = RequestMethod.GET) 
	 public String loginPage2() { 
		 return "redirect:/index"; 
	 }
	 
	@RequestMapping("user")
	@ResponseBody
	public Principal user(Principal principal) {
		return principal;
	}
}
