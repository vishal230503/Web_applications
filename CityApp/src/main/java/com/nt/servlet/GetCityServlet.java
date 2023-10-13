package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GetCityServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		int cityIndex=Integer.parseInt(req.getParameter("City"));
		int cityIndex1=Integer.parseInt(req.getParameter("city"));
		String cities[][]=new String[][] {{"India","Pakistan","China"},{"America","Srilanka","Bangladesh"}};
		
		pw.println("<h1 style='color:red;text-align:center'>The Cities Country name:: "+cities[cityIndex]+"</h1>");
		
		pw.println("<a href='input.html'>home</a>");
		
		pw.close();
	}
	
}
