package com.service;

import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.entity.User;
import com.tool.BeanTool;
import com.tool.SessionTool;


public class LoginService implements ILoginService{
	private UserDao dao;
	
	public LoginService(){
		UserDao dao = (UserDao)BeanTool.getBean("userDao");
	}

	@Override
	public boolean Login(String userName, String password) {
		User user = dao.getUserByName(userName);
		if(user.getUserName().equals(userName) && user.getPassword().equals(password)){
			HttpSession httpSession = SessionTool.getSesison();
			httpSession.setAttribute("users", userName);
			return true;
		}
		
		return false;
	}
}
