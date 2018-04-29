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

import com.cloud.zj.entity.Manager;
import com.cloud.zj.service.ManagerService;
import com.cloud.zj.service.TeacherService;

@WebServlet("/managerServlet")
public class ManagerServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TeacherService teacherService;
	private ManagerService managerService;
	
	
	public ManagerServlet() {
		super();
		managerService = new ManagerService();
		teacherService = new TeacherService();
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
			String managerName = "";
			String managerPassword = "";
			
			try {
				managerName = jsonObject.getString("managerName");
				managerPassword = jsonObject.getString("managerPassword");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Manager manager = new Manager();
			manager.setManagerName(managerName);
			manager.setManagerPassword(managerPassword);
			
			boolean managerLogin = false;
			
			if(managerName != null && !managerName.equals("")) {
				if(managerPassword != null && !managerPassword.equals("")) {
					managerLogin = this.teacherService.login(manager);
				}
			}
			
			if( managerLogin == true) {
				manager = this.managerService.getManagerByManagerName(managerName);
				HttpSession session = request.getSession();
				session.setAttribute("manager", manager);
				response.getWriter().print("/mexamServlet");
			} else
				response.getWriter().print("error");
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
