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
	src="My97DatePicker/WdatePicker.js"></script>

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
	#uhead{
		width: 40px;
		height: 30px;
	}
	.sel{
		width: 60px;
		height: 30px;
	}

    </style>
    <script type="text/javascript">
    $(function() {
    	var sexx = $("#sex").text();
    	if(sexx==1){
    		$("#sex").text("男");
    	}else if(sexx==2){
    		$("#sex").text("女");
    	}
    	
    		$("#seacher").click(function(){
    			$(".user").remove();
    			var name = $("#username").val();
    			var uid = ${sessionScope.user.UId};
    			$.ajax({
					url : 'UserServlet?option=findName',
					type : 'post',
					data : {"name" : name},
					dataType:'json',
					success : function(data) {
						$(data).each(function(i, obj) {
							if(obj.USex=='1'){sexvalue="男"}
							else if(obj.USex=='2'){sexvalue="女"}
							var path = "upload/"+obj.UHead;
							var sendmsg="sys/Role/chat.jsp?option=sendmsg&tid='"+uid+"'&uid='"+obj.UId+"'";
							$("#usertab").append("<tr class='user'><td>"+obj.UName+"</td><td>"
									+obj.UAge+"</td><td>"
									+obj.UArea+"</td><td>"
									+sexvalue+"</td><td><img id='uhead' src='"+path+"'/></td><td>"
									+obj.USignature+"</td><td><a href='"+sendmsg+"'>发送信息</a></td></tr>");
						});
					}
    		});
    	});
    		
    		 $("#sel").change(function(){
    			 $(".user").remove();
    		    	var sex = $(this).val();
    		    	var uid = ${sessionScope.user.UId};
    		    	$.ajax({
    					url : 'UserServlet?option=findSex',
    					type : 'post',
    					data : {"sex" : sex},
    					dataType:'json',
    					success : function(data) {
    						$(data).each(function(i, obj) {
    							if(obj.USex=='1'){sexvalue="男"}
								else if(obj.USex=='2'){sexvalue="女"}
    							var path = "upload/"+obj.UHead;
    							var send="sys/Role/chat.jsp?option=sendmsg&tid="+uid+"&uid="+obj.UId+"";
    							$("#usertab").append("<tr class='user'><td>"+obj.UName+"</td><td>"
									+obj.UAge+"</td><td>"
									+obj.UArea+"</td><td>"
									+sexvalue+"</td><td><img id='uhead' src='"+path+"'/></td><td>"
									+obj.USignature+"</td><td><a href='"+send+"'>发送信息</a></td></tr>");
    					});
    					}
        		});
    		    });
    });
    </script>
</head>
<body>

<form class="form-inline definewidth m20" action="" method="get">    
    用户名:
    <input type="text" name="username" id="username"class="abc input-default" placeholder="" value="">&nbsp;&nbsp;  
    <button type="button" class="btn btn-primary" id="seacher">查询</button>
    <select class="sel" id="sel">
    	<option value="0" selected="selected">性别</option>
    	<option value="1">男</option>
    	<option value="2">女</option>
    </select>
    &nbsp;&nbsp; <a href="sys/User/edit.jsp"><button type="button" class="btn btn-success" id="">修改</button></a>
</form>
<table class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr>
        <th>用户名</th>
        <th>年龄</th>
        <th>地区</th>
        <th>性别</th>
        <th>头像</th>
        <th>个性签名</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody id="usertab">
	     <tr>
            <td>${sessionScope.user.UName}</td>
            <td>${sessionScope.user.UAge}</td>
            <td>${sessionScope.user.UArea}</td>
            <td id="sex">${sessionScope.user.USex}</td>
            <td><img id="uhead" src="<%=basePath %>upload/${sessionScope.user.UHead}"/></td>
            <td>${sessionScope.user.USignature}</td>
            <td>
                <a href="sys/User/edit.jsp">修改</a>                
            </td>
        </tr>
        </tbody>	
</table>
</body>
</html>
<script>
    $(function () {
        

		$('#addnew').click(function(){

				window.location.href="add.jsp";
		 });


    });

	function del(id)
	{
		
		
		if(confirm("ç¡®å®è¦å é¤åï¼"))
		{
		
			var url = "index.jsp";
			
			window.location.href=url;		
		
		}
	
	
	
	
	}
</script>