<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'chat.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">

 #msghistory{width:600px;height: 410px;border: solid 1px;  OVERFLOW:auto;}
.txtli{list-style-type: none;}
.msgl{width: 350px;height:20px;background:#FFBFFF;float:left;}
.msgr{width: 350px;height:20px;background:#FFFFAA; float:right;}
#msg{
	width: 420px;
	height: 80px;
	font-size: 20px;
}
#btn{
	width: 100px;
	height: 80px;
}
</style>
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
 $(document).ready(function(){
	 var tid = <%=request.getParameter("tid")%>;
	 var uid = <%=request.getParameter("uid")%>;
	 setInterval(refresh1,1000);
	 function refresh1(){
	 var txtstr="<ul>";
		 $("ul").remove();
		 $.ajax({
				url:"BooksServlet?option=showmsg&tid="+tid+"&uid="+uid+"",
				type:"post",
				dataType:"json",
				async:false,
				success: function(obj){
					 $(obj).each(function(i,txtval){
					    	txtstr+= "<li class='txtli'><div class='msgl'>他说："+txtval.uuRecord+"</div><div class='msgl'>"+txtval.tuData+"</div></li>"; 
					     })
					     txtstr+="</ul>";
					     $("#msghistory").empty();
					     $("#msghistory").append(txtstr);
				}
				 });
	 $.ajax({
			url:"BooksServlet?option=showmsg&tid="+uid+"&uid="+tid+"",
			type:"post",
			dataType:"json",
			async:false,
			success: function(obj){
				 $(obj).each(function(i,txtval){
				    	txtstr+= "<li class='txtli'><div class='msgr'>您说："+txtval.uuRecord+"</div><div class='msgr'>"+txtval.tuData+"</div></li>"; 
				     })
				     txtstr+="</ul>";
				     $("#msghistory").empty();
				     $("#msghistory").append(txtstr);
			}
			 });	
	
	 } 
	 
    $("#btn").click(function(){
    	var msg = $("#msg").val();  
    	$.ajax({
			url:"BooksServlet?option=sendmsg&tid="+uid+"&uid="+tid+"",
			type:'post',
			data:{"msg":msg},
			dataType:'text',
			success: function(data){
		        if(data){
		        	setInterval(refresh1,1000);
		        }
			}
			 });
    	$("#msg").val("");
		});
 });
 function refresh(){
		var txtstr="<ul>";
	 $.ajax({
			url:'chat.php',
			type:'post',
			dataType:'json',
			success: function(obj){
				 $(obj).each(function(i,txtval){
				    	txtstr+= "<li class='txtli'><div class='msgl'>"+txtval['name']+"对"+txtval['re_name']+"说："+txtval['msg']+"</div><div class='msgr'>"+txtval['retime']+"</div></li>"; 
				     })
				     txtstr+="</ul>";
				     $("#msghistory").empty();
				     $("#msghistory").append(txtstr);
			}
			 });	
 }

</script>
  </head>
  <div id="msghistory">
  </div>
  <br />
  <input type="text" id="msg"/><input id="btn" type="button" value="发送">
  <body>
    
  </body>
</html>
