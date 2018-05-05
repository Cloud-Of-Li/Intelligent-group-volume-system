package com.cloud.zj.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.cloud.zj.entity.Course;
import com.cloud.zj.entity.Exam;
import com.cloud.zj.entity.Major;
import com.cloud.zj.entity.Teacher;
import com.cloud.zj.generation.Paper;
import com.cloud.zj.service.CourseService;
import com.cloud.zj.service.ExamService;
import com.cloud.zj.service.MajorService;
import com.cloud.zj.service.PaperService;
import com.cloud.zj.service.TeacherService;

@WebServlet("/mexamServlet")
public class MexamServlet extends HttpServlet {

	private ExamService examService;
	private TeacherService teacherService;
	private PaperService paperService;
	private CourseService courseService;
	private MajorService majorService;

	public MexamServlet() {
		examService = new ExamService();
		teacherService = new TeacherService();
		paperService = new PaperService();
		courseService = new CourseService();
		majorService = new MajorService();
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
		List<Course> courselist = this.courseService.getAllCourse();
		List<Major> majorall = this.majorService.getAllmajor();
		Map<Integer, List<Course>> courseMap = this.courseService.getCourseByTList(teacherlist);
		/*Iterator<Integer> it = courseMap.keySet().iterator();
		while(it.hasNext()) {
			Integer key = it.next();
			System.out.print("Teacherid：" + key + ",");
			List<Course> list = courseMap.get(key);
			for(Course c: list) {
				System.out.print(c + "   ");
			}
			System.out.println();
		}
		*/
		
		List<Major> majorlist = new ArrayList<>();
		for (Teacher t : teacherlist) {
			majorlist.add(this.majorService.getMajorById(t.getMajorid()));
		}
		request.setAttribute("teacherlist", teacherlist);
		request.setAttribute("majorlist",  majorlist);
		request.setAttribute("majorall",  majorall);
		request.setAttribute("courseMap", courseMap);
		request.setAttribute("paperList", paperList);
		request.setAttribute("courselist", courselist);
		String op = request.getParameter("op");
		if ("search".equals(op)) {
			String leixing = request.getParameter("leixing");
			String xinxi = request.getParameter("search");
			String xingshi = request.getParameter("xingshi");
			String coursestr = request.getParameter("kecheng");
			
			Course course = this.courseService.getCourseByName(coursestr);
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
			getServletContext().getRequestDispatcher("/manager.jsp").forward(request, response);
		} else if ("list".equals(op)) {
			String coursestr = request.getParameter("kecheng");
			Course course = this.courseService.getCourseByName(coursestr);
			if(course == null){
				course = this.courseService.getCourseByName("离散数学");
			}
			List<Exam> danxuan_exam = this.examService.findExamByCourseIdAndExamKind(course.getCourseId(), "单选题");
			List<Exam> duoxuan_exam = this.examService.findExamByCourseIdAndExamKind(course.getCourseId(), "多选题");
			List<Exam> panduan_exam = this.examService.findExamByCourseIdAndExamKind(course.getCourseId(), "判断题");
			List<Exam> tiankong_exam = this.examService.findExamByCourseIdAndExamKind(course.getCourseId(), "填空题");
			List<Exam> jianda_exam = this.examService.findExamByCourseIdAndExamKind(course.getCourseId(), "简答题");
			request.setAttribute("danxuan_exam", danxuan_exam);
			request.setAttribute("duoxuan_exam", duoxuan_exam);
			request.setAttribute("panduan_exam", panduan_exam);
			request.setAttribute("tiankong_exam", tiankong_exam);
			request.setAttribute("jianda_exam", jianda_exam);
			getServletContext().getRequestDispatcher("/manager.jsp").forward(request, response);
		} else if ("add".equals(op)) {
			String coursestr = request.getParameter("add_kecheng");
			Course course = this.courseService.getCourseByName(coursestr);
			if(course == null){
				course = this.courseService.getCourseByName("离散数学");
			}
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
			response.sendRedirect("mexamServlet");
		} else if ("delete".equals(op)) {
			int teacherid = Integer.parseInt(request.getParameter("teacherid"));
			this.teacherService.putOutTeacher(teacherid);
			response.sendRedirect("mexamServlet");
		}  else if ("update".equals(op)) {
			
			String json = readJSONString(request);
			JSONObject jsonObject = null;
			
			String teacherid = "";
			String teachername = "";
			String teachersex = "";
			String teacherphone = "";
			String techercourse = "";
			String teachermajorid = "";
			
			try {
				jsonObject = new JSONObject(json);
				teacherid = jsonObject.getString("teacherid");
				teachername = jsonObject.getString("teachername");
				teachersex = jsonObject.getString("teachersex");
				teacherphone = jsonObject.getString("teacherphone");
				techercourse = jsonObject.getString("techercourse");
				teachermajorid = jsonObject.getString("teachermajorid");
				
			/*	System.out.println(teacherid);
				System.out.println(teachername);
				System.out.println(teachersex);
				System.out.println(teacherphone);
				System.out.println(techercourse);
				System.out.println(teachermajorid);
				*/
				this.teacherService.reflashTeacher(teacherid,teachername,teachersex,teacherphone,teachermajorid);
				this.teacherService.reflashT4C(teacherid,techercourse);
				
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			response.sendRedirect("mexamServlet");
		} else {
			getServletContext().getRequestDispatcher("/manager.jsp").forward(request, response);
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



























