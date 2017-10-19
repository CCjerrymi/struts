package com.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Student;

public class MyTest {
	
	
	//将对数据库的操作封装成一个工具类
	@org.junit.Test
	public void Test(){
		//1.加载hibernate.cfg.xml配置
		Configuration config = new Configuration().configure();
		//2.获取sessionFactory
		SessionFactory sessionFactory = config.buildSessionFactory();
		//3.得到一个session
		Session session = sessionFactory.openSession();
		//4.开启事物
		Transaction transaction = session.beginTransaction();
		//5.操作
		Student student = new Student();
		student.setAge(20);
		student.setStuName("roof");
		student.setStuNumber("11501010101");
		
		//将数据存入数据库中
		session.save(student);
		//6.提交事物
		transaction.commit();
		//7.关闭资源
		session.close();
		sessionFactory.close();
	}

}
