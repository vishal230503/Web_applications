package com.nt.beans;

import java.io.Serializable;

public class Employee implements Serializable {
	private int empNo;
	private String empName;
	private String empAddrs;
	private float empSalary;
	private float grossSalary;
	private float netSalary;
	public Employee() {
		System.out.println("Employee:: 0-param constructor");
	}
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpAddrs() {
		return empAddrs;
	}
	public void setEmpAddrs(String empAddrs) {
		this.empAddrs = empAddrs;
	}
	public float getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(float empSalary) {
		this.empSalary = empSalary;
	}
	public float getGrossSalary() {
		return grossSalary;
	}
	public void setGrossSalary(float grossSalary) {
		this.grossSalary = grossSalary;
	}
	public float getNetSalary() {
		return netSalary;
	}
	public void setNetSalary(float netSalary) {
		this.netSalary = netSalary;
	}
	
}
