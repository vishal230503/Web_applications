//SecondServlet.java
package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet {
	
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 //get PrintWriter
		PrintWriter pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		
		//read form2/req2 data
		 String  f2val1=req.getParameter("f2t1");
		 String f2val2=req.getParameter("f2t2");
		
		//read form1/req1  data  from the from Session attributes by accessing the Session object
		  HttpSession  ses=req.getSession(false);
		  String name=(String)ses.getAttribute("name");
		  String addrs=(String)ses.getAttribute("addrs");
		  int age=(Integer)ses.getAttribute("age");
		  String ms=(String)ses.getAttribute("ms");
		  
		
		 
		 // Generate the dynamic webpage displaying  form1/req1 data and form2/req2 data
		  pw.println("<h1 style='color:red;text-align:center'>Form1/req1 data  ::"+name+"..."+addrs+"..."+age+"... "+ms+"</h1>");
		  pw.println("<h1 style='color:red;text-align:center'>Form2/req2 data  ::"+f2val1+"..."+f2val2+"</h1>");
		  
		  
		  pw.println("<br> <b> Session id  is  ::"+ses.getId()+"</b>");
		  //invlidate the Session
		  ses.invalidate();
		  
		  // here we can write jdbc  code to insert both forms data as record in db table
		  
		  //add home hyperlink
		  pw.println("<br> <a href='person_details.html'>home </a>");
		  
		  //close the stream
		  pw.close();
		  
		
	}//doGet(-,-)
	
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}//doPost(-,-)

}//class
