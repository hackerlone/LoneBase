package gxa.service;

import gxa.entity.CarType;
import gxa.page.PageInfo;

import java.util.List;

public interface CarTypeServiceI {
	public  List<CarType> getAllCarType(PageInfo pageInfo)throws Exception  ;
}
