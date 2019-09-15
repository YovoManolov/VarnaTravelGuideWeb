package com.varnaTravelGuideWeb.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.varnaTravelGuideWeb.entity.User;
import com.varnaTravelGuideWeb.event.UserRegistrationEvent;
import com.varnaTravelGuideWeb.model.UserDto;
import com.varnaTravelGuideWeb.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserRegistrationService {

	private final UserRepository repository;
	private final PasswordEncoder encoder;
	private final ApplicationEventPublisher eventPublisher;
	private final boolean TOTP_ENABLED = false;
	@Value(value = "${disableEmailVerification}")
	private boolean disableEmailVerification;
	
	public void registerNewUser(UserDto user) {
		User newUser = new User(
				user.getUsername(), 
				user.getFirstname(), 
				user.getLastname(),
				user.getEmail(), 
				encoder.encode(user.getPassword()),
				encoder.encode(String.valueOf(user.getSecurityPin())),
				TOTP_ENABLED
		);
		newUser.setVerified(disableEmailVerification);
		repository.save(newUser);
		eventPublisher.publishEvent(new UserRegistrationEvent(newUser));
	}

}
