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
	<script type="text/javascript" src="js/jquery-1.4.1.js"></script>
	<script type="text/javascript">
		
	
	</script>
	
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
   	  <tr><th>职位编号</th><th>企业编号</th><th>职位名称</th><th>入职时间</th><th>工作地点</th>
   	  		<th>人数</th><th>职能</th><th>描述</th><th>薪资</th>
   	  		
   	  		</tr>
   	  	<tbody>
   	  	
   	  		<s:iterator value="#request.jobs" var="jobs">
	   	  			<tr>
				  	<td><s:property value="#jobs.ZId" /></td>
				  	<td><s:property value="#jobs.enterprise.QId" /></td>
				  	<td><s:property value="#jobs.ZName" /></td>
				  	<td><s:property value="#jobs.ZDate" /></td>
				  	<td><s:property value="#jobs.ZArea" /></td>
				  	<td><s:property value="#jobs.ZRenshu" /></td>
				  	<td><s:property value="#jobs.ZZhineng" /></td>
				  	<td><s:property value="#jobs.ZMiaoshu" /></td>
				  	<td><s:property value="#jobs.ZXinzi" /></td>
				  	<td><a href="/MTCampus/job_getJobById.action?id=<s:property value="#jobs.ZId"/>&option=sec">查看详情</a><br /></td>
  				  		    
			     </tr>
			</s:iterator>
			
	    </tbody>
    </table>
  
     <page:paging offset="${pageInfo.firstResult}" 
                  pageSize="${pageInfo.maxResults}" 
        totalRecords="${pageInfo.itemCount}"
        href="/MTCampus/job_getAllJob.action"/>
        
    
   </div>
  </body>
</html>
