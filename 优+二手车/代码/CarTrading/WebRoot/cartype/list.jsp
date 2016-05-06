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
    <title>My JSP 'reg.jsp' starting page</title>
    <link rel="stylesheet" type="text/css"  href="../css/reg.css">
  </head>
  <body>
  <table border="1">
  <tr><td>编号</td><td>车型</td><td>父ID</td><td colspan="2">操作</td></tr>
   <s:iterator value="#request.carTypes" var="cartype">
    <tr><td><s:property value="#cartype.ctId"/></td>
    <td><s:property value="#cartype.ctName"/></td>
    <td><s:property value="#cartype.ctPid"/></td>
    <td><a href="cartype_getCarTypeById.action?id=<s:property value='#cartypet.id'/>&option=update" >修改</a></td>
    </tr>
   </s:iterator>
   </table>
    <page:paging offset="${pageInfo.firstResult}" 
                  pageSize="${pageInfo.maxResults}" 
        totalRecords="${pageInfo.itemCount}"
        href="/CarTrading/cartype_getAllCarType.action"/>
  </body>
</html>
