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

import com.cloud.zj.dao.TeacherDao;
import com.cloud.zj.db.DB;
import com.cloud.zj.entity.Course;
import com.cloud.zj.entity.Major;
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

	@Override
	public void addTeacher(String identity, String teachername, String teachersex, String teacherphone, String majorid) {
		// TODO Auto-generated method stub
		String sql = "insert into teacher(identity, teachername, teachersex, teacherphone,majorid)  values('" + identity + "','" + teachername + "','" + teachersex + "','" 
					+ teacherphone + "'," + majorid + ")";
		System.out.println(sql);
		Connection conn = DB.getConn();
		Statement stmt = DB.createStatement(conn);
		DB.executeUpdate(conn, sql);
		DB.close(stmt);
		DB.close(conn);
	}

	@Override
	public void addT4C(String identity, String teachername, String teachercourseid) {
		// TODO Auto-generated method stub
		
		Teacher teacher = findTeacherByTname(teachername);
		int teacherid = teacher.getTeacherId();
		String[] courseStr = teachercourseid.split("_");
		String sql = "";
		Connection conn = DB.getConn();
		Statement stmt = DB.createStatement(conn);
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
	public Map<Integer, List<Teacher>> findTeacherByTList(List<Course> courselist) {
		// TODO Auto-generated method stub
		Map<Integer, List<Teacher>> map = new HashMap<>();
		for(Course c : courselist) {
			List<Teacher> teacherlist = findTeacherBycourseid(c.getCourseId());
			map.put(c.getCourseId(), teacherlist);
		}
		return map;

	}

	@Override
	public Map<Integer, List<Teacher>> findTeacherByMList(List<Major> majorall) {
		// TODO Auto-generated method stub
		Map<Integer, List<Teacher>> map = new HashMap<>();
		for(Major m : majorall) {
			List<Teacher> teacherlist = findTeacherBymajorid(m.getMajorId());
			map.put(m.getMajorId(), teacherlist);
		}
		return map;
	}

	@Override
	public void updateTsMajor(int majorid, String majorteacherid) {
		// TODO Auto-generated method stub
		Connection conn = DB.getConn();
		Statement stmt = DB.createStatement(conn);
		String[] teacheridstr = majorteacherid.split("_");
		String sql = "";
		int[] teacheridNums  = new int[teacheridstr.length]; 
		for(int i = 0; i < teacheridNums.length; i++) {
			teacheridNums[i] = Integer.parseInt(teacheridstr[i]); 
		}
		for(int i =0; i < teacheridNums.length; i++) {
			sql =  "update teacher set majorid = " + majorid + " where teacherid = " + teacheridNums[i];
			DB.executeUpdate(conn, sql);
		}
		DB.close(stmt);
		DB.close(conn);
	}

	public List<Teacher> findTeacherBymajorid(Integer majorId) {
		// TODO Auto-generated method stub
		String sql = "select * from teacher where majorid = " + majorId;
		Connection conn = DB.getConn();
		Statement stmt = DB.createStatement(conn);
		ResultSet rs = DB.executeQuery(stmt, sql);
		List<Teacher> teacheridList = new ArrayList<>();
		Set<Teacher> teacehridSet = new HashSet<>();
		Teacher t = null;
		try {
			while (rs.next()) {
				t = new Teacher();
				t.setMajorid(rs.getInt("majorid"));
				t.setTeacherId(rs.getInt("teacherid"));
				t.setTeacherName(rs.getString("teachername"));
				t.setTeacherPassword(rs.getString("teacherPassword"));
				t.setTeacherPhone(rs.getString("teacherPhone"));
				t.setTeacherSex(rs.getString("teacherSex"));
				t.setIdentity(rs.getString("identity"));
				if(teacehridSet.add(t)) {
					teacheridList.add(t);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DB.close(rs);
		DB.close(stmt);
		DB.close(conn);
		return teacheridList;
	}

	public List<Teacher> findTeacherBycourseid(Integer courseId) {
		// TODO Auto-generated method stub
		List<Integer> list = gettid(courseId);
		List<Teacher> teacherList = new ArrayList<>();
		Connection conn = DB.getConn();
		Statement stmt = DB.createStatement(conn);
		Teacher t = null;
		for (int i = 0; i < list.size(); i++) {
			String sql = "select * from teacher where teacherid = " + list.get(i);
			ResultSet rs = DB.executeQuery(stmt, sql);
			try {
				while (rs.next()) {
					t = new Teacher();
					t.setMajorid(rs.getInt("majorid"));
					t.setTeacherId(rs.getInt("teacherid"));
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
			teacherList.add(t);
			DB.close(rs);
		}
		DB.close(stmt);
		DB.close(conn);
		return teacherList;
	}
	
	public List<Integer> gettid(int cid) {
		String sql = "select * from t4c where courseid = " + cid;
		Connection conn = DB.getConn();
		Statement stmt = DB.createStatement(conn);
		ResultSet rs = DB.executeQuery(stmt, sql);
		List<Integer> teacheridList = new ArrayList<>();
		Set<Integer> teacehridSet = new HashSet<>();
		try {
			while (rs.next()) {
				if(teacehridSet.add(rs.getInt("teacherid"))) {
					teacheridList.add(rs.getInt("teacherid"));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DB.close(rs);
		DB.close(stmt);
		DB.close(conn);
		return teacheridList;
	}

}





























