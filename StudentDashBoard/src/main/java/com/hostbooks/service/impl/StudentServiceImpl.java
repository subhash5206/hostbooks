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
	public void deleteStudent(Integer id) {
		studentDao.deleteStudent(id);
	}

	@Transactional
	public Student getStudentByID(Integer id) {
		return studentDao.getStudentByID(id);

	}

	@Transactional
	public Student updateStudent(Student student) {

		return studentDao.updateStudent(student);
	}

}
