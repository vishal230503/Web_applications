

<%@ page isELIgnored="false" %>
<%@ page import="com.nt.service.*,com.nt.beans.*" %>

<!-- Read from data and write it to java bean class object -->
<jsp:useBean id="emp" class="com.nt.beans.Employee" scope="request"/>

<jsp:setProperty property="*"  name="emp"/>

<!-- create service class object -->
<jsp:useBean id="service" class="com.nt.service.PayslipGeneratorService" scope="application"/>

<%
	service.generatePaySlip(emp);
%>

<!-- call getter methods on java bean class obj to display the result -->
<h1> The Employee Payment details are </h1>
employee id :: <jsp:getProperty property="empNo" name="emp"/><br>
employee name :: <jsp:getProperty property="empName" name="emp"/><br>
employee salary :: <jsp:getProperty property="empSalary" name="emp"/><br>
employee addrs :: <jsp:getProperty property="empAddrs" name="emp"/><br>
employee grossSalary :: <jsp:getProperty property="grossSalary" name="emp"/><br>
employee netSalary :: <jsp:getProperty property="netSalary" name="emp"/><br>

<br><br>

<a href="employee_register.html"> home </a>