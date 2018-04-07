package com.cloud.zj.dao.imp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cloud.zj.dao.CourseDao;
import com.cloud.zj.db.DB;
import com.cloud.zj.entity.Course;

public class CourseDaoImp extends BaseDaoImp<Course> implements CourseDao {

	@Override
	public Course findCourseByTid(int tid) {
		// TODO Auto-generated method stub
		String sql = "select * from course where teacherid = " + tid;
		Course course = null;
		Connection conn = DB.getConn();
		Statement stmt = DB.createStatement(conn);
		ResultSet rs = DB.executeQuery(stmt, sql);
		
		try {
			while (rs.next()) {
				course = new Course();
				course.setCourseId(rs.getInt("courseid"));
				course.setCourseName(rs.getString("coursename"));
				course.setMajorId(rs.getInt("majorid"));
				course.setTeacherId(tid);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DB.close(rs);
		DB.close(stmt);
		DB.close(conn);
		
		return course;
		
	}

	

}
