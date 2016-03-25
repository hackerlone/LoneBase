<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
   contentType="text/html; charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<%@ taglib uri="/WEB-INF/paging.tld" prefix ="page" %>
<title>服装销售管理系统</title>
<!--                       CSS                       -->
<!-- Reset Stylesheet -->
<link rel="stylesheet" href="resources/css/reset.css" type="text/css" media="screen" />
<!-- Main Stylesheet -->
<link rel="stylesheet" href="resources/css/style1.css" type="text/css" media="screen" />
<!-- Invalid Stylesheet. This makes stuff look pretty. Remove it if you want the CSS completely valid -->
<link rel="stylesheet" href="resources/css/invalid.css" type="text/css" media="screen" />
<!--                       Javascripts                       -->
<!-- jQuery -->
<script type="text/javascript" src="resources/scripts/jquery-1.3.2.min.js"></script>
<!-- jQuery Configuration -->
<script type="text/javascript" src="resources/scripts/simpla.jquery.configuration.js"></script>
<!-- Facebox jQuery Plugin -->
<script type="text/javascript" src="resources/scripts/facebox.js"></script>
<!-- jQuery WYSIWYG Plugin -->
<script type="text/javascript" src="resources/scripts/jquery.wysiwyg.js"></script>
<!-- jQuery Datepicker Plugin -->
<script type="text/javascript" src="resources/scripts/jquery.datePicker.js"></script>
<script type="text/javascript" src="resources/scripts/jquery.date.js"></script>
</head>
<body>
<div id="body-wrapper">
  <!-- Wrapper for the radial gradient background -->
  
  <!-- End #sidebar -->
  <div id="main-content">
    <!-- Main Content Section with everything -->
    <noscript>
    <!-- Show a notification if the user has disabled javascript -->
    </noscript>
    <!-- Page Head -->
    <h2></h2>
   
    <!-- End .shortcut-buttons-set -->
    
    <!-- End .clear -->
    <br /><br /><br />
    <div class="content-box">
      <!-- Start Content Box -->
      <div class="content-box-header">
        <h3>客户信息表</h3>
        <ul class="content-box-tabs">
          <li><a href="#tab1" class="default-tab">Table</a></li>
          <!-- href must be unique and match the id of target div -->
         
        </ul>
        <div class="clear"></div>
      </div>
      <!-- End .content-box-header -->
      <div class="content-box-content">
        <div class="tab-content default-tab" id="tab1">
          <!-- This is the target div. id must match the href of this div's tab -->
          
          <table border="5">
            <thead>
              <tr>
               
                <th>客户编号</th>
                <th>客户积分</th>
                <th>客户姓名</th>
                <th>客户密码</th>
                <th>购买数量</th>
                <th>联系方式</th>
                 <th>退货次数</th>
                 <th>操作</th>
              </tr>
            </thead>
          
    <c:forEach var="customer" items="${customers}" >
     <tr>
      <td>${customer.k_id }</td>
      <td>${customer.k_integ }</td>
      <td>${customer.k_name }</td>
      <td>${customer.k_pwd }</td>
      <td>${customer.k_number }</td>
      <td>${customer.k_tel }</td>
      <td>${customer.k_return }</td>
      <td>
        
        <a href="CustomerS?option=deleteById&id=${customer.k_id }" title="删除"><img src="resources/images/icons/cross.png" alt="Delete" /></a>
       <a href="CustomerS?option=alterById&id=${customer.k_id}" title="修改"><img src="resources/images/icons/hammer_screwdriver.png" alt="Update" /></a>
      
       </td>
       <td><a href="CustomerS?option=showchart&type=bar&k_id=${customer.k_id }" title="柱状图"><img src="resources/images/icons/hammer_screwdriver.png"   /></a> 
      </td>
      <td><a href="CustomerS?option=showchart&type=pie&k_id=${customer.k_id }" title="饼图"><img src="resources/images/icons/hammer_screwdriver.png"   /></a> 
      </td>
      </tr>
      </c:forEach> 
  
           
          </table>
              <page:paging href="CustomerS?option=getByPage" totalRecords="${pageinfo.itemCount}" offset="${pageinfo.firstResult}"
   pageSize="${pageinfo.maxResults}"/>
   



        </div>
 
        </div>
        </div>
        </div>
        </div>
    </body>
<!-- Download From www.exet.tk-->
</html>
