//VotingElgibilityCheckServlet.java
package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class VotingElgibilityCheckServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("VotingElgibilityCheckServlet:doGet(-,-)");
		//get PrintWriter object
		PrintWriter pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		
		//read form data (req param values)
		String name=req.getParameter("pname");
		String addrs=req.getParameter("paddrs");
		String tage=req.getParameter("page");
		int age=0;
		//int age=Integer.parseInt(tage);
		 // read  hidden box value  to  know wheather client side form validations are done or not
		String vstatus=req.getParameter("vflag");
		System.out.println("VotingElgibilityCheckServlet:: vflag::"+vstatus);
		
	if(vstatus.equalsIgnoreCase("no")) {
		
		List<String>  errorsList=new ArrayList();
		System.out.println("VotingElgibilityCheckServlet:: server side form validations");
		// form validation logic  (server side)
		 if(name==null || name.equalsIgnoreCase("") || name.length()==0) {   // required rule  on name
			 errorsList.add("Person name is required");
		 }
		 else if(name.length()<3 || name.length()>10){   // min length rule  on  name
			 errorsList.add("Person name must have min of 3 chars and  max of 15 chars");
		 }
		 
		 if(tage==null ||  tage.length()==0 || tage.equalsIgnoreCase("") ) {   // required rule on age
			 errorsList.add("Person age is required");
		 }
		 else {
			  try {
				  age=Integer.parseInt(tage);
				    if(age<1 || age>100) {
				    	errorsList.add("Person age must be throguh 1  and 100");  //range rule on age
				    }
			  }
			  catch(NumberFormatException nfe) {
				  errorsList.add("Person age must be a numeric value");  //numeric value on age
			  }
		 }
		 
		 //display the form validatiions error messages
		 if(errorsList.size()>0) {
			 errorsList.forEach(msg->{
				 pw.println("<br><li style='color:red'>"+msg+"</li>");
			 });
			 
			 return;   //To stop the controlling to next b.logic execution (if form validation errors are there)
			 
		 }//if
	}
	else {
		age=Integer.parseInt(tage);
	}
			 
		
		//write b.logic
		if(age>=18) {
			pw.println("<h1 style='color:green;text-align:center'>"+name+" u r  elgible for voting </h1>");
		}
		else {
			pw.println("<h1 style='color:red;text-align:center'>"+name+" u r not elgible for voting </h1>");
		}
		//add home as the graphical hyperlink
		pw.println("<br><br><a href='input.html'><img src='images/home.jfif' width='50' height='50'> </a>");
		
		//close the stream
		pw.close();
		
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	  doGet(req,res);
	}
	
	
	
	

}//class
