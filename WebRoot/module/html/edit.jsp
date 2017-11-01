<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.action.SearchAction,com.entity.Student,java.util.ArrayList"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Student student = SearchAction.temp;
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>编辑界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="../struts/module/css/edit.css">
  </head>
  
  <body>
   	<div id="total"> 	 	
   	 	<div id="mainInfo">
			<ul>
				<li><label>班级</label><input type="text" id="stuClassNumber" value="<%=student.getStuClassNumber()%>"/></li>
				<li><label>学号</label><input type="text" id="stuNumber" value="<%=student.getStuNumber()%>"/></li>
				<li><label>姓名</label><input type="text" id="stuName" value="<%=student.getStuName()%>"/></li>
				<li><label>年龄</label><input type="text" id="stuAge" value="<%=student.getAge()%>"></li>
				<li><input type="button" value = "确认" onclick="edit()"/><input type="button" value="取消" onclick="cancel()"/></li>
				
				
			</ul>   	 	
   	 	</div>
   	
   	
   	
   	</div>
  </body>
    <script type="text/javascript" src="/struts/module/js/edit.js"></script>
    <script type="text/javascript" src="/struts/module/js/jquery-2.1.4.js"></script>
    <script type="text/javascript" src="/struts/module/js/jquery-2.1.4.min.js"></script>
</html>
