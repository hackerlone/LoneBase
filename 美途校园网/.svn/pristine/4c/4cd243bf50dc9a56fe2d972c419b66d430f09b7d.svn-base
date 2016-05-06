package com.Campus.service;

import java.util.List;

import com.Campus.dao.VitaDaoI;
import com.Campus.entity.Student;
import com.Campus.entity.Vita;
import com.Campus.page.PageInfo;



public class VitaService implements VitaServiceI {
	private VitaDaoI vitaDaoI;

	public VitaDaoI getVitaDaoI() {
		return vitaDaoI;
	}

	public void setVitaDaoI(VitaDaoI vitaDaoI) {
		this.vitaDaoI = vitaDaoI;
	}

	public  List<Vita> getAllVita(PageInfo pageInfo)throws Exception{
		 return vitaDaoI.getPage("From Vita", pageInfo);
	 }
	
	 public Vita getVitaById(int id)throws Exception{
		  return vitaDaoI.getVitaById(id);
	  }
	 public void update(Vita vita) throws Exception{
		 vitaDaoI.update(vita);
	 }
	 public List getVitaMaxId() throws Exception {
		 return vitaDaoI.getVitaMaxId();
	 }
	 public void addVita(Vita vita) throws Exception{
		 vitaDaoI.addVita(vita);
	 }
	 public Vita deleteVita(int id) throws Exception{
		return vitaDaoI.deleteVita(id);
	 }
	 public void delete(Vita vita) throws Exception{
		 vitaDaoI.delete(vita);
	 }
}
