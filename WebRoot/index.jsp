<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>登录页面</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="index.css">
</head>

<body>
	<div id="main">
		<div id="info">
				<!-- <table align="center">
				   <tr>
						<td><label>用户名</label></td>
						<td><input type="text" id="userName"/></td>
					</tr>	
					<tr>
						<td><label>密 &nbsp&nbsp码</label></td>		
						<td><input type="password" id="password"/></td>			
					</tr>	
					<tr>
						<td colspan="2" align="right"><input type="button" value="提交" onClick="login()"/></td>
					</tr>				
				</table> -->
				<form action="login" method="post" name="form1" id="loginForm">
 				用户名：
				<s:textfield name="userName" />
 				密码：
 				<s:password name="password" />
 				<input type="button" onClick="login()" value="登录"/>
			</form>
			
		</div>

	</div>

	
</body>

   <script type="text/javascript" src="module/js/jquery-2.1.4.js"></script>
   <script type="text/javascript" src="module/js/jquery-2.1.4.min.js"></script>
   <script type="text/javascript" src="index.js"></script>
</html>
