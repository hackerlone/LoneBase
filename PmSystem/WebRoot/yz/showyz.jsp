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
<style type="text/css">
#bt{
margin-right: 20px;
}
</style>
  </head>
  
  <body>
  <div align="center"><font size="20" color="red">${yz.o_xm }您的个人信息 </font></div><br />
  <!-- 添加 -->
  
	<div class="widget">

                <div class="widget-head">
                  <div class="pull-left">Tables</div>
                  <div class="widget-icons pull-right">
                    <a href="main.jsp" class="wminimize"><i class="icon-chevron-up"></i></a> 
                    <a href="main.jsp" class="wclose"><i class="icon-remove"></i></a>
                  </div>  
                  <div class="clearfix"></div>
                </div>

                  <div class="widget-content">

                    <div align="center" class="table table-striped table-bordered table-hover">
                      <thead>
                        <tr>
        
                        </tr>
                      </thead>
                      <tbody>

                          <c:forEach var="yz" items="${yzs}" >
     
     <h2> <font size="5" color="red">${yz.o_xm }</font><font size="4">：您好，欢迎来到本小区物业管理系统</h2><br/><br />
     	<div align="left">
		<table class="table table-striped table-bordered table-hover">
		<tr>
     	 <td>您的编号：</td><td>${yz.o_id }</td>
      	<td>您的年龄：</td><td>${yz.o_nl }</td>
		</tr>
		<tr>
     	 <td>家庭住址：</td><td>${yz.o_jtzz }</td>
      	<td>身份证号：</td><td>${yz.o_sfzhm }</td>
		</tr>
		<tr>
      	<td>入住时间：</td><td>${yz.o_rzsj }</td>
      	<td>联系方式</td><td>${yz.o_lxfs }</td>
		</tr>
		<tr>
      	<td>您的物管</td><td>${yz.w_id }</td>
      	<td>密码</td><td>${yz.o_pwd }</td>
		</tr>
		</table>
         </div>                
<tr>
                              
                              <button class="btn btn-xs btn-warning" title="修改" id="bt"><a href="YzS?option=UpdateById&id=${yz.o_id }">信息不对？<i class="icon-pencil"></i> </a></button>
                              <button class="btn btn-xs btn-warning"  id="bt"><a href="YzS?option=showchart&type=bar&o_id=${yz.o_id }">缴费柱状图</a></button>
                              <button class="btn btn-xs btn-danger"  id="bt"><a href="YzS?option=showchart&type=pie&o_id=${yz.o_id }">缴费饼图</a> </button>      
                        </tr>
                        
</c:forEach>

                      </tbody>
                    </div>

                    <div class="widget-foot">

                      <!-- 分页 -->
   <!--  <ul class="pagination pull-right">
      <page:paging href="YzS?option=getByPage" totalRecords="${pageinfo.itemCount}" 
    offset="${pageinfo.firstResult}" pageSize="${pageinfo.maxResults}"/>
     --></ul>
 <div class="clearfix"></div> 
                    </div>
                  </div>

                </div>
  </body>
</html>
