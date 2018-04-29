package com.cloud.zj.service;

import java.util.List;

import com.cloud.zj.dao.ExamDao;
import com.cloud.zj.dao.imp.ExamDaoImp;
import com.cloud.zj.entity.Exam;

public class QuestionService {
	private static ExamDao examDao;

	public static Exam[] getQuestionArray(int courseId,String type) {
		// TODO Auto-generated method stub
		
		examDao = new ExamDaoImp();
		List<Exam> examlist = examDao.getExamByCourseIdAndExamKind(courseId, type);
		Exam[] exams = new Exam[examlist.size()];
		return examlist.toArray(exams);
	}



	public static List<Exam> getQuestionListWithOutSId(int courseId, Exam tmpQuestion) {
		// TODO Auto-generated method stub
		examDao = new ExamDaoImp();
		return examDao.getExamListByExam(courseId, tmpQuestion);
	}

}
