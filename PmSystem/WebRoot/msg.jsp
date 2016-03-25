<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page isELIgnored="false" 
contentType="text/html; charset=UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>跳转提示页面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
 <!--<center> ${msg }</center>-->
   <%//=request.getAttribute("msg") %>
   <script type="text/javascript">
    alert("<%=request.getAttribute("msg") %>,1秒后跳转到最新页面");
    var second = 1;
    setInterval("redirect()", 500);  //
    function redirect()
    {
       second--;
        if (second < 0)
        {
            location.href = '<%=request.getAttribute("url")%>';
        }
        
     } 
    </script>
  </body>
</html>
