package gxa.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.PageContext;

import com.jspsmart.upload.SmartUpload;

public class FileUpS extends HttpServlet {
	 private ServletConfig config;  
	 final public void init(ServletConfig config) throws ServletException {  
	  this.config = config;  
	 } 
	/**
	 * Constructor of the object.
	 */
	public FileUpS() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out
				.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("GBK");
		
		int count = 0;  
		  //创建一个SmartUpload类  
		 String fileName = "";
		  SmartUpload mySmartUpload = new SmartUpload();  
		  try {  
		        //初始化     
		        mySmartUpload.initialize(config, request, response);  
		       //上传  
		       mySmartUpload.upload();  
		       for (int i = 0; i < mySmartUpload.getFiles().getCount(); i++) {  
		        com.jspsmart.upload.File myfile = mySmartUpload.getFiles().getFile(i);  
		        fileName = myfile.getFileName();  
		        //保存  
		        count = mySmartUpload.save("/images");  
		        //count = mySmartUpload.save(null);  
		       }  
		       out.println( "<script>");
               out.print("alert('添加成功');");
              String url= request.getParameter("url");
              
               out.print("window.location.href='"+url+"&imgsrc="+fileName+"';");
               out.print("</script>");
		  } catch (Exception e) {  
		       out.println("Unable to upload the file.<br>");  
		       out.println("Error : " + e.toString());  
		  }  

		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	

}
