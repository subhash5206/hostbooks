package com.hostbooks.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hostbooks.dao.StudentDao;
import com.hostbooks.model.Student;
import com.hostbooks.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentDao;

	@Transactional
	public Student saveStudent(Student student) {
		return studentDao.saveStudent(student);
	}

	@Transactional
	public List<Student> getStudents() {
		return studentDao.getAllStudents();

	}

	@Transactional
	public Student deleteStudent(Student student) {
		return studentDao.deleteStudent(student);

	}

	@Transactional
	public Student getStudentByID(Student student, Integer id) {
		return studentDao.getStudentByID(student, id);

	}

	@Transactional
	public Student updateStudent(Student student) {

		return studentDao.updateStudent(student);
	}

}
