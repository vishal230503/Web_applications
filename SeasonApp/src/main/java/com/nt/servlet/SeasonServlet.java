package com.nt.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Month;
import java.time.MonthDay;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SeasonServlet extends HttpServlet {
	
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		MonthDay md=MonthDay.now();
		int month=md.getMonthValue();
		
		if(month<5) {
			pw.println("<h1 style='color:red;text-align:center'>Summar Season</h1>");
		}
		else if(month<9) {
			pw.println("<h1 style='color:blue;text-align:center'>Rain Season</h1>");
		}
		else {
			pw.println("<h1 style='color:yellow;text-align:center'>Winter Season</h1>");
		}
		
		pw.println("<br><a href='http://localhost:3030/SeasonApp/page.html'>home</a>");
		
		pw.close();
		
	}
	
}
