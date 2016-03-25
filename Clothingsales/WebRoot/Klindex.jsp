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
</style></head>
<body>
<header>
</header>
 <div class="mainContent">
   <aside>
      <div class="avatar">
        <a href="#"><span>欣欣服装</span></a>
      </div>
    <section class="topspaceinfo">
        <div align="center">个人资料 </div>
        <br>
		  <div>
		  <form action="CustomerS?option=processupdate" method="post" id=form >
         <table border="0">
          <tr><td>
                  <span>客户编号：</span> </td><td> <input type="text" size="20" name="k_id" alt="客户编号" value="${customer.k_id}" readonly/></td></tr>
          <tr><td>               
                客户积分：  </td><td><input type="text" size="20" name="k_integ" alt="客户积分" value="${customer.k_integ}" readonly/></td></tr>
          <tr><td>            
                  客户姓名： </td><td> <input type="text" size="20" name="k_name" alt="客户姓名" value="${customer.k_name}" /></td></tr>
          <tr><td>           
                  客户密码： </td><td> <input type="text" size="20" name="k_pwd" alt="客户密码" value="${customer.k_pwd}" /></td></tr>           
          <tr><td>
                购买数量：</td><td>  <input type="text" size="20" name="k_number"  alt="购买数量" value="${customer.k_number}" readonly/><div></div></td></tr>
         <tr><td>          
          联系方式：</td><td> <input type="text" size="20" name="k_tel" alt="联系方式" value="${customer.k_tel}" /></td></tr>
         <tr><td>         
                客户退货：  </td><td><input type="text" size="20" name="k_return" alt="身份证号" value="${customer.k_return}" readonly/><div></div></td></tr>
        <tr><td>
		</td><td>
           

		

		    </td></tr>
     </table>
     </form></div>
            
    </section>
   </aside>
</div>
</body>
</html>