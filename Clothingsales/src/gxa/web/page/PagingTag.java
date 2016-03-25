/*
 * Created on 2004-2-6
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package gxa.web.page;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;


/**
 * @author vikings
 *
 */
public class PagingTag extends TagSupport{

	private static final long serialVersionUID = 1L;
	
	//总页数
	private int pageSize = 0; //recordsPerPage
	private int offset=0; //beginItem
	private int totalRecords = 0;
	private String href = null;
		
	public int getPageSize()
	{
	  return this.pageSize;
	}
	public void setPageSize(int pageSize)
	{
	  this.pageSize = pageSize;
	}

	//总记录数
	public int getTotalRecords()
	{
		return this.totalRecords;
	}
	public void setTotalRecords(int totalRecords)
	{
		this.totalRecords = totalRecords;
	}

	public int getOffset() {
	  return offset;
	}
	public void setOffset(int offset) {
	  this.offset = offset;
	}

	//链接的URL地址
	public String getHref()
	{
		return this.href;
	}
	public void setHref(String href)
	{
		this.href = href;
	}
	
	public int doStartTag() throws JspException 
	{
	  return SKIP_BODY;
	}
	
	public int doEndTag() throws JspException 
	{	
		if (pageSize ==0)
          pageSize=Integer.parseInt(PageInfo.DEFAULT_PAGE_SIZE);
		if (offset ==0)
		  offset=Integer.parseInt(PageInfo.DEFAULT_LIST_OFFSET);
		
		int totalPages = 0;
		int currentPage=0;

        totalPages = totalRecords / pageSize;
		if(totalRecords==0||pageSize==0){
		  return EVAL_PAGE;
		}
		if (totalRecords % pageSize != 0) {
		  totalPages = totalPages + 1;
		}
		if (totalPages<=1)
		{
		  return EVAL_PAGE;
		}
		currentPage = (offset) / pageSize;
		currentPage = currentPage+1;
		StringBuffer navigation = new StringBuffer();
		navigation.append("[第"+currentPage+"页/共"+totalPages+"页]&nbsp;&nbsp;");
		if (currentPage<=1){
		  navigation.append("[首页]");
		  navigation.append("&nbsp;");
		  navigation.append("[上一页]");
		} else {
		  navigation.append("<a href='"+href+"&offset=0&pageSize="+pageSize+"'>[首页]</a>");
		  navigation.append("&nbsp;");
		  navigation.append("<a href='"+href+"&offset="+(offset-pageSize)+"&pageSize="+pageSize+"'>[上一页]</a>");
		}
		navigation.append("&nbsp;");
		if (currentPage>=totalPages){
		  navigation.append("[下一页]");
		  navigation.append("&nbsp;");
		  navigation.append("[尾页]");
		}else {
		  navigation.append("<a href='"+href+"&offset="+(offset+pageSize)+"&pageSize="+pageSize+"'>[下一页]</a>");
		  navigation.append("&nbsp;");
		  navigation.append("<a href='"+href+"&offset="+((totalPages-1)*pageSize)+"&pageSize="+pageSize+"'>[尾页]&nbsp;</a>");
		}
		navigation.append("&nbsp;");
		try {
			pageContext.getOut().print(navigation.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	   
	  return EVAL_PAGE;
	}
	
	public void release() 
	{		
		super.release();
		this.pageSize = 0; //recordsPerPage
		this.offset=0; //beginItem
		this.totalRecords = 0;
		this.href = null;
	}
}
