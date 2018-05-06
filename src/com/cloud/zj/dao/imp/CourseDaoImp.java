package com.cloud.zj.dao.imp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.cloud.zj.dao.CourseDao;
import com.cloud.zj.db.DB;
import com.cloud.zj.entity.Course;
import com.cloud.zj.entity.Teacher;

public class CourseDaoImp extends BaseDaoImp<Course> implements CourseDao {

	public List<Integer> getcid(int tid) {
		String sql = "select * from t4c where teacherid = " + tid;
		Connection conn = DB.getConn();
		Statement stmt = DB.createStatement(conn);
		ResultSet rs = DB.executeQuery(stmt, sql);
		List<Integer> courseidList = new ArrayList<>();
		Set<Integer> courseidSet = new HashSet<>();
		try {
			while (rs.next()) {
				if(courseidSet.add(rs.getInt("courseid"))) {
					courseidList.add(rs.getInt("courseid"));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DB.close(rs);
		DB.close(stmt);
		DB.close(conn);
		return courseidList;
	}
	
	
	@Override
	public List<Course> findCourseByTid(int tid) {
		// TODO Auto-generated method stub
		
		List<Integer> list = getcid(tid);
		List<Course> courseList = new ArrayList<>();
		Connection conn = DB.getConn();
		Statement stmt = DB.createStatement(conn);
		Course course = null;
		for (int i = 0; i < list.size(); i++) {
			String sql = "select * from course where courseid = " + list.get(i);
			ResultSet rs = DB.executeQuery(stmt, sql);
			try {
				while (rs.next()) {
					course = new Course();
					course.setCourseId(rs.getInt("courseid"));
					course.setCourseName(rs.getString("courseName"));
					course.setMajorId(rs.getInt("majorId"));
					course.setTeacherId(tid);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			courseList.add(course);
			DB.close(rs);
		}
		DB.close(stmt);
		DB.close(conn);
		return courseList;
	}


	@Override
	public Map<Integer, List<Course>> findCourseByTList(List<Teacher> teacherlist) {
		// TODO Auto-generated method stub
		Map<Integer, List<Course>> map = new HashMap<>();
		for(Teacher t : teacherlist) {
			List<Course> courselist = findCourseByTid(t.getTeacherId());
			map.put(t.getTeacherId(), courselist);
		}
		return map;

	}


	@Override
	public List<Course> findAllCourse() {
		// TODO Auto-generated method stub
		String sql = "select * from course";
		Connection conn = DB.getConn();
		Statement stmt = DB.createStatement(conn);
		ResultSet rs = DB.executeQuery(stmt, sql);
		List<Course> courseidList = new ArrayList<>();
		Set<Course> courseSet = new HashSet<>();
		try {
			while (rs.next()) {
				Course course = new Course();
				course.setCourseId(rs.getInt("courseid"));
				course.setCourseName(rs.getString("courseName"));
				course.setMajorId(rs.getInt("majorId"));
				if(courseSet.add(course)) {
					courseidList.add(course);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DB.close(rs);
		DB.close(stmt);
		DB.close(conn);
		return courseidList;
	}


	@Override
	public Course findCourseByName(String coursestr) {
		String sql = "select * from course where coursename = '" + coursestr +"'";
		Connection conn = DB.getConn();
		Statement stmt = DB.createStatement(conn);
		ResultSet rs = DB.executeQuery(stmt, sql);
		Course course = null;
		try {
			while (rs.next()) {
				course = new Course();
				course.setCourseId(rs.getInt("courseid"));
				course.setCourseName(rs.getString("courseName"));
				course.setMajorId(rs.getInt("majorId"));
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


	@Override
	public Course getCourseById(int courseId) {
		// TODO Auto-generated method stub
		String sql = "select * from course where courseid = " + courseId;
		Connection conn = DB.getConn();
		Statement stmt = DB.createStatement(conn);
		ResultSet rs = DB.executeQuery(stmt, sql);
		Course course = null;
		try {
			while (rs.next()) {
				course = new Course();
				course.setCourseId(rs.getInt("courseid"));
				course.setCourseName(rs.getString("courseName"));
				course.setMajorId(rs.getInt("majorId"));
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


























