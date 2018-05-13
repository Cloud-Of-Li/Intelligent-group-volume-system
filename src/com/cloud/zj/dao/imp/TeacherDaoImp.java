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
				teacher.setMajorid(rs.getInt("majorid"));
				teacher.setIdentity(rs.getString("identity"));

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

	@Override
	public void deleteByid(int teacherid) {
		String sql1 = "delete from t4c where teacherid = " + teacherid;
		String sql = "delete from teacher where teacherid = " + teacherid;		
		Connection conn = DB.getConn();
		Statement stmt = DB.createStatement(conn);
		DB.executeUpdate(conn, sql1);
		DB.executeUpdate(conn, sql);
		DB.close(stmt);
		DB.close(conn);
	}

	@Override
	public void updateTeacher(String teacherid, String teachername, String teachersex, String teacherphone,
			String teachermajorid) {
		String sql = "update teacher set TeacherSex = '" + teachersex + "', " + "TeacherPhone = '" + teacherphone + "', " + "Majorid = "+ teachermajorid + " where teacherid= " + teacherid;
		System.out.println(sql);
		Connection conn = DB.getConn();
		Statement stmt = DB.createStatement(conn);
		DB.executeUpdate(conn, sql);
		DB.close(stmt);
		DB.close(conn);
		
	}

	@Override
	public void updateT4C(String teacherid, String techercourse) {
		// TODO Auto-generated method stub
		
		String sql = "delete from t4c where teacherid = " + teacherid;
		Connection conn = DB.getConn();
		Statement stmt = DB.createStatement(conn);
		DB.executeUpdate(conn, sql);
		String[] courseStr = techercourse.split("_");
		int[] teacherCourseNums  = new int[courseStr.length]; 
		for(int i =0; i < teacherCourseNums.length; i++) {
			teacherCourseNums[i] =Integer.parseInt(courseStr[i]); 
		}
		for(int i =0; i < teacherCourseNums.length; i++) {
			sql =  "insert into T4c(teacherid,courseid) values(" + teacherid + "," + teacherCourseNums[i] + ")";
			System.out.println(sql);
			DB.executeUpdate(conn, sql);
		}
		DB.close(stmt);
		DB.close(conn);
	}

	@Override
	public void updateTeacher(String teacherid, String teachername, String teachersex, String teacherphone) {
		// TODO Auto-generated method stub
		String sql = "update teacher set TeacherSex = '" + teachersex + "', " + "TeacherPhone = '" + teacherphone + "' " + " where teacherid = " + teacherid;
		System.out.println(sql);
		Connection conn = DB.getConn();
		Statement stmt = DB.createStatement(conn);
		DB.executeUpdate(conn, sql);
		DB.close(stmt);
		DB.close(conn);
	}

	@Override
	public Teacher selectByid(int teacherid) {
		// TODO Auto-generated method stub
		String sql = "select *  from teacher where teacherid = " + teacherid;
		Connection conn = DB.getConn();
		Statement stmt = DB.createStatement(conn);
		ResultSet rs = DB.executeQuery(conn, sql);
		Teacher t = null;
		try {
			while(rs.next()) {
				t = new Teacher();
				t.setMajorid(rs.getInt("majorid"));
				t.setTeacherId(teacherid);
				t.setTeacherName(rs.getString("teachername"));
				t.setTeacherPassword(rs.getString("teacherPassword"));
				t.setTeacherPhone(rs.getString("teacherPhone"));
				t.setTeacherSex(rs.getString("teacherSex"));
				t.setIdentity(rs.getString("identity"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DB.close(stmt);
		DB.close(conn);
		return t;
	}

}





























