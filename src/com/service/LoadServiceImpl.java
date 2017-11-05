package com.service;

import java.io.File;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

import com.entity.Student;
import com.tool.FileTool;


@Service
public class LoadServiceImpl implements LoadService {

	
	public void upload(File file) {
		Configuration config = new Configuration().configure();
		//2.获取sessionFactory
		SessionFactory sessionFactory = config.buildSessionFactory();
		//3.得到一个session
		Session session = sessionFactory.openSession();
		//4.开启事物
		Transaction transaction = session.beginTransaction();
		//5.操作
		
	
		List<Student> list = FileTool.analysisFile(file);
		
		for(Student stu :list){
			session.save(stu);
		}
		//6.提交事物
		transaction.commit();
		//7.关闭资源
		session.close();
		sessionFactory.close();
	}

}
