package com.nt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.nt.beans.Employee;

public class EmployeeDAOImpl implements IEmployeeDAO {
	private static final String GET_EMPS_BY_DESGS="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE JOB =? ORDER BY SAL";
	
	public Connection makeConnection() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Vishal");
		return con;
	}
	

	@Override
	public List<Employee> searchEmployeeByDesg(String desg) throws Exception {
		List<Employee> list=null;
		try(Connection con=makeConnection();
				PreparedStatement ps=con.prepareStatement(GET_EMPS_BY_DESGS);) {
			ps.setString(1, desg);
			try(ResultSet rs=ps.executeQuery()) {
				list=new ArrayList();
				while(rs.next()) {
					Employee emp = new Employee();
					emp.setEmpNo(rs.getInt(1));
					emp.setEmpName(rs.getString(2));
					emp.setDesg(rs.getString(3));
					emp.setSalary(rs.getDouble(4));
					list.add(emp);
				}
			}
		}
		catch (SQLException se) {
			throw se;
		}
		catch (Exception e) {
			throw e;
		}
				
		return list;
	}
}
