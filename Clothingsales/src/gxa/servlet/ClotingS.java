package gxa.servlet;

import gxa.db.Cloting;
import gxa.service.ClotingService;
import gxa.service.Supplierservice;
import gxa.web.page.PageInfo;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.commons.beanutils.BeanUtils;

public class ClotingS extends HttpServlet {

	/**
	 * Constructor of the object.
	 */

	PageInfo pageinfo;
	ClotingService clotingService;

	public ClotingS() {
		super();

		clotingService = new ClotingService();
		pageinfo = new PageInfo();
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

		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();

		// 获取分页标签提交的相关信息，包含每页记录数，和当前页的开始编号
		String firstResult = request.getParameter("offset");
		String maxResults = request.getParameter("pageSize");
		String option = request.getParameter("option");
		// 将获得的开始编号保存到pageinfo中
		if (firstResult != null) {
			pageinfo.setFirstResult(firstResult);
		}
		if (maxResults != null) {
			pageinfo.setMaxResults(maxResults);
		} else {
			pageinfo.setMaxResults(pageinfo.DEFAULT_PAGE_SIZE);
		}

		if (option.equals("getByPage")) {
			List clotings = clotingService.getAllCloting(pageinfo);
			request.setAttribute("clotings", clotings);
			request.setAttribute("pageinfo", pageinfo);
			request.getRequestDispatcher("cloting/showall.jsp").forward(
					request, response);

		} else if (option.equals("deleteById")) {
			String id = request.getParameter("id");
			String msg = clotingService.deleteById(id);
			request.setAttribute("msg", msg);
			request.setAttribute("url", "ClotingS?option=getByPage");
			request.getRequestDispatcher("msg.jsp").forward(request, response);

		} else if (option.equals("add")) {
			String imgsrc=request.getParameter("imgsrc");
			
			request.setAttribute("imgsrc",imgsrc);
			List suppiers = clotingService.getsuppliers();
			request.setAttribute("suppiers", suppiers);
            String fid= clotingService.getNewById();
            request.setAttribute("fid",fid );
			request.getRequestDispatcher("cloting/add.jsp").forward(request,
					response);
		} else if (option.equals("processAdd")) {
			Map map = new HashMap(request.getParameterMap());// 获取表单提交的全部参数
              
			Cloting cloting = new Cloting();
			try {
				
				
				BeanUtils.populate(cloting, map);
				String msg = clotingService.add(cloting);
				request.setAttribute("msg", msg);
				request.setAttribute("url", "ClotingS?option=getByPage");
				request.getRequestDispatcher("msg.jsp").forward(request,
						response);

			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// else if(option.equals("alterById")){
		// List users=request.getParameter();
		// request.getRequestDispatcher("user/alter.jsp").forward(request,
		// response);
		// }

		else if (option.equals("alterById")) {
			String id = request.getParameter("id");
			Cloting cloting = clotingService.getClotingById(id);
			if (cloting == null) {
				request.setAttribute("msg", "数据操作有误");
				request.setAttribute("url", "ClotingS?option=getByPage");
				request.getRequestDispatcher("msg.jsp").forward(request,
						response);

			} else {
				List suppiers = clotingService.getsuppliers();
				request.setAttribute("suppiers", suppiers);
				request.setAttribute("cloting", cloting);
				request.getRequestDispatcher("cloting/alter.jsp").forward(
						request, response);
			}
		} else if (option.equals("processupdate")) {
			Map map = new HashMap(request.getParameterMap());

			// 单独处理日期
			// String o_rzsj = request.getParameter("");
			// 格式化日期
			// DateFormat df = new SimpleDateFormat("yyyy-MM-DD");
			// String dfstr= o_rzsj+" 00:00:00";
			// map.put("",dfstr);

			Cloting cloting = new Cloting();
			try {
				BeanUtils.populate(cloting, map);
				String msg = clotingService.update(cloting);
				request.setAttribute("msg", msg);
				request.setAttribute("url", "ClotingS?option=getByPage");
				request.getRequestDispatcher("msg.jsp").forward(request,
						response);

			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
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
