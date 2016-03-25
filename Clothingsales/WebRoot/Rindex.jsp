
<%@ page language="java" import="java.util.*,java.io.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>



<html>
<head>

<title></title>
<link href="css/styles.css" rel="stylesheet">
<!--[if lt IE 9]>
<script src="js/modernizr.js"></script>
<![endif]-->
</head>
<body>

 <div class="mainContent">
    <div class="blogitem">
      <article>
        <h2 class="title"><a href="/">销售信息</a></h2>
        <ul class="text">
        <center>
        <table border="1" width="300px" margin="center">
        <tr>销售表</tr>
        <tr>
        <td><div align="center">月份</div></td>
        <td><div align="center">销售数量</div></td>  
        </tr>
        <c:forEach var="employees" items="${employees}" >
          <tr>
        <td><div align="center">${employees.item}</div></td>
        <td><div align="center">${employees.no}</div></td>
         </tr>
         </c:forEach>
        </table>
       </center>
        </ul>   
      </article>
       <c:if test="${imgnamebar!=null}">
       <div  align="center">
     <img  src="<%=basePath%>upload/${imgnamebar}" width="480" height="320" />   </c:if>
   <c:if test="${imgnamebar==null}">
          图表没有内容或未正确生成
   </c:if>
    <c:if test="${imgnamepie!=null}">

     <img  src="<%=basePath%>upload/${imgnamepie}" width="480" height="320" />   </c:if>
   <c:if test="${imgnamepie==null}">
          图表没有内容或未正确生成
   </c:if>
 </div>
</body>
</html>