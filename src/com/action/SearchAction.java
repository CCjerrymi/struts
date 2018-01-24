package com.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.entity.Student;
import com.opensymphony.xwork2.ActionSupport;
import com.service.SearchByHibernateService;
import com.service.StudentManagerService;
import com.tool.BeanTool;

public class SearchAction  extends ActionSupport {
	private StudentManagerService studentManagerService; 
	private Student student;
	public static ArrayList<Student> result = new ArrayList<Student>();
	public static Student temp = new Student();
	private String stuNumber;
  
	public SearchAction(){
		studentManagerService = (StudentManagerService) BeanTool.getBean("studentManagerService");
	}
	 
	
	public String getStuNumber() {
		return stuNumber;
	}
	public void setStuNumber(String stuNumber) {
		this.stuNumber = stuNumber;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public ArrayList<Student> getresult() {
		return result;
	}
	public void setresult(ArrayList<Student> result) {
		this.result = result;
	}
	/**
	 *定义接口
	 * 
	 **/
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		
		try{
			this.result = (ArrayList<Student>) studentManagerService.search(request);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		System.out.println(this.result.toString());
		return "success";
	}
	
	public String getStudentByNumber(){
		Student stu = studentManagerService.getStudentByStuNumber(stuNumber);
		this.temp = stu;
		return "success";
	}
	
	public String getStudentsByClassNumber(){
		
		try{
			HttpServletRequest request = ServletActionContext.getRequest();
			String stuClassNumber = request.getParameter("classNumber");
			this.result = (ArrayList<Student>) studentManagerService.getStudentsByclassNumber(stuClassNumber);
			return "success";
		}catch(Exception e){
			e.printStackTrace();
			return "fail";
		}
		
	}
	

}
