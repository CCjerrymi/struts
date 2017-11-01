package com.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.entity.Student;
import com.opensymphony.xwork2.ActionSupport;
import com.service.SearchByHibernateService;

public class SearchAction  extends ActionSupport {
	private Student student;
	public static ArrayList<Student> result = new ArrayList<Student>();
	public static Student temp = new Student();
	private String stuNumber;
  
	
	 
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
		//调用service中的方法进数据查找和处理
		//正常情况下是不采用new操作符新建对象的，但是要配置，所以就先采用new操作新建对象
		System.out.println("请求到后台！");
		HttpServletRequest request = ServletActionContext.getRequest();
		//SearchService service = new SearchService();
		SearchByHibernateService service = new SearchByHibernateService();
		
		try{
			this.result = (ArrayList<Student>) service.search(request);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		System.out.println(this.result.toString());
		return "success";
	}
	
	
	
	public String getStudentByNumber(){
	/*	HttpServletRequest request = ServletActionContext.getRequest();
		String stuNumber = (String)request.getAttribute("stuNumber");*/
		SearchByHibernateService service = new SearchByHibernateService();
		Student stu = service.getStudentByNumber(stuNumber);
		this.temp = stu;
		return "success";
	}
	

}
