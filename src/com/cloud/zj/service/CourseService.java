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
	
}
