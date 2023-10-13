// FirstServlet.java
package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/firsturl")
public class FirstServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get PrintWriter object
		 PrintWriter pw=res.getWriter();
		 //set response content type
		 res.setContentType("text/html");
		 //read form1/req1 data
		  String name=req.getParameter("pname");
		  String  addrs=req.getParameter("paddrs");
		  int age=Integer.parseInt(req.getParameter("page"));
		  String ms=req.getParameter("ms");
		  //generate form2 dynamically  based on the given marital status
		  if(ms.equalsIgnoreCase("single")) {
			  pw.println("<h1 style='color:red;text-align:center'> Enter Bachelor life  details </h1>");
			  pw.println("<form action='secondurl' method='post'>");
			  pw.println("<table align='center' bgcolor='cyan'>");
			  pw.println(" <tr><td>   when do u want to marry ?</td> <td><input type='text' name='f2t1'> </td> </tr>");
			  pw.println(" <tr><td>   why do u want to marry ?</td> <td><input type='text' name='f2t2'> </td> </tr>");
			  pw.println("<tr><td cospan='2'><input type='submit' value='submit'> </td></tr>");
			  pw.println("</table>");
			  pw.println("</form>");
		  }
		  else {
			  pw.println("<h1 style='color:red;text-align:center'> Enter Married life  details </h1>");
			  pw.println("<form action='secondurl' method='post'>");
			  pw.println("<table align='center' bgcolor='cyan'>");
			  pw.println(" <tr><td> Spouse name ::</td> <td><input type='text' name='f2t1'> </td> </tr>");
			  pw.println(" <tr><td>  No.of kids ::</td> <td><input type='text' name='f2t2'> </td> </tr>");
			  pw.println("<tr><td cospan='2'><input type='submit' value='submit'> </td></tr>");
			  pw.println("</table>");
			  pw.println("</form>");
		  }
		  
		  //close stream 
		  pw.close();
		  
		
	}//doGet(-,-)
	
	@Override
	public  void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	   doGet(req,res);
	}//doPost(-,-)

}//class
