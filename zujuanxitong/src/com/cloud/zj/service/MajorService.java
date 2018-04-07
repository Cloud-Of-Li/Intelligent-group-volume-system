package com.cloud.zj.service;

import com.cloud.zj.dao.MajorDao;
import com.cloud.zj.dao.imp.MajorDaoImp;
import com.cloud.zj.entity.Major;

public class MajorService {
	private MajorDao majorDao;

	public MajorService() {
		super();
		majorDao = new MajorDaoImp();
	}

	public Major getMajorById(int majorId) {
		// TODO Auto-generated method stub
		return this.majorDao.loadById(majorId);
	}
	
}
