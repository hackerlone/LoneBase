package gxa.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import gxa.entity.Car;
import gxa.page.PageInfo;
import gxa.service.CarServiceI;

import com.opensymphony.xwork2.ActionSupport;

public class CarAction extends ActionSupport {
	private CarServiceI carServiceI;
	private Car car;
	PageInfo pageInfo;
	public CarServiceI getCarServiceI() {
		return carServiceI;
	}
	public void setCarServiceI(CarServiceI carServiceI) {
		this.carServiceI = carServiceI;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public PageInfo getPageInfo() {
		return pageInfo;
	}
	public void setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}
	public  String getAllCar() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		String offset = request.getParameter("offset");
		pageInfo.setFirstResult(offset);
		if(offset==null){
		pageInfo.setFirstResult("0");
		}
		List<Car> cars = carServiceI.getAllCar(pageInfo);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("cars", cars);
		return "getallsuc";
	}
}
