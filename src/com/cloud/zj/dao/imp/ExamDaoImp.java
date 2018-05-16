package com.cloud.zj.dao.imp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.cloud.zj.dao.CourseDao;
import com.cloud.zj.dao.ExamDao;
import com.cloud.zj.db.DB;
import com.cloud.zj.entity.Course;
import com.cloud.zj.entity.Exam;
import com.cloud.zj.entity.Parten;
import com.cloud.zj.generation.Paper;

public class ExamDaoImp extends BaseDaoImp<Exam> implements ExamDao {

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
				if (set.add(e)) {
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
		for (String chapter : chapterList) {
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
		String sql = "select * from exam where examkind = '" + examKind + "' and courseid = " + courseId;
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
				if (examSet.add(e))
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
		String sql = "select * from exam where examkind = '" + tmpQuestion.getExamKind() + " ' and courseid = "
				+ courseId;
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
				if (examSet.add(e))
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

	public List<Exam> changeStrtoList(String str) {
		str = str.replace("#", "");
		String[] sub = str.split("-");
		List<Exam> questionList = new ArrayList<Exam>();
		Exam exam = new Exam();
		for (int i = 1; i < sub.length - 1; i++) {
			exam = getExamByid(Integer.parseInt(sub[i]));
			questionList.add(exam);
		}
		return questionList;
	}

	@Override
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
		/*
		 * DB.close(rs); DB.close(stmt); DB.close(conn);
		 */
		return e;
	}

	@Override
	public void updateExam(Exam em) {
		// TODO Auto-generated method stub
		String sql = "update exam set courseid= " + em.getCourseId() + ", examkind='" + em.getExamKind()
				+ "', examchapter='" + em.getExamChapter() + "', examdegree= " + em.getExamDegree() + ", examscore= "
				+ em.getExamScore() + ", examcontent='" + em.getExamContent() + "', ExamAnwser='" + em.getExamAnwser()
				+ "' where examid = " + em.getExamId();
		Connection conn = DB.getConn();
		Statement stmt = DB.createStatement(conn);
		DB.executeUpdate(conn, sql);
		DB.close(stmt);
		DB.close(conn);
	}


	@Override
	public void insertExam(Exam e) {
		// TODO Auto-generated method stub
		String sql = "insert into exam(courseid, examkind, examchapter, examdegree, examscore, examcontent, examanwser) values( "
				+ e.getCourseId() + ", '" + e.getExamKind() + "', '" + e.getExamChapter() + "', " + e.getExamDegree()
				+ ", " + e.getExamScore() + ", '" + e.getExamContent() + "', '" + e.getExamAnwser() + "'" + ")";
		Connection conn = DB.getConn();
		Statement stmt = DB.createStatement(conn);
		DB.executeUpdate(conn, sql);
		DB.close(stmt);
		DB.close(conn);
	}

	@Override
	public List<Exam> searchExamByCourseIdAndExamKindAndSearch(Integer courseId, String leixing, String xinxi,
			String str) {
		// TODO Auto-generated method stub
		String sql;
		if ("根据分数".equals(str)) {
			sql = "select * from exam where examkind = '" + leixing + "' and courseid = " + courseId
					+ " and examScore = " + xinxi;
		} else if ("根据难度".equals(str)) {
			sql = "select * from exam where examkind = '" + leixing + "' and courseid = " + courseId
					+ " and examDegree = " + xinxi;
		} else {
			sql = "select * from exam where courseid = " + courseId + " and examkind = '" + leixing
					+ "' and ExamContent like '%" + xinxi + "%'";
			;
			System.out.println(sql);
		}
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
				if (examSet.add(e))
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
		String sql = "select * from paper where courseid = " + courseId;
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
				if (paperSet.add(paper))
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

	@Override
	public List<Paper> findPaper(List<Course> courseList) {
		// TODO Auto-generated method stub
		List<Paper> temp = null;
		List<Paper> paperList = new ArrayList<>();
		Set<Paper> paperSet = new HashSet<>();
		for (Course c : courseList) {
			temp = getPaperListByCourseId(c.getCourseId());
			for (Paper p : temp) {
				if (paperSet.add(p)) {
					paperList.add(p);
				}
			}
		}
		return paperList;
	}

	@Override
	public List<Exam> findExamByTeacher(Integer teacherId) {
		// TODO Auto-generated method stub
		CourseDao cdp = new CourseDaoImp();
		List<Course> courselist = cdp.findCourseByTid(teacherId);
		List<Exam> list = new ArrayList<>();
		Set<Exam> set = new HashSet<>();
		Connection conn = DB.getConn();
		Statement stmt = DB.createStatement(conn);
		for (Course c : courselist) {
			String sql = "select * from exam where courseid = " + c.getCourseId();
			ResultSet rs = DB.executeQuery(stmt, sql);
			try {
				while (rs.next()) {
					Exam e = new Exam();
					e.setCourseId(c.getCourseId());
					e.setExamAnwser(rs.getString("examanwser"));
					e.setExamChapter(rs.getString("examchapter"));
					e.setExamContent(rs.getString("examcontent"));
					e.setExamDegree(rs.getFloat("examdegree"));
					e.setExamId(rs.getInt("examid"));
					e.setExamKind(rs.getString("ExamKind"));
					e.setExamScore(rs.getInt("examscore"));
					if (set.add(e)) {
						list.add(e);
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			DB.close(rs);
		}
		DB.close(stmt);
		DB.close(conn);
		return list;
	}

	@Override
	public List<Course> findCourselistByEL(List<Exam> teacher4examList) {
		// TODO Auto-generated method stub
		List<Course> courselist = new ArrayList<>();
		CourseDao cdp = new CourseDaoImp();
		for (Exam e : teacher4examList) {
			int courseid = e.getCourseId();
			courselist.add(cdp.getCourseById(courseid));
		}
		return courselist;
	}

	@Override
	public void deleteExamByids(String examidstr) {
		// TODO Auto-generated method stub
		Connection conn = DB.getConn();
		Statement stmt = DB.createStatement(conn);
		String[] examidstring = examidstr.split("_");
		String sql = "";
		int[] examids = new int[examidstring.length];
		for (int i = 0; i < examids.length; i++) {
			examids[i] = Integer.parseInt(examidstring[i]);
		}
		for (int i = 0; i < examids.length; i++) {
			sql = "delete from exam where examid = " + examids[i];
			DB.executeUpdate(conn, sql);
		}
		DB.close(stmt);
		DB.close(conn);
	}

	@Override
	public List<Parten> findAllParten() {
		// TODO Auto-generated method stub
		String sql = "select * from parten";
		Connection conn = DB.getConn();
		Statement stmt = DB.createStatement(conn);
		ResultSet rs = DB.executeQuery(stmt, sql);
		List<Parten> partenList = new ArrayList<>();
		Set<Parten> partenSet = new HashSet<>();
		try {
			while (rs.next()) {
				Parten p = new Parten();
				p.setPartenid(rs.getInt("partenid"));
				p.setPartenName(rs.getString("partenname"));
				if (partenSet.add(p))
					partenList.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DB.close(rs);
		DB.close(stmt);
		DB.close(conn);
		return partenList;
	}

	@Override
	public String insertParten(String partenName) {
		// TODO Auto-generated method stub
		Connection conn = DB.getConn();
		Statement stmt = DB.createStatement(conn);
		String sqlPre = "Select * from parten where partenName = '"+partenName +"'";
		ResultSet rs = DB.executeQuery(stmt, sqlPre);
		try {
			while(rs.next()) {
				DB.close(rs);
				DB.close(stmt);
				DB.close(conn);
				return "error";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String sql = "insert into parten(partenname) values('" + partenName +"')";
		DB.executeUpdate(stmt, sql);
		DB.close(stmt);
		DB.close(conn);
		
		
		return "ok";
	}
	

	@Override
	public List<Exam> findExamListByExamKindAndPaper(Paper paper, String string) {
		// TODO Auto-generated method stub
		List<Exam> examList = paper.getQuestionList();
		List<Exam> list = new ArrayList<Exam>();
		String sql = "";
		for (int i = 0; i < examList.size(); i++) {
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
			if (string.equals(e.getExamKind())) {
				list.add(e);
			}
			DB.close(rs);
			DB.close(stmt);
			DB.close(conn);
		}
		return list;
	}
	
	@Override
	public Map<String, List<Exam>> getPaperMap(Paper paper) {
		// TODO Auto-generated method stub
		String[] partens = paper.getPartens().split("_");
		List<Exam> examList = paper.getQuestionList();
		Map<String, List<Exam>> map = new HashMap<>();
		String sql = "";
		for(int j = 0; j< partens.length; j++) {
			List<Exam> outputExamList = new ArrayList<>();
			String conet = "";
			for (int i = 0; i < examList.size() - 1; i++) {
				conet +=  examList.get(i).getExamId() + ",";
			}
			conet += examList.get(examList.size()-1).getExamId();
			sql = "select * from exam where examid in (" + conet  +") and examkind = '" + partens[j]+ "'";
			Connection conn = DB.getConn();
			Statement stmt = DB.createStatement(conn);
			ResultSet rs = DB.executeQuery(stmt, sql);
			Exam e = null;
			try {
				while (rs.next()) {
					e = new Exam();
					e.setCourseId(rs.getInt("courseid"));
					e.setExamAnwser(rs.getString("examanwser"));
					e.setExamChapter(rs.getString("examchapter"));
					e.setExamContent(rs.getString("examcontent"));
					e.setExamDegree(rs.getFloat("examdegree"));
					e.setExamId(rs.getInt("examid"));
					e.setExamKind(rs.getString("ExamKind"));
					e.setExamScore(rs.getInt("examscore"));
					outputExamList.add(e);
				}
			} catch (SQLException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
			DB.close(rs);
			DB.close(stmt);
			DB.close(conn);
			
			map.put(partens[j], outputExamList);
			System.out.println();
		}
		return map;
	}

	@Override
	public Map<String, Integer> getpcMap(Paper paper) {
		// TODO Auto-generated method stub
		String[] partens = paper.getPartens().split("_");
		String[] scores = paper.getPartensScoures().split("_");
		int[] partenScore = new int[scores.length];
		Map<String, Integer> map = new HashMap<>();
		for(int i= 0; i< scores.length; i++) {
			partenScore[i] = Integer.parseInt(scores[i]);
			map.put(partens[i], partenScore[i]);
		}
		return map;
	}
}














