package com.cloud.zj.dao.imp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cloud.zj.dao.TeacherDao;
import com.cloud.zj.db.DB;
import com.cloud.zj.entity.Teacher;

public class TeacherDaoImp extends BaseDaoImp<Teacher> implements TeacherDao {

	@Override
	public Teacher findTeacherByTname(String teacherName) {
		// TODO Auto-generated method stub
		String sql = "select * from teacher where teacherName = '" + teacherName + "'";
		Connection conn = DB.getConn();
		Statement stmt = DB.createStatement(conn);
		ResultSet rs = DB.executeQuery(stmt, sql);
		Teacher teacher = null;
		try {
			while (rs.next()) {
				teacher = new Teacher();
				teacher.setTeacherId(rs.getInt("teacherid"));
				teacher.setTeacherName(rs.getString("teachername"));
				teacher.setTeacherPassword(rs.getString("teacherpassword"));
				teacher.setTeacherSex(rs.getString("teachersex"));
				teacher.setTeacherPhone(rs.getString("teacherphone"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DB.close(rs);
		DB.close(stmt);
		DB.close(conn);

		return teacher;
	}
}
