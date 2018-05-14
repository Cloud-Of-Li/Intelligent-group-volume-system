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


	@Override
	public void inputCourse(String coursename, String coursemajorid) {
		// TODO Auto-generated method stub
		String sql = "insert into course(coursename, majorid)  values('" + coursename + "'," + coursemajorid + ")";
		System.out.println(sql);
		Connection conn = DB.getConn();
		Statement stmt = DB.createStatement(conn);
		DB.executeUpdate(conn, sql);
		DB.close(stmt);
		DB.close(conn);
	}


	@Override
	public void deleteByid(int courseid) {
		// TODO Auto-generated method stub
		String sql1 = "delete from t4c where courseid = " + courseid;
		String sql = "delete from course where courseid = " + courseid;		
		Connection conn = DB.getConn();
		Statement stmt = DB.createStatement(conn);
		DB.executeUpdate(conn, sql1);
		DB.executeUpdate(conn, sql);
		DB.close(stmt);
		DB.close(conn);
	}


	@Override
	public void addT4C(String coursename, String coursetecherid) {
		// TODO Auto-generated method stub
		String[] teacherStr = coursetecherid.split("_");
		Course course = findCourseByName(coursename);
		String sql = "";
		Connection conn = DB.getConn();
		Statement stmt = DB.createStatement(conn);
		int[] courseTeacherNum  = new int[teacherStr.length]; 
		//初始化教师数组
		for(int i =0; i < courseTeacherNum.length; i++) {
			courseTeacherNum[i] =Integer.parseInt(teacherStr[i]); 
		}
		
		for(int i =0; i < courseTeacherNum.length; i++) {
			sql =  "insert into T4c(teacherid,courseid) values(" + courseTeacherNum[i] + "," + course.getCourseId() + ")";
			System.out.println(sql);
			DB.executeUpdate(conn, sql);
		}
		DB.close(stmt);
		DB.close(conn);
	}


	@Override
	public void updateCourse(int courseid, String coursename, int coursemajorid) {
		// TODO Auto-generated method stub
		String sql = "update course set coursename = '" + coursename + "', " + "majorid = " + coursemajorid + " where courseid= " + courseid;
		System.out.println(sql);
		Connection conn = DB.getConn();
		Statement stmt = DB.createStatement(conn);
		DB.executeUpdate(conn, sql);
		DB.close(stmt);
		DB.close(conn);
	}


	@Override
	public void updateT4C(int courseid, String coursetecherid) {
		// TODO Auto-generated method stub
		String sql = "delete from t4c where courseid = " + courseid;
		Connection conn = DB.getConn();
		Statement stmt = DB.createStatement(conn);
		DB.executeUpdate(conn, sql);
		String[] teacherstr = coursetecherid.split("_");
		int[] teacherNums  = new int[teacherstr.length]; 
		for(int i =0; i < teacherNums.length; i++) {
			teacherNums[i] =Integer.parseInt(teacherstr[i]); 
		}
		for(int i =0; i < teacherNums.length; i++) {
			sql =  "insert into T4c(teacherid,courseid) values(" + teacherNums[i] + "," + courseid + ")";
			System.out.println(sql);
			DB.executeUpdate(conn, sql);
		}
		DB.close(stmt);
		DB.close(conn);
	}
	
	
	
}


























