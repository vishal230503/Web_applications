package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/registerurl")
public class RegistrationServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		String name=req.getParameter("sname");
		String addrs=req.getParameter("sadd");
		String gender=req.getParameter("gender");
		String ms=req.getParameter("ms");
		String qlfy=req.getParameter("qlfy");
		long contactNo=Long.parseLong(req.getParameter("contactNo"));
		String email=req.getParameter("email");
		String hobies[]=req.getParameterValues("hb");
		String favColors[]=req.getParameterValues("favColors");
		String petName=req.getParameter("petName");
		String dob=req.getParameter("dob");
		String tob=req.getParameter("tob");
		String monthInfo=req.getParameter("month");
		String weekInfo=req.getParameter("week");
		String fbUrl=req.getParameter("fbUrl");
		String scolor=req.getParameter("scolor");
		String ss=req.getParameter("ss");
		int favNo=Integer.parseInt(req.getParameter("favNo"));
		long expSalary=Long.parseLong(req.getParameter("salrange"));
		
		pw.println("<b> name:: "+name+"</b></br>");
		pw.println("<b> addrs:: "+addrs+"</b></br>");
		pw.println("<b> gender:: "+gender+"</b></br>");
		pw.println("<b> marital Status:: "+ms+"</b></br>");
		pw.println("<b> Qualification:: "+qlfy+"</b></br>");
		pw.println("<b> Contact No:: "+contactNo+"</b></br>");
		pw.println("<b> email:: "+email+"</b></br>");
		pw.println("<b> hobbies:: "+Arrays.toString(hobies)+"</b></br>");
		pw.println("<b> favColors:: "+Arrays.toString(favColors)+"</b></br>");
		pw.println("<b> DOB:: "+dob+"</b></br>");
		pw.println("<b> TOB:: "+tob+"</b></br>");
		pw.println("<b> petName:: "+petName+"</b></br>");
		pw.println("<b> Month info:: "+monthInfo+"</b></br>");
		pw.println("<b> Week Info:: "+weekInfo+"</b></br>");
		pw.println("<b> FB Url:: "+fbUrl+"</b></br>");
		pw.println("<b> Sentiment Color:: "+scolor+"</b></br>");
		pw.println("<b> Search String:: "+ss+"</b></br>");
		pw.println("<b> Salary:: "+expSalary+"</b></br>");
		pw.println("<b> Favorite Number:: "+favNo+"</b></br>");
	
		pw.println("<br><a href='student_registration.html'>home</a>");
		
		pw.close();
		
		
	}
	
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
	
}
