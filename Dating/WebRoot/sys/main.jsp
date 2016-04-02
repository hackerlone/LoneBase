<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>
	<base href="<%=basePath%>">
    <title>后台管理系统</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="sys/assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
    <link href="sys/assets/css/bui-min.css" rel="stylesheet" type="text/css" />
    <link href="sys/assets/css/main-min.css" rel="stylesheet" type="text/css" />
    <script language="javascript" type="text/javascript"
	src="My97DatePicker/WdatePicker.js"></script>
</head>
<body>

<div class="header">

    <div class="dl-title">
        <!--<img src="/chinapost/Public/assets/img/top.png">-->
    </div>

    <div class="dl-log">欢迎您，<span class="dl-log-user">${sessionScope.user.UName}</span><a href="LoginServlet?option=loginout" title="退出系统" class="dl-log-quit">[退出]</a>
    </div>
</div>
<div class="content">
    <div class="dl-main-nav">
        <div class="dl-inform"><div class="dl-inform-title"><s class="dl-inform-icon dl-up"></s></div></div>
        <ul id="J_Nav"  class="nav-list ks-clear">
            <li class="nav-item dl-selected"><div class="nav-item-inner nav-home">系统管理</div></li>		

        </ul>
    </div>
    <ul id="J_NavContent" class="dl-tab-conten">
		
    </ul>
</div>
<script type="text/javascript" src="sys/assets/js/jquery-1.8.1.min.js"></script>
<script type="text/javascript" src="sys/assets/js/bui-min.js"></script>
<script type="text/javascript" src="sys/assets/js/common/main-min.js"></script>
<script type="text/javascript" src="sys/assets/js/config-min.js"></script>
<script>
    BUI.use('common/main',function(){
        var config = [{id:'1',menu:[{text:'系统管理',items:[{id:'12',text:'资讯管理',href:'sys/Node/index.jsp'},{id:'3',text:'约单管理',href:'sys/Node/index.jsp'},{id:'4',text:'用户管理',href:'sys/User/index.jsp'},{id:'6',text:'安全退出',href:'LoginServlet?option=loginout'}]}]},{id:'7',homePage : '9',menu:[{text:'业务管理',items:[{id:'9',text:'查询业务',href:'sys/Node/index.jsp'}]}]}];
        new PageUtil.MainPage({
            modulesConfig : config
        });
    });
</script>
</body>
</html>