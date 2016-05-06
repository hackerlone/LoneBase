<%@ page language="java" import="java.util.*" pageEncoding="utf-8" 
contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<%@ taglib uri="/WEB-INF/paging.tld" prefix ="page" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'add.jsp' starting page</title>
    
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

  <!-- 日历JavaScript -->
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
		var $w_id= $("input[name='w_id']");	
		var $w_xm = $("input[name='w_xm']");
		var $w_nl = $("input[name='w_nl']");
		var $w_sg = $("input[name='w_sg']");
		var $w_jtzz = $("input[name='w_jtzz']");
		var $w_jg = $("input[name='w_jg']");
		var $w_sfzhm = $("input[name='w_sfzhm']");
		var $w_lxfs = $("input[name='w_lxfs']");
		var $w_time = $("input[name='w_time']");
		var $zy_id = $("input[name='zy_id']");
		//判断是否为空
		$("#formreg div").text("");
		if(ischeck){
			 checkNull($w_id);
			}
		if(ischeck){
			 checkNull($w_xm);
			}
			if(ischeck){
			 checkNull($w_nl);
			}
			if(ischeck){
			 checkNull($w_sg);
			}
			if(ischeck){
			 checkNull($w_jtzz);
			}
			if(ischeck){
			//checkNull 判断是否为空
			 checkNull($w_jg);
			}
			if(ischeck){
			 checkNull($w_sfzhm);
			}
			if(ischeck){
				 checkNull($w_lxfs);
				}
			if(ischeck){
				 checkNull($w_time);
				}
			
		/*
		if(ischeck){
			checkisDig($age.val(),$age);//年龄是否正确
	    }
	if(ischeck){//检查用户名是否过长
			checkUnamelen($o_xm);
		}
		//检查电话是否周正确
		if(ischeck){
			checkisPhone($o_lxfs);
		}
		*/
	/*	if(ischeck){//检查是否为中文
			//checkisCN($uname.val());
		}
	//检查电话是否周正确
		if(ischeck){
			checkisPhone($phone);
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
 //检查用户名是否为中文
 /*function checkisCN(uname){
	 var patrn =  /^[A-Z u4E00-u9FA5]+$/ ;
	 if(!patrn.exec(uname)){
		 alert("请填写中文用户名");
		 ischeck = false; 
	 }
	 //正则表达式，用于检验字符串是否符合规范
	 //以/为开头结尾，[]取值范围,{}重复的次数
 }
 */
 //检查年龄
 function checkisDig(val,$node){
	 var len  = val.length;
	 var patrn;
	 if(len >=2&&len < 3){
	   patrn = /[1-9][0-9]/;
	 }else {
	   patrn = /1[0-2][0-9]/;
	 }
	 if(!patrn.exec(val)){
		// alert("请填写正确的年龄");
		$node.next().text("请填写正确的年龄");
		 ischeck = false;
	 }
	 }

  //电话号码
  function checkisPhone($node){
	 var patrn =  /1[3|8]\d{9}/ ;
var nodeval = $node.val();
	 if(nodeval.length!=11||!patrn.exec(nodeval)){
		// alert("请填写正确电话号码");
$node.next().text("请填写正确电话号码");
		 ischeck = false; 
	 }
 }

</script>
	<style type="text/css">  
#formdiv{width:600px;text-align:left;margin-left:auto;margin-right:auto; margin-top:auto; margin-bottom:auto;}
 #formreg{width:360px; margin-left:auto;margin-right:auto; margin-top:auto; margin-bottom:auto; }
 #formreg div{color:red;float:right;text-align:center;}
</style>
  </head>
  
  <body>
    <div align="center"><font size="14">物管信息添加 </font></div><br />
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
          
<form action="WgxxS?option=processAdd" method="post" id="formreg">
 物管编号： <input type="text" size="30" name="w_id" value="${wid}"  readonly="readonly"    alt="物管编号"/> <div></div><br/>
 物管姓名：  <input type="text" size="30" name="w_xm"   alt="物管姓名"/><div></div><br/>
 物管年龄：  <input type="text" size="30" name="w_nl"   alt="物管年龄" /><div></div><br/>
 物管身高：  <input type="text" size="30" name="w_sg"    alt="物管身高" /><div></div><br/>
 家庭住址：  <input type="text" size="30" name="w_jtzz"  alt="家庭住址"/><div></div><br/>
 物管籍贯：  <input type="text" size="30" name="w_jg"      alt="物管籍贯"/><div></div><br/>
 身份证号：  <input type="text" size="30" name="w_sfzhm"   alt="身份证号"/><div></div><br/>
 联系方式：  <input type="text" size="30" name="w_lxfs"    alt="联系方式"/><div></div><br/>
值班时间：  <input type="text" size="30" name="w_time"  readonly="readonly" id="popupDatepicker" alt="值班时间" />  <div></div><br/>
资源管理： <select name="zy_id" >
		<c:forEach var="zy" items="${zys}" >
		<option value=${zy.zy_id } >${zy.zy_leibie}</option> 
		</c:forEach></select>
 <div></div><br/><br/>

<button type="button" class="btn btn-danger" id="regbtn">添加</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<button type="reset" class="btn btn-default">清除</button>
  </form>
     </div>
     </div>
  </body>
</html>
