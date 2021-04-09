package com.hostbooks.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.hostbooks.model.Student;

@Component
public class StudentValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Student.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "studentName", "studentName.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "studentBranch", "studentbranch.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "studentMail", "studentMail.empty");

	}

}
