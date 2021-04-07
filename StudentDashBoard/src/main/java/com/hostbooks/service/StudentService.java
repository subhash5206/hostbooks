package com.hostbooks.service;

import java.util.List;

import com.hostbooks.model.Student;

public interface StudentService {
	public Student saveStudent(Student student);

	public List<Student> getStudents();

	public Student deleteStudent(Student student);

	public Student getStudentByID(Student student,Integer id);

	public Student updateStudent(Student student);
}
