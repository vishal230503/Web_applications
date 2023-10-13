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
		 if(engg.equalsIgnoreCase("google"))
			 pw.println("<h1> <a href='https://www.google.com/search?q="+ss+"'> click here for Google Search </a> </h1> ");
		 else if(engg.equalsIgnoreCase("bing"))
			 pw.println("<h1> <a href='https://www.bing.com/search?q="+ss+"'> click here for Bing Search </a> </h1> ");
		 else 
			 pw.println("<h1> <a href=https://in.search.yahoo.com/search?p="+ss+"'> click here for yahoo Search </a> </h1> ");
		 
		 //close stream
		 pw.close();
	
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}

}
