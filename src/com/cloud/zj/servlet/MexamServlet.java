package com.cloud.zj.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cloud.zj.entity.Course;
import com.cloud.zj.entity.Teacher;
import com.cloud.zj.generation.Paper;
import com.cloud.zj.service.CourseService;
import com.cloud.zj.service.ExamService;
import com.cloud.zj.service.PaperService;
import com.cloud.zj.service.TeacherService;

@WebServlet("/mexamServlet")
public class MexamServlet extends HttpServlet {

	private ExamService examService;
	private TeacherService teacherService;
	private PaperService paperService;
	private CourseService courseService;

	public MexamServlet() {
		examService = new ExamService();
		teacherService = new TeacherService();
		paperService = new PaperService();
		courseService = new CourseService();
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

		List<Teacher> teacherlist = this.teacherService.getAllTeacher();
		List<Paper> paperList = this.paperService.getAllPaper();
		
		Map<Integer, List<Course>> courseMap = this.courseService.getCourseByTList(teacherlist);
		
		
		request.setAttribute("teacherlist", teacherlist);
		request.setAttribute("courseMap", courseMap);
		request.setAttribute("paperList", paperList);

		String op = request.getParameter("op");
		
		getServletContext().getRequestDispatcher("/manager.jsp").forward(request, response);
		/*if ("add".equals(op)) {
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
		} else if ("list".equals(op)) {
			List<Exam> danxuan_exam = this.examService.findExamByCourseIdAndExamKind(course.getCourseId(), "单选题");
			List<Exam> duoxuan_exam = this.examService.findExamByCourseIdAndExamKind(course.getCourseId(), "多选题");
			List<Exam> panduan_exam = this.examService.findExamByCourseIdAndExamKind(course.getCourseId(), "判断题");
			List<Exam> tiankong_exam = this.examService.findExamByCourseIdAndExamKind(course.getCourseId(), "填空题");
			List<Exam> jianda_exam = this.examService.findExamByCourseIdAndExamKind(course.getCourseId(), "简答题");
			List<Paper> paperList = this.examService.findPaperByCourserId(course.getCourseId());
			request.setAttribute("danxuan_exam", danxuan_exam);
			request.setAttribute("duoxuan_exam", duoxuan_exam);
			request.setAttribute("panduan_exam", panduan_exam);
			request.setAttribute("tiankong_exam", tiankong_exam);
			request.setAttribute("jianda_exam", jianda_exam);
			request.setAttribute("paperList", paperList);
			getServletContext().getRequestDispatcher("/test.jsp").forward(request, response);
		}*/
	}
}
