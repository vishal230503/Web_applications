//CreateCookiesServlet.java
package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/createurl")
public class CreateCookiesServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get PrintWriter object
		PrintWriter pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		// create  Cookies
		   // InMemory Cookies
		Cookie ck1=new Cookie("ap","no-capital");
		Cookie ck2=new Cookie("TG","hyd");
		  // Persistent  Cookies
		Cookie ck3=new Cookie("MH","mumbai");
		 ck3.setMaxAge(120);  //2 mins
		Cookie ck4=new Cookie("MP","bhopal");
		ck4.setMaxAge(60);   // 1 min
		//add these cookies  to response
		res.addCookie(ck1); res.addCookie(ck2);
		res.addCookie(ck3); res.addCookie(ck4);
		
		pw.println("<h1 style='color:red;text-align:center'> Cookies are added to  the response </h1>");
		
		//close stream
		pw.close();
		
	
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  doGet(req,res);
	}
	
}
