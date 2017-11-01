<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
/* String stuClassNumber = (String)request.getAttribute("stuClassNumber"); */
String stuClassNumber = "001";
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>新增学生页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <div>
    	<div>
    		<form action="">
    			<label>班级</label>
    			<input type="text" name="stuClassNumber" value=<%=stuClassNumber%> disabled="disabled"/>
    			<label>学号</label>
    			<input type="text" name="stuNumber"/>
    			<label>姓名</label>
    			<input type="text" name="stuName"/>
    			<label>年龄</label>
    			<input type="text" name="age"/>
    			<input type="submit" value="提交"/>
    			<input type="button" value="取消"/> 
    		</form>
    	
    	</div>
    
    </div>
  </body>
</html>
