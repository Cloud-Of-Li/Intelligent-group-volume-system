package com.cloud.zj.dao.imp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
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

	@Override
	public String checkpsw(String teacherName, String teacherPassword, String identity, String phone) {
		// TODO Auto-generated method stub
		String sql = "select * from teacher where teachername = '" + teacherName + "' and identity = '" + identity + "'";
		String sql1 = "select * from teacher where teachername = '" + teacherName + "' and identity = '" + identity + "' and " + "teacherphone = '" + phone + "'";
		String sql2 = "update teacher set teacherpassword = '" + teacherPassword + "' where teacherName = " + teacherName + "' and identity = '" + identity + "'";
		Connection conn = DB.getConn();
		Statement stmt = DB.createStatement(conn);
		ResultSet rs = DB.executeQuery(stmt, sql);
		try {
			if(!rs.next()) {
				return "id_error";
			}
			rs =  DB.executeQuery(stmt, sql1);
			if(!rs.next()) {
				return "phone_error";
			}
			DB.executeUpdate(conn, sql2);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DB.close(stmt);
		DB.close(conn);
		return "succrss";
	}
	
}



















