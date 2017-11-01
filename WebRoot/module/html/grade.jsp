<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page import="com.entity.Grade"%>
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
			</tr>
			<tr>
				<td>班级号</td>
				<td>说明</td>
				<td>操作</td>
			</tr>
			<s:iterator var="grade" value="grades">
				<tr>
					<td class="classId"><s:property value="#grade.classId"/></td>
					<td class="className"><s:property value="#grade.className"/></td>
				</tr>
			</s:iterator>
		</table>

	</div>
  </body>
</html>
