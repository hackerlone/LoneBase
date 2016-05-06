package com.Campus.dao;

import java.util.List;

import com.Campus.entity.Student;
import com.Campus.entity.Vita;

public interface VitaDaoI extends BaseDaoI{
	public List<Vita> getAllVita() throws Exception;
	public Vita getVitaById(int id) throws Exception;
	public void update(Vita vita) throws Exception;
	public List getVitaMaxId() throws Exception;
	public void addVita(Vita vita) throws Exception;
	public Vita deleteVita(int id) throws Exception;
	public void delete(Vita vita) throws Exception;
}
