package gxa.service;

import java.util.List;

import gxa.dao.CarTypeDaoI;
import gxa.entity.CarType;
import gxa.page.PageInfo;

public class CarTypeService implements CarTypeServiceI {
	private CarTypeDaoI CarTypeDaoI;

	public CarTypeDaoI getCarTypeDaoI() {
		return CarTypeDaoI;
	}

	public void setCarTypeDaoI(CarTypeDaoI CarTypeDaoI) {
		this.CarTypeDaoI = CarTypeDaoI;
	}
	public  List<CarType> getAllCarType(PageInfo pageInfo) throws Exception{
		 return CarTypeDaoI.getPage("From CarType", pageInfo);
	}

}
