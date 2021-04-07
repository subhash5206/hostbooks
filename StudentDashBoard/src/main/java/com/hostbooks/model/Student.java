package com.hostbooks.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

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
	@NotNull
	private String studentName;

	@NotNull
	@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-z.-]+$")
	private String studentMail;
	@NotNull
	private String studentBranch;

}
