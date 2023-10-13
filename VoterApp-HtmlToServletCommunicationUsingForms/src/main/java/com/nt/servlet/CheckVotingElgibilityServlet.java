//CheckVotingElgibilityServlet.java
package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CheckVotingElgibilityServlet extends HttpServlet {
	
	@Override
	public  void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("CheckVotingElgibilityServlet.doPost(-,-)");
		//get PrintWriter stream  from res obj
		PrintWriter pw=res.getWriter();
		//set response Content Type
		res.setContentType("text/html");
		//read form  data  as req param values
		 String name=req.getParameter("pname");
		 String  addrs=req.getParameter("paddrs");
		 String  tage=req.getParameter("page");
		 int age=Integer.parseInt(tage);
		 //write the b.logic
		 if(age>=18)
			  pw.println("<h1 style='color:green;text-align:center'>Mr/Miss/Mrs."+name +" of "+addrs+" u  r eligible for Voting</h1>");
		 else
			  pw.println("<h1 style='color:red;text-align:center'>Mr/Miss/Mrs."+name +" of "+addrs+" u  r not eligible for Voting</h1>");
		
		 //add home hyperlink (graphical link)
		   pw.println("<center><a  href='input.html'><img   src='images/home.jfif' height='60px' width='40px'></a></center>");
		
		    //clsoe the stream
		   pw.close();
	}
	
	@Override
	public  void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("CheckVotingElgibilityServlet.doGet(-,-)");
		//get PrintWriter stream  from res obj
				PrintWriter pw=res.getWriter();
				//set response Content Type
				res.setContentType("text/html");
			//write  the output to browser
				 pw.println("<h1 style='color:red;text-align:center'> Date and Time is ::"+new java.util.Date()+"</h1>");
				 
				 //add home hyperlink (graphical link)
				   pw.println("<center><a  href='input.html'><img   src='images/home.jfif' height='60px' width='40px'></a></center>");
		   //close stream
				  pw.close();
		
	}

}
