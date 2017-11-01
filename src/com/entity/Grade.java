package com.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Grade implements Serializable {
	private String classId;
	private String className;
	private String classNumber;
	private Set<Student> students;

	

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getClassNumber() {
		return classNumber;
	}

	public void setClassNumber(String classNumber) {
		this.classNumber = classNumber;
	}

	public Grade() {
		super();
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public Grade(String classId, String className, String classNumber) {
		super();
		this.classId = classId;
		this.className = className;
		this.classNumber = classNumber;
	}

	public Grade(String className, String classNumber) {
		super();
		this.className = className;
		this.classNumber = classNumber;
	}

}
