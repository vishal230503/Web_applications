package com.nt.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/empdburl")
public class EmployeeSearchServlet extends HttpServlet {
	private static final String GET_EMP_DETAILS_BY_NO ="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE EMPNO=?";
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try(PrintWriter pw=res.getWriter();
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe","TEST","Test");
					PreparedStatement ps=con.prepareStatement(GET_EMP_DETAILS_BY_NO);
				) {
				int no=Integer.parseInt(req.getParameter("eno"));
				ps.setInt(1, no);
				
				try(ResultSet rs=ps.executeQuery()) {
					if(rs.next()) {
						pw.println("<table border='1' align='center' bgcolor='cyan'>");
						pw.println("<tr><th>empno</th><th>ename</th><th>job</th><th>salary</th><th>deptno</th></tr>");
						pw.println("<tr><td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getFloat(4)+"</td><td>"+rs.getInt(5)+"</td></tr>");
						pw.println("<table>");
					}
					else {
						pw.println("<h1 style='color:red;text-align:center'>Employee not found </h1>");
					}
					
					pw.println("<h1 style='color:red;text-align:center'><a href='input.html'>home</a></h1>");
				}
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
