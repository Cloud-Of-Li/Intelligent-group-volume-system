package com.cloud.zj.dao;

import com.cloud.zj.entity.Teacher;

public interface TeacherDao extends BaseDao<Teacher>{
	public Teacher findTeacherByTname(String TeacherName);

	public void deleteByid(int teacherid);

	public void updateTeacher(String teacherid, String teachername, String teachersex, String teacherphone,
			String teachermajorid);

	public void updateT4C(String teacherid, String techercourse);
}
