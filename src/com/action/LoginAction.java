package com.action;

import com.entity.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.LoginService;
import com.tool.BeanTool;


public class LoginAction extends ActionSupport implements ModelDriven{
	private User user = new User();
	private LoginService loginService;
	
	/*@Resource(name="loginService")
	LoginService service;*/



	/**
	 * 方法描述：注册一个Action（登录的Action），当前台请求的时候，通过过滤器调用该方法
	 * 
	 **/
	public String execute() throws Exception {
		System.out.println("login in action");
		System.out.println("获取到的用户名：" + user.getUserName());
		System.out.println("获取到的密码：" + user.getPassword());
		
		//LoginServiceImpl service = new LoginServiceImpl();
		//LoginService loginService = new LoginService();
		loginService = (LoginService) BeanTool.getBean("loginService");
		
		try{
			if(loginService.Login(this.user.getUserName(),this.user.getPassword())){
				System.out.println("登录成功");
				return "success";
			}else{
				System.out.println("登录失败");
				return "false";
			}	
			
		}catch(Exception e){
			e.printStackTrace();
			return "";
		}
		
	}

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return user;
	}

}
