<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
   contentType="text/html; charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<%@ taglib uri="/WEB-INF/paging.tld" prefix ="page" %>
<title>服装销售管理系统</title>
<!--                       CSS                       -->
<!-- Reset Stylesheet -->
<link rel="stylesheet" href="resources/css/reset.css" type="text/css" media="screen" />
<!-- Main Stylesheet -->
<link rel="stylesheet" href="resources/css/style1.css" type="text/css" media="screen" />
<!-- Invalid Stylesheet. This makes stuff look pretty. Remove it if you want the CSS completely valid -->
<link rel="stylesheet" href="resources/css/invalid.css" type="text/css" media="screen" />
<!--                       Javascripts                       -->
<!-- jQuery -->
<script type="text/javascript" src="resources/scripts/jquery-1.3.2.min.js"></script>
<!-- jQuery Configuration -->
<script type="text/javascript" src="resources/scripts/simpla.jquery.configuration.js"></script>
<!-- Facebox jQuery Plugin -->
<script type="text/javascript" src="resources/scripts/facebox.js"></script>
<!-- jQuery WYSIWYG Plugin -->
<script type="text/javascript" src="resources/scripts/jquery.wysiwyg.js"></script>
<!-- jQuery Datepicker Plugin -->
<script type="text/javascript" src="resources/scripts/jquery.datePicker.js"></script>
<script type="text/javascript" src="resources/scripts/jquery.date.js"></script>


<script type="text/javascript">
var ischeck;
 $(document).ready(function() {
	$("#regbtn").click(function(){
		ischeck = true;
		var $e_id = $("input[name='e_id']");
		var $e_name = $("input[name='e_name']");
		var $e_pwd = $("input[name='e_pwd']");
		
		var $e_tel = $("input[name='e_tel']");
		var $e_idcard = $("input[name='e_idcard']");
		

		$("#form div").text("");
		if(ischeck){
		 checkNull($e_id);
		}
		if(ischeck){//检查用户名是否过长
			checkUnamelen($e_id);
		}
		//if(ischeck){//检查是否为中文
			//checkisCN($uname.val());
		//}
		if(ischeck){
		 checkNull($e_name);
		}
		if(ischeck){
		 checkNull($e_pwd);
		}	
		if(ischeck){
		 checkNull($e_tel);
		}
		if(ischeck){
			checkisPhone($e_tel);
		}
		if(ischeck){
		 checkNull($e_idcard);
		}
		if(ischeck){
		$("#form").submit();}
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
	 if(len<5){
		 //alert("用户名长度不正确，应该在3-5个字");

		 $node.next().text("编号长度不正确，应该至少为5个数字");
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





</head>
<body>
<div id="body-wrapper">
  <!-- Wrapper for the radial gradient background -->
  
  <!-- End #sidebar -->
  <div id="main-content">
    <!-- Main Content Section with everything -->
    <noscript>
    <!-- Show a notification if the user has disabled javascript -->
    </noscript>
    <!-- Page Head -->
    <h2></h2>
  
    <!-- End .shortcut-buttons-set -->
   
    <!-- End .clear --><br/><br/><br/>
    <div class="content-box">
      <!-- Start Content Box -->
      <div class="content-box-header">
        <h3>员工信息添加</h3>
        <ul class="content-box-tabs">
          <li><a href="#tab1" class="default-tab">Table</a></li>
          <!-- href must be unique and match the id of target div -->
         
        </ul>
        <div class="clear"></div>
      </div>
      <!-- End .content-box-header -->
      <div class="content-box-content">
        <div class="tab-content default-tab" id="tab1">
          <!-- This is the target div. id must match the href of this div's tab -->
          
         
           <div id="formreg">
            <form action="EmployeeS?option=processAdd" method="post" id=form >
 <table border="5">
<tr><td>
                  员工编号： </td><td> <input type="text" size="20" name="e_id" alt="员工编号" /><div></div></td></tr>
       <tr><td>           
                  所在店铺：  </td><td><select name="d_id" >
        <c:forEach var="depot" items="${depots}" >
		<option value=${depot.d_id } >${depot.d_name}</option> 
		</c:forEach></select></td></tr>
          <tr><td>        
                  员工姓名：  </td><td><input type="text" size="20" name="e_name" alt="员工姓名" /><div></div></td></tr>
      <tr><td>            
                  员工密码：</td><td>  <input type="text" size="20" name="e_pwd" alt="员工密码" /><div></div></td></tr>
       <tr><td>           
                  员工类别： </td><td> 
                  <select name="e_power" >
		     <option value="1" >店长</option>
		     <option value="2" >收银员</option>
		     <option value="3" >普通员工</option>
		     <option value="4" >安保人员</option>
		     
		     </select>
                  </td></tr>
       <tr><td>           
                  员工性别：  </td><td><select name="e_sex" >
		     <option value="男" >男</option>
		     <option value="女" >女</option>
		     </select></td></tr>
<!-- 员工性别：  <input type="text" size="20" name="e_sex"><br/><br/>  -->
<tr><td>
                  员工电话：</td><td>  <input type="text" size="20" name="e_tel"  alt="员工电话"/><div></div></td></tr>
        <tr><td>          
                  员工学历：</td><td> 
                  <select name="e_diploma" >
		     <option value="本科" >本科</option>
		     <option value="大专" >大专</option>
		     <option value="高中" >高中</option>
		     <option value="初中" >初中</option>
		     
		     
		     </select>
                   </td></tr>
         <tr><td>         
                  身份证号：  </td><td><input type="text" size="20" name="e_idcard" alt="身份证号"/><div></div></td></tr>
        <tr><td>          
             &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input class="button" name="Submit" type="reset" value="重填"/></td><td>&nbsp;&nbsp;
		    <input type="button" class="button" size="20" value="增加" id="regbtn"/></td></tr>
      
   
     </table>
     </form>

          
 
 



        </div>
 
        </div>
        </div>
        </div>
        </div>
       </div>
    </body>
<!-- Download From www.exet.tk-->
</html>
