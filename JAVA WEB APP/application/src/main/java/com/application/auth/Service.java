package com.application.auth;

import java.io.IOException;
import java.io.PrintWriter;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/auth")
public class Service extends HttpServlet {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
protected void doGet(HttpServletRequest req , HttpServletResponse res) throws IOException {
	PrintWriter out = res.getWriter();
	try {
		System.out.println("service.java");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		RequestDispatcher rd;
		HttpSession session=req.getSession();  
		System.out.println("auth req");
		if(username != null && password != null) {
			System.out.println("username and password received success");
			if(new Action().verify(username,password)){
				session.setAttribute("sessionKey","1234");  //-------> created session key from database from log
				System.out.println("username and password verified");
				rd=req.getRequestDispatcher("jsp/userDashboard.jsp");  
				rd.forward(req, res);  
			}else {
				System.out.println("username and password verification failed");
				rd=req.getRequestDispatcher("jsp/signup.jsp");  
				rd.forward(req, res);  
			}
		}else {
			rd=req.getRequestDispatcher("jsp/signin.jsp");  
			rd.forward(req, res);  
		}
		System.out.println("started");
		
	}catch(Exception ex) {
		out.println(ex.toString());
	}
	}
protected void doPost(HttpServletRequest req , HttpServletResponse res) throws IOException {
	doGet(req,res);
}
}
