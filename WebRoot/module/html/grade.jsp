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

	<link rel="stylesheet" type="text/css" href="../struts/module/css/grade.css">

  </head>
  
  <body>
   	<div id="allInfo">
   		<div id="main-info">
			<table width="620" border="1">
				<tr>
					<th align="center" colspan="3" bgcolor="black" style="color:white">班级信息表</th>
				</tr>
				<tr>
					<td align="right" colspan="3"><input type="button" value="点击查看" onclick="getAllInfo()"/></td>
				</tr>
				<tr>
					<td class="tips">班级号</td>
					<td class="tips">说明</td>
					<td align="center">操作</td>
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
		        			  	<td class="buttonHead" align="center">
		        			  		<input type="button" value = "查看学生" onclick="getStudents(<%=grade.getClassNumber()%>)"/>
		        			  		<input type="button" value = "添加学生"  onclick="addStudent(<%=grade.getClassNumber()%>)"/>
		        			  		<input type="button" value = "删除班级"  onclick="deleteGrade(<%=grade.getClassNumber()%>)"/>
		        			  	</td> 
		   		 			</tr>
		   		 		<%
		   		 		}} %>
					
			</table>
		</div>
	</div>
  </body>
  
  <%-- <script type="text/javascript" src="/struts/module/js/grade.js"></script> --%>
    <script type="text/javascript" src="/struts/module/js/grade.js"></script>
   <script type="text/javascript" src="/struts/module/js/jquery-2.1.1.js"></script>
    <script type="text/javascript" src="/struts/module/js/jquery-2.1.1.min.js"></script>
</html>
