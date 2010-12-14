package com.hascode.tutorial.constraint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CustomerNumberValidator.class)
public @interface CustomerNumber {
	String message() default "The given customer number is invalid";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
