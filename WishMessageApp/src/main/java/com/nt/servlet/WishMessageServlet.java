//WishMessageServlet.java
package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class WishMessageServlet extends HttpServlet {
	 
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		LocalDateTime ldt=LocalDateTime.now();
		
		int hour=ldt.getHour();
		if(hour<12) {
			pw.println("<h1 style='color:orange;text-align:center'>Good Morning</h1>");
		}
		else if(hour<16) {
			pw.println("<h1 style='color:red;text-align:center'>Good Afternoon</h1>");
		}
		else if(hour<20) {
			pw.println("<h1 style='color:pink;text-align:center'>Good Evening</h1>");
		}
		else {
			pw.println("<h1 style='color:blue;text-align:center'>Good Night</h1>");
		}
		
		pw.println("<br><a href='http://localhost:3030/WishMessageApp/page.html'>home</a>");
		
		pw.close();
	}
	
}
