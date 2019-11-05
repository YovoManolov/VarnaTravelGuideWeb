package com.varnaTravelGuideWeb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.varnaTravelGuideWeb.domain.User;
import com.varnaTravelGuideWeb.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AdminService {

	private final UserRepository userRepository;
	
	//@PreAuthorize("hasRole('ADMIN')")
	public List<User> getAllUsers() {
		return this.userRepository.findAll();
	}
	
}
