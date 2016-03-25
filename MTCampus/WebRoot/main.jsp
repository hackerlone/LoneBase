<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<%@ taglib uri="/WEB-INF/paging.tld" prefix ="page" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>欢迎进入后台</title>
    
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
  <c:if test="${sessionScope.name=='yz'}">
  <iframe name="main" width="1050px" height="700px;" src="YzS?option=getByPage" id="src1" >
<!-- 调用模块iframe -->
</iframe>
</c:if>
  <br/><br/><br/><br/>
 <div align="center"> <font size="14" >尊敬的网站管理员：<br/><br/> 欢迎来到 美途校园网后台系统。<br/>
    	<br/>   <font size="15" color="red">数据无价，请谨慎操作！！</font>
    </font>	 
</div>
  </body>
</html>
