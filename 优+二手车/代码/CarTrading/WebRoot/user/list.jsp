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
  <tr><td>编号</td><td>昵称</td><td>密码</td><td>头像</td><td>优+币</td><td>电话</td><td>用户类型</td><td>联系地址</td><td colspan="2">操作</td></tr>
   <s:iterator value="#request.users" var="user">
    <tr><td><s:property value="#user.UId"/></td>
    <td><s:property value="#user.UName"/></td>
    <td><s:property value="#user.UPwd"/></td>
    <td><s:property value="#user.UImg"/></td>
    <td><s:property value="#user.coin"/></td>
    <td><s:property value="#user.UPhone"/></td>
     <td><s:property value="#user.UType"/></td>
      <td><s:property value="#user.UAdress"/></td>
    <td><a href="stu_getStudentById.action?id=<s:property value='#student.id'/>&option=update" >修改</a></td>
    </tr>
   </s:iterator>
   </table>
    <page:paging offset="${pageInfo.firstResult}" 
                  pageSize="${pageInfo.maxResults}" 
        totalRecords="${pageInfo.itemCount}"
        href="/CarTrading/user_getAllUser.action"/>
  </body>
</html>
