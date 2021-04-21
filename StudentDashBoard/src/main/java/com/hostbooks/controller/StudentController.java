package com.hostbooks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hostbooks.model.Student;
import com.hostbooks.service.StudentService;
import com.hostbooks.validation.StudentValidator;

@RestController
@RequestMapping("/student")
@Validated
@CrossOrigin(origins="http://localhost:4200")
public class StudentController {

	@Autowired
	private StudentService service;

	@Autowired
	private StudentValidator validator;

	@GetMapping("/fetch")
	public ResponseEntity<?> getStudents() {
		List<Student> list = service.getStudents();
		return new ResponseEntity<List<Student>>(list, HttpStatus.ACCEPTED);

	}

	@PostMapping("/save")
	public ResponseEntity<?> saveStudent(@RequestBody Student student, BindingResult result) {
		validator.validate(student, result);
		if (result.hasErrors()) {
			return new ResponseEntity<>("Data Not Saved ", HttpStatus.NOT_ACCEPTABLE);
		} else {
			service.saveStudent(student);
			return new ResponseEntity<>(student, HttpStatus.CREATED);
		}

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteStudent(@PathVariable String id) {
		// student.setStudentId(id);
		service.deleteStudent(id);
		ResponseEntity<String> response = new ResponseEntity<String>("Data Deleted " + id, HttpStatus.OK);
		return response;
	}

	@GetMapping("/fetch/{id}")
	public ResponseEntity<?> getStudentById(@PathVariable String id) {
		// student.setStudentId(id);
		Student student = service.getStudentByID(id);
		ResponseEntity<Student> response = new ResponseEntity<Student>(student, HttpStatus.ACCEPTED);
		return response;
	}

	@PutMapping("/update")
	public ResponseEntity<?> updateStudent(@RequestBody Student student, BindingResult result) {
		validator.validate(student, result);
		if (result.hasErrors()) {
			return new ResponseEntity<>("Data Not Updated", HttpStatus.NOT_ACCEPTABLE);
		} else {
			service.updateStudent(student);
			return new ResponseEntity<>(student, HttpStatus.CREATED);
		}

	}

	@GetMapping("/find/{branchName}")
	public ResponseEntity<?> getStudentByBranch(@PathVariable String branchName) {
		List<Student> list = service.findStudentsByBranchName(branchName);
		return new ResponseEntity<>(list, HttpStatus.ACCEPTED);
	}
}
