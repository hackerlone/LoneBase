<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html> 
<head>
<base href="<%=basePath%>">
<title>实习僧-实习生-最靠谱的实习生招聘网站</title>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="renderer" content="webkit">
<meta name="description" content="实习僧是国内领先的实习生招聘网站,500强名企实习,靠谱实习机会,优质实习信息,优秀实习生,找实习就上实习僧,实习生招聘首选实习僧。">
<meta name="keywords" content="实习,实习生,找实习,实习生招聘,暑期实习,实习僧">
<meta name="Robots" content="all">
<meta property="qc:admins" content="2040752403463010135676375"/>
<meta name="baidu-site-verification" content="EP5drAzZgp"/>
<link rel="icon" href="${pageContext.request.contextPath}/images/favicon.ico" type="image/x-icon" />
<link rel="Shortcut Icon" href="${pageContext.request.contextPath}/images/favicon.ico" type="image/x-icon">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/spinner.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/register_index.css"/>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/trainee_center.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/ajaxfileupload.js"></script>
     <script type="text/javascript" src="${pageContext.request.contextPath}/js/upload.js"></script>
     <script src="${pageContext.request.contextPath}/css/jquery-1.9.1.min.js"></script>
<script src="${pageContext.request.contextPath}/css/jquery-creatBox.js"></script>
<script src="${pageContext.request.contextPath}/js/utils.js"></script>
<script src="${pageContext.request.contextPath}/js/layer.js"></script>
<script src="${pageContext.request.contextPath}/js/main_base.js"></script>
<script>
var item = 'feedback',maxLength = '2';
</script>
<script src="${pageContext.request.contextPath}/css/upload.js"></script>
<script src='${pageContext.request.contextPath}/css/jquery-creatBox.js'></script>
<script src="${pageContext.request.contextPath}/js/trainee_center.js"></script>

<script>
var _hmt = _hmt || [];
(function () {
var hm = document.createElement("script");
hm.src = "//hm.baidu.com/hm.js?aedd3972ca50f4fd67b4d7e025fa000c";
var s = document.getElementsByTagName("script")[0];
s.parentNode.insertBefore(hm, s);
})();
</script>
<style type="text/css">
.shanchu{
float:left;
}
.a{margin-left:100px;}
</style>
    <link rel="stylesheet" type="text/css"  href="css/reg.css">
    <sx:head parseContent="true"/>
 	<script type="text/javascript" src="js/jquery-1.4.1.js"></script>
    <script type="text/javascript" src="js/ajaxfileupload.js"></script>
     <script type="text/javascript" src="js/upload.js"></script>
     <script language="javascript" type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
   <script language="javascript" type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
     <script type="text/javascript">
     	$("document").ready(function (){
     		$("#freesession").click(function(){
				option="freesession";
				$.ajax({
					type:'POST',
                    data: {'email':null,'password':null,'option':option},
                    url:'stu_stuLogin',
                    dataType:'text',
                    success: function (data){
                    	location.reload();
                    	} 
					});
                });
         	});
     </script>
  </head>
  <body>
  
  
  <s:action name="job_getAllJob" executeResult="false"/> 
  
  <div id="header_box">
<div id="header">
<div id="header_content">
<a href="index.jsp" class="home_logo">
<h1>实习僧</h1>
</a>
<ul id="item_box">

<li >
<a href="index.jsp" class="header_href">首页</a>
</li>
<li  class="active" >
<a href="qy_getEnterpriseById.action?enterprise.QId=<s:property value="enterprise.QId"/>&option=updata" class="header_href">个人中心</a>
</li>
<li >
<a href="/topic" target="_blank" class="header_href">活动</a>
</li>
<li><a href="http://more.shixiseng.com/" target="_blank" class="header_href">加油站</a></li>

</ul>
<!--未登录-->

<!--已经登录 企业用户-->
<dl id="log_user">
<dt id="user_name"><s:property value="#request.enterprise.QName"/><span class="redstar"></span></dt>


