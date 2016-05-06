
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" 
contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>投诉表</title>
    
      <link href="style/bootstrap.css" rel="stylesheet">
  <!-- Font awesome icon -->
  <link rel="stylesheet" href="style/font-awesome.css"> 
  <!-- jQuery UI -->
  <link rel="stylesheet" href="style/jquery-ui.css"> 
  <!-- Calendar -->
  <link rel="stylesheet" href="style/fullcalendar.css">
  <!-- prettyPhoto -->
  <link rel="stylesheet" href="style/prettyPhoto.css">  
  <!-- Star rating -->
  <link rel="stylesheet" href="style/rateit.css">
  <!-- Date picker -->
  <link rel="stylesheet" href="style/bootstrap-datetimepicker.min.css">
  <!-- CLEditor -->
  <link rel="stylesheet" href="style/jquery.cleditor.css"> 
  <!-- Uniform -->
  <link rel="stylesheet" href="style/uniform.default.css"> 
  <!-- Bootstrap toggle -->
  <link rel="stylesheet" href="style/bootstrap-switch.css">
  <!-- Main stylesheet -->
  <link href="style/style.css" rel="stylesheet">
  <!-- Widgets stylesheet -->
  <link href="style/widgets.css" rel="stylesheet">   
  <link rel="shortcut icon" href="img/favicon/favicon.png">
<!-- js主函数体js开始 -->
<script src="rili/js/jquery-1.8.3.min.js"></script>
<!-- js主函数体js结束 -->
<script type="text/javascript">
var ischeck;
 $(document).ready(function() {
	$("#regbtn1").click(function(){
		ischeck = true;
		var $ly_id= $("input[name='ly_id']");
		var $o_id= $("input[name='o_id']");	
		var $w_id = $("input[name='w_id']");
		var $t_sy = $("input[name='t_sy']");
		//判断是否为空
		$("#formreg1 div").text("");
	if(ischeck){
		 checkNull($o_id);
		}
	if(ischeck){
		 checkNull($w_id);
		}
	//	if(ischeck){
	//	 checkNull($t_sy);
	//	}
	/*
	if(ischeck){//检查用户名是否过长
			checkUnamelen($o_xm);
		}	
	*/	
	if(ischeck){
	$("#formreg1").submit();
	}
	});
});
//定义一个方法用于判断input元素是否为空并给出相应的提示
function checkNull($node){
	 var nodeval = $node.val();
	 var altval = $node.attr("alt");
	 if(nodeval.trim().length == 0||nodeval.trim()==""){
		 ischeck = false;
		 $node.focus();
		 //alert(altval+"不能为空");
		 $node.next().text(altval+"不能为空");
	 }
 }


</script>
<style type="text/css">
#formdiv1 {
	width: 600px;
	text-align: left;
	margin-left: auto;
	margin-right: auto;
	margin-top: auto;
	margin-bottom: auto;
}

#formreg1 {
	width: 360px;
	margin-left: auto;
	margin-right: auto;
	margin-top: auto;
	margin-bottom: auto;
}

#formreg1 div {
	color: red;
	float: right;
	text-align: center;
}
 #tx{width:360px; height: 300px; float:none;}
 #regbtn1{float:none;margin-left: 100px;margin-top: 10px;}
  #regbtn2{float:none;margin-left: 20px;margin-top: 10px;}
</style>
</head>
  
  <body>
    <div align="center"><font size="14">留言信息添加 </font></div><br />
  <div class="widget">
                <div class="widget-head" >
                  <div align="center" class="pull-left">请认真填写：</div>
                  <div class="widget-icons pull-right">
                    <a href="main.jsp" class="wminimize"><i class="icon-chevron-up"></i></a> 
                  </div>  
                  <div class="clearfix"></div>
                </div>

                  <div class="widget-content" align="center" id="formdiv1">
          
<form action="TsS?option=processAdd" method="post" id="formreg1">
留言条数： <input type="text" size="30" name="ly_id" alt="留言编号" value="${fid}" readonly="readonly"><div></div><br/> 
您的昵称： <input type="text" size="30" name="o_id"  alt="您的昵称">&nbsp;&nbsp;<div></div><br/> 
邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱：  <input type="text" size="30" name="w_id"  alt="邮箱">&nbsp;&nbsp;<div></div><br/>
留言内容：  <textarea cols="300" rows="20" name="t_sy"  id="tx"> &nbsp;&nbsp;</textarea><div></div><br/>
				<input type="button" class="btn btn-danger" id="regbtn1" value="增加">&nbsp;&nbsp;
				<input type="reset" class="btn btn-default" value="清除" id="regbtn2">
     </form>
     </div>
     </div>
  </body>
</html>
