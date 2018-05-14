package com.cloud.zj.dao;

import java.util.List;
import java.util.Map;

import com.cloud.zj.entity.Course;
import com.cloud.zj.entity.Teacher;

public interface TeacherDao extends BaseDao<Teacher>{
	public Teacher findTeacherByTname(String TeacherName);

	public void deleteByid(int teacherid);

	public void updateTeacher(String teacherid, String teachername, String teachersex, String teacherphone,
			String teachermajorid);

	public void updateT4C(String teacherid, String techercourse);

	public void updateTeacher(String teacherid, String teachername, String teachersex, String teacherphone);

	public Teacher selectByid(int teacherid);

	public void addTeacher(String identity, String teachername, String teachersex, String teacherphone,String majorid);

	public void addT4C(String identity, String teachername, String teachercourseid);

	public Map<Integer, List<Teacher>> findTeacherByTList(List<Course> courselist);

}
