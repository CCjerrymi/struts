<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page import="com.entity.Grade,com.action.GradeMangerAction"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>班级信息管理页面</title>
    
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
		<table>
			<tr>
				<th>班级信息表</th>
				<td><input type="button" value="点击查看所有班级信息" onclick="getAllInfo()"/></td>
			</tr>
			<tr>
				<td>班级号</td>
				<td>说明</td>
				<td>操作</td>
			</tr>
			 	<%
					GradeMangerAction action = new GradeMangerAction();
					List<Grade> list = action.getGrades();
					if(list.size()>0 || list!=null){
						for(int index = 0;index < list.size();index++){
							Grade grade = list.get(index);
							%>
						<tr>
							<td class="tableHead" id="classNumber"><%=grade.getClassNumber()%></th>
	      				 	<td class="tableHead" id="className"><%=grade.getClassName()%></th>
	        			  	<td class="tableHead" align="center">
	        			  		<input type="button" value = "查看学生" onclick="getStudents(<%=grade.getClassNumber()%>)"/>
	        			  		<input type="button" value = "添加学生"  onclick="addStudent(<%=grade.getClassNumber()%>)"/>
	        			  		<input type="button" value = "删除班级"  onclick="deleteGrade(<%=grade.getClassNumber()%>)"/>
	        			  	</td> 
	   		 			</tr>
	   		 		<%
	   		 		}} %>
				
		</table>

	</div>
  </body>
  
  <%-- <script type="text/javascript" src="/struts/module/js/grade.js"></script> --%>
    <script type="text/javascript" src="/struts/module/js/grade.js"></script>
   <script type="text/javascript" src="/struts/module/js/jquery-2.1.4.js"></script>
    <script type="text/javascript" src="/struts/module/js/jquery-2.1.4.min.js"></script>
</html>
