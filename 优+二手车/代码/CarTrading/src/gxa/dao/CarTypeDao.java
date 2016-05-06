package gxa.dao;

import gxa.entity.CarType;
import gxa.page.PageInfo;

import java.util.List;

public class CarTypeDao extends BaseDaoImp implements CarTypeDaoI{
	public List<CarType> getAllCarType() throws Exception{
		return this.getSession().createQuery("From cartype").list();
	
	}


}
