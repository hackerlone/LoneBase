package com.Campus.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.Campus.entity.Model;
import com.Campus.page.PageInfo;
import com.Campus.service.ModelServiceI;
import com.opensymphony.xwork2.ActionSupport;

public class ModelAction extends ActionSupport {
	private Model Model;
	private ModelServiceI ModelServiceI;
	PageInfo pageInfo;

	public Model getModel() {
		return Model;
	}

	public void setModel(Model model) {
		Model = model;
	}

	public ModelServiceI getModelServiceI() {
		return ModelServiceI;
	}

	public void setModelServiceI(ModelServiceI modelServiceI) {
		ModelServiceI = modelServiceI;
	}

	public PageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}

	public String getAllModel() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String offset = request.getParameter("offset");
		System.out.println("11");
		if (offset == null) {
			offset = "0";

		}
		pageInfo.setFirstResult(offset);
		List<Model> models = ModelServiceI.getAllModel(pageInfo);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("models", models);
		return "getAllmo";

	}

}
