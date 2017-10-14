<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page import="com.action.SearchAction,com.entity.Student,java.util.ArrayList"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>学生信息查询功能界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="../css/search.css">

  </head>
  
  <body>
    	<div id="main">
		<div id="info">
			<!--condition-->
			<div id="condition">
				<ul id="searchCondition">
					<li id="tip"><span >属性</span></li>
					<li>
						<select id="argumentsType" onchange="argumentsChange()">
							<option value="stuName">姓名</option>
							<option value="stuNumber">学号</option>
							<option value="age">年龄</option>
						</select>
					</li>

					<li>
						<!--下拉框的值动态添加-->
						<select id="selects">
							<option value="1">包含</option>
							<option value="0">等于</option>							
						</select>
					</li>
					<li><input type="text" name="value" id="inputValue"/></li>
					
					<li><input type="button" name="search" value="查询" onclick="searchResult()"></li>
					<!-- <a href="#">新增</a>		 -->	
				</ul>	
			</div>	

			<!--此处可使用EL表达式对返回的结构进行处理-->
			<!--信息展示部分-->
			<div id="table">
				<table width="500" border="1">
   				    <tr style="color:white" bgcolor="black">
      				 	<td class="tableHead">学号</td>
        			  	<td class="tableHead">姓名</td>
						<td class="tableHead" align="right">年龄</td>
						<!-- <th width="80" align="center">操作</th> -->
   		 			</tr>
   		   		   <!--展示从后台获取到的数据-->
   		   		   <%
					SearchAction action = new SearchAction();
					ArrayList<Student> list = action.getresult();
					if(list.size()>0 || list!=null){
						for(int index = 0;index < list.size();index++){
							Student student = list.get(index);
							%>
						<tr>
	      				 	<td class="tableHead"><%=student.getStuNumber()%></th>
	        			  	<td class="tableHead"><%=student.getStuName()%></th>
	        			  	<td class="tableHead" align="right"><%=student.getAge()%></th>
	        			  	<!-- <td width="80" align="center">
	        			  		<a href="#">编辑</a>
	        			  		<a href="#">删除</a>	
	        			  	</td> -->
	   		 			</tr>
							<% 
						}%>
						<tr>
							<td align="center" colspan="3">共<%=list.size() %>人</td>
						</tr>
					<%} %>
					
				</table>
				

			</div>
			
			<div>
				<s:form action="upload" method="post" enctype="multipart/form-data"	>
					<s:file name="file" label="上传文件"/>
					<s:submit value="上传"/>
					<s:reset value="重置"/>					
				</s:form>
			</div>	
			 
			
		</div>
		
		
	</div>
  </body>
  <script type="text/javascript" src="../js/search.js"></script>
   <script type="text/javascript" src="../js/jquery-2.1.4.js"></script>
    <script type="text/javascript" src="../js/jquery-2.1.4.min.js"></script>
</html>
