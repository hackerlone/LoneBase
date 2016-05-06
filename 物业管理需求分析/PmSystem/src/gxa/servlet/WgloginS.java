package gxa.servlet;
import gxa.dao.Conn;
import gxa.db.Wgxx;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;


public class WgloginS extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	Conn conn = new Conn();
	public WgloginS() {
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

		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();		
		String option = request.getParameter("option");
		if(option.equals("checkname")){
			checkname(out, request);
		}else if(option.equals("login")){
			login(out, request);
		}else if(option.equals("saveUser")){
		     request.getRequestDispatcher("index.jsp").forward(request,response);
		}else if(option.equals("freesession")){
			request.getSession().invalidate();
			response.sendRedirect("login.html");
		}		
		out.flush();
		out.close();
	}

	public void checkname(PrintWriter out,HttpServletRequest request){
		String name = request.getParameter("name");
		//System.out.println(name);
		Wgxx wgxx = (Wgxx)conn.
		getOBJById("select * from [wgxx] where w_xm = '"+name+"'",
				new Wgxx());
		if(wgxx!=null){
		 out.println(1);
		}else{
			out.println(0);
		}
	}
	public void login(PrintWriter out,HttpServletRequest request){
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		System.out.println(name+"密码"+pwd);
		Wgxx wgxx = (Wgxx)conn.
		getOBJById("select * from [wgxx] where w_xm = '"+name+"'",
				new Wgxx());
		if(wgxx!=null){
			if(pwd.equals(wgxx.getW_pwd())){
				out.println(0);//登陆成功

			      HttpSession session=request.getSession();
			     session.setAttribute("name","wg");
			}else{
				out.println(-2);//密码错误
			}
		}else{
			out.println(-1);//表示用户名不存在
		}
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
