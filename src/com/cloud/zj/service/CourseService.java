package com.cloud.zj.service;

import java.util.List;
import java.util.Map;

import com.cloud.zj.dao.CourseDao;
import com.cloud.zj.dao.imp.CourseDaoImp;
import com.cloud.zj.entity.Course;
import com.cloud.zj.entity.Teacher;

public class CourseService {
	private CourseDao courseDao;

	public CourseService() {
		super();
		courseDao = new CourseDaoImp();
	}

	public List<Course> getCourseByTid(int tid) {
		// TODO Auto-generated method stub
		return this.courseDao.findCourseByTid(tid);
	}

	public Map<Integer, List<Course>> getCourseByTList(List<Teacher> teacherlist) {
		// TODO Auto-generated method stub
		return this.courseDao.findCourseByTList(teacherlist);
	}

	public List<Course> getAllCourse() {
		// TODO Auto-generated method stub
		return this.courseDao.findAllCourse();
	}

	public Course getCourseByName(String coursestr) {
		// TODO Auto-generated method stub
		return this.courseDao.findCourseByName(coursestr);
	}

	public void addCourse(String coursename, String coursemajorid) {
		// TODO Auto-generated method stub
		this.courseDao.inputCourse(coursename, coursemajorid);
	}

	public void putOutCourse(int courseid) {
		// TODO Auto-generated method stub
		this.courseDao.deleteByid(courseid);
	}

	public void addT4C(String coursename, String coursetecherid) {
		// TODO Auto-generated method stub
		this.courseDao.addT4C(coursename, coursetecherid);
		
	}

	public void reflashTeacher(int courseid, String coursename, int coursemajorid) {
		// TODO Auto-generated method stub
		this.courseDao.updateCourse(courseid,coursename,coursemajorid);
	}

	public void reflashT4C(int courseid, String coursetecherid) {
		// TODO Auto-generated method stub
		this.courseDao.updateT4C(courseid,coursetecherid);
	}
	
}
