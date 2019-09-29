package com.varnaTravelGuideWeb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.varnaTravelGuideWeb.entity.User;
import com.varnaTravelGuideWeb.repository.UserRepository;
import com.varnaTravelGuideWeb.service.VerificationService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class VerificationController {

	private final VerificationService verificationService;
	private final UserRepository userRepository;
	
	@GetMapping("/verify/email")
	public String verifyEmail(@RequestParam String id) {
		String username = verificationService.getUsernameForId(id);
		if(username != null) {
			User user = userRepository.findByUsername(username);
			user.setVerified(true);
			userRepository.save(user);
		}
		return "redirect:/login-verified";
	}
	
}