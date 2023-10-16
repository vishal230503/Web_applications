package com.nt.service;

import java.util.List;

import com.nt.beans.Employee;
import com.nt.dao.EmployeeDAOImpl;
import com.nt.dao.IEmployeeDAO;

public class EmployeeMgmtServiceImpl implements IEmployeeMgmtServiceImpl{
	private IEmployeeDAO empDao;
	
	public EmployeeMgmtServiceImpl() {
		empDao=new EmployeeDAOImpl();
	}

	@Override
	public List<Employee> fetchEmployeesByDesg(String desg) throws Exception {
		List<Employee> list=empDao.searchEmployeeByDesg(desg);
		list.forEach(emp->{
			double grossSalary=emp.getSalary() + emp.getSalary()*3.0f;
			double netSalary=grossSalary-(-grossSalary*0.1);
			emp.setGrossSalary(grossSalary); emp.setNetSalary(netSalary);
		});
		return list;
	}
}
