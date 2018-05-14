package com.cloud.zj.dao.imp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cloud.zj.dao.MajorDao;
import com.cloud.zj.db.DB;
import com.cloud.zj.entity.Major;

public class MajorDaoImp extends BaseDaoImp<Major> implements MajorDao {

	@Override
	public Major getMajorByid(int majorId) {
		// TODO Auto-generated method stub
		String sql = "select * from Major where majorid = " + majorId;
		Connection conn = DB.getConn();
		Statement stmt = DB.createStatement(conn);
		ResultSet rs = DB.executeQuery(stmt, sql);
		Major major = null;
		try {
			while (rs.next()) {
				major = new Major();
				major.setMajorId(majorId);
				major.setMajorName(rs.getString("majorname"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DB.close(rs);
		DB.close(stmt);
		DB.close(conn);
		return major;
	}

	@Override
	public void deleteMajor(int majorid) {
		// TODO Auto-generated method stub
		String sql = "delete from major where majorid = " + majorid;
		System.out.println(sql);
		Connection conn = DB.getConn();
		Statement stmt = DB.createStatement(conn);
		DB.executeUpdate(conn, sql);
		DB.close(stmt);
		DB.close(conn);
	}

	@Override
	public void insertMajor(String majorname) {
		// TODO Auto-generated method stub
		String sql = "insert into major(majorname) values('" + majorname + "')";
		Connection conn = DB.getConn();
		Statement stmt = DB.createStatement(conn);
		DB.executeUpdate(conn, sql);
		DB.close(stmt);
		DB.close(conn);
	}

	@Override
	public int selectMajorByName(String majorname) {
		// TODO Auto-generated method stub
		String sql = "select * from Major where majorname = '" + majorname + "'";
		Connection conn = DB.getConn();
		Statement stmt = DB.createStatement(conn);
		ResultSet rs = DB.executeQuery(stmt, sql);
		Major major = null;
		try {
			while (rs.next()) {
				major = new Major();
				major.setMajorId(rs.getInt("majorid"));
				major.setMajorName(rs.getString("majorname"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DB.close(rs);
		DB.close(stmt);
		DB.close(conn);
		return major.getMajorId();
	}

	@Override
	public List<Major> getMajor() {
		// TODO Auto-generated method stub
		String sql = "select * from Major";
		Connection conn = DB.getConn();
		Statement stmt = DB.createStatement(conn);
		ResultSet rs = DB.executeQuery(stmt, sql);
		List<Major> majorall = new ArrayList<>();
		try {
			while (rs.next()) {
				Major major = null;
				major = new Major();
				major.setMajorId(rs.getInt("majorid"));
				major.setMajorName(rs.getString("majorname"));
				majorall.add(major);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DB.close(rs);
		DB.close(stmt);
		DB.close(conn);
		return majorall;
	}

	@Override
	public void updateMajor(int majorid, String majorname) {
		// TODO Auto-generated method stub
		String sql = "update major set majorname = '" + majorname + "' where majorid = " + majorid;
		System.out.println(sql);
		Connection conn = DB.getConn();
		Statement stmt = DB.createStatement(conn);
		DB.executeUpdate(conn, sql);
		DB.close(stmt);
		DB.close(conn);
	}


}
