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

import com.cloud.zj.entity.Course;
import com.cloud.zj.entity.Exam;
import com.cloud.zj.service.ExamService;

@WebServlet("/examServlet")
public class ExamServlet extends HttpServlet {
	
	private ExamService examService;
	
	

	public ExamServlet() {
		examService = new ExamService();
		// TODO Auto-generated constructor stub
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utr-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
//		System.out.println("你好");
		Course course = (Course)session.getAttribute("course");
		if(course == null){
			response.sendRedirect("/zujuanxitong/login.html");
			return;
		}
		List<Exam> danxuan_exam = this.examService.findExamByCourseIdAndExamKind(course.getCourseId(),"单选题");
		List<Exam> duoxuan_exam = this.examService.findExamByCourseIdAndExamKind(course.getCourseId(),"多选题");
		List<Exam> panduan_exam = this.examService.findExamByCourseIdAndExamKind(course.getCourseId(),"判断题");
		List<Exam> tiankong_exam = this.examService.findExamByCourseIdAndExamKind(course.getCourseId(),"填空题");
		List<Exam> jianda_exam = this.examService.findExamByCourseIdAndExamKind(course.getCourseId(),"简答题");
		
		request.setAttribute("danxuan_exam", danxuan_exam);
		request.setAttribute("duoxuan_exam", duoxuan_exam);
		request.setAttribute("panduan_exam", panduan_exam);
		request.setAttribute("tiankong_exam", tiankong_exam);
		request.setAttribute("jianda_exam", jianda_exam);
//		JSONArray jsonArray = JSONArray.fromObject(danxuan_exam);
//		response.getWriter().print(jsonArray);
		getServletContext().getRequestDispatcher("/test.jsp").forward(request, response);
		
		/*
		JSONObject jsonObject = null;
		String examkind = "";
		
		try {
			jsonObject = new JSONObject(json);
			examkind = jsonObject.getString("examkind");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if ("danxuan".equals(examkind)) {
			System.out.println(course.getCourseId());
			List<Exam> danxuan_exam = this.examService.findExamByCourseIdAndExamKind(course.getCourseId(),"单选题");
			request.setAttribute("danxuan_exam", danxuan_exam);
			System.out.println("-------------------------------");
			JSONArray jsonArray = JSONArray.fromObject(danxuan_exam);
			response.getWriter().print(jsonArray);
			getServletContext().getRequestDispatcher("/test.jsp").forward(request, response);
		}
		*/
		
		
		/*
		List<Exam> duoxuan_exam = this.examService.findExamByCourseIdAndExamKind(course.getCourseId(),"多选题");
		List<Exam> panduan_exam = this.examService.findExamByCourseIdAndExamKind(course.getCourseId(),"判断题");
		List<Exam> tiankong_exam = this.examService.findExamByCourseIdAndExamKind(course.getCourseId(),"填空题");
		List<Exam> jianda_exam = this.examService.findExamByCourseIdAndExamKind(course.getCourseId(),"简答题");
		
		JSONArray jsonArray = JSONArray.fromObject(danxuan_exam);
		response.getWriter().print(jsonArray);*/
	
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
