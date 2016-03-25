<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
   contentType="text/html; charset=UTF-8"%>
<!doctype html>
<html>
<head>

<title></title>
<link href="css/styles.css" rel="stylesheet">
<!--[if lt IE 9]>
<script src="js/modernizr.js"></script>
<![endif]-->
<style type="text/css">
<!--
a:link {
	color: #0000FF;
	text-decoration: none;
}
a:hover {
	color: #3399CC;
	text-decoration: none;
}
a:visited {
	text-decoration: none;
	color: #FF00FF;
}
a:active {
	text-decoration: none;
}
-->
</style>
<script type="text/javascript">
function yc(){
document.getElementById('from1').style.display='none'; 
document.getElementById('form').style.display='block';
}
function updata(){
    document.getElementById('from1').style.display='block';
    document.getElementById('form').style.display='none'; 
}

</script>

</head>
<body onload="yc();">
<header>
</header>
 <div class="mainContent">
   <aside>
      <div class="avatar">
        <a href="#"><span>欣欣服装</span></a>
      </div>
    <section class="topspaceinfo">
        <div align="center">个人资料 </div>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
       <input type="button" id="uppwd" value="修改密码"onclick="updata()"/>
        
         <br /> 
      
        
        
        
        
        
        
        
        
        
        <br>
		  <div>
		  <form action="EmployeeS?option=processupdate" method="post" id=form >
         <table border="0">
          <tr><td>
     <span>员工编号：</span> </td><td> <input type="text" size="20" name="e_id" alt="员工编号" value="${employee.e_id}" readonly/></td></tr>
          <tr><td>               
                  员工姓名：  </td><td><input type="text" size="20" name="e_name" alt="员工姓名" value="${employee.e_name}" readonly /></td></tr>
            <tr><td>            
                  员工职位： </td><td> <input type="text" size="20" name="e_pwd" alt="员工职位" value="${employee.e_power}" readonly/></td></tr>
            <tr><td>           
                  员工性别：  </td><td>
                      <input type="text" size="20" name="e_sex" alt="员工职位" value="${employee.e_sex}" readonly/></td></tr>
          <tr><td>
                  员工电话：</td><td>  <input type="text" size="20" name="e_tel"  alt="员工电话" value="${employee.e_tel}" readonly /><div></div></td></tr>
         <tr><td>          
                  员工学历：</td><td> <input type="text" size="20" name="e_pwd" alt="员工学历" value="${employee.e_diploma}" readonly/></td></tr>
         <tr><td>         
                  身份证号：  </td><td><input type="text" size="20" name="e_idcard" alt="身份证号" value="${employee.e_idcard}"  readonly/><div></div></td></tr>
        <tr><td>
		</td><td>
		      
		            
		</td></tr>
     </table>
     </form></div>
     
     
     
      <div id="from1" >
	<form action="EmployeeS?option=updatepwd" method="post" id="form" >
     <table >
     <tr><td> 
                员工姓名：  </td><td><input type="text" size="20" name="e_name" alt="员工姓名" value="${employee.e_name}" /><div></div></td></tr>
      <tr><td>            
                  员工密码：</td><td>  <input type="text" size="20" name="e_pwd" alt="员工密码" value="${employee.e_pwd}" /><div></div></td></tr>
       <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
       <tr><td>	
		<input type="submit" size="20"  class="button" value="提交"  /></td><td>&nbsp;&nbsp;
		<input class="button" name="Submit" type="button" value="取消" onclick="yc();"/></td></tr>
		
		    </table>
		</form>
        </div>      
    </section>
   </aside>
</div>
</body>
</html>