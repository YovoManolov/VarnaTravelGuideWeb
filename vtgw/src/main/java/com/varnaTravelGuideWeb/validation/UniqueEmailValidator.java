package com.varnaTravelGuideWeb.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.varnaTravelGuideWeb.repository.UserRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

	private UserRepository repository;
	
	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		return email != null && repository.findByEmail(email) == null ;
	}

}
