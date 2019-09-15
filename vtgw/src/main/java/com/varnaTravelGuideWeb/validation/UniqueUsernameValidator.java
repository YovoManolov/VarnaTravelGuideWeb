package com.varnaTravelGuideWeb.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.varnaTravelGuideWeb.repository.UserRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

	private UserRepository repository;
	
	@Override
	public boolean isValid(String username, ConstraintValidatorContext context) {
		return username != null && repository.findByUsername(username) == null ;
	}

}
