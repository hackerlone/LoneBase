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
    <p></p><p></p>
    <div class="content-box">
      <!-- Start Content Box -->
      
      <div class="content-box-header">
      
        <h3>服装信息表</h3>
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
               
                <th>服装编号</th>
                <th>供应商编号</th>
                <th>品牌编号 </th>
                <th>服装名称</th>
                <th>品牌名称</th>
                 <th>服装尺寸</th>
                 <th>服装销售价格</th>
                 <th> 服装进价</th>
                 <th> 服装数量</th>
                 <th>服装图</th>
                 <th>操作</th>
              </tr>
            </thead>
           
                
    <c:forEach var="clotings" items="${clotings}" >
     
     <tr>
      <td>${clotings.f_id }</td>
      <td>${clotings.s_id }</td>
      <td>${clotings.f_pid }</td>
       <td>${clotings.f_name }</td>
      <td>${clotings.f_brand }</td>
      <td>${clotings.f_model }</td>
       <td>${clotings.f_price}</td>
      <td>${clotings.f_bid }</td>
      <td>${clotings.f_number }</td>
      <td><img src="images/${clotings.f_img }" height="100" width="100"></td>
      <td>
        <a href="ClotingS?option=deleteById&id=${clotings.f_id }" title="删除"><img src="resources/images/icons/cross.png" alt="Delete" /></a>
       <a href="ClotingS?option=alterById&id=${clotings.f_id }" title="修改"><img src="resources/images/icons/hammer_screwdriver.png" alt="Update" /></a>
      
       </td>
      </tr>
      </c:forEach> 
  
           
          </table>
              <page:paging href="ClotingS?option=getByPage" totalRecords="${pageinfo.itemCount}" offset="${pageinfo.firstResult}"
   pageSize="${pageinfo.maxResults}"/>
     



        </div>
 
        </div>
        </div>
        </div>
        </div>
    </body>
<!-- Download From www.exet.tk-->
</html>
