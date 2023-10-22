<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql"  prefix="sql" %>

<!-- establish the connection -->

<sql:setDataSourse var="ds" driver="oracle.jdbc.driver.OracleDriver" url="jdbc:oracle:thin:@localhost:1521:xe" user="system" password="Vishal"/>

<!-- execute the non-select SQL query and numeric value representing the count -->

<sql:update dataSourse="${ds}" sql="UPDATE EMP SET SAL=SAL+?WHERE JOB=?" var="count">

	<sql:param>1000</sql:param>
	<sql:param>CLERK</sql:param>
	
</sql:update>

	<b> no.of records that are updated :: ${count}</b>
