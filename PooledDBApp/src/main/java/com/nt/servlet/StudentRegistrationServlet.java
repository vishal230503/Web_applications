package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/poolurl")
public class StudentRegistrationServlet extends  HttpServlet {
	
	
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		//set response content type
		res.setContentType("text/html");
		//read form data
		String name=req.getParameter("sname");
		String addrs=req.getParameter("sadd");
		float avg=Float.parseFloat(req.getParameter("avg"));
		//get Context param value using SErvletContext object
		 ServletContext  sc=getServletContext();
		 String jndiName=sc.getInitParameter("jndi");
		//write jdbc code
		try(
				PrintWriter pw=res.getWriter();
				Connection con=getPooledConnection(jndiName);
				PreparedStatement ps=con.prepareStatement("INSERT INTO STUDENT VALUES(SNO_SEQ.NEXTVAL,?,?,?)");
				){
			   //set values to Query params
			    ps.setString(1, name);
			    ps.setString(2, addrs);
			    ps.setFloat(3, avg);
			    
			    //execute the Query
			    int result=ps.executeUpdate();
			    
			    //process the result
			    if(result==1)
			    	pw.println("<h1 style='color:red;text-align:center'> Student is registered </h1>");
			    else
			     	pw.println("<h1 style='color:red;text-align:center'> Student is not registered </h1>");
			    
			    //add home hyperlink
			    pw.println("<br><br> <a href='input.html'>home </a>");
		    }//try
	       catch(SQLException se) {
	    	   se.printStackTrace();
	       }
		   catch(Exception e) {
			   e.printStackTrace();
		   }
			   
		}//doGet(-,-)
	
	// private methods are helper methods for other public methods of the same class
	private   Connection  getPooledConnection(String jndi)throws Exception{
		// create InitialContext object
		 InitialContext ic=new InitialContext();
		 //get  DataSource obj using jndi lookup operation
		 DataSource  ds=(DataSource)ic.lookup(jndi);
		 //get Pooled jdbc con object
		 Connection con=ds.getConnection();
		 return con;
		 
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    doGet(req, res);	
	}

}
