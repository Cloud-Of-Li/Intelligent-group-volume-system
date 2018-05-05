package com.cloud.zj.service;

import java.util.List;

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
		return this.majorDao.getMajorByid(majorId);
	}

	public List<Major> getAllmajor() {
		// TODO Auto-generated method stub
		return this.majorDao.getMajor();
	}
	
}
