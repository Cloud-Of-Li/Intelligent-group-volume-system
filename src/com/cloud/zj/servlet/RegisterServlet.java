package com.cloud.zj.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		String name = request.getParameter("name");
		String number = request.getParameter("number");
		String password = request.getParameter("password");
		String sex = request.getParameter("selector1");
		
		registerService.registeUser(name, number, password, sex);
		
		
		response.sendRedirect("/zujuanxitong/login.html");
		
	}
	
	

}
