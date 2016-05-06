package gxa.dao;

import gxa.entity.CarType;

import java.util.List;

public interface CarTypeDaoI extends BaseDaoI {
	public List<CarType> getAllCarType() throws Exception;
}
