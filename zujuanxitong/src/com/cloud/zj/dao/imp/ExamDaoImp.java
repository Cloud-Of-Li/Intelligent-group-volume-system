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
import com.cloud.zj.generation.Paper;

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

	@Override
	public List<Exam> getExamListByExam(int courseId, Exam tmpQuestion) {
		// 获取和参数题目分数一样，类型一样的题目
		String sql = "select * from exam where examkind = '"+ tmpQuestion.getExamKind() + " ' and courseid = "  + courseId;
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

	@Override
	public List<Paper> getPaperListByCourseId(Integer courseId) {
		// TODO Auto-generated method stub
		String sql = "select * from paper where courseid = "  + courseId;
		Connection conn = DB.getConn();
		Statement stmt = DB.createStatement(conn);
		ResultSet rs = DB.executeQuery(stmt, sql);
		List<Paper> paperList = new ArrayList<>();
		Set<Paper> paperSet = new HashSet<>();
		try {
			while (rs.next()) {
				Paper paper = new Paper();
				paper.setAdaptationDegree(rs.getDouble("adaptationdegree"));
				paper.setCourseId(courseId);
				paper.setCreateTime(rs.getTimestamp("createtime"));
				paper.setDifficulty(rs.getDouble("diffculty"));
				paper.setId(rs.getInt("id"));
				paper.setkPCoverage(rs.getDouble("kpcoverage"));
				paper.setTotalScore(rs.getDouble("totalscore"));
				paper.setPaperName(rs.getString("papername"));
				String questionStr = rs.getString("examlist");
				paper.setQuestionList(changeStrtoList(questionStr));
				if(paperSet.add(paper))
					paperList.add(paper);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DB.close(rs);
		DB.close(stmt);
		DB.close(conn);
		return paperList;
	}
	
	public List<Exam> changeStrtoList(String str) {
		str = str.replace("#", "");
		String[] sub = str.split("-");
		List<Exam> questionList = new ArrayList<Exam>();
		Exam exam = new Exam();
		for(int i = 1; i < sub.length - 1; i++) {
			exam =  getExamByid(Integer.parseInt(sub[i]));
			questionList.add(exam);
		}
		return questionList;
	}
	
	public Exam getExamByid(int examid) {
		// TODO Auto-generated method stub
		String sql = "select * from exam where examid = " + examid;
		Connection conn = DB.getConn();
		Statement stmt = DB.createStatement(conn);
		ResultSet rs = DB.executeQuery(stmt, sql);
		Exam e = new Exam();
		try {
			while (rs.next()) {
				e.setCourseId(rs.getInt("courseid"));
				e.setExamAnwser(rs.getString("examanwser"));
				e.setExamChapter(rs.getString("examchapter"));
				e.setExamContent(rs.getString("examcontent"));
				e.setExamDegree(rs.getFloat("examdegree"));
				e.setExamId(examid);
				e.setExamKind(rs.getString("ExamKind"));
				e.setExamScore(rs.getInt("examscore"));
			}
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		/*DB.close(rs);
		DB.close(stmt);
		DB.close(conn);*/
		return e;
	}

	@Override
	public List<Exam> findExamListByExamKindAndPaper(Paper paper, String string) {
		// TODO Auto-generated method stub
		List<Exam> examList = paper.getQuestionList();
		List<Exam> list = new ArrayList<Exam>();
		String sql = "";
		for(int i = 0; i < examList.size(); i++) {
			sql = "select * from exam where examid = " + examList.get(i).getExamId();
			Connection conn = DB.getConn();
			Statement stmt = DB.createStatement(conn);
			ResultSet rs = DB.executeQuery(stmt, sql);
			Exam e = new Exam();
			try {
				while (rs.next()) {
					e.setCourseId(rs.getInt("courseid"));
					e.setExamAnwser(rs.getString("examanwser"));
					e.setExamChapter(rs.getString("examchapter"));
					e.setExamContent(rs.getString("examcontent"));
					e.setExamDegree(rs.getFloat("examdegree"));
					e.setExamId(examList.get(i).getExamId());
					e.setExamKind(rs.getString("ExamKind"));
					e.setExamScore(rs.getInt("examscore"));
				}
			} catch (SQLException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
			if(string.equals(e.getExamKind())) {
				list.add(e);
			}
			DB.close(rs);
			DB.close(stmt);
			DB.close(conn);
		}
		return list;
	}
	
	
	
}
	










































