package com.cloud.zj.service;

import com.cloud.zj.dao.RegisterDao;

public class RegisterService {

	private RegisterDao registerDao;
	
	public RegisterService() {
		registerDao = new RegisterDaoImp();
	}

	public void registeUser(String name, String number, String password, String sex) {
		this.registerDao.insertUser(name, number, password, sex);
	}
	
}
