package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/lcurl")
public class LCTestServlet extends HttpServlet {
	
	static {
		System.out.println("LCTestServlet::static block");
	}
	public LCTestServlet() {
		System.out.println("LCTestServlet::0-param constructor");
	}
	public void init(ServletConfig cg) {
		System.out.println("LCTestServlet:init(-)method");
	}
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("LCTestServlet.service(-,-)");
		
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		Date date=new Date();
		pw.println("<h1 style='color:red;text-align:center'>Date and Time ::"+date+"<h1>");
		
		pw.close();
	}
	
	@Override
	public void destroy() {
		System.out.println("LCTestServlet.destroy()");
	}

}
