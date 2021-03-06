package com.cloud.zj.dao;

import java.util.List;
import java.util.Map;

import com.cloud.zj.entity.Course;
import com.cloud.zj.entity.Exam;
import com.cloud.zj.entity.Parten;
import com.cloud.zj.generation.Paper;

public interface ExamDao extends BaseDao<Exam>{

	public List<Exam> getExamListByCourseId(Integer courseId);

	public List<String> ChapterListByExam(List<Exam> examList);

	public List<List<Exam>> getExamListBychapter(List<String> chapterList);

	public List<Exam> getExamByCourseIdAndExamKind(Integer courseId, String examKind);

	public List<Exam> getExamListByExam(int courseId, Exam tmpQuestion);

	public List<Paper> getPaperListByCourseId(Integer courseId);

	public List<Exam> findExamListByExamKindAndPaper(Paper paper, String string);

	public void insertExam(Exam e);

	public List<Exam> searchExamByCourseIdAndExamKindAndSearch(Integer courseId, String leixing, String xinxi, String str);

	public List<Paper> findPaper(List<Course> courseList);

	public List<Exam> findExamByTeacher(Integer teacherId);

	public List<Course> findCourselistByEL(List<Exam> teacher4examList);

	public void deleteExamByids(String examidstr);

	public Exam getExamByid(int examid);

	public void updateExam(Exam e);

	public List<Parten> findAllParten();

	public String insertParten(String partenName);

	public Map<String, List<Exam>> getPaperMap(Paper paper);

	public Map<String, Integer> getpcMap(Paper paper);

}
