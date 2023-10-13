//ArithmeticServlet.java
package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ArithmeticServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get PrintWriter
		PrintWriter pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		// read addtional req param value
		String s1Val=req.getParameter("s1");
		//read text box values  and convert them floating point values when the submit buttons are clicked
		float val1=0.0f, val2=0.0f;
		if(!s1Val.equalsIgnoreCase("link1") && !s1Val.equalsIgnoreCase("link2")) {
			  val1=Float.parseFloat(req.getParameter("t1"));
			  val2=Float.parseFloat(req.getParameter("t2"));
		}
		
		//get System Date and Time
		 LocalDateTime ldt=LocalDateTime.now();
		//differentiate the logic for multiple submit Buttons and hyperlinks
		 if(s1Val.equalsIgnoreCase("add")) {
			 pw.println("<h1 style='color:green;text-align:center'> Addtion ::"+(val1+val2)+"</h1>");
		 }
		 else if(s1Val.equalsIgnoreCase("sub")) {
			 pw.println("<h1 style='color:green;text-align:center'> SubStraction ::"+(val1-val2)+"</h1>");
		 }
		 else if(s1Val.equalsIgnoreCase("mul")) {
			 pw.println("<h1 style='color:green;text-align:center'> Multiplication ::"+(val1*val2)+"</h1>");
		 }
		 else if(s1Val.equalsIgnoreCase("div")) {
			 pw.println("<h1 style='color:green;text-align:center'> Division ::"+(val1/val2)+"</h1>");
		 }
		 else if(s1Val.equalsIgnoreCase("link1")) {
			 //get  current hour of  the day
			  int hour=ldt.getHour();
			  if(hour<12)
				  pw.println("<h1 style='color:orange;text-align:center'> Good Morning</h1>");
			  else if(hour<16)
				  pw.println("<h1 style='color:red;text-align:center'> Good Afternoon</h1>");
			  else if(hour<20)
				  pw.println("<h1 style='color:pink;text-align:center'> Good Evening</h1>");
			  else 
				  pw.println("<h1 style='color:grey;text-align:center'> Good Night</h1>");
		 }
		 else {
			 // get current month
			 int month=ldt.getMonthValue();
			 
			  if(month>=3 && month<=6)
				  pw.println("<h1 style='color:red;text-align:center'> Summer Season</h1>");
			  else if(month>=7 && month<=10)
				  pw.println("<h1 style='color:blue;text-align:center'> Rainy Season</h1>");
			  else
				  pw.println("<h1 style='color:green;text-align:center'> winter Season</h1>");
		 }
		//add home hyperlink
		  pw.println("<br> <br>  <a href='input.html'> home </a>");
		 
			//close stream
		  pw.close();
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		   doGet(req, res);
	}

}
