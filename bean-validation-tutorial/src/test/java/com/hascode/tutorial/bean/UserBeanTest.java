package com.hascode.tutorial.bean;

import java.util.Date;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;

public class UserBeanTest {
	private static Validator	validator;

	@BeforeClass
	public static void setUp() {
		validator = Validation.buildDefaultValidatorFactory().getValidator();
	}

	@Test
	public void testCreateUser() {
		UserBean user = new UserBean();
		Set<ConstraintViolation<UserBean>> violations = validator.validate(user);
		Assert.assertEquals(5, violations.size()); // 5x
													// "must not be null error"
		user.setFirstName("Howard Phillips");
		user.setLastName("Lovecraft");
		user.setBirthday(new Date(600000000));
		user.setCustomerNumber("XXX");
		violations = validator.validate(user);
		/**
		 * birthday is not a past date and customer number does not match the
		 * specified format
		 */
		Assert.assertTrue("there are still some errors", (violations.size() > 0));
		user.setCustomerNumber("EN-123456");
		violations = validator.validate(user);
		Assert.assertEquals(0, violations.size()); // finally everything
													// validates

	}
}
