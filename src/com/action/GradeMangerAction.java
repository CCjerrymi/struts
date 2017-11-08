package com.action;

import java.util.ArrayList;
import java.util.List;

import com.entity.Grade;
import com.opensymphony.xwork2.ActionSupport;
import com.service.GradeManagerService;
import com.tool.BeanTool;

public class GradeMangerAction extends ActionSupport{
	private static List<Grade> grades = new ArrayList<Grade>();
	private GradeManagerService gradeManagerServiceImpl;
	
	public List<Grade> getGrades() {
		return grades;
	}

	public void setGrades(List<Grade> grades) {
		this.grades = grades;
	}


	public String getAllGradeInfo(){
		//GradeManagerServiceImpl service = new GradeManagerServiceImpl();
		gradeManagerServiceImpl = (GradeManagerService) BeanTool.getBean("gradeManagerService"); 
		try{
			this.grades = gradeManagerServiceImpl.getAllGradeInfo();
			System.out.println("Success!");
			return "success";
			
		}catch(Exception e){
			e.printStackTrace();
			return "success";
		}
		
	}

}
