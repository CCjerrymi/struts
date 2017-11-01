package com.tool;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.entity.Student;

public class FileTool {
	
	public static List<Student> analysisFile(File file){
		String enconding = "UTF-8";
		//存储从文件中读取出来的Student对象
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		try{
			//读取文件
			FileInputStream inputStream = new FileInputStream(file); 
			int temp = 0;
			String content = "",key="",value="";
			Map<String,Object> map = null;
			
			while((temp = inputStream.read()) != -1){
				
				if(content.equals("Student")){
					if(map != null || map.size() > 0){
						list.add(map);
					}else{
						map = new HashMap<String,Object>();
					}
				}
				
				if(temp == 58){
					//创建一个map，将读取到的信息存入
					//map = new HashMap<String,Object>();
					//赋值，清空
					key = content;
					content = "";
				}
				
				if(temp == 59){
					value = content;
					content = "";
					
					
					map.put(key, value);
				}
				
				
				
				content +=(char)temp;
				
				
			}
				
			
			return analysisStudent(list);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}	
	}
	
	
	/**
	 * 
	 *根据反射原理对文件进行读取并且生成相应对象的数组返回 
	 * 
	 **/
	protected static List<Object> analysis(List<Map<String,Object>> list){
		//使用反射原理动态生成
		
		String className = (String)list.get(0).get("className");
		for(int index = 0 ;index < list.size();index++) {
			Map map = list.get(index);
			//获取第一个对象信息
			try{
				Class clazz = Class.forName(className);
				//考虑到反射机制打破了封装特性，我们通过获取调用方法的方式来使用
				//Method[] method = clazz.getMethods();//获取方法
				Object object = clazz.newInstance();//获取对象
				
				//遍历map
				Iterator<Map.Entry<String, Object>> entries = map.entrySet().iterator();  
				  
				while (entries.hasNext()) {    
				    Map.Entry<String, Object> entry = entries.next();  
				  
				    String methodName = getSetterMethodName(entry.getKey());
				    Object value = entry.getValue();
				    
				    Method method = clazz.getDeclaredMethod(methodName);
				    
				    System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());  
				  
				}  
				
				
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}
			
			
		}
		return null;
		
	}
	
	
	protected static List<Student> analysisStudent(List<Map<String,Object>> list){
		List<Student> myList = new ArrayList<Student>();
		//直接遍历list取值
		for(int index = 0; index < list.size();index++){
			//获取每一个map
			Map map = list.get(index);
			String stuName = (String)map.get("stuName");
			String stuNumber = (String)map.get("stuNumber");
			int stuClassNumber = (int)map.get("stuClassNumber");
			int age = (int)map.get("age");
			
			Student student = new Student(stuName,stuNumber,age);
			student.setStuClassNumber(stuClassNumber);
			myList.add(student);
		}
		return myList;
	}
	
	protected static String getSetterMethodName(String attributeName){
		String methodName = "set" + attributeName.substring(0, 2).toUpperCase() + attributeName.substring(1, attributeName.length());
		return methodName;
	}

}
