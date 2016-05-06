<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>My JSP 'reg.jsp' starting page</title>

		<link rel="stylesheet" type="text/css" href="css/reg.css">
		<sx:head parseContent="true" />
		<script type="text/javascript" src="js/jquery-1.4.1.js"></script>
		<script type="text/javascript" src="js/ajaxfileupload.js"></script>
		<script type="text/javascript" src="js/upload.js"></script>
	</head>
	<body>
		<s:action name="qy_getEnterpriseMaxId" executeResult="false" />


		头像：
		<img id="headimg" src="upload/<s:property value="enterprise.QTouxiang"/>" />
		<s:form id="uploadForm" action="upload_exec" method="post"
			enctype="multipart/form-data">
			<input id="file" type="file" name="myFile">
			<input id="uploadBtn" type="button" value="修改头像" />
		</s:form>

<s:form action="qy_addEnterprise">
    编号:
  <input type="text" name="QId" 
          value="<s:property value="#request.maxidQId"/>" readonly="readonly" /><br />		
		名称：<input type="text" name="QName" /><br />		
		密码：<input type="text" name="QPwd" /><br />	
		确认密码：<input type="text" name="QPwd1" /><br />
	    <sx:datetimepicker name="QDate" label="请选择注册日期"  
       displayFormat="yyyy年MM月dd日"/><br />	
                      性质：<input type="text" name="QXingzhi"/><br />	
                      规模：<input type="text" name="QGuimo"/><br />	
                      地址:<input type="text" name="QArea"/><br />	
                      邮编:<input type="text" name="QYoubian"/><br />	
                      邮箱:<input type="text" name="QEmail"/><br />	
		电话：<input type="text" name="QPhone" /><br />
		描述<input type="text" name="QMiaoshu" /><br />		
			<s:submit value="修改"></s:submit>
		</s:form>
	</body>
</html>
