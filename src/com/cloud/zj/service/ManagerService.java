package com.cloud.zj.service;

import com.cloud.zj.dao.ManagerDao;
import com.cloud.zj.dao.imp.ManagerDaoImp;
import com.cloud.zj.entity.Manager;

public class ManagerService {

	private ManagerDao managerDao;
	
	

	public ManagerService() {
		super();
		managerDao = new ManagerDaoImp();
	}



	public Manager getManagerByManagerName(String managerName) {
		// TODO Auto-generated method stub
		return this.managerDao.findManagerByName(managerName);
	}

}
