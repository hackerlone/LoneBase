<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
    <a href="/MTCampus/stu_getAllStudent.action">所有实习生</a>
    <a href="/MTCampus/vit_getAllVita.action">所有简历</a>
    <a href="/MTCampus/qy_getAllEnterprise.action">所有企业</a>
    <a href="/MTCampus/job_getAllJob.action">所有职位</a>
    <a href="/MTCampus/user_getAllUser.action">所有管理员</a>
    <a href="/MTCampus/mo_getAllModel.action">所有模板</a>
    <a href="/MTCampus/select.jsp">查询职位</a>
  </body>
</html>
