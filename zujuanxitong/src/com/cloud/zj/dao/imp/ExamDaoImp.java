package com.cloud.zj.dao.imp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.cloud.zj.dao.ExamDao;
import com.cloud.zj.db.DB;
import com.cloud.zj.entity.Exam;

public class ExamDaoImp extends BaseDaoImp<Exam> implements ExamDao{

	@Override
	public List<Exam> getExamListByCourseId(Integer courseId) {
		// TODO Auto-generated method stub
		String sql = "select * from exam where courseid = " + courseId;
		Connection conn = DB.getConn();
		Statement stmt = DB.createStatement(conn);
		ResultSet rs = DB.executeQuery(stmt, sql);
		List<Exam> list = new ArrayList<>();
		Set<Exam> set = new HashSet<>();
		try {
			while (rs.next()) {
				Exam e = new Exam();
				e.setCourseId(courseId);
				e.setExamAnwser(rs.getString("examanwser"));
				e.setExamChapter(rs.getString("examchapter"));
				e.setExamContent(rs.getString("examcontent"));
				e.setExamDegree(rs.getFloat("examdegree"));
				e.setExamId(rs.getInt("examid"));
				e.setExamKind(rs.getString("ExamKind"));
				e.setExamScore(rs.getInt("examscore"));
				if(set.add(e)) {
					list.add(e);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DB.close(rs);
		DB.close(stmt);
		DB.close(conn);
		return list;
	}

	@Override
	public List<String> ChapterListByExam(List<Exam> examList) {
		// TODO Auto-generated method stub
		List<String> chapterList = new ArrayList<>();
		Set<String> set = new HashSet<>();
		for (Exam e : examList) {
			if (set.add(e.getExamChapter()))
				chapterList.add(e.getExamChapter());
		}	
		return chapterList;
	}

	@Override
	public List<List<Exam>> getExamListBychapter(List<String> chapterList) {
		// TODO Auto-generated method stub
		List<List<Exam>> examList = new ArrayList<>();
		for(String chapter : chapterList) {
			examList.add(getExamSetBychapter(chapter));
		}
		return examList;
	}
	
	public List<Exam> getExamSetBychapter(String chapter) {
		String sql = "select * from exam where examchapter = '" + chapter + "'";
		Connection conn = DB.getConn();
		Statement stmt = DB.createStatement(conn);
		ResultSet rs = DB.executeQuery(stmt, sql);
		List<Exam> examList = new ArrayList<>();
		try {
			while (rs.next()) {
				Exam e = new Exam();
				e.setCourseId(rs.getInt("courseid"));
				e.setExamAnwser(rs.getString("examanwser"));
				e.setExamChapter(rs.getString("examchapter"));
				e.setExamContent(rs.getString("examcontent"));
				e.setExamDegree(rs.getFloat("examdegree"));
				e.setExamId(rs.getInt("examid"));
				e.setExamKind(rs.getString("ExamKind"));
				e.setExamScore(rs.getInt("examscore"));
				examList.add(e);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DB.close(rs);
		DB.close(stmt);
		DB.close(conn);
		return examList;
	}

	@Override
	public List<Exam> getExamByCourseIdAndExamKind(Integer courseId, String examKind) {
		// TODO Auto-generated method stub
		String sql = "select * from exam where examkind = '"+ examKind + " ' and courseid = "  + courseId;
		Connection conn = DB.getConn();
		Statement stmt = DB.createStatement(conn);
		ResultSet rs = DB.executeQuery(stmt, sql);
		List<Exam> examList = new ArrayList<>();
		Set<Exam> examSet = new HashSet<>();
		try {
			while (rs.next()) {
				Exam e = new Exam();
				e.setCourseId(rs.getInt("courseid"));
				e.setExamAnwser(rs.getString("examanwser"));
				e.setExamChapter(rs.getString("examchapter"));
				e.setExamContent(rs.getString("examcontent"));
				e.setExamDegree(rs.getFloat("examdegree"));
				e.setExamId(rs.getInt("examid"));
				e.setExamKind(rs.getString("ExamKind"));
				e.setExamScore(rs.getInt("examscore"));
				if(examSet.add(e))
					examList.add(e);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DB.close(rs);
		DB.close(stmt);
		DB.close(conn);
		return examList;
	}
}
	










































