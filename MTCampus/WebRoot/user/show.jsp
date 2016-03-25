<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="page" uri="/WEB-INF/paging.tld" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="style/font-awesome.css"> 
  <link rel="stylesheet" href="style/jquery-ui.css"> 
  <link rel="stylesheet" href="style/fullcalendar.css">
  <link rel="stylesheet" href="style/prettyPhoto.css">  
  <link rel="stylesheet" href="style/rateit.css">
  <link rel="stylesheet" href="style/bootstrap-datetimepicker.min.css">
  <link rel="stylesheet" href="style/jquery.cleditor.css"> 
  <link rel="stylesheet" href="style/uniform.default.css"> 
  <link rel="stylesheet" href="style/bootstrap-switch.css">
  <link href="style/style.css" rel="stylesheet">
  <link href="style/widgets.css" rel="stylesheet">   
  <script src="js/html5shim.js"></script>
  </head>
  
  <body>
   <div>
   	<table border="1" class="table table-striped table-bordered table-hover">
   	  <tr></tr>
   	  	<tbody>
   	  		<s:iterator value="#request.admins" var="admins">
	   	  		<tr>
	   	  		
				  	<td><s:property value="#admins.AId" /></td>
				  	<td><s:property value="#admins.AName" /></td>
				  	<td><s:property value="#admins.APwd" /></td>
				  	<td><s:property value="#admins.AEmalil" /></td>
				  	<td><s:property value="#admins.APhone" /></td>
				   
				    <td><a href="user_getVitaById.action?id=<s:property value='#vitas.j_id'/>&option=update" >修改</a>
				    </td>
			     </tr>
			</s:iterator>
	    </tbody>
    </table>
 
			 <page:paging offset="${pageInfo.firstResult}" 
                  pageSize="${pageInfo.maxResults}" 
        totalRecords="${pageInfo.itemCount}"
        href="/MTCampus/user_getAllAdmin.action"/>
        
   </div>
   
  </body>
</html>
