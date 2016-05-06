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
    
    <title>留言信息管理</title>
    
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
  

  <!-- Favicon -->
  <link rel="shortcut icon" href="img/favicon/favicon.png">
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<link href="rili/css/jquery.datepick.css" rel="stylesheet">
<script src="rili/js/jquery-1.8.3.min.js"></script>
<script src="rili/js/jquery.plugin.js"></script>
<script src="rili/js/jquery.datepick.js"></script>
<script>
$(function() {
	$('#popupDatepicker').datepick();
	$('#inlineDatepicker').datepick({onSelect: showDate});
});
function showDate(date) {
	alert('The date chosen is ' + date);
}
</script>
<script type="text/javascript">
var ischeck;
 $(document).ready(function() {
	$("#regbtn").click(function(){
		ischeck = true;
		var $ly_id=$("input[name='ly_id']");
		var $o_id= $("input[name='o_id']");	
		var $w_id = $("input[name='w_id']");
		var $t_sy = $("input[name='t_sy']");
		//判断是否为空
		$("#formreg div").text("");
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
	    }
	if(ischeck){//检查用户名是否过长
			checkUnamelen($o_xm);
		}
	*/	
	if(ischeck){
	$("#formreg").submit();
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
#formdiv{width:600px;text-align:left;margin-left:auto;margin-right:auto; margin-top:auto; margin-bottom:auto;}
 #formreg{width:360px; margin-left:auto;margin-right:auto; margin-top:auto; margin-bottom:auto; }
 #formreg div{color:red;float:right;text-align:center;}
 #tx{width:360px; height: 300px; float:none;}
 #regbtn{float:none;margin-left: 100px;margin-top: 10px;}
 #regbtn2{float:none;margin-left: 20px;margin-top: 10px;}
</style>
  </head>
  
  <body>
    <div align="center"><font size="14">留言信息修改 </font></div><br />
  <div class="widget">
                <div class="widget-head" >
                  <div align="center" class="pull-left">请认真填写：</div>
                  <div class="widget-icons pull-right">
                    <a href="main.jsp" class="wminimize"><i class="icon-chevron-up"></i></a> 
                    <a href="#" class="wclose"><i class="icon-remove"></i></a>
                  </div>  
                  <div class="clearfix"></div>
                </div>

                  <div class="widget-content" align="center" id="formdiv">
          
<form action="TsS?option=processUpdate" method="post" id="formreg">
留言条数： <input type="text" size="30" name="ly_id" alt="留言编号" value="${ts.ly_id}" readonly="readonly"><div></div><br/>
  您的昵称： <input type="text" size="30" name="o_id" alt="业主编号" value="${ts.o_id }" readonly="readonly"><div></div><br/>
修改邮箱：<input type="text" size="30" name="w_id" alt="物业编号" value="${ts.w_id}"><div></div><br/>
 留言信息：  <textarea cols="300" rows="20" name="t_sy" alt="留言信息" id="tx">${ts.t_sy }</textarea><div></div><br/>
				<button type="button" class="btn btn-danger" id="regbtn">修改</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<button type="reset" class="btn btn-default" id="regbtn2">清除</button>
     </form>
     </div>
     </div>
  </body>
</html>
