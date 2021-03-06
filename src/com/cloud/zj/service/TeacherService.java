package com.cloud.zj.service;

import java.util.List;
import java.util.Map;

import com.cloud.zj.dao.ManagerDao;
import com.cloud.zj.dao.TeacherDao;
import com.cloud.zj.dao.imp.ManagerDaoImp;
import com.cloud.zj.dao.imp.TeacherDaoImp;
import com.cloud.zj.entity.Course;
import com.cloud.zj.entity.Major;
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

	public List<Teacher> getAllTeacher() {
		// TODO Auto-generated method stub
		return this.teacherDao.findAll();
	}

	public void putOutTeacher(int teacherid) {
		// TODO Auto-generated method stub
		this.teacherDao.deleteByid(teacherid);
	}

	public void reflashTeacher(String teacherid, String teachername, String teachersex, String teacherphone,
			String teachermajorid) {
		// TODO Auto-generated method stub
		this.teacherDao.updateTeacher(teacherid,teachername,teachersex,teacherphone,teachermajorid);
		
	}

	public void reflashT4C(String teacherid, String techercourse) {
		// TODO Auto-generated method stub
		this.teacherDao.updateT4C(teacherid,techercourse);
	}

	public void reflashTeacher(String teacherid, String teachername, String teachersex, String teacherphone) {
		// TODO Auto-generated method stub
		this.teacherDao.updateTeacher(teacherid,teachername,teachersex,teacherphone);
	}

	public Teacher getTeacherById(int teacherid) {
		// TODO Auto-generated method stub
		return this.teacherDao.selectByid(teacherid);
	}

	public void addTeacher(String identity, String teachername, String teachersex, String teacherphone,
			String teachermajorid) {
		// TODO Auto-generated method stub
		this.teacherDao.addTeacher(identity,teachername,teachersex,teacherphone,teachermajorid);
	}

	public void addT4C(String identity, String teachername, String teachercourseid) {
		// TODO Auto-generated method stub
		this.teacherDao.addT4C(identity, teachername,teachercourseid);
	}

	public Map<Integer, List<Teacher>> getTeacherByTList(List<Course> courselist) {
		// TODO Auto-generated method stub
		return this.teacherDao.findTeacherByTList(courselist);
	}
	
	public Map<Integer, List<Teacher>> getTeacherByMList(List<Major> majorall) {
		// TODO Auto-generated method stub
		return this.teacherDao.findTeacherByMList(majorall);
	}

	public void changeTsMajor(int majorid, String majorteacherid) {
		// TODO Auto-generated method stub
		this.teacherDao.updateTsMajor(majorid, majorteacherid);
	}

}

















