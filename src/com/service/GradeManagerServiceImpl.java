package com.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Grade;
import com.entity.Student;

public class GradeManagerServiceImpl implements GradeManagerService {
	public List<Grade> list = new ArrayList<Grade>();

	@Override
	public List<Grade> getAllGradeInfo() {
		//1.加载hibernate.cfg.xml配置
		Configuration config = new Configuration().configure();
		//2.获取sessionFactory
		SessionFactory sessionFactory = config.buildSessionFactory();
		//3.得到一个session
		Session session = sessionFactory.openSession();
		//4.开启事物
		Transaction transaction = session.beginTransaction();
		//编写hql语句
		String hql = "from Grade";
		//调用session.createQuery创建查询对象
		Query query = session.createQuery(hql);
		//使用query.list方法查询数据并将数据存入一个list集合
		List<Grade> list = query.list();
		transaction.commit();
		session.close();
		sessionFactory.close();
		return list;
	}
}
