package com.nt.service;

import com.nt.beans.Employee;

public class PayslipGeneratorService {
	
	public void generatePaySlip(Employee emp) {
		
		float grossSalary=emp.getEmpSalary()+emp.getEmpSalary()*0.5f;
		float netSalary=grossSalary-(grossSalary*2.0f);
		
		emp.setGrossSalary(grossSalary);
		emp.setNetSalary(netSalary);
	}
	
}
