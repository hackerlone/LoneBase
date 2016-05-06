package gxa.service;

import gxa.entity.Car;
import gxa.page.PageInfo;

import java.util.List;

public interface CarServiceI {
	public  List<Car> getAllCar(PageInfo pageInfo)throws Exception  ;
}
