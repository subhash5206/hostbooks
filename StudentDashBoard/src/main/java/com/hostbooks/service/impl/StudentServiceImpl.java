package com.hostbooks.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hostbooks.dao.StudentDao;
import com.hostbooks.exceptions.BranchNotFoundException;
import com.hostbooks.exceptions.DataNotFoundException;
import com.hostbooks.exceptions.IdNotFoundException;
import com.hostbooks.model.Student;
import com.hostbooks.service.StudentService;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentDao;

	@Override
	public Student saveStudent(Student student) {

		return studentDao.saveStudent(student);
	}

	@Override
	public List<Student> getStudents() {
		List<Student> allStudents = studentDao.getAllStudents();
		if (allStudents == null) {
			throw new DataNotFoundException();
		}
		return allStudents;
	}

	@Override
	public void deleteStudent(String id) {

		Student studentByID = studentDao.getStudentByID(id);
		if (studentByID == null) {
			throw new IdNotFoundException("Id  not found");
		}

		/*
		 * if (id == null) { throw new IdNotFoundException(""); }
		 */
		studentDao.deleteStudent(id);
	}

	@Override
	public Student getStudentByID(String id) {

		Student studentByID = studentDao.getStudentByID(id);
		if (studentByID == null) {
			throw new IdNotFoundException("Id  not found");
		}
		return studentDao.getStudentByID(id);

	}

	@Override
	public Student updateStudent(Student student) {
		String id = student.getStudentId();
		Student studentByID = studentDao.getStudentByID(id);
		if (studentByID == null) {
			throw new IdNotFoundException("Id  not found");
		}
		return studentDao.updateStudent(student);
	}

	@Override
	public List<Student> findStudentsByBranchName(String branchName) {
		
		if (branchName == null) {
			throw new BranchNotFoundException("Branch Not Found");
		}
		return studentDao.findStudentsByBranchName(branchName);
	}

}
