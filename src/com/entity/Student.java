package com.entity;

import com.entity.Grade;

public class Student {
	private String stuName;
	private String stuNumber;
	private int stuClassNumber;
	private int age;
	private Grade grade;
	//private Set<Grade> grade = new HashSet<Grade>();
	
	public Student(){
	}
	
	public Student(String stuName,String stuNumber,int age){
		this.stuName = stuName;
		this.stuNumber = stuNumber;
		this.age = age;	
	}
	
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getStuNumber() {
		return stuNumber;
	}
	public void setStuNumber(String stuNumber) {
		this.stuNumber = stuNumber;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	public int getStuClassNumber() {
		return stuClassNumber;
	}

	public void setStuClassNumber(int stuClassNumber) {
		this.stuClassNumber = stuClassNumber;
	}
	
	
	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public String toString(){
		return "Student[stuNumber=" + stuNumber+ ",stuName=" + stuName+ ",age=" + age + "]"; 
	}
	
	

}
