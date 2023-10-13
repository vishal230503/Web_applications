//SearchServlet.java
package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/searchurl")
public class SearchServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 //get PrintWriter
		 PrintWriter pw=res.getWriter();
		 //set response content type
		 res.setContentType("text/html");
		 //read form data
		 String ss=req.getParameter("ss");
		 String engg=req.getParameter("sengg");
		 
		 //genernate hyperlink in the response for send redirection
		 String url=null;
		 if(engg.equalsIgnoreCase("google"))
			 url="https://www.google.com/search?q="+ss;
		 else if(engg.equalsIgnoreCase("bing"))
			 url="https://www.bing.com/search?q="+ss;
		 else 
			 url="https://in.search.yahoo.com/search?p="+ss;
		 
		 //perform  send Redirection
		 System.out.println("Before --->SearchServlet.doGet()");
		  res.sendRedirect(url);
		  System.out.println("After --->SearchServlet.doGet()");
		 
		 //close stream
		 pw.close();
	
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}//method

}//class
