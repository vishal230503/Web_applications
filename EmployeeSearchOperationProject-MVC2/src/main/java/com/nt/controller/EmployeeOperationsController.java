package com.nt.controller;

import java.io.IOException;
import java.util.List;

import com.nt.beans.Employee;
import com.nt.service.EmployeeMgmtServiceImpl;
import com.nt.service.IEmployeeMgmtServiceImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/controller")
public class EmployeeOperationsController extends HttpServlet {
	private IEmployeeMgmtServiceImpl empService;
	
	public void inti() {
		empService=new EmployeeMgmtServiceImpl();

	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String desg=req.getParameter("desg");
		String action=req.getParameter("sourse");
		
		try {
			List<Employee> list=empService.fetchEmployeesByDesg(desg);
			req.setAttribute("empInfo", list);
			String target=null;
			
			if(action.equalsIgnoreCase("html")) {
				target="/html_screen.jsp";
			}
			else {
				target="/excel_screen.jsp";
			}
			
			RequestDispatcher rd=req.getRequestDispatcher(target);
			rd.forward(req, res);
		} catch (Exception e) {
			RequestDispatcher rd=req.getRequestDispatcher("/error.jsp");
			rd.forward(req, res);
		}
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
