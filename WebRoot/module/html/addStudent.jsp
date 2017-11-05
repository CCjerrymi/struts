<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
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
	<link rel="stylesheet" type="text/css" href="../struts/module/css/addStudent.css">

  </head>
  
  <body>
    <div id="total">
    	<div id="info">   		
    		  <form action="addStudent.action">
    		  	<table  width="300" border="1">
    		  		<tr class="tableStyle" style="color:white" bgcolor="black">
	    		  		<td align="center" colspan="2" >添加学生信息</td>
    		  		</tr>
    		  		<tr class="tableStyle">
	    		  		<td align="center" class="myInfo">班级</td>
		    			<td><input type="text" name="stuClassNumber" id="stuClassNumber" readonly="readonly" class="myTips"/></td>
    		  		</tr>
	    			<tr class="tableStyle">
	    		  		<td align="center">学号</td>
		    			<td><input type="text" name="stuNumber" placeholder="请输入学号" class="myTips"/></td>
    		  		</tr>
    		  		
	    			<tr class="tableStyle">
	    		  		<td align="center">姓名</td>
		    			<td><input type="text" name="stuName" placeholder="请输学生入姓名" class="myTips"/></td>
    		  		</tr>
    		  		
    		  		<tr class="tableStyle">
	    		  		<td align="center">年龄</td>
		    			<td><input type="text" name="age" placeholder="请输入学生年龄" class="myTips"/></td>
    		  		</tr>
    		  		
    		  		<tr class="tableStyle">
	    		  		<td align="center" colspan="2"><input type="submit" value="提交" class="myButton"/><input type="button" value="取消" class="myButton" onclick="cancel()"/> </td>
    		  			
    		  		</tr>
	    			
	    			
	    			
    			</table>
    		</form>
    		
    	
    	</div>
    
    
    </div>
  </body>

	<script type="text/javascript" src="/struts/module/js/addStudent.js"></script>
</html>
