package com.Campus.dao;

import java.util.List;

import com.Campus.entity.Job;
import com.Campus.entity.Jz;
import com.Campus.entity.Student;
import com.Campus.entity.Vita;

public interface JzDaoI extends BaseDaoI{
	public void sendVita(Jz jz) throws Exception;
	public Job getJobById(int id) throws Exception;
	public Vita getVitaById(int zid) throws Exception;
	public List secjobforvita(int zid) throws Exception;
	public List secvitaforjob(int jid) throws Exception;
}
