package com.dating.servlet;

import java.awt.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.cert.PKIXRevocationChecker.Option;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import annotation.Column;

import com.daing.utils.MD5Code;
import com.dating.entity.User;
import com.dating.service.UserService;
import com.dating.service.impl.UserServiceImpl;

public class LoginServlet extends HttpServlet {
	UserService userService;
	/**
	 * Constructor of the object.
	 */
	public LoginServlet() {
		super();
		userService = new UserServiceImpl();
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

		doPost(request, response);
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

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String option = request.getParameter("option");
		
		//添加用户信息		
		if(option.equals("save")){
			User user = new User();
//			user.setUId(uId);
//			user.setTId(tId);
			user.setUName(request.getParameter("name"));
			user.setUEmail(request.getParameter("email"));
			//单独处理时间
			user.setUAge(request.getParameter("age"));//			
			user.setUSex(Integer.valueOf(request.getParameter("sex")));
			//单独处理密码
			MD5Code md5 =  new MD5Code();
			user.setUPwd(md5.getMD5ofStr(request.getParameter("pwd")));
			
			user.setUPhone(request.getParameter("phone"));
			user.setUArea(request.getParameter("area"));
			user.setUSignature(request.getParameter("qianming"));
			userService.save(user);	
			response.sendRedirect(request.getContextPath()+"/login.html");
			
//			JSONObject users = JSONObject.fromObject(user);
//			System.out.println(users);
		}
		
		//登录
		if(option.equals("login")){
			String username = request.getParameter("username");
			MD5Code md5 =  new MD5Code();
			String password = md5.getMD5ofStr(request.getParameter("password"));
			User user = userService.login(username,password);
//			System.out.println(user.getUName());
			if(user != null){
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				session.setAttribute("userid", user.getUId());
				System.out.println("session:"+session.getAttribute("userid"));
				out.print(1);
			}else {
				out.print(0);
			}
		}
		//注销登录
		if(option.equals("loginout")){
			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect("login.html");
		}
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
