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

  </head>
  
  <body>
  <div align="center"><font size="20">业主信息查询 </font></div><br />
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

                    <table class="table table-striped table-bordered table-hover">
                      <thead>
                        <tr>
        <th>业主编号</th>
   		<th>业主姓名</th>
   		<th>业主年龄</th>
   		<th>家庭住址</th>
   		<th>身份证号</th>
   		<th>入住时间</th>
   		<th>联系方式</th>
   		<th>楼道编号</th>
   		<th>密码</th>
   		<th>操作</th>
                        </tr>
                      </thead>
                      <tbody>

                          <c:forEach var="yz" items="${yzs}" >
     <tr>
      <td>${yz.o_id }</td>
      <td>${yz.o_xm }</td>
      <td>${yz.o_nl }</td>
      <td>${yz.o_jtzz }</td>
      <td>${yz.o_sfzhm }</td>
      <td>${yz.o_rzsj }</td>
      <td>${yz.o_lxfs }</td>
      <td>${yz.w_id }</td>
      <td>${yz.o_pwd }</td>
                          <td>

                              <button class="btn btn-xs btn-success" title="增加"><a href="YzS?option=add"><i class="icon-ok"></i></a> </button>
                              <button class="btn btn-xs btn-warning" title="修改"><a href="YzS?option=UpdateById&id=${yz.o_id }"><i class="icon-pencil"></i> </a></button>
                              <button class="btn btn-xs btn-danger" title="删除"><a href="YzS?option=deleteById&id=${yz.o_id }"><i class="icon-remove"></i></a> </button>
                          </td>
                          <td>
                              <button class="btn btn-xs btn-warning" ><a href="YzS?option=showchart&type=bar&o_id=${yz.o_id }">柱状图</a></button>
                              <button class="btn btn-xs btn-danger" ><a href="YzS?option=showchart&type=pie&o_id=${yz.o_id }">饼图</a> </button>
                          </td>
                          
                        </tr>
                        
</c:forEach>

                      </tbody>
                    </table>

                    <div class="widget-foot">

                      <!-- 分页 -->
    <ul class="pagination pull-right">
      <page:paging href="YzS?option=getByPage" totalRecords="${pageinfo.itemCount}" 
    offset="${pageinfo.firstResult}" pageSize="${pageinfo.maxResults}"/>
    </ul>
 <div class="clearfix"></div> 
                    </div>
                  </div>

                </div>
  </body>
</html>
