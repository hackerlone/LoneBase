<%@page import="com.dating.entity.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="com.daing.utils.*"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.net.URLDecoder"%>

<%!
String imagepath1="";
//编辑页面中包含 camera.swf 的 HTML 代码
public String renderHtml(String id,String basePath,String input)
{
	String outinput="";
	try {
	outinput = URLDecoder.decode(input);
	}catch(Exception e)
	{
		System.out.println("解码错误!");
	}
	String[] tmp_input=outinput.split("@");//input传递的类型和uid
	//System.out.println(input+","+tmp_input.length);
	
	String uc_api =URLEncoder.encode(basePath+"upload/avatar.jsp");

	String urlCameraFlash = "camera.swf?nt=1&inajax=1&appid=1&input="+input+"&uploadSize=1000&ucapi="+uc_api;
	urlCameraFlash = "<script src=\"common.js?B6k\" type=\"text/javascript\"></script><script type=\"text/javascript\">document.write(AC_FL_RunContent(\"width\",\"450\",\"height\",\"253\",\"scale\",\"exactfit\",\"src\",\""+urlCameraFlash+"\",\"id\",\"mycamera\",\"name\",\"mycamera\",\"quality\",\"high\",\"bgcolor\",\"#ffffff\",\"wmode\",\"transparent\",\"menu\",\"false\",\"swLiveConnect\",\"true\",\"allowScriptAccess\",\"always\"));</script>";

	return urlCameraFlash;
}
public String getFileExt(String fileName) {
    // 下面取到的扩展名错误，只有三位，而如html的文件则有四位
    // extName = fileName.substring(fileName.length() - 3, fileName.length()); //扩展名
    int dotindex = fileName.lastIndexOf(".");
    String extName = fileName.substring(dotindex, fileName.length());
    extName = extName.toLowerCase(); //置为小写
    return extName;
}
private byte[] getFlashDataDecode(String src)
{
	char []s=src.toCharArray();
	int len=s.length;
    byte[] r = new byte[len / 2];
    for (int i = 0; i < len; i = i + 2)
    {
        int k1 = s[i] - 48;
        k1 -= k1 > 9 ? 7 : 0;
        int k2 = s[i + 1] - 48;
        k2 -= k2 > 9 ? 7 : 0;
        r[i / 2] = (byte)(k1 << 4 | k2);
    }
    return r;
}
public boolean saveFile(String path,byte[]b){
	try{
		FileOutputStream fs = new FileOutputStream(path);
	    fs.write(b, 0, b.length);
	    fs.close();
		return false;
	}catch(Exception e){
	    return true;
	}
}
%>

<%
String uploadtype= request.getParameter("uploadtype");
//图片上传类型:头像,logo,图片分别对应参数:head,logo,pic没有传递，默认为PIC
if("".equals(uploadtype))
{
	uploadtype="pic";
}
//最终裁剪好的图片存放位置
String uid=request.getParameter("uid");
	imagepath1=uploadtype+"/"+uid+"_big.jpg";
	
String action= request.getParameter("a");
//String input=request.getParameter("input");
String path = request.getContextPath();
String infoFilePath="";
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
if(action==null){
	%>
	<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
	<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
	<style>
	body{
		margin: 0;
		border: 0;
	}
	</style>
	<script type="text/javascript">
	function updateavatar() {
		var img1="<%=imagepath1%>";
		if(window.opener.document.getElementById("imgpath1"))
		{
			window.opener.document.getElementById("imgpath1").value=img1;
			window.opener.document.getElementById("showimg1").src="upload/"+img1;
		}
		window.close();
	}
	
	</script>
	</head>
	<body>
	<%
	out.print(renderHtml("5",basePath,URLEncoder.encode(uploadtype+"@"+uid)));
	%>
	</body></html>
	<%
}else if("uploadavatar".equals(action)){//上传临时图片,可以自己实现
		//System.out.println(action);
		UploadUtil uploadUtil = new UploadUtil();
		boolean isOk = uploadUtil.initParam(pageContext,request);
		if (isOk == false)
		{
			System.out.println("页面出错：" + uploadUtil.getMsg());
			return;
		}
		//上传附件  
		isOk = uploadUtil.uploadFile("");
		if (isOk == false)
		{
			System.out.println("页面出错：" + uploadUtil.getMsg());
			return;
		}
		Map map = uploadUtil.getUploadFiles();
		if (map == null)
		{
			System.out.println("页面出错：上传附件失败");
		}
		if (map.size() == 0)
		{
			System.out.println("页面出错：没有上传附件");
			return;
		}
		//获取附件文件名和存储文件路径
		for (Iterator iter = map.keySet().iterator(); iter.hasNext();)
		{
			infoFilePath = (String) iter.next();
			String infoFileName = (String) map.get(infoFilePath);
			//infoFilePath=infoFilePath.substring(infoFilePath.lastIndexOf("\\")+1);
			//System.out.println(infoFilePath);
			//infoFilePath=infoFilePath.substring(infoFilePath.indexOf("webapps")+8);
			infoFilePath=infoFilePath.replaceAll("\\\\", "/");
			//System.out.println(basePath+"upload"+infoFilePath);
			out.clear();
			out.print(basePath+"upload"+infoFilePath);
		}

}else if("rectavatar".equals(action)){//缩略图
	String avatar1 = request.getParameter("avatar1");//大
	String avatar2 = request.getParameter("avatar2");//中
	String avatar3 = request.getParameter("avatar3");//小
	String output ="";
	try {
	output = URLDecoder.decode(request.getParameter("input"));
	System.out.println("00:"+output);
	}catch(Exception e)
	{
		System.out.println("解码错误!");
	}
	
	String[] tmp_input=output.split("@");//input传递的类型和uid
	String pathff = request.getSession().getServletContext().getRealPath("/")+ "upload\\";
	String imgfilepath=pathff+tmp_input[0];
	imagepath1=imgfilepath+"/"+tmp_input[1]+"_big.jpg";

	out.clear();
	boolean a1=saveFile(imagepath1,getFlashDataDecode(avatar1));
	
	if(a1){
		out.print("<?xml version=\"1.0\" ?><root><face success=\"0\"/></root>");
	}else{
		out.print("<?xml version=\"1.0\" ?><root><face success=\"1\"/></root>");
	}
	
}
%>
