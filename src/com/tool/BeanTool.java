package com.tool;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanTool {
	
	public static Object getBean(String beanName){
		//定义配置文件的路径
		String xmlPath = "com/config/beans.xml";
		//创建Spring容器，加载配置文件
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		//获取Dao实例
		Object dao = applicationContext.getBean(beanName);
		
		return dao;
	}

}
