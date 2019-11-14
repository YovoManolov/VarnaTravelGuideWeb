package com.varnaTravelGuideWeb.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordConfirmedValidator implements ConstraintValidator<PasswordConfirmed, Object>{

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * @Override public boolean isValid(Object user, ConstraintValidatorContext
	 * context) { String password = ((User)user).getPassword(); String
	 * confirmedPassword = ((User)user).getConfirmPassword(); return
	 * password.equals(confirmedPassword); }
	 */

}
