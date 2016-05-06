package com.Campus.controller;

import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;

import com.Campus.entity.Job;
import com.Campus.service.JobServiceI;
import com.opensymphony.xwork2.ActionSupport;



public class UtilsAction extends ActionSupport {
	private JobServiceI jobServiceI;
	
	public JobServiceI getJobServiceI() {
		return jobServiceI;
	}

	public void setJobServiceI(JobServiceI jobServiceI) {
		this.jobServiceI = jobServiceI;
	}
	public String selcJname() throws Exception{
		StringBuffer hql1 = new StringBuffer();
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();		
		response.setContentType("text/html;charset=utf-8");
		String txt = request.getParameter("txt");
		if (txt!=null&&!txt.equals("")) {
			hql1.append("select distinct j.z_name  from Job j " +
					"Where 1=1 and  j.z_name like '%"+txt+"%' order by j.z_name asc;");
			Iterator its = jobServiceI.selcJname(hql1.toString());
//			System.out.println(its.next());
			StringBuffer make = new StringBuffer();
			make.append("[");
			while(its.hasNext()){
				//Object [] o = (((Object [])its.next()));
				make.append("{\"name\":");
				make.append("\""+its.next()+"\"");
				make.append("}");
				if(its.hasNext()){
				make.append(",");
				}
			}				
			make.append("]");
			System.out.println(make);			
			PrintWriter out = response.getWriter();
			out.print(make);
			out.flush();
		}
		return null;
	}
	public String selcAllJob() throws Exception {
		StringBuffer hql = new StringBuffer();
		hql.append("select * From Job j Where 1=1 ");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();		
		response.setContentType("text/html;charset=utf-8");
		String txt = request.getParameter("txt");
		String xz = request.getParameter("xz");
		String yx = request.getParameter("yx");
		String gm = request.getParameter("gm");
		String xl = request.getParameter("xl");
		
		if (txt!=null&&!txt.equals("")) {
			hql.append(" And  j.z_name like '%"+
						txt+"%'");
		}
		
		// 企业性质
		if (!xz.equals("")&&xz!=null) {
			hql.append(" And j.q_id in (select q_id from enterprise where  q_xingzhi='"
							+ xz + "')");
		}
		
		/* 月薪范围 */
		if (!yx.equals("")&&yx!=null) {
			String[] yxarray = yx.split("-");
			Integer minyx = (Integer.valueOf(yxarray[0]));
			Integer maxyx = (Integer.valueOf(yxarray[1]));
			hql.append(" And " + minyx + "<= z_xinzi and z_xinzi <= " + maxyx
					+ "");
		}

		/* 公司规模 */		
		if (!gm.equals("")&&gm!=null) {
			String[] gmarray = gm.split("-");
			Integer mingm = (Integer.valueOf(gmarray[0]));
			Integer maxgm = (Integer.valueOf(gmarray[1]));	
			hql.append(" And j.q_id in " +
					"(select q_id from enterprise where "+mingm+"<= q_guimo and q_guimo <= "+maxgm+")");
		}
		/* 学历 */
		if (!xl.equals("")&&xl!=null) {
			hql.append(" And z_xl = '"+xl+"'");
		}	
		System.out.println(hql);
		Iterator its = jobServiceI.selcJob(hql.toString());
		StringBuffer make = new StringBuffer();
		make.append("[");
		while(its.hasNext()){
			Object [] o = (((Object [])its.next()));
			make.append("{\"id\":");
			make.append("\""+o[0]+"\"");
			make.append(",\"qid\":");
			make.append("\""+o[1]+"\"");
			make.append(",\"name\":");
			make.append("\""+o[2]+"\"");
			make.append(",\"data\":");
			make.append("\""+o[3]+"\"");
			make.append(",\"area\":");
			make.append("\""+o[4]+"\"");
			make.append(",\"renshu\":");
			make.append("\""+o[5]+"\"");
			make.append(",\"zhineng\":");
			make.append("\""+o[6]+"\"");
			make.append(",\"miaoshu\":");
			make.append("\""+o[7]+"\"");
			make.append(",\"xinzi\":");
			make.append("\""+o[8]+"\"");
			make.append(",\"xl\":");
			make.append("\""+o[9]+"\"");
			make.append("}");
			if(its.hasNext()){
			make.append(",");
			}
		}	
		
		make.append("]");
		System.out.println(make);
		PrintWriter out = response.getWriter();
//		response.setCharacterEncoding("UTF-8");
		out.print(make);
		out.flush();
//		out.close();
		return null;
	}

}
