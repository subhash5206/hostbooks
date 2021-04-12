package com.hostbooks.dao;

import java.util.List;

import com.hostbooks.model.Student;

public interface StudentDao {

	public Student saveStudent(Student student);

	public List<Student> getAllStudents();

	public Student updateStudent(Student student);

	Student getStudentByID(String id);

	void deleteStudent(String id);

	List<Student> findStudentsByBranchName(String branchName);

}
