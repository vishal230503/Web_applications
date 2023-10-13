//HtmlServlet.java
package com.nt.servlet;

import  jakarta.servlet.*;
import  jakarta.servlet.http.*;
import  java.io.*;

public   class  HtmlServlet extends HttpServlet{
	
	static {
		System.out.println("HtmlServlet::static block");
	}
	
	public HtmlServlet() {
		System.out.println("HtmlServlet:: 0-param constructor)");
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		 System.out.println("HtmlServlet: init(-) ");
		}

    //2nd  service(-,-) method overriding
	public void service(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException{
		System.out.println("HtmlServlet.service(-,-)");
             //set response content type
			   res.setContentType("text/html");
			   //get PrintWriter stream
			   PrintWriter pw=res.getWriter();
			   //display the content as db table
			   pw.println("<table align='center' border='1'  bgcolor='pink'>");
			   pw.println("<tr><th>TeamName </th>  <th> year </th> <th> place </th></tr>");
                pw.println("<tr><td>  India </td>  <td> 2007 </td> <td> South Africa </td></tr>");
			    pw.println("<tr><td>  Pakistan </td>  <td> 2009 </td>   <td> England</td></tr>");
    			 pw.println("<tr><td>  England </td>  <td> 2010 </td> <td> WestIndies  </td></tr>");
			    pw.println("<tr><td>  WestWindies </td>  <td> 2012 </td> <td>  Austrilia</td></tr>");
				pw.println("</table>");

				//set response header "refresh" value
				 res.setHeader("refresh","10");

				pw.println("<br><br><h1> Date and Time ::"+new java.util.Date()+"</h1>");
			   //close the stream 
			   pw.close();
	}

}



