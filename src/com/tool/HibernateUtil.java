package com.tool;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	private static Session session;

	static {
		// 创建Configuration对象，读取hibernate.cfg.xml文件，完成初始化
		Configuration config = new Configuration().configure();
		sessionFactory=config.buildSessionFactory();
	}
	
	//获取SessionFactory
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	
	//获取Session
	public static Session getSession(){
		session=sessionFactory.openSession();
		return session;
	}
	
	//关闭Session
	public static void closeSession(Session session){
		if(session!=null){
			session.close();
		}
	}
}