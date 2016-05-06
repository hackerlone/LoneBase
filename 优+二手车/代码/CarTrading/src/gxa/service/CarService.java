package gxa.service;

import java.util.List;

import gxa.dao.CarDaoI;
import gxa.entity.Car;
import gxa.page.PageInfo;

public class CarService implements CarServiceI {
	private CarDaoI CarDaoI;

	public CarDaoI getCarDaoI() {
		return CarDaoI;
	}

	public void setCarDaoI(CarDaoI CarDaoI) {
		this.CarDaoI = CarDaoI;
	}
	public  List<Car> getAllCar(PageInfo pageInfo) throws Exception{
		 return CarDaoI.getPage("From Car", pageInfo);
	}

}
