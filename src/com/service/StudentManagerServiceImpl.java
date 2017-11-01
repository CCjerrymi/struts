package com.service;

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
		return false;
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

}
