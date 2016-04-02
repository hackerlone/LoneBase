package com.dating.servlet;

import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.dating.entity.Agreement;
import com.dating.entity.Yu;
import com.dating.service.AgreementService;
import com.dating.service.YuService;
import com.dating.service.impl.AgreementServiceImpl;
import com.dating.service.impl.YuServiceImpl;

public class AgreementServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	AgreementService agreementService;
	YuService yuService;
	public AgreementServlet() {
		super();
		agreementService = new AgreementServiceImpl();
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
		if(option.equals("findAll")){
			List<Agreement> ags = agreementService.findAll();
			for (Agreement agreement : ags) {
				agreement.setYYhsj(agreement.getYYhsj().substring(0, 10));
			}	
			JSONArray argArray = JSONArray.fromObject(ags);
			System.out.println(argArray);
			out.print(argArray);
			
		}
		if(option.equals("findById")){
			String yid = request.getParameter("yid");
			Agreement ags = agreementService.findById(yid);
			ags.setYYhsj(ags.getYYhsj().substring(0, 10));
			JSONArray argArray = JSONArray.fromObject(ags);
			System.out.println(argArray);
			request.setAttribute("agree", ags);
			request.getRequestDispatcher("sys/Node/edit.jsp").forward(request, response);
			out.print(argArray);
			
		}
		
		if(option.equals("findByName")){
			String name = request.getParameter("name");
			System.out.println(name);
			List<Agreement> argee = agreementService.findByName(name);
			
			JSONArray argeeArray = JSONArray.fromObject(argee);
			System.out.println(argeeArray);
			out.print(argeeArray);
		}
		if(option.equals("findByTag")){
			String name = request.getParameter("name");
			System.out.println(name);
			List<Agreement> argee = agreementService.findByTag(name);
			
			JSONArray argeeArray = JSONArray.fromObject(argee);
			System.out.println(argeeArray);
			out.print(argeeArray);
		}
		if(option.equals("findByCreate")){
			String y_id = request.getParameter("y_id");
			Agreement argee = agreementService.findByCreate(y_id);
			JSONArray argeeArray = JSONArray.fromObject(argee);
			System.out.println("00"+argeeArray);
			out.print(argeeArray);
		}
		
		
		if(option.equals("update")){
			String yid = request.getParameter("agreeid");
			String agreename = request.getParameter("agreename");
			String agreems = request.getParameter("agreems");		
			String fs = request.getParameter("fs");
			String age = request.getParameter("age");
			String area = request.getParameter("area");
			String bz = request.getParameter("bz");
			
			Agreement agreement = new Agreement();
			agreement.setYId(Integer.valueOf(yid));
			agreement.setYName(agreename);
			agreement.setYMs(agreems);
			agreement.setYFs(fs);
			agreement.setYYhsj(age);
			agreement.setYArea(area);
			agreement.setYBz(bz);
			agreementService.update(agreement);
			out.println("<SCRIPT LANGUAGE=javascript>");
			out.println("parent.location.reload()");
			out.println("</script>");
		}
		
		if(option.equals("save")){
//			SELECT LAST_INSERT_ID() 
			Agreement ags = new Agreement();
			ags.setYName(request.getParameter("y_name"));
			ags.setYMs(request.getParameter("y_ms"));
			ags.setYFs(request.getParameter("y_fs"));
			ags.setYYhsj(request.getParameter("y_yhsj"));
			ags.setYArea(request.getParameter("y_area"));
			ags.setYBz(request.getParameter("y_bz"));
			String yuid = agreementService.saveAgree(ags);
			out.print(yuid);
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
