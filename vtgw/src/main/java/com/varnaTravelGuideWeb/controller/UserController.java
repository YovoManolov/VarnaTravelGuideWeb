package com.varnaTravelGuideWeb.controller;


import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.varnaTravelGuideWeb.model.User;
import com.varnaTravelGuideWeb.repository.UserRepository;

@RestController
@RequestMapping(value = "/")
public class UserController {
	private final Logger LOG = LoggerFactory.getLogger(getClass());

	private final UserRepository userRepository;

	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<User> getAllUsers() {
		LOG.info("Getting all users.");
		return userRepository.findAll();
	}

	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public User getUser(@PathVariable String userId) {
		LOG.info("Getting user with ID: {}.", userId);
		Optional<User> optionalUser = userRepository.findById(userId);
		if(optionalUser.isPresent()) {
		    // value is present inside Optional
			return optionalUser.get();
		} else {
		    // value is absent
			LOG.warn("There is no user for this ID");
		}	
		return userRepository.findById(userId).get();
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public User addNewUsers(@RequestBody User user) {
		LOG.info("Saving user.");
		return userRepository.save(user);
	}
	
	
	/*
	 * @RequestMapping(value = "/settings/{userId}", method = RequestMethod.GET)
	 * public Object getAllUserSettings(@PathVariable String userId) { User user =
	 * userRepository.findOne(userId); if (user != null) { return
	 * user.getUserSettings(); } else { return "User not found."; } }
	 */
}	