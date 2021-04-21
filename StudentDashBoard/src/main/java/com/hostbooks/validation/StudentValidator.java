package com.hostbooks.validation;

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

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "studentName", "Student Name is Empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "studentBranch", "Student Branch is Empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "studentMail", "Student Mail is Empty");

	}

}
