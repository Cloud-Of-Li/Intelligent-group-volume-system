package com.cloud.zj.service;

import java.util.List;

import com.cloud.zj.dao.CourseDao;
import com.cloud.zj.dao.imp.CourseDaoImp;
import com.cloud.zj.entity.Course;

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
	
}
