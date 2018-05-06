package com.cloud.zj.servlet;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.cloud.zj.service.RegisterService;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {

	private RegisterService registerService;
	
	
	
	public RegisterServlet() {
		registerService  = new RegisterService();
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
		request.setCharacterEncoding("utf-8");
		
		
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
		
		if("changepsw".equals(op)) {
			String teacherName = "";
			String teacherPassword = "";
			String identity = "";
			String phone = "";
			try {
				teacherName = jsonObject.getString("teacherName");
				teacherPassword = jsonObject.getString("teacherPassword");
				identity = jsonObject.getString("identity");
				phone = jsonObject.getString("phone");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(teacherName == "" || teacherPassword == "" || identity == "" || phone == "") {
				response.getWriter().print("id_error");
				return;
			} else {
				System.out.println(this.registerService.comfirmAndChangpsw(teacherName, teacherPassword, identity, phone));
				response.getWriter().print(this.registerService.comfirmAndChangpsw(teacherName, teacherPassword, identity, phone));
				
			}
		} else {
			String name = request.getParameter("name");
			String number = request.getParameter("number");
			String password = request.getParameter("password");
			String sex = request.getParameter("selector1");
			registerService.registeUser(name, number, password, sex);
			response.sendRedirect("/zujuanxitong/login.html");
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
