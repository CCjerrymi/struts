package com.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.dao.StudentDao;
import com.entity.Student;
import com.tool.BeanTool;

public class StudentManagerService implements IStudentManagerService {
	private StudentDao studentDao;

	public StudentManagerService(){	
		studentDao = (StudentDao)BeanTool.getBean("studentDao");
	}
		

	@Override
	public boolean updateStudent(Student student) {
		int result =studentDao.updateStudent(student);
		return result == 1;
	}

	@Override
	public boolean addStudent(Student student) {
		int result = studentDao.addStudent(student);
		return result == 1;
	}

	@Override
	public boolean deleteStudent(Student student) {
		String stuNumber = student.getStuNumber();
		int result = studentDao.deleteStudentByStuNumber(stuNumber);
		return result == 1;
	}

	@Override
	public Student getStudentByCondition(String condition) {
		return null;
	}

	@Override
	public Student getStudentByStuNumber(String stuNumber) {
		return null;
	}

	
	//删除学生实体
	public boolean deleteStudentByNumber(String stuNumber){
		int result = studentDao.deleteStudentByStuNumber(stuNumber);
		return result == 1;
	}
	
	public List<Student> search(HttpServletRequest request){
		//获取参数名、条件符号、值
		String argument = (String)request.getParameter("arguValue");
		String operat = (String)request.getParameter("operatValue");
		String value = (String)request.getParameter("conditionValue");
		
		List<Student> list = studentDao.searchStudent(argument, operat, value);
		
		return list;
		
	}


	@Override
	public List<Student> getStudentsByclassNumber(String stuClassNumber) {
		List<Student> list = studentDao.getStudentsByclassNumber(stuClassNumber);
		if(list.size() > 0){
			return list;
		}else{
			return new ArrayList<Student>();
		}
		
	}
}
