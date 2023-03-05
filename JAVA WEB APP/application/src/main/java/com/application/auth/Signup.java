package com.application.auth;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/signup")
@MultipartConfig(maxFileSize = 16177215) //size up to 16 MB
public class Signup extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest req , HttpServletResponse res) throws IOException, ServletException 
	{
	System.out.println("Sign up");
	}
	protected void doGet(HttpServletRequest req , HttpServletResponse res) throws IOException, ServletException 
	{
		doPost(req,res);
	
	}
	
}
