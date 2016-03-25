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
   	  <tr><th>简历编号</th><th>实习生编号</th><th>姓名</th><th>性别</th><th>出生日期</th><th>政治面貌</th><th>联系地址</th><th>毕业学校</th>
   	  		<th>专业</th><th>工作经历</th><th>学历</th><th>邮箱</th><th>简介</th><th>操作</th></tr>
   	  	<tbody>
   	  		<s:iterator value="#request.vitas" var="vitas" status="s">
	   	  		<tr>
	   	  		
				  	<td><s:property value="#vitas.JId" /></td>
				   <td><s:property value="#vitas.student.UId" /></td>
				    <td><s:property value="student.UName" /></td>
				     <td> <s:if test="student.USex==0">男</s:if>
   				 		<s:elseif test="student.USex==1">女</s:elseif>
    				 </td>
				    <td><s:property value="student.UBirthday" /></td>
				    <td><s:property value="#vitas.JFace" /></td>
				    <td><s:property value="#vitas.JDizhi" /></td>
				    <td><s:property value="#vitas.JByxx" /></td>
				    <td><s:property value="#vitas.JZy" /></td>
				    <td><s:property value="#vitas.JGzjl" /></td>
				    <td><s:property value="#vitas.JXl" /></td>
				    <td><s:property value="student.UEmail" /></td>
				    <td><s:property value="#vitas.JJianjie" /></td>
				    <td><a href="vit_getVitaById.action?id=<s:property value='#vitas.JId'/>&option=update" >修改</a>
				    <a href="vit_deleteVita.action?id=<s:property value='#vitas.JId'/>&option=delete" >删除</a>
				    
				    </td>
				    <td><a href="vita/add.jsp">添加</a></td>
			     </tr>
			</s:iterator>
	    </tbody>
    </table>
  <ul class="pagination pull-right">
			 <page:paging offset="${pageInfo.firstResult}" 
                  pageSize="${pageInfo.maxResults}" 
        totalRecords="${pageInfo.itemCount}"
        href="/MTCampus/vit_getAllVita.action"/>
        《、
   </div>
   
  </body>
</html>
