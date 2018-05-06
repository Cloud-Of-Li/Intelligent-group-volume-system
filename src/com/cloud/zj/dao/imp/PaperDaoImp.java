package com.cloud.zj.dao.imp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cloud.zj.dao.CourseDao;
import com.cloud.zj.dao.PaperDao;
import com.cloud.zj.db.DB;
import com.cloud.zj.entity.Course;
import com.cloud.zj.entity.Exam;
import com.cloud.zj.generation.Paper;
import com.cloud.zj.generation.RuleBean;

public class PaperDaoImp implements PaperDao {
	
	
	private CourseDao courseDao;
	
	public PaperDaoImp() {
		courseDao = new CourseDaoImp();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void savePaper(Paper resultPaper, RuleBean rule) {
		// TODO Auto-generated method stub
		Timestamp time = new Timestamp(new Date().getTime());
		List<Exam> questionList = resultPaper.getQuestionList();
		String examList = getExamListToString(questionList , rule);
		
		Course course = courseDao.getCourseById(resultPaper.getCourseId());
		
		String sql = "insert into paper(paperName, courseid, adaptationDegree, examList, totalScore, diffculty, createTime, kpcoverage, "
				+ "singlescore, multiscore, completeScore, tfscore, subjectscore) "
				+ "values('" + course.getCourseName() + "-" + time.toString().substring(0, 19) + "', " + resultPaper.getCourseId()
				+ ", " + resultPaper.getAdaptationDegree() + ", '" + examList + "'," + resultPaper.getTotalScore() 
				+ " ," + resultPaper.getDifficulty() + " ,'" + time.toString().substring(0, 18) + "'," + resultPaper.getkPCoverage() 
				+ "," + rule.getSingleScore() + "," + rule.getMultiScore() + "," + rule.getCompleteScore() + "," + rule.getTfScore()
				+ "," + rule.getSubjectiveScore() + ")";
		Connection conn = DB.getConn();
		Statement stmt = DB.createStatement(conn);
		DB.executeUpdate(conn, sql);
		DB.close(stmt);
		DB.close(conn);
	}
	
	public String getExamListToString(List<Exam> questionList, RuleBean rule) {
		String examList = "#";
		int k = rule.getSingleNum();
		for(int i = 0; i < k; i++) {
			examList += "-" + questionList.get(i).getExamId();
		}
		examList += "#";
		
		for(int i = k; i < k + rule.getMultiNum(); i++) {
			examList += "-" + questionList.get(i).getExamId();
		}
		examList += "#";
		
		k += rule.getMultiNum();
		for(int i = k; i < k + rule.getCompleteNum(); i++) {
			examList += "-" + questionList.get(i).getExamId();
		}
		examList += "#";
		
		k += rule.getCompleteNum();
		for(int i = k; i < k + rule.getTfNum(); i++) {
			examList += "-" + questionList.get(i).getExamId();
		}
		examList += "#";
		
		k += rule.getTfNum();
		for(int i = k; i < k + rule.getSubjectiveNum(); i++) {
			examList += "-" + questionList.get(i).getExamId();
		}
		examList += "#";
		return examList;
	}

	@Override
	public Paper findPaperByPaperName(String paperName) {
		// TODO Auto-generated method stub
		String sql = "select * from paper where paperName = '" + paperName + "'";
		Connection conn = DB.getConn();
		Statement stmt = DB.createStatement(conn);
		ResultSet rs = DB.executeQuery(stmt, sql);
		Paper paper = new Paper();
		try {
			while (rs.next()) {
				paper.setAdaptationDegree(rs.getDouble("adaptationdegree"));
				paper.setCourseId(rs.getInt("courseid"));
				paper.setCreateTime(rs.getTimestamp("createtime"));
				paper.setDifficulty(rs.getDouble("diffculty"));
				paper.setId(rs.getInt("id"));
				paper.setkPCoverage(rs.getDouble("kpcoverage"));
				paper.setTotalScore(rs.getDouble("totalscore"));
				paper.setPaperName(rs.getString("papername"));
				String questionStr = rs.getString("examlist");
				paper.setQuestionList(changeStrtoList(questionStr));
				paper.setSingleScore(rs.getDouble("singlescore"));
				paper.setMultiScore(rs.getDouble("multiscore"));
				paper.setCompeleteScore(rs.getDouble("completescore"));
				paper.setTfScore(rs.getDouble("tfscore"));
				paper.setSubjectScore(rs.getDouble("subjectscore"));
			}
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		DB.close(rs);
		DB.close(stmt);
		DB.close(conn);
		return paper;
	}
	public List<Exam> changeStrtoList(String str) {
		str = str.replace("#", "");
		String[] sub = str.split("-");
		List<Exam> questionList = new ArrayList<Exam>();
		Exam exam = new Exam();
		for(int i = 1; i < sub.length; i++) {
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
	public int getExamNumByCourseIdAndKind(Integer courseId, String string) {
		// TODO Auto-generated method stub
		String sql = "select * from exam where courseid = " + courseId + " and examkind = '" + string +"'";
		Connection conn = DB.getConn();
		Statement stmt = DB.createStatement(conn);
		ResultSet rs = DB.executeQuery(stmt, sql);
		int count = 0;
		try {
			while (rs.next()) {
				count++;
			}
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		DB.close(rs);
		DB.close(stmt);
		DB.close(conn);
		return count;
	}

	@Override
	public List<Paper> findAllpapers() {
		String sql = "select * from paper";
		Connection conn = DB.getConn();
		Statement stmt = DB.createStatement(conn);
		ResultSet rs = DB.executeQuery(stmt, sql);
		List<Paper> paperlist = new ArrayList<>();
		Paper paper = null;
		try {
			while (rs.next()) {
				paper = new Paper();
				paper.setId(rs.getInt("id"));
				paper.setPaperName(rs.getString("papername"));
				paper.setCourseId(rs.getInt("courseid"));
				paper.setAdaptationDegree(rs.getDouble("adaptationdegree"));
				String questionStr = rs.getString("examlist");
				paper.setQuestionList(changeStrtoList(questionStr));
				paper.setTotalScore(rs.getDouble("totalscore"));
				paper.setDifficulty(rs.getDouble("diffculty"));
				paper.setCreateTime(rs.getTimestamp("createtime"));
				paper.setkPCoverage(rs.getDouble("kpcoverage"));
				paper.setSingleScore(rs.getDouble("singlescore"));
				paper.setMultiScore(rs.getDouble("multiscore"));
				paper.setCompeleteScore(rs.getDouble("completescore"));
				paper.setTfScore(rs.getDouble("tfscore"));
				paper.setSubjectScore(rs.getDouble("subjectscore"));
				paperlist.add(paper);
				
			}
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		DB.close(rs);
		DB.close(stmt);
		DB.close(conn);
		return paperlist;
	}

	@Override
	public void deletePaperByName(String paperName) {
		// TODO Auto-generated method stub
		String sql = "delete from paper where papername = '" + paperName + "'";
		Connection conn = DB.getConn();
		Statement stmt = DB.createStatement(conn);
		DB.executeUpdate(conn, sql);
		DB.close(stmt);
		DB.close(conn);
	}
}



























