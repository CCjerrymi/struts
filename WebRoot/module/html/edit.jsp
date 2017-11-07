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
	<link rel="stylesheet" type="text/css" href="../struts/module/css/addStudent.css">
  </head>
  
  <body>
  
   <div id="total">
    	<div id="info">   		
    		  <form action="addStudent.action">
    		  	<table  width="300" border="1">
    		  		<tr class="tableStyle" style="color:white" bgcolor="black">
	    		  		<td align="center" colspan="2" >编辑学生信息</td>
    		  		</tr>
    		  		<tr class="tableStyle">
	    		  		<td align="center" class="myInfo">班级</td>
		    			<td><input type="text" name="stuClassNumber" id="stuClassNumber" readonly="readonly" class="myTips" value="<%=student.getStuClassNumber()%>"/></td>
    		  		</tr>
	    			<tr class="tableStyle">
	    		  		<td align="center">学号</td>
		    			<td><input type="text" name="stuNumber" id="stuNumber" class="myTips" value="<%=student.getStuNumber()%>"/></td>
    		  		</tr>
    		  		
	    			<tr class="tableStyle">
	    		  		<td align="center">姓名</td>
		    			<td><input type="text" name="stuName" id="stuName" class="myTips" value="<%=student.getStuName()%>"/></td>
    		  		</tr>
    		  		
    		  		<tr class="tableStyle">
	    		  		<td align="center">年龄</td>
		    			<td><input type="text" name="age" id="age" class="myTips" value="<%=student.getAge()%>"/></td>
    		  		</tr>
    		  		
    		  		<tr class="tableStyle">
	    		  		<td align="center" colspan="2"><input type="button" value="确认" class="myButton" onclick="edit()"/><input type="button" value="取消" class="myButton" onclick="cancel()"/> </td>
    		  			
    		  		</tr>
	    			
	    			
	    			
    			</table>
    		</form>
    		
    	
    	</div>
    
    
    </div>
  </body>
    <script type="text/javascript" src="/struts/module/js/edit.js"></script>
    <script type="text/javascript" src="/struts/module/js/jquery-2.1.4.js"></script>
    <script type="text/javascript" src="/struts/module/js/jquery-2.1.4.min.js"></script>
</html>
