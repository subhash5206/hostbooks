package com.hostbooks.service;

import java.util.List;

import com.hostbooks.model.Student;

public interface StudentService {
	public Student saveStudent(Student student);

	public List<Student> getStudents();

	public void deleteStudent(String id);

	public Student getStudentByID(String id);

	public Student updateStudent(Student student);

	public List<Student> findStudentsByBranchName(String branchName);
}
