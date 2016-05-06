<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">-->
	
		<link href="css/serch.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="js/jquery-1.4.1.js"></script>
		<script type="text/javascript" src="js/serch.js"></script>
<style type="text/css">
body{
	
}
table{
background-color: #79FF79;
font-family: "微软雅黑";
font-size:20;
color: green;
margin: 0 auto;
border-color: #999;
border-bottom-color: red;
}
.thead{
	background-color: #B15BFF;

}
.tab{

}
table tr td{
text-align: center;
}

table tr:hover{
	background-color: #F9F900;
	transform:scale(1.1);
	transition:transform 0.3s ease
}
</style>
  </head>
  
  <body>
  <!-- 联动搜索开始 -->
   	<div class="bline_search">
			<div id="search1" class="refineNavOn">
				公司性质
			</div>
			<div id="xz" class="refineMenu">
				<ul>
					<li><a >外资</a></li>
					<li><a >合资</a></li>
					<li><a >国企</a></li>
					<li><a >民营公司</a></li>
					<li><a >上市公司</a></li>
					<li><a >创业公司</a></li>
					<li><a >政府机关</a></li>
					<li><a >事业单位</a></li>
					<li><a >非营利机构</a></li>
				</ul>
			</div>
			<div id="search2" class="refineNavOn">
				月薪范围
			</div>
			<div id="yx" class="refineMenu">
				<ul>
					<li><a >0-1500</a></li>
					<li><a >1500-1999</a></li>
					<li><a >2000-2999</a></li>
					<li><a >3000-4499</a></li>
					<li><a >4500-5999</a></li>
					<li><a >6000-7999</a></li>
					<li><a >8000-9999</a></li>
					<li><a >10000-9999999</a></li>				
				</ul>
			</div>
			<div id="search3" class="refineNavOn">
				公司人数
			</div>
			<div id="gm" class="refineMenu">
				<ul>
					<li><a >0-50</a></li>
					<li><a >50-150</a></li>
					<li><a >150-500</a></li>
					<li><a >500-1000</a></li>
					<li><a >1000-5000</a></li>
					<li><a >5000-10000</a></li>
					<li><a >10000-999999</a></li>
				</ul>
			</div>
			<div id="search4" class="refineNavOn">
				学历要求
			</div>
			<div id="xl" class="refineMenu">
				<ul name="">
					<li><a >初中及以下</a></li>
					<li><a >高中</a></li>
					<li><a >中专</a></li>
					<li><a >大专</a></li>
					<li><a >本科</a></li>
					<li><a >硕士</a></li>
					<li><a >博士</a></li>
				</ul>
			</div>
</div>

		<div class="tab">
			<table border="1">
				<tr class="thead">
				<th>编号</th>
				<th>所属企业</th>
				<th>职位</th>
				<th>发布时间</th>
				<th>工作地点</th>
				<th>所需人数</th>
				<th>职能要求</th>
				<th>描述</th>
				<th>薪资</th>
				<th>学历</th>
				</tr>
				<tbody id="secjob">
					
				</tbody>
			</table>
		</div>
		 <!-- 联动搜索结束 -->
  </body>
</html>
