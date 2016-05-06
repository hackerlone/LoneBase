package gxa.dao;

import gxa.entity.Car;

import java.util.List;

public interface CarDaoI extends BaseDaoI {
	public List<Car> getAllCar() throws Exception;
}
