package com.cloud.zj.dao;

import java.util.List;
import java.util.Set;

import com.cloud.zj.entity.Exam;

public interface ExamDao extends BaseDao<Exam>{

	public List<Exam> getExamListByCourseId(Integer courseId);

	public List<String> ChapterListByExam(List<Exam> examList);

	public List<List<Exam>> getExamListBychapter(List<String> chapterList);

	public List<Exam> getExamByCourseIdAndExamKind(Integer courseId, String examKind);
}
