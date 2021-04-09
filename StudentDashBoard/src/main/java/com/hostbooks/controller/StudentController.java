package com.hostbooks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hostbooks.exceptions.DataNotFoundException;
import com.hostbooks.exceptions.DataNotSavedException;
import com.hostbooks.exceptions.IdNotFoundException;
import com.hostbooks.model.Student;
import com.hostbooks.service.StudentService;
import com.hostbooks.validation.StudentValidator;

@RestController
@RequestMapping("/student")
@Validated
public class StudentController {

	@Autowired
	private StudentService service;

	@Autowired
	private StudentValidator validator;

	@GetMapping("/fetch")
	public ResponseEntity<List<Student>> getStudents() {
		List<Student> list = service.getStudents();
		ResponseEntity<List<Student>> response = new ResponseEntity<List<Student>>(list, HttpStatus.FOUND);
		return response;
	}

	@PostMapping("/save")
	public ResponseEntity<String> saveStudent(@RequestBody Student student, BindingResult result) {
		validator.validate(student, result);
		if (result.hasErrors()) {
			return new ResponseEntity<String>("Data Not Saved", HttpStatus.NOT_ACCEPTABLE);
		} else {
			service.saveStudent(student);
			return new ResponseEntity<String>("Data Saved", HttpStatus.CREATED);

		}

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable Integer id) {
		// student.setStudentId(id);

		service.deleteStudent(id);
		ResponseEntity<String> response = new ResponseEntity<String>("Data Deleted", HttpStatus.OK);
		return response;
	}

	@GetMapping("/fetch/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable Integer id) {
		// student.setStudentId(id);
		Student student = service.getStudentByID(id);
		ResponseEntity<Student> response = new ResponseEntity<Student>(student, HttpStatus.OK);
		return response;
	}

	@PutMapping("/update")
	public ResponseEntity<String> updateStudent(@RequestBody Student student, BindingResult result) {
		validator.validate(student, result);
		if (result.hasErrors()) {
			return new ResponseEntity<String>("Data Not Updated", HttpStatus.NOT_ACCEPTABLE);
		} else {
			service.updateStudent(student);
			return new ResponseEntity<String>("Data Updated", HttpStatus.CREATED);

		}

	}
}
