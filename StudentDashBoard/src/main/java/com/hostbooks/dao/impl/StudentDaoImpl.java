package com.hostbooks.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.validation.constraints.Pattern;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hostbooks.dao.StudentDao;
import com.hostbooks.model.Student;

@Repository
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private EntityManager em;

	@Override
	public Student saveStudent(Student student) {

		em.persist(student);

		return student;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> getAllStudents() {
		String queryString = "from Student";

		Query<Student> query = (Query<Student>) em.createQuery(queryString);

		return (List<Student>) query.getResultList();

	}

	@Override
	public Student updateStudent(Student student) {
		em.merge(student);
		return student;
	}

	public boolean isStudentExist(Integer id) {
		return em.contains(id);
	}

	@Override
	public void deleteStudent(Integer id) {
		Student st = em.find(Student.class, id);
		em.remove(st);
	}

	@Override
	public Student getStudentByID(Integer id) {
		Student student = (Student) em.find(Student.class, id);
		return student;
	}

}
