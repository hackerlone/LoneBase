<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/paging.tld" prefix="page"%>
<html>
<head>
<base href="<%=basePath%>">

<title>查看留言表单</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="style/bootstrap.css" rel="stylesheet">
<!-- Font awesome icon -->
<link rel="stylesheet" href="style/font-awesome.css">
<!-- jQuery UI -->
<link rel="stylesheet" href="style/jquery-ui.css">
<!-- Calendar -->
<link rel="stylesheet" href="style/fullcalendar.css">
<!-- prettyPhoto -->
<link rel="stylesheet" href="style/prettyPhoto.css">
<!-- Star rating -->
<link rel="stylesheet" href="style/rateit.css">
<!-- Date picker -->
<link rel="stylesheet" href="style/bootstrap-datetimepicker.min.css">
<!-- CLEditor -->
<link rel="stylesheet" href="style/jquery.cleditor.css">
<!-- Uniform -->
<link rel="stylesheet" href="style/uniform.default.css">
<!-- Bootstrap toggle -->
<link rel="stylesheet" href="style/bootstrap-switch.css">
<!-- Main stylesheet -->
<link href="style/style.css" rel="stylesheet">
<!-- Widgets stylesheet -->
<link href="style/widgets.css" rel="stylesheet">

</head>

<body>
	<div align="center">
		<font size="20">查看留言</font>
	</div>
	<br />
	<!-- 添加 -->

	<div class="widget">

		<div class="widget-head">
			<div class="pull-left">表单</div>
			<div class="widget-icons pull-right">
				<a href="main.jsp" class="wminimize"><i class="icon-chevron-up"></i>
				</a> <a href="#" class="wclose"><i class="icon-remove"></i> </a>
			</div>
			<div class="clearfix"></div>
		</div>

		<div class="widget-content">

			<table class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						
						<th>姓名</th>
						<th>邮箱</th>
						<th>留言内容</th>
							<c:if test="${sessionScope.name=='admin'||sessionScope.name=='wg'}">   
						<th>操作</th>
						</c:if>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="ts" items="${tss}">
						<tr>
							
							<td>${ts.o_id }</td>
							<td>${ts.w_id }</td>
							<td>${ts.t_sy }</td>
							<td>
	<c:if test="${sessionScope.name=='admin'||sessionScope.name=='wg'}">   
								<button class="btn btn-xs btn-success" title="增加">
									<a href="TsS?option=add"><i class="icon-ok"></i> </a>
								</button>
								<button class="btn btn-xs btn-warning" title="修改">
									<a href="TsS?option=UpdateById&id=${ts.ly_id }"><i class="icon-pencil"></i> </a>
								</button>
								<button class="btn btn-xs btn-danger" title="删除">
									<a href="TsS?option=deleteById&id=${ts.ly_id }"><i
										class="icon-remove"></i> </a>
								</button>
								</c:if></td>
							
						</tr>
					</c:forEach>

				</tbody>
			</table>

			<div class="widget-foot">

				<!-- 分页 -->
				<ul class="pagination pull-right">
					<page:paging href="TsS?option=getByPage"
						totalRecords="${pageinfo.itemCount}"
						offset="${pageinfo.firstResult}" pageSize="${pageinfo.maxResults}" />
				</ul>
				<div class="clearfix"></div>

			</div>

		</div>

	</div>
</body>
</html>

