package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class VotingElgibilityCheckServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		String name=req.getParameter("pname");
		String addrs=req.getParameter("paddrs");
		int age=Integer.parseInt(req.getParameter("page"));
		
		if(age>=18) {
			pw.println("<h1 style='color:green;text-align:center'>Mr/Miss/Mrs."+name+" u r eligible for Voting</h1>");
		}
		else {
			pw.println("<h1 style='color:red;text-align:center'>Mr/Miss/Mrs."+name+" u r not eligible for Voting</h1>");
			
		}
		
		pw.println("<a href='input.html'><img src='images/home.jpg' width='50' height='50'></a>");
		
		pw.close();
		
	}
	
}
