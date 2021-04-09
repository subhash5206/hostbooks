package com.hostbooks.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.hostbooks.validation.EmailValidation;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmailValidation.class)
@Documented
public @interface MyEmailAnno {

	String message() default "{MyEmailAnno.invalid}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
