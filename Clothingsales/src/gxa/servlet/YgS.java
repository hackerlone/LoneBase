package gxa.servlet;
import gxa.dao.Conn;
import gxa.db.Employee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.registry.infomodel.User;


public class YgS extends HttpServlet {
	 Integer other;
	/**
	 * Constructor of the object.
	 */
	Conn conn = new Conn();
	public YgS() {
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
		}else if(option.equals("saveYg")){
			Integer other= (Integer)request.getSession().getAttribute("other");
			
			
			if(other==1){
				request.setAttribute("url", "inde.html");
				request.getRequestDispatcher("inde.html").forward(request,response);
			    
			//request.getRequestDispatcher("ChartS").forward(request,response);
			}else{
				request.setAttribute("url", "index.html");
		     request.getRequestDispatcher("index.html").forward(request,response);
		    
		    
			}
			//http://localhost:8088/Clothingsales/YgS?option=freesession
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
		Employee employee = (Employee)conn.
		getOBJById("select * from employee where e_name = '"+name+"'",
				new Employee());
		 other = employee.getE_power();
		 request.getSession().setAttribute("other", other);
		
		if(employee!=null){
		 out.println(1);
		}else{
			out.println(0);
		}
	}
	public void login(PrintWriter out,HttpServletRequest request){
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		System.out.println(name+"密码"+pwd);
		Employee employee = (Employee)conn.
		getOBJById("select * from employee where e_name = '"+name+"'",
				new Employee());
		
		 other = employee.getE_power();

		
		if(employee!=null){
			if(pwd.equals(employee.getE_pwd())){
			      HttpSession session=request.getSession();
			      session.setAttribute("name",name);
			      session.setAttribute("other",other);
			      session.setAttribute("employee",employee);
				out.println(0);//登陆成功
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
