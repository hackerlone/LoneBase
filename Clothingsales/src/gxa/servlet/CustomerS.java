package gxa.servlet;



import gxa.db.BarAndPie;
import gxa.db.Cloting;
import gxa.db.Customer;
import gxa.db.Employee;
import gxa.service.ChartService;
import gxa.service.CustomerService;
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

import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import com.sun.org.apache.commons.beanutils.BeanUtils;

public class CustomerS extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	PageInfo pageinfo;
	CustomerService customerService;
	ChartService chartService;
	public CustomerS() {
		super();
		 customerService = new CustomerService();
		 pageinfo = new PageInfo();
		 chartService = new ChartService();
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

		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		//获取分页标签提交的相关信息，包含每页记录数，和当前页的开始编号
		String firstResult = request.getParameter("offset");
		String maxResults = request.getParameter("pageSize");
		String option=request.getParameter("option");
		//将获得的开始编号保存到pageinfo中
		if(firstResult!=null){
		 pageinfo.setFirstResult(firstResult);
		}if(maxResults!=null){
		 pageinfo.setMaxResults(maxResults);
		}else{
			pageinfo.setMaxResults(pageinfo.DEFAULT_PAGE_SIZE);
		}
		if(option.equals("getByPage")){
		List customerS = customerService.getAllcustomer(pageinfo);
		//System.out.println(pageinfo.getItemCount());
		request.setAttribute("customers",customerS);
		request.setAttribute("pageinfo", pageinfo);
		request.getRequestDispatcher("customer/showall.jsp").
		forward(request, response);
		}else if(option.equals("deleteById")){
			String id = request.getParameter("id");
			String msg = customerService.deleteById(id);
			request.setAttribute("msg", msg);
			request.setAttribute("url","CustomerS?option=getByPage" );
			request.getRequestDispatcher("msg.jsp").forward(request, response);
		}else if(option.equals("add")){
			request.getRequestDispatcher("customer/add.jsp").forward(request, response);
			
		}else if(option.equals("processAdd")){
			Map map = new  HashMap(request.getParameterMap());//获取表单提交的全部参数
		    
			
			Customer customer = new Customer();
			try {
				BeanUtils.populate(customer, map);
				String msg = customerService.add(customer);
				request.setAttribute("msg", msg);
				request.setAttribute("url", "CustomerS?option=getByPage");
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
		

		else if (option.equals("alterById")) {
			String id = request.getParameter("id");
			Customer customer = customerService.getCustomerById(id);
			if (customer == null) {
				request.setAttribute("msg", "数据操作有误");
				request.setAttribute("url", "CustomerS?option=getByPage");
				request.getRequestDispatcher("msg.jsp").forward(request,
						response);

			} else {
				
				request.setAttribute("customer", customer);
				request.getRequestDispatcher("customer/alter.jsp").forward(
						request, response);
			}
		} else if (option.equals("processupdate")) {
			Map map = new HashMap(request.getParameterMap());
			
			
			//单独处理日期
			//String o_rzsj = request.getParameter("o_rzsj");
			//格式化日期
			//DateFormat df = new SimpleDateFormat("yyyy-MM-DD");
			//String dfstr= o_rzsj+" 00:00:00";		    
			//map.put("o_rzsj",dfstr);
			
			Customer customer= new Customer();
			try {
				BeanUtils.populate(customer, map);
				String msg = customerService.update(customer);
				request.setAttribute("msg", msg);
				request.setAttribute("url","CustomerS?option=getByPage" );
				request.getRequestDispatcher("msg.jsp").forward(request, response);
			
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if (option.equals("showchart")) {
			Map map = new HashMap(request.getParameterMap());// 获取表单提交的全部参数

			Customer customer= new Customer();
			try {
				BeanUtils.populate(customer, map);
			} catch (Exception e) {
				e.printStackTrace();
			}
			String type=request.getParameter("type");
			request.setAttribute("type", type);
			if(type.equals("bar")){
			List list = customerService.getBarAndPie(customer);
			DefaultCategoryDataset dcd = new DefaultCategoryDataset();
			for (int i = 0; i < list.size(); i++) {
				BarAndPie bp = (BarAndPie) list.get(i);
				dcd.addValue(bp.getNo(), "", bp.getItem());
			}
			
			request.setAttribute("dcd", dcd);
			}else if(type.equals("pie")){
				
				
				List list = customerService.getBarAndPie(customer);
				
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
			request.setAttribute("chartname", "月份购买记录");
			request.setAttribute("itemname", "月份");
			request.setAttribute("itemval", "购买数量");
			
			//设置图片名称，既不能轻易重复，也不能一直声称新图片，而是有规律的覆盖
			String imgname = this.getClass().getName()+"_"+ customer.getK_id();
			request.setAttribute("imgname", imgname);
			request.getRequestDispatcher("ChartS").forward(request, response);
		}
		
		else if (option.equals("initInfo")) {
			Customer customer = (Customer)request.getSession().getAttribute("customer");

			String type = "bar";
			request.setAttribute("type", type);
			// 图表相应的标题图示
			request.setAttribute("chartname", "月购买记录");
			request.setAttribute("itemname", "月份");
			request.setAttribute("itemval", "购买数量");
			
			List listbar = customerService.getBarAndPie(customer);
			DefaultCategoryDataset dcd = new DefaultCategoryDataset();
			for (int i = 0; i < listbar.size(); i++) {
				BarAndPie bp = (BarAndPie) listbar.get(i);
				dcd.addValue(bp.getNo(), "", bp.getItem());
			}
			request.setAttribute("dcd", dcd);
			
			chartService.processImg(request);
			
			type = "pie";
			request.setAttribute("type", type);
			List listpie = customerService.getBarAndPie(customer);

			DefaultPieDataset dpd = new DefaultPieDataset();

			for (int i = 0; i < listpie.size(); i++) {
				BarAndPie bp = (BarAndPie) listpie.get(i);
				dpd.setValue(bp.getItem(), bp.getNo());
			}
			request.setAttribute("dpd", dpd);

			// 图表相应的标题图示
			request.setAttribute("chartname", "月份销售记录");
			request.setAttribute("itemname", "月份");
			request.setAttribute("itemval", "销售数量");

			// 设置图片名称，既不能轻易重复，也不能一直声称新图片，而是有规律的覆盖
			String imgname = this.getClass().getName() + "_"
					+ customer.getK_id();
			request.setAttribute("imgname", imgname);
			chartService.processImg(request);
			List employees = customerService.getBarAndPie(customer);
			request.setAttribute("customer", customer);
			request.getRequestDispatcher("krindex.jsp").forward(request,
					response);
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
