package com.varnaTravelGuideWeb.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.varnaTravelGuideWeb.domain.User;
import com.varnaTravelGuideWeb.service.CustomUserDetailsService;

@Controller
public class LoginController {

	@Autowired
	private CustomUserDetailsService userService;
	
	
	@GetMapping(value = "/login")
	public ModelAndView login() {
	    ModelAndView modelAndView = new ModelAndView();
	    modelAndView.setViewName("login");
	    return modelAndView;
	}
	
	@PostMapping(value = {"/","/login"} )
	public ModelAndView login(@Valid User user, BindingResult bindingResult) {
		
		ModelAndView modelAndView = new ModelAndView();
	    User userExists = userService.findUserByEmail(user.getEmail());
	    
	    if (userExists == null) {
	        bindingResult
	                .rejectValue("email", "error.user",
	                        "There is no user registered with the username provided");
	    }
	    if (bindingResult.hasErrors()) {
	        modelAndView.setViewName("login");
	    } else {
	        modelAndView.addObject("successMessage", "User has loged in successfully");
	        modelAndView.addObject("user", new User());
	        modelAndView.setViewName("home");

	    }
	    return modelAndView;
	}

	@GetMapping(value = "/signup")
	public ModelAndView signup() {
		ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("signup");
        return modelAndView;
	}
	
	@PostMapping(value = "/signup")
	public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
	    ModelAndView modelAndView = new ModelAndView();
	    User userExists = userService.findUserByEmail(user.getEmail());
	    if (userExists != null) {
	        bindingResult
	                .rejectValue("email", "error.user",
	                        "There is already a user registered with the username provided");
	    }
	    if (bindingResult.hasErrors()) {
	        modelAndView.setViewName("signup");
	    } else {
	        userService.saveUser(user);
	        modelAndView.addObject("successMessage", "User has been registered successfully");
	        modelAndView.addObject("user", new User());
	        modelAndView.setViewName("login");

	    }
	    return modelAndView;
	}
	
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	
	public ModelAndView dashboard() {
	    ModelAndView modelAndView = new ModelAndView();
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    User user = userService.findUserByEmail(auth.getName());
	    modelAndView.addObject("currentUser", user);
	    modelAndView.addObject("fullName", "Welcome " + user.getFullname());
	    modelAndView.addObject("adminMessage", "Content Available Only for Users with Admin Role");
	    modelAndView.setViewName("dashboard");
	    return modelAndView;
	}
	
	@RequestMapping(value = {"/home"}, method = RequestMethod.GET)
	public ModelAndView home() {
	    ModelAndView modelAndView = new ModelAndView();
	    modelAndView.setViewName("home");
	    return modelAndView;
	}
	
	@RequestMapping("/login-error")
	public String loginError(Model model) {
		model.addAttribute("loginError", true);
		return "login";
	}
	
	@RequestMapping("/login-verified")
	public String loginVerified(Model model) {
		model.addAttribute("verified", true);
		return "login";
	}
}
