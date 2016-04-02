<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
    <title></title>
    <meta charset="UTF-8">
   <link rel="stylesheet" type="text/css" href="sys/Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="sys/Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="sys/Css/style.css" />
    <script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="sys/Js/jquery.sorted.js"></script>
    <script type="text/javascript" src="sys/Js/bootstrap.js"></script>
    <script type="text/javascript" src="sys/Js/ckform.js"></script>
    <script type="text/javascript" src="sys/Js/common.js"></script>
        <script language="javascript" type="text/javascript"
	src="<%=basePath%>/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
	$(function() {
		var sex = ${sessionScope.user.USex};
		if(sex=="1"){
			$("#nan").attr('checked','true');
		}else if(sex=="2"){
			$("#nv").attr('checked','true');
		}
	});
</script>
 

    <style type="text/css">
        body {
            padding-bottom: 40px;
        }
        .sidebar-nav {
            padding: 9px 0;
        }
        @media (max-width: 980px) {
            /* Enable use of floated navbar text */
            .navbar-text.pull-right {
                float: none;
                padding-left: 5px;
                padding-right: 5px;
            }
        }
	#showimg1{
	height: 80px;
	}
td{text-align:center;}
    </style>


</head>
<body>
<form action="" method="post" class="definewidth m20">
<input type="hidden" name="UId" value="${sessionScope.user.UId}">
<center><font size="15px">你好：</font><font size="15px" style="color: red">${sessionScope.user.UName}</font></h2></center>
    <table class="table table-bordered table-hover definewidth m10">
    	  <tr><td class="tableleft">头像</td>
        <td>
    	<div class="input-block-level">
			 <img src="<%=basePath %>upload/${sessionScope.user.UHead}" id="showimg1">
			<br/>
			</div>
    	</td></tr>
        <tr>
            <td width="10%" class="tableleft">用户名</td>
            <td><input type="text" name="username" value="${sessionScope.user.UName}" readonly/></td>
        </tr>
      
      
        <tr>
            <td class="">生日</td>
            <td><input type="text" name="age"
				class="Wdate" placeholder="年龄"
				onClick="WdatePicker()" readonly value="${sessionScope.user.UAge}"/></td>
        </tr>
         <tr>
            <td class="tableleft">性别</td>
            <td>
            	<input type="radio" name="status" id="nan" value="1" readonly></input>男
            	<input type="radio" name="status" id="nv" value="2" readonly></input>女
            </td>
        </tr>
        <tr>
            <td class="tableleft">邮箱</td>
            <td><input type="text" name="email" value="${sessionScope.user.UEmail}" readonly/></td>
        </tr>
        <tr>
            <td class="tableleft">电话</td>
            <td>
            	<input type="text" name="phone" value="${sessionScope.user.UPhone}" readonly/>
            </td>
        </tr>
        <tr>
            <td class="tableleft">地址</td>
            <td><input type="text" name="area" value="${sessionScope.user.UArea}" readonly/></td>
        </tr>
        <tr>
            <td class="tableleft">个性签名</td>
            <td><textarea type="text" name="signature" readonly>${sessionScope.user.USignature}</textarea></td>
        </tr>
        <tr>
            
        </tr>
    </table>
</form>
</body>
</html>
<script>
    $(function () {       
		$('#backid').click(function(){
				window.location.href="{:U('User/index')}";
		 });

    });
</script>