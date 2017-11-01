package com.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.webflow.engine.ActionList;

import com.entity.Grade;
import com.entity.Student;
import com.opensymphony.xwork2.ModelDriven;
import com.service.StudentManagerServiceImpl;

public class StudentManager extends ActionList  implements ModelDriven{
	private Student student = new Student();
	private String stuName;
	private String stuNumber;
	private int stuClassNumber;
	private int age;
	private Grade grade;
	 
	
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

	public int getStuClassNumber() {
		return stuClassNumber;
	}

	public void setStuClassNumber(int stuClassNumber) {
		this.stuClassNumber = stuClassNumber;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	@Override
	public Object getModel() {
		return student;
	}
	
	public String execute  () throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		String stuNumber = request.getParameter("stuNumber");
		String stuName = request.getParameter("stuName");
		System.out.println("request " + request.getParameter("stuName"));
		int age = Integer.parseInt(request.getParameter("age"));
		int stuClassNumber =Integer.parseInt(request.getParameter("stuClassNumber"));
		student.setStuClassNumber(stuClassNumber);
		StudentManagerServiceImpl service = new StudentManagerServiceImpl();
		if(service.updateStudent(student)){
			return "success";
		}
		
		return "fail";
		
	}
	
		
}
