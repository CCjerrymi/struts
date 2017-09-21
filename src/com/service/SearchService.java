package com.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.entity.Student;

public class SearchService {
	private Student student;
	
	/**
	 * 根据条件查找,不用hibernate或者mybatis查找数据库特别麻烦，还要匹配操作符、转换参数格式。。。
	 *  
	 **/
	public List<Student> search(HttpServletRequest request){	
		String argument = (String)request.getParameter("arguValue");
		String operat = (String)request.getParameter("operatValue");
		String value = (String)request.getParameter("conditionValue");
		ArrayList students = (ArrayList) createStudentInfo();
		ArrayList<Student> searchResult = new ArrayList<Student>();
		//若链接数据库后则不需要进行判断，可以直接用字符串形式的age进行比较
		if(argument.equals("age")){
			int arguAge = Integer.parseInt(value);
			for(int index=0;index<students.size();index++){
				Student temp = (Student)students.get(index);
				if(checkValue(Integer.parseInt(operat),arguAge,temp.getAge())){
					searchResult.add(temp);
				}
				
			}
		}else if(argument.equals("stuName")){
			for(int index=0;index<students.size();index++){
				Student temp = (Student)students.get(index);
				if(checkValue(Integer.parseInt(operat),value,temp.getStuName())){
					searchResult.add(temp);
				}
				
			}
		}else if(argument.equals("stuNumber")){
			for(int index=0;index<students.size();index++){
				Student temp = (Student)students.get(index);
				if(checkValue(Integer.parseInt(operat),value,temp.getStuNumber())){
					searchResult.add(temp);
				}
				
			}
		}
		
		return searchResult;
	}
	
	
	/**
	 *匹配操作符 
	 * 
	 **/
	public boolean checkValue(int operat,int conditionAge,int stuAge){
		boolean result = false;
		//定义操作符时没有定义2(search.js),坑,懒得改了。
		switch(operat){
			case 0: result = conditionAge==stuAge?true:false;break;
			case 1: break;
			case 3: result = stuAge>conditionAge?true:false;break;
			case 4: result = stuAge>=conditionAge?true:false;break;
			case 5: result = stuAge<conditionAge?true:false;break;
			case 6: result = stuAge<=conditionAge?true:false;break;
			default:break;
		}
		
		return result;
	}
	
	public boolean checkValue(int operat,String conditionArgu,String stuArgu){
		boolean result = false;
		switch(operat){
			case 0: result = conditionArgu.equals(stuArgu);break;
			case 1: result = stuArgu.contains(conditionArgu);break;
			default:break;
		}
		
		System.out.println("是否包含：" + conditionArgu.contains(stuArgu));
		return result;
	}
	
	
	public List<Student> createStudentInfo(){
		Student first = new Student("刘晨","11501010101",20);
		Student second = new Student("李海","11501010102",20);
		Student third = new Student("王万","11501010103",24);
		
		ArrayList<Student> list = new ArrayList<Student>();
		list.add(first);
		list.add(second);
		list.add(third);		
		return list;
	}

}
