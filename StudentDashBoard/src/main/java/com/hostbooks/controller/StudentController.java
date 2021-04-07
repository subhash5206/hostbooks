package com.hostbooks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService service;

	@GetMapping("/fetch")
	public ResponseEntity<List<Student>> getStudents(@RequestBody Student student) {
		List<Student> list = service.getStudents();
		ResponseEntity<List<Student>> response = new ResponseEntity<List<Student>>(list, HttpStatus.FOUND);
		return response;
	}

	@PostMapping("/save")
	public ResponseEntity<String> saveStudent(@RequestBody Student student) {
		service.saveStudent(student);
		ResponseEntity<String> response = new ResponseEntity<String>("Data Saved", HttpStatus.CREATED);
		return response;
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable Integer id, @RequestBody Student student) {
		student.setStudentId(id);
		service.deleteStudent(student);
		ResponseEntity<String> response = new ResponseEntity<String>("Data Deleted", HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/fetch/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable Integer id, @RequestBody Student student) {
		student.setStudentId(id);
		service.getStudentByID(student, id);
		ResponseEntity<Student> response = new ResponseEntity<Student>(student, HttpStatus.OK);
		return response;
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateStudent(@RequestBody Student student,@PathVariable Integer id) {
		service.updateStudent(student);
		ResponseEntity<String> response = new ResponseEntity<String>("Data Saved", HttpStatus.CREATED);
		return response;
	}
}
