package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/showurl")
public class ShowCookiesServlet extends HttpServlet {
	
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    //get PrintWriter
		 PrintWriter pw=res.getWriter();
		 //set response content type
		 res.setContentType("text/html");
		 //read all the cookies
		  Cookie cks[]=req.getCookies();
		  if(cks!=null) {
			  pw.println("<h1 style='color:red;text-align:center'> The cookies are </h1>");
		     pw.println("<table border='1' align='center'>");
		     for(Cookie ck:cks) {
		       pw.println("<tr><td>"+ck.getName()+"</td><td>"+ck.getValue()+"</td></tr>");
		     }
		     pw.println("</table>");
		  }//if
		  else {
			    pw.println("<h1 style='color:red;text-align:center'>No Cookies  present </h1>");
		  }
		  
			   //close stream
		  pw.close();
		 
	}
	
	@Override
	public  void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
	}

}
