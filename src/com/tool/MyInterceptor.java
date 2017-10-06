package com.tool;

import java.util.Map;

import javax.servlet.http.HttpSession;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class MyInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		// 获取ActionContext对象
		
		ActionContext actionContext = invocation.getInvocationContext();

		String actionName = actionContext.getName();
		System.out.println("拦截请求！" + actionName);
		//登录以外的所有请求都进行拦截
		if (!"login".equals(actionName)) {
			// 获取session
			HttpSession session = SessionTool.getSesison();
			Object loginName = session.getAttribute("logiName");
			Object password = session.getAttribute("password");
			
			//验证是否登录
			if (loginName == null || loginName == "" || password == null
					|| password == "") {
				actionContext.put("msg", "您还未登录，请先登录！");
				// 验证不通过则自动跳转到登录页面
				return Action.LOGIN; 
			} else {
				//验证通过放行
				return invocation.invoke();
			}

		} else {
			//对登录直接放行
			return invocation.invoke();
		}
	}

}
