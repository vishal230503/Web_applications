//GetCapitalServlet.java
package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GetCapitalServlet extends HttpServlet {
	
	@Override
	public  void doPost(HttpServletRequest req, 
			                                      HttpServletResponse res) throws ServletException, IOException {
		//get PrintWriter stream
		PrintWriter pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//read form data
		 int  countryIndex=Integer.parseInt(req.getParameter("country"));
		 //write b.logic 
		 String  countries[]=new String[] {"NewDelhi","Islamabad","Bejing","WashingtonDC","London","Paris"};
		 pw.println("<h1 style='color:red;text-align:center'>The Capital City name is :: "+countries[countryIndex]+"</h1>");
		 
		 //add home hyperlink
		 pw.println("<h1 style='text-align:center'><a href='input.html'>home </a></h1>");
		 
		 //close stream
		 pw.close();
	}  //doPost(-,-)

}//class
