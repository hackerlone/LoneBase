package gxa.servlet;
import gxa.db.BarAndPie;
import gxa.db.Yz;
import gxa.service.YzService;
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




import javax.servlet.http.HttpSession;

import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import com.sun.org.apache.commons.beanutils.BeanUtils;

public class YzS extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	PageInfo pageinfo;
	YzService yzService;
	public YzS() {
		super();
		yzService = new YzService();
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
			HttpSession sessionName=request.getSession();
			HttpSession session=request.getSession();
			String other=(String) session.getAttribute("name");
			String yzname=(String) sessionName.getAttribute("yzname");
			//System.out.println(other+"0000"+yzname);
			List yzs;
			if(other.equals("yz")){
				 yzs = yzService.getYz(yzname,pageinfo);
				 request.setAttribute("pageinfo",pageinfo);
					request.setAttribute("yzs",yzs);
					request.getRequestDispatcher("yz/showyz.jsp").
					forward(request, response);
			}else{
			 yzs = yzService.getAllYz(pageinfo);
			 request.setAttribute("pageinfo",pageinfo);
				request.setAttribute("yzs",yzs);
				request.getRequestDispatcher("yz/show.jsp").
				forward(request, response);
			}
			//String yzs1 = new 
			
			}else if(option.equals("deleteById")){
				String id = request.getParameter("id");
				String msg = yzService.deleteById(id);
				request.setAttribute("msg", msg);
				request.setAttribute("url","YzS?option=getByPage" );
				request.getRequestDispatcher("msg.jsp").forward(request, response);
			
			}else if(option.equals("add")){
				String imgsrc=request.getParameter("imgsrc");
				request.setAttribute("imgsrc",imgsrc);
				//外键
				List wgxxs = yzService.getwgxx();
				request.setAttribute("wgxxs", wgxxs);
				
				 String fid= yzService.getNewById();
		           request.setAttribute("fid",fid );
				request.getRequestDispatcher("yz/add.jsp").forward(request, response);
				
			}else if(option.equals("processAdd")){
				Map map = new  HashMap(request.getParameterMap());//获取表单提交的全部参数
			    
				
				//单独处理日期
				String o_rzsj = request.getParameter("o_rzsj");
				//格式化日期
				//DateFormat df = new SimpleDateFormat("yyyy-MM-DD");
				String dfstr= o_rzsj+" 00:00:00";		    
				map.put("o_rzsj",dfstr);
				
				Yz yz = new Yz();
				try {
					BeanUtils.populate(yz, map);
					String msg = yzService.add(yz);
					request.setAttribute("msg", msg);
					request.setAttribute("url","YzS?option=getByPage" );
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
			    Yz yz=yzService.getYzById(id);
			    if(yz==null){
			    	request.setAttribute("msg", "数据操作有误");
					request.setAttribute("url","YzS?option=getByPage" );
					request.getRequestDispatcher("msg.jsp").forward(request,response);
					 
			    }else{
			    	List wgxxs = yzService.getwgxx();
					request.setAttribute("wgxxs", wgxxs);
					request.setAttribute("yz",yz);
			    request.getRequestDispatcher("yz/update.jsp").forward(request,response);
			    }
			    }
	    else if(option.equals("processUpdate")){
	    	Map map = new  HashMap(request.getParameterMap());
	    	
	    	//单独处理日期
			String o_rzsj = request.getParameter("o_rzsj");
			//格式化日期
			//DateFormat df = new SimpleDateFormat("yyyy-MM-DD");
			if(o_rzsj.length()<=11){
				String dfstr= o_rzsj+" 00:00:00";
//				System.out.println(dfstr.length());
				map.put("o_rzsj",dfstr);
				}else{
					map.put("o_rzsj",o_rzsj);
				}
	    	Yz yz = new Yz();
			try {
				BeanUtils.populate(yz, map);
				String msg = yzService.update(yz);
				request.setAttribute("msg", msg);
				request.setAttribute("url","YzS?option=getByPage" );
				request.getRequestDispatcher("msg.jsp").forward(request, response);
			
			}catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			} else if (option.equals("showchart")) {
				Map map = new HashMap(request.getParameterMap());// 获取表单提交的全部参数

				Yz yz = new Yz();
				try {
					BeanUtils.populate(yz, map);
				} catch (Exception e) {
					e.printStackTrace();
				}
				String type=request.getParameter("type");
				request.setAttribute("type", type);
				if(type.equals("bar")){
				List list = yzService.getBarAndPie(yz);
				DefaultCategoryDataset dcd = new DefaultCategoryDataset();
				for (int i = 0; i < list.size(); i++) {
					BarAndPie bp = (BarAndPie) list.get(i);
					dcd.addValue(bp.getNo(), "", bp.getItem());
				}
				
				request.setAttribute("dcd", dcd);
				}else if(type.equals("pie")){
					
					
					List list = yzService.getBarAndPie(yz);
					
					DefaultPieDataset dpd = new DefaultPieDataset();
					System.out.println(list.size());
					for (int i = 0; i < list.size(); i++) {
						BarAndPie bp = (BarAndPie) list.get(i);
						dpd.setValue(bp.getItem(),bp.getNo());
						System.out.println(bp.getItem()+bp.getNo());
					}
					
					request.setAttribute("dpd", dpd);
					
					
					
					
				}
				// 图表相应的标题图示
				request.setAttribute("chartname", "业主缴费记录");
				request.setAttribute("itemname", "月份");
				request.setAttribute("itemval", "金额");
				
				//设置图片名称，既不能轻易重复，也不能一直声称新图片，而是有规律的覆盖
				String imgname = this.getClass().getName()+"_"+ yz.getO_id();
				request.setAttribute("imgname", imgname);
				request.getRequestDispatcher("ChartS").forward(request, response);
			}
		
		out.flush();
		out.close();
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
