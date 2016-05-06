<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
    <tr>
    <td><a href="http://192.168.20.173:8089/CarTrading/admin_getAllAdmin.action" >管理员</a></td>
  	    <td><a href="http://192.168.20.173:8089/CarTrading/user_getAllUser.action" >用户</a></td>
  	    <td><a href="http://192.168.20.173:8089/CarTrading/cartype_getAllCarType.action" >车辆类型</a></td>
  	
  	    <td><a href="http://192.168.20.173:8089/CarTrading/car_getAllCar.action" >车辆信息</a></td>
  	
  </tr>
  </body>
</html>
