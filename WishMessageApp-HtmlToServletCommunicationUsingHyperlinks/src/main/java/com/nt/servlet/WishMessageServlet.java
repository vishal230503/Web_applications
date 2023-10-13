//WishMessageServlet.java
package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class WishMessageServlet extends HttpServlet {
	
	   //2nd service (-,-) / protected service(-,-) is overridden
	  public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		  //get PrintWriter from res obj pointing to res object
		   PrintWriter pw=res.getWriter();
		   //set response  content type
		   res.setContentType("text/html");
		   //  write b.logic to generate the wish message
		              //get System date and time
		               LocalDateTime ldt=LocalDateTime.now();
		               //get the current hour of the day
		               int hour=ldt.getHour();
		         //generate the wish Message
		                 String  msg=null;
		                if(hour<12)
		                	  msg="Good Morning";
		                else if(hour<16) 
		                	msg="Good AfterNoon";
		                else if(hour<20)
		                	msg="Good Evening";
		                else
		                	msg="Good Night";
			      //Display the generted WishMessage
		                pw.println("<h1 style='color:green;text-align:center'>"+msg+"</h1>");
		           //add home hyperlink
		                pw.println("<br><a href='page.html'>home</a>");
		          //close streams
		               pw.close();
	  }//serivce(-,-)


}//class
