package com.hostbooks.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "studentDashboard")
public class Student {

	@Id
	//@GeneratedValue()
	//@Generated
	@GeneratedValue(generator = "std_seq_name")
	//@SequenceGenerator(name = "uom_seq_name", sequenceName = "uom_seq")
	@GenericGenerator(name = "std_seq_name",strategy = "com.hostbooks.generator.StudentGenerator")
	
	private String studentId;
	private String studentName;

	private String studentMail;
	private String studentBranch;

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentMail() {
		return studentMail;
	}

	public void setStudentMail(String studentMail) {
		this.studentMail = studentMail;
	}

	public String getStudentBranch() {
		return studentBranch;
	}

	public void setStudentBranch(String studentBranch) {
		this.studentBranch = studentBranch;
	}

}
