<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql"  prefix="sql" %>

<!-- establish the connection -->

<sql:setDataSource var="ds" driver="oracle.jdbc.driver.OracleDriver" url="jdbc:oracle:thin:@localhost:1521:xe" user="system" password="Vishal"/>

<!-- execute the select SQL query and get ResultSet object -->
<sql:query var="rs" sql="SELECT EMPNO,ENAME,JOB,SAL FROM EMP" dataSourse="${ds}"/>

<!-- Process the ResultSet object -->
<c:forEach var="row" items="${rs.rows}">
	${row.EMPNO } &nbsp;&nbsp;   ${row.ENAME }  &nbsp;&nbsp;  ${row.JOB }  &nbsp;  ${row.SAL }  <br>
	</c:forEach>