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
<link rel="stylesheet" href="resources/css/reset.css" type="text/css" media="screen" />
<link rel="stylesheet" href="resources/css/style1.css" type="text/css" media="screen" />
<link rel="stylesheet" href="resources/css/invalid.css" type="text/css" media="screen" />
<script type="text/javascript" src="resources/scripts/jquery-1.3.2.min.js"></script>
<script type="text/javascript" src="resources/scripts/simpla.jquery.configuration.js"></script>
<script type="text/javascript" src="resources/scripts/facebox.js"></script>
<script type="text/javascript" src="resources/scripts/jquery.wysiwyg.js"></script>
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
  <div id="main-content">
    <noscript>
    </noscript>
    <h2></h2>
    <!-- End .clear --><br/><br/><br/>
    <div class="content-box">
      <div class="content-box-header">
        <h3>员工信息添加</h3>
        <ul class="content-box-tabs">
          <li><a href="#tab1" class="default-tab">Table</a></li>       
        </ul>
        <div class="clear"></div>
      </div>
      <div class="content-box-content">
        <div class="tab-content default-tab" id="tab1">
           <div id="formreg">
            <form action="EmployeeS?option=processupdate" method="post" id="form" >
 <table border="5">
<tr><td>
                  员工编号： </td><td> <input type="text" size="20" name="e_id" alt="员工编号" value="${employee.e_id}" readonly/><div></div></td></tr>
       <tr><td>           
                  所在店铺：  </td><td>
             <select name="d_id" >
		<c:forEach var="depot" items="${depots}" >
		<option value="${depot.d_id }" <c:if test="${depot.d_id == employees.d_id}"> selected='true'</c:if>   > ${depot.d_name} </option>
		
		</c:forEach></select>
                  
           </td></tr>
          <tr><td>        
                  员工姓名：  </td><td><input type="text" size="20" name="e_name" alt="员工姓名" value="${employee.e_name}" /><div></div></td></tr>
      <tr><td>            
                  员工密码：</td><td>  <input type="text" size="20" name="e_pwd" alt="员工密码" value="${employee.e_pwd}" /><div></div></td></tr>
       <tr><td>           
                  员工类别： </td><td> 
                  <select name="e_power" >
             <option value="${employee.e_power}" selected>${employee.e_power}</option>
		     <option value="1" >店长</option>
		     <option value="2" >收银员</option>
		     <option value="3" >销售人员</option>
		     <option value="4" >安保人员</option>
		     
		     </select>
                  </td></tr>
            <tr><td>           
                  员工性别：  </td><td><select name="e_sex" >
             <option value="${employee.e_sex}" selected>${employee.e_sex}</option>
		     <option value="男" >男</option>
		     <option value="女" >女</option>
		     </select></td></tr>
<tr><td>
                  员工电话：</td><td>  <input type="text" size="20" name="e_tel"  alt="员工电话" value="${employee.e_tel}" /><div></div></td></tr>
        <tr><td>          
                  员工学历：</td><td> 
                  <select name="e_diploma" >
             <option value="${employee.e_diploma}" selected>${employee.e_diploma}</option>
             <option value="研究生" >初中</option>
		     <option value="本科" >本科</option>
		     <option value="专科" >大专</option>
		     <option value="高中" >高中</option>
		     <option value="初中" >初中</option>
		     <option value="小学" >小学</option>
		     
		     </select>
             </td></tr>
         <tr><td>         
                  身份证号：  </td><td><input type="text" size="20" name="e_idcard" alt="身份证号" value="${employee.e_idcard}" /><div></div></td></tr>
        <tr><td>          
             &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input class="button" name="Submit" type="reset" value="重填"/></td><td>&nbsp;&nbsp;
		    <input type="button" class="button" size="20" value="修改" id="regbtn"/></td></tr>
     </table>
     </form>
        </div>
        </div>
        </div>
        </div>
        </div>
       </div>
    </body>
</html>
