package com.hostbooks.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.hostbooks.annotation.MyEmailAnno;

public class EmailValidation implements ConstraintValidator<MyEmailAnno, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		String regex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-[$&+,:;=?@#|'<>-^*()%!]]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		try {
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(value);
			if (!matcher.matches()) {
				return false;
			} else {
				return true;
			}

		} catch (Exception e) {
			return false;
		}

	}

}
