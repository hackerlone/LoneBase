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
	
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<SCRIPT type="text/javascript" src="js/jquery-1.4.1.js"></SCRIPT>
<style type="text/css">
	img {
    width: 140px;
    height: 140px;
    border-radius: 50%;
    display: inline-block;
    margin: 10px auto 0;
}
</style>
  </head>
  
  <body>
   <div>
   	<table border="1" class="table table-striped table-bordered table-hover">
   	  <tr><th>编号</th><th>姓名</th><th>密码</th><th>性别</th><th>邮箱</th>
   	  		<th>联系电话</th><th>头像</th><th>年龄</th><th>简历份数</th><th>操作</th></tr>
   	  	<tbody>
   	  		<s:iterator value="#request.students" var="stus" status="s">
   	  		
	   	  		<tr>
				  	<td><s:property value="#stus.UId" /></td>
				   <td><s:property value="#stus.UName" /></td>
				    <td><s:property value="#stus.UPwd"/></td>
				    
				       <td> <s:if test="#stus.USex==0">男</s:if>
   				 		<s:elseif test="#stus.USex==1">女</s:elseif>
    				 </td>
				    
				    <td><s:property value="#stus.UEmail"/></td>
				    <td><s:property value="#stus.UPhone"/></td>
				    <td><img id="headimg" src="upload/<s:property value="#stus.UTouxiang"/>"/></td>
	   				<td><s:property value="#request.ages[#s.getIndex()]"/></td>
	   				<td><s:property value="#request.vitas.size"/></td>
	   				
				    <td><a href="stu_getStudentById.action?student.UId=<s:property value='#stus.UId'/>&option=update" >修改</a>
				    </td>
				    <td><a href="stu/add.jsp" >添加</a>
				    </td>
				    
			     </tr>
			     
			      
			</s:iterator>
	    </tbody>
    </table>
    <ul class="pagination pull-right">
			 <page:paging offset="${pageInfo.firstResult}" 
                  pageSize="${pageInfo.maxResults}" 
        totalRecords="${pageInfo.itemCount}"
        href="/MTCampus/stu_getAllStudent.action"/>
        </ul>
   </div>
   
  </body>
</html>
