package gxa.servlet;

/*
 * 资源servlet 用于检索业主信息
 * 张领国
 * */

import gxa.db.Zy;
import gxa.service.ZyService;
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

public class ZyS extends HttpServlet {

	ZyService zyService;
	PageInfo pageinfo;

	public ZyS() {
		super();
		pageinfo = new PageInfo();
		zyService = new ZyService();
	}

	public void destroy() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		// 获取分页标签提交的相关信息,包含每页记录数，当前页的开始编号
		String firstResult = request.getParameter("offset");
		String maxResults = request.getParameter("pageSize");
		String option = request.getParameter("option");
		// 将获得的开始编号保存
		if (firstResult != null) {
			pageinfo.setFirstResult(firstResult);
		}
		if (maxResults != null) {
			pageinfo.setMaxResults(maxResults);
		} else {
			pageinfo.setMaxResults(PageInfo.DEFAULT_PAGE_SIZE);
		}
		if (option.equals("getByPage")) {
			List zys = zyService.getAllZy(pageinfo);
			request.setAttribute("pageinfo", pageinfo);
			request.setAttribute("zys", zys);
			request.getRequestDispatcher("zy/show.jsp").forward(request,response);
		} else if (option.equals("deleteById")) {
			String id = request.getParameter("id");
			String msg = zyService.deleteById(id);
			request.setAttribute("msg", msg);
			request.setAttribute("url", "ZyS?option=getByPage");
			request.getRequestDispatcher("msg.jsp").forward(request, response);

		} else if(option.equals("add")){
			String wid= zyService.getNewById();
            request.setAttribute("wid",wid);
			request.getRequestDispatcher("zy/add.jsp").forward(request, response);
			
		}else if(option.equals("processAdd")){
			Map map = new  HashMap(request.getParameterMap());//获取表单提交的全部参数
			Zy zy = new Zy();
			try {
				BeanUtils.populate(zy, map);
				String msg = zyService.add(zy);
				request.setAttribute("msg", msg);
				request.setAttribute("url","ZyS?option=getByPage" );
				request.getRequestDispatcher("msg.jsp").forward(request, response);
			
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(option.equals("UpdateById")){
		    String id=request.getParameter("id");
		    Zy zy=zyService.getZyById(id);
		    if(zy==null){
		    	request.setAttribute("msg", "数据操作有误");
				request.setAttribute("url","ZyS?option=getByPage" );
				 request.getRequestDispatcher("msg.jsp").forward(request,response);
				 
		    }else{
		    request.setAttribute("zy",zy); 
		    request.getRequestDispatcher("zy/update.jsp").forward(request,response);
		    }
		    }
    else if(option.equals("processUpdate")){
    	Map map = new  HashMap(request.getParameterMap());
    	
    	Zy zy = new Zy();
		try {
			BeanUtils.populate(zy, map);
			String msg = zyService.update(zy);
			request.setAttribute("msg", msg);
			request.setAttribute("url","ZyS?option=getByPage" );
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

	public void init() throws ServletException {
	}

}
