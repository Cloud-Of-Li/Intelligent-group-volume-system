package com.cloud.zj.service;

import java.util.ArrayList;
import java.util.List;

import com.cloud.zj.dao.ExamDao;
import com.cloud.zj.dao.imp.ExamDaoImp;
import com.cloud.zj.entity.Course;
import com.cloud.zj.entity.Exam;
import com.cloud.zj.generation.Paper;

public class ExamService {
	private ExamDao examDao;

	public ExamService() {
		super();
		examDao = new ExamDaoImp();
	}
	
	public List<Exam> findByCourseId(Integer courseId) {
		// TODO Auto-generated method stub
		return this.examDao.getExamListByCourseId(courseId);
	}

	public List<String> findByExam(List<Exam> examList) {
		// TODO Auto-generated method stub
		return this.examDao.ChapterListByExam(examList);
	}

	public List<List<Exam>> findExamByChapter(List<String> chapterList) {
		// TODO Auto-generated method stub
		return this.examDao.getExamListBychapter(chapterList);
	}

	public List<Exam> findExamByCourseIdAndExamKind(Integer courseId,  String examKind) {
		// TODO Auto-generated method stub
		return this.examDao.getExamByCourseIdAndExamKind(courseId,examKind);
	}

	public List<Paper> findPaperByCourserId(Integer courseId) {
		// TODO Auto-generated method stub
		return this.examDao.getPaperListByCourseId(courseId);
	}

	public List<Exam> getExamListByExamKindAndPaper(Paper paper, String string) {
		// TODO Auto-generated method stub
		return this.examDao.findExamListByExamKindAndPaper(paper, string);
	}

	public List<String> setSequence() {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<>();
		list.add("一");
		list.add("二");
		list.add("三");
		list.add("四");
		list.add("五");
		return list;
	}

	public void addExam(Exam e) {
		// TODO Auto-generated method stub
		this.examDao.insertExam(e);
	}

	public List<Exam> findExamByCourseIdAndExamKindAndSearch(Integer courseId, String leixing, String xinxi, String str) {
		// TODO Auto-generated method stub
		return this.examDao.searchExamByCourseIdAndExamKindAndSearch(courseId, leixing, xinxi, str);
	}

	public List<Paper> findPaperByCourserList(List<Course> courseList) {
		// TODO Auto-generated method stub
		return this.examDao.findPaper(courseList);
	}

	public List<Exam> findteacher4examList(Integer teacherId) {
		// TODO Auto-generated method stub
		return this.examDao.findExamByTeacher(teacherId);
	}

	public List<Course> findCourse4examList(List<Exam> teacher4examList) {
		// TODO Auto-generated method stub
		return this.examDao.findCourselistByEL(teacher4examList);
	}

	public void putOutExam(String examidstr) {
		// TODO Auto-generated method stub
		this.examDao.deleteExamByids(examidstr);
	}

	public Exam getExamByid(int examid) {
		// TODO Auto-generated method stub
		return this.examDao.getExamByid(examid);
	}

	public void updateExam(Exam e) {
		// TODO Auto-generated method stub
		this.examDao.updateExam(e);
	}

	
}
