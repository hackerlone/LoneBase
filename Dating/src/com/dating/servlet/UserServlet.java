package com.dating.servlet;

import java.awt.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.cert.PKIXRevocationChecker.Option;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

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

public class UserServlet extends HttpServlet {
	UserService userService;
	/**
	 * Constructor of the object.
	 */
	public UserServlet() {
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
		//获取所有用户
		if(option.equals("getAllUser")){
		java.util.List<User> userList = userService.findAll();
		JSONArray users=JSONArray.fromObject(userList);
		System.out.println(users);
		}
		//根据id查询某信息
		if(option.equals("findById")){
			System.out.println("======================");
			String id = request.getParameter("id");
			User user = userService.findById(Integer.valueOf(id));
			JSONObject users = JSONObject.fromObject(user);
			System.out.println(users);
			out.print(users);
		}
		if(option.equals("findById1")){
			System.out.println("======================");
			String id = request.getParameter("id");
			User user = userService.findById(Integer.valueOf(id));
			JSONObject users = JSONObject.fromObject(user);
			System.out.println(users);
			request.setAttribute("user", user);
			request.getRequestDispatcher("sys/User/show.jsp").forward(request, response);
		}
		//添加用户信息
		
		if(option.equals("save")){
			User user = new User();
//			user.setUId(uId);
//			user.setTId(tId);
			user.setUName(request.getParameter("name"));
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
			
			
//			JSONObject users = JSONObject.fromObject(user);
//			System.out.println(users);
		}
		
		
		//更改用户信息
		if(option.equals("update")){		
			User user = new User();
			user.setUId(Integer.valueOf(request.getParameter("UId")));
			user.setUName(request.getParameter("username"));
			user.setUAge(request.getParameter("age"));
			user.setUSex(Integer.valueOf(request.getParameter("status")));
			user.setUEmail(request.getParameter("email"));
			MD5Code md5 =  new MD5Code();
			user.setUPwd(md5.getMD5ofStr(request.getParameter("password")));
			user.setUPhone(request.getParameter("phone"));
			user.setUArea(request.getParameter("area"));
			user.setUHead(request.getParameter("imgpath1"));
			user.setUSignature(request.getParameter("signature"));
			userService.update(user);
			response.sendRedirect("LoginServlet?option=loginout");
			
		}
		//删除用户信息
		if(option.equals("delete")){
			
		}
		//查询用户
		if(option.equals("findName")){
			String name = request.getParameter("name");
			System.out.println(name);
			
			java.util.List<User> user = userService.findByName(name);
			JSONArray users=JSONArray.fromObject(user);
			System.out.println(users);
			out.print(users);
		}
		//查询用户
		if(option.equals("findSex")){
			String sex = request.getParameter("sex");
			java.util.List<User> user = userService.findBySex(sex);
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String data1 = (String) (df.format(new Date())).subSequence(0, 4);
			for (User user2 : user) {
				System.out.println("data1:"+data1);
				String data = String.valueOf(Integer.valueOf(data1) - Integer.valueOf((String) user2.getUAge().subSequence(0,4)));
				user2.setUAge(data);
			}
			JSONArray users=JSONArray.fromObject(user);
			System.out.println(users);
			out.print(users);
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
