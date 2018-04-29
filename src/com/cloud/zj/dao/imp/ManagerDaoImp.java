package com.cloud.zj.dao.imp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cloud.zj.dao.ManagerDao;
import com.cloud.zj.db.DB;
import com.cloud.zj.entity.Manager;

public class ManagerDaoImp extends BaseDaoImp<Manager> implements ManagerDao {

	@Override
	public Manager findManagerByName(String managerName) {
		// TODO Auto-generated method stub
		String sql = "select * from manager where managerName = '" + managerName + "'";
		Connection conn = DB.getConn();
		Statement stmt = DB.createStatement(conn);
		ResultSet rs = DB.executeQuery(stmt, sql);
		Manager manager = null;
		try {
			while (rs.next()) {
				manager = new Manager();
				manager.setManagerId(rs.getInt("managerid"));
				manager.setManagerName(rs.getString("managerName"));
				manager.setManagerPassword(rs.getString("managerPassword"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DB.close(rs);
		DB.close(stmt);
		DB.close(conn);

		return manager;
	}

}
