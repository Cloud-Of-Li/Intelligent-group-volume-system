package com.cloud.zj.servlet;

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
import com.cloud.zj.generation.Paper;
import com.cloud.zj.service.ExamService;
import com.cloud.zj.service.PaperService;

@WebServlet("/paperServlet")
public class PaperServlet extends HttpServlet {
	
	private PaperService paperService;
	private ExamService examService;
	

	public PaperServlet() {
		// TODO Auto-generated constructor stub
		paperService = new PaperService();
		examService = new ExamService();
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
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
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
		List<Paper> paperList = this.examService.findPaperByCourserId(course.getCourseId());
		List<String> xuliehao = this.examService.setSequence(); 
		
		request.setAttribute("danxuan_exam", danxuan_exam);
		request.setAttribute("duoxuan_exam", duoxuan_exam);
		request.setAttribute("panduan_exam", panduan_exam);
		request.setAttribute("tiankong_exam", tiankong_exam);
		request.setAttribute("jianda_exam", jianda_exam);
		request.setAttribute("paperList", paperList);
		

		String paperName = request.getParameter("paperName");
		System.out.println("paperName:" +paperName);
		Paper paper = this.paperService.getPaperByPaperName(paperName);
		System.out.println(paper.getId());
		List<Exam> paper_danxuan_exam = this.examService.getExamListByExamKindAndPaper(paper, "单选题");
		List<Exam> paper_duoxuan_exam = this.examService.getExamListByExamKindAndPaper(paper, "多选题");
		List<Exam> paper_pandaunxuan_exam = this.examService.getExamListByExamKindAndPaper(paper, "判断题");
		List<Exam> paper_tiankong_exam = this.examService.getExamListByExamKindAndPaper(paper, "填空题");
		List<Exam> paper_jianda_exam = this.examService.getExamListByExamKindAndPaper(paper, "简答题");
		
		request.setAttribute("singleScore", paper.getSingleScore());
		System.out.println("单选题分数：" + paper.getSingleScore());
		request.setAttribute("multiScore", paper.getMultiScore());
		request.setAttribute("completeScore", paper.getCompeleteScore());
		request.setAttribute("tfScore", paper.getTfScore());
		request.setAttribute("subjectScore", paper.getSubjectScore());
		request.setAttribute("xuliehao", xuliehao);
		
		request.setAttribute("paper_danxuan_exam", paper_danxuan_exam);
		request.setAttribute("paper_duoxuan_exam", paper_duoxuan_exam);
		request.setAttribute("paper_pandaunxuan_exam", paper_pandaunxuan_exam);
		request.setAttribute("paper_tiankong_exam", paper_tiankong_exam);
		request.setAttribute("paper_jianda_exam", paper_jianda_exam);
		
		request.setAttribute("paper", paper);
		request.getRequestDispatcher("/test.jsp").forward(request, response);
			
		}
		
	
}
