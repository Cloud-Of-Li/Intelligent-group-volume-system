package com.cloud.zj.dao;

import java.util.List;
import java.util.Map;

import com.cloud.zj.entity.Course;
import com.cloud.zj.entity.Teacher;

public interface CourseDao extends BaseDao<Course>{

	public List<Course> findCourseByTid(int tid);

	public Map<Integer, List<Course>> findCourseByTList(List<Teacher> teacherlist);

}
