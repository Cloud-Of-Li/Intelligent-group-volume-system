package com.cloud.zj.dao;

import com.cloud.zj.entity.Course;

public interface CourseDao extends BaseDao<Course>{

	public Course findCourseByTid(int tid);

}
