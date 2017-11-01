package com.action;

import java.util.List;

import com.entity.Grade;
import com.opensymphony.xwork2.ActionSupport;

public class GradeMangerAction extends ActionSupport{
	private List<Grade> grades;
	
	public List<Grade> getGrades() {
		return grades;
	}

	public void setGrades(List<Grade> grades) {
		this.grades = grades;
	}


	public String getAllGradeInfo(){
		System.out.println("Success!");
		return "";
	}

}
