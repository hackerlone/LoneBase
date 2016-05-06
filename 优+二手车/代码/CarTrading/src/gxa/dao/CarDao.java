package gxa.dao;

import gxa.entity.Car;

import java.util.List;

public class CarDao extends BaseDaoImp implements CarDaoI{
	public List<Car> getAllCar() throws Exception{
		return this.getSession().createQuery("From car").list();
	
	}


}
