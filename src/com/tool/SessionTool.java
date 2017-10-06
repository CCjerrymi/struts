package com.tool;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

public class SessionTool {
    
	public static HttpSession getSesison(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		
		return session;
	}

}
