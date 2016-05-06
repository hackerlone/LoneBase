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
  </head>
  
  <body>
   <div>
   	<table border="1">
   	  <tr><th>模板编号</th><th>管理员编号</th><th>个人编号</th><th>模板名称</th><th>操作</th></tr>
   	  	<tbody>
   	  		<s:iterator value="#request.models" var="mos">
	   	  		<tr>
				  	<td><s:property value="#mos.MId" /></td>
				   <td><s:property value="#mos.vita.JId" /></td>
				    <td><s:property value="#mos.admin.AId"/></td>
				    <td><s:property value="#mos.MUrl"/></td>
				    <td><a href="mo_getModelById.action?id=<s:property value='#mos.MId'/>&option=update" >修改</a>
				    </td>
				    
			     </tr>
			</s:iterator>
	    </tbody>
    </table>
			 <page:paging offset="${pageInfo.firstResult}" 
                  pageSize="${pageInfo.maxResults}" 
        totalRecords="${pageInfo.itemCount}"
        href="/MTCampus/mo_getAllModel.action"/>
   </div>
   
  </body>
</html>
