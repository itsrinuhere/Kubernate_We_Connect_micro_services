package com.application.auth;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/userdashboard")
public class Dashboard extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest req , HttpServletResponse res) throws IOException, ServletException{
		HttpSession session=req.getSession();  
		req.getSession(true);
		RequestDispatcher rd;
		System.out.println("Dashboard page Envoked");
		String key = (String) session.getAttribute("sessionKey");
		if(key!=null && key.equals(Action.key())) {
			rd=req.getRequestDispatcher("jsp/userDashboard.jsp");  
			rd.forward(req, res); 
		}else {
			rd=req.getRequestDispatcher("index.jsp");  
			rd.forward(req, res); 
		}
		
	}
	protected void doGet(HttpServletRequest req , HttpServletResponse res) throws IOException, ServletException 
	{
		doPost(req,res);
	}
	
}
