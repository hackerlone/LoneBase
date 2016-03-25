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

<title>物业资源页面</title>

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
		<font size="20">资源信息查询 </font>
	</div>
	<br />
	<!-- 添加 -->

	<div class="widget">

		<div class="widget-head">
			<div class="pull-left">表单</div>
			<div class="widget-icons pull-right">
				<a href="main.jsp" class="wminimize"><i class="icon-chevron-up"></i></a>
			</div>
			<div class="clearfix"></div>
		</div>

		<div class="widget-content">

			<table class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						<th>资源编号</th>
						<th>库存编号</th>
						<th>资源类别</th>
						<th>资源名称</th>
						<th>资源现在情况</th>
						<th>资源外借人</th>
						<th>管理员编号</th>
						<th>仓库编号</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="zy" items="${zys}">
						<tr>
							<td>${zy.zy_id }</td>
							<td>${zy.k_id }</td>
							<td>${zy.zy_leibie }</td>
							<td>${zy.zy_name }</td>
							<td>${zy.zy_qingkuang }</td>
							<td>${zy.zy_waijieren }</td>
							<td>${zy.w_id }</td>
							<td>${zy.ck_id }</td>
							<td>
							<c:if test="${sessionScope.name=='admin'||sessionScope.name=='wg'}">   
								<button class="btn btn-xs btn-success" title="增加">
									<a href="ZyS?option=add"><i class="icon-ok"></i></a>
								</button>
								<button class="btn btn-xs btn-warning" title="修改">
									<a href="ZyS?option=UpdateById&id=${zy.zy_id }"><i class="icon-pencil"></i> </a>
								</button>
								<button class="btn btn-xs btn-danger" title="删除">
									<a href="ZyS?option=deleteById&id=${zy.zy_id }"><i class="icon-remove"></i> </a>
								</button>
								</c:if>
							</td>
						</tr>
					</c:forEach>

				</tbody>
			</table>

			<div class="widget-foot">

				<!-- 分页 -->
				<ul class="pagination pull-right">
					<page:paging href="ZyS?option=getByPage"
						totalRecords="${pageinfo.itemCount}" 
						offset="${pageinfo.firstResult}" pageSize="${pageinfo.maxResults}" />
				</ul>
				<div class="clearfix"></div>

			</div>

		</div>

	</div>
</body>
</html>

