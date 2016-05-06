<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="page" uri="/WEB-INF/paging.tld" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>车辆信息操作</title>
    <link rel="stylesheet" type="text/css"  href="../css/reg.css">
  </head>
  <body>
  <table border="1">
  <tr><td>车辆编号</td>
  <!-- <td></td><td></td><td></td> -->
  <td>品牌</td><td>车系</td><td>车型</td><td>车牌所在地</td><td>行驶公里</td><td>上牌时间</td>
  <td>卖价</td><td>车辆图片</td><td>车辆简述</td><td>联系电话</td><td>交易人</td><td>交易地点</td>
  <td>年检有效期</td><td>交强险到期时间</td><td>是否保养</td><td>车辆用途</td>
  <td>交易次数</td><td>交易时间</td><td> 操作 </td></tr>
   <s:iterator value="#request.cars" var="car">
    <tr><td><s:property value="#car.CId"/></td>
<!-- 
    <td><s:property value="#car.UId"/></td>
    <td><s:property value="#car.ctId"/></td>
    <td><s:property value="#car.AId"/></td>
--> 
    <td><s:property value="#car.brand"/></td>
    <td><s:property value="#car.carseries"/></td>
    <td><s:property value="#car.chexing"/></td>
    <td><s:property value="#car.CArea"/></td>
    <td><s:property value="#car.kilometre"/></td>
    <td><s:property value="#car.registration"/></td>
    <td><s:property value="#car.price"/></td>
    <td><s:property value="#car.image"/></td>
    <td><s:property value="#car.introduce"/></td>
    <td><s:property value="#car.tel"/></td>
    <td><s:property value="#car.realname"/></td>
    <td><s:property value="#car.area"/></td>
    <td><s:property value="#car.nianjian"/></td>
    <td><s:property value="#car.insurance"/></td>
    <td><s:property value="#car.upkeep"/></td>
    <td><s:property value="#car.CUse"/></td>
    <td><s:property value="#car.CChange"/></td>
    <td><s:property value="#car.releasetime"/></td>
    <td><a href="stu_getStudentById.action?id=<s:property value='#student.id'/>&option=update" >修改</a></td>
    </tr>
   </s:iterator>
   </table>
    <page:paging offset="${pageInfo.firstResult}" 
                  pageSize="${pageInfo.maxResults}" 
        totalRecords="${pageInfo.itemCount}"
        href="/CarTrading/car_getAllCar.action"/>
  </body>
</html>
