package com.nt.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/s2url")
public class Servlet2 extends HttpServlet {
	

	
	public  void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		//get PrintWriter 
		PrintWriter pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		
		//display request attribute values
		pw.println("<b>Servlet2:: attr1(req scope) attribute value:: "+req.getAttribute("attr1")+"</b>");
		// display session attribute values 
		 HttpSession ses=req.getSession();
			pw.println("<br><b>Servlet2:: attr2(session scope) attribute value:: "+ses.getAttribute("attr2")+"</b>");
		//display  ServletContext attribute values
			ServletContext sc=getServletContext();
			pw.println("<br><b>Servlet2:: attr3(application scope) attribute value:: "+sc.getAttribute("attr3")+"</b>");

			
		
		
		//forward request to  Servlet3 web comp
		RequestDispatcher rd=req.getRequestDispatcher("/s3url");
		rd.forward(req, res);
		
		
	}


	public  void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
