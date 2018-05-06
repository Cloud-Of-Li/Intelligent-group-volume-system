package com.cloud.zj.servlet;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;

import com.cloud.zj.entity.Course;
import com.cloud.zj.generation.Paper;
import com.cloud.zj.generation.RuleBean;
import com.cloud.zj.service.CourseService;
import com.cloud.zj.service.CreatePaperService;

@WebServlet("/createPaperServlet")
public class CreatePaperServlet extends HttpServlet {

	private CreatePaperService createPaperService;
	private CourseService courseService;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CreatePaperServlet() {
		createPaperService = new CreatePaperService();
		courseService = new CourseService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		Course course = (Course) session.getAttribute("course");
		
		String json = readJSONString(request);
		JSONObject jsonObject = null;
		
		String op = "";
		try {
			jsonObject = new JSONObject(json);
			op = jsonObject.getString("op");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if("ifcreate".equals(op)) {
			int singleNum = 0;
			int multiNum = 0;
			int completeNum = 0;
			int tfNum = 0;
			int subjectiveNum = 0;
			String courseName = "";
			try {
				courseName = jsonObject.getString("courseName");
				course = this.courseService.getCourseByName(courseName);
				singleNum = jsonObject.getInt("count_danxuan");
				multiNum = jsonObject.getInt("count_duoxuan");
				tfNum = jsonObject.getInt("count_panduan");
				subjectiveNum = jsonObject.getInt("count_jianda");
				completeNum = jsonObject.getInt("count_tiankong");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			int sj_singleNum = this.createPaperService.getSingNum(course.getCourseId(),"单选题");
			if(sj_singleNum < singleNum) {
				response.getWriter().print("{\"flag\":\"danxuan_error\",\"num\":" + sj_singleNum + "}");
				return;
			}
			int sj_multiNum = this.createPaperService.getSingNum(course.getCourseId(),"多选题");
			if(sj_multiNum < multiNum) {
				response.getWriter().print("{\"flag\":\"duoxuan_error\",\"num\":"+ sj_multiNum+ "}");
				return;
			}
			int sj_completeNum = this.createPaperService.getSingNum(course.getCourseId(),"填空题");
			if(sj_completeNum < completeNum) {
				response.getWriter().print("{\"flag\":\"tiankong_error\",\"num\":" + sj_completeNum+ "}");
				return;
			}
			int sj_tfNum = this.createPaperService.getSingNum(course.getCourseId(),"判断题");
			if(sj_tfNum < tfNum) {
				response.getWriter().print("{\"flag\":\"panduan_error\",\"num\":" + sj_tfNum+ "}");
				return;
			}
			int sj_subjectiveNum = this.createPaperService.getSingNum(course.getCourseId(),"简答题");
			if(sj_subjectiveNum < subjectiveNum) {
				response.getWriter().print("{\"flag\":\"jianda_error\",\"num\":" + sj_subjectiveNum+ "}");
				return;
			}
			response.getWriter().print("{\"flag\":\"ok\",\"num\":" + 5 + "}");
			
			
		} else if("auto".equals(op)) {
			int singleNum = 0;
			int multiNum = 0;
			int completeNum = 0;
			int tfNum = 0;
			int subjectiveNum = 0;
			
			double singleScore = 0.0;
			double multiScore = 0.0;
			double completeScore = 0.0;
			double tfScore = 0.0;
			double subjectiveScore = 0.0;
			
			double totalMark =100.0;
			double difficulty = 0.5;
			
			String courseName = "";
			try {
				
				courseName = jsonObject.getString("courseName");
				course = this.courseService.getCourseByName(courseName);
				
				singleNum = jsonObject.getInt("count_danxuan");
				multiNum = jsonObject.getInt("count_duoxuan");
				tfNum = jsonObject.getInt("count_panduan");
				subjectiveNum = jsonObject.getInt("count_jianda");
				completeNum = jsonObject.getInt("count_tiankong");
				
				singleScore = jsonObject.getDouble("score_danxuan");
				multiScore = jsonObject.getDouble("score_duoxuan");
				tfScore = jsonObject.getDouble("score_panduan");
				subjectiveScore = jsonObject.getDouble("score_jianda");
				completeScore = jsonObject.getDouble("score_tiankong");

				totalMark = jsonObject.getDouble("totalScore");
				difficulty = jsonObject.getDouble("diffculty");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			RuleBean rule = new RuleBean();
			rule.setCompleteNum(completeNum);
			rule.setCompleteScore(completeScore);
			rule.setDifficulty(difficulty);
			rule.setMultiNum(multiNum);
			rule.setMultiScore(multiScore);
			rule.setSingleNum(singleNum);
			rule.setSingleScore(singleScore);
			rule.setSubjectiveNum(subjectiveNum);
			rule.setSubjectiveScore(subjectiveScore);
			rule.setTfNum(tfNum);
			rule.setTfScore(tfScore);
			rule.setTotalMark(totalMark);
			Paper resultPaper = this.createPaperService.createPaper(course.getCourseId(), rule);
			//添加试卷到数据库中
			this.createPaperService.addPaper(resultPaper, rule);
		}	
			/*System.out.println(singleNum);
			System.out.println(multiNum);
			System.out.println(tfNum);
			System.out.println(subjectiveNum);
			System.out.println(completeNum);
			
			System.out.println(singleScore);
			System.out.println(multiScore);
			System.out.println(tfScore);
			System.out.println(subjectiveScore);
			System.out.println(completeScore);
			
			System.out.println(totalMark);
			System.out.println(difficulty);*/
	}

	
	public String readJSONString(HttpServletRequest request) {
		StringBuffer json = new StringBuffer();
		String line = null;
		try {
			BufferedReader reader = request.getReader();
			while((line = reader.readLine()) != null) {
				json.append(line);
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json.toString();
	}

}
