package com.hostbooks.service.impl;

import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hostbooks.dao.StudentDao;
import com.hostbooks.exceptions.DataNotFoundException;
import com.hostbooks.exceptions.IdNotFoundException;
import com.hostbooks.exceptions.MailNotValidException;
import com.hostbooks.model.Student;
import com.hostbooks.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentDao;

	@Transactional
	public Student saveStudent(Student student) {
		
		String mail=student.getStudentMail();
		if(mail==null) {
			throw new MailNotValidException("Please Enter Valid Email");
		}
		return studentDao.saveStudent(student);
	}

	@Transactional(readOnly = true)
	public List<Student> getStudents() {
		List<Student> allStudents = studentDao.getAllStudents();
		if (allStudents == null) {
			throw new DataNotFoundException();
		}
		return allStudents;
	}

	@Transactional
	public void deleteStudent(Integer id) {

		Student studentByID = studentDao.getStudentByID(id);
		if (studentByID == null) {
			throw new IdNotFoundException("Id  not found");
		}

		/*
		 * if (id == null) { throw new IdNotFoundException(""); }
		 */
		studentDao.deleteStudent(id);
	}

	@Transactional(readOnly = true)
	public Student getStudentByID(Integer id) {

		Student studentByID = studentDao.getStudentByID(id);
		if (studentByID == null) {
			throw new IdNotFoundException("Id  not found");
		}
		return studentDao.getStudentByID(id);

	}

	@Transactional
	public Student updateStudent(Student student) {
		Integer id = student.getStudentId();
		if (id == null) {
			throw new IdNotFoundException("");
		}
		return studentDao.updateStudent(student);
	}

}
