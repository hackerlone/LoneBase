package com.dating.servlet;

import java.awt.print.Book;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.dating.entity.Books;
import com.dating.service.BooksService;
import com.dating.service.UserService;
import com.dating.service.impl.BooksServiceImpl;

public class BooksServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	BooksService booksService;
	public BooksServlet() {
		super();
		booksService = new BooksServiceImpl();
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
		if(option.equals("showmsg")){
			String tid = request.getParameter("tid");
			String uid = request.getParameter("uid");
			System.out.println("tid:"+tid+"uid:"+uid);
			List<Books> booList = booksService.findAllmsg(tid,uid);
			JSONArray json = JSONArray.fromObject(booList);
			System.out.println(json);
			out.print(json);
		}
		if(option.equals("sendmsg")){
			Books books = new Books();
			String tid = request.getParameter("tid");
			String uid = request.getParameter("uid");
			String msg = request.getParameter("msg");
			books.setTId(Integer.valueOf(tid));
			books.setUId(Integer.valueOf(uid));
			books.setUuRecord(msg);
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			books.setTuData(df.format(new Date()));
			booksService.save(books);
			out.print(1);
		}
		
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
