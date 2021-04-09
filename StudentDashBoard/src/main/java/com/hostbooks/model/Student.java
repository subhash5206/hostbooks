package com.hostbooks.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.hostbooks.annotation.MyEmailAnno;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "studentDashboard")
public class Student {

	@Id
	@GeneratedValue
	@NonNull

	private Integer studentId;
	private String studentName;

	@MyEmailAnno
	private String studentMail;
	private String studentBranch;

}
