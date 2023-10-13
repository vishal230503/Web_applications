//XmlServlet.java
package com.nt.servlet;

import  jakarta.servlet.*;
import  jakarta.servlet.http.*;
import  java.io.*;

public   class  XmlServlet extends HttpServlet{
	
	static {
		System.out.println("XmlServlet::static block");
	}
	
	public XmlServlet() {
		System.out.println("XmlServlet:: 0-param constructor)");
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		 System.out.println("XmlServlet: init(-) ");
		}

    //2nd  service(-,-) method overriding
	protected void service(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException{
		System.out.println("XmlServlet.service()");
             //set response content type
			   res.setContentType("text/xml");
			   //get PrintWriter stream
			   PrintWriter pw=res.getWriter();
			   //display the content as db table
			   pw.println("<table align='center' border='1'  bgcolor='cyan'>");
			   pw.println("<tr><th>TeamName </th>  <th> year </th> <th> place </th></tr>");
                pw.println("<tr><td>  India </td>  <td> 2007 </td> <td> South Africa </td></tr>");
			    pw.println("<tr><td>  Pakistan </td>  <td> 2009 </td>   <td> England</td></tr>");
    			 pw.println("<tr><td>  England </td>  <td> 2010 </td> <td> WestIndies  </td></tr>");
			    pw.println("<tr><td>  WestWindies </td>  <td> 2012 </td> <td>  Austrilia</td></tr>");
				pw.println("</table>");
			   //close the stream 
			   pw.close();
	}

}



