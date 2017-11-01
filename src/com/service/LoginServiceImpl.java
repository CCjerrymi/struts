package com.service;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.User;
import com.tool.HibernateUtil;
import com.tool.SessionTool;


public class LoginServiceImpl implements LoginService{

	@Override
	public boolean Login(String userName, String password) {
		
		//Session session = HibernateUtil.getSession();
		//Transaction transaction=session.beginTransaction();
		//1.加载hibernate.cfg.xml配置
		Configuration config = new Configuration().configure();
		//2.获取sessionFactory
		SessionFactory sessionFactory = config.buildSessionFactory();
		//3.得到一个session
		Session session = sessionFactory.openSession();
		User user = (User)session.get(User.class,"001");
		session.close();
		sessionFactory.close();
		
		if(user.getUserName().equals(userName) && user.getPassword().equals(password)){
			HttpSession httpSession = SessionTool.getSesison();
			httpSession.setAttribute("users", userName);
			return true;
		}
		
		return false;
	}
	
	
	
	/*public boolean Login(String userName,String password){
		if(userName == null || userName.equals("")){
			return false;
		}else if(password == null || password.equals("")){
			return false;
		}else if("admin".equals(userName) && "admin".equals(password)){
			HttpSession session = SessionTool.getSesison();
			session.setAttribute("users", userName);
			return true;
		}else{
			return false;
		}
	}*/
}
