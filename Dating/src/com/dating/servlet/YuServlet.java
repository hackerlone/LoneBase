package com.dating.servlet;

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
import net.sf.json.JSONObject;

import com.dating.entity.Yu;
import com.dating.service.UserService;
import com.dating.service.YuService;
import com.dating.service.impl.YuServiceImpl;

public class YuServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	YuService yuService;

	public YuServlet() {
		super();
		yuService = new YuServiceImpl();
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
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String option = request.getParameter("option");
		if (option.equals("getUId")) {
			String yuid = request.getParameter("yuid");
			List<Yu> yus = yuService.findById1(yuid);
			for (Yu yu : yus) {
				yu.setYuData(yu.getYuData().substring(0, 10));
				yu.setYuEnddata(yu.getYuEnddata().substring(0,10));
			}
			JSONArray yuss = JSONArray.fromObject(yus);
			System.out.println(yuss);
			out.print(yuss);
		}
		
		if (option.equals("getYUId")) {
			String y_id = request.getParameter("y_id");
			List<Yu> yus = yuService.findById8(y_id);
			for (Yu yu : yus) {
				yu.setYuData(yu.getYuData().substring(0, 10));
				yu.setYuEnddata(yu.getYuEnddata().substring(0,10));
			}
			JSONArray yuss = JSONArray.fromObject(yus);
			System.out.println(yuss);
			out.print(yuss);
		}
		
		if (option.equals("getYUId1")) {
			String y_id = request.getParameter("y_id");
			List<Yu> yus = yuService.findById9(y_id);
			for (Yu yu : yus) {
				yu.setYuData(yu.getYuData().substring(0, 10));
				yu.setYuEnddata(yu.getYuEnddata().substring(0,10));
			}
			JSONArray yuss = JSONArray.fromObject(yus);
			System.out.println(yuss);
			out.print(yuss);
		}
		
		if (option.equals("save")) {
			Yu yu = new Yu();
			String y_id = request.getParameter("y_id");
			String u_id = request.getParameter("u_id");
			String yu_data = request.getParameter("yu_data");
			String yu_enddata = request.getParameter("yu_enddata");
			String yu_id = request.getParameter("yu_id");
			yuService.save(yu_id, y_id, u_id, yu_data, yu_enddata);
			out.println("<SCRIPT LANGUAGE=javascript>");
			out.println("alert('创建成功')");
			out.println("window.location.href='javascript:history.go(-1)'");
			out.println("</script>");
		}
		if (option.equals("join")) {
			String yu_id = request.getParameter("yu_id");
			String y_id = request.getParameter("y_id");
			String u_id = request.getParameter("u_id");
			String yuData = "";
			String yuEnddata = "";
			List<Yu> yus = yuService.findById1(yu_id);
			for (Yu yu : yus) {
				yuData = yu.getYuData();
				yuEnddata = yu.getYuEnddata();
			}
			List<Yu> yuss = yuService.findById2(yu_id, y_id, u_id);
			if (yuss.size() > 0) {
				out.println("<SCRIPT LANGUAGE=javascript>");
				out.println("alert('您已经报名')");
				out.println("window.location.href='javascript:history.go(-1)'");
				out.println("</script>");
			} else {
				yuService.save(yu_id, y_id, u_id, yuData, yuEnddata);
				out.println("<SCRIPT LANGUAGE=javascript>");
				out.println("alert('报名成功！')");
				out.println("window.location.href='javascript:history.go(-1)'");
				out.println("</script>");
			}
		}

		// if(option.equals("findById")){
		// String yuid = request.getParameter("yuid");
		// List<Yu> yus = yuService.findById1(yuid);
		// for (Yu yu : yus) {
		// yu.setYuData(yu.getYuData().substring(0, 10));
		// }
		// JSONArray yuss = JSONArray.fromObject(yus);
		// System.out.println(yuss);
		// request.setAttribute("yus", yus);
		// request.getRequestDispatcher("sys/Node/edit.jsp").forward(request,
		// response);
		// out.print(yuss);
		// }
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
