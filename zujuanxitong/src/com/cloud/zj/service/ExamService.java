package com.cloud.zj.service;

import java.util.List;
import java.util.Set;

import com.cloud.zj.dao.ExamDao;
import com.cloud.zj.dao.imp.ExamDaoImp;
import com.cloud.zj.entity.Exam;

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

	
}
