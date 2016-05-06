<%@ page language="java" import="java.util.*" pageEncoding="utf-8" 
contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>资源添加页面</title>
    
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
<script src="rili/js/jquery-1.8.3.min.js"></script>
  <link rel="shortcut icon" href="img/favicon/favicon.png">
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<script type="text/javascript">
var ischeck;
 $(document).ready(function() {
	$("#regbtn").click(function(){
		ischeck = true;
		var $zy_id= $("input[name='zy_id']");	
		var $k_id = $("input[name='k_id']");
		var $zy_leibie = $("input[name='zy_leibie']");
		var $zy_name = $("input[name='zy_name']");
		var $zy_qingkuang = $("input[name='zy_qingkuang']");
		var $zy_waijieren = $("input[name='zy_waijieren']");
		var $w_id = $("input[name='w_id']");
		var $ck_id = $("input[name='ck_id']");
		//判断是否为空
		$("#formreg div").text("");
	if(ischeck){
	//checkNull 判断是否为空
		 checkNull($zy_id);
		}
	if(ischeck){
		 checkNull($k_id);
		}
		if(ischeck){
		 checkNull($zy_leibie);
		}
		if(ischeck){
		 checkNull($zy_name);
		}
		if(ischeck){
		 checkNull($w_id);
		}
		if(ischeck){
		 checkNull($ck_id);
		}
		/*
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

 function checkUnamelen($node){
	 var len = $node.val().trim().length;
	 if(len <= 2 ||len>=6){
		 //alert("用户名长度不正确，应该在3-5个字");
		 $node.next().text("用户名长度不正确，应该在3-5个字");
		 ischeck = false;
		 }
 }

</script>

<style type="text/css">  
#formdiv{width:600px;text-align:left;margin-left:auto;margin-right:auto; margin-top:auto; margin-bottom:auto;}
 #formreg{width:360px; margin-left:auto;margin-right:auto; margin-top:auto; margin-bottom:auto; }
 #formreg div{color:red;float:right;text-align:center;}
 #op{ width: 188px; height: 26px;}
</style>

  </head>
  <body>
    <div align="center"><font size="14">资源信息添加 </font></div><br />
  <div class="widget">
                <div class="widget-head" >
                  <div align="center" class="pull-left">请认真填写：</div>
                  <div class="widget-icons pull-right">
                    <a href="main.jsp" class="wminimize"><i class="icon-chevron-up"></i></a> 
                  </div>  
                  <div class="clearfix"></div>
                </div>
                  <div class="widget-content" align="center" id="formdiv">            
<form action="ZyS?option=processAdd" method="post" id="formreg">
资源编号： <input type="text" size="30" name="zy_id" value="${wid }"
					alt="资源编号" readonly="readonly"><div></div><br/>
库存编号：  <input type="text" size="30" name="k_id" alt="库存编号"/><div></div><br/>
资源类别：  <input type="text" size="30" name="zy_leibie" alt="资源类别"><div></div><br/>
资源名称：  <input type="text" size="30" name="zy_name" alt="资源名称"><div></div><br/>
 资源情况：<select name="zy_qingkuang" id="op">
                            <option value="外借">外借</option>
                            <option value="在库" selected>在库</option>
                            <option value="其他">其他</option>
 </select> <div></div><br/>
<!-- 资源情况：  <input type="text" size="30" name="zy_qingkuang" alt="资源情况"><div></div><br/> -->
外  &nbsp;借 &nbsp;人：  <input type="text" size="30" name="zy_waijieren" alt="外 借 人"><div></div><br/>
 物管编号：  <input type="text" size="30" name="w_id" alt="物管编号"><div></div><br/>
 仓库编号：  <input type="text" size="30" name="ck_id" alt="仓库编号"><div></div><br/>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<button type="button" class="btn btn-danger" id="regbtn">增加</button>&nbsp;&nbsp;&nbsp;&nbsp;
				<button type="reset" class="btn btn-default">清除</button>
     </form>
     </div>
     </div>
   </body>
</html>
