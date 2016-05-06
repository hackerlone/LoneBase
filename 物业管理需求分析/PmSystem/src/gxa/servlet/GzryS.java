package gxa.servlet;
	/*
	 * 物管servlet 用于检索物管信息
	 * 
	 * */

import gxa.db.Gzry;
import gxa.service.GzryService;
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

public class GzryS extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	GzryService gzryService;
	PageInfo pageinfo;
	public GzryS() {
		super();
		gzryService = new GzryService();
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
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();	
		
		//获取分页标签提交的相关信息,包含每页记录数，当前页的开始编号
		String firstResult = request.getParameter("offset");
		String maxResults = request.getParameter("pageSize");
		String option = request.getParameter("option");
		
		//将获得的开始编号保存
		if(firstResult!=null){
		pageinfo.setFirstResult(firstResult);
		}if(maxResults!=null){
		pageinfo.setMaxResults(maxResults);
		}else{
			pageinfo.setMaxResults(PageInfo.DEFAULT_PAGE_SIZE);
		}
		
		if(option.equals("getByPage")){
			List gzrys =gzryService.getAllGzry(pageinfo);
			//String yzs1 = new 
			request.setAttribute("pageinfo",pageinfo);
			request.setAttribute("gzrys",gzrys);
			
			request.getRequestDispatcher("gzry/show.jsp").
			forward(request, response);
			}else if(option.equals("deleteById")){
				String id = request.getParameter("id");
				String msg = gzryService.deleteById(id);
				request.setAttribute("msg", msg);
				request.setAttribute("url","GzryS?option=getByPage" );
				request.getRequestDispatcher("msg.jsp").forward(request, response);
			
			}else if(option.equals("add")){
				//外键
				List wgxxs =gzryService.getwgxx();
				request.setAttribute("wgxxs", wgxxs);
				String gzbianhao= gzryService.getNewById();
	            request.setAttribute("gzbianhao",gzbianhao);
				request.getRequestDispatcher("gzry/add.jsp").forward(request, response);
				
			}else if(option.equals("processAdd")){
				Map map = new  HashMap(request.getParameterMap());//获取表单提交的全部参数
			    
				
				Gzry gzry = new Gzry();
				try {
					BeanUtils.populate(gzry, map);
					String msg = gzryService.add(gzry);
					request.setAttribute("msg", msg);
					request.setAttribute("url","GzryS?option=getByPage" );
					request.getRequestDispatcher("msg.jsp").forward(request, response);
				
				}
				catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if(option.equals("UpdateById")){
			    String id=request.getParameter("id");
			    Gzry gzry=gzryService.getGzryById(id);
			    if(gzry==null){
			    	request.setAttribute("msg", "数据操作有误");
					request.setAttribute("url","GzryS?option=getByPage" );
					 request.getRequestDispatcher("msg.jsp").forward(request,response);
					 
			    }else{
			    	List wgxxs =gzryService.getwgxx();
					request.setAttribute("wgxxs", wgxxs);
			    request.setAttribute("gzry",gzry); 
			    request.getRequestDispatcher("gzry/update.jsp").forward(request,response);
			    }
			    }
	    else if(option.equals("processUpdate")){
	    	Map map = new  HashMap(request.getParameterMap());
	    	
	    	Gzry gzry = new Gzry();
			try {
				BeanUtils.populate(gzry, map);
				String msg = gzryService.update(gzry);
				request.setAttribute("msg", msg);
				request.setAttribute("url","GzryS?option=getByPage" );
				request.getRequestDispatcher("msg.jsp").forward(request, response);
			
			}catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		out.flush();
		out.close();
		}
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
