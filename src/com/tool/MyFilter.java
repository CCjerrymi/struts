package com.tool;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * 检测用户是否登录否过滤器，未登录则跳转到登录页面，
 * 
 * 
 **/

public class MyFilter implements Filter{
	protected FilterConfig filterConfig = null;
	private String redirectURL = null;
	private Set<String> notCheckURLList = new HashSet<String>();
	private String sessionKey = null;

	@Override
	public void destroy() {
		notCheckURLList.clear();
		
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse)servletResponse;
		HttpSession session = request.getSession();
		
		if(sessionKey == null) {
			filterChain.doFilter(request,response);
			return;
		}
		
		if((!checkRequestURLIntNotFilterList(request))&&session.getAttribute("users") == null) {
			response.sendRedirect(request.getContextPath() + redirectURL);
			return;
		}
		
		filterChain.doFilter(servletRequest, servletResponse);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
			this.filterConfig = filterConfig;
			redirectURL = filterConfig.getInitParameter("redirectURL");
			sessionKey = filterConfig.getInitParameter("checkSessionKey");
			String notCheckURLListString = filterConfig.getInitParameter("notCheckURLList");
			
			if(notCheckURLListString != null){
				System.out.println(notCheckURLListString);
				String[] params = notCheckURLListString.split(",");
				
				for(int i = 0; i < params.length; i++){
					notCheckURLList.add(params[i].trim());
				}
				
			}
	}
	
	private boolean checkRequestURLIntNotFilterList(HttpServletRequest request){
		String url = request.getServletPath() + (request.getPathInfo() == null ? "":request.getPathInfo());
		String temp = request.getRequestURI();
		temp = temp.substring(request.getContextPath().length() + 1);
		return notCheckURLList.contains(url);
	}

		
}
