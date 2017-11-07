package com.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.entity.Grade;
import com.entity.Student;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.SearchByHibernateService;
import com.service.StudentManagerServiceImpl;

public class StudentManager extends ActionSupport  implements ModelDriven{
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
		String stuClassNumber =request.getParameter("stuClassNumber");
		student.setStuClassNumber(stuClassNumber);
		StudentManagerServiceImpl service = new StudentManagerServiceImpl();
		if(service.updateStudent(student)){
			return "success";
		}
		
		return "fail";
		
	}
	
	public String addStudent  () {
		System.out.println("run here " + student.getStuName());
		StudentManagerServiceImpl service = new StudentManagerServiceImpl();
		if(service.addStudent(student)){
			return "success";
		}
		
		return "fail";	
	}
	
	public String deleteStudentByNumber  () {
		HttpServletRequest request = ServletActionContext.getRequest();
		String number = request.getParameter("stuNumber");
		StudentManagerServiceImpl service = new StudentManagerServiceImpl();
		if( service.deleteStudentByNumber(number)){
			return "success";
		}
		return "fail";
	}
	
		
}
