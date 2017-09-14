package com.action;

import com.opensymphony.xwork2.ActionSupport;


public class LoginAction extends ActionSupport {
	/**
	 * 方法描述：注册一个Action（登录的Action），当前台请求的时候，通过过滤器调用该方法
	 * 
	 **/
	public String execute() throws Exception {
		return "success";
	}

}
