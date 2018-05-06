package com.cloud.zj.dao;

public interface RegisterDao {

	void insertUser(String name, String number, String password, String sex);

	String checkpsw(String teacherName, String teacherPassword, String identity, String phone);

}
