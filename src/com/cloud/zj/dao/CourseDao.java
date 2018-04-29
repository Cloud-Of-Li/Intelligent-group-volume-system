package com.cloud.zj.dao;

import java.util.List;

import com.cloud.zj.entity.Course;

public interface CourseDao extends BaseDao<Course>{

	public List<Course> findCourseByTid(int tid);

}
