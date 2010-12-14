package com.hascode.tutorial.constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CustomerNumberValidator implements ConstraintValidator<CustomerNumber, String> {

	@Override
	public void initialize(CustomerNumber number) {
	}

	@Override
	public boolean isValid(String customerNumber, ConstraintValidatorContext ctx) {
		if (customerNumber == null)
			return false;

		if (customerNumber.matches("^[a-zA-Z]{2}-\\d+$"))
			return true;
		return false;
	}

}
