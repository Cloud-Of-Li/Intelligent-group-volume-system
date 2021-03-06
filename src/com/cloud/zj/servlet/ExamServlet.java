package com.cloud.zj.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.cloud.zj.entity.Parten;
import com.cloud.zj.entity.Teacher;
import com.cloud.zj.generation.Paper;
import com.cloud.zj.service.CourseService;
import com.cloud.zj.service.ExamService;
import com.cloud.zj.service.TeacherService;

@WebServlet("/examServlet")
public class ExamServlet extends HttpServlet {
	
	private ExamService examService;
	private CourseService courseService;
	private TeacherService teacherService;
	
	public ExamServlet() {
		examService = new ExamService();
		courseService = new CourseService();
		teacherService = new TeacherService();
		// TODO Auto-generated constructor stub
	}
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utr-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		// System.out.println("你好");
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		if(teacher == null || teacher.getTeacherId()== null) {
			response.sendRedirect("/zujuanxitong/login.html");
		}
		Course course = (Course) session.getAttribute("course");
		List<Course> courseList = this.courseService.getCourseByTid(teacher.getTeacherId());
		if (course == null || courseList == null) {
			response.sendRedirect("/zujuanxitong/login.html");
			return;
		}
		
		List<Parten> partenList = this.examService.getAllParten();
		
		
		List<Paper> paperList = this.examService.findPaperByCourserList(courseList);
		List<Exam> teacher4examList = this.examService.findteacher4examList(teacher.getTeacherId());
		List<Course> course4examList = this.examService.findCourse4examList(teacher4examList);
		Map<Exam, Course> ECMap = new HashMap<>();
		for(int i = 0; i < teacher4examList.size(); i++) {
			ECMap.put(teacher4examList.get(i), course4examList.get(i));
		}
		request.setAttribute("partenList", partenList);
		request.setAttribute("paperList", paperList);
		request.setAttribute("courseList", courseList);
		request.setAttribute("teacher4examList", teacher4examList);
		request.setAttribute("course4examList", course4examList);
		request.setAttribute("ECMap", ECMap);
		
		
		
		
		String op = request.getParameter("op");
		if ("add".equals(op)) {
			
			String courseName = request.getParameter("add_kecheng");
			course = this.courseService.getCourseByName(courseName);
			String zhangjie = request.getParameter("add_zhangjie");
			float diffculty = Float.parseFloat(request.getParameter("add_nandu"));
			Double score = Double.parseDouble(request.getParameter("add_fenzhi"));
			String content = request.getParameter("add_shitineirong_name");
			String anwser = request.getParameter("add_shiti_daan");
			String kind = request.getParameter("add_leixing");

			Exam e = new Exam();
			e.setCourseId(course.getCourseId());
			e.setExamAnwser(anwser);
			e.setExamChapter(zhangjie);
			e.setExamContent(content);
			e.setExamDegree(diffculty);
			e.setExamKind(kind);
			e.setExamScore(score);
			this.examService.addExam(e);
			response.sendRedirect("examServlet");
		} else if ("search".equals(op)) {
			String leixing = request.getParameter("leixing");
			String xinxi = request.getParameter("search");
			String xingshi = request.getParameter("xingshi");
			String courseName = request.getParameter("courseName");
			
			course = this.courseService.getCourseByName(courseName);
			List<Exam> examforSeacher = null;
			if ("1".equals(xingshi)) {
				examforSeacher = this.examService.findExamByCourseIdAndExamKindAndSearch(course.getCourseId(), leixing,
						xinxi, "根据内容");
			} else if ("2".equals(xingshi)) {
				examforSeacher = this.examService.findExamByCourseIdAndExamKindAndSearch(course.getCourseId(), leixing,
						xinxi, "根据难度");
			} else if ("3".equals(xingshi)) {
				examforSeacher = this.examService.findExamByCourseIdAndExamKindAndSearch(course.getCourseId(), leixing,
						xinxi, "根据分数");
			}
			request.setAttribute("examforSeacher", examforSeacher);
			getServletContext().getRequestDispatcher("/test.jsp").forward(request, response);
		} else if("list".equals(op)) {
			String coursestr = request.getParameter("courseName");
			course = this.courseService.getCourseByName(coursestr);
			if(course == null){
				course = this.courseService.getCourseByName("离散数学");
			}
			getServletContext().getRequestDispatcher("/test.jsp").forward(request, response);
		}   else if("deleteExam".equals(op)) {
			//删除试题
			String examidstr = request.getParameter("examidstr");
			this.examService.putOutExam(examidstr);
			response.sendRedirect("examServlet");
		}  else if ("update".equals(op)) {
			/*更新教师信息*/
			String json = readJSONString(request);
			JSONObject jsonObject = null;
			String teacherid = "";
			String teachername = "";
			String teachersex = "";
			String teacherphone = "";
			try {
				jsonObject = new JSONObject(json);
				teacherid = jsonObject.getString("teacherid");
				teachername = jsonObject.getString("teachername");
				teachersex = jsonObject.getString("teachersex");
				teacherphone = jsonObject.getString("teacherphone");
				this.teacherService.reflashTeacher(teacherid,teachername,teachersex,teacherphone);
				response.getWriter().print("\"teacherid\":" + teacherid + "}");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if("updateExamforDB".equals(op)) {
			/*修改试题信息*/
			int examid = Integer.parseInt(request.getParameter("examid"));
			int courseid = Integer.parseInt(request.getParameter("update_kecheng"));
			String chapter = request.getParameter("update_zhangjie");
			String content = request.getParameter("update_shitineirong_name");
			float degree = Float.parseFloat(request.getParameter("update_nandu"));
			String kind = request.getParameter("update_leixing");
			double score = Double.parseDouble(request.getParameter("update_fenzhi"));
			String anwser = request.getParameter("update_shiti_daan");
			
			Exam e = new Exam();
			e.setExamId(examid);
			e.setCourseId(courseid);
			e.setExamAnwser(anwser);
			e.setExamChapter(chapter);
			e.setExamContent(content);
			e.setExamDegree(degree);
			e.setExamKind(kind);
			e.setExamScore(score);
			this.examService.updateExam(e);
			response.sendRedirect("examServlet");
		} else if("addParten".equals(op)){
				String partenName = request.getParameter("partenName");
				String ok = this.examService.addParten(partenName);
				if("ok".equals(ok)) {
					response.getWriter().print("ok");
				} else {
					response.getWriter().print("error");
				}
		} else {
			getServletContext().getRequestDispatcher("/test.jsp").forward(request, response);
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






















