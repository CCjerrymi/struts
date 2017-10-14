package com.service;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.entity.User;
import com.tool.SessionTool;

public class LoginService {
	
	public boolean Login(String userName,String password){
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
	}

}
