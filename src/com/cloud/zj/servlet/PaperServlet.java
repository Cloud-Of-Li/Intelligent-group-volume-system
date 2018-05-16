package com.cloud.zj.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cloud.zj.entity.Course;
import com.cloud.zj.entity.Exam;
import com.cloud.zj.generation.Paper;
import com.cloud.zj.service.CourseService;
import com.cloud.zj.service.ExamService;
import com.cloud.zj.service.PaperService;

@WebServlet("/paperServlet")
public class PaperServlet extends HttpServlet {
	
	private PaperService paperService;
	private ExamService examService;
	private CourseService courseService;

	public PaperServlet() {
		// TODO Auto-generated constructor stub
		paperService = new PaperService();
		examService = new ExamService();
		courseService = new CourseService();
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
			String coursestr = request.getParameter("paperName").substring(0, request.getParameter("paperName").indexOf("-"));
			course = this.courseService.getCourseByName(coursestr);
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
		
		Map<String, List<Exam>> paper_examMap = this.examService.makeAMap(paper);
		Map<String, Integer> p_scMap = this.examService.scMap(paper); 
		
		/*for (Entry<String, List<Exam>> entry : paper_examMap.entrySet()) {  
			   String key = entry.getKey().toString();  
			   List<Exam> value = entry.getValue();
			   for(Exam e : value) {
				   System.out.println("key=" + key + " value=" + e.getExamId());  
			   }
		}  */
		
		
		
		request.setAttribute("xuliehao", xuliehao);
		
		
		request.setAttribute("paper", paper);
		request.setAttribute("paper_examMap", paper_examMap);
		request.setAttribute("p_scMap", p_scMap);
		
		String op = request.getParameter("op");

		if("paper4manager".equals(op)) {
			request.getRequestDispatcher("/mexamServlet").forward(request, response);
		} else if("paper".equals(op)) {
			request.getRequestDispatcher("/examServlet").forward(request, response);
		}
	}
	
}
