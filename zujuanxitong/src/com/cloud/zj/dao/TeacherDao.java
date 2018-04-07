package com.cloud.zj.dao;

import com.cloud.zj.entity.Teacher;

public interface TeacherDao extends BaseDao<Teacher>{
	public Teacher findTeacherByTname(String TeacherName);
}
