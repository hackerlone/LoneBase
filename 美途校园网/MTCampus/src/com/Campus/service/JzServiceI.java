package com.Campus.service;

import java.util.List;

import com.Campus.entity.Job;
import com.Campus.entity.Jz;
import com.Campus.entity.Student;
import com.Campus.entity.Vita;
import com.Campus.page.PageInfo;

public interface JzServiceI {
	
	public void sendVita(Jz jz) throws Exception;
	public Job getJobById(int id)throws Exception;
	public Vita getVitaById(int id) throws Exception;
	public List secjobforvita(int zid) throws Exception;
	public List secvitaforjob(int jid) throws Exception;
}
