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
    <script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
        <script language="javascript" type="text/javascript"
	src="<%=basePath%>/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
	$(function() {
		var sex = ${requestScope.agree.YId};
		if(sex=="1"){
			$("#aa").attr("selected","true");
		}else if(sex=="2"){
			$("#team").attr("selected","true");
		}else if(sex=="3"){
			$("#free").attr("selected","true");
		}
		
		$("#deleted").click(function(){
			var agreeid = $("#agreeid").val();
			alert(agreeid);
			
		});
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

    </style>


</head>
<body>
<form action="AgreementServlet?option=update" method="post" class="definewidth m20">
    <table class="table table-bordered table-hover definewidth m10">	
        <tr>
            <td width="10%" class="tableleft">约单编号</td>
            <td><input type="text" id="agreeid" name="agreeid" value="${requestScope.agree.YId}" readonly/></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">约单名称</td>
            <td><input type="text" name="agreename" value="${requestScope.agree.YName}" /></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">约会描述</td>
            <td><input type="text" name="agreems" value="${requestScope.agree.YMs}" /></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">约会方式</td>
            <td><select id="fs" name="fs">
    	<option value="1" id="aa">AA制</option>
    	<option value="2" id="team">组团行</option>
    	<option value="3" id="free">自由行</option>
            </select></td>
        </tr>   
        <tr>
            <td class="">约会时间</td>
            <td><input type="text" name="age"
				class="Wdate" placeholder="约会时间"
				onClick="WdatePicker()" readonly value="${requestScope.agree.YYhsj}"/></td>
        </tr>
        <tr>
            <td class="tableleft">地点</td>
            <td><input type="text" name="area" value="${requestScope.agree.YArea}" /></td>
        </tr>
        <tr>
            <td class="tableleft">备注</td>
            <td>
            	<input type="text" name="bz" value="${requestScope.agree.YBz}" />
            </td>
        </tr>
        <tr>
           <td class="tableleft"></td>
            <td>
                <button type="submit" class="btn btn-primary" type="button">确定</button>
                <button type="reset" class="btn btn-success">重填</button>
                <button type="button" id="deleted" class="btn btn-primary">删除</button>
            </td>
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