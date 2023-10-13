package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
//	import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LinksServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		String p1Val=req.getParameter("p1");
		Locale locale[]=Locale.getAvailableLocales();
		
		if(p1Val.equalsIgnoreCase("link1")) {
			pw.println("<b>all countries are</b></br>");
			Set<String> countriesSet=new TreeSet<>();
			for(Locale l:locale) {
				countriesSet.add(l.getDisplayCountry());
			}
			pw.println(countriesSet.toString()+"......count:: "+countriesSet.size());
		}
		else if(p1Val.equalsIgnoreCase("link2")) {
			pw.println("<b>all languages are</b></br>");
			Set<String> languagesSet=new TreeSet<>();
			for(Locale l:locale) {
				languagesSet.add(l.getDisplayLanguage());
			}
			pw.println(languagesSet.toString()+"....count:: "+languagesSet.size());
		}
		else {
			LocalDate ld=LocalDate.now();
			int month=ld.getMonthValue();
			if(month>=3 && month<=6) {
				pw.println("<h1 style='color:red;text-align:center'>Summer Season</h1>");
			}
			else if(month>=7 && month<=10) {
				pw.println("<h1 style='color:blue;text-align:center'>Rainy Season</h1>");
			}
			else {
				pw.println("<h1 style='color:green;text-align:center'>Winter Season</h1>");
			}
		}
		pw.println("<br><a href='links.html'>home</a>");
		
		pw.close();
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
	
}
