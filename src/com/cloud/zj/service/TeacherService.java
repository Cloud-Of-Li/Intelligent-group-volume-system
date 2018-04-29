package com.cloud.zj.service;

import java.util.List;

import com.cloud.zj.dao.ManagerDao;
import com.cloud.zj.dao.TeacherDao;
import com.cloud.zj.dao.imp.TeacherDaoImp;
import com.cloud.zj.entity.Manager;
import com.cloud.zj.entity.Teacher;

public class TeacherService {

private TeacherDao teacherDao;
private ManagerDao managerDao;
	
	

	public TeacherService() {
		teacherDao = new TeacherDaoImp();
		managerDao = new ManagerDaoImp();
		// TODO Auto-generated constructor stub
	}
	
	public Teacher getTeacherByTname(String teacherName) {
		// TODO Auto-generated method stub
		return this.teacherDao.findTeacherByTname(teacherName);
	}

	public boolean login(Teacher teacher) {
		// TODO Auto-generated method stub
		List<Teacher> teachers = this.teacherDao.findAll();
		for(Teacher t : teachers){
			if(t.getTeacherName().equals(teacher.getTeacherName())
					&& t.getTeacherPassword().equals(teacher.getTeacherPassword())) {
				return true;
			}
		}
		return false;
	}

	public boolean login(Manager manager) {
		// TODO Auto-generated method stub
		List<Manager> managers = this.managerDao.findAll();
		for(Manager m : managers){
			if(m.getManagerName().equals(manager.getManagerName())
					&& m.getManagerPassword().equals(manager.getManagerPassword())) {
				return true;
			}
		}
		return false;
	}
	
}
















