package com.cloud.zj.service;

import java.sql.Connection;
import java.sql.Statement;

import com.cloud.zj.dao.RegisterDao;
import com.cloud.zj.db.DB;

public class RegisterDaoImp implements RegisterDao {

	@Override
	public void insertUser(String name, String number, String password, String sex) {
		// TODO Auto-generated method stub
				String sql = "insert into teacher(teachername, teacherPassword, teacherphone, teacherSex)"
						+ "values ('" + name + "', '" + password + "', '" + number + "', '" + sex + "')" ;
				Connection conn = DB.getConn();
				Statement stmt = DB.createStatement(conn);
				DB.executeUpdate(conn, sql);
				DB.close(stmt);
				DB.close(conn);
	}
	
}
