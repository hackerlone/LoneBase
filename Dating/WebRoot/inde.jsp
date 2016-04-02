<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
	function openimgupload()
	{ 
		window.open('upload/avatar.jsp?uid=<%=Math.round(Math.random() * 900) + 100 + ""%>&uploadtype=head','图片上传','height=253,width=450,status=no,toolbar=no,menubar=no,location=no,scrollbars=no,resizable=no');
	}
	</script>
  </head>
  
  <body>
     <img src="images/noimg.png" id="showimg1"><input type="text" name="imgpath1" id="imgpath1"><br/>
    <input type="button" value="上传图片" onclick="openimgupload();"><br/>
  </body>
</html>
