package gxa.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import gxa.entity.CarType;
import gxa.page.PageInfo;
import gxa.service.CarTypeServiceI;

import com.opensymphony.xwork2.ActionSupport;

public class CarTypeAction extends ActionSupport {
	private CarTypeServiceI carTypeServiceI;
	private CarType carType;
	PageInfo pageInfo;
	public CarTypeServiceI getCarTypeServiceI() {
		return carTypeServiceI;
	}
	public void setCarTypeServiceI(CarTypeServiceI carTypeServiceI) {
		this.carTypeServiceI = carTypeServiceI;
	}
	public CarType getCarType() {
		return carType;
	}
	public void setCarType(CarType carType) {
		this.carType = carType;
	}
	public PageInfo getPageInfo() {
		return pageInfo;
	}
	public void setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}
	public  String getAllCarType() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		String offset = request.getParameter("offset");
		pageInfo.setFirstResult(offset);
		if(offset==null){
		pageInfo.setFirstResult("0");
		}
		List<CarType> carTypes = carTypeServiceI.getAllCarType(pageInfo);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("carTypes", carTypes);
		return "getallsuc";
	}
}
