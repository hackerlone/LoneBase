package gxa.servlet;
	/*
	 * 物管servlet 用于检索物管信息
	 * 
	 * */


import gxa.db.Wgxx;
import gxa.db.Yz;
import gxa.service.WgxxService;
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

public class WgxxS extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	WgxxService wgxxService;
	PageInfo pageinfo;
	public WgxxS() {
		super();
		wgxxService = new WgxxService();
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
			List wgxxs =wgxxService.getAllWgxx(pageinfo);
			//String yzs1 = new 
			request.setAttribute("pageinfo",pageinfo);
			request.setAttribute("wgxxs",wgxxs);
			
			request.getRequestDispatcher("wgxx/show.jsp").
			forward(request, response);
			}else if(option.equals("deleteById")){
				String id = request.getParameter("id");
				String msg = wgxxService.deleteById(id);
				request.setAttribute("msg", msg);
				request.setAttribute("url","WgxxS?option=getByPage" );
				request.getRequestDispatcher("msg.jsp").forward(request, response);
			
			}else if(option.equals("add")){
				List zys = wgxxService.getzy();
				request.setAttribute("zys", zys);
				  String wid= wgxxService.getNewById();
		            request.setAttribute("wid",wid);
				request.getRequestDispatcher("wgxx/add.jsp").forward(request, response);
				
			}else if(option.equals("processAdd")){
				Map map = new  HashMap(request.getParameterMap());//获取表单提交的全部参数
				//单独处理日期
				String w_time= request.getParameter("w_time");
				//格式化日期
				//DateFormat df = new SimpleDateFormat("yyyy-MM-DD");
				if(w_time.length()<=11){
					String dfstr= w_time+" 00:00:00";
//					System.out.println(dfstr.length());
					map.put("w_time",dfstr);
					}else{
						map.put("w_time",w_time);
					}
				
				Wgxx wgxx = new Wgxx();
				try {
					BeanUtils.populate(wgxx, map);
					String msg = wgxxService.add(wgxx);
					request.setAttribute("msg", msg);
					request.setAttribute("url","WgxxS?option=getByPage" );
					request.getRequestDispatcher("msg.jsp").forward(request, response);
				
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(option.equals("UpdateById")){
			    String id=request.getParameter("id");
	
			    Wgxx wgxx=wgxxService.getWgxxById(id);
			    if(wgxx==null){
			    	request.setAttribute("msg", "数据操作有误");
					request.setAttribute("url","WgxxS?option=getByPage" );
					 request.getRequestDispatcher("msg.jsp").forward(request,response);
					 
			    }else{
			    	List zys = wgxxService.getzy();
					request.setAttribute("zys", zys);
			    request.setAttribute("wgxx",wgxx); 
			    request.getRequestDispatcher("wgxx/update.jsp").forward(request,response);
			    }
			    }
	    else if(option.equals("processUpdate")){
	    	Map map = new  HashMap(request.getParameterMap()); //获取表单提交的全部参数
	    	//单独处理日期
			String w_time= request.getParameter("w_time");
			//格式化日期
			//DateFormat df = new SimpleDateFormat("yyyy-MM-DD");
			String dfstr= w_time+" 00:00:00";		    
			map.put("w_time",dfstr);
	    	Wgxx wgxx = new Wgxx();
			try {
				BeanUtils.populate(wgxx, map);
				String msg = wgxxService.update(wgxx);
				request.setAttribute("msg", msg);
				request.setAttribute("url","WgxxS?option=getByPage" );
				request.getRequestDispatcher("msg.jsp").forward(request, response);
			
			}catch (IllegalAccessException e) {
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
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
