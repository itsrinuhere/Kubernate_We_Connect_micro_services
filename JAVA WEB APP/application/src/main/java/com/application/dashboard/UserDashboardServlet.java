package com.application.dashboard;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/admin")
public class UserDashboardServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest req , HttpServletResponse res) throws IOException, ServletException {
		RequestDispatcher rd;
		HttpSession session=req.getSession();  
		rd=req.getRequestDispatcher("jsp/AdminDashboard.jsp");  
		rd.forward(req, res);  
	
	}
	protected void doPost(HttpServletRequest req , HttpServletResponse res) throws IOException, ServletException {
		doGet(req,res);
	}
}
