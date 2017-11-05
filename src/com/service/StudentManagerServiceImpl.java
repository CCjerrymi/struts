package com.service;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Student;

public class StudentManagerServiceImpl implements StudentManagerService {
	private Configuration config;
	private SessionFactory sessionFactory;
	private Session session;

	public StudentManagerServiceImpl(){
		 config = new Configuration().configure();
		//2.获取sessionFactory
		 sessionFactory = config.buildSessionFactory();
		//3.得到一个session
		
	}
		

	@Override
	public boolean updateStudent(Student student) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(student);
		transaction.commit();
		session.close();
		sessionFactory.close();
		return true;
	}

	@Override
	public boolean addStudent(Student student) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(student);
		transaction.commit();
		session.close();
		sessionFactory.close();
		return true;
	}

	@Override
	public boolean deleteStudent(Student student) {
		return false;
	}

	@Override
	public Student getStudentByCondition(String condition) {
		return null;
	}

	@Override
	public Student getStudentByStuNumber(String stuNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	
	//删除学生实体
	public boolean deleteStudentByNumber(String stuNumber){
		Session session = sessionFactory.openSession();
		//4.开启事物
		Transaction transaction = session.beginTransaction();
		//编写hql语句
		//调用session.createQuery创建查询对象
		//Query query = session.createQuery(hql);
		Student student = new Student();
		student.setStuNumber(stuNumber);
		try{
			session.delete(student);
			transaction.commit();session.close();
			sessionFactory.close();
		}catch(Exception e){
			e.printStackTrace();
			session.close();
			sessionFactory.close();
			return false;
		}
		
		
		return true;
	}
}
