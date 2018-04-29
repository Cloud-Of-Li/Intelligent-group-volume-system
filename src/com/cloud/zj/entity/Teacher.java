package com.cloud.zj.entity;

public class Teacher {
	private Integer teacherId;
	private String teacherName;
	private String teacherPassword;
	private String teacherSex;
	private String teacherPhone;
	private int majorid;
	public String getTeacherSex() {
		return teacherSex;
	}
	public void setTeacherSex(String teacherSex) {
		this.teacherSex = teacherSex;
	}
	public String getTeacherPhone() {
		return teacherPhone;
	}
	public void setTeacherPhone(String teacherPhone) {
		this.teacherPhone = teacherPhone;
	}
	public Integer getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getTeacherPassword() {
		return teacherPassword;
	}
	public void setTeacherPassword(String teacherPassword) {
		this.teacherPassword = teacherPassword;
	}
	public int getMajorid() {
		return majorid;
	}
	public void setMajorid(int majorid) {
		this.majorid = majorid;
	}
}
