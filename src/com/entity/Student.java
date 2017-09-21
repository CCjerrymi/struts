package com.entity;

public class Student {
	private String stuName;
	private String stuNumber;
	private int age;
	
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
	
	

}
