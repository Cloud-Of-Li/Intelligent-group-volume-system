package com.cloud.zj.service;


import java.util.List;

import com.cloud.zj.dao.PaperDao;
import com.cloud.zj.dao.imp.PaperDaoImp;
import com.cloud.zj.generation.Paper;

public class PaperService {
	
	private PaperDao paperDao;
	

	public PaperService() {
		// TODO Auto-generated constructor stub
		super();
		paperDao = new PaperDaoImp();
	}


	public Paper getPaperByPaperName(String paperName) {
		// TODO Auto-generated method stub
		return this.paperDao.findPaperByPaperName(paperName);
	}


	public List<Paper> getAllPaper() {
		// TODO Auto-generated method stub
		return this.paperDao.findAllpapers();
	}
	
}
