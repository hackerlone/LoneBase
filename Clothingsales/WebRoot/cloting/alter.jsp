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
		var $f_id = $("input[name='f_id']");
			
		var $f_pid = $("input[name='f_pid']");
		var $f_name = $("input[name='f_name']");
		var $f_brand = $("input[name='f_brand']");
		
		var $f_price = $("input[name='f_price']");
		var $f_number = $("input[name='f_number']");
		

		$("#form div").text("");
		if(ischeck){
		 checkNull($f_id);
		}
		if(ischeck){//检查用户名是否过长
			checkUnamelen($f_id);
		}
		//if(ischeck){//检查是否为中文
			//checkisCN($uname.val());
		//}
		if(ischeck){
		 checkNull($f_pid);
		}
		if(ischeck){
		 checkNull($f_name);
		}
		if(ischeck){
		 checkNull($f_brand);
		}
		
		if(ischeck){
		 checkNull($f_price);
		}
		if(ischeck){
		 checkNull($f_number);
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
    
    <!-- End .clear -->
    <br /><br /><br />
    <div class="content-box">
      <!-- Start Content Box -->
      <div class="content-box-header">
        <h3>服装信息修改</h3>
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
          <form action="ClotingS?option=processupdate" method="post" id=form>
          <table border="5">
          <tr>
          <td>
	             服装编号：</td><td><input name="f_id" type="text" value="${cloting.f_id}" readonly="readonly" alt="服装编号"/><div></div></td> </tr>
	  <tr>
		<td>供应商：</td><td>
		
		<select name="s_id" >
		<c:forEach var="supperi" items="${suppiers}" >
		<option value="${supperi.s_id}"   <c:if test="${supperi.s_id == cloting.s_id}">selected='true'</c:if>   >${supperi.s_name}</option>
		
		</c:forEach></select></td></tr>
		<tr><td>
		品牌编号：</td><td><input name="f_pid" type="text" value="${cloting.f_pid} " alt="品牌编号" /><div></div></td></tr>
		<tr><td>
	            服装名称：</td><td><input name="f_name" type="text" value="${cloting.f_name} " alt="服装名称" /><div></div></td></tr>
	            <tr><td>
		品牌名称：</td><td><input name="f_brand" type="text" value="${cloting.f_brand} " alt="品牌名称" /><div></div></td></tr>
		<tr><td>
		服装尺寸：</td><td>
		 <select name="f_model" >
		 
		 <option value="0"   <c:if test="${cloting.f_model == '0'}">selected='model'</c:if>   >S</option>
		 <option value="1"   <c:if test="${cloting.f_model == '1'}">selected='model'</c:if>   >M</option>
		 <option value="2"   <c:if test="${cloting.f_model == '2'}">selected='model'</c:if>   >L</option>
		<option value="3"   <c:if test="${cloting.f_model == '3'}">selected='model'</c:if>   >XL</option>
		<option value="4"   <c:if test="${cloting.f_model == '4'}">selected='model'</c:if>   >XXL</option>
		
		</select>
		</td></tr>
		<tr><td>
		服装销售价格：</td><td><input name="f_price" type="text" value="${cloting.f_price} " alt="服装销售价格" /><div></div></td></tr>
		<tr><td>
		服装进价：</td><td><input name="f_bid" type="text" value="${cloting.f_bid} " /></td></tr>
		<tr><td>
		服装数量：</td><td><input name="f_number" type="text" value="${cloting.f_number} " alt="服装数量" /><div></div></td></tr>
		<tr><td>
		图片：</td><td><input id="" name="f_img" value="${imgsrc}"   type="hidden"/> <img src="images/${imgsrc}" height="100" width="180" ></td></tr>
		
		<tr><td >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="button" size="20" class="button" value="提交" id="regbtn" /></td>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;
		<input class="button" name="Submit" type="reset" value="清 除"/></td></tr>
		
		 </table>
		</form>
       <form action="FileUpS?url=ClotingS?option=processupdate" method="post" enctype="multipart/form-data">
         
         <input type="file" name="file1" id="sc">
         <input type="submit" class="button"  value="上传">
         
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
