package com.nt.service;

import java.util.List;

import com.nt.beans.Employee;

public interface IEmployeeMgmtServiceImpl {
	public List<Employee> fetchEmployeesByDesg(String desg) throws Exception;
}
