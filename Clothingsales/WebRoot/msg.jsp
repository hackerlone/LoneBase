<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page isELIgnored="false" 
contentType="text/html; charset=utf-8"%>
<html>
  <head>
    <title>msg.jsp</title>
	
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    
    <!--<link rel="stylesheet" type="text/css" href="./styles.css">-->

  </head>
  
  <body><center><br /><br /><br /><br />
   <h3><%=request.getAttribute("msg") %>,3秒后查看最新结果!</h3></center>
    <script type="text/javascript">
    alert("<%=request.getAttribute("msg") %>,3秒后查看最新结果");
    var second = 3;
    setInterval("redirect()", 1000);  //
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
