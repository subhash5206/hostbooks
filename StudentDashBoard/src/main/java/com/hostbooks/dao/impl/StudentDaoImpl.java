package com.hostbooks.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hostbooks.dao.StudentDao;
import com.hostbooks.model.Student;

@Repository
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private EntityManager em;

	@Override
	public Student saveStudent(Student student) {
		try {
			em.persist(student);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return student;
	}

	@Override
	public List<Student> getAllStudents() {
		try {
			String queryString = "from Student";

			Query<Student> query = (Query<Student>) em.createQuery(queryString);

			return (List<Student>) query.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Student updateStudent(Student student) {
		try {
			em.merge(student);
			return student;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean isStudentExist(Integer id) {
		return em.contains(id);
	}

	@Override
	public void deleteStudent(Integer id) {
		try {
			Student st = em.find(Student.class, id);
			if(st==null) {
				//TODO
			}
			
			em.remove(st);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Student getStudentByID(Integer id) {
		Student student = (Student) em.find(Student.class, id);

		return student;
	}

}
