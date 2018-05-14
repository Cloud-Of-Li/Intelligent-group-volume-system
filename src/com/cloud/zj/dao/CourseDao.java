package com.cloud.zj.dao;

import java.util.List;
import java.util.Map;

import com.cloud.zj.entity.Course;
import com.cloud.zj.entity.Teacher;

public interface CourseDao extends BaseDao<Course>{

	public List<Course> findCourseByTid(int tid);

	public Map<Integer, List<Course>> findCourseByTList(List<Teacher> teacherlist);

	public List<Course> findAllCourse();

	public Course findCourseByName(String coursestr);

	public Course getCourseById(int courseId);

	public void inputCourse(String coursename, String coursemajorid);

	public void deleteByid(int courseid);

	public void addT4C(String coursename, String coursetecherid);

	public void updateCourse(int courseid, String coursename, int coursemajorid);

	public void updateT4C(int courseid, String coursetecherid);

}
