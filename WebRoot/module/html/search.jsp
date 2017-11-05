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
				<table width="620" border="1">
   				    <tr style="color:white" bgcolor="black">
   				   		<td class="tableHead">班级</td>
      				 	<td class="tableHead">学号</td>
        			  	<td class="tableHead">姓名</td>
						<td class="tableHead" align="right">年龄</td>
						<th class="tableHead" align="center">操作</th>
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
							<td class="tableHead" id="stuClassNumber"><%=student.getStuClassNumber()%></th>
	      				 	<td class="tableHead" id="stuNumber"><%=student.getStuNumber()%></th>
	        			  	<td class="tableHead" id="stuName"><%=student.getStuName()%></th>
	        			  	<td class="tableHead" align="right" id="age"><%=student.getAge()%></th>
	        			  	<td class="tableHead" align="center">
	        			  		<input type="button" id="opb" value = "编辑" onClick="edit(<%=student.getStuNumber()%>)"/>
	        			  		<input type="button" id="opb" value = "删除" onClick="deleteStu(<%=student.getStuNumber()%>)"/>
	        			  	</td> 
	   		 			</tr>
							<% 
						}%>
						
						<tr>
							<td align="center" colspan="4">共<%=list.size() %>人</td>
							<td align="center"><!-- <input type="button" value="下载" onClick="downLoad()"/> -->
								<a href="http://localhost:8080/struts/downLoadAction.action?filename=struts2.txt">下载</a>
								<!-- <input type="button" value="上传" id="startUp" onClick="clickLoad()"/></td> -->
						</tr>
						<%--
						<tr>							
							<td align="center" colspan="5">
								<span>文件名：</span>
								<input type="text" id="fileName"/>
								<span>文件类型：</span>
								 <select id="fileType">
								  <option value=".txt">.txt</option>
								  <option value=".jpg">.jpg</option>
								  <option value=".doc">.doc</option>
								  <option value=".pdf">.pdf</option>
								</select> 
															
								<input type="button" value="下载结果" onClick="downLoad()"/></td>	</tr>--%>
						
						<tr id="upload">
							<td align="center" colspan="5">
								<form action="http://localhost:8080/struts/uploadFile.action" method="post" enctype="multipart/form-data" id="fileForm">
									<input type="file" name="file" id="okUp" label="上传文件" id="file"/>
									<input type="button" value="上传" onClick="upload()" class="myButton"/>
									<input type="reset" value="重置" class="myButton"/>					
								</form>
							</td>
						</tr>
					<%} %>
					
				</table>
				

			</div>
			
		</div>
		

		
		
	</div>
  </body>
  <script type="text/javascript" src="../js/search.js"></script>
   <script type="text/javascript" src="../js/jquery-2.1.4.js"></script>
    <script type="text/javascript" src="../js/jquery-2.1.4.min.js"></script>
</html>
