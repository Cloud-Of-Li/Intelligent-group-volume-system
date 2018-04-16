package com.cloud.zj.dao.imp;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.Timestamp;
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
		
		Course course = courseDao.loadById(resultPaper.getCourseId());
		
		String sql = "insert into paper(paperName, courseid, adaptationDegree, examList, totalScore, diffculty, createTime, kpcoverage) "
				+ "values('" + course.getCourseName() + "-" + time.toString().substring(0, 10) + "', " + course.getCourseId()
				+ ", " + resultPaper.getAdaptationDegree() + ", '" + examList + "'," + resultPaper.getTotalScore() 
				+ " ," + resultPaper.getDifficulty() + " ,'" + time.toString().substring(0, 18) + "'," + resultPaper.getkPCoverage();
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
	
	
}

/*public static void main(String[] args) {
		Timestamp time = new Timestamp(new Date().getTime());
		int courseId = 2;
		int count = 0;
		int runCount = 3;
		double expand = 0.98;
		Paper resultPaper = null;
		
		RuleBean rule = new RuleBean();
		rule.setCompleteNum(10);
		rule.setCompleteScore(1);
		rule.setDifficulty(0.68);
		rule.setMultiNum(0);
		rule.setMultiScore(0);
		rule.setSingleNum(8);
		rule.setSingleScore(5);
		rule.setSubjectiveNum(5);
		rule.setSubjectiveScore(10);
		rule.setTfNum(0);
		rule.setTfScore(0);
		rule.setTotalMark(100);
		
		if (rule != null) {
			// 初始化种群
			Population population = new Population(courseId, 20, true, rule);
			System.out.println("初次适应度  " + population.getFitness().getAdaptationDegree());
			while (count < runCount && population.getFitness().getAdaptationDegree() < expand) {
				count++;
				population = GA.evolvePopulation(courseId, population, rule);
				System.out.println("第 " + count + " 次进化，适应度为： " + population.getFitness().getAdaptationDegree());
			}
			System.out.println("进化次数： " + count);
			System.out.println(population.getFitness().getAdaptationDegree());
			resultPaper = population.getFitness();
		}
		List<Exam> questionList = resultPaper.getQuestionList();
		
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
		
		
		String sql = "insert into paper(paperName, courseid, adaptationDegree, examList, totalScore, diffculty, createTime, kpcoverage) "
				+ "values(离散数学-2018---, " + courseId + ", " + resultPaper.getAdaptationDegree() + ", " + examList + "," + resultPaper.getTotalScore() 
				+ " ," + resultPaper.getDifficulty() + " ," + time + "," + resultPaper.getkPCoverage();
		Connection conn = DB.getConn();
		Statement stmt = DB.createStatement(conn);
		DB.executeUpdate(conn, sql);
		DB.close(stmt);
		DB.close(conn);
	}
*/