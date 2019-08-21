package com.varnaTravelGuideWeb.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebController {
	
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() { 
		 return "templates/index";
	}
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		return "redirect:/login";
	}
	
	@RequestMapping("user")
	@ResponseBody
	public Principal user(Principal principal) {
		return principal;
	}
}
