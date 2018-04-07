package com.cloud.zj.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;

import com.cloud.zj.entity.Course;
import com.cloud.zj.entity.Exam;
import com.cloud.zj.entity.Major;
import com.cloud.zj.entity.Teacher;
import com.cloud.zj.service.CourseService;
import com.cloud.zj.service.ExamService;
import com.cloud.zj.service.MajorService;
import com.cloud.zj.service.TeacherService;

@WebServlet("/teacherServlet")
public class TeacherServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TeacherService teacherService;
	private ExamService examService;
	private CourseService courseService;
	private MajorService majorService;
	
	public TeacherServlet() {
		super();
		teacherService = new TeacherService();
		examService = new ExamService();
		courseService = new CourseService();
		majorService = new MajorService();
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
		
		if("login".equals(op)) {
			String teacherName = "";
			String teacherPassword = "";
			
			try {
				teacherName = jsonObject.getString("teacherName");
				teacherPassword = jsonObject.getString("teacherPassword");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Teacher teacher = this.teacherService.getTeacherByTname(teacherName);
			
			if(teacher != null) {
				Course course = this.courseService.getCourseByTid(teacher.getTeacherId());
				Major major = this.majorService.getMajorById(course.getMajorId());
				List<String> chapterList = this.examService.findByExam(this.examService.findByCourseId(course.getCourseId()));
				List<List<Exam>>  examList = this.examService.findExamByChapter(chapterList);
				HttpSession session = request.getSession();
				session.setAttribute("teacher", teacher);
				session.setAttribute("course", course);
				session.setAttribute("major", major);
				session.setAttribute("chapterList", chapterList);
				session.setAttribute("examList", examList);
			}
			
			boolean teacherLogin = false;
			
			if(teacherName != null && !teacherName.equals("")) {
				if(teacherPassword != null && !teacherPassword.equals("")) {
					teacherLogin = this.teacherService.login(teacher);
				}
			}
//			JSONArray jsonArray = JSONArray.fromObject(examList);
			
			
			if (teacherLogin == true)
				//request.getRequestDispatcher("examServlet").forward(request, response);
				response.getWriter().print("/examServlet");
			else
				response.getWriter().print("error");
		} else if ("show".equals(op)) {
			
		}
	}
	
	public String readJSONString(HttpServletRequest request) {
		StringBuffer json = new StringBuffer();
		String line = null;
		try {
			BufferedReader reader = request.getReader();
			while ((line = reader.readLine()) != null) {
				json.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return json.toString();
	} 
	
	
}
