package com.action;

import com.opensymphony.xwork2.ActionSupport;
import com.service.LoginService;


public class LoginAction extends ActionSupport {
	private String userName;
	private String password;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	/**
	 * 方法描述：注册一个Action（登录的Action），当前台请求的时候，通过过滤器调用该方法
	 * 
	 **/
	public String execute() throws Exception {
		System.out.println("login in action");
		System.out.println("获取到的用户名：" + userName);
		System.out.println("获取到的密码：" + password);
		
		LoginService service = new LoginService();
		if(service.Login(this.userName,this.password)){
			System.out.println("登录成功");
			return "success";
		}else{
			System.out.println("登录失败");
			return "false";
		}	
	}

}
