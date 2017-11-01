package com.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Student;

public class SearchByHibernateService {
	private Student student;
	
	public List<Student> search(HttpServletRequest request){
		//获取参数名、条件符号、值
		String argument = (String)request.getParameter("arguValue");
		String operat = (String)request.getParameter("operatValue");
		String value = (String)request.getParameter("conditionValue");
		
		//1.加载hibernate.cfg.xml配置
		Configuration config = new Configuration().configure();
		//2.获取sessionFactory
		SessionFactory sessionFactory = config.buildSessionFactory();
		//3.得到一个session
		Session session = sessionFactory.openSession();
		//4.开启事物
		Transaction transaction = session.beginTransaction();
		//编写hql语句
		String hql = "from Student where " + argument + " " + operat + " '" + value + "'";
		if(operat.equals("like")){
			hql = "from Student where " + argument + " " + operat + " '%" + value + "%'";
		}
		//调用session.createQuery创建查询对象
		Query query = session.createQuery(hql);
		//使用query.list方法查询数据并将数据存入一个list集合
		List<Student> list = query.list();
		//循环出集合中的数据
		for(Student student:list){
			System.out.println(student);
		}
		
		transaction.commit();
		session.close();
		sessionFactory.close();
		
		return list;
		
	}
	
	
	public Student getStudentByNumber(String stuNumber){
		//1.加载hibernate.cfg.xml配置
		Configuration config = new Configuration().configure();
		//2.获取sessionFactory
		SessionFactory sessionFactory = config.buildSessionFactory();
		//3.得到一个session
		Session session = sessionFactory.openSession();
		String hql = "from Student where stuNumber = " + stuNumber;
		Query query = session.createQuery(hql);
		//使用query.list方法查询数据并将数据存入一个list集合
		List<Student> list = query.list();
		
		
		return list.get(0);
	}
	
	public List<Student> getStudentByClassNumber(String classNumber){
		//1.加载hibernate.cfg.xml配置
		Configuration config = new Configuration().configure();
		//2.获取sessionFactory
		SessionFactory sessionFactory = config.buildSessionFactory();
		//3.得到一个session
		Session session = sessionFactory.openSession();
		String hql = "from Student where classNumber = " + classNumber;
		Query query = session.createQuery(hql);
		//使用query.list方法查询数据并将数据存入一个list集合
		List<Student> list = query.list();
		
		
		return list;
	}
	

}