<dd class="user_nav"><a href="qy_getEnterpriseById.action?enterprise.QId=<s:property value="enterprise.QId"/>&option=updata">个人中心<span class="redstar"></span></a></dd>
<dd class="user_nav"><a  id="freesession"  href="" class="exit">退出</a></dd>
</dl>

</div>
</div>
</div>
<div id="container">

<!--<div id="shade"></div>-->
<div class="box">
<div class="resume_box">
<div class="base_inf">
<!--  
    <img src="upload/<s:property value="enterprise.student.UTouxiang"/>" id="head_img" />
<input type="file" class="header_fil" id="header_fil"/><br/>
   -->
  
    编号:<s:property value="enterprise.QId"/><br/>
  <strong><s:property value="#request.enterprise.QName"/></strong>
注册时间：<s:property value="#request.enterprise.QDate"/>
 | 
公司性质：<s:property value="#request.enterprise.QXingzhi"/>
 |公司规模： <s:property value="#request.enterprise.QGuimo"/> 人<p />
 地址： <s:property value="#request.enterprise.QArea"/> 
 |邮编： <s:property value="#request.enterprise.QYoubian"/> 
 |邮箱： <s:property value="#request.enterprise.QEmail"/> 
 |公司简介： <s:property value="#request.enterprise.QMiaoshu"/> 
<p />
   <s:if test="#session.enterprise.QName!=null">   
       <a href="qy_getEnterpriseById.action?enterprise.QId=<s:property value='enterprise.QId'/>&option=update">企业信息修改</a>
   	</s:if>
   	<br/>
   
           
                   
          	
          	<div class="resume_handle">
<i class="add_resume">
<span class="add_ico">
<a>+</a>
</span>
</i>
</div>
</div>
<div class="res_load_box">
<div class="load_con">

<div class="resume">
<div>
<p>
<strong></strong>
</p>
<span class="add_resume_box">
<a href="jianli1.html"
class="add_resume_item" data-point="34">
<canvas class="completeness" width="50" height="50"></canvas>
<span class="close_resume" data-resid="res_bbecb3vwaekf">x</span>
</a>

<a class="add_resume_item wait_eng not_have">
English
<span class="inexistence">&#xe632;</span>
</a>

</span>
</div>
<p class="update_time">最近更新 2015-11-16 21:17:22</p>
</div>

</div>
</div>
<div class="fun_view">


<ul>
<li class="fankui active view_item" data-item="feedback">
<i></i>
职位修改
<span class="view_item_num">
</span>
 
</li>
<li class="shouchang view_item" data-item="mcollect">
<i></i>
职位份数
<span class="view_item_num">( <s:property value="enterprise.jobs.size"/>)</span>
</li>
<li class="dinyue is_wait" data-item="msubscrip">
<i></i>
<a href="job/add.jsp" >
添加职位</a>
<!--<span class="view_item_num">0</span>-->
</li>
<li class="yaoyue is_wait">
<i></i>
删除职位
<span class="view_item_num">

</span>
</li>
</ul>

<i class="view_flag"  style="left:88px;"></i>
</div>
<div class="fun_model">
<!--投递反馈-->
<div class="fun_model_feedback">
<div class="back_nav">
<s:if test="#session.enterprise.QId==#request.enterprise.QId">
<ul class="shanchu">
<li class="back_item" data-back="all">全部</li>
 职位修改:<br />
<s:iterator value="#request.jobs" var="job">         
          	  <li class="back_item" data-back="all">
          	  <a href="/MTCampus/job_getJobById.action?id=<s:property value="#job.ZId"/>&option=update">修改<s:property value="#job.ZId"/>号职位</a><br />
            	</li><br />
            </s:iterator>
 
</ul>
<ul class="shanchu a">
职位删除：<br/>
            <s:iterator value="#request.jobs" var="job">
             <li class="back_item" data-back="all">         
          	 <a href="/MTCampus/job_deleteJob.action?id=<s:property value="#job.ZId"/>&option=delete">删除<s:property value="#job.ZId"/>号职位</a><br />
            </li><br />
            </s:iterator>
</ul>
</s:if>
<div class="back_inf">
</div>
</div>
</div>
</div>
</div>
</div> 
  </body>
</html>
