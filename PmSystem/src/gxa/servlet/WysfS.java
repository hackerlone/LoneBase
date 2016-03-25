package gxa.servlet;

import gxa.db.Wysf;
import gxa.service.WysfService;
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

public class WysfS extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	PageInfo pageinfo;
	WysfService wysfService;
	public WysfS() {
		super();
		wysfService = new WysfService();
		pageinfo = new PageInfo();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	
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
			List wysfs = wysfService.getAllYz(pageinfo);
			//String yzs1 = new 
			request.setAttribute("pageinfo",pageinfo);
			request.setAttribute("wysfs",wysfs);
			
			request.getRequestDispatcher("wysf/show.jsp").
			forward(request, response);
			}else if(option.equals("deleteById")){
				String id = request.getParameter("id");
				String msg = wysfService.deleteById(id);
				request.setAttribute("msg", msg);
				request.setAttribute("url","WysfS?option=getByPage" );
				request.getRequestDispatcher("msg.jsp").forward(request, response);
			
			}else if(option.equals("add")){
				//外键
				List yzs = wysfService.getwysf();
				request.setAttribute("yzs", yzs);
				
				 String shid= wysfService.getNewById();
		            request.setAttribute("shid",shid );
				request.getRequestDispatcher("wysf/add.jsp").forward(request, response);
				
			}else if(option.equals("UpdateById")){
			    String id=request.getParameter("id");
			    Wysf wysf=wysfService.getWysfById(id);
			    if(wysf==null){
			    	request.setAttribute("msg", "数据操作有误");
					request.setAttribute("url","WysfS?option=getByPage" );
					request.getRequestDispatcher("msg.jsp").forward(request,response);
					 
			    }else{
			    	List yzs = wysfService.getwysf();
					request.setAttribute("yzs", yzs);
			    request.setAttribute("wysf",wysf); 
			    request.getRequestDispatcher("wysf/update.jsp").forward(request,response);
			    }
			    }
	    else if(option.equals("processUpdate")){
	    	Map map = new  HashMap(request.getParameterMap());
	    	
	    	//单独处理日期
			String sh_time = request.getParameter("sh_time");
			//格式化日期
			if(sh_time.length()<=11){
				String dfstr= sh_time+" 00:00:00";
//				System.out.println(dfstr.length());
				map.put("o_rzsj",dfstr);
				}else{
					map.put("o_rzsj",sh_time);
				}
			//DateFormat df = new SimpleDateFormat("yyyy-MM-DD");
	    	Wysf wysf = new Wysf();
			try {
				BeanUtils.populate(wysf, map);
				String msg = wysfService.update(wysf);
				request.setAttribute("msg", msg);
				request.setAttribute("url","WysfS?option=getByPage" );
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
			}else if(option.equals("processAdd")){
				Map map = new  HashMap(request.getParameterMap());//获取表单提交的全部参数
			    
				
				//单独处理日期
				String sh_time = request.getParameter("sh_time");
				//格式化日期
				//DateFormat df = new SimpleDateFormat("yyyy-MM-DD");
				String dfstr= sh_time+" 00:00:00";		    
				map.put("sh_time",dfstr);
				
				Wysf wysf = new Wysf();
				try {
					BeanUtils.populate(wysf, map);
					String msg = wysfService.add(wysf);
					request.setAttribute("msg", msg);
					request.setAttribute("url","WysfS?option=getByPage" );
					request.getRequestDispatcher("msg.jsp").forward(request, response);
				
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

	
	public void init() throws ServletException {
		// Put your code here
	}

}
