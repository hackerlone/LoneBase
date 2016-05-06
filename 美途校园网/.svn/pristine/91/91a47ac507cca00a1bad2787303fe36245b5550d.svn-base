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
		<s:action name="stu_getStudentMaxId" executeResult="false" />


		头像：
		<img id="headimg" src="upload/<s:property value="student.UTouxiang"/>" />
		<s:form id="uploadForm" action="upload_exec" method="post"
			enctype="multipart/form-data">
			<input id="file" type="file" name="myFile">
			<input id="uploadBtn" type="button" value="修改头像" />
		</s:form>

<s:form action="stu_addStu">
    编号:
  <input type="text" name="UId"
				value="<s:property value="#request.maxid"/>" readonly="readonly" />
		<br />		
		名称：<input type="text" name="UName" /><br />	
		性别：<select name="USex" >
				<option value="0" label="男" selected="selected">男</option>
				<option value="1" label="女">女</option>
			</select><br />	
			
		邮箱<input type="text" name="UEmail" /><br />	
		电话：<input type="text" name="UPhone" /><br />	
		密码：<input type="text" name="UPwd" /><br />	
		确认密码：<input type="text" name="UPwd1" /><br />
		
		生日:<sx:datetimepicker name="UBirthday" label="请选择出生日期" 
       displayFormat="yyyy年MM月dd日"/>
		
			<s:submit value="修改"></s:submit>
		</s:form>
	</body>
</html>
