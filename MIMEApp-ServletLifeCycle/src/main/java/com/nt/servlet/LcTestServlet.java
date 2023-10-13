//LcTestServlet.java
package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LcTestServlet extends HttpServlet {
	
	static {
		System.out.println("LcTestServlet:: static block");
	}
	
	public LcTestServlet() {
		System.out.println("LcTestServlet:: 0-param constructor");
	}
	
	
	/*public void init() {
		System.out.println("LcTestServlet::init()");
	}*/
	
/*	public void init(ServletConfig cg) {
		System.out.println("LcTestServlet: init(-) method");
		   System.out.println("p1 init param value::"+cg.getInitParameter("p1"));
		   System.out.println("p2 init param value::"+cg.getInitParameter("p2"));
		   
	}*/
	
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		System.out.println("LcTestServlet.doGet(-,-)::");
		  //get PrintWriter 
		 PrintWriter pw=res.getWriter();
		   //set response content type
		   res.setContentType("text/html");
		   
		   // write b.logic
		     Date  date=new Date();
		     //write the output to response object
		     pw.println("<h1 style='color:green;text-align:center'>Date and Time ::"+date+"</h1>");
		     
		     //close the stream
		     pw.close();
		
	}
	
	@Override
	public void destroy() {
		  System.out.println("LcTestServlet.destroy()");
	}

}
