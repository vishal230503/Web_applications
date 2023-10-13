package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/s1url")
public class Servlet1 extends HttpServlet {
	

	
	public  void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		//get PrintWriter 
		PrintWriter pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		
		//create request attributes
		req.setAttribute("attr1", "val1");
		//create Session attributes
		 HttpSession ses=req.getSession();
		 ses.setAttribute("attr2", "val2");
		 //create  ServletContext or application attribute
		  ServletContext sc=getServletContext();
		  sc.setAttribute("attr3", "val3");
		  
		 
		
		//forward request to  Servlet2 web comp
		RequestDispatcher rd=req.getRequestDispatcher("/s2url");
		rd.forward(req, res);
		
		
	}


	public  void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
