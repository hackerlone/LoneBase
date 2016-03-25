package com.Campus.controller;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UploadAction extends ActionSupport {
	// username属性用来封装用户名
	
	// myFile属性用来封装所有上传的文件
	private List<File> myFile;
	
	// myFileContentType属性用来封装所有上传文件的类型
	private List<String> myFileContentType;
	
	// myFileFileName属性用来封装所有上传文件的文件名
	private List<String> myFileFileName;

	private String savePath;
	
	private List<String> fileNames = new ArrayList<String>();
	
	
	public List<String> getFileNames() {
		return fileNames;
	}

	public void setFileNames(List<String> fileNames) {
		this.fileNames = fileNames;
	}

	//获得上传文件保存目录
	public String getSavePath() {
		return savePath;
	}
	
	//设置上传文件保存目录
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	
	//获得myFile值
	public List<File> getMyFile() {
		return myFile;
	}

	//设置myFile值
	public void setMyFile(List<File> myFile) {
		this.myFile = myFile;
	}

	//获得myFileContentType值
	public List<String> getMyFileContentType() {
		return myFileContentType;
	}

	//设置myFileContentType值
	public void setMyFileContentType(List<String> myFileContentType) {
		this.myFileContentType = myFileContentType;
	}

	//获得myFileFileName值
	public List<String> getMyFileFileName() {
		return myFileFileName;
	}

	//设置myFileFileName值
	public void setMyFileFileName(List<String> myFileFileName) {
		this.myFileFileName = myFileFileName;
	}

	public String exec() throws Exception {
		System.out.println("ttt");
		//取得用来上传的文件数组
		try {
			List<File> files = getMyFile();
			//循环每个上传的文件
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");//设置日期格式
			//System.out.println(df.format(new Date()));// 
			for (int i = 0; i < files.size(); i++) {
				
				//基于file[i]创建一个文件输入流
				InputStream is = new FileInputStream(files.get(i));
				
				// 设置上传文件目录
				String uploadPath = ServletActionContext.getServletContext()
						.getRealPath(getSavePath());
				
				
				
				// 设置目标文件
				String oldFileName = getMyFileFileName().get(i);
				String newFileName = df.format(new Date())+oldFileName.substring(oldFileName.lastIndexOf("."));
				//System.out.println(newFileName);
				getMyFileFileName().set(i,newFileName);
				File toFile = new File(uploadPath,newFileName);
				
				fileNames.add(newFileName);
				ServletActionContext.getRequest().setAttribute("fileNames", fileNames);
				
				// 输出流
				OutputStream os = new FileOutputStream(toFile);

				//设置缓存
				byte[] buffer = new byte[1024];

				int length = 0;

				//读取file[i]文件输出到toFile文件中
				while ((length = is.read(buffer)) > 0) {
					os.write(buffer, 0, length);
				}
				
				//关闭输入流
				is.close();
				
				//关闭输出流
				os.close();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.addActionError("文件上传失败");
			return this.ERROR;
		}
		//添加一个strutst提示信息
		this.addActionMessage("上传成功");
		String url = (String) ActionContext.getContext().getValueStack().findValue("url");
		//ServletActionContext.getRequest().setAttribute("myFileFileName", myFileFileName);
		//JSONArray filenames = JSONArray.fromObject(myFileFileName);
        
        
		ServletActionContext.getResponse().getWriter().print(myFileFileName.get(0));
		//ServletActionContext.getResponse().getWriter().flush();
		//ServletActionContext.getResponse().getWriter().close();
		return this.NONE;
	}
}
