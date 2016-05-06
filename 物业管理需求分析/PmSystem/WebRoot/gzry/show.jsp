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
    
    <title>My JSP 'show.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	  <link href="style/bootstrap.css" rel="stylesheet">
  <!-- Font awesome icon -->
  <link rel="stylesheet" href="style/font-awesome.css"> 
  <!-- jQuery UI -->
  <link rel="stylesheet" href="style/jquery-ui.css"> 
  <!-- Calendar -->
  <link rel="stylesheet" href="style/fullcalendar.css">
  <!-- prettyPhoto -->
  <link rel="stylesheet" href="style/prettyPhoto.css">  
  <!-- Star rating -->
  <link rel="stylesheet" href="style/rateit.css">
  <!-- Date picker -->
  <link rel="stylesheet" href="style/bootstrap-datetimepicker.min.css">
  <!-- CLEditor -->
  <link rel="stylesheet" href="style/jquery.cleditor.css"> 
  <!-- Uniform -->
  <link rel="stylesheet" href="style/uniform.default.css"> 
  <!-- Bootstrap toggle -->
  <link rel="stylesheet" href="style/bootstrap-switch.css">
  <!-- Main stylesheet -->
  <link href="style/style.css" rel="stylesheet">
  <!-- Widgets stylesheet -->
  <link href="style/widgets.css" rel="stylesheet">   
  
  <!-- HTML5 Support for IE -->
  <!--[if lt IE 9]>
  <script src="js/html5shim.js"></script>
  <![endif]-->

  <!-- Favicon -->
  <link rel="shortcut icon" href="img/favicon/favicon.png">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<!--  <script type="text/javascript">
	window.onload=function()
	{
		var oBtn=document.getElementById("btn1");
		var add1=document.getElementById("add"); 
		add1.style.display="none";
		oBtn.onclick=function(){
		if(add1.style.display=="none")
		{
			add1.style.display="block";
		}
		else
		{
			add1.style.display="none";
		}
	} }
	  </script>-->
  </head>
  <body>
<div align="center"><font size="20">工作人员</font></div><br />
    <!-- 添加 -->
  
	<div class="widget">

                <div class="widget-head">
                  <div class="pull-left">Tables</div>
                  <div class="widget-icons pull-right">
                    <a href="main.jsp" class="wminimize"><i class="icon-chevron-up"></i></a> 
                    <a href="#" class="wclose"><i class="icon-remove"></i></a>
                  </div>  
                  <div class="clearfix"></div>
                </div>

                  <div class="widget-content">

                    <table class="table table-striped table-bordered table-hover">
                      <thead>
                        <tr>
   		<th>工作人员编号</th>
   		<th>物管ID</th>
   		<th>在职状态</th>
   		<th>工作时间</th>
   		<th>操作</th>
                        </tr>
                      </thead>
                      <tbody>
   		

    <c:forEach var="gzry" items="${gzrys}" >
     <tr>
      <td>${gzry.gz_bianhao }</td>
      <td>${gzry.w_id }</td>
      <td>${gzry.gz_qk }</td>
      <td>${gzry.gz_nb }</td>
       <td>
<c:if test="${sessionScope.name=='admin'}">  
                              <button class="btn btn-xs btn-success" title="增加"><a href="GzryS?option=add"><i class="icon-ok"></i></a> </button>
                              <button class="btn btn-xs btn-warning" title="修改"><a href="GzryS?option=UpdateById&id=${gzry.gz_bianhao }"><i class="icon-pencil"></i> </a></button>
                              <button class="btn btn-xs btn-danger" title="删除"><a href="GzryS?option=deleteById&id=${gzry.gz_bianhao }"><i class="icon-remove"></i></a> </button>
  </c:if>
     </tr>
</c:forEach>

                      </tbody>
                    </table>

                    <div class="widget-foot">

  <!-- 分页 --><ul class="pagination pull-right">
      <page:paging href="GzryS?option=getByPage" totalRecords="${pageinfo.itemCount}" 
    offset="${pageinfo.firstResult}" pageSize="${pageinfo.maxResults}"/>
  <!-- 添加 -->
</ul>
                       
                         
                     
                      <div class="clearfix"></div> 

                    </div>

                  </div>

                </div>
  </body>
</html>
