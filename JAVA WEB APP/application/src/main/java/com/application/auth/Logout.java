package com.application.auth;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/logout")
public class Logout extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest req , HttpServletResponse res) throws IOException, ServletException 
	{
		System.out.println("logout.class");
		HttpSession session=req.getSession();  
		session.removeAttribute("sessionKey");
		RequestDispatcher rd;
		System.out.println("logging out");
		rd=req.getRequestDispatcher("index.jsp");  
		rd.forward(req, res);  
	}
	protected void doGet(HttpServletRequest req , HttpServletResponse res) throws IOException, ServletException 
	{
	doPost(req,res);
	}
}
